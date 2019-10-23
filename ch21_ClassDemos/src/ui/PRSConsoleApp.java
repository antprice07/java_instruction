package ui;

import java.sql.SQLException;
import java.util.List;

import business.User;
import db.UserDB;
import util.Console;

public class PRSConsoleApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the PRS Console!");
		UserDB udb = new UserDB();
		int command = 0;
		while(command != 99) {
			command = Console.getInt(getMenu(),0,100);
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
				//add
				break;
			case 4:
				//update
				break;
			case 5:
				//delete
				break;
			case 99:
				//exit
				break;
			default:
				System.out.println("Error. Invalid command");
				break;
			}
		}
		
		
		
		
		
		
		System.out.println("Deuces");

	}
	
	private static String getMenu() {
		String str = "MENU\n"+
					"1  - List Users\n"+
					"2  - Get User\n"+
					"3  - Add User\n"+
					"4  - Update User\n"+
					"5  - Delete User\n"+
					"99 - Exit\n"+
					"Command - ";
		return str;
	}

}
