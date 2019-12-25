import java.util.ArrayList;
import java.util.HashMap;

public class Chamber {

	public Chamber(int [] temp, int length, HashMap<Integer, Integer>list) {
		findCombo(temp, length, list);
	}
	
	private ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
	
	public ArrayList<ArrayList<String>> getOutput() {
		return output;
	}
	
	/* method for finding combinations of ascending column
	 * 
     * array[]  	---> Input Array
     * data[] 		---> Temporary array to store current combination 
     * start & end 	---> Starting and ending indexes in array[]
     * curr  		---> Current index in data[]
     */
    public void combinations(int array[], int combos[], int start, int end, int curr, HashMap<Integer, Integer> map) {
	        // current combination is ready to be printed, print it 
	        if (curr == 4) {
	        	ArrayList<String> currCombo = new ArrayList<String>();
	            for (int j = 0; j < 4; j++) {
	            	for(int key : map.keySet()) {
	            		if(key == combos[j])
	            			currCombo.add(map.get(key) + "");		// builds current combo
	            	}
	            }
	            output.add(currCombo);								// adds combo to output
	            return; 
	        } 
	
	        // method that iterates through each index, calling recursively on every index after
	        for (int i=start; i<=end && end-i >= 4-curr; i++) { 
	        	combos[curr] = array[i];
	        	combinations(array, combos, i+1, end, curr+1, map);
	        }
        
    } 
  
    public void findCombo(int array[], int arrayLength, HashMap<Integer, Integer> map) { 
        // a temp array to store combinations
    	int combos[] = new int[4]; 
  
        // print all combination using temporary array 'combos[]' 
        combinations(array, combos, 0, arrayLength, 0, map); 
    }
}
