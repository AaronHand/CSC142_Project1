import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class
import snowman.*;

/**
 * <p>
 * A MountainScene displays snow men, trees (with ornaments), a cable car and a
 * fourth element of your choice in a graphics window
 * </p>
 * Add a line to declare an instance field of type the new type that you defined
 * in hw1, then complete the method addGraphicsElements. Leave all the rest of
 * the code unchanged.
 * 
 * @author Your name here
 */

public class MountainScene extends GWindowEventAdapter {
	/** The graphics window that displays the picture */
	private GWindow window;

	/** The elements in the picture */
	// 2 snowmen that move their arms and hats
	private Snowman snowMan1, snowMan2;
	// 3 trees that flash their ornaments
	private Tree tree1, tree2, tree3;
	// A cable car that moves back and forth across the window
	private CableCar cableCar;
	// A mountain goat that moves its legs
	private MountainGoat myElement;

	// To keep track of the duration of the animation
	private int animationCounter;

	/**
	 * Create a picture
	 */
	public MountainScene() {
		// The graphics window
		this.window = new GWindow("Mountain scene");
		this.window.setExitOnClose();

		// paint the background
		Rectangle bgnd = new Rectangle(0, 0, this.window.getWindowWidth(),
				this.window.getWindowHeight(), Color.cyan, true);
		this.window.add(bgnd);
		this.window.doRepaint();

		// Add the graphics elements
		this.addGraphicsElements();

		// Code to do the animation
		this.window.addEventHandler(this);
		this.window.startTimerEvents(150);
	}

	// To do the animation
	public void timerExpired(GWindowEvent we) {
		this.window.suspendRepaints();
		this.snowMan1.moveArmsAndHat();
//		this.snowMan2.moveArmsAndHat();
//		this.tree1.flashOrnaments();
//		this.tree2.flashOrnaments();
//		this.tree3.flashOrnaments();
//		this.cableCar.move();
		this.myElement.moveLegs();
		this.window.resumeRepaints();

		// Run the animation 100 times (about 15 s)
		this.animationCounter++;
		if (this.animationCounter >= 100)
			this.window.stopTimerEvents();
	}

	/**
	 * Entry point of the program
	 */
	public static void main(String[] args) {
		new MountainScene();
	}

	/**
	 * Instantiate in this method the elements of the scene. This is the only
	 * method that you need to modify in this class
	 */
	private void addGraphicsElements() {
		// You can change the coordinates and scales that appear
//		// in the constructors (but don't change the names of the variables)
//		this.tree3 = new Tree(300, 100, 0.6, this.window);
//		this.cableCar = new CableCar(350, 100, 1, this.window);
//		this.tree1 = new Tree(200, 120, 0.8, this.window);
//		this.tree2 = new Tree(250, 250, 1.2, this.window);
		this.snowMan1 = new Snowman(100, 200, 1, this.window);
//		this.snowMan2 = new Snowman(400, 150, 0.7, this.window);
		this.myElement = new MountainGoat(300, 200, 0.5, this.window);
	}
}