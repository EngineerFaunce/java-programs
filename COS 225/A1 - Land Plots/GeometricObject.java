package wFaunceA1;

// shape with a color and boolean indicating if it is filled
public abstract class GeometricObject {
	private String color;
	private boolean filled;

	// POST: default constructor
	protected GeometricObject() {
		this.color = "blue";
		this.filled = false;
	}

	// POST: parameterized constructor
	protected GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	/* ACCESSORS AND MODIFIERS */
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFillStatus(boolean filled) {
		this.filled = filled;
	}

	// POST: string representation of shape
	public String toString() {
		return "color: " + color + " filled: " + filled;
	}

	public abstract double getArea(); // POST: return area of geometric object

	public abstract double getPerimeter(); // POST: return perimeter of geometric object
}
