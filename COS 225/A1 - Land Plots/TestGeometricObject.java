package wFaunceA1;

public class TestGeometricObject {
	public static void main(String[] args) {

		GeometricObject[] shapes = new GeometricObject[4];
		shapes[0] = new Circle(5.0);
		shapes[1] = new Rectangle(2.0, 3.0);
		shapes[2] = new Circle(4.0, "red", true);
		shapes[3] = new Rectangle(1.0, 1.0, "green", true);
		System.out.println("Display all objects:");
		display(shapes);

		System.out.println("\nAll objects have the same perimeters? " + equalPerimeters(shapes));

		System.out.println("\nNumber of circles is: " + countCircles(shapes));
		System.out.println();

		enlargeCircles(shapes);
		display(shapes);
	}

	public static void display(GeometricObject[] shapes) {
		for (GeometricObject shape : shapes)
			System.out.println(shape.toString());
	}

	public static Boolean equalPerimeters(GeometricObject[] shapes) {
		double per = shapes[0].getPerimeter();
		for (GeometricObject shape : shapes)
			if (shape.getPerimeter() != per)
				return false;
		return true;
	}

	public static int countCircles(GeometricObject[] shapes) {
		int count = 0;
		for (GeometricObject shape : shapes)
			if (shape instanceof Circle)
				count++;
		return count;
	}

	public static void enlargeCircles(GeometricObject[] shapes) {
		for (int k = 0; k < shapes.length; k++)
			if (shapes[k] instanceof Circle) {
				double radius = ((Circle) shapes[k]).getRadius();
				((Circle) shapes[k]).setRadius(radius * 2);
			}
	}
}
