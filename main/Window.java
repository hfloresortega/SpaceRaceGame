package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Window extends JPanel implements Runnable {

    Thread gameThread;
    SpaceRaceGame game; // links to game logic
    int FPS = 60; // target frames per second

    public Window(int screenWidth, int screenHeight) {
        // Set up window
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // better rendering

        game = new SpaceRaceGame(); // initialize game logic
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS; // nanoseconds per frame
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
                // update game and repaint
                game.update();
                repaint();
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Draw player rocket
        g2.setColor(Color.WHITE);
        g2.fillRect(game.player1.x, game.player1.y, game.player1.width, game.player1.height);

        // Draw computer rocket
        g2.setColor(Color.RED);
        g2.fillRect(game.player2.x, game.player2.y, game.player2.width, game.player2.height);

        // Draw asteroids
        g2.setColor(Color.GRAY);
        for (int i = 0; i < game.asteroids.size(); i++) {
            Asteroid a = game.asteroids.get(i);
            g2.fillRect(a.x, a.y, a.width, a.height);
        }

        g2.dispose();
    }
}
