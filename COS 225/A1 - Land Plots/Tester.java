package wFaunceA1;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter (x,y) for start rectangle: ");
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		System.out.print("Enter width,height for start rectangle: ");
		double w = scan.nextDouble();
		double h = scan.nextDouble();
		Rectangle2D rec = new Rectangle2D(x, y, w, h);
		String code;

		System.out.print("Contains or overlap (C/O): ");
		code = scan.next();

		if (code.equals("C")) {
			System.out.print("Compare to point or rectangle: (P/R): ");
			code = scan.next();
			if (code.equals("P")) {
				Point p = new Point();
				System.out.print("Enter (x,y) for point: ");
				p.setX(scan.nextDouble());
				p.setY(scan.nextDouble());
				if (rec.contains(p))
					System.out.println("rec contains point");
				else
					System.out.println("rec does not contain point");
			} else {
				System.out.print("Enter (x,y) for second rectangle: ");
				x = scan.nextDouble();
				y = scan.nextDouble();
				System.out.print("Enter width,height for second rectangle: ");
				w = scan.nextDouble();
				h = scan.nextDouble();
				Rectangle2D rec2 = new Rectangle2D(x, y, w, h);
				if (rec.contains(rec2))
					System.out.println("rec contains second rec" + "");
				else
					System.out.println("rec does not contain second rec");
			}
		} else {
			System.out.print("Enter (x,y) for second rectangle: ");
			x = scan.nextDouble();
			y = scan.nextDouble();
			System.out.print("Enter width,height for second rectangle: ");
			w = scan.nextDouble();
			h = scan.nextDouble();
			Rectangle2D rec2 = new Rectangle2D(x, y, w, h);
			if (rec.overlaps(rec2))
				System.out.println("second rec overlaps rec" + "");
			else
				System.out.println("second rec does not overlap rec");
		}
		scan.close();
	}
}
