package com.example.email.model;

import java.util.Collection;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="persona")
@AllArgsConstructor //con parametros
@NoArgsConstructor //constructor vacio
@Data //crea setter y getter
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombre;
	private String apellido;
	private String nacimiento;
	
	
	@OneToMany(cascade = CascadeType.ALL)	
	private Collection<Educacion> educacion;
	
	
	
	
	
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
	public Collection<Educacion> getEducacion() {
		return educacion;
	}
	/**
	 * @param educacion the educacion to set
	 */
	public void setEducacion(Collection<Educacion> educacion) {
		this.educacion = educacion;
	}
	
	
	
}
