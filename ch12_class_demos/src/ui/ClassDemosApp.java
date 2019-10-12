package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Console;

public class ClassDemosApp {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(5);
		numbers.add(20);
		numbers.addAll(Arrays.asList(67,32,13,2));
		
		
		System.out.println(numbers);
		System.out.println("size = "+numbers.size());
		
		//int idx=Console.getInt("Index position to remove?");
		//numbers.remove(idx);
		//System.out.println(numbers);
		
		System.out.println(numbers.contains(67));
		System.out.println(numbers.contains(11));

		List<String> students = new ArrayList<>();
		String name = "";
		while(!name.equalsIgnoreCase("exit")) {
			name = Console.getLine("Name? ");
			if(!name.equalsIgnoreCase("exit")) {
				students.add(name);
			}
		}
		System.out.println("list of students:");
		System.out.println(students);
		
		String s = "Karlee";
		System.out.println(students.indexOf(s));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
