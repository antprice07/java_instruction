package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import business.Vendor;

public class VendorDB {

	public List<Vendor> list() throws SQLException {
		Statement stmt = ProductDB.getConnection().createStatement();
		String sql = "SELECT * FROM Vendor";
		List<Vendor> vendors = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Vendor v = createVendorFromRS(rs);

			vendors.add(v);

		}
		rs.close();
		return vendors;
	}

	public Vendor get(int id) {
		Vendor v = null;
		String sql = "Select * from Vendor WHERE ID = ?";
		try (PreparedStatement ps = ProductDB.getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				v = createVendorFromRS(rs);
				rs.close();
			} else {
				System.out.println("No Vendor found with that ID.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}
	
	public int addVendor(Vendor v) {
		int rowCount = 0;
		String sql = "INSERT INTO Vendor (code,name,address,city,state,zip,phonenumber,email) VALUES(?,?,?,?,?,?,?,?)";
		try(PreparedStatement ps = ProductDB.getConnection().prepareStatement(sql)){
			ps.setString(1, v.getCode());
			ps.setString(2, v.getName());
			ps.setString(3, v.getAddress());
			ps.setString(4, v.getCity());
			ps.setString(5, v.getState());
			ps.setString(6, v.getZip());
			ps.setString(7, v.getPhoneNumber());
			ps.setString(8, v.getEmail());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int updateVendor(int id, String choice,String change) {
		int rowCount = 0;
		if (!choice.contains("'")) {
			String sql = "UPDATE Vendor SET "+choice+"= ? WHERE id = ?";
			Vendor vendorCheck = get(id);
			if (vendorCheck!=null) {
				try(PreparedStatement ps = ProductDB.getConnection().prepareStatement(sql)){
					ps.setString(1, change);
					ps.setInt(2, id);
					rowCount=ps.executeUpdate();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("No Product found with that ID.");
			}
		}else {
			System.out.println("You can not use a single quote in your selection.");
		}
		
		return rowCount;
	}
	
	public int deleteVendor(int id) {
		String sql = "DELETE FROM Vendor WHERE ID = ?";
		int rowCount = 0;
		Vendor checkVendor = null;
		checkVendor = get(id);
		if(checkVendor!=null) {
			try(PreparedStatement ps = ProductDB.getConnection().prepareStatement(sql)){
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}

	private Vendor createVendorFromRS(ResultSet rs) throws SQLException {
		// parse user row into product pojo
		int id = rs.getInt("id");
		String code = rs.getString("code");
		String name = rs.getString("name");
		String address = rs.getString("address");
		String city = rs.getString("city");
		String state = rs.getString("state");
		String zip = rs.getString("zip");
		String phone = rs.getString("phonenumber");
		String email = rs.getString("email");

		Vendor v = new Vendor(id, code, name, address, city, state, zip,phone,email);
		return v;
	}
}
