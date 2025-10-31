package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameWindow extends JPanel implements Runnable {

    Thread gameThread;
    SpaceRaceGame game; // connects game logic
    KeyHandler keyH = new KeyHandler();

    int FPS = 60;

    public GameWindow(int screenWidth, int screenHeight) {
        // Set window size and background
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // better rendering
        this.addKeyListener(keyH);
        this.setFocusable(true);

        game = new SpaceRaceGame(); // initialize game logic
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Game loop
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();  // update player and game objects
                repaint(); // draw everything
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        // move player using keys
        if (keyH.upPressed) {
            game.player1.moveUp();
        }
        if (keyH.downPressed) {
            game.player1.y += game.player1.speed; // move down
        }
        // could add left/right if needed

        // update computer and asteroids
        game.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // draw player rocket
        g2.setColor(Color.white);
        g2.fillRect(game.player1.x, game.player1.y, game.player1.width, game.player1.height);

        // draw computer rocket
        g2.setColor(Color.red);
        g2.fillRect(game.player2.x, game.player2.y, game.player2.width, game.player2.height);

        // draw asteroids
        g2.setColor(Color.gray);
        for (int i = 0; i < game.asteroids.size(); i++) {
            Asteroid a = game.asteroids.get(i);
            g2.fillRect(a.x, a.y, a.width, a.height);
        }

        g2.dispose();
    }
}