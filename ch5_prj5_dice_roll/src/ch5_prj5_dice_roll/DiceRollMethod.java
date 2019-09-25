package ch5_prj5_dice_roll;
import java.lang.Math;

public class DiceRollMethod {

	public static int diceRoll() {
		return (int)(Math.random() * 6) + 1;
	}
}
