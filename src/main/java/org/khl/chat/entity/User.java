package org.khl.chat.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.khl.chat.model.UserDto;

@Entity 
public class User {
	@Id
	private Long id;
	private String name;
	private String email;
	private String password;
	private String role;
	

	public User () {};
	
	public User(Long id, String name, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public User(UserDto u) {
		this.id = u.getId();
		this.name = u.getName();
		this.email = u.getEmail();
		this.password = u.getPassword();
		this.role = u.getRole();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}	
	public void setRole(String role) {
		this.role = role;
	}

}
