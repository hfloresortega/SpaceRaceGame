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
import java.awt.Font;

import javax.swing.JPanel;

public class GameWindow extends JPanel implements Runnable {

    Thread gameThread;
  
    KeyHandler keyH = new KeyHandler();
    
    //Initialize Rocket 
    RocketPlayer player1 = new RocketPlayer(this, keyH);
    ComputerPlayer player2 = new ComputerPlayer(this);
    
    // list that will hold all asteroid objects
    ArrayList<Asteroid> asteroids = new ArrayList<>();
    
    // initializes asteroids 
//    Asteroid asteroid = new Asteroid(this, 300, 0);
   
    
    //test
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    
    
    int FPS = 60; //frames per second
    
    Sound sound = new Sound();
    
    // timer variables
    long startTime;
    int elapsedTime = 0;
    
    boolean isRunning = true;
    boolean gameOver = false;  
    
    public GameWindow(int screenWidth, int screenHeight) {
        // Set window size and background
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // better rendering
        this.addKeyListener(keyH); // for keyboard input
        this.setFocusable(true); 
        
       // initialize timer
        startTime = System.currentTimeMillis();
      
        
        // each new asteroid is added to the list
        asteroids.add(new Asteroid(this, 300,0));
        asteroids.add(new Asteroid(this,500,200));
        asteroids.add(new Asteroid(this,100,400));
        asteroids.add(new Asteroid(this,700,150));
        asteroids.add(new Asteroid(this,400,200));
        asteroids.add(new Asteroid(this,600,100));
        asteroids.add(new Asteroid(this,100,200));
        asteroids.add(new Asteroid(this,700,50));
        asteroids.add(new Asteroid(this,900,300));
        asteroids.add(new Asteroid(this,50,200));
        asteroids.add(new Asteroid(this,500,20));
        
    }

    // starts game loop in new thread
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Game loop
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; // how long one frame should take
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        //Add Baground music
        playMusic(0);
        
        
        //Update window in 60 FPS
        while (gameThread != null) { // runs while the game is active
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) { // time to update/draw a frame
            	
            	try
            	{
                update(); // update player and game objects with exception handling
            	}	
            	catch (Exception e)
            	{
            		System.out.println("There was an error updating" + e.getMessage()); // catches runtime errors during updates
            		e.printStackTrace();
            	}
              try 
              {
            	  repaint(); // draw everything
              }
              catch (Exception e)
              {
            	  System.out.println("There was an error repainting" + e.getMessage());
              }
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) { // prints FPS to monitor performance
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    //Updates game objects and checks collisions
    public void update() {
       try {
           //update player movement based on input
           player1.update();
           
           //update bot player movement and automatic behavior
           player2.update();
           // move computer rocket
           player2.autoMove();
            
           // update asteroid positions
           for (Asteroid ast : asteroids) 
           {
               ast.moveRandomly(); // small random drifting movement
               ast.update(); // update position and bounding box
           }
           
           // checks if rockets reached top
           checkTop();
            
           // updates timer
           elapsedTime = (int)((System.currentTimeMillis() - startTime)/ 1000);
            
           // check collisions for both players
           for (Asteroid ast: asteroids )
           {
               // if player hits asteroid, reset position
               if (ast.getBounds().intersects(player1.getBounds()))
               {
                   player1.resetPosition(500);
               }
           
               // check collisions for computer player
               if (ast.getBounds().intersects(player2.getBounds())) {
                   player2.resetPosition(500);
               }
           }

           // automatically end game after 60 seconds
           if (elapsedTime >= 60 && gameOver == false) {
               gameOver = true;  //it only happens once
               showFinalWinner(); // display who won
           }

        }  
        catch (Exception e) // catches unexpceted runtime erros when updating game logic
        {
            System.out.println("There was an error while updating: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
 // checks if rockets reached top of game window
    public void checkTop() {
        // if a rocket reaches y <= 0, it scored
        if (player1.getY() <= 0) {
            scorePlayer1++;
            player1.resetPosition(500); // reset to starting area
        }

        if (player2.getY() <= 0) {
            scorePlayer2++;
            player2.resetPosition(500);
        }
    }
    
    //paint system
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //draw player
        player1.draw(g2);

        // draw computer rocket
        player2.draw(g2);

        // draw all asteroids
        for(Asteroid ast : asteroids)
        {
            ast.draw(g2);
        }
  
        // draw UI text such as scores and timer
        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString("Player 1 Score: " + scorePlayer1, 10, 20);
        g2.setColor(Color.BLUE);
        g2.drawString("Computer Score: " + scorePlayer2, 10, 40);

        g2.setColor(Color.YELLOW);
        g2.drawString("Time: " + elapsedTime + "s", 600, 20);
       
        g2.dispose();
    }
   
    // messages shown once a winner is decided
    public void showFinalWinner() {

        String winnerMessage = "";

        // determine which player scored more
        if (scorePlayer1 > scorePlayer2) {
            winnerMessage = "Player 1 Wins!\nScore: " + scorePlayer1 + " - " + scorePlayer2;
        } 
        else if (scorePlayer2 > scorePlayer1) {
            winnerMessage = "Computer Wins!\nScore: " + scorePlayer2 + " - " + scorePlayer1;
        } 
        else {
            winnerMessage = "It's a Tie!\nScore: " + scorePlayer1 + " - " + scorePlayer2;
        }

        // ask user if they want to play again
        int choice = javax.swing.JOptionPane.showConfirmDialog(this,
                winnerMessage + "\n\nPlay again?",
                "Game Over",
                javax.swing.JOptionPane.YES_NO_OPTION);

        // if yes, restart game values
        if (choice == javax.swing.JOptionPane.YES_OPTION) {
            restartGame();
        } 
        else {
            System.exit(0); // close game
        }
    }
    
    public void restartGame() {

        // reset scores
        scorePlayer1 = 0;
        scorePlayer2 = 0;

        // reset player positions
        player1.resetPosition(500);
        player2.resetPosition(500);

        // reset timer
        startTime = System.currentTimeMillis();
        elapsedTime = 0;

        // allow game loop to continue normally again
        gameOver = false;
    }

    //Play music class
    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    //Stop music class
    public void stopMusic() {
        sound.stop();
    }
    //Play sound effect else sound is short 
    public void playSoundEffect(int i) {
        sound.setFile(i);
        sound.play();
    }
     
}