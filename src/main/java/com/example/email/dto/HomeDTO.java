package com.example.email.dto;

public class HomeDTO {
	private Long id;
	private String nombre;
	private String ocupacion;
	private String stack;
	private String imgBanner;
	private String apellido;
	
	/**
	 * @return the ocupacion
	 */
	public String getOcupacion() {
		return ocupacion;
	}

	/**
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * @return the stack
	 */
	public String getStack() {
		return stack;
	}

	/**
	 * @param stack the stack to set
	 */
	public void setStack(String stack) {
		this.stack = stack;
	}

	/**
	 * @return the imgBanner
	 */
	public String getImgBanner() {
		return imgBanner;
	}

	/**
	 * @param imgBanner the imgBanner to set
	 */
	public void setImgBanner(String imgBanner) {
		this.imgBanner = imgBanner;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
