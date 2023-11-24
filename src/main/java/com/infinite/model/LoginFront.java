package com.infinite.model;

public class LoginFront {
	String username;
	String password;

	public LoginFront(String username, String password) {
		//super();
		this.username = username;//refers to accessing the instance
		this.password = password;
	}

	public LoginFront() {
		super();//calls the constructor for the parent class
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
