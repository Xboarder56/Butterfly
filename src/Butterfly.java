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
	int startX; int startY; private Color wingColor;
	int bodyTop = 50; int bodyBottom = 40; int offSetBottom = 10; int offSetTop = 15;
	int bodyMiddleX = 30; int bodyMiddleY = bodyTop + bodyBottom + offSetBottom;
	int locationX =0; int locationY = 0;
	
	public Butterfly(Color color)
	{
		startX=locationX;
		startY=locationY;
		wingColor = color;
		createButterfly();
	}
	
	public void createButterfly()
	{
		GOval bodyTopLeft = new GOval(startX,startY,bodyTop,bodyTop);
		GOval bodyTopRight = new GOval(startX+bodyTop,startY,bodyTop,bodyTop);
		GOval bodyBottomLeft = new GOval(startX+offSetBottom,startY+bodyBottom,bodyBottom,bodyBottom);
		GOval bodyBottomRight = new GOval(startX+bodyBottom+offSetBottom,startY+bodyBottom,bodyBottom,bodyBottom);
		GOval bodyMiddle = new GOval(startX+bodyBottom-(offSetBottom/2),startY-offSetTop,bodyMiddleX,bodyMiddleY);
		
		bodyTopLeft.setFillColor(wingColor);
		bodyTopRight.setFillColor(wingColor);
		bodyBottomLeft.setFillColor(wingColor);
		bodyBottomRight.setFillColor(wingColor);
		bodyMiddle.setFillColor(Color.BLACK);
		
		bodyTopLeft.setFilled(true);
		bodyTopRight.setFilled(true);
		bodyBottomLeft.setFilled(true);
		bodyBottomRight.setFilled(true);
		bodyMiddle.setFilled(true);
		
		add(bodyTopLeft);
		add(bodyTopRight);
		add(bodyBottomLeft);
		add(bodyBottomRight);
		add(bodyMiddle);
	}
	
}