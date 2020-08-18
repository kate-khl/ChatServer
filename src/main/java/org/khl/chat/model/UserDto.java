package org.khl.chat.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.khl.chat.entity.User;


public class UserDto {
	
	private int id;
	@NotBlank @NotNull 
	private String name;
	@Email @NotNull 
	private String email;
	@NotBlank @NotNull 
	private String  password;
	

	public UserDto(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserDto(User u) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
