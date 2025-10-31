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
  		try {
  			rocket = ImageIO.read(getClass().getResourceAsStream("/rocket/RocketBot.png"));
  		} catch(IOException e) {
  			e.printStackTrace();
  		}
  	}
    
    // makes the computer rocket move automatically
    public void autoMove()
    {
        y = y + (speed * direction);

        // if rocket reaches the top or bottom, switch direction
        if (y <= 0)
        {
            direction = 1; // start moving down
        }
        else if (y >= 500) // bottom of window 
        {
            direction = -1; // start moving up
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
    
  //Don't need because have in parent class RocketShip
//    @Override
//    // for collision detection
//    public Rectangle getBounds()
//    {
//        return new Rectangle(x, y, sizeWidth, sizeHeight);
//    }

  //Don't need because have in parent class RocketShip
//    @Override
//    // reset rocket position to specific y
//    public void resetPosition(int newY)
//    {
//        y = newY;
//    }

    
    
    
    
    
    
    
    
    
    
    
}