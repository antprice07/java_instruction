package db;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import business.User;

public class UserTextFile implements DAO<User> {

	private List<User> users = null;
	private Path usersPath = null;
	private File usersFile = null;
	private final String TAB = "\t";

	public UserTextFile() {
		usersPath = Paths.get("F:/bootcamp/java/user");
		usersFile = usersPath.toFile();
		users = this.getAll();

	}

	@Override
	public User get(String userName) {
		
		for (User u:users) {
			if(u.getUserName().equalsIgnoreCase(userName)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		if(users != null) {
			return users;
		}
		users = new ArrayList<>();
		if(Files.exists(usersPath)) {
			try(BufferedReader in = new BufferedReader(
					new FileReader(usersFile))){
				String line = in.readLine();
				while(line != null) {
					String[] fields = line.split(TAB);
					String userName = fields[0];
					String password = fields[1];
					User u = new User(userName,password);
					users.add(u);
					line = in.readLine();
				}
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}else {
			System.out.println(usersPath.toAbsolutePath() + " doesn't exist.");
			return users;
		}
		return users;
		
	}
	
	private boolean saveAll() {
		try(PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new FileWriter(usersFile)))){
			for(User u : users) {
				out.print(u.getUserName()+TAB);
				out.println(u.getPassword()+TAB);
				
			}
			return true;
		} catch (IOException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean add(User u) {
		
		users.add(u);

		return this.saveAll();
	}

	@Override
	public boolean update(User u) {
		
		User oldUser = this.get(u.getUserName());
		int i = users.indexOf(oldUser);
		users.remove(i);
		users.add(i, u);

		return this.saveAll();
	}

	@Override
	public boolean delete(User u) {
		users.remove(u);
		return this.saveAll();
	}

}
