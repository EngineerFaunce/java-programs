package wFaunceA2;

public class Rectangle extends GeometricObject {
	private double width; // rectangle width
	private double height; // rectangle length

	public Rectangle() { // POST: default rectangle: blue unfilled, width/length 1.0
		super();
		width = 1.0;
		height = 1.0;
	}

	public Rectangle(double width, double height) { // POST: rectangle is blue unfilled with set width & length
		super();
		this.width = width;
		this.height = height;
	}

	// PRE: width/height > 0.0
	public Rectangle(double width, double height, String color, boolean filled) {
		super(color, filled); // POST: rectangle is set by the user
		this.width = width;
		this.height = height;
	}

	// accessors and modifiers
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) { // PRE: width > 0.0
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) { // PRE: height > 0.0
		this.height = height;
	}

	@Override
	public double getArea() { // POST: return rectangle area
		return width * height;
	}

	@Override
	public double getPerimeter() { // POST: return rectangle perimeter
		return width * 2 + height * 2;
	}

	@Override
	public String toString() { // POST: return string representation of rectangle
		return super.toString() + " width: " + width + " height: " + height + " area: "
				+ String.format("%-6.2f", getArea()) + " perimeter: " + String.format("%-10.2f", getPerimeter());
	}
}
