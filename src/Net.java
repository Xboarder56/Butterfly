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
	int netStartX; int netStartY; private Color handleColor;
	int squareDim = 10; int netSize =10; 
	int handleX = 25; int handleY = 300;
	
	public Net(int locationX,int locationY, Color color)
	{
		netStartX=locationX;
		netStartY=locationY;
		handleColor = color;
		createNet();
	}
	
	public void createNet()
	{
		
		GRect netHandle = new GRect(netStartX-(handleX-squareDim), netStartY+squareDim, handleX,handleY);
		netHandle.setFillColor(handleColor);
		netHandle.setFilled(true);
		add(netHandle);
		
		
		for (int i = 1; i <=netSize ; i++) 
		{
			int y = i * squareDim + netStartY;
			
			for (int j = 1; j <= netSize; j++) 
			{
				GRect net = new GRect(10 * j+netStartX, y, squareDim, squareDim);
				add(net);
			}
		}
	}
}