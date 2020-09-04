package todos.model;

public class User {
	private String username;
	private String password;
	private int id;
	public User(int id,String username,String password){
		this.username = username;
		this.password = password;
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    public void setUsername(String username) {
		this.username = username;
	}
    public int getId() {
		return id;
	}
    public void setId(int id) {
		this.id = id;
	}
}
