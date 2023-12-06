/*package whatever //do not write package name here */
import java.io.*; 
class BresenhamAlgorithm { 

	// A naive way of drawing line 
	public static void naiveDrawLine(int x0, int y0, int x1, int y1) 
	{ 

		// Calculate dx and dy 
	int dx = x1 - x0; 
	int dy = y1 - y0; 
	int i1=2*dy;
	int i2=2*(dy-dx);
	int d=i1-dx;

	} 
	public static void main(String[] args) {
		naiveDrawLine(1,2,6,7);
	} 
} 

