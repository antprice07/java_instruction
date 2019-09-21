import java.util.Scanner;


public class FizzBuzzApp {

	public static void main(String[] args) {
		String number;
		String Fizz = "Fizz";
		String Buzz = "Buzz";
		String FizzBuzz = "FizzBuzz";
		String cont = "y";
		int count;
		Scanner sc = new Scanner(System.in);
		while(cont.equalsIgnoreCase("y")) {
			System.out.println("Welcome to FizzBuzz!");
			System.out.print("Enter an integer: ");
			count = sc.nextInt();
			sc.nextLine();
			
			for (int i = 1; i <= count; i++) {
			
				if(i % 3 == 0 && i % 5 == 0) {
					number = FizzBuzz;		
				} else if(i % 3 == 0) {
					number = Fizz;
				} else if(i % 5 == 0) {
					number = Buzz;
				} else {
					number = Integer.toString(i);
				}
			System.out.print(number + " ");
			}	
			System.out.print("\nContinue? y/n: ");
			cont = sc.nextLine();		
		}
		System.out.println("Goodbye");
		sc.close();
	}

}
