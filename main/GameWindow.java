package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GameWindow extends JPanel implements Runnable {
	
	//Test 
	final int PlayerSize = 60;
	Thread gameThread;
	SpaceRaceGame game; // connects game class
	
	KeyHandler keyH = new KeyHandler();
	
	//Set player's default position
	int playerX = 100; //Test position player
	int playerY = 100; //Test position player
	//Speed player on 4 pixel move
	int playerSpeed = 4; //Test speed player
		
	//FPS
	int FPS = 60;
	
	public GameWindow(int screenWidth, int screenHeight) {
		
		//Create window 
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		//Better rendering performance
		this.setDoubleBuffered(true);
		//Add system key listener for keyboard
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		game = new SpaceRaceGame(); // initializes game logic
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//Game loop
		public void run() {
			
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		//For FPS show
		long timer = 0;
		int drawCount = 0;
			
		while(gameThread != null) {
			currentTime = System.nanoTime();
				
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
				
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
				
			//FPS show
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	//Update system
	public void update() {
		//Update move player when you push button W, player up move
			if (keyH.upPressed == true) {
				playerY -= playerSpeed;
			}
			//Update move player when you push button S, player down move
			else if (keyH.downPressed == true) {
				playerY += playerSpeed;
			}
			//Update move player when you push button A, player left move
			else if (keyH.leftPressed == true) {
				playerX -= playerSpeed;
			}
			//Update move player when you push button D, player right move
			else if (keyH.rightPressed == true) {
				playerX += playerSpeed;
			}
		
	}
	//System for show graphics
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, PlayerSize, PlayerSize);
		
		g2.dispose();
	}
	
}
