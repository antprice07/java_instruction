import java.util.Scanner;


public class FactorialCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Factorial Calculator!");
		
		Scanner sc = new Scanner(System.in);
		
		String cont = "y";
		
		int count,fact;
		
		while(cont.equalsIgnoreCase("y")) {
							
			System.out.print("Please enter an integer: ");
			count = sc.nextInt();
			sc.nextLine();
			
			for(int i = 1;i <= count;i++) {
					fact = i * i;				
			}
		System.out.println("The factorial of " + count + " is " + fact);
		
		System.out.print("Continue? y/n: ");
		}
		System.out.println("Goodbye!");
		sc.close();
	}

}
