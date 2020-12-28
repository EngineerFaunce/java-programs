// William Faunce
// This program manages an inventory based on contents of a .txt file

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class InventoryManager {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);					// scanner for user input
		Scanner fileScan = new Scanner(new FileReader("inventory.txt"));	// scanner for reading inventory file
		DecimalFormat fmt = new DecimalFormat("#.00");				// format for showing only one decimal point
		
		String input = "";					// initializes input to take in user input later
		String item = "";					// string for entering new products
		int itemStock = 0;					// new product's stock
		int itemAdd = 0;					// amount of item to add/subtract from stock
		String itemPrice = "";					// new product's unit price
		double sum;						// cost of all items in array
		
		final int INITIALIZE = 5;				// initial array size
		String [] id = new String[INITIALIZE];			// array for item ID in the inventory
		String [] price = new String[INITIALIZE];		// price of the item
		int [] stock = new int[INITIALIZE];			// array for how much of the item is in stock

		int c = 0;						// initialized counter for use with while loop
		int capacity = 0;					// capacity of array
		
		// OUTPUT
		System.out.println("Inventory Manager");
		System.out.println("By William Faunce");
		System.out.println("");
		System.out.println("Select from menu:");
		System.out.println("E - Edit");
		System.out.println("I - Insert");
		System.out.println("R - Remove");
		System.out.println("D - Display table");
		System.out.println("Q - Quit");
		System.out.println("");
		
		// while loop to read each line from file and assign data to appropriate items
		while (fileScan.hasNext()) {
			id[c] = fileScan.next();
			stock[c] = fileScan.nextInt();
			price[c] = fileScan.next();
			
			capacity++;
			
			// if loop that resizes the array if it is full
			if (capacity == id.length || capacity == stock.length || capacity == price.length) {
				id = resize(id, id.length+1);
				stock = resize(stock, stock.length+1);
				price = resize(price, price.length+1);
				
				// if loop to resize array once file is done being read, otherwise the array contains an extra null value at the end
				if (!fileScan.hasNext()) {
					id = resize(id, id.length-1);
					stock = resize(stock, stock.length-1);
					price = resize(price, price.length-1);
				}
			}
			
			c++;
		}
		
		// while loop that repeats unless the user enters "Q" which quits the program
		while (!input.equals("Q")) {
			// switch case for reading the user's input
			switch (input) {
				// edit function
				case "E":
					System.out.print("Enter product: ");
					item = scan.next();
					
					// if loop that checks whether the id entered exists in the inventory or not inventory
					if (check(id, id.length, item) == true) {
						System.out.print("Enter amount to add (+) or subtract (-): ");
						itemAdd = scan.nextInt();
						stock[search(id, id.length, item)] = stock[search(id, id.length, item)] + itemAdd;		// adds new amount to current stock
						
						System.out.println("Item " +item+ " has new amount in stock " +stock[search(id, id.length, item)]);
						System.out.println("");
					} else {
						System.out.println("Item " +item+ " is not found");
						System.out.println("");
					}
					
					break;
					
				// insert function
				case "I":
					System.out.print("Enter new product ID, stock, and unit price: ");
					item = scan.next();
					itemStock = scan.nextInt();
					itemPrice = scan.next();
					
					// if loop that will either insert the item or report that the item already exits
					if (check(id, id.length, item) == false) {
						id = insert(id, item);
						stock = insert(stock, itemStock);
						price = insert(price, itemPrice);
						
						System.out.println("Item " +item+ " is inserted");
						System.out.println("");
					} else {
						System.out.println("Item " +item+ " already exists");
						System.out.println("");
					}
					
					break;
					
				// remove function
				case "R":
					System.out.print("Enter ID of product to remove: ");
					item = scan.next();
					
					// if loop that will either remove a product or report that no such item exists
					if (check(id, id.length, item) == true) {
						stock = remove(stock, stock[search(id, id.length, item)]);
						price = remove(price, price[search(id, id.length, item)]);
						id = remove(id, item);
					
						System.out.println("Item " +item+ " has been removed");
						System.out.println("");
					} else {
						System.out.println("Item " +item+ " does not exist");
						System.out.println("");
					}
					
					break;
					
				// displays inventory table	
				case "D":
					sum = 0;
					
					System.out.println(String.format("%-10s %-10s %-10s", "ID", "Stock", "Unit Price"));
					
					// for loop that outputs each value of the array's index
					for (int k = 0; k < id.length && k < stock.length && k < price.length; k++) {
						System.out.println(String.format("%-10s %-10s %-10s", id[k], stock[k], price[k]));
						sum = sum +stock[k]*(Double.parseDouble(price[k]));
					}
					
					System.out.println("Total Inventory: " +fmt.format(sum));
					System.out.println("");
					break;

			} // END SWITCH CASE
			
			System.out.print("Enter letter of choice: ");
			input = scan.next();
		}

		// closes both scanners
		scan.close();
		fileScan.close();
	}
	
	// PRE: resize is passed an array and the desired size of the new array | POST: returns new array that has been resized
	public static String [] resize (String [] array, int newSize) {
		String [] temp = new String [newSize];				// creates an array with capacity of desired new size
		int nCopy = array.length;					// copies the number of values in array
		if (newSize < array.length)					// copies only the number of values of newSize if it is less than array.length
			nCopy = newSize;
		for (int k = 0; k < nCopy; k++)					// copies elements from old array to new array
			temp[k] = array[k];
		return temp;											
	}
	
	// PRE: resize is passed an array and the desired size of the new array | POST: returns new array that has been resized
	public static int [] resize (int [] array, int newSize) {
		int [] temp = new int [newSize];				// creates an array with capacity of desired new size
		int nCopy = array.length;					// copies the number of values in array
		if (newSize < array.length)					// copies only the number of values of newSize if it is less than array.length
			nCopy = newSize;
		for (int k = 0; k < nCopy; k++)					// copies elements from old array to new array
			temp[k] = array[k];
		return temp;											
	}
	
	// PRE: method is passed an array, integer, and item to check | POST: searches the array for a value and if found it equals true, else false
	public static boolean check (String [] array, int arrayLength, String item) {
		boolean found = false;						// sets found initially to false
		int k = 0;
		while (!found && k < arrayLength)						
			if ((array[k]).equals(item))				// item is found
				found = true;
			else k++;						// item not found, search next index
		if (found) return true;									
		else return false;
	}
	
	// PRE: method is passed an array, integer, and item | POST: searches the array for a value and if found it returns the index the value is at
	public static int search (int [] array, int arrayLength, int item) {
		boolean found = false;
		int k = 0;
		while (!found && k < arrayLength)						
			if ((array[k]) == item)					// item is found
				found = true;
			else k++;						// item not found, search next index
		if (found) return k;									
		else return -1;
	}
	
	// PRE: method is passed an array, integer, and item | POST: searches the array for a value and if found it returns the index the value is at
	public static int search (String [] array, int arrayLength, String item) {
		boolean found = false;
		int k = 0;
		while (!found && k < arrayLength)						
			if ((array[k]).equals(item))				// item is found
				found = true;
			else k++;						// item not found, search next index
		if (found) return k;									
		else return -1;
	}
	
	// PRE: method is passed an array and item to be inserted | POST: returns array with new item entered
	public static String [] insert (String [] array, String item) {
		array = resize(array, array.length+1);
		array[array.length-1] = item;					// inserts item into new index created from resizing
		return array;
	}
	
	// PRE: method is passed an array and item to be inserted | POST: returns array with new item entered
	public static int [] insert (int [] array, int item) {
		array = resize(array, array.length+1);
		array[array.length-1] = item;					// inserts item into new index created from resizing
		return array;
	}
	
	// PRE: passed an array and index of item to remove | POST: returns array with desired item removed
	public static String [] remove (String [] array, String item) {
		int value = search(array, array.length, item);
		int arrayLength = array.length;
		
		if (value != -1) {
			arrayLength--;
			array[value] = array[arrayLength];
		}
		
		array = resize(array, array.length-1);
		return array;
	}
	
	// PRE: passed an array and index of item to remove | POST: returns array with desired item removed
	public static int [] remove (int [] array, int item) {
		int value = search(array, array.length, item);
		int arrayLength = array.length;
		
		if (value != -1) {
			arrayLength--;
			array[value] = array[arrayLength];
		}
		
		array = resize(array, array.length-1);
		return array;
	}
}
