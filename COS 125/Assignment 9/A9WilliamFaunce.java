// William Faunce
// This program calculates the cost of shipping snow globes based on box dimensions

package boxProgram;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class A9WilliamFaunce {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);									// scanner for user input
		NumberFormat currency = new DecimalFormat("$0.00");						// format for adding a $ sign for pricing
		
		// shipping box dimensions
		int length = 0;
		int width = 0;
		int height = 0;
		
		int snowGlobeSize = 0;													// dimension of snow globe
		int globeCount = 0;														// amount of snow globes that user wants shipped
		int maxGlobeCount = 0;													// maximum amount of globes that can fit in a box
		int boxCount = 0;														// amount of shipping boxes needed
		
		double boxCost = 0.00;													// cost of shipping box
		double materialCost = 0.00;												// initializes cost of packing material in output
		final double MATERIAL = 0.0023;											// cost of packing material
		final double WRAP = 0.0012;												// cost of plastic wrap
		
		Box ship = new Box();													// shipping box
		Box globe = new Box();													// snow globe box
		
		// error checking loop that repeats if box dimensions are not valid
		do {
			System.out.print("Enter length, width, height of ship box: ");
			
			// reads dimensions for shipping box
			length = scan.nextInt();
			width = scan.nextInt();
			height = scan.nextInt();
			
			ship = new Box(length, width, height);								// sets shipping box to user's desired dimensions
		} while (((length % 4) != 0) || ((width % 4) != 0) || ((height % 4) != 0) || (ship.getLength() < 0 || ship.getWidth() < 0 || ship.getHeight() < 0));

		// error checking loop for a valid price
		do {
			System.out.print("Enter box cost: ");
			boxCost = scan.nextDouble();
		} while (boxCost <= 0);
		
		// error checking loop to make sure the snow globe can fit inside the shipping box
		do {
			System.out.print("Enter dimension of snow globe: ");
			snowGlobeSize = scan.nextInt();
			
			// sets length, width, and height to the number entered
			globe.setLength(snowGlobeSize);
			globe.setWidth(snowGlobeSize);
			globe.setHeight(snowGlobeSize);
		} while ((snowGlobeSize % 4 != 0) || (globe.getLength() > ship.getLength()) || (globe.getWidth() > ship.getWidth()) || (globe.getHeight() > ship.getHeight()));
		
		do {
			System.out.print("Enter number of snow globes to ship (0 to quit): ");
			globeCount = scan.nextInt();
			maxGlobeCount = Box.maxAmountOfGlobes(ship.getLength(), ship.getWidth(), ship.getHeight(), snowGlobeSize);
			
			// if loop that breaks out of do-while loop if user inputs 0
			if (globeCount == 0)
				continue;
			
			// if the amount of snow globes fits inside 1 shipping box then only 1 shipping box is needed, else increase the needed box amount
			if (globeCount <= maxGlobeCount)
				boxCount = 1;
			else {
				int temp = maxGlobeCount;
				boxCount = 1;
				while (globeCount > temp) {
					temp = maxGlobeCount + temp;
					boxCount++;
				}
			}
			
			double wrapCost = Box.surfaceArea(ship.getLength(), ship.getWidth(), ship.getHeight()) * WRAP;				// calculates cost of plastic wrap needed
			double shipVol = Box.volume(ship.getLength(), ship.getWidth(), ship.getHeight());							// calculates shipping box volume
			double globeVol = Box.volume(globe.getLength(), globe.getWidth(), globe.getHeight());						// calculates snow globe box volume
			
			// if loop that calculates cost of packing material for partially filled boxes
			if (globeCount % maxGlobeCount > 0)
				materialCost = (shipVol - (globeVol * (globeCount % maxGlobeCount))) * MATERIAL;
			else
				materialCost = 0.00;			// resets materialCost to 0 or else it will causes pricing errors
			
			String total = currency.format(boxCost * boxCount + wrapCost * boxCount + materialCost);
			// OUTPUT
			System.out.println("");
			System.out.println("Number of snow globes: " +globeCount);
			System.out.println("-------------------------");
			System.out.println("Number of shipping boxes needed: " +boxCount);
			System.out.println("Cost of box: " +currency.format(boxCost));
			System.out.println("Cost of packing material: " +currency.format(materialCost));
			System.out.println("Cost of plastic wrap: " +currency.format(wrapCost * boxCount));
			System.out.println("Total Cost: " +total);
			System.out.println("");
			boxCount = 1;						// resets boxCount to 1 so the user can enter new data on next loop
		} while(globeCount != 0);
		
		scan.close();							// closes scanner
	}
}
