package ch5_prj5_dice_roll;

public class diceString {
	public static String diceStgMth (int rollOne,int rollTwo) {
		String reply;
		if(rollOne == 6 && rollTwo == 6) {
			reply = "Die 1:"+ rollOne + "\nDie 2: " + rollTwo + "\nTotal: " + (rollOne + rollTwo) + "\nBoxcars!";
		}else if(rollOne == 1 && rollTwo == 1) {
			reply = "Die 1:"+ rollOne + "\nDie 2: " + rollTwo + "\nTotal: " + (rollOne + rollTwo) + "\nSnake Eyes!";
		}else {
			reply = "Die 1:"+ rollOne + "\nDie 2: " + rollTwo + "\nTotal: " + (rollOne + rollTwo);
		}
		return reply;
	}

}
