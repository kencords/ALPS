package model;

public class User {

	private String id, username, password;
	
	public User(){
		
	}
	
	public void define(String id, String username, String password){
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}