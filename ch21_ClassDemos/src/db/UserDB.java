package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.User;
import util.Console;

public class UserDB {

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "prs_user";
		String pwd = "sesame";
		Connection con = DriverManager.getConnection(dbURL, username, pwd);
		return con;
	}

	public List<User> list() throws SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			// parse user row into user pojo
			int id = rs.getInt("id");
			String userName = rs.getString("Username");
			String pwd = rs.getString("password");
			String fname = rs.getString("firstname");
			String lname = rs.getString("lastname");
			String phone = rs.getString("phonenumber");
			String email = rs.getString("email");
			boolean rvw = rs.getBoolean("isreviewer");
			boolean adm = rs.getBoolean("isadmin");

			User u = new User(id, userName, pwd, fname, lname, phone, email, rvw, adm);

			users.add(u);

		}
		rs.close();
		return users;

	}

	public User get(int id) throws SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User" + " WHERE ID = " + id;
		User u = null;
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			// parse user row into user pojo
			String userName = rs.getString("Username");
			String pwd = rs.getString("password");
			String fname = rs.getString("firstname");
			String lname = rs.getString("lastname");
			String phone = rs.getString("phonenumber");
			String email = rs.getString("email");
			boolean rvw = rs.getBoolean("isreviewer");
			boolean adm = rs.getBoolean("isadmin");

			u = new User(id, userName, pwd, fname, lname, phone, email, rvw, adm);

		}
		rs.close();
		return u;
	}
	
	public void add() throws SQLException {
		Statement stmt = getConnection().createStatement();
		System.out.println("ADD USER");
		int id = Console.getInt("ID: ");
		User u = get(id);
		if(u == null) {
			String sql = "INSERT INTO user (ID, UserName, Password, FirstName, LastName, PhoneNumber, Email, IsReviewer, IsAdmin) VALUES (";
			String uname = Console.getString("Username: ");
			String pwd = Console.getString("Password: ");
			String fname = Console.getString("First Name: ");
			String lname = Console.getString("Last Name: ");
			String phone = Console.getString("Phone number(with dashes):");
			String email = Console.getString("Email: ");
			int rvw = Console.getInt("Is this user a reviewer? (1 for yes, 0 for no): ",-1,2);
			int admin = Console.getInt("Is this user an admin? (1 for yes, 0 for no): ",-1,2);
			int update = stmt.executeUpdate(sql+id+",'"+uname+"','"+pwd+"','"+fname+"','"+lname+"','"+phone+"','"+email+"',"+rvw+","+admin+")");
			System.out.println("User added.");
		}else {
			System.out.println("Na fam. That is already an ID.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
