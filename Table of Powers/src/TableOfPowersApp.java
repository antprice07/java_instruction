import java.util.Scanner;


public class TableOfPowersApp {

	public static void main(String[] args) {
		String cont = "y";
		
		Scanner sc = new Scanner(System.in);
		
		int integer;
		System.out.println("Welcome to the Table of Powers!");
		
		while(cont.equalsIgnoreCase("y")) {
			System.out.print("Enter an integer: ");
			integer = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Number\t\t" + "Squared\t\t" + "Cubed\n" 
					+ "======\t\t" + "=======\t\t" + "=====");
			
			for(int i = 1;i <= integer;i++) {
			int square = i * i;
			int cube = i * i * i;
			
			System.out.println(i + "\t\t" + square + "\t\t" + cube);
			
			}
			System.out.print("Continue? y/n: ");
			cont = sc.nextLine();
		}
		System.out.println("Thank you for playing. Goodbye!");
		sc.close();

	}

}
