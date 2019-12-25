import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// this will read the user's input into appropriate variables
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the type of journey, distance to the door, and available pogosticks plus their cost: ");
		String [] temp = scan.nextLine().split(" ");
		scan.close();
        
		String type = temp[0];
		int distanceToDoor = Integer.parseInt(temp[1]);
        
        // if JJ doesn't have to move then there is exactly one way to do that
        if(distanceToDoor == 0) {
        	System.out.println("# of combinations: 1");
        	System.exit(1);
        }
        // otherwise read pogosticks and their costs into appropriate array lists
        ArrayList<Integer> costs = new ArrayList<Integer>();
        ArrayList<Integer> pogosticks = new ArrayList<Integer>();
        ArrayList<Integer> coinLoc = new ArrayList<Integer>();
        ArrayList<Integer> coinVal = new ArrayList<Integer>();
        
        for(int i=2; i < temp.length; i+=2) {
        	if(Integer.parseInt(temp[i])>=0) {
        		costs.add(Integer.parseInt(temp[i]));
            	pogosticks.add(Integer.parseInt(temp[i+1]));
        	}
        	else {
        		coinLoc.add(Integer.parseInt(temp[i]));
        		coinVal.add(Integer.parseInt(temp[i+1]));
        	}
        	
        }
        
        // creates a new JJ object which will output everything
        if(coinLoc.isEmpty())
        	new JJ(type, distanceToDoor, pogosticks, costs);
        else
        	new JJ(type, distanceToDoor, pogosticks, costs, coinLoc, coinVal);
	}

}
