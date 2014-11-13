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
	
	/**Creates objects for global access throughout the class*/
	private GLabel scoringLabel;
	private int score;
	private Net net;
	
	/**Init method to call parts of the code before the winodw is loaded*/
	public void init()
	{
		/**Set the size of the applet*/
		setSize(WINDOW_X,WINDOW_Y);
		
		/**Set the color of the applet*/
		setBackground(Color.CYAN);
		
		/**Adds the key listern to watch for up and down keys being pressed*/
		addKeyListeners();
		
		/** add score label */
		scoringLabel = new GLabel("Score: 0", (WINDOW_X - SCORE_WIDTH) / 2, SCORE_HEIGHT);	
		scoringLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(scoringLabel);
	}
	
	/**Run method to start the other methods*/
	public void run()
	{
		/**Stops the applet from running right away until its clicked and then after will animate the applet*/
		waitForClick();
		animate();
	}
	
	public void animate()
	{
		
		// tell whether to end game
		boolean continueGame = true;
		
		/**Creates new net object based off the net class at the bottom of the screen.*/
		net = new Net(WINDOW_X-100,WINDOW_Y-350,Color.blue);
		
		/**Creates new butterfly based off the Butterfly compound with a yellow body color*/
		Butterfly butterfly = new Butterfly(Color.YELLOW);
		
		/**Sets the butterfly location randomly on the x side of the applet.*/
		butterfly.setLocation(BUTTERFLY_HEIGHT/2,(int) (Math.random( )*(WINDOW_Y-BUTTERFLY_HEIGHT)));
		
		/**Add the newly created objects to the applet*/
		add(net);
		add(butterfly);
		
		/**while loop to end game or start game*/
		while(continueGame)
		{
			/**Moves the butterfly but pauses the loop because its way to fast!*/
			butterfly.move(4, 0);
			pause(15);
			
			/**Checks the butterfly to see if it has passed the right side of the applet*/
			if(butterfly.getX() + butterfly.getWidth() >= WINDOW_X+BUTTERFLY_HEIGHT)
			{
				/**Moves the butterfly back to the start when it passes the edge of the screen*/
				butterfly.setLocation(butterfly.getWidth(),(int) (Math.random( )*(WINDOW_Y-BUTTERFLY_HEIGHT)));
			
			}
			
			/** Collision detection between two objects */
			/**Creates the bounds into a variable for the program to compare to*/
			GRectangle netBox = net.getBounds();
			GRectangle butterflyBox = butterfly.getBounds();
				
			/**compares the butterfly bounds to the net bounds and if it equals enter*/
			if (butterflyBox.intersects(netBox))
				{
					/**Move the butter fly back to the start*/
					butterfly.setLocation(butterfly.getWidth(),(int) (Math.random( )*(WINDOW_Y-BUTTERFLY_HEIGHT)));
					
					/**+1 to the player and update the score board based on the method playerScored*/
					playerScored();
				}
		
		}
	}
	
	
	
	/**keypressed method called from the top in the init*/
	public void keyPressed(KeyEvent event)
	{
		/**Checks to see if the key pressed = the up key if it does enter the if statement*/
		if (event.getKeyCode() == KeyEvent.VK_UP) 
		{
			/**Moves the net up forward when the up key is pressed*/
			net.move(0,-40);
			

		}
		/**Checks to see if the key pressed = the down key if it does enter the if statement*/
		if (event.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			/**Moves the net down when the down key is pressed*/
			net.move(0,40);
		}
	}
	
	
	
	/**playerScored method will be called when the butterfly intersects with the net.*/
	public void playerScored() 
	{
		/**increment to score*/
		score++;
		
		/**display new score on screen*/
		scoringLabel.setLabel("Score: " + score);
	}

}
