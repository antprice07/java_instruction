package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.User;

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
	public int addUser(User u) {
		int rowCount = 0;
		String sql = "INSERT INTO Product (username,password,firstname,lastname,phonenumber,email,isreviewer,isadmin) VALUES(?,?,?,?,?,?)";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getPhoneNumber());
			ps.setString(6, u.getEmail());
			ps.setBoolean(7, u.isReviewer());
			ps.setBoolean(8, u.isAdmin());
			rowCount=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
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
