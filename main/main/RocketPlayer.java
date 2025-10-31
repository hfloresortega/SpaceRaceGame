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
* Version: 2025-10-31
*/
package main;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RocketPlayer extends RocketShip
{ 
	GameWindow gw;
	KeyHandler keyH;
	
    // set starting position using RocketShip's constructor
	public RocketPlayer(GameWindow gw, KeyHandler keyH)
	{
		this.gw = gw;
		this.keyH = keyH;		
		setDefaultValues();
		getPlayerImage();
	}
	// starting position of rocket
	@Override
	public void setDefaultValues() {
		x = 100;
		y = 500;
		speed = 1;
		directionFolder = "rocket";
	}
	
	//Get player image
	public void getPlayerImage() {
		try {
			rocket = ImageIO.read(getClass().getResourceAsStream("/rocket/Rocket.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() {
		 // move player using keys and update sprite
       if (keyH.upPressed) {
    	   directionFolder = "rocket";
           moveUp();
       }
       else if (keyH.downPressed) {
    	   directionFolder = "rocket";
           y += speed; // move down
       }
       else if (keyH.leftPressed) {
    	   directionFolder = "rocket";
       	x -= speed;
       }
       else if (keyH.rightPressed) {
    	   directionFolder = "rocket";
       	x += speed;
       }
       // could add left/right if needed
	}
	@Override
	public void draw(Graphics2D g2) {
		   // draw player rocket
		BufferedImage image = null;
		
		switch(directionFolder) {
		case "rocket":
			image = rocket;
			break;
		}
		
		g2.drawImage(image, x, y, sizeWidth, sizeHeight, null);
	}
	
	//Don't need because have in parent class RocketShip
//    @Override
//    // for collision detection
//    public Rectangle getBounds() {
//        return new Rectangle(x, y, sizeWidth, sizeHeight);
//    }

	//Don't need because have in parent class RocketShip
//    @Override
//    // resets player to a y position
//    public void resetPosition(int newY) {
//        y = newY;
//    }

  
}