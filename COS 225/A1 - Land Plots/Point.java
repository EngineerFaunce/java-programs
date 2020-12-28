package wFaunceA1;

public class Point {
	private double x; // x coordinate
	private double y; // y coordinate

	public Point() // POST: point (0,0)
	{
		x = y = 0;
	}

	public Point(double x, double y) // POST: point (x,y)
	{
		this.x = x;
		this.y = y;
	}

	// accessors and modifiers
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

	public String toString() // POST: return (x,y)
	{
		return " (" + x + "," + y + ") ";
	}
}
