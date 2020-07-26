// William Faunce
// This program gives a list of textbooks for a student based on input

package bookProgram;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class A10WilliamFaunce {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in); // scanner for user input
		NumberFormat price = new DecimalFormat("$0.00"); // format for adding a $ sign for pricing

		String input = "";

		System.out.print("Enter your major: ");
		major = scan.next();
		System.out.println();

		int c = 0; // counter

		do {
			System.out.print("Enter course name (xxx to quit): ");
			input = scan.next();

		} while (!input.equals("xxx"));

		System.out.println("\nList of textbooks: ");

		scan.close();

	}
}