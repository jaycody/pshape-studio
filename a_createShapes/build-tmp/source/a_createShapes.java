import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class a_createShapes extends PApplet {

/* jstephens  - pshape practice sketches  2015-04-02

a_createShapes

*/
float over;
float up;


public void setup () {
	size(1024, 768);


}

public void draw () {
	over 	= mouseX;
	up 		= mouseY;

	beginShape();
	vertex(10 	+ over, 10	+ up);
	vertex(100 	+ over, 10 	+ up);
	vertex(100 	+ over, 100 + up);
	endShape();

}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "a_createShapes" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
