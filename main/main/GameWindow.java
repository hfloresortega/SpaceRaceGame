package main;

/**
* Lead Author(s):
* @author Hassel Flores Ortega
* @author Ivan Fesiunov
* 
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*

*
* Version: 2025-10-31
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameWindow extends JPanel implements Runnable {

    Thread gameThread;
    //SpaceRaceGame game; // connects game logic
    KeyHandler keyH = new KeyHandler();
    //Initialize Rocket 
    RocketPlayer player1 = new RocketPlayer(this, keyH);
    ComputerPlayer player2 = new ComputerPlayer(this);
    ArrayList<Asteroid> asteroids;
    // initializes asteroids 
    Asteroid asteroid = new Asteroid(this, 300, 0);
    //asteroids.add(new Asteroid(this, 300, 0));
    //asteroids.add(new Asteroid(this, 500, 0));
    
    
    //test
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    
    
    int FPS = 60;

    public GameWindow(int screenWidth, int screenHeight) {
        // Set window size and background
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // better rendering
        this.addKeyListener(keyH);
        this.setFocusable(true);

        //game = new SpaceRaceGame(); // initialize game logic
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

        //Update window in 60 FPS
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
    //Update system
    public void update() {
    	
	   //update player
    	player1.update();
    	
    	//update bot player
    	player2.update();
    	// move computer rocket
    	player2.autoMove();
        
    	asteroid.moveRandomly();
    	 // move asteroids
//        for (int i = 0; i < asteroids.size(); i++) {
//            Asteroid a = asteroids.get(i);
//            a.moveRandomly();
//
//            // check collisions inside loop
//            if (a.getBounds().intersects(player1.getBounds())) {
//                player1.resetPosition(500);
//            }
//            if (a.getBounds().intersects(player2.getBounds())) {
//                player2.resetPosition(500);
//            }
//        }

        // checks if rockets reached top
        //checkTop();
    	
    	asteroid.update();
    }
    
 // checks if rockets reached top of game window
//    public void checkTop() {
//        if (player1.getY() <= 0) {
//            scorePlayer1 = scorePlayer1 + 1;
//            player1.resetPosition(500);
//        }
//
//        if (player2.getY() <= 0) {
//            scorePlayer2 = scorePlayer2 + 1;
//            player2.resetPosition(500);
//        }
//    }
    
    //Paint system
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //draw player
        player1.draw(g2);

        // draw computer rocket
        player2.draw(g2);

        asteroid.draw(g2);

        g2.dispose();
    }
}