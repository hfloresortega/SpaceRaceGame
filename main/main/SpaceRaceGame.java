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
    Timer timer; // timer to update game

    boolean isRunning = true; 

    public SpaceRaceGame() {

        // create window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Space Race Game"); 

        // timer
        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try
               {
            	   update(); //updates game 
               }
               catch (Exception b) // catches any potential errors during updates
               {
            	   System.out.println("Oops, something went wrong: " + b.getMessage());
               }
                
            }
        });
        timer.start(); // starts timer
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

}