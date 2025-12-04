/**
* Lead Author(s):
* @author Hassel Flores Ortega
* @author Ivan Fesiunov
* 
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*

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
	
	//Animation variable
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	//Store to image data
	//First asteroid
	public BufferedImage asteroid1;
	public BufferedImage asteroid2;
	public BufferedImage asteroid3;
	public BufferedImage asteroid4;
	public BufferedImage asteroid5;
	public BufferedImage asteroid6;
	//Second asteroid
	public BufferedImage asteroidSmoll1;
	public BufferedImage asteroidSmoll2;
	public BufferedImage asteroidSmoll3;
	public BufferedImage asteroidSmoll4;
	public BufferedImage asteroidSmoll5;
	
	//Folder picture
	public String directionFolder;
	
	// size of asteroid
	int sizeWidth = 25;
	int sizeHeight = 20;
	
	// speed of asteroid
	int speed = 1;
	
	Random random = new Random(); //makes asteroids appear randomly
	
	public Asteroid(GameWindow gw, int x, int y, int variantAsteroid) // constructor to set position of asteroid
	{
		this.gw = gw;
		this.x = x; 
		this.y = y;
		
		//initializes images and folders
		try {
		setDefaultValues(variantAsteroid);
		}
		catch(Exception e)
		{
			e.printStackTrace(); // catches unexpected errors during initialization 
		}
	}
	
	//Get asteroid image
		public void getPlayerImage(int number) {
			
				if (number == 1) {
					try {
						//Variant asteroids
						asteroid1 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Anim1.png"));
						asteroid2 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Anim2.png"));
						asteroid3 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Anim3.png"));
						asteroid4 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Anim4.png"));
						asteroid5 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Anim5.png"));
						asteroid6 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Anim6.png"));
					} catch(IOException e) { // catches IO exceptions 
						e.printStackTrace();
					}
					
				}
				else if (number == 2) {
					try {
						//Variant asteroids
						asteroidSmoll1 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Smoll1.png"));
						asteroidSmoll2 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Smoll2.png"));
						asteroidSmoll3 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Smoll3.png"));
						asteroidSmoll4 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Smoll4.png"));
						asteroidSmoll5 = ImageIO.read(getClass().getResourceAsStream("/asteroid/Asteroid_Smoll5.png"));
					} catch(IOException e) { // catches IO exceptions 
						e.printStackTrace();
					}
				}
		}
				
		
	
	// starting position of rocket
	public void setDefaultValues(int variantAsteroid) {
		directionFolder = "asteroid";
		getPlayerImage(variantAsteroid);
	}
		
	public void moveRandomly() // asteroid moves to left and resets when it leaves screen
	{
		try {
		x = x - speed;
		}
		catch(Exception e) {
			e.printStackTrace(); // catches unexpected errors in movement of asteroids 
		}
	
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
	
	
	//Update asteroid
	public void update() {
		//Update animation sprite 
		directionFolder = "asteroid";
		spriteCounter++;
		//Change > 10 on other for make speed animation
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 3;
			}
			else if(spriteNum == 3) {
				spriteNum = 4;
			}
			else if(spriteNum == 4) {
				spriteNum = 5;
			}
			else if(spriteNum == 5) {
				spriteNum = 6;
			}
			else if(spriteNum == 6)
			spriteNum = 1;
			spriteCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		 // draw asteroids
		BufferedImage image = null;
		BufferedImage image2 = null;
		
		switch(directionFolder) {
		
		case "asteroid":
			//Update sprite asteroid
			if(spriteNum == 1) {
				image = asteroid1;
				image2 = asteroidSmoll1;
			}
			if(spriteNum == 2) {
				image = asteroid2;
				image2 = asteroidSmoll2;
			}

			if(spriteNum == 3) {
				image = asteroid3;
				image2 = asteroidSmoll3;
			}

			if(spriteNum == 4) {
				image = asteroid4;
				image2 = asteroidSmoll4;
			}

			if(spriteNum == 5) {
				image = asteroid5;
				image2 = asteroidSmoll5;
			}

			if(spriteNum == 6) {
				image = asteroid6;
				image2 = asteroidSmoll1;
			}
			break;
		}
		
		try {
			//Draw asteroid Small
			g2.drawImage(image2, x, y, sizeWidth, sizeHeight, null);
			//Draw asteroid default
			g2.drawImage(image, x, y, sizeWidth, sizeHeight, null);	
		}
		catch(Exception e)
		{
			e.printStackTrace(); // catches errors if image doesnt load correctly 
		}
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	