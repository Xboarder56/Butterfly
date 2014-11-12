/**
 * MAIN.java
 * @author Garrett J. Beasley
 * 11/01/2014
 * Main class for lunching Butterfly and Net
 */

/** Imports for the project */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram
{
	
	/**Constant Window Size*/
	public static final int WINDOW_X = 1000;
	public static final int WINDOW_Y = 1000;
	public static final int BUTTERFLY_HEIGHT = 100;
	private static final int SCORE_HEIGHT = 25;
	private static final int SCORE_WIDTH = 80;
	private int x;
	
	private GLabel scoringLabel;
	private int score;
	Net net = new Net(WINDOW_X-150,WINDOW_Y-350,Color.blue);
	
	public void init()
	{
		/**Set the size of the applet*/
		setSize(WINDOW_X,WINDOW_Y);
		addKeyListeners();
		// add score label
				x = (WINDOW_X - SCORE_WIDTH) / 2;
				scoringLabel = new GLabel("Score: 0", x, SCORE_HEIGHT);
				
				scoringLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
				add(scoringLabel);
	}
	
	public void run()
	{
		waitForClick();
		animate();
	
		
	}
	
	public void animate()
	{
		
		// tell whether to end game
		boolean continueGame = true;
		
		Butterfly butterfly = new Butterfly(Color.YELLOW);
		butterfly.setLocation(BUTTERFLY_HEIGHT/2,(int) (Math.random( )*(WINDOW_Y-BUTTERFLY_HEIGHT)));
		add(net);
		add(butterfly);
		
		while(continueGame)
		{
			butterfly.move(4, 0);
			pause(15);
			
			if(butterfly.getX() + butterfly.getWidth() >= WINDOW_X+BUTTERFLY_HEIGHT)
			{
				butterfly.setLocation(butterfly.getWidth(),(int) (Math.random( )*(WINDOW_Y-BUTTERFLY_HEIGHT)));
			
			}
			
			// collision detection between two objects
			GRectangle netBox = net.getBounds();
			GRectangle butterflyBox = butterfly.getBounds();
				
			if (butterflyBox.intersects(netBox))
				{
					butterfly.setLocation(butterfly.getWidth(),(int) (Math.random( )*(WINDOW_Y-BUTTERFLY_HEIGHT)));
					playerScored();
				}
		
		}
	}
	
	public void keyPressed(KeyEvent event)
	{
		if (event.getKeyCode() == KeyEvent.VK_UP) 
		{
			net.move(0,-40);
			

		}
		
		if (event.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			net.move(0,40);
		}
	}
	
	public void playerScored() {
		// increment to score
		score++;
		
		// display new score on screen
		scoringLabel.setLabel("Score: " + score);
	}

}
