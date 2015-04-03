/* jstephens  - pshape practice sketches  2015-04-02

a_createShapes

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

}

