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


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends Application{
	
	//JavaFX window 
	@Override
    public void start(Stage primaryStage) {
    	String videoPath = getClass().getResource("/video/Space_Star.mp4").toExternalForm();
    	Media media = new Media(videoPath);
    	MediaPlayer player = new MediaPlayer(media);
    	player.setCycleCount(MediaPlayer.INDEFINITE); //Loop video
    	player.setAutoPlay(true);
    	
    	MediaView mediaView = new MediaView(player);
    	
    	//Create button
    	Button startButton = new Button("Start Game");
    	
    	//Action button
    	startButton.setOnAction(e -> { 
    		primaryStage.close();
    		MenuWindow();
    		
    	});
    	
    	VBox controls = new VBox(10, startButton);
    	controls.setStyle("-fx-alignment: center;");
    	
    	
    	// StackPane: first video, after button
    	StackPane root = new StackPane();
    	root.getChildren().addAll(mediaView, controls);
    	
    	Scene scene = new Scene(root, 720, 780);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Space Race Game");
    	primaryStage.show();
    }
	
    private void MenuWindow() {
    	
    	SwingUtilities.invokeLater(() -> {
    		try {
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
    	});
    }
    
    public static void main(String[] args) {
    	launch(args);
    }
    
    
}