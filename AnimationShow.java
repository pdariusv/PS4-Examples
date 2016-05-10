//==========================================================
// 
// AnimationShow.java      CS112
// 
// Author: YRY            Email: cs112ta@cs.yale.edu 
// 
// Class: AnimationShow
// 
// ---------------------------------------------------------
//   This simple class demonstrates the effects of double 
// buffer. A good way to execute the program is in the Debug
// mode of eclipse. Please see slides of lecture 13.
//==========================================================
public class AnimationShow {
 
   public static void main(String[] args) {

      // Default is animation off: each draw appears on screen
      StdDraw.circle(0.5, 0.5, 0.25);

      // Screen cleared
      StdDraw.clear();

      // Draw again, appear immediately
      StdDraw.square(0.5, 0.5, 0.25);

      // Now switch to animation node: draw in buffer only
      StdDraw.show(0);
      
      // Now draw line (0,0) -> (1,1), but you cannot see
      StdDraw.line(0, 0, 1, 1);
      // Now draw line (0,1) -> (1,0), but you cannot see
      StdDraw.line(0, 1, 1, 0);

      // Now you can see
      StdDraw.show(0);

      // Now clear, which clears buffer only, no change to display
      StdDraw.clear();

      // Now show buffer, which is empty
      StdDraw.show(0);

      // Draw again
      StdDraw.square(0.5, 0.5, 0.25);
      StdDraw.show(0);
      
   } // end of main

} // end of AnimationShow
