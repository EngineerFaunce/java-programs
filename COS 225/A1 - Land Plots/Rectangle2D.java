package wFaunceA1;

// 2 dimensional rectangle with a point
public class Rectangle2D extends Rectangle {
	private Point point;

	// default constructor: blue, unfilled with width & length set to 1.0
	public Rectangle2D() {
		super();
		point = new Point();
	}

	// parameterized constructor
	public Rectangle2D(double x, double y, double width, double height) {
		super(width, height);
		this.point = new Point(x, y);
	}

	// accessors and modifiers
	public Point getPoint() {
		return point;
	}

	public void setPoint(double x, double y) {
		this.point = new Point(x, y);
	}

	// POST: return true if object contains other point
	public Boolean contains(Point other) {
		double otherX = other.getX();
		double otherY = other.getY();

		double pointX = point.getX();
		double pointY = point.getY();

		if (((otherX >= pointX) && (otherX <= pointX + super.getWidth() - 1))
				&& ((otherY >= pointY) && (otherY <= pointY + super.getHeight() - 1)))
			return true;
		else
			return false;
	}

	// POST: return true if object contains other rectangle
	public Boolean contains(Rectangle2D other) {
		Point otherP = new Point(other.getPoint().getX() + other.getWidth() - 1,
				other.getPoint().getY() + other.getHeight() - 1);

		if (this.contains(other.getPoint()) && this.contains(otherP))
			return true;
		else
			return false;
	}

	// POST: return true if another rectangle overlaps with current rectangle
	public Boolean overlaps(Rectangle2D other) {
		Point topL = other.getPoint();
		Point topR = new Point(other.getPoint().getX() + other.getWidth() - 1, other.getPoint().getY());
		Point bottomR = new Point(other.getPoint().getX() + other.getWidth() - 1,
				other.getPoint().getY() + other.getHeight() - 1);
		Point bottomL = new Point(other.getPoint().getX(), other.getPoint().getY() + other.getHeight() - 1);

		int count = 0;

		if (this.contains(topL))
			count++;
		if (this.contains(topR))
			count++;
		if (this.contains(bottomR))
			count++;
		if (this.contains(bottomL))
			count++;

		if (count > 0 && count < 4) {
			return true;
		} else {
			return false;
		}
	}

}
