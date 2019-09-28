package ch05_prj3_guessing_game;

import java.util.Scanner;

public class GuessingGameApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Guessing Game!\n");
		System.out.println("I'm thinking of a number from 1 to 100.");
		System.out.println("Try to guess it!\n");
		
		Scanner sc = new Scanner(System.in);
		String cont = "";
		
		do {
			int randomNum = (int)(Math.random()*100) +1;
			boolean isCorrect = false;
			int attempt = 0;
			
			while(!isCorrect) {
				int guess = getIntWithinRange(sc,"Guess a number: ",1,100);
				
				if(guess < (randomNum-10)) {
					System.out.println("Way too low, dummy");
					attempt++;
					continue;
				}
				if(guess < randomNum) {
					System.out.println("Too low.");
					attempt++;
					continue;
				}
				if(guess > randomNum+10) {
					System.out.println("Way too high!");
					attempt++;
					continue;
				}
				if(guess > randomNum) {
					System.out.println("Too high");
					attempt++;
					continue;
				}
				attempt++;
				isCorrect = true;
				}
			System.out.println("Congrats, you got it right and it only took you "+attempt+" tries.");
			if(attempt > 7) {
				System.out.println("What took you so long?");
			}else if (attempt > 3) {
				System.out.println("Not bad!");
			}else {
				System.out.println("You're a number guessing wizard!");
			}
			
			System.out.print("Continue? (y/n)");
			cont = sc.nextLine();
		}while(cont.equalsIgnoreCase("y"));
		
	System.out.println("Goodbye!");
	sc.close();
	}
	
	
	private static int getIntWithinRange(Scanner sc,String prompt,int min,int max) {
		boolean isValid = false;
		int input = 0;
		while(!isValid) {
			System.out.print(prompt);
			if(sc.hasNextInt()) {
				input = sc.nextInt();
			}else {
				System.out.println("I said give me an int, you idiot.");
				sc.nextLine();
				continue;
			}
			if(input < min) {
				System.out.println("Needs to be at least " + min + " , you idiot.");
				sc.nextLine();
				continue;
			}
			else if(input > max) {
				System.out.println("Need to be " + max + " or less, you idiot.");
				sc.nextLine();
				continue;
			}else {
				sc.nextLine();
				isValid = true;
			}
				
		}
		return input;
	}
}
