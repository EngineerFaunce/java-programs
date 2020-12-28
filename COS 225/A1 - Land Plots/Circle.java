package wFaunceA1;

public class Circle extends GeometricObject {
	private double radius; // circle radius

	public Circle() { // POST: default circle: blue unfilled radius 1.0
		super();
		radius = 1.0;
	}

	public Circle(double radius) // POST: circle is blue unfilled with set radius
	{
		super();
		this.radius = radius;
	}

	// PRE: radius > 0.0
	public Circle(double radius, String color, boolean filled) {
		super(color, filled); // POST: circle is set by user
		this.radius = radius;
	}

	// accessors and modifiers
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) { // PRE: radius > 0.0
		this.radius = radius;
	}

	@Override
	public double getArea() { // POST: return circle area
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() { // POST: return circle perimeter
		return 2 * radius * Math.PI;
	}

	@Override
	public String toString() { // POST: return string representation of circle
		return super.toString() + " radius: " + radius + " area: " + String.format("%-6.2f", getArea()) + " perimeter: "
				+ String.format("%-10.2f", getPerimeter());
	}
}
