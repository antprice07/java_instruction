package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserDB {

	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?useSSL=false";
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
		
	}
}
