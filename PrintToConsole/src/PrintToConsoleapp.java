import java.util.Scanner;

public class PrintToConsoleapp {

	
	public static void main(String[] args) {
		System.out.println("Welcome to the Console demo app!");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
		
		int number1;
		int number2;
		
		System.out.print("Input whole number:");
		number1 = sc.nextInt();
		
		System.out.print("Input another whole number:");
		number2 = sc.nextInt();
		System.out.print("Enter a sentence: ");
		String word1 = sc.next();
		String word2 = sc.next();
		String word3 = sc.next();
		String restOfSentence = sc.nextLine();
		
		System.out.println(word1);
		System.out.println(word2);
		System.out.println(word3);
		System.out.println(restOfSentence);
		
		int sum = number1 + number2;
		
		System.out.println("Enter a double: ");
		double decimal = sc.nextDouble();
		
		if (decimal > 50.0) {
			System.out.println(decimal + " is greater than 50");
			
		} else if (decimal < 50.0) {
			System.out.println(decimal + " is less than 50.0");
		}
		else {
			System.out.println(decimal + " is 50.0");
		}
	
		
		System.out.println("Your total is " + sum);
		
		System.out.println("Continue? (y\\n): ");
		choice = sc.nextLine();
		
		
		}
		
		System.out.println("Thanks for playing!!!");
		
		sc.close();
		

	}

}
