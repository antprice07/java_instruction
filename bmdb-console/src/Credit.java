
public class Credit {

	private int id;
	private int movieID;
	private int actorID;
	private String role;
	
	public Credit(int id, int movieID, int actorID, String role) {
		super();
		this.id = id;
		this.movieID = movieID;
		this.actorID = actorID;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getActorID() {
		return actorID;
	}
	public void setActorID(int actorID) {
		this.actorID = actorID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
