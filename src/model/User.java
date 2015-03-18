package model;

import controller.Home_Controller;

public class User {

	public static final String tableName = "user";
	private String id, username, password;
	
	public User(){
		
	}
	
	public void define(String id, String username, String password) throws Exception{
		this.id = id;
		this.username = username;
		this.password = password;
		Home_Controller.sqlConnect.update("update "+tableName+" set username = '"+SQLConnection.insertBackSlash(username)+"', password = md5('"+password+"') where id = "+id);
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

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}