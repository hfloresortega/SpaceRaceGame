package main;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		//Add default close button for close window 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Not Resizable window
		window.setResizable(false);
		//Create title for window
		window.setTitle("Space Race Game");
		
		//Create game window
		Window gameWindow = new Window(720, 780);
		//Add game window
		window.add(gameWindow);
		
		window.pack();
		
		//Window display center on the screen
		window.setLocationRelativeTo(null);
		//For see window
		window.setVisible(true);
		
		gameWindow.startGameThread();
	}
	
}
