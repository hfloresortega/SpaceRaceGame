/**
* Lead Author(s):
* @author hasse; student ID
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2025-10-30
*/
package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow {

    public MenuWindow() {
        // creates the menu frame
        JFrame menuFrame = new JFrame("Space Race Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(300, 200);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null); // center on screen

        // creates a panel to hold the button
        JPanel panel = new JPanel();

        // creates a Start Game button
        JButton startButton = new JButton("Start Game");

        // adds button to panel
        panel.add(startButton);

        // adds panel to frame
        menuFrame.add(panel);

        // make the menu visible
        menuFrame.setVisible(true);

        // action when the start button is clicked
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // close the menu window
                menuFrame.dispose();

                // create the game window
                JFrame window = new JFrame("Space Race Game");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setResizable(false);

                // create and add the game panel
                GameWindow gameWindow = new GameWindow(720, 780);
                window.add(gameWindow);
                window.pack();
                window.setLocationRelativeTo(null); // center on screen
                window.setVisible(true);

                // start the game loop
                gameWindow.startGameThread();
            }
        });
    }
}