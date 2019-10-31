package ui;

import business.JUnitTesting;
import util.Console;

public class JUnitTestingApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the JUnit Testing App");
		
		int i = Console.getInt("Give us an integer to find the square: ");
		JUnitTesting jut = new JUnitTesting();
		i=jut.square(i);
		System.out.println("Answer: "+ i);
		String str = Console.getString("Now give us a word or sentence: ");
		int aCount = jut.countA(str);
		System.out.println("Your entry contains "+aCount+" 'a's.");

	}

}
