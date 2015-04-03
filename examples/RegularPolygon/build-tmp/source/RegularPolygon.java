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

public class RegularPolygon extends PApplet {

/**
 * Regular Polygon
 * 
 * What is your favorite? Pentagon? Hexagon? Heptagon? 
 * No? What about the icosagon? The polygon() function 
 * created for this example is capable of drawing any 
 * regular polygon. Try placing different numbers into the 
 * polygon() function calls within draw() to explore. 
 */

public void setup() {
  size(640, 360);
}

public void draw() {
  background(102);
  
  pushMatrix();
  translate(width*0.2f, height*0.5f);
  rotate(frameCount / 200.0f);
  polygon(0, 0, 82, 3); 
  popMatrix();
  
  pushMatrix();
  translate(width*0.5f, height*0.5f);
  rotate(frameCount / 50.0f);
  polygon(0, 0, 80, 20); 
  popMatrix();
  
  pushMatrix();
  translate(width*0.8f, height*0.5f);
  rotate(frameCount / -100.0f);
  polygon(0, 0, 70, 7); 
  popMatrix();
}

public void polygon(float x, float y, float radius, int npoints) {
  float angle = TWO_PI / npoints;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius;
    float sy = y + sin(a) * radius;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "RegularPolygon" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
