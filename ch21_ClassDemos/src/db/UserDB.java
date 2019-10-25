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

	// NOTE: uses statement instead of prepared statement
	public List<User> list() throws SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User";
		List<User> users = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			User u = createUserFromRS(rs);

			users.add(u);

		}
		rs.close();
		return users;

	}

	// NOTE: uses statement instead of prepared statement
	public User get(int id) throws SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM User" + " WHERE ID = " + id;
		User u = null;
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			u = createUserFromRS(rs);
		}
		rs.close();
		return u;
	}

	// NOTE: uses statement instead of prepared statement
	public void addUser() throws SQLException {
		Statement stmt = getConnection().createStatement();
		System.out.println("ADD USER");
		String sql = "INSERT INTO user (UserName, Password, FirstName, LastName, PhoneNumber, Email, IsReviewer, IsAdmin) VALUES (";
		String uname = Console.getString("Username: ");
		String pwd = Console.getString("Password: ");
		String fname = Console.getString("First Name: ");
		String lname = Console.getString("Last Name: ");
		String phone = Console.getString("Phone number(with dashes):");
		String email = Console.getString("Email: ");
		int rvw = Console.getInt("Is this user a reviewer? (1 for yes, 0 for no): ", -1, 2);
		int admin = Console.getInt("Is this user an admin? (1 for yes, 0 for no): ", -1, 2);
		int rowCount = stmt.executeUpdate(sql + "'" + uname + "','" + pwd + "','" + fname + "','" + lname + "','"
				+ phone + "','" + email + "'," + rvw + "," + admin + ")");
		System.out.println("User added.");

	}

	public int updateUser(int id, String choice, String change) {
		String sql = "UPDATE USER SET " + choice + "= ? WHERE id = " + id;
		int rowCount = 0;
		User checkUser = null;
		try {
			checkUser = get(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (checkUser != null) {
			try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
				ps.setString(1, change);
				rowCount = ps.executeUpdate();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("Does not exist");
		}
		return rowCount;
	}
	
	public int deleteUser(int id) {
		String sql = "DELETE FROM USER WHERE ID = ?";
		int rowCount = 0;
		User checkUser = null;
		try {
			checkUser = get(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(checkUser!=null) {
			try(PreparedStatement ps = getConnection().prepareStatement(sql)){
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}

	private User createUserFromRS(ResultSet rs) throws SQLException {
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
		return u;
	}

}
