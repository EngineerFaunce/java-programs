import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
    public static void main(String args []) {
    	Scanner scan = new Scanner(System.in);

        System.out.println("Enter a sequence of 2m integers (4 pairs minimum): ");
        String [] input = scan.nextLine().split(" ");
        scan.close();
        
        // program needs to generate 4 columns to meet assignment requirements
        if(input.length < 8)
        	System.out.print("# of combinations: 0");
        else {
        	HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();	// hash map for storing radii of column with associated height
        	
        	// for loop to read input into hash map
            for(int i = 0; i < input.length; i += 2)
            	list.put(Integer.parseInt(input[i+1]), Integer.parseInt(input[i]));
            
            int temp [] = new int[list.size()];
            int counter = 0;								// counter for iterating through temp array
            for(int key : list.keySet()) {
            	temp[counter] = key;
            	counter++;
            }
            // creates new Chamber object that will perform recursive function on user input
            Chamber chamber = new Chamber(temp, temp.length, list);
            
            // OUTPUT
            System.out.println(chamber.getOutput().size());
            for(int k=0; k < chamber.getOutput().size(); k++) {
            	System.out.println(chamber.getOutput().get(k));
            }
            
        }
        
    }
    
}
