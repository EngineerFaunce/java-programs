// This program produces a customer's bill

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Currency;

public class Catering {

	public static void main(String[] args) {
		final double BEEF = 12.95; // price of beef meal
		final double CHIC = 10.95; // price of chicken meal
		final double VEG = 8.95; // price of vegan meal

		// room capacities and associated fees
		final int ROOM1 = 200;
		final int ROOM2 = 150;
		final int ROOM3 = 100;
		final int ROOM4 = 30;
		final double FEE1 = 250.00;
		final double FEE2 = 200.00;
		final double FEE3 = 100.00;
		final double FEE4 = 50.00;

		final double TAX1 = 0.18; // gratuity tax
		final double TAX2 = 0.065; // state tax

		double roomTotal = 0; // initializes room total
		double roomTax = 0; // initializes room tax

		// used later for displaying a $ in the output
		NumberFormat fmtC = NumberFormat.getCurrencyInstance();
		fmtC.setCurrency(Currency.getInstance(Locale.US));

		Scanner scan = new Scanner(System.in); // takes the user's input

		// user inputs for number of each meal wanted
		System.out.print("Enter the number of beef meals: ");
		int meal1 = scan.nextInt();
		System.out.print("Enter the number of chicken meals: ");
		int meal2 = scan.nextInt();
		System.out.print("Enter the number of vegan meals: ");
		int meal3 = scan.nextInt();
		scan.close();

		int guests = meal1 + meal2 + meal3; // totals the guest count

		// used to limit number of guests
		if (guests > 200) {
			System.out.print("Invalid. Max capacity is 200.\n");
			System.exit(1);
		}

		// creates an error for negative numbers
		if (meal1 < 0 || meal2 < 0 || meal3 < 0) {
			System.out.print("Invalid data. Number cannot be negative.\n");
			System.exit(-1);
		}

		/* Processing and output */
		System.out.println("\nCatering Bill\n------------------------");
		System.out.printf("%-30s %20s %n", "Number in party: ", "" + guests);

		// Determines which room is assigned and its cost
		if (guests <= ROOM4 && guests > 0) {
			System.out.printf("%-30s %20s %n", "Room Cost: ", "" + fmtC.format(FEE4));
			System.out.printf("%-30s %20s %n %n", "Room Tax: ", "" + fmtC.format(FEE4 * TAX2));
			roomTotal = FEE4;
			roomTax = (FEE4 * TAX2);
		} else if (guests <= ROOM3 && guests > ROOM4) {
			System.out.printf("%-30s %20s %n", "Room Cost: ", "" + fmtC.format(FEE3));
			System.out.printf("%-30s %20s %n %n", "Room Tax: ", "" + fmtC.format(FEE3 * TAX2));
			roomTotal = FEE3;
			roomTax = (FEE3 * TAX2);
		} else if (guests <= ROOM2 && guests > ROOM3) {
			System.out.printf("%-30s %20s %n", "Room Cost: ", "" + fmtC.format(FEE2));
			System.out.printf("%-30s %20s %n %n", "Room Tax: ", "" + fmtC.format(FEE2 * TAX2));
			roomTotal = FEE2;
			roomTax = (FEE2 * TAX2);
		} else if (guests <= ROOM1 && guests > ROOM2) {
			System.out.printf("%-30s %20s %n", "Room Cost: ", "" + fmtC.format(FEE1));
			System.out.printf("%-30s %20s %n %n", "Room Tax: ", "" + fmtC.format(FEE1 * TAX2));
			roomTotal = FEE1;
			roomTax = (FEE1 * TAX2);
		}

		// meal totals
		double beeft = meal1 * BEEF;
		double chict = meal2 * CHIC;
		double vegt = meal3 * VEG;

		// Displays amount of meals requested and their cost
		if (meal1 > 0) {
			System.out.printf("%-30s %20s %n", "Number of beef dinners: ", meal1);
			System.out.printf("%-30s %20s %n %n", "Cost of beef dinners: ", fmtC.format(beeft));
		}
		if (meal2 > 0) {
			System.out.printf("%-30s %20s %n", "Number of chicken dinners: ", meal2);
			System.out.printf("%-30s %20s %n %n", "Cost of chicken dinners: ", fmtC.format(chict));
		}
		if (meal3 > 0) {
			System.out.printf("%-30s %20s %n", "Number of vegan dinners: ", meal3);
			System.out.printf("%-30s %20s %n %n", "Cost of vegan dinners: ", fmtC.format(vegt));
		}

		double foodg = ((beeft + chict + vegt) * TAX1); // food gratuity
		double total = roomTotal + roomTax + beeft + chict + vegt + foodg; // bill total

		System.out.printf("%-30s %20s %n", "Food Gratuity: ", "" + fmtC.format(foodg));
		System.out.printf("%-30s %20s %n", "Total: ", "" + fmtC.format(total));
	}

}
