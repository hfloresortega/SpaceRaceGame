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
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.control.Label;
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
		//Video Background
    	String videoPath = getClass().getResource("/video/Space_Star.mp4").toExternalForm();
    	Media media = new Media(videoPath);
    	MediaPlayer player = new MediaPlayer(media);
    	player.setCycleCount(MediaPlayer.INDEFINITE); //Loop video
    	player.setAutoPlay(true);
    	
    	MediaView mediaView = new MediaView(player);
    	
    	//Create button
    	Button startButton = new Button("Start Game");
    	
    	//Video For Close Space Gate
    	String videoPathButtonAction = getClass().getResource("/video/SpaceGate.mp4").toExternalForm();
    	Media mediaGate = new Media(videoPathButtonAction);
    	MediaPlayer playerGate = new MediaPlayer(mediaGate);
    	MediaView mediaViewGate = new MediaView(playerGate);
    	
    	//Action button
    	startButton.setOnAction(e -> { 
    		//Create panel for Space Gate video
    		StackPane videoPane = new StackPane(mediaViewGate);
    		Scene videoScene = new Scene(videoPane, 720, 780);
    		primaryStage.setScene(videoScene);
    		
    		playerGate.play();
    		
    		playerGate.setOnEndOfMedia(() -> {
    			primaryStage.close();
    			MenuWindow();
    		});
    		
    	});
    	
    	//Button start
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
	//First window with start button 
    private void MenuWindow() {
    	
    	Stage newStage = new Stage();
    	
    	SwingNode swingNode = new SwingNode();
    	createSwingContent(swingNode);
    	//Create window
    	Scene secondScene = new Scene(new VBox(swingNode), 720, 780);
    	
    	//Add fix for close window on x (not button)
    	newStage.setOnCloseRequest(event -> {
    	    System.exit(0); // End JVM full
    	});
    	
    	newStage.setTitle("Space Race Game");
    	newStage.setScene(secondScene);
    	newStage.show();
    }
    //Transfer JLable to JavaFX and create GameWindow
    private void createSwingContent(SwingNode swingNode) {
    	SwingUtilities.invokeLater(() -> {
    		GameWindow gamePanel = new GameWindow(720, 780);
    		gamePanel.startGameThread();
    		swingNode.setContent(gamePanel);
    		
    	});
    }
    //Start Program
    public static void main(String[] args) {
    	launch(args);
    }
    
    
}