/* jstephens  - pshape practice sketches  2015-04-02

b_createShapeFunctions

*/


float over;
float up;


void setup () {
	size(1024, 768);


}

void draw () {
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
void myPolygon(float x, float y, float radius, float npoints) {

	float theta = TWO_PI / npoints;

	beginShape();
	for (int a = 0; a < TWO_PI; a += theta){
		float sx = x + cos(a) * radius;
		float sy = y + sin(a) * radius;
		vertex(sx, sy);
	}
	endShape(CLOSE);



}