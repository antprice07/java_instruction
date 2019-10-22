package ui;

import java.text.NumberFormat;
import java.util.List;

import business.Product;
import business.User;
import db.DAO;
import db.ProductTextFile;
import db.UserTextFile;
import util.Console;

public class ProductManagerApp {

	private static DAO<Product> productFile = new ProductTextFile();
	private static DAO<User> userFile = new UserTextFile();

	public static void main(String[] args) {

		System.out.println("Welcome to the Product Manager");

		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			displayMain();
			command = Console.getString("Enter a command: ");
			switch (command) {
			case "products":

				productCommands(command);

				break;
			case "users":

				userCommands(command);

				break;
			case "exit":
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid command, dork.");
				break;
			}
		}

	}

	private static void productCommands(String command) {
		String menu = "products.";
		displayMenu(menu);
		while (!command.equalsIgnoreCase("back")) {
			command = Console.getString("Enter a command: ");
			switch (command) {
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
				displayMenu(menu);
				break;
			case "back":
				System.out.println("Back to main menu.");
				break;
			default:
				System.out.println("Invalid command.");
				break;
			}
		}
	}

	private static void userCommands(String command) {
		String menu = "users.";
		displayMenu(menu);
		while (!command.equalsIgnoreCase("back")) {
			command = Console.getString("Enter a command: ");
			switch (command) {
			case "list":
				displayAllUsers();
				break;
			case "add":
				addUser();
				break;
			case "del":
				deleteUser();
				break;
			case "help":
				displayMenu(menu);
				break;
			case "back":
				System.out.println("Back to main menu.");
				break;
			default:
				System.out.println("Invalid command.");
				break;
			}
		}
	}

	private static void displayMain() {
		System.out.println("MAIN MENU");
		System.out.println("COMMANDS");
		System.out.println("products    - Manage Products");
		System.out.println("users       - Manage Users");
		System.out.println("exit        - Exit the app.");
	}

	private static void displayMenu(String menu) {
		System.out.println("COMMAND MENU");
		System.out.println("list    - List all " + menu);
		System.out.println("add     - Add a " + menu);
		System.out.println("del     - Delete a " + menu);
		System.out.println("help    - Show this menu");
		System.out.println("back    - Back to main menu");
	}

	private static void displayAllProducts() {
		System.out.println("PRODUCT LIST");
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		List<Product> products = productFile.getAll();
		StringBuilder sb = new StringBuilder();
		for (Product p : products) {
			sb.append(p.getCode() + "\t" + p.getDescription() + "\t" + currency.format(p.getPrice()) + "\n");
		}
		System.out.println(sb);
	}

	private static void addProduct() {
		String code = Console.getString("Enter code: ");
		String desc = Console.getString("Description: ");
		double price = Console.getDouble("Enter price: ");

		Product p = new Product(code, desc, price);
		boolean wasSuccessful = productFile.add(p);
		if (wasSuccessful) {
			System.out.println("Successfully added " + desc);
		} else {
			System.out.println("Error adding " + desc);
		}
	}

	private static void deleteProduct() {
		String code = Console.getString("Product code to delete? ");

		Product p = productFile.get(code);
		if (p != null) {
			productFile.delete(p);
			System.out.println(p.getDescription() + " has been deleted.");
		} else {
			System.out.println("No product found for code: " + code);
		}
	}

	private static void displayAllUsers() {
		System.out.println("USER LIST");
		List<User> users = userFile.getAll();
		StringBuilder sb = new StringBuilder();
		for (User u : users) {
			sb.append(u.getUserName() + "\t" + u.getPassword() + "\n");
		}
		System.out.println(sb);
	}

	private static void addUser() {
		String userName = Console.getString("Enter Username: ");
		String Password = Console.getString("Password: ");

		User u = new User(userName, Password);
		boolean wasSuccessful = userFile.add(u);
		if (wasSuccessful) {
			System.out.println("Successfully added " + userName);
		} else {
			System.out.println("Error adding " + userName);
		}
	}

	private static void deleteUser() {
		String userName = Console.getString("Username to delete? ");

		User u = userFile.get(userName);
		if (u != null) {
			userFile.delete(u);
			System.out.println(u.getUserName() + " has been deleted.");
		} else {
			System.out.println("No product found for code: " + userName);
		}
	}

}
