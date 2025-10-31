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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow {

    public MenuWindow() {
        JFrame menuFrame = new JFrame("Space Race Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(300, 200);
        menuFrame.setResizable(false);
        menuFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton startButton = new JButton("Start Game");

        // when button is clicked, open the game window
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close menu
                menuFrame.dispose();

                // Open game window
                JFrame window = new JFrame();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setResizable(false);
                window.setTitle("Space Race Game");

                Window gameWindow = new Window(720, 780);
                window.add(gameWindow);
                window.pack();
                window.setLocationRelativeTo(null);
                window.setVisible(true);

                gameWindow.startGameThread();
            }
        });

        panel.add(startButton);
        menuFrame.add(panel);
        menuFrame.setVisible(true);
    }
}
