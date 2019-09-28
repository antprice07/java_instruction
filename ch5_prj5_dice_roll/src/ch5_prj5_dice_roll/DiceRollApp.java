package ch5_prj5_dice_roll;

import java.util.Scanner;

public class DiceRollApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller!");
		
		System.out.print("Would you like to roll the dice? y/n: ");
		Scanner sc = new Scanner(System.in);
		String roll = sc.nextLine();
		int rollOne;
		int rollTwo;
		
		while(roll.equalsIgnoreCase("y")) {
			rollOne = DiceRollMethod.diceRoll();
			rollTwo = DiceRollMethod.diceRoll();
			String reply = diceString.diceStgMth(rollOne, rollTwo);
			System.out.println(reply);
			
			System.out.print("Roll again? ");
			roll = sc.nextLine();
		}
		sc.close();
		System.out.println("Thanks for playing!");

	}

}
