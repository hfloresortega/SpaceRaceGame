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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow {

    public MenuWindow() {
        // creates the menu frame
        JFrame menuFrame = new JFrame("Space Race Game");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(720, 780);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null); // center on screen

        // creates a panel to hold the button
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        // creates a Start Game button
        JButton startButton = new JButton("Start Game");
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // adds button to panel
        panel.add(startButton, gbc);

        // adds panel to frame
        menuFrame.add(panel);

        // make the menu visible
        menuFrame.setVisible(true);

        // action when the start button is clicked
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
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
                
            	} catch (Exception b) // catches exceptions when starting game
            	{
            		b.printStackTrace();
            	}
            }
        });
    }
    
    public void GateClose() {
    	
    }
}