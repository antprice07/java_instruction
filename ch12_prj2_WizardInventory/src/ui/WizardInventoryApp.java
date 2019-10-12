package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Console;

public class WizardInventoryApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Wizard Inventory App");
		List<String> inventory = new ArrayList<String>();
		inventory.addAll(Arrays.asList("Wooden Staff", "Wizard Hat", "Cloth Shoes"));

		System.out.println("COMMAND MENU\nshow - Show all items\ngrab - Grab an item\n"
				+ "edit - Edit an item\ndrop - Drop an item\nexit - Exit the program");

		boolean doExit = false;
		while (!doExit) {
			String command = Console.getString("Command: ");
			switch (command) {
			case "show":
				showAll(inventory);
				break;
			case "grab":
				if (inventory.size() == 4) {
					System.out.println("You can't carry any more items. Drop something first");
				
				}
				else if (inventory.size() < 4.1) {
					inventory.add("potion of invisibility");
					System.out.println("Name: potion of invisibility");
					System.out.println("potion of invisibility was added.");
				
				}
				break;
				
			case "edit":
				int i = Console.getInt("Number: ", 0, 5);
				i -= 1;
				String name = Console.getLine("Updated name: ");
				inventory.set(i, name);
				i += 1;
				System.out.println("Item number " + i + " was changed.");
				break;
			case "drop":
				int i2 = Console.getInt("Number: ", 0, 5);
				i2 -= 1;
				inventory.remove(i2);
				i2 += 1;
				System.out.println("Item number " + i2 + " was dropped.");
				break;
			case "exit":
				doExit = true;
				break;
			}
		}
		System.out.println("Deuces!");

	}

	private static void showAll(List<String> inventory) {
		int count = 1;
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(count + ". " + inventory.get(i));
			count++;
		}
	}

}
