package org.khl.chat.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class UserDto {
	
	private Long id;
	@NotBlank @NotNull 
	private String name;
	@Email @NotNull 
	private String email;
	@NotBlank @NotNull 
	private String  role;
	
	
	public UserDto() {}
			
	public UserDto(String name, String email, String password, String role) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
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
