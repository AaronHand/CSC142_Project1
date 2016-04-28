import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>Create a mountain for background imagery</p>  
 * @author Mahonri Gibson
 */

public class MountainBackDrop {
	
	/**
	 * Internal attributes
	 */
	private int x, y;
	private double scale;
	private GWindow window;
	
	/**
	 * 
	 * @param x 
	 * @param y  - top point of mountain
	 * @param scale
	 * @param window
	 */
	public MountainBackDrop(int x, int y, double scale, GWindow window) {
		/**
		 * Initialize internal attributes
		 */
		
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.window = window;
		
		/**
		 * Draw the mountain
		 */
		Draw();
	}
	
	/**
	 * The mountain will be drawn with a combination of a few shapes
	 * Triangle for main peak, 4 sided polygon for body of mountain,
	 * and several smaller triangles for snow fields
	 * default size 200px * 400px
	 */
	private void Draw(){
		
		// size of the overall mountain
		int width = (int)(200 * scale);
		int height = (int)(400 * scale);
		
		// white mountain peak
		Triangle peak = new Triangle(x, y, x-(width/10), y+(height/5), x+(width/10), y+(height/5), Color.white, true);
		window.add(peak);
		
		// gray mountain body
		Polygon body = new Polygon(Color.gray, true);
		body.addPoint(x-(width/10), y+(height/5));
		body.addPoint(x+(width/10), y+(height/5));
		body.addPoint(x+(width/2), y+height);
		body.addPoint(x-(width/2), y+height);
		window.add(body);
		
		// gray mountain body
		Polygon bodyOutline = new Polygon(Color.black, false);
		bodyOutline.addPoint(x-(width/10), y+(height/5));
		bodyOutline.addPoint(x+(width/10), y+(height/5));
		bodyOutline.addPoint(x+(width/2), y+height);
		bodyOutline.addPoint(x-(width/2), y+height);
		window.add(bodyOutline);
		
		int smallWidth = width/14;
		for (int i=0; i<3; i++){
			int x1 = x-(width/10) + (smallWidth*i);
			int y1 = y+(height/5);
			
			int x2 = x-(width/10) + (smallWidth*i) + (smallWidth/2);
			int y2 = y+(height/4);
			
			int x3 = x-(width/10) + (smallWidth*i) + (smallWidth);
			int y3 = y+(height/5);
			Triangle snow = new Triangle(x1, y1, x2, y2, x3, y3, Color.white, true);
			window.add(snow);
		}
	}

}
