package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Console;

public class WizardInventoryApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Wizard Inventory Game!");
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
				else {
					String item = Console.getLine("Name: ");
					inventory.add(item);
					System.out.println(item + " was added.");
				
				}
				break;
				
			case "edit":
				int i = Console.getInt("Number: ", 0, inventory.size()+1);
				i -= 1;
				String name = Console.getLine("Updated name: ");
				inventory.set(i, name);
				i += 1;
				System.out.println("Item number " + i + " was changed.");
				break;
			case "drop":
				int i2 = Console.getInt("Number: ", 0, inventory.size()+1);
				i2 -= 1;
				inventory.remove(i2);
				i2 += 1;
				System.out.println("Item number " + i2 + " was dropped.");
				break;
			case "exit":
				doExit = true;
				break;
			default: System.out.println("You must make a seletion from the menu.");
			continue;
			}
		}
		System.out.println("Deuces!");

	}

	private static void showAll(List<String> inventory) {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i+1) + ". " + inventory.get(i));
		}
	}

}
