// William Faunce
// This program calculates a budget based on a user's job (hours, rate, etc.)

import java.util.Scanner;

public class A1WilliamFaunce {

	public static void main(String[] args) {
		
		int hour1, hour2, hour3, hour4;				// hours worked per week
		final double rate = 15.50;				// fixed hourly rate
		double rent;						// cost of rent
		double util;						// cost of utilities
		double trans;						// cost of transportation
		double food;						// cost of food
		final double car = 325.75;				// fixed car payment
		
		Scanner scan = new Scanner(System.in);			// takes the user's input
		
		// user inputs for hours worked each week
		System.out.print("Enter hours worked in week 1: ");
		hour1 = scan.nextInt();
		System.out.print("Enter hours worked in week 2: ");
		hour2 = scan.nextInt();
		System.out.print("Enter hours worked in week 3: ");
		hour3 = scan.nextInt();
		System.out.print("Enter hours worked in week 4: ");
		hour4 = scan.nextInt();
		System.out.println("");
		
		int hours = hour1+hour2+hour3+hour4;			// adds up all the hours
		
		// user inputs for expenses
		System.out.print("Enter rent: ");
		rent = scan.nextDouble();
		System.out.print("Enter utilities: ");
		util = scan.nextDouble();
		System.out.print("Enter transportaion cost: ");
		trans = scan.nextDouble();
		System.out.print("Enter food cost: ");
		food = scan.nextDouble();
		scan.close();
		System.out.println("");
		
		double pay = hours * rate;				// calculates user's pay
		double exp = rent+util+trans+food+car;			// calculates total expenses
		
		double carp = ((car/exp) * 100);			// percentage of car
		double rentp = ((rent/exp) * 100);			// percentage of rent
		double utilp = ((util/exp) * 100);			// percentage of utilities
		double transp = ((trans/exp) * 100);			// percentage of transportation
		double foodp = ((food/exp) * 100);			// percentage of car
		
		// formatted budget chart showing cost and percentages
		System.out.print("Budget for William Faunce");
		System.out.println("");
		System.out.printf("%-20s %12s %15s %n","Expenses","Amount","Percentage");
		System.out.printf("%-20s %12.2f %15.2f %n","Car Payment", car, carp);
		System.out.printf("%-20s %12.2f %15.2f %n","Rent", rent, rentp);
		System.out.printf("%-20s %12.2f %15.2f %n","Utility", util, utilp);
		System.out.printf("%-20s %12.2f %15.2f %n","Transportation", trans, transp);
		System.out.printf("%-20s %12.2f %15.2f %n","Food", food, foodp);
		System.out.println("");
		
		double ext = (pay - exp);				// leftover money
		
		// output
		System.out.printf("%-20s %11.2f %n","Total Pay", pay);
		System.out.printf("%-20s %11.2f %n","Total Expenses", exp);
		System.out.printf("%-20s %11.2f %n","Leftover funds", ext);
		
	}

}
