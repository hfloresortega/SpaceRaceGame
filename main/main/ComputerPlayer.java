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
* Version: 2025-10-31
*/
package main;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ComputerPlayer extends RocketShip
{
	private int direction = -1; // -1 means moving up, +1 means moving down

    // constructor
    public ComputerPlayer(GameWindow gw)
	{
		this.gw = gw;

		setDefaultValues();
		getPlayerImage();
	}

  //Get player image
  	public void getPlayerImage() {
  		try 
  		{
  			rocket = ImageIO.read(getClass().getResourceAsStream("/rocket/RocketBot.png"));
  		} 
  		catch(IOException e) 
  		{
  			e.printStackTrace();
  		}
  		catch(Exception e)
  		{
  			System.out.println("Error loading rocket image"); // catches any other excceptions while
  			e.printStackTrace();							// loading rocketbot image
  		}
  	}
    
    // makes the computer rocket move automatically
  	 public void autoMove() 
  	 {
         try
         {
             y = y + (speed * direction);

             // change direction if rocket hits top or bottom of screen
             if (y <= 0) 
             {
                 direction = 1; // move down
             } else if (y >= 500)
             {
                 direction = -1; // move up
             }
         } 
         catch (Exception e) // catches errors that may occur during the automove
         {
             e.printStackTrace();
         }
     }
 // starting position of rocket change x coordinate
    @Override
	public void setDefaultValues() {
		x = 500;
		y = 500;
		speed = 1;
		directionFolder = "rocket";
	}
    
    public void update() {
    	directionFolder = "rocket";
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

  
    
}