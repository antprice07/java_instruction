package ui;

import java.sql.SQLException;
import java.util.List;

import business.Product;
import business.User;
import business.Vendor;
import db.ProductDB;
import db.UserDB;
import db.VendorDB;
import util.Console;

public class PRSConsoleApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the PRS Console!");
		UserDB udb = new UserDB();
		ProductDB pdb = new ProductDB();
		VendorDB vdb = new VendorDB();
		int command = 0;
		String mainMenuCmd = "";
		while(!mainMenuCmd.equalsIgnoreCase("exit")) {
			mainMenuCmd = Console.getString(printMainMenu());
			switch(mainMenuCmd){
			case "user":
				userSwitch(udb, command);
				break;
			case "product":
				productSwitch(vdb,pdb,command);
				break;
			case "vendor":
				vendorSwitch(vdb,command);
				break;
			case "exit":
				break;
			default:
				System.out.println("Error. Invalid command.");
			}
		
		}
		
		
		
		
		System.out.println("Deuces");

	}
	
	private static String printMainMenu() {
		String str = "MAIN MENU\n"
				+ "Pick a DB you'd like to work with:\n"
				+ "'user'    - User Database\n"
				+ "'product' - Product Database\n"
				+ "'vendor'  - Vendor Database\n"
				+ "'exit'    - Exit the application\n"
				+ "Command: ";
		return str;
	}

	private static void userSwitch(UserDB udb, int command) {
		while(command != 99) {
			String menu = "User";
			command = Console.getInt(getMenu(menu),0,100);
			switch(command) {
			case 1:
				try {
					List<User> users = udb.list();
					System.out.println("List of users: ");
					for(User u: users) {
						System.out.println(u);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				int id = Console.getInt("User ID: ");
				try {
					User u = udb.get(id);
					System.out.println("User retrieved: ");
					System.out.println(u);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					udb.addUser();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				//update
				System.out.println("Update User:");
				id = Console.getInt("What ID would you like to update? ");
				String choice = Console.getString("Would you like to change Username, Password,\n"
						+ "FirstName, LastName, PhoneNumber, or Email? ");
				String change = Console.getString("What do you want to make "+choice+"? ");
				int rowCount = udb.updateUser(id, choice,change);
				System.out.println(rowCount + " rows changed.");
				break;
			case 5:
				//delete
				System.out.println("Delete a User:");
				id = Console.getInt("What is the ID of the user you'd like to delete? ");
				User u = null;
				try {
					u = udb.get(id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println(u);
				choice = Console.getString("Are you sure you want to delete? This cannot be undone. y/n ");
				if(choice.equalsIgnoreCase("y")) {
					rowCount = udb.deleteUser(id);
					System.out.println(rowCount + " rows deleted.");
				}else {
					System.out.println("Action cancelled.");
				}
				break;
			case 99:
				//exit
				break;
			default:
				System.out.println("Error. Invalid command");
				break;
			}
		}
	}
	
	private static void productSwitch(VendorDB vdb, ProductDB pdb, int command) {
		while(command != 99) {
			String menu = "Product";
			command = Console.getInt(getMenu(menu),0,100);
			switch(command) {
			case 1:
				try {
					List<Product> products = pdb.list();
					System.out.println("List of Products: ");
					for(Product p: products) {
						System.out.println(p);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				int id = Console.getInt("Product ID: ");
				Product p = pdb.get(id);
				System.out.println("Product retrieved: ");
				System.out.println(p);
				break;
			case 3:
				System.out.println("Add a Product");
				String prompt = Console.getString("Would you like to view a list of vendors to identify\n"
						+ "your Vendor's ID? ");
				List<Vendor> vendors=null;
				if(prompt.equalsIgnoreCase("y")) {
					try {
						vendors = vdb.list();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					for(Vendor v: vendors) {
						System.out.println(v.getId()+" "+v.getName());
					}
				}
				int vid = Console.getInt("Vendor's ID: ");
				String pnumber = Console.getString("Part Number: ");
				String name = Console.getString("Name of product: ");
				double price = Console.getDouble("Price of product: ");
				String unit = Console.getString("Unit code: ");
				String photo = Console.getString("Photo path of product: ");
				p = new Product(vid,pnumber,name,price,unit,photo);
				int rowCount = pdb.addProduct(p);
				System.out.println(rowCount+ " Product(s) added.");
				break;
			case 4:
				//update
				System.out.println("Update Product:");
				id = Console.getInt("What ID would you like to update? ");
				String choice = Console.getString("Would you like to change PartNumber, Name,\n"
						+ "Price, Unit, PhotoPath? ");
				String change = Console.getString("What do you want to make "+choice+"? ");
				rowCount = pdb.updateProduct(id, choice,change);
				System.out.println(rowCount + " rows changed.");
				break;
			case 5:
				//delete
				System.out.println("Delete a Product:");
				id = Console.getInt("What is the ID of the Product you'd like to delete? ");
				p = pdb.get(id);
				System.out.println(p);
				choice = Console.getString("Are you sure you want to delete? This cannot be undone. y/n ");
				if(choice.equalsIgnoreCase("y")) {
					rowCount = pdb.deleteProduct(id);
					System.out.println(rowCount + " rows deleted.");
				}else {
					System.out.println("Action cancelled.");
				}
				break;
			case 99:
				//exit
				break;
			default:
				System.out.println("Error. Invalid command");
				break;
			}
		}
	}
	
	private static void vendorSwitch(VendorDB vdb, int command) {
		while(command != 99) {
			String menu = "Vendor";
			command = Console.getInt(getMenu(menu),0,100);
			switch(command) {
			case 1:
				try {
					List<Vendor> vendors = vdb.list();
					System.out.println("List of Vendors: ");
					for(Vendor v: vendors) {
						System.out.println(v);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				int id = Console.getInt("Vendor ID: ");
				Vendor v = vdb.get(id);
				System.out.println("Vendor retrieved: ");
				System.out.println(v);
				break;
			case 3:
				System.out.println("Add a Vendor");
				String code = Console.getString("Vendor code: ");
				String name = Console.getString("Name of vendor: ");
				String address = Console.getString("Address: ");
				String city = Console.getString("City: ");
				String state = Console.getString("State: ");
				String zip = Console.getString("Zip: ");
				String phone = Console.getString("Phone number: ");
				String email = Console.getString("Email: ");
				v = new Vendor(code,name,address,city,state,zip,phone,email);
				int rowCount = vdb.addVendor(v);
				System.out.println(rowCount+ " Vendors(s) added.");
				break;
			case 4:
				//update
				System.out.println("Update Vendor:");
				id = Console.getInt("What ID would you like to update? ");
				String choice = Console.getString("Would you like to change Code, Name,\n"
						+ "Address, City, State, Zip, PhoneNumber, Email? ");
				String change = Console.getString("What do you want to make "+choice+"? ");
				rowCount = vdb.updateVendor(id, choice,change);
				System.out.println(rowCount + " rows changed.");
				break;
			case 5:
				//delete
				System.out.println("Delete a Vendor:");
				id = Console.getInt("What is the ID of the Vendor you'd like to delete? ");
				v = vdb.get(id);
				System.out.println(v);
				choice = Console.getString("Are you sure you want to delete? This cannot be undone. y/n ");
				if(choice.equalsIgnoreCase("y")) {
					rowCount = vdb.deleteVendor(id);
					System.out.println(rowCount + " rows deleted.");
				}else {
					System.out.println("Action cancelled.");
				}
				break;
			case 99:
				//exit
				break;
			default:
				System.out.println("Error. Invalid command");
				break;
			}
		}
	}
	
	private static String getMenu(String choice) {
		String str = "MENU\n"+
					"1  - List " +choice+"\n"+
					"2  - Get " + choice+"\n"+
					"3  - Add "+ choice+"\n"+
					"4  - Update "+choice+"\n"+
					"5  - Delete "+choice+"\n"+
					"99 - Back to main menu\n"+
					"Command - ";
		return str;
	}

}
