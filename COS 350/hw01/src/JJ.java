
import java.util.*;

public class JJ {
	private int distanceToDoor;					// distance JJ has to travel to reach exit
	private int [] pogosticks;					// JJ's available pogo-sticks
	private int counter;						// counter for number of combinations
	private String out;							// "combo builder" for output
	private List<String> output;				// output of all combos/permutations
	
	// default constructor
	public JJ() {
		this.distanceToDoor = 0;
	}
	
	// parameterized constructor
	public JJ(int distance, int [] sticks) {
		this.distanceToDoor = distance;
		this.pogosticks = sticks;
		this.counter = 0;
		this.out = "";
		this.output = new ArrayList<String>();
		
		enumeration(pogosticks, distanceToDoor);
		Collections.sort(output);
		System.out.println("# of combinations: " + counter);
		for(int s=0;s < output.size(); s++)
			System.out.println(output.get(s));
	}
	
	// given the array of pogosticks and distance, call helper method
	private void enumeration(int[] array, int distance) {
	    List<Integer> temp = new ArrayList<>();
	    
	    Arrays.sort(array);
	    enumHelper(array, 0, distance, 0, temp);
	}
	
	// recursive method for finding possible journeys and their permutations
	private void enumHelper(int[] pogos, int index, int distance, int sum, List<Integer> list){
		// ends recursion
		if(sum > distance)
	        return;
	 
		// if a combination of pogo sticks reach the door, output it
	    if(sum == distance) {
	    	
	    	/* this will check if a combination only uses 1 pogo stick or the same pogo stick 
	    	 * so that we don't have to waste time permuting that combo
	    	 */
	    	
	    	int [] check = new int [list.size()];
	    	
	    	for(int m=0; m < check.length; m++)
	    		check[m] = list.get(m);
	    	
	    	// if a combo uses different pogosticks, show permutations
	    	// else just output the combination
			if(checkArray(check) == false) {
				findPermutations(check, 0, check.length);
				counter -= 1;	// solves a off by 1 error that I couldn't find
			}
			else {
				for(int i: list) 
					out += i + " ";
				output.add(out);
				out = "";
	    	}
			
	    	counter += 1;
	        return;
	    }
	    
	    for(int j=index; j<pogos.length; j++) {
	        list.add(pogos[j]);
	        enumHelper(pogos, j, distance, sum+pogos[j], list);
	        list.remove(list.size()-1);
	    }
	}
	
	// Prints all distinct permutations in str[0..n-1]  
    private void findPermutations(int [] arr, int index, int n) { 
        if (index >= n) { 
        	for(int k: arr)
        		out += k + " ";
        	output.add(out);
        	out = "";
        	counter += 1;
            return; 
        } 
  
        for (int i = index; i < n; i++) { 
            // checks if an index should swap with another 
            boolean check = shouldSwap(arr, index, i); 
            if (check) { 
            	
                swap(arr, index, i); 
                findPermutations(arr, index + 1, n); 
                swap(arr, index, i); 
            } 
        } 
    } 
    
    // prevents a number from swapping with an identical number
    private boolean shouldSwap(int [] arr, int start, int curr) { 
        for (int i = start; i < curr; i++) { 
            if (arr[i] == arr[curr])
                return false;
        } 
        return true; 
    } 
  
    // swaps the values of two indexes
    private void swap(int [] arr, int a, int b) { 
        int c = arr[a]; 
        arr[a] = arr[b]; 
        arr[b] = c; 
    } 
	
	
	// method for checking if the array only contains the same value
	public static boolean checkArray(int [] array) {

        // simple check if the array only contains 1 element
        if (array.length == 1)
            return true;

        int element = array[0]; // element to compare everything to

        // checking all other elements
        for (int i = 1; i < array.length; i++) {
            if (array[i] != element)
                return false;
        }

        return true;

    }
    
}
