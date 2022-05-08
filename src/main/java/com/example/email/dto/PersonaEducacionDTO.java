package com.example.email.dto;

import java.util.Collection;

public class PersonaEducacionDTO {
	private Long id;

	private String nombre;
	private String apellido;
	
	private Collection<EducacionDTO>educacion;

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

	/**
	 * @return the educacion
	 */
	public Collection<EducacionDTO> getEducacion() {
		return educacion;
	}

	/**
	 * @param educacion the educacion to set
	 */
	public void setEducacion(Collection<EducacionDTO> educacion) {
		this.educacion = educacion;
	}
	
	
	
}
