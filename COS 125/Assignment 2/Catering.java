// William Faunce
// This program produces a customer's bill

import java.util.Scanner;
import java.text.NumberFormat;

public class Catering {

	public static void main(String[] args) {
		final double BEEF = 12.95; // declares price of BEEF
		final double CHIC = 10.95; // declares price of CHICken
		final double VEG = 8.95; // declares price of VEGan meal

		double roomt = 0; // initializes room total
		double rmtax = 0; // initializes room tax

		int room1 = 200; // declares capacity of room 1
		int room2 = 150; // declares capacity of room 2
		int room3 = 100; // declares capacity of room 3
		int room4 = 30; // declares capacity of room 4
		final double FEE1 = 250.00; // room 1 rental fee
		final double FEE2 = 200.00; // room 2 rental fee
		final double FEE3 = 100.00; // room 3 rental fee
		final double FEE4 = 50.00; // room 4 rental fee

		final double TAX1 = 0.18; // declares gratuity tax
		final double TAX2 = 0.065; // declares state tax

		// makes it so a $ displays in the output
		NumberFormat fmtC = NumberFormat.getCurrencyInstance();

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
			System.out.print("Invalid. Max capacity is 200.");
			System.exit(1);
		}

		// creates an error for negative numbers
		if (meal1 < 0 || meal2 < 0 || meal3 < 0) {
			System.out.print("Invalid data. Number cannot be negative.");
			System.exit(1);
		}

		// Processing and output
		System.out.println("");
		System.out.println("Catering by William Faunce");
		System.out.printf("%-30s %20s %n", "Number in party: ", "" + guests);

		// Determines which room is assigned and its cost
		if (guests <= room4 && guests > 0) {
			System.out.printf("%-30s %20s %n", "Room Cost: ", "" + fmtC.format(FEE4));
			System.out.printf("%-30s %20s %n", "Room Tax: ", "" + fmtC.format(FEE4 * TAX2));
			roomt = FEE4; // sets room total equal to room 4 fee
			rmtax = (FEE4 * TAX2); // declares room tax fee
		} else if (guests <= room3 && guests > room4) {
			System.out.printf("%-30s %20s %n", "Room Cost: ", "" + fmtC.format(FEE3));
			System.out.printf("%-30s %20s %n", "Room Tax: ", "" + fmtC.format(FEE3 * TAX2));
			roomt = FEE3; // sets room total equal to room 3 fee
			rmtax = (FEE3 * TAX2); // declares room tax fee
		} else if (guests <= room2 && guests > room3) {
			System.out.printf("%-30s %20s %n", "Room Cost: ", "" + fmtC.format(FEE2));
			System.out.printf("%-30s %20s %n", "Room Tax: ", "" + fmtC.format(FEE2 * TAX2));
			roomt = FEE2; // sets room total equal to room 2 fee
			rmtax = (FEE2 * TAX2); // declares room tax fee
		} else if (guests <= room1 && guests > room2) {
			System.out.printf("%-30s %20s %n", "Room Cost: ", "" + fmtC.format(FEE1));
			System.out.printf("%-30s %20s %n", "Room Tax: ", "" + fmtC.format(FEE1 * TAX2));
			roomt = FEE1; // sets room total equal to room 1 fee
			rmtax = (FEE1 * TAX2); // declares room tax fee
		}

		double beeft = meal1 * BEEF; // declares beef meal total
		double chict = meal2 * CHIC; // declares chicken meal total
		double vegt = meal3 * VEG; // declares vegan meal total

		// Displays amount of meals requested and their cost
		if (meal1 > 0) {
			System.out.printf("%-30s %3s %n", "Number of beef dinners: ", meal1);
			System.out.printf("%-30s %20s %n", "Cost of beef dinners: ", fmtC.format(beeft));
		} else
			;
		if (meal2 > 0) {
			System.out.printf("%-30s %3s %n", "Number of chicken dinners: ", meal2);
			System.out.printf("%-30s %20s %n", "Cost of chicken dinners: ", fmtC.format(chict));
		} else
			;
		if (meal3 > 0) {
			System.out.printf("%-30s %3s %n", "Number of vegan dinners: ", meal3);
			System.out.printf("%-30s %20s %n", "Cost of vegan dinners: ", fmtC.format(vegt));
		} else
			;

		double foodg = ((beeft + chict + vegt) * TAX1); // food gratuity
		double total = roomt + rmtax + beeft + chict + vegt + foodg; // bill total

		System.out.printf("%-30s %20s %n", "Food Gratuity: ", "" + fmtC.format(foodg));
		System.out.println("");
		System.out.printf("%-30s %20s %n", "Total: ", "" + fmtC.format(total));
	}

}
