package com.example.email.dto;

public class ProyectosDTO {
	@javax.validation.constraints.NotEmpty(message = "Es requrido descripcion")
	private String descripcion;
	@javax.validation.constraints.NotEmpty(message = "Es requrido nombre")
	private String nombre;
	@javax.validation.constraints.NotEmpty(message = "Es requrido imagen")
	private String imagen;
	private Long id;
	/**
	 * @return the descripion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripion the descripion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
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
	
	
}
