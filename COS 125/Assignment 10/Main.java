// William Faunce
// This program will give a student a list of textbooks needed 
// for courses as well as a list of related tradebooks of interest to the major.

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BooklistGenerator data = new BooklistGenerator();
		data.LoadData();

		Scanner scan = new Scanner(System.in); // scanner for user input

		// System.out.print(data.booklist[0].getTitle());

		System.out.print("Enter your major: ");
		String userMajor = scan.next();
		String[] userCourses = new String[5];
		int count = 0;

		do {
			System.out.print("Enter course name (xxx to quit): ");
			userCourses[count] = scan.next();
			count++;
		} while (!userCourses[count - 1].equals("xxx") && count < 5);

		System.out.print("\n\nList of textbooks: ");
		for(int i=0;i < 5; i++) {
			
		}
		

		scan.close();

	}
}