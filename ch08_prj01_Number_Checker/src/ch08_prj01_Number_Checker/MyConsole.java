package ch08_prj01_Number_Checker;

import java.util.Scanner;

public class MyConsole extends Console {

	public MyConsole() {
	}

	public static String getString(String prompt) {
		Scanner sc = new Scanner(System.in);
		boolean isValid = false;
		String s = "";
		System.out.print(prompt);
		while (!isValid) {
			if (sc.hasNext()) {
				s = sc.next(); // read user entry
				sc.nextLine(); // discard any other data entered on the line
				isValid=true;
			}else {
				System.out.println("You have to enter a value!");
				continue;
			}
		}
		sc.close();
		return s;
	}
}