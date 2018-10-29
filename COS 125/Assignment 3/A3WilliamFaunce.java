//William Faunce
//This program performs computations on a sample of skis

import java.util.Scanner;
import java.text.NumberFormat;

public class A3WilliamFaunce {

	public static void main(String[] args) {
		
		int datap = 0;								//initializes data-points
		int loopC = 0;								//initializes loop count to determine how many times loop will run
		int rejSkis = 0;							//initializes rejected ski number
		
		String datapCount;							//initializes datap string to convert to integer later
		String skiID = "";							//initializes string for ski ID
		String skiAbr = "";							//initializes ski abbreviation so console only reads the component letters
		
		double frco = 0.0;							//initializes friction coefficient
		double avgFrco = 0.0;						//initializes double used to produce average frco at end
		String frcoCount = "";						//initializes frco string to be converted later
		
		double cost = 0.0;							//initializes double so that cost of rejected skis can be calculated
		final double RC = 21.99;					//cost of RC component
		final double ED = 24.99;					//cost of ED component
		
		Scanner scan = new Scanner(System.in);						//scanner for user input
		NumberFormat fmtC = NumberFormat.getCurrencyInstance();		//used to display a dollar sign ($)
		NumberFormat fmtP = NumberFormat.getPercentInstance();		//used to display percentage (%)
		
		System.out.println("Programmer: William Faunce");
		System.out.println("");
		
		//causes loop if number entered is less than or equal to 0
		do {
			System.out.print("Enter number of data points: ");
			datapCount = scan.nextLine();
			datap = Integer.parseInt(datapCount);			//converts string entered into an integer
			loopC = Integer.parseInt(datapCount);			//sets loop count equal to the number the user entered
		} while (datap <= 0);
		
		//loop that runs depending on number entered in first prompt
		do {
		
			//causes loop if ski ID entered does not equal RC or ED
			do {
				System.out.print("Enter ski ID: ");
				skiID = scan.nextLine();
				skiAbr = skiID.substring(0, 2);
			} while (!skiAbr.equals("RC") && !skiAbr.equals("ED"));
		
			//causes loop if friction coefficient is less than or equal to 0
			do {
				System.out.print("Enter friction coefficient for ski "+skiID +": ");
				frcoCount = scan.nextLine();
				frco = Double.parseDouble(frcoCount);		//converts string entered into a double
				
			} while (frco <= 0);
		
			avgFrco = avgFrco + frco;						//adds each instance of frco to the total so that average can be taken later
			
			//prints component cost based on model number
			if (skiAbr.equals("RC")) {
				System.out.print("Component cost for ski "+skiID+": "+fmtC.format(RC));
			} else {
				System.out.print("Component cost for ski "+skiID+": "+fmtC.format(ED));
			}
			
			
			if (frco > 1.23) {
				System.out.print(" <--- REJECT");		//prints reject if friction coefficient exceeds 1.23
				++rejSkis;								//adds 1 to the count of rejected skis
				if (skiAbr.equals("RC")) {
					cost = cost + RC;					//adds cost of RC component to total cost
				} else {
					cost = cost + ED;					//adds cost of ED component to total cost
				}
			}
			
			System.out.println("");
			System.out.println("");
			--loopC;									//decrements loopC so that it will only run (datap) times
			
		} while (loopC > 0);
		
		avgFrco = (avgFrco/(double)datap);				//calculates the average friction coefficient
		double perc = (double)rejSkis/(double)datap;	//calculates percent of rejected skis
		
		//final outputs
		System.out.println("Number of Data Points: "+datap);
		System.out.println("Average Friction Coefficient: "+avgFrco);
		System.out.println("Number of rejected skis: "+rejSkis);
		System.out.println("Percentage of rejected skis: "+fmtP.format(perc));
		System.out.println("Cost of rejected skis: "+fmtC.format(cost));
		
		scan.close();						//closes scanner
	}

}
