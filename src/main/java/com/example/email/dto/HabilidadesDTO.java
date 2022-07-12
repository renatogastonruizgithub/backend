package com.example.email.dto;

public class HabilidadesDTO {
	private Long id;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el nombre")
	private String nombre;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el numero")
	private String numero;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el icono")
	private String icono;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the icono
	 */
	public String getIcono() {
		return icono;
	}
	/**
	 * @param icono the icono to set
	 */
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	
}
