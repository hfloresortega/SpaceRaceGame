
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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPressed, downPressed, leftPressed, rightPressed; // indicates which buttons are being pressed by player
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) { // called when a key is pressed 
		
		try {
		int code = e.getKeyCode();
		
		//movement controls 
		if (code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;
		}
	} 	
		catch(Exception b) // catches unexpected errors when player presses a key
		{
			b.printStackTrace();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		// stops movement of rocket when a key is released
		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}

}
