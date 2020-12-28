// William Faunce
// This program reads grades from a file and reports the statistics of the class' grades

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class GradeReport {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);					// scanner for user input
		DecimalFormat fmt = new DecimalFormat("#.0");				// format for showing only one decimal point
		
		String [] studentID;							// array for student ID
		String fileName = "";							// initializes fileName so that the user can enter the name later
		int [] midterm;								// array for midterm grades
		int [] finalGrade;							// array for final grades
		int [] midCount = {0,0,0,0,0};						// array for midterm analysis
		int [] finalCount = {0,0,0,0,0};
		
		int a = 0;															// initialized integer used for the index of arrays
		
		// OUTPUT
		System.out.println("Grade Roster by William Faunce");
		System.out.println("");
		System.out.print("Enter name of file: ");
		
		fileName = scan.nextLine();						// sets the string fileName equal to the user's input
		Scanner filescan = new Scanner(new FileReader(fileName)); 		// scanner for reading the file
		
		System.out.println("");
		System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s", "Student", "Midterm", "Grade", "Final", "Grade"));
		System.out.println("-------------------------------------------------");
		
		int classSize = filescan.nextInt();					// scans first line of file to determine class size
		
		// sets the array sizes equal to the class size
		studentID = new String[classSize];
		midterm = new int [classSize];
		finalGrade = new int [classSize];
		
		// while loop to read each line from file and assign data to appropriate items
		while (filescan.hasNext()) {
			studentID[a] = filescan.next();
			midterm[a] = filescan.nextInt();
			finalGrade[a] = filescan.nextInt();
			++a;								// increases "a" by 1 to store the next data point in the next index
		}
		
		// for loop that displays output of data from the while loop
		for (int b=0; b < midterm.length; b++) {
			System.out.println(String.format("%-10s %-10s %-10s %-10s %-10s", studentID[b],
					midterm[b], letterGrade(midterm, mean(midterm), deviate(midterm, mean(midterm)),b),
					finalGrade[b], letterGrade(finalGrade, mean(finalGrade), deviate(finalGrade, mean(finalGrade)), b)));
		}
		
		// MIDTERM ANALYSIS
		System.out.println("");
		System.out.println("Midterm Analysis");
		System.out.println("Mean: " +fmt.format(mean(midterm)));
		System.out.println("Std Dev: " +fmt.format(deviate(midterm, mean(midterm))));
		for (int c = 0; c < classSize; c++) {
			switch(letterGrade(midterm, mean(midterm), deviate(midterm, mean(midterm)), c)) {
				case "A": midCount [0] = midCount[0] + 1;
					break;
				case "B": midCount [1] = midCount[1] + 1;
					break;
				case "C": midCount [2] = midCount[2] + 1;
					break;
				case "D": midCount [3] = midCount[3] + 1;
					break;
				case "E": midCount [4] = midCount[4] + 1;
					break;
			}
		}
		System.out.println(counter(midCount));				// displays the number of times a letter grade has appeared
		
		// FINAL ANALYSIS
		System.out.println("Final Analysis");
		System.out.println("Mean: " +fmt.format(mean(finalGrade)));
		System.out.println("Std Dev: " +fmt.format(deviate(finalGrade, mean(finalGrade))));
		
		for (int c = 0; c < classSize; c++) {
			switch(letterGrade(finalGrade, mean(finalGrade), deviate(finalGrade, mean(finalGrade)), c)) {
				case "A": finalCount [0] = finalCount[0] + 1;
					break;
				case "B": finalCount [1] = finalCount[1] + 1;
					break;
				case "C": finalCount [2] = finalCount[2] + 1;
					break;
				case "D": finalCount [3] = finalCount[3] + 1;
					break;
				case "E": finalCount [4] = finalCount[4] + 1;
					break;
			}
		}
		System.out.println(counter(finalCount));
		
		// closes both scanners
		scan.close();
		filescan.close();
	}

	// PRE: passed an array reference | POST: returns the arithmetic mean
	public static double mean (int [] data) {
		double result = 0;						// initializes double result
		
		// for loop to add up all the values in the array
		for (int k = 0; k < data.length; k++)
			result += data[k];
		result = result / data.length;					// divides sum by number of values in array
		
		return result;
	}
	
	// PRE: passed an array reference and the mean | POST: returns the standard deviation
	public static double deviate (int [] data, double mean) {
		double total = 0;						// initializes double total
		
		// for loop to total values based on given formula for standard deviation
		for (int k = 0; k < data.length; k++)
			total += Math.pow(data[k] - mean,2) / data.length;
		double result = Math.sqrt(total);				// square roots the total to determine the standard deviation
		
		return result;
	}
	
	// PRE: passed the numeric grade, the mean, and standard deviation | POST: returns the letter grade based on curve
	public static String letterGrade (int [] data, double mean, double deviate, int n) {
		String letter = "";						// initializes string letter to be assigned later
		
		// if else statements used as equations for calculating the letter grade
		if (mean + 1.5*deviate <= data[n])
			letter = "A";
		else if (((mean + 0.5*deviate) <= data[n]) && (data[n] < (mean + 1.5*deviate)))
			letter = "B";
		else if (((mean - 0.5*deviate) <= data[n]) && (data[n] < (mean + 0.5*deviate)))
			letter = "C";
		else if (((mean - 1.5*deviate) <= data[n]) && (data[n] < (mean - 0.5*deviate)))
			letter = "D";
		else if (data[n] < (mean - 1.5*deviate))
			letter = "E";
			
		return letter;
	}
	
	// PRE: passed an array of counts | POST: returns the letter grade with *'s to show how many times it occurred
	public static String counter (int [] c) {
		String result = "";
		
		// nested loops that ends up displaying *'s next to the letter grade
		// that is dependent upon how many times the letter is read
		for (int i = 0; i < c.length; i++) {
			if (c[i] > 0) {
				if (i == 0) System.out.print("A: ");
				if (i == 1) System.out.print("B: ");
				if (i == 2) System.out.print("C: ");
				if (i == 3) System.out.print("D: ");
				if (i == 4) System.out.print("E: ");
				for (int b = 0; b < c[i]; b++)
					System.out.print("*");
				System.out.println();
			}
		}
		return result;
	}
}
