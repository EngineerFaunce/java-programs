// This program reads weather data from file input and produces a formatted file

import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;

public class A4WilliamFaunce {

	public static void main(String[] args) throws IOException {
		String town; // name of town
		String date = ""; // initializes the current date
		String windD; // wind direction
		String name; // name
		String firstI; // first initial
		String lastI; // last initial

		double temp; // air temperature
		double avgTemp = 0; // average temperature
		double minTemp = 0; // minimum temperature
		double maxTemp = 0; // maximum temperature
		double tTemp = 0; // temporary temperature
		double windS; // wind speed

		int count = 0; // integer used to count number of times loop runs
		int bCount = 0; // Bangor count
		int oCount = 0; // Orono count
		int cCount = 0; // Calais count

		String month = ""; // initializes month to be scanned later
		double avgMonth = 0; // initializes historical average to be scanned later

		DecimalFormat fmt = new DecimalFormat("#.00"); // formats doubles to two decimal places
		Scanner filescan = new Scanner(new FileReader("weather.txt")); // scanner used to scan weather.txt file
		Scanner file2scan = new Scanner(new FileReader("averages.txt")); // scanner used to scan averages.txt file
		PrintWriter writer = new PrintWriter(new File("weatherout.txt")); // writes output to specified file

		// processing and outputs
		writer.println("Weather Watch\n");

		writer.println(String.format("%-12s %-12s %-12s %-12s %-12s %-12s %-12s", "Town", "Date", "Temp", "Direction",
				"Wind Speed", "Wind Chill", "Reporter"));

		// scans and assigns inputs while the weather.txt has nonempty data sets
		while (filescan.hasNext()) {
			town = filescan.next().toUpperCase();
			date = filescan.next();
			temp = filescan.nextDouble();
			avgTemp += temp; // adds new temperature entry to calculate avgTemp later

			// used to determine maxTemp by comparing temp to temporary temp
			if (temp > tTemp)
				maxTemp = temp;

			// used to determine minTemp by comparing temp to temporary temp
			if (temp < tTemp)
				minTemp = temp;

			tTemp = temp;
			windD = filescan.next();
			windS = filescan.nextDouble();
			name = filescan.nextLine(); // reads the remainder of line
			name = name.trim(); // trims the spaces
			firstI = name.substring(0, 1); // reads first initial
			lastI = name.substring(name.lastIndexOf(" ") + 1, name.lastIndexOf(" ") + 2); // reads initial of last name

			count++; // increments the count to calculate avgTemp later

			// calculation for wind chill
			double windC = (35.74 + (0.6215 * temp) - (35.75 * (Math.pow(windS, 0.16)))
					+ (0.4275 * temp * (Math.pow(windS, 0.16))));
			writer.println(String.format("%-12s %-12s %-12s %-12s %-12s %-12s %-12s", town, date, fmt.format(temp),
					windD, fmt.format(windS), fmt.format(windC), firstI + lastI));

			// if statement used to determine number of readings per town/city
			if (town.equals("BANGOR"))
				bCount++;
			else if (town.equals("ORONO"))
				oCount++;
			else
				cCount++;
		}
		filescan.close(); // closes file scanner

		avgTemp /= count; // calculates average temperature

		writer.println("\nAverage Temperature: " + fmt.format(avgTemp));
		writer.println("Maximum Temperature: " + fmt.format(maxTemp));
		writer.println("Minimum Temperature: " + fmt.format(minTemp));

		writer.println("\nNumber of readings:");
		writer.println(String.format("%-10s %-5d", "BANGOR", bCount));
		writer.println(String.format("%-10s %-5d", "ORONO", oCount));
		writer.println(String.format("%-10s %-5d %n", "CALAIS", cCount));

		// scans and assigns inputs while averages.txt has nonempty data sets
		while (file2scan.hasNext()) {
			month = file2scan.next();
			avgMonth = file2scan.nextDouble();

			writer.println(String.format("%-10s %-10s", month, fmt.format(avgMonth)));
		}
		file2scan.close(); // closes file2 scanner

		// switch case to determine which month is being read from the weather.txt file
		switch (date.substring(0, 2)) {
			case "01": month = "January"; avgMonth = 24.92; break;
			case "02": month = "February"; avgMonth = 28.70; break;
			case "03": month = "March"; avgMonth = 45.91; break;
			case "04": month = "April"; avgMonth = 52.00; break;
			case "05": month = "May"; avgMonth = 68.90; break;
			case "06": month = "June"; avgMonth = 73.55; break;
			case "07": month = "July"; avgMonth = 78.63; break;
			case "08": month = "August"; avgMonth = 77.59; break;
			case "09": month = "September"; avgMonth = 68.40; break;
			case "10": month = "October"; avgMonth = 55.70; break;
			case "11": month = "November"; avgMonth = 45.75; break;
			case "12": month = "December"; avgMonth = 36.33; break;
		}

		// calculates difference from current month and historical average
		double diff = avgTemp - avgMonth;

		writer.println("\nDifference between this " + month + " from historical average is " + fmt.format(diff));
		writer.close(); // closes writer
	}

}
