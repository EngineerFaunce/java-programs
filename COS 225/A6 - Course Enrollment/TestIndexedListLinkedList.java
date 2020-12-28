import java.io.*;
import java.util.Scanner;

public class TestIndexedListLinkedList {

	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner (System.in);
		IndexedListLinkedList<String> list = new IndexedListLinkedList<String> ( );
		
		list.addLast("a");
		list.addLast("b");
		list.addLast("*");
		list.addLast("c");
		
		System.out.println("Tester by Your Name");
		System.out.println("Original list: " + list.toString());
		
		// test remove method
		list.remove("*");				// element * is found and removed
		list.remove("d");				// element d is not found and nothing done
		System.out.println("List after remove: " + list.toString());
		
		// test first and last
		System.out.println("First element: " + list.first());
		System.out.println("Last element: " + list.last());
		
		// test contains
		if (list.contains("b")) System.out.println("List contains b");
		else System.out.println("List does not contain b");
		if (list.contains("d")) System.out.println("List contains d");
		else System.out.println("List does not contain d");
		
		// test indexOf
		System.out.println("Index of b is: " + list.indexOf("b"));
		System.out.println("Index of d is: " + list.indexOf("d"));
		
		// test get 
		System.out.println("String at position 1 is: " + list.get(1));
		
		// test set
		list.set(1, "*");
		System.out.println("List after set position 1 to *: " + list.toString());
		
		// test invalid position
		try {
			System.out.println("Element at position 1000 is: " + list.get(1000));
		}
		catch (InvalidPositionException e)
		{
			System.out.println(1000 + " " + e.getMessage());
		}
		finally {
			System.out.println("Test program is ending.");
		}
		
		
			
		
		
		
		
		
		scan.close();
	}
}

