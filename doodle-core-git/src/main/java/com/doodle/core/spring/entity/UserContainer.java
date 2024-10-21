package com.doodle.core.spring.entity;

import jakarta.validation.constraints.Size;

public class UserContainer {
	@Size(min=5, max=10)
	private String username;
	@Size(min=5, max=15)
	private String password;
	
	public UserContainer() {
	}
	public UserContainer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
