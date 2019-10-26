package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import business.Product;

public class ProductDB {

	protected static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prs?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "prs_user";
		String pwd = "sesame";
		Connection con = DriverManager.getConnection(dbURL, username, pwd);
		return con;
	}

	public List<Product> list() throws SQLException {
		Statement stmt = getConnection().createStatement();
		String sql = "SELECT * FROM Product";
		List<Product> products = new ArrayList<>();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Product u = createProductFromRS(rs);

			products.add(u);

		}
		rs.close();
		return products;
	}

	public Product get(int id) {
		Product p = null;
		String sql = "Select * from Product WHERE ID = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = createProductFromRS(rs);
				rs.close();
			} else {
				System.out.println("No Product found with that ID.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}
	
	public int addProduct(Product p) {
		int rowCount = 0;
		String sql = "INSERT INTO Product (vendorID,partnumber,name,price,unit,photopath) VALUES(?,?,?,?,?,?)";
		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
			ps.setInt(1, p.getVendorID());
			ps.setString(2, p.getPartNumber());
			ps.setString(3, p.getName());
			ps.setDouble(4, p.getPrice());
			ps.setString(5, p.getUnit());
			ps.setString(6, p.getPhotoPath());
			rowCount = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int updateProduct(int id, String choice,String change) {
		int rowCount = 0;
		if (!choice.contains("'")) {
			String sql = "UPDATE PRODUCT SET "+choice+"= ? WHERE id = ?";
			Product productCheck = get(id);
			if (productCheck!=null) {
				if(choice.equalsIgnoreCase("price")) {
					try(PreparedStatement ps = getConnection().prepareStatement(sql)){
						ps.setDouble(1, Double.parseDouble(change));
						ps.setInt(2, id);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else {
				try(PreparedStatement ps = getConnection().prepareStatement(sql)){
					ps.setString(1, change);
					ps.setInt(2, id);
					rowCount=ps.executeUpdate();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				}
			}else {
				System.out.println("No Product found with that ID.");
			}
		}else {
			System.out.println("You can not use a single quote in your selection.");
		}
		
		return rowCount;
	}
	
	public int deleteProduct(int id) {
		String sql = "DELETE FROM PRODUCT WHERE ID = ?";
		int rowCount = 0;
		Product checkProduct = null;
		checkProduct = get(id);
		if(checkProduct!=null) {
			try(PreparedStatement ps = getConnection().prepareStatement(sql)){
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}

	private Product createProductFromRS(ResultSet rs) throws SQLException {
		// parse user row into product pojo
		int id = rs.getInt("id");
		int vID = rs.getInt("VendorID");
		String partNumber = rs.getString("partNumber");
		String name = rs.getString("name");
		double price = rs.getDouble("price");
		String unit = rs.getString("unit");
		String photoPath = rs.getString("photoPath");

		Product p = new Product(id, vID, partNumber, name, price, unit, photoPath);
		return p;
	}
	
	
	
	
	
	
	

}