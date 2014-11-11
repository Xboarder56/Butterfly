/**
 * MAIN.java
 * @author Garrett J. Beasley
 * 11/01/2014
 * Main class for lunching Butterfly and Net
 */

/** Imports for the project */
import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Main extends GraphicsProgram
{
	
	/**Constant Window Size*/
	public static final int WINDOW_X = 1000;
	public static final int WINDOW_Y = 1000;
	public static final int BUTTERFLY_HEIGHT = 100;
	
	
	Net NET = new Net(WINDOW_X-150,WINDOW_Y-350,Color.blue);
	
	public void init()
	{
		/**Set the size of the applet*/
		setSize(WINDOW_X,WINDOW_Y);
		
		addKeyListeners();
	}
	
	public void run()
	{
		waitForClick();
		animate();
	
		
	}
	
	public void animate()
	{
		
		Butterfly butterfly = new Butterfly(Color.YELLOW);
		butterfly.setLocation(BUTTERFLY_HEIGHT/2,(int) (Math.random( )*(WINDOW_Y-BUTTERFLY_HEIGHT)));
		add(NET);
		add(butterfly);
		
		while(true)
		{
			butterfly.move(4, 0);
			pause(15);
			
			if(butterfly.getX() + butterfly.getWidth() >= WINDOW_X+BUTTERFLY_HEIGHT)
			{
				butterfly.setLocation(butterfly.getWidth(),(int) (Math.random( )*(WINDOW_Y-BUTTERFLY_HEIGHT)));
			
			}
		
		}
	}
	
	public void keyPressed(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.VK_UP) 
		{
			NET.move(0,-40);
		}
		
		if (event.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			NET.move(0,40);
		}
	}

}
