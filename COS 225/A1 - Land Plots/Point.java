package wFaunceA1;

// point represented in 2D with an X and Y coordinate
public class Point {
	private double x;
	private double y;

	// POST: default point is (0,0)
	public Point() {
		x = y = 0;
	}

	// POST: parameterized constructor
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/* ACCESSORS AND MODIFIERS */
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	// POST: return (x,y)
	public String toString() {
		return " (" + x + "," + y + ") ";
	}
}
