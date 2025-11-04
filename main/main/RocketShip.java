/**
* Lead Author(s):
* @author Hassel Flores Ortega
* @author Ivan Fesiunov

* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* Version: 2025-10-31
*/
package main;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class RocketShip
{
	GameWindow gw;
	KeyHandler keyH;
	
	// position of rocket
	public int x;
	public int y;
	
	//Store to image data
	public BufferedImage rocket;
	//Folder picture
	public String directionFolder;
	
	// size of rocket
	int sizeWidth = 40;
	int sizeHeight = 60;
	
	// rocket speed
	int speed;
	
	// starting position of rocket
	public void setDefaultValues() {
		x = 100;
		y = 500;
		speed = 1;
	}

	
	
	public void moveUp()  // moves rocket up
	{
		try 
		{
		y = y - speed;
		}
		catch(Exception e)
		{
			e.printStackTrace(); // for debugging
		}
		
		
	}
	// updates method for rocket
	 public void update() {
	        try {
	            // no default behavior
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	public void draw(Graphics2D g2) {
		   // draw player rocket
        g2.setColor(Color.white);
        g2.fillRect(x, y, sizeWidth, sizeHeight);
	}
	
	public void resetPosition(int newY) // resets rocket to y position
	{
		y = newY;
	}
	
	public Rectangle getBounds() {
        try 
        {
          return new Rectangle(x, y, sizeWidth, sizeHeight);
        } catch (Exception e) 
        {
            e.printStackTrace();
            return null; // returns null if something goes wrong
        }
    }
	public int getY()
	{
		return y;
	}
	
}
