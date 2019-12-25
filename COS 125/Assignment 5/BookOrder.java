// This program creates an order for books based on the file's input

import java.util.Scanner;
import java.io.*;

public class BookOrder {

	public static void main(String[] args) throws IOException {
		String title = "";					// title of book
		String isbn = "";					// ISBN of book
		String course = "";					// course ID of the class
		String enroll = "";					// amount of students enrolled in course
		
		// scanner used to read text file
		Scanner filescan = new Scanner(new FileReader("bookorders.txt")); 
		
		// OUTPUT
		System.out.println("Book Order Program by William Faunce");
		System.out.println();;
		System.out.println(String.format("%-60s %-25s %-15s %-15s %-15s", "Title", "ISBN", "Course", "Enrollment", "# To Order"));
		
		// loop that reads data from text file
		while (filescan.hasNext()) {
			title = filescan.nextLine();
			isbn = filescan.nextLine();
			course = filescan.nextLine();
			enroll = filescan.nextLine();
			
			// if statement that outputs "INVALID ISBN if isValid method returns false
			if (isValid(stripDashes((isbn))) == false)
				isbn = "INVALID ISBN";
			
			// formats and outputs the data read
			System.out.println(String.format("%-60s %-25s %-15s %-15s %-15d", title, stripDashes(isbn), course, enroll, numberToOrder(course, Integer.parseInt(enroll))));
		}
		filescan.close();					// closes file scanner
	}

	public static String stripDashes (String isbn) {		// PRE: isbn equals some 13 digit number with dashes
		isbn = isbn.replaceAll("-", "");			// removes the dashes from the ISBN read
		
		return isbn;						// POST: Return string with all dashes removed
	}
	
	public static boolean isValid (String isbn) {			// PRE: isbn w/o dashes
		// if statement to determine if the isbn is 13 digits in length
		if (stripDashes(isbn).length() != 13)
			return false;
			
		// if statement to determine if the last digit read is equal to the validated digit from the equation
		if (Integer.parseInt(stripDashes(isbn.substring(12,13))) != validation(isbn))
			return false;
		
		return true;						// POST: return TRUE if isbn is a valid ISBN number; else false
	}
	
	// another method needed because isValid cannot return an integer
	public static int validation (String isbn) {			// PRE: isbn w/o dashes
		// long equation to calculate 13th digit of isbn
		int validate = (Integer.parseInt(stripDashes(isbn.substring(0,1)))) + (Integer.parseInt(stripDashes(isbn.substring(1,2)))*3) + (Integer.parseInt(stripDashes(isbn.substring(2,3)))) + (Integer.parseInt(stripDashes(isbn.substring(3,4)))*3) + (Integer.parseInt(stripDashes(isbn.substring(4,5)))) + (Integer.parseInt(stripDashes(isbn.substring(5,6)))*3) + (Integer.parseInt(stripDashes(isbn.substring(6,7)))) + (Integer.parseInt(stripDashes(isbn.substring(7,8)))*3) + (Integer.parseInt(stripDashes(isbn.substring(8,9)))) + (Integer.parseInt(stripDashes(isbn.substring(9,10)))*3) + (Integer.parseInt(stripDashes(isbn.substring(10,11)))) + (Integer.parseInt(stripDashes(isbn.substring(11,12)))*3);
		int remainder = validate % 10;				// takes the remainder after dividing by 10
		int calculation = 10 - remainder;			// calculates the validation digit
		
		return calculation;					// POST: return calculated digit for isbn validation
	}
	
	public static int numberToOrder (String course, int enroll) {	// PRE: some course ID and amount of students enrolled in course
		int order = 0;						// initializes historical enrollment levels
		
		// switch case that assigns order number based on the course ID
		switch (course.substring(3,6)) {
			case "103": order = 50; break;
			case "120": order = 48; break;
			case "125": order = 110; break;
			case "213": order = 96; break;
			case "220": order = 100; break;
			case "221": order = 40; break;
			case "235": order = 85; break;
			case "312": order = 45; break;
			case "331": order = 50; break;
		}
		
		// if statement that determines which is the maximum amount to order
		if (order < enroll)
			return enroll;
		
		return order;														// POST: return the number of books to order as maximum of current and historical enrollment
	} 
}
