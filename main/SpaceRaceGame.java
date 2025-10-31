/**
* Lead Author(s):
* @author Hassel Flores Ortega
* @author Ivan 
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
import javax.swing.JOptionPane;

public class SpaceRaceGame {
    Timer timer;

    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    ArrayList<Asteroid> asteroids;
    RocketPlayer player1;
    ComputerPlayer player2;
    boolean isRunning = true; 

    public SpaceRaceGame() {
        // initialize rockets 
        player1 = new RocketPlayer(100, 500);
        player2 = new ComputerPlayer(200, 500);

        // initializes asteroids 
        asteroids = new ArrayList<>();
        asteroids.add(new Asteroid(300, 0));
        asteroids.add(new Asteroid(500, 0));
//
//        // timer
//        timer = new Timer(16, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                update();
//            }
//        });
//        timer.start();
    }

    // starts game
    public void startGame() {
        isRunning = true;
    }

//    // updates game
//    public void update() {
//        if (isRunning == true) {
//            // move computer rocket
//            player2.autoMove();
//
//            // move asteroids
//            for (int i = 0; i < asteroids.size(); i++) {
//                Asteroid a = asteroids.get(i);
//                a.moveRandomly();
//
//                // check collisions inside loop
//                if (a.getBounds().intersects(player1.getBounds())) {
//                    player1.resetPosition(500);
//                }
//                if (a.getBounds().intersects(player2.getBounds())) {
//                    player2.resetPosition(500);
//                }
//            }
//
//            // checks if rockets reached top
//            checkTop();
//        }
//    }

    // checks if rockets reached top of game window
    public void checkTop() {
        if (player1.getY() <= 0) {
            scorePlayer1 = scorePlayer1 + 1;
            player1.resetPosition(500);
        }

        if (player2.getY() <= 0) {
            scorePlayer2 = scorePlayer2 + 1;
            player2.resetPosition(500);
        }
    }
    
    // ends game and shows winner
    public void endGame() {
        isRunning = false;

        String winner = "";
        if (scorePlayer1 > scorePlayer2) {
            winner = "Player 1 Wins :D";
        } else if (scorePlayer2 > scorePlayer1) {
            winner = "Computer Wins :(";
        } else {
            winner = "It's a Tie :O";
        }

        JOptionPane.showMessageDialog(null, winner);
    }

    // resets game
    public void resetGame() {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        player1.resetPosition(500);
        player2.resetPosition(500);
        startGame();
    }
}