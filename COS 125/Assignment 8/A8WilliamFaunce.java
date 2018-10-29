// William Faunce
// This program simulates a forest and then the outcome of setting the first row on fire

import java.util.Scanner;

public class A8WilliamFaunce {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);									// scanner for user input
		
		int capacity = 0;														// capacity of forest
		double density = 0;														// density of trees
		int treeCount = 0;														// counter for number of trees in forest
		int burnCount = 0;														// counter for number of trees burned
		
		System.out.print("Enter number of trees: ");
		capacity = scan.nextInt();
		System.out.print("Enter density: ");
		density = scan.nextDouble();
		
		String [][] forest = new String[capacity][capacity];					// array for the forest to create
		
		// OUTPUT
		// while loop that produces a valid forest and randomly populates with trees
		while (capacity >= 10 && capacity <= 30 && density >= 0.20 && density <= 0.8) {
			System.out.println();
			System.out.println("The original forest:");
			for (int row=0; row < forest.length; row++) {
				for (int col=0; col < forest.length; col++) {
					forest[row][col] = " . ";
					
					// if loop that calls the tree method to create trees (T's)
					if (tree(density) == true) {
						forest[row][col] = " T ";
						treeCount++;						// adds 1 to the treeCount when a tree is created
					}
					System.out.print(forest[row][col]);
				}
				System.out.println();
			}
			
			System.out.println("Percent populated: " +percent(treeCount, forest.length));
			System.out.println();
			System.out.println("The final forest:");
			forest = burn(forest, capacity);
			for (int row=0; row < forest.length; row++) {
				for (int col=0; col < forest.length; col++) {
					System.out.print(forest[row][col]);
					// adds 1 to the burnCount if a " B " is found in any of the rows/columns
					if (forest[row][col] == " B ") {
						burnCount++;
					}
				}
				System.out.println();
			}
			System.out.println("Percent burned: " +percent(burnCount, forest.length));
			
			// boolean logic to determine if the last row contains a " B " or not
			boolean burned = false;
			for (int row=0; row < forest.length; row++) {
				for (int col=0; col < forest.length; col++) {
					if (forest[capacity-1][col] == " B ") {
						burned = true;
					}
				}
			}
			
			// if logic that states whether the fire burned through or not
			if (burned == true)
				System.out.print("Fire burned through");
			else
				System.out.print("Fire burned out");
			
			break;
		}
		
		scan.close();							// closes scanner
	}

	// PRE: passed the desired density of the forest | POST: randomly generates trees for the forest
	public static boolean tree (double density) {
		if ((int)((Math.random()) * 101) <= density * 100) {
			return true;
		} else {
			return false;
		}
	}
	
	// PRE: passed the amount of trees and size of the forest | POST: returns percentage of trees in forest
	public static double percent (int treeCount, int arrayLength) {
		double totalArray = arrayLength * arrayLength;							// size of forest (length*width)
		double result = (double)treeCount / totalArray;
		
		return result;
	}
	
	// PRE: passed a 2D array and amount of trees | POST: causes trees below a burned tree to also burn
	public static String [][] burn (String [][] array, int arrayCapacity) {
		for (int row=0; row < array.length; row++) {
			for (int col=0; col < array.length; col++) {
				// if loop that sets first row of forest on fire
				if (array[0][col] == " T ")
					array[row][col] = " B ";
				
				// if loop that sets a tree below a burning tree to " B "
				if (row != arrayCapacity-1 && array[row][col] == " B " && array[row+1][col] == " T ")
					array[row+1][col] = " B ";
				
				// if loop that sets a tree diagonally down-left to " B "
				if (col != 0 && row != arrayCapacity-1 && array[row][col] == " B " && array[row+1][col-1] == " T ")
					array[row+1][col-1] = " B ";
				
				// if loop that sets a tree diagonally down-right to " B "
				if (col != arrayCapacity-1 && row != arrayCapacity-1 && array[row][col] == " B " && array[row+1][col+1] == " T ")
					array[row+1][col+1] = " B ";
				
			}
		}

		return array;
	}
}
