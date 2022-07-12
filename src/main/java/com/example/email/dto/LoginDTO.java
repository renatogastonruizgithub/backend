package com.example.email.dto;

public class LoginDTO {
	@javax.validation.constraints.NotEmpty(message = "Es requrido username o email")
	private String usernameOrEmail;
	@javax.validation.constraints.NotEmpty(message = "Es requrido password")
	private String password;

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
