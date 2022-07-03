package com.example.email.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="habilidades")
@SQLDelete(sql = "UPDATE habilidades SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Habilidades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String numero;
	private String icono;
	private boolean deleted = Boolean.FALSE;
	
	
	public Habilidades() {
		
	}
	public Habilidades(String nombre, String numero, String icono, boolean deleted) {
	
		this.nombre = nombre;
		this.numero = numero;
		this.icono = icono;
		this.deleted = deleted;
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
