package assignment10;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.*;

public class TestHashTable {

	public static void main(String[] args) throws IOException
	{
		Scanner filescan  = new Scanner (new FileReader("words.txt"));					// input file
		ArrayList<String> a = new ArrayList<String> ();									// array of words used for testing
																			
		String word;																	// one word from input file
		HashTable dictionary;															// dictionary of words
		long start;																		// start time
		long end;																		// end time
			
		dictionary = new HashTable ();													// hashtable of all words
		int count = 0;	
		
		start = System.currentTimeMillis( );				
		while (filescan.hasNext())														// while more words...
		{	word = filescan.nextLine();													// get word from file
			a.add(word);																// add word to array list for testing
			dictionary.insert (word);													// insert word into hash table
			count++;
		}
		end = System.currentTimeMillis( );
		
		filescan.close();
		System.out.println("Number of words read from file: " + count);
		System.out.println (dictionary.getSize() + " words inserted into dictionary using hash __");	// fill in 1 or 2 for hash function used	
		System.out.println ("Construction of hash table took: " + (end-start) + " ms");
		System.out.println ("Hash table capacity = " + dictionary.getCapacity());
		System.out.println ("Hash table load factor = " + dictionary.getLoadFactor());
			
		for (int k=0; k<a.size(); k++)													// test that each word is in the hash table
		{	word = a.get(k);															// get the word from array list
			if (!dictionary.isPresent(word))											// is word in dictionary?
			{	System.out.println("Fatal error " + word + " is not found");
				System.exit(1);															// end the program
			}
		}
		System.out.println ("Successful check that all words in file are in the hash table");
		System.out.println();
		
		Scanner scan = new Scanner (System.in);											// let user search for words using xxx as sentinel to stop loop
		System.out.print("Enter word xxx to quit: ");
		word = scan.nextLine();
		while (!word.equals("xxx"))
		{	boolean found = dictionary.isPresent(word);
			if (found)
				System.out.println("Found word " + word + " at index " +  dictionary.getIndex(word) + " with probe count: " + dictionary.getNProbes(word));
			else
				System.out.println("Word " + word + " is not found with probe count: " + dictionary.getNProbes(word));  
			System.out.print("\nEnter word xxx to quit: ");
			word = scan.nextLine();
		}
		scan.close();
	}
}
