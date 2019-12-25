import java.util.*;

public class JJ {
	private String type;						// type of journey the user wants
	private int distanceToDoor;					// distance JJ has to travel to reach exit
	private ArrayList<Integer> pogosticks;		// JJ's available pogosticks
	private ArrayList<Integer> costs;			// pogostick costs
	private ArrayList<Integer> coinLoc;			// coin location
	private ArrayList<Integer> coinAmt;			// coin amount
	private List<String> output;				// output of all combos/permutations
	
	// default constructor
	public JJ() {
		this.distanceToDoor = 0;
	}
	
	// parameterized constructor
	public JJ(String t, int distance, ArrayList<Integer> sticks, ArrayList<Integer> cost) {
		this.type = t;
		this.distanceToDoor = distance;
		this.pogosticks = sticks;
		this.costs = cost;
		this.output = new ArrayList<String>();
		
		switch(type) {
		case "E":
			enumeration(pogosticks, distanceToDoor);
			Collections.sort(output);
			System.out.println("# of combinations: " + output.size());
			for(int s=0; s < output.size(); s++)
				System.out.println(output.get(s));
			break;
		case "M":
			enumeration(pogosticks, distanceToDoor);
			System.out.println("Minimum cost journey(s): ");
			minCost(output);
			break;
		}
		
	}
	
	// parameterized constructor with coins
	public JJ(String t, int distance, ArrayList<Integer> sticks, ArrayList<Integer> cost, 
			ArrayList<Integer> coinL, ArrayList<Integer> coinA) {
		this.type = t;
		this.distanceToDoor = distance;
		this.pogosticks = sticks;
		this.costs = cost;
		this.output = new ArrayList<String>();
		this.coinLoc = coinL;
		this.coinAmt = coinA;
		
		switch(type) {
		case "E":
			enumeration(pogosticks, distanceToDoor);
			Collections.sort(output);
			System.out.println("# of combinations: " + output.size());
			for(int s=0; s < output.size(); s++)
				System.out.println(output.get(s));
			break;
		case "M":
			enumeration(pogosticks, distanceToDoor);
			System.out.println("Minimum cost journey(s): ");
			minCost(output);
			break;
		}
	}
	
	// given the array of pogosticks and distance, call helper method
	private void enumeration(ArrayList<Integer> array, int distance) {
	    ArrayList<Integer> temp = new ArrayList<>();
	    enumHelper(array, 0, distance, 0, temp);
	}
	
	// recursive method for finding possible journeys and their permutations
	private void enumHelper(ArrayList<Integer> pogos, int index, int distance, int sum, ArrayList<Integer> list){
		// ends recursion
		if(sum > distance)
	        return;
	 
		// if a combination of pogosticks reach the door, output it
	    if(sum == distance) {
	    	// this will prevent wasting time by not permuting 1 1 1, for example
	    	int [] check = new int [list.size()];
	    	for(int m=0; m < check.length; m++)
	    		check[m] = list.get(m);
	    	
	    	// if a combo uses different pogosticks, show permutations
	    	// else just output the combination
			if(checkArray(check) == false)
				findPermutations(list, 0, check.length);
			else
				addCombo(list);
	        return;
	    }
	    
	    // creates list containing values that add to given distance
	    for(int j=index; j<pogos.size(); j++) {
	        list.add(pogos.get(j));
	        enumHelper(pogos, j, distance, sum+pogos.get(j), list);
	        list.remove(list.size()-1);
	    }
	}
	
	// determines the journey(s) with the lowest cost
	private void minCost(List<String> outputList) {
		String [] findMin = outputList.get(0).split(" ");
		int min = Integer.parseInt(findMin[0]);
		
		for(int i=1; i<outputList.size(); i++) {
			findMin = outputList.get(i).split(" ");
			
			int curr = Integer.parseInt(findMin[0]);
			if(curr < min)
				min = curr;
		}
		
		for(int j=0; j < outputList.size(); j++) {
			String [] check = outputList.get(j).split(" ");
			int checkVal = Integer.parseInt(check[0]);
			if(min == checkVal) {
				System.out.println(outputList.get(j));
			}
				
		}
		
				
		
		/*
		 * alright, we gotta call .split on each string in outputList
		 * then compare [0] against every other [0] index to find the min
		 * then we can print the journey(s) from outputList that contain the min value
		 */
		
	}
	
	// finds distinct permutations and adds them to output
    private void findPermutations(ArrayList<Integer> list, int index, int n) { 
        if (index >= n) { 
        	addCombo(list);
            return; 
        } 
  
        for (int i = index; i < n; i++) { 
            // prevents an index value from swapping with an identical value
            boolean check = shouldSwap(list, index, i); 
            if (check) {
                swap(list, index, i); 
                findPermutations(list, index + 1, n); 
                swap(list, index, i); 
            } 
        } 
    }
    
    // method for adding a combo to the output
    private void addCombo(ArrayList<Integer> list) {
    	String out = "";
    	int pathCost = 0;
    	for(int k: list) {
    		if(pogosticks.contains(k)) {
				int tempIndex = pogosticks.indexOf(k);
				pathCost += costs.get(tempIndex);
			}
    		out += k + " ";
    	}
    	String newOut = pathCost + " " + out;
    	output.add(newOut);
    }
    
    // prevents a number from swapping with an identical number
    private boolean shouldSwap(ArrayList<Integer> arr, int start, int curr) { 
        for (int i = start; i < curr; i++) { 
            if (arr.get(i) == arr.get(curr))
                return false;
        } 
        return true; 
    } 
  
    // swaps the values of two indexes
    private void swap(ArrayList<Integer> arr, int a, int b) { 
        int c = arr.get(a); 
        arr.set(a, arr.get(b));
        arr.set(b, c); 
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
