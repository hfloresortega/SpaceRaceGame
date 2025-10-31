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

public class ComputerPlayer extends RocketShip
{
	private int direction = -1; // -1 means moving up, +1 means moving down

    // constructor
    public ComputerPlayer(int x, int y)
    {
        super(x, y); // calls RocketShip constructor
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
    
    @Override
    // for collision detection
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }

    @Override
    // reset rocket position to specific y
    public void resetPosition(int newY)
    {
        y = newY;
    }

    
    
    
    
    
    
    
    
    
    
    
}