//==========================================================
// 
// Car.java              CS112
// 
// Author: Richard Yang         Email: yry@cs.yale.edu 
// 
// Class: Car
// 
// ---------------------------------------------------------
//   See SimpleStdDrawX.java for how to use StdDraw
//==========================================================
import java.awt.Color;

public class Cannon {
    // declare these as class variables because they
    // are needed by multiple methods
    final static int WIDTH = 600;
    final static int HEIGHT = 400;

    public static void main(String[] args) {

        setCanvasScale();
        drawBorder();

        /*drawCar(100, 100, 100);
        drawCar(300, 300, 200);
        drawCar(250, 180, 150);*/
        drawCannon(450, 160, 80);

    } // end of main
    public static void setCanvasScale() {
        // Change from the default of 512x512.
        StdDraw.setCanvasSize(WIDTH, HEIGHT);

        // Change scale from the default of [0 - 1.0].
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
    }

    public static void drawBorder() {
        StdDraw.rectangle(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
    }

    // assume body lower left corner is at (x0, y0)
    // body: 100% x 50% rect of size
    // window: 30% x 20% in the right, middle
    
    public static void drawCannon(double x0, double y0, int size) {
        
    	// Define the variables to avoid magic numbers
        // A more general version of drawCannon may make
        // some into method parameters
        final double CAN_WIDTH = 1.00, CAN_HEIGHT = 1.00;
        //final double WHEEL_MARGIN = 0.15, WHEEL_RADIUS = 0.10;
        final double WINDOW_WIDTH = 1.0, WINDOW_HEIGHT = 0.30;
        final double RADIUS = 0.25;
        
        // Cannon body
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledRectangle(x0 + size * CAN_WIDTH / 2, 
                                y0 + size * CAN_HEIGHT / 2, 
                                size * CAN_WIDTH / 2, 
                                size * CAN_HEIGHT / 2);


        // barrel
        StdDraw.setPenColor(Color.YELLOW);
        StdDraw.filledRectangle(x0 + size * (CAN_WIDTH - WINDOW_WIDTH / 2), 
                                y0 + size  * CAN_HEIGHT / 2, 
                                size * WINDOW_WIDTH / 2, 
                                size * WINDOW_HEIGHT / 2);
       
        StdDraw.setPenColor(Color.BLUE);
        //wheel base for cannon
        StdDraw.filledCircle(x0, y0, RADIUS*size);
        
        StdDraw.filledRectangle(x0 + size*(CAN_WIDTH), 
                                y0 + size*(CAN_WIDTH), size * WINDOW_WIDTH / 2, size * WINDOW_HEIGHT / 2);
    }
}
