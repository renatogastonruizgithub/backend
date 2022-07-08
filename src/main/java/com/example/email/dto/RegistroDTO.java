package com.example.email.dto;

import java.util.HashSet;
import java.util.Set;


public class RegistroDTO {
	@javax.validation.constraints.NotEmpty(message = "Es requrido el nombre")
	 
	private String nombre;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el nombre de usuario")
	private String username;
	
	private String email;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la contraseña")
	private String password;
	
	private Set<String> roles = new HashSet<>();

	public Set<String> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public RegistroDTO() {
		super();
	}
}
