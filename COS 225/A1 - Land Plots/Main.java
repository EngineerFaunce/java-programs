// William Faunce
// This program generates a field with random plots

package wFaunceA1;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Rectangle2D[] plots = new Rectangle2D[4];
		Random ran = new Random(); // used as a randomizer for plot points

		int count = 0; // counter
		Boolean bool = true;

		// fills the plots array and ensures no overlap
		while (bool) {
			for (int i = 0; i < 4; i++) {
				plots[i] = new Rectangle2D((double) (ran.nextInt(16)), (double) (ran.nextInt(16)), 4.0, 4.0);
			}
			count = 0;

			// ensure that there are no plots overlapping
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if ((plots[i].overlaps(plots[k])) || (plots[i].contains(plots[k])))
						count++;
				}
			}

			if (count == 0)
				bool = false;
		}

		// OUTPUT
		System.out.print("Land Plots\n\n");
		for(int i=0; i < 4; i++) {
			System.out.print("Plot %d: %s\n", i, plot[i].getPoint().toString());
		}

		// create the field containing the plots, represented by 'P' characters
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
			System.out.print("\n");
		}
	}

}
