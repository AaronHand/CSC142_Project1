import java.awt.Color;

import uwcse.graphics.GWindow;
import uwcse.graphics.Polygon;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Triangle;

/**
 * @author huiyingcao
 *
 * A MountainGoat with moving legs that can be added to a GWindow.
 */
public class MountainGoat {
	
	private int x;
	private int y;
	private double scale;
	private GWindow window;
	
	private Polygon leftLeg;
	private int leftLegX;
	private int leftLegY;
	
	private Polygon rightLeg;
	private int rightLegX;
	private int rightLegY;
	
	private boolean goingForward;
	
	/**
	 * @param x 
	 *     top left x coordinate of the body
	 * @param y 
	 *     top left y coordinate of the body
	 * @param scale 
	 *     scale factor for the x and y coordinates
	 * @param window 
	 *     window for the graphic 
	 */
	public MountainGoat(int x, int y, double scale, GWindow window) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.goingForward = true;
		this.drawGoat();
	}

	/**
	 * Draw the goat.
	 */
	private void drawGoat() {
		int size = (int) (50 * this.scale);
		Rectangle body = new Rectangle(this.x, 
										this.y, 
										2 * size, 
										size, 
										Color.white,
										true);
		
		// Add the body to the window
		this.window.add(body);
		
		// Make the head
		this.drawHead(this.x, this.y - 10);
		
		// Make the legs
		this.drawLeftLeg(this.x, this.y + size);
		this.drawRightLeg(this.x + 2*size - (int) (10 * this.scale), this.y + size);
		
		// Make the tail
		this.drawTail(this.x + 2*size, this.y);
	}
	
	/**
	 * 
	 * Draw a head at the given position
	 * 
	 * @param x 
	 *     The x coordinate of the top right corner
	 * @param y
	 *     The y coordinate of the top right corner
	 */
	private void drawHead(int x, int y) {
		int size = (int) (22 * this.scale);
		Rectangle head = new Rectangle(x - 2*size, y, 2 * size, size, Color.white, true);
		this.window.add(head);
		
		//Make the horns
		this.drawHorns(x, y);
	}
	
	/**
	 * 
	 * Draw a horn at the given position
	 * 
	 * @param x
	 * 	   The x coordinate of the bottom right corner
	 * @param y 
	 *     The y coordinate of the bottom right corner
	 */
	private void drawHorns(int x, int y) {
		int size = (int) (10 * this.scale);
		Triangle horns = new Triangle(x, y,  x - size, y, x, y - 3*size, Color.black, true);
		this.window.add(horns);
	}
	
	/**
	 * Draws the right leg as a four point polygon
	 * @param x
	 * @param y
	 */
	private void drawRightLeg(int x, int y) {
		int size = (int) (10 * this.scale);
		rightLeg = new Polygon(Color.white, true);
		rightLegX = x;
		rightLegY = y;
		rightLeg.addPoint(x, y);
		rightLeg.addPoint(x + size, y);
		rightLeg.addPoint(x + size, y + 3 * size);
		rightLeg.addPoint(x, y + 3 * size);
		this.window.add(rightLeg);
	}
	
	/**
	 * Draws the left leg as a four point polygon
	 * @param x
	 * @param y
	 */
	private void drawLeftLeg(int x, int y) {
		int size = (int) (10 * this.scale);
		leftLeg = new Polygon(Color.white, true);
		leftLegX = x;
		leftLegY = y;
		leftLeg.addPoint(x, y);
		leftLeg.addPoint(x + size, y);
		leftLeg.addPoint(x + size, y + 3 * size);
		leftLeg.addPoint(x, y + 3 * size);
		this.window.add(leftLeg);
	}
	
	/**
	 * 
	 * Draw a tail at the given position
	 * 
	 * @param x
	 *     The x coordinate of the top left corner
	 * @param y
	 *     The y coordinate of the top left corner
	 */
	private void drawTail(int x, int y) {
		int size = (int) (10 * this.scale);
		Rectangle tail = new Rectangle(x, y, 2*size, size, Color.white, true);
		this.window.add(tail);
	}

	/**
	 * This method moves the legs
	 */
	public void moveLegs() {
		if (goingForward) {
			rightLeg.rotateAround(rightLegX, rightLegY, 30);
			leftLeg.rotateAround(leftLegX, leftLegY, -30);
			goingForward = false;
		} else {
			rightLeg.rotateAround(rightLegX, rightLegY, -30);
			leftLeg.rotateAround(leftLegX, leftLegY, 30);
			goingForward = true;
		
		}	
		
	}
}
