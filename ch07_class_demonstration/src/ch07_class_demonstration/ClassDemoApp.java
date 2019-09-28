package ch07_class_demonstration;

import java.util.Scanner;

public class ClassDemoApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the demo app!");
		Scanner sc = new Scanner(System.in);
		
		Product prod1 = new Product();
		System.out.print("Enter product code: ");
		prod1.setCode(sc.nextLine());
		System.out.print("Enter product description: ");
		prod1.setDescription(sc.nextLine());
		System.out.print("Enter product price: ");
		prod1.setPrice(sc.nextDouble());
		
		System.out.println(prod1.getCode());
		System.out.println(prod1.getDescription());
		System.out.println(prod1.getPrice());
		
		System.out.println(prod1.toString());
		
	}

}
