import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class


/**
 * <p>Create a cable car in a graphics window</p>  
 * @author Mahonri Gibson
 */

public class CableCar {

	// Your instance fields go here
	private int x, y, startX, startY, width, height;
	private Rectangle body;
	private Rectangle[] windows;
	private Polygon hanger;
	private Line cable;
	private boolean isMovingRight;
	private double scale;
	private GWindow window;

	/**
	* Create a cable car at location (x,y) in the GWindow window.
	* @param x the x coordinate of the center of the cable car
	* @param y the y coordinate of the center of the cable car
	* @scale the factor that multiplies all default dimensions for this cable car
	* (e.g. if the default size is 80, the size of this cable car is
	* scale * 80)
	* @window the graphics window this cable car belongs to
	*/
	public CableCar(int x, int y, double scale, GWindow window) {
		// initialize the instance fields
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		this.isMovingRight = true;
		
		/** 
		 * Useful calculations for overall size and 
		 * top left corner of car 
		 */
		width = (int)(100 * scale);
		height = (int)(60 * scale);
		startX = x-(width/2);
		startY = y-(height/2);
		// The details of the drawing are in a private method
		Draw();
	}
	
	public void move(){
		if (isMovingRight){
			x = x + 4;
			y = y + 2;
			body.moveBy(4,  -2);
			windows[0].moveBy(4,  -2);
			windows[1].moveBy(4,  -2);
			windows[2].moveBy(4,  -2);
			hanger.moveBy(4,  -2);
			cable.moveBy(4, -2);
			if (x >= window.getWindowWidth()){
				isMovingRight = false;
			}
		} else {
			x = x - 4;
			y = y - 2;
			body.moveBy(-4,  2);
			windows[0].moveBy(-4,  2);
			windows[1].moveBy(-4,  2);
			windows[2].moveBy(-4,  2);
			hanger.moveBy(-4,  2);
			cable.moveBy(-4, 2);
			if (x <= 0){
				isMovingRight = true;
			}
		}
		
		
	}
	
	/**
	 * Draw all our pieces, divided up to 
	 * keep each function small
	 */
	private void Draw(){
		DrawBody();
		DrawWindows();
		DrawHangers();
		DrawCables();
	}

	/** Draw the body, using attributes calculated in constructor
	 *  default size will be 100px*60px 
	 */
	private void DrawBody() {
		body = new Rectangle(startX, startY, width, height, Color.lightGray, true);
		window.add(body);
	}
	
	/**
	 * Draw three windows across top of body
	 * each window will be a quarter of the width
	 * and half the height of the body
	 */
	private void DrawWindows(){
		windows = new Rectangle[3];
		int windowWidth = width / 4;
		int windowHeight = height / 2;
		int spacer = width / 3; // used for spacing windows out
		for (int i = 0; i < 3; i++){
			int windowX = startX + spacer*i + (int)(5*scale); 
			int windowY = startY + (int)(5*scale);
			windows[i] = new Rectangle(windowX, windowY, windowWidth, windowHeight, Color.white, true);
			window.add(windows[i]);
		}
	}
	
	/**
	 * The cable hanger will be a polygon shape
	 * stretching above the body
	 */
	private void DrawHangers(){
		int startPointX = startX + (width /2); // start in middle of car
		hanger = new Polygon(Color.gray, true);
		hanger.addPoint(startPointX, startY);
		hanger.addPoint(startPointX + (width/10), startY - (height/2));
		hanger.addPoint(startPointX - (width/10), startY - (height/2));
		hanger.addPoint(startPointX - (width/10), startY - (2*height/3));
		hanger.addPoint(startPointX + (width/5), startY - (2*height/3));
		hanger.addPoint(startPointX + (width/5), startY - (height/2));
		hanger.addPoint(startPointX + (width/10), startY);
		
		window.add(hanger);
		
		
	}
	
	/**
	 * a diagonal line stretching across screen, meeting up with point
	 */
	private void DrawCables(){
		int windowWidth = window.getWindowWidth();
		
		int hangerPointX = (startX + (width / 2)) - (width/10);
		int hangerPointY = startY - (height / 2);
		
		cable = new Line(hangerPointX-windowWidth, hangerPointY+(2*height), hangerPointX+windowWidth, hangerPointY-(2*height));
		window.add(cable);
	}
}