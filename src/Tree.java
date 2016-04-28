import uwcse.graphics.*; // access the graphics utilities in the uw library
import java.awt.Color; // access the Color class

/**
 * <p>Create a tree with ornaments in a graphics window</p>
 * @author Serge Kalinin
 */

public class Tree {

  // Instance fields
  // The graphics window this tree belongs to
  private GWindow window;
  // The location of this tree
  // (precisely (as done in the draw method), (x,y) is
  // the upper left corner of the tree trunk)
  private int x;
  private int y;
  // The scale used to draw this tree
  private double scale;

  /**
   * Create a tree
   * @param x the x coordinate of the tree location (upper left corner of the tree trunk)
   * @param y the y coordinate of the tree location
   * @param window the graphics window this Tree belongs to
   * @param scale the scale of the drawing (all default dimensions are multiplied
   * by scale)
   */
  public Tree(int x, int y, double scale, GWindow window)
  {
    // Initialize the instance fields (the use of this is required
    // since the instance fields have the same name as the
    // parameters of the constructor)
    this.window = window;
    this.scale = scale;
    this.x = x;
    this.y = y;

    // the details of the drawing are in written in the private method draw()
    this.draw();
  }

  /**
   * draw a pine tree
   */
  private void draw()
  {

    // This is necessary since the Rectangle constructor takes integers
    Rectangle trunk = new Rectangle(this.x,this.y,(int)(20*this.scale),(int)(60*this.scale),
            Color.black,true);
    // Foliage (improve the drawing!)
    // a green triangle
    Triangle foliage = new Triangle(this.x-(int)(45*this.scale),this.y+(int)(45*this.scale),
            this.x+(int)(10*this.scale),this.y-(int)(10*this.scale),
            this.x+(int)(65*this.scale),this.y+(int)(45*this.scale),
            Color.green,true);
    Triangle foliage2 = new Triangle(this.x-(int)(35*this.scale),this.y+(int)(15*this.scale),
            this.x+(int)(10*this.scale),this.y-(int)(30*this.scale),
            this.x+(int)(55*this.scale),this.y+(int)(15*this.scale),
            Color.green,true);
    Triangle foliage3 = new Triangle(this.x-(int)(25*this.scale),this.y-(int)(15*this.scale),
            this.x+(int)(10*this.scale),this.y-(int)(50*this.scale),
            this.x+(int)(45*this.scale),this.y-(int)(15*this.scale),
            Color.green,true);

    //Ornaments
    int ornament = (int) (5 * this.scale);
    Oval blueornament = new Oval(this.x -(int)(10*this.scale), this.y - (int)(10*this.scale),
            2 * ornament, 2 * ornament, Color.blue, true);
    Oval yellowornament = new Oval(this.x +(int)(10*this.scale), this.y - (int)(20*this.scale),
            2 * ornament, 2 * ornament, Color.yellow, true);
    Oval orangeornament = new Oval(this.x -(int)(5*this.scale), this.y + (int)(25*this.scale),
            2 * ornament, 2 * ornament, Color.orange, true);
    Oval redornament = new Oval(this.x +(int)(15*this.scale), this.y + (int)(5*this.scale),
            2 * ornament, 2 * ornament, Color.red, true);

    this.window.add(trunk);
    this.window.add(foliage);
    this.window.add(foliage2);
    this.window.add(foliage3);
    this.window.add(blueornament);
    this.window.add(yellowornament);
    this.window.add(orangeornament);
    this.window.add(redornament);

    // Improve the drawing of the foliage and add the ornaments...
  }
}