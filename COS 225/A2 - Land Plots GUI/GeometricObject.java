package wFaunceA2;

public abstract class GeometricObject {
	private String color = "white"; // shape color
	private boolean filled; // fill status

	protected GeometricObject() { // POST: default shape is unfilled blue
		this.color = "blue";
		this.filled = false;
	}

	// POST: shape set by user
	protected GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	// accessors and modifiers
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public String toString() { // POST: string representation of shape
		return "color: " + color + " filled: " + filled;
	}

	public abstract double getArea(); // POST: return area of geometric object

	public abstract double getPerimeter(); // POST: return perimeter of geometric object
}
