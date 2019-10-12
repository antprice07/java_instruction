package ui;

import java.util.Arrays;

import business.Student;
import util.Console;

public class StudentScoresApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Student Scores App");
		
		int nbr = Console.getInt("How many students? ", 0, 501);
		
		Student[] students = new Student[nbr];
		
		for(int i=0; i <nbr;i++) {
			String lastName = Console.getLine("Student Last Name: ");
			String firstName = Console.getLine("Student First Name: ");
			int score = Console.getInt("Student score: ",-1,101);
			Student s = new Student(lastName,firstName,score);
			students[i]=s;
		}
		Arrays.sort(students);
		int studentCount = 1;
		for(int i = 0;i<students.length;i++) {
			
			System.out.println("Student "+studentCount);
			System.out.println(students[i]);
			studentCount++;
		}
		
		System.out.println("Peace out!");
		
	}

}
