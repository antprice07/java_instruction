import java.util.Scanner;
import java.lang.Math;


public class TravelTimeCalculatorApp {

	public static void main(String[] args) {
		
		String cont = "y";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Travel Time Calculator?");
		
		double miles;
		double mph;
		
		int hours,minutes;

		while (cont.equalsIgnoreCase("y")) {
			System.out.print("Enter miles: ");
			miles = sc.nextDouble();
			System.out.print("Enter miles per hour: ");
			mph = sc.nextDouble();
			
			sc.nextLine();
			
			hours = (int) miles / (int) mph;
			minutes = (int) miles % (int) mph;
			
			System.out.println("Estimated travel time /n -------------"
					+ "/n Hours: /nMinutes: ");
			
			System.out.println("Continue? y/n");
			cont = sc.nextLine();
			
		}
		
		System.out.println("Thank you for participating!");

	}

}
                                                                