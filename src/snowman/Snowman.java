package snowman;

/**
 * Created by Aaron Hand on 4/18/16.
 * Project: Project1
 *
 * Draws a snowman given it's location, scale, and window.
 *
 *
 */

import uwcse.graphics.*;
import uwcse.graphics.Rectangle;

import java.awt.*;
import java.util.Random;

public class Snowman {

    private Grid grid;
    private GWindow window;

    /**
     * @param x point
     * @param y point
     * @param scale factor (1 = 100px)
     * @param window to draw on
     */
    public Snowman(int x, int y, double scale, GWindow window){
        this.window = window;
        grid = new Grid(x,y,(int)(100 * scale)); //size of snowman (default 100 * scale)
        addTorso();
        addHead();
        addArms();
    }

    private void addHead(){

        /**
         * EYES
         */
        window.add(new Oval(
                grid.getX(2,2),
                grid.getY(2,2),
                grid.spanX(7),
                grid.spanY(7),
                Color.white,
                true
        ));

        window.add(new Oval(
                grid.getX(4,4),
                grid.getY(4,4),
                grid.spanX(1),
                grid.spanY(1),
                Color.black,
                true
        ));

        window.add(new Oval(
                grid.getX(6,4),
                grid.getY(6,4),
                grid.spanX(1),
                grid.spanY(1),
                Color.black,
                true
        ));

        /**
         * MOUTH
         */
        window.add(new Rectangle(
                grid.getX(4,7),
                grid.getY(4,7),
                grid.spanX(3),
                grid.spanY(1)/2,
                Color.black,
                true
        ));

        //left mouth
        window.add(new Rectangle(
                grid.getX(3,6),
                grid.getY(3,6),
                grid.spanX(1)/2,
                grid.spanY(1)/2,
                Color.black,
                true
        ));

        window.add(new Rectangle(
                grid.getX(3,7) + grid.spanX(1)/2,
                grid.getY(3,7) - grid.spanY(1)/2,
                grid.spanX(1)/2,
                grid.spanY(1)/2,
                Color.black,
                true
        ));

        //right mouth
        window.add(new Rectangle(
                grid.getX(8,6) - grid.spanX(1)/2,
                grid.getY(7,6),
                grid.spanX(1)/2,
                grid.spanY(1)/2,
                Color.black,
                true
        ));

        window.add(new Rectangle(
                grid.getX(7,7),
                grid.getY(7,7) - grid.spanY(1)/2,
                grid.spanX(1)/2,
                grid.spanY(1)/2,
                Color.black,
                true
        ));

        /**
         * NOSE
         */

        Random rand = new Random();
        window.add(new Triangle(
                grid.getX(5,5), grid.getY(5,5) + grid.spanY(1)/2, //point 1
                grid.getX(6,5),grid.getY(6,5) + grid.spanY(1)/2, //point 2
                grid.getX(rand.nextInt(7),9) + grid.spanX(1)/2,grid.getY(rand.nextInt(7),9),
                Color.orange,
                true
        ));


        /**
         * HAT
         */

        window.add(new Rectangle(
                grid.getX(2,2),
                grid.getY(2,2),
                grid.spanX(7),
                grid.spanX(1),
                Color.black,
                true
        ));

        window.add(new Rectangle(
                grid.getX(3,0),
                grid.getY(3,0),
                grid.spanX(5),
                grid.spanX(2),
                Color.black,
                true
        ));
    }

    /**
     * BODY
     */

    private void addTorso(){
        window.add(new Oval(
                grid.getX(0,8) - grid.spanX(1)/2,
                grid.getY(0,8),
                grid.spanX(12),
                grid.spanY(12),
                Color.white,
                true
        ));

        for(int i=0; i<3;i++){
            window.add(new Oval(
                    grid.getX(5,10),
                    grid.getY(6,10 + i * 2),
                    grid.spanX(1),
                    grid.spanY(1),
                    Color.black,
                    true
            ));
        }
    }

    /**
     * ARMS
     */

    private void addArms(){

        //left arm
        window.add(new Line(
                grid.getX(0,6) - grid.spanX(1),
                grid.getY(0,5),
                grid.getX(0,12),
                grid.getY(0,12),
                Color.black

        ));

        //left hand
        window.add(new Line(
                grid.getX(0,6) + grid.spanX(1),
                grid.getY(0,6),
                grid.getX(0,6) - grid.spanX(2),
                grid.getY(0,6) + grid.spanY(1)/2
        ));

        //right arm
        window.add(new Line(
                grid.getX(10,5) + grid.spanX(2),
                grid.getY(10,5) ,
                grid.getX(10,12) + grid.spanX(1),
                grid.getY(10,12),
                Color.black

        ));

        //right hand
        window.add(new Line(
                grid.getX(10,6),
                grid.getY(10,6),
                grid.getX(10,7) + grid.spanX(3),
                grid.getY(10,7)
        ));
    }
}
