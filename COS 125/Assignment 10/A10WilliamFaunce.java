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
		Scanner scan = new Scanner(System.in);								// scanner for user input
		Scanner filescan = new Scanner(new FileReader("books.txt"));		// scanner for scanning files
		NumberFormat price = new DecimalFormat("$0.00");					// format for adding a $ sign for pricing
		
		String input = "";
		String major = "";
		String [] courseName = new String [5];
		String [][] books = new String [50][50];
		
		String bookType = "";
		String title = "";
		String author = "";
		String isbn = "";
		String bookPrice = "";
		String course = "";
		
		
		// Couldn't figure out how to assign stuff from the .txt file to the array. Kept getting an error that
		// I've never seen before, so this is all I have. Hope you have a good winter break though!
		
		while(filescan.hasNext()) {
			for(int row=0; row < books.length; row++) {
				for(int col=0; col < books.length; col++) {
					books[row][col] = filescan.nextLine();
				}
			}
		}
		
		System.out.println(books[0][0]);
		System.out.println(books[0][1]);
		System.out.println(books[0][2]);
		
		System.out.print("Enter your major: ");
		major = scan.next();
		System.out.println();
		
		int c = 0;															// counter
		
		do {
			System.out.print("Enter course name (xxx to quit): ");
			input = scan.next();
			
			// if statement that breaks out of do-while loop
			if (input.equals("xxx"))
				continue;
			
			courseName[c] = input;
			c++;
		} while (!input.equals("xxx"));
		
		System.out.println("");
		System.out.println("List of textbooks: ");
		
		scan.close();
		filescan.close();
		
	}
}