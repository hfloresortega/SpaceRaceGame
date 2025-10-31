/**
* Lead Author(s):
* @author Hassel Flores Ortega
* @author Ivan

* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* Version: 2025-10-30
*/
package main;
import java.awt.Rectangle;


public class RocketShip
{
	// position of rocket
	int x;
	int y;
	
	// size of rocket
	int width = 40;
	int height = 60;
	
	// rocket speed
	int speed = 5;
	
	// starting position of rocket
	public RocketShip(int x, int y)
	{
		this.x = x;
		this.y = y;		
	}

	public void moveUp()  // moves rocket up
	{
		y = y - speed;
		
	}
	
	public void resetPosition(int newY) // resets rocket to y position
	{
		y = newY;
	}
	
	public Rectangle getBounds() // for collision detection 
	{
		return new Rectangle (x,y,width,height);
	}
	public int getY()
	{
		return y;
	}
	
}
