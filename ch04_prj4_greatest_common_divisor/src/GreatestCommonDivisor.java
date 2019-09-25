import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		System.out.println("Welcome to the Greatest Common Divisor App!");
		Scanner sc = new Scanner(System.in);
		String cont = "";
		
		do {
			System.out.print("Enter a number: ");
			int x =  sc.nextInt();
			System.out.print("Enter another number: ");
			int y = sc.nextInt();
			sc.nextLine();
			
			while(x != y) {
				if(x>y) {
					x -=y;
					
				}else {
					y -= x;
				}
				
				
			}
			System.out.println("Greatest common divisor: " + y);
			System.out.print("Continue? y/n: ");
			cont = sc.nextLine();
		}while (cont.equalsIgnoreCase("y"));
		System.out.println("Goodbye!");
		sc.close();
	}

}
