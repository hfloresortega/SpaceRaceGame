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

public class RocketPlayer extends RocketShip
{ 
    // set starting position using RocketShip's constructor
    public RocketPlayer(int x, int y)
    {
        super(x, y); // call parent constructor
    }

    @Override
    // for collision detection
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    // resets player to a y position
    public void resetPosition(int newY) {
        y = newY;
    }

  
}