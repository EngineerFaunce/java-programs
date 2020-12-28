package wFaunceA1;

// 2 dimensional rectangle
public class Rectangle extends GeometricObject {
	private double width;
	private double height;

	// POST: default rectangle: blue, unfilled, width/length 1.0
	public Rectangle() {
		super();
		width = 1.0;
		height = 1.0;
	}

	// POST: parameterized width and height for rectangle
	public Rectangle(double width, double height) {
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

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// POST: return rectangle area
	@Override
	public double getArea() {
		return width * height;
	}

	// POST: return rectangle perimeter
	@Override
	public double getPerimeter() {
		return width * 2 + height * 2;
	}

	// POST: return string representation of rectangle
	@Override
	public String toString() {
		return super.toString() + " width: " + width + " height: " + height + " area: "
				+ String.format("%-6.2f", getArea()) + " perimeter: " + String.format("%-10.2f", getPerimeter());
	}
}
