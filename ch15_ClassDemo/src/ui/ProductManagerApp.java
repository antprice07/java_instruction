package ui;

import java.text.NumberFormat;
import java.util.List;

import business.Product;
import db.DAO;
import db.ProductTextFile;
import util.Console;

public class ProductManagerApp {

	private static DAO<Product> productFile = new ProductTextFile();
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Product Manager");
		displayMenu();
		
		String command = "";
		while(!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Enter a command: ");
			switch(command) {
			case "list":
				displayAllProducts();
				break;
			case "add":
				addProduct();
				break;
			case "del":
				deleteProduct();
				break;
			case "help":
				displayMenu();
				break;
			case "exit":
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid command.");
				break;
			}
		}
		
		

	}
	
	private static void displayMenu() {
		System.out.println("COMMAND MENU");
		System.out.println("list    - List all products.");
		System.out.println("add     - Add a product");
		System.out.println("del     - Delete a product");
		System.out.println("help    - Show this menu");
		System.out.println("exit    - Exit this application");
	}
	
	private static void displayAllProducts() {
		System.out.println("PRODUCT LIST");
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		List<Product> products = productFile.getAll();
		StringBuilder sb = new StringBuilder();
		for(Product p : products) {
			sb.append(p.getCode()+"\t"+p.getDescription()+ "\t" + currency.format(p.getPrice())+"\n");
		}
		System.out.println(sb);
	}
	
	private static void addProduct() {
		String code = Console.getString("Enter code: ");
		String desc = Console.getString("Description: ");
		double price = Console.getDouble("Enter price: ");
		
		Product p = new Product(code,desc,price);
		boolean wasSuccessful = productFile.add(p);
		if(wasSuccessful) {
			System.out.println("Successfully added "+ desc);
		}else {
			System.out.println("Error adding "+ desc);
		}
	}
	
	private static void deleteProduct() {
		String code = Console.getString("Product code to delete? ");
		
		Product p = productFile.get(code);
		if (p!=null) {
			productFile.delete(p);
			System.out.println(p.getDescription()+ " has been deleted.");
		}else {
			System.out.println("No product found for code: "+code);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
