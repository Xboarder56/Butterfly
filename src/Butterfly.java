/**
 * Butterfly.java
 * @author Garrett J. Beasley
 * 11/01/2014
 * Butterfly class for making Butterfly GCompound
 */

/** Imports for the project */
import java.awt.Color;
import acm.graphics.GCompound;
import acm.graphics.*;

public class Butterfly extends GCompound
{
	/**Init of variables*/
	private int startX; private int startY; private Color wingColor;
	public static final int bodyTop = 50; 	public static final int bodyBottom = 40; 
	public static final int offSetBottom = 10; 	public static final int offSetTop = 15;
	public static final int bodyMiddleX = 30; int bodyMiddleY = bodyTop + bodyBottom + offSetBottom;
	public static final int locationX =0; 	public static final int locationY = 0;
	
	public Butterfly(Color color)
	{
		/**helper classes changes from input to another variable accessible by the program*/
		startX=locationX;
		startY=locationY;
		wingColor = color;
		
		/**Calls the butterfly method createButterfly*/
		createButterfly();
	}
	
	/**createButterfly Method where it makes the butterfly for the gcompound*/
	public void createButterfly()
	{
		/**Creates all the govals used to make the butter fly based off the set location startX/start Y*/
		GOval bodyTopLeft = new GOval(startX,startY,bodyTop,bodyTop);
		GOval bodyTopRight = new GOval(startX+bodyTop,startY,bodyTop,bodyTop);
		GOval bodyBottomLeft = new GOval(startX+offSetBottom,startY+bodyBottom,bodyBottom,bodyBottom);
		GOval bodyBottomRight = new GOval(startX+bodyBottom+offSetBottom,startY+bodyBottom,bodyBottom,bodyBottom);
		GOval bodyMiddle = new GOval(startX+bodyBottom-(offSetBottom/2),startY-offSetTop,bodyMiddleX,bodyMiddleY);
		
		/**Sets the color to the color that is passed into the program except for the body*/
		bodyTopLeft.setFillColor(wingColor);
		bodyTopRight.setFillColor(wingColor);
		bodyBottomLeft.setFillColor(wingColor);
		bodyBottomRight.setFillColor(wingColor);
		bodyMiddle.setFillColor(Color.BLACK);
		
		/**Sets the objects to filled true*/
		bodyTopLeft.setFilled(true);
		bodyTopRight.setFilled(true);
		bodyBottomLeft.setFilled(true);
		bodyBottomRight.setFilled(true);
		bodyMiddle.setFilled(true);
		
		/**Adds the objects to the gcompound*/
		add(bodyTopLeft);
		add(bodyTopRight);
		add(bodyBottomLeft);
		add(bodyBottomRight);
		add(bodyMiddle);
	}
	
}