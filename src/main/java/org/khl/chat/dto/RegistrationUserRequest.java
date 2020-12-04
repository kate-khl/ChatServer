package org.khl.chat.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegistrationUserRequest {

	@NotBlank @NotNull 
	private String name;
	@Email @NotNull 
	private String email;
	@NotBlank @NotNull 
	private String  password;	
	@NotBlank @NotNull 
	private String  role;
	
	public RegistrationUserRequest(@NotBlank @NotNull String name, @Email @NotNull String email,
			@NotBlank @NotNull String password, @NotBlank @NotNull String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
