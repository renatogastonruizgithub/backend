package com.example.email.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombre;
	private String password;
	
	
	/*@OneToOne(cascade = CascadeType.ALL)
	
	private Persona persona;*/
	
	public User( String nombre, String password) {
	
		
		this.nombre = nombre;
		this.password = password;
	
	}
	public User() {
	
	}
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the usuario
	 */
	/**
	 * @return the persona
	
	/*public Persona getPersona() {
		return persona;
	}
	/**
	 * @param persona the persona to set
	
	 /*public void setPersona(Persona persona) {
		this.persona = persona;
	}*/

	
	
}
