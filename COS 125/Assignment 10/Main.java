// William Faunce
// This program will give a student a list of textbooks needed 
// for courses as well as a list of related tradebooks of interest to the major.

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BooklistGenerator data = new BooklistGenerator();
		data.LoadData();

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter your major: ");
		String userMajor = scan.next();
		String[] userCourses = new String[5];
		int count = 0;

		do {
			System.out.print("Enter course name (xxx to quit): ");
			userCourses[count] = scan.next();
			count++;
		} while (!userCourses[count - 1].equals("xxx") && count < 5);
		scan.close();

		/*
		 * Here we are iterating through the array of books generated in
		 * BooklistGenerator and the courses the user entered from before.
		 * 
		 * First we are checking if the book in the booklist is an instance of a
		 * Textbook object. If it is, then we check if the textbook is a match with the
		 * user's courses.
		 * 
		 * If the book is a tradebook, then we check if the major associated with the
		 * book is a match with the major the user entered.
		 */
		List<Book> textbooks = new ArrayList<Book>();
		List<Book> tradebooks = new ArrayList<Book>();

		for (int i = 0; i < data.booklist.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (data.booklist[i] instanceof Textbook) {
					if (((Textbook) data.booklist[i]).getCourseID().equals(userCourses[j])) {
						textbooks.add(data.booklist[i]);
					}
				} else if (data.booklist[i] instanceof Tradebook) {
					if (((Tradebook) data.booklist[i]).getMajor().equals(userMajor)) {
						if (!tradebooks.contains(data.booklist[i]))
							tradebooks.add(data.booklist[i]);
					}
				}
			}
		}

		System.out.print("\nList of textbooks:\n");
		Iterator<Book> iterator = textbooks.iterator();
		double textbook_sum = 0.00;
		while (iterator.hasNext()) {
			Book temp = iterator.next();
			textbook_sum += temp.retailPrice();
			temp.getBookInfo();
		}
		System.out.print("\nSum of retail book prices: " + textbook_sum);

		System.out.print("\n\nList of tradebooks:\n");
		iterator = tradebooks.iterator();
		while (iterator.hasNext()) {
			iterator.next().getBookInfo();
		}

	}
}