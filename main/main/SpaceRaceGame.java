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
* Version: 2025-10-27
*/

package main;

import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SpaceRaceGame {
    Timer timer;

   

    //ArrayList<Asteroid> asteroids;

    boolean isRunning = true; 

    public SpaceRaceGame() {

        //Create window ...
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Space Race Game");
        //Initialize rockets and create window
        GameWindow gameWindow = new GameWindow(720, 780);
        window.add(gameWindow);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gameWindow.startGameThread();
        //....
        
        

        // timer
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        timer.start();
    }

    // starts game
    public void startGame() {
        isRunning = true;
    }

    // updates game
    public void update() {
        if (isRunning == true) {
            // move computer rocket
            //player2.autoMove();

           
        }
    }

    
    
//    // ends game and shows winner
//    public void endGame() {
//        isRunning = false;
//
//        String winner = "";
//        if (scorePlayer1 > scorePlayer2) {
//            winner = "Player 1 Wins :D";
//        } else if (scorePlayer2 > scorePlayer1) {
//            winner = "Computer Wins :(";
//        } else {
//            winner = "It's a Tie :O";
//        }
//
//        JOptionPane.showMessageDialog(null, winner);
//    }
//
//    // resets game
//    public void resetGame() {
//        scorePlayer1 = 0;
//        scorePlayer2 = 0;
//        player1.resetPosition(500);
//        player2.resetPosition(500);
//        startGame();
//    }
}