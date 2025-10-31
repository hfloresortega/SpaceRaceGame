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

import java.awt.Rectangle;
import java.util.Random;

public class Asteroid
{
	// asteroid position
	int x;
	int y;
	
	// size of asteroid
	int width = 40;
	int height = 40;
	
	// speed of asteroid
	int speed = 4;
	
	Random random = new Random(); //makes asteroids appear randomly
	
	public Asteroid(int x, int y) // constructor to set position of asteroid
	{
		this.x = x; 
		this.y = y;
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
		return new Rectangle(x, y, width, height);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	