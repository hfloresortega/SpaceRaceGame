package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel implements Runnable{
	
	Thread gameThread;
	
	public Window(int screenWidth, int screenHeight) {
		
		
		
		
		//Create window 
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		//Better rendering performance
		this.setDoubleBuffered(true);
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//GameLoop
	@Override
	public void run() {
		
		
	}
	
	
}
