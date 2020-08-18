package org.khl.chat.entity;

import org.khl.chat.model.UserDto;

public class User {
	private int id;
	private String name;
	private String email;
	
	public User () {};
	
	public User(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public User(UserDto u) {
		this.id = u.getId();
		this.name = u.getName();
		this.email = u.getEmail();
		this.password = u.getPassword();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
