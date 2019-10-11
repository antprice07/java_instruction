package ui;

import java.util.Arrays;

public class ArraysDemoApp {

	public static void main(String[] args) {
		
		double[] prices = new double[4];
		prices[0]=14.95;
		prices[1]=12.95;
		prices[2]=11.95;
		prices[3]=9.95;
		
		for(int i = 0;i<prices.length;i++) {
			System.out.println(prices[i]);
		}
		
		String[] students = {"Brytt","Anthony","Joelle","Fred","Karlee","Justin"};
		for(int i = 0;i<students.length;i++) {
			System.out.print(students[i]+" ");
		}
		
		String[] letters = new String[10];
		Arrays.fill(letters, "a");
		
		for(String str: letters) {
			System.out.println(str);
		}
		
		System.out.println("Sorted students:");
		Arrays.sort(students);
		for(String student: students) {
			System.out.print(student + " ");
		}
		
	}

}
