//==========================================================
// 
// Animation.java      CS112
// 
// Author: P. Darius Vaillancourt            Email: phaelan.vaillancourt@yale.edu 
// 
// Class: Animation							Time spent: 5 hours
// 
// ---------------------------------------------------------
//   Races two images in the horizontal direction
//==========================================================

import java.awt.Color;

public class Animation {

    final static int WIDTH     = 600;
    final static int HEIGHT    = 600;
    final static int CAN_SIZE = 50;
    final static double cx = WIDTH/2; //center of clock
    final static double cy = HEIGHT/2; //center of clock
    final static double r = WIDTH/4; //radius of clock
    final static int n = 10; // total countdown time


    public static void main(String[] args) {

        setCanvasScale();
        
        int h1 = 400, v1x = 50, v1y = 40;
        int h2 = 300, v2x = 70, v2y = 60;

        // First, a count down scene
        sceneStart(h1, h2);

        // Then real launch
        sceneRace(h1, h2, v1x, v1y, v2x, v2y);

    } // end of main
   
    //draw the clock, note: n is the total count down time
    public static void drawClock(double cx, double cy, double r, double n, double t) {
    	
    	StdDraw.circle(cx, cy, r);
		
		// polar to Cartesian coordinates for clock arm length
		
    	double x = Math.cos(Math.toRadians((360*t/n))) * r; 
		double y = Math.sin(Math.toRadians((360*t/n))) * r;
		
		StdDraw.setPenColor(Color.RED);
		StdDraw.line(cx, cy, cx + x, cy + y);
    	
		System.out.print(360*t/n);
    	
    	
    }
    		
    // method that initiates the scene start -- displays the objects and starts clock count down
    public static void sceneStart(int h1, int h2) {
        for (int t = 10; t >= 0; t--) {

            drawBorder();
            
            // Object 1 at initial position
            //StdDraw.line(0, h1, WIDTH, h1);
            StdDraw.picture(0, h1, "ball.png");

            // Object 2 at initial position
            //StdDraw.line(0, h2, WIDTH, h2);
            drawCannon(0, h2, CAN_SIZE);
            
            double x = Math.cos(Math.toRadians((360*t/n))) * r; 
    		double y = Math.sin(Math.toRadians((360*t/n))) * r;
    		
            // Count down number
            StdDraw.setPenColor(Color.RED);
            //StdDraw.text(WIDTH / 2, HEIGHT / 2, "" + t);
            StdDraw.text(cx + x, cx + y, "" + t); // NEED TO PUT CLOCK ON END OF HAND
            
            drawClock(cx, cy, r, n, t);
            // show double buffer and then sleep 1 sec
            StdDraw.show(1000);

            // When we did not have clear, the numbers
            // overlap on each other
            StdDraw.clear();
        }
    }// end of scene start method

    //creates program that displays the moving object
    public static void sceneRace(int h1, int h2, int v1x, int v1y, int v2x,
            int v2y) {
        
        StdAudio.loop("computer_blow.wav");

        final int FRAME_TIME = 50; // 60 ms
        final double GRAVITY = 0;

        // Simulate time from 0 to 10 sec.
        long T0 = System.currentTimeMillis(); // for debugging to see real time
        for (double t = 0; t < 10; t += FRAME_TIME / 1000.0) {
            // Compute image 1's position
            double x1 = pos(0, v1x, 0, t); // v1x * t;
            double y1 = pos(h1, 0, GRAVITY, t);  // h1 + v1y * t 

            // Compute image 2's position
            double x2 = pos(0, v2x, 0, t); // v2x * t;
            double y2 = pos(h2, 0, GRAVITY, t); // h2 + v2y * t 

            // Print out for debugging
            long currT = System.currentTimeMillis();
            System.out.println("t: " + t + "; RealT: " + (currT - T0) / 1000.0);
            System.out.println("x1: " + x1 + "; y1:" + y1);
            System.out.println("x2: " + x2 + "; y2:" + y2);

            // Used the method for custom figure
            // You can also define the method in this file
            StdDraw.picture(x1, y1, "ball.png");
            drawCannon(x2, y2, CAN_SIZE);

            // copy to display, and sleep for FRAME_TIME ms
            StdDraw.show(FRAME_TIME);

            StdDraw.clear();
        } // end of for

    } // end of scene race method

    // Compute position from initial position initP, initial speed initV, 
    // acceleration a, at time t
    public static double pos(double initP, double initV, double a, double t) {
        return initP + initV * t /*+ 0.5 * a * t * t*/; 
    }// end of position method
    
    // Utility method to use Canvas size as scale
    public static void setCanvasScale() {
        // Change from the default of 512x512.
        StdDraw.setCanvasSize(WIDTH, HEIGHT);

        // Change scale from the default of [0 - 1.0].
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
    } // end of canvas scale method
    
    // draws border
    public static void drawBorder() {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
    }// end of draw border
    
    //method for customized object created by student
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
    
}//end of drawCannon method

    
    

} // end of Animation
