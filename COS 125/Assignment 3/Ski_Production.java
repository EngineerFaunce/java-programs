// This program performs computations on a sample of skis

import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class Ski_Production {

	public static void main(String[] args) {

		int datap = 0; // number of data points
		int rejSkis = 0; // number of rejected skis

		String skiID = "";
		String skiAbr = ""; // ski component (RC or ED)

		double fricCoeff = 0.0; // friction coefficient
		double avgFricCo = 0.0; // average friction coefficient
		double cost = 0.0; // initializes cost of rejected skis

		final double RC = 21.99; // cost of RC component
		final double ED = 24.99; // cost of ED component

		Scanner scan = new Scanner(System.in); // scanner for user input
		NumberFormat fmtC = NumberFormat.getCurrencyInstance(); // used to display a dollar sign ($)
		fmtC.setCurrency(Currency.getInstance(Locale.US));
		NumberFormat fmtP = NumberFormat.getPercentInstance(); // used to display percentage (%)

		// asks user how many data entries they are making
		do {
			System.out.print("Enter number of data points: ");
			datap = scan.nextInt();
		} while (datap <= 0);

		int count = datap;
		do {
			// causes loop if ski ID entered does not equal RC or ED
			do {
				System.out.print("Enter ski ID: ");
				skiID = scan.next();
				skiAbr = skiID.substring(0, 2);
			} while (!skiAbr.equals("RC") && !skiAbr.equals("ED"));

			// asks user for friction coefficient greater than 0
			do {
				System.out.print("Enter friction coefficient for ski " + skiID + ": ");
				fricCoeff = scan.nextDouble();
			} while (fricCoeff <= 0);

			avgFricCo += fricCoeff; // adds each instance of frco to the total so that average can be taken later

			// prints component cost based on model number
			if (skiAbr.equals("RC"))
				System.out.print("Component cost for ski " + skiID + ": " + fmtC.format(RC));
			else
				System.out.print("Component cost for ski " + skiID + ": " + fmtC.format(ED));

			if (fricCoeff > 1.23) {
				System.out.print(" <--- REJECT"); // prints reject if friction coefficient exceeds 1.23
				rejSkis++; // increments count of rejected skis
				if (skiAbr.equals("RC"))
					cost += RC; // adds cost of RC component to total cost
				else
					cost += ED; // adds cost of ED component to total cost
			}

			System.out.print("\n\n");
			count--;
		} while (count > 0);

		scan.close(); // closes scanner

		avgFricCo /= datap; // calculates the average friction coefficient
		double perc = rejSkis / datap; // calculates percent of rejected skis

		/* Final Output */
		System.out.println("Number of Data Points: " + datap);
		System.out.println("Average Friction Coefficient: " + avgFricCo);
		System.out.println("Number of rejected skis: " + rejSkis);
		System.out.println("Percentage of rejected skis: " + fmtP.format(perc));
		System.out.println("Cost of rejected skis: " + fmtC.format(cost));
	}

}
