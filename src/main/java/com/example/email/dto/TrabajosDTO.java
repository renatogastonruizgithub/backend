package com.example.email.dto;



public class TrabajosDTO {
	private Long id;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el nombre")
	private String nombre;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la descripcion")
	private String descripcion;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la cargo")
	private String cargo;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la fecha de inicio")
	private String inicio;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la fecha de fin")
	private String fin;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return the inicio
	 */
	public String getInicio() {
		return inicio;
	}
	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	/**
	 * @return the fin
	 */
	public String getFin() {
		return fin;
	}
	/**
	 * @param fin the fin to set
	 */
	public void setFin(String fin) {
		this.fin = fin;
	}
	
	
	
}
