package com.example.email.dto;

import java.util.HashSet;
import java.util.Set;




public class RegistroDTO {
	private String nombre;
	private String username;
	private String email;

	private String password;
	
	private Set<String> roles = new HashSet<>();
	
	
	
	
	/**
	 * @return the roles
	 */
	public Set<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
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