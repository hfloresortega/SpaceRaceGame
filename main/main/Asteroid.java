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
* Version: 2025-10-29
*/
package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Asteroid
{
	GameWindow gw;
	// asteroid position
	int x;
	int y;
	
	//Store to image data
	public BufferedImage asteroid1;
	public BufferedImage asteroid2;
	public BufferedImage asteroid3;
	//Folder picture
	public String directionFolder;
	
	// size of asteroid
	int sizeWidth = 25;
	int sizeHeight = 20;
	
	// speed of asteroid
	int speed = 1;
	
	Random random = new Random(); //makes asteroids appear randomly
	
	public Asteroid(GameWindow gw, int x, int y) // constructor to set position of asteroid
	{
		this.gw = gw;
		this.x = x; 
		this.y = y;
		setDefaultValues();
	}
	
	//Get asteroid image
		public void getPlayerImage() {
			try {
				//Variant asteroids
				asteroid1 = ImageIO.read(getClass().getResourceAsStream("/rocket/Asteroid.png"));
				asteroid2 = ImageIO.read(getClass().getResourceAsStream("/rocket/Asteroid1.png"));
				asteroid3 = ImageIO.read(getClass().getResourceAsStream("/rocket/Asteroid.png"));
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	// starting position of rocket
	public void setDefaultValues() {
		directionFolder = "asteroid1";
		getPlayerImage();
	}
		
	public void moveRandomly() // asteroid moves to left and resets when it leaves screen
	{
		x = x - speed;
	
	
	if (x < 0) // moves asteroid to right side randomly if asteroid goes to left
	{
		x = 800; // resets to rigt side of window
		y = random.nextInt(500);
	}
	
	}
	
	public Rectangle getBounds() // detects collison
	{
		return new Rectangle(x, y, sizeWidth, sizeHeight);
	}
	
	public void update() {
		directionFolder = "asteroid1";
	}
	
	public void draw(Graphics2D g2) {
		 // draw asteroids
		BufferedImage image = null;
		
		switch(directionFolder) {
		case "asteroid1":
			image = asteroid1;
			break;
		}
		
		g2.drawImage(image, x, y, sizeWidth, sizeHeight, null);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	