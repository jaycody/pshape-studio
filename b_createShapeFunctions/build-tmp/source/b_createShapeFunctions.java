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

public class b_createShapeFunctions extends PApplet {

/* jstephens  - pshape practice sketches  2015-04-02

b_createShapeFunctions

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


///CREATE TRIANGLE FROM POLYGON FUNCTION
	myPolygon(20 + over, 20 + up, 100, 3); 

}

////////////////////////////////////////////////////
//  CREATE A POLYGON with EQUIDISTANCE VERTEX ANGLES
public void myPolygon(float x, float y, float radius, float npoints) {

	float theta = TWO_PI / npoints;

	beginShape();
	for (int a = 0; a < TWO_PI; a += theta){
		float sx = x + cos(a) * radius;
		float sy = y + sin(a) * radius;
		vertex(sx, sy);
	}
	endShape(CLOSE);



}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "b_createShapeFunctions" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
