package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Window extends JPanel implements Runnable {
	
	//Test 
	Thread gameThread;
	SpaceRaceGame game; // connects game class
	final int PlayerSize = 60;
	
	public Window(int screenWidth, int screenHeight) {
		
		//Create window 
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		//Better rendering performance
		this.setDoubleBuffered(true);
		
		game = new SpaceRaceGame(); // initializes game logic
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//GameLoop
	@Override
	public void run() {
		while(gameThread != null) {
			//System.out.println("The game loop is running");
			
			//1 Update: update information such as player position
			game.update();
			
			//2 Draw: draw the screen with the update information
			repaint();
		}
		
	}
	
	public void update() {
		game.update(); // updates game logic
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(100, 100, PlayerSize, PlayerSize);
		
		g2.dispose();
	}
	
}
