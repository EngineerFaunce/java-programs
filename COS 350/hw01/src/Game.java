
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// this will read the user's input into appropriate variables
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the distance to the door and available pogo-sticks: ");
		String [] temp = scan.nextLine().split(" ");
		scan.close();
        
		int distanceToDoor = Integer.parseInt(temp[0]);
        
        // if JJ doesn't have to move then there is exactly one way to do that
        if(distanceToDoor == 0) {
        	System.out.println("# of combinations: 1");
        	System.exit(1);
        }
        // otherwise read pogosticks and their costs into appropriate arrays
        int [] pogosticks = new int [temp.length-1];
        //int [] costs = new int [(temp.length-2)/2];
        
        for(int i=1; i < temp.length; i++) {
        	pogosticks[i-1] = Integer.parseInt(temp[i]);
        }
        
        // creates a new JJ object which will output everything
        new JJ(distanceToDoor, pogosticks);
	}

}
