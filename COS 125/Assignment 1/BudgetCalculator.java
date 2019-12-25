// This program calculates a budget based on a user's job (hours, rate, etc.)

import java.util.Scanner;

public class BudgetCalculator {

	public static void main(String[] args) {

		int hours = 0; // hours worked for 4 weeks
		double rent, util, trans, food; // various bills
		final double rate = 15.50; // fixed hourly rate
		final double car = 325.75; // fixed car payment

		Scanner scan = new Scanner(System.in); // takes the user's input

		// user inputs for hours worked each week
		for (int i = 1; i < 5; i++) {
			System.out.print("Enter hours worked in week " + i + ": ");
			hours += scan.nextInt();
		}

		// user inputs for expenses
		System.out.print("\nEnter rent: ");
		rent = scan.nextDouble();
		System.out.print("Enter utilities: ");
		util = scan.nextDouble();
		System.out.print("Enter transportaion cost: ");
		trans = scan.nextDouble();
		System.out.print("Enter food cost: ");
		food = scan.nextDouble();
		scan.close();

		double pay = hours * rate; // calculates user's pay
		double exp = rent + util + trans + food + car; // calculates total expenses
		double ext = (pay - exp); // leftover funds

		// percentages of each bill in expenses
		double carp = ((car / exp) * 100);
		double rentp = ((rent / exp) * 100);
		double utilp = ((util / exp) * 100);
		double transp = ((trans / exp) * 100);
		double foodp = ((food / exp) * 100);

		// formatted output showing cost and percentages
		System.out.print("\nBudget\n");
		System.out.printf("%-20s %12s %15s %n", "Expenses", "Amount", "Percentage");
		System.out.printf("%-20s %12.2f %15.2f %n", "Car Payment", car, carp);
		System.out.printf("%-20s %12.2f %15.2f %n", "Rent", rent, rentp);
		System.out.printf("%-20s %12.2f %15.2f %n", "Utility", util, utilp);
		System.out.printf("%-20s %12.2f %15.2f %n", "Transportation", trans, transp);
		System.out.printf("%-20s %12.2f %15.2f %n %n", "Food", food, foodp);

		System.out.printf("%-20s %11.2f %n", "Total Pay", pay);
		System.out.printf("%-20s %11.2f %n", "Total Expenses", exp);
		System.out.printf("%-20s %11.2f %n", "Leftover funds", ext);

	}

}