/**
 * Net.java
 * @author Garrett J. Beasley
 * 11/01/2014
 * Net class for making Net GCompound
 */

/** Imports for the project */
import java.awt.Color;
import acm.graphics.*;


public class Net extends GCompound
{
	/**Init of variables*/
	private int netStartX; private int netStartY; private Color handleColor;
	public static final int squareDim = 10; public static final int netSize =10; 
	public static final int handleX = 25; public static final int handleY = 300;
	
	public Net(int locationX,int locationY, Color color)
	{
		/**helper classes changes from input to another variable accessible by the program*/
		netStartX=locationX;
		netStartY=locationY;
		handleColor = color;
		
		/**Calls the butterfly method createButterfly*/
		createNet();
	}
	
	/**createNet Method where it makes the net for the gcompound*/
	public void createNet()
	{
		/**Creates all the grect used to make the nethandle based off the set location startX/start Y*/
		GRect netHandle = new GRect(netStartX-(handleX-squareDim), netStartY+squareDim, handleX,handleY);
		
		/**Sets the color to the color that is passed into the program except for the body*/
		netHandle.setFillColor(handleColor);
		
		/**Sets the objects to filled true*/
		netHandle.setFilled(true);
		
		/**Adds the objects to the gcompound*/
		add(netHandle);
		
		
		for (int i = 1; i <=netSize ; i++) 
		{
			int y = i * squareDim + netStartY;
			
			for (int j = 1; j <= netSize; j++) 
			{
				/**Creates all the grect used to make the net based off the set location startX/start Y*/
				GRect net = new GRect(10 * j+netStartX, y, squareDim, squareDim);
				
				/**Adds the objects to the gcompound*/
				add(net);
			}
		}
	}
}