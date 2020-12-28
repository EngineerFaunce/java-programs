package wFaunceA1;

public class Circle extends GeometricObject {
	private double radius;

	// POST: default circle: blue, unfilled with radius 1.0
	public Circle() {
		super();
		radius = 1.0;
	}

	// POST: circle is blue, unfilled with set radius
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	// PRE: radius > 0.0
	// POST: circle is set by user
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	/* ACCESSORS AND MODIFIERS */
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// POST: return area of the circle
	@Override
	public double getArea() { 
		return Math.PI * radius * radius;
	}

	// POST: return circumference of the circle
	@Override
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	// POST: return string representation of circle
	@Override
	public String toString() {
		return super.toString() + " radius: " + radius + " area: " + String.format("%-6.2f", getArea()) + " perimeter: "
				+ String.format("%-10.2f", getPerimeter());
	}
}
