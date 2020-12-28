// William Faunce
// This class is for generating boxes to be used in A9WilliamFaunce

package boxProgram;

public class Box {

	private int length;
	private int width;
	private int height;
	
	// default box constructor
	public Box() {
		length = 1;
		width = 1;
		height = 1;
	}
	
	// parameterized box constructor where box is created with user-entered dimensions
	public Box(int l, int w, int h) {
		length = l;
		width = w;
		height = h;
	}
	
	// POST: returns length of box
	public int getLength() {
		return length;
	}
	
	// POST: returns width of box
	public int getWidth() {
		return width;
	}
	
	// POST: returns height of box
	public int getHeight() {
		return height;
	}
	
	// PRE: passed length | POST: sets length to desired number
	public int setLength(int l) {
		return length = l;
	}
	
	// PRE: passed width | POST: sets width to desired number
	public int setWidth(int w) {
		return width = w;
	}
	
	// PRE: passed height | POST: sets height to desired number
	public int setHeight(int h) {
		return height = h;
	}
	
	// PRE: passed the length, width, and height | POST: returns surface area of the box
	public static int surfaceArea(int l, int w, int h) {
		int area = (2 * (l * w)) + (2 * (l * h)) + (2 * (w * h));
		return area;
	}
	
	// PRE: passed the length, width, height | POST: returns volume of the box
	public static int volume(int l, int h, int w) {
		int volume = l * h * w;
		return volume;
	}

	public static int maxAmountOfGlobes(int l, int w, int h, int globeSize) {
		int max = (l / globeSize) * (w / globeSize) * (h / globeSize);
		return max;
	}

}
