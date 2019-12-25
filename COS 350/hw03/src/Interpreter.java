
import java.util.Scanner;

public class Interpreter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter an even-numbered sequence of 2m integers: ");
		String input = scan.nextLine();
		
		new JJIsland(input);
		
		scan.close();

	}

}
