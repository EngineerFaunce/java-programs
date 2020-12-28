// William Faunce
// This program generates a field with random plots

package wFaunceA2;

import java.util.Random;

public class assignment1 {

	public static void main(String[] args) {
		Rectangle2D[] plots = new Rectangle2D[4]; // creates an array for the plots
		Random ran = new Random(); // used as a randomizer for plot points

		int count = 0; // counter

		Boolean bool = true;
		while (bool) { // while loop that fills the array with plots and ensures no overlap
			for (int a = 0; a < 4; a++) {
				plots[a] = new Rectangle2D((double) (ran.nextInt(16)), (double) (ran.nextInt(16)), 4.0, 4.0);
			}
			count = 0;
			for (int u = 0; u < 4; u++) { // nested for loop to ensure that there is no plots overlapping
				for (int i = 0; i < 4; i++) {
					if (plots[u] == plots[i])
						;
					else if ((plots[u].overlaps(plots[i])) || (plots[u].contains(plots[i])))
						count++;
				}
			}
			if (count == 0) // if statement that breaks out of the while loop
				bool = false;
		}

		// OUTPUT
		System.out.println("William Faunce");
		System.out.println("");
		System.out.println("Plot 1: " + plots[0].getPoint().toString());
		System.out.println("Plot 2: " + plots[1].getPoint().toString());
		System.out.println("Plot 3: " + plots[2].getPoint().toString());
		System.out.println("Plot 4: " + plots[3].getPoint().toString());

		// nested for loop to create the field and plots using Rectangle2D class
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				Point plot = new Point(c, r);
				count = 0;

				if (plots[0].contains(plot))
					count++;
				else if (plots[1].contains(plot))
					count++;
				else if (plots[2].contains(plot))
					count++;
				else if (plots[3].contains(plot))
					count++;

				if (count > 0)
					System.out.print("P");
				else
					System.out.print(".");
			}
			System.out.println("");
		}
	}

}
