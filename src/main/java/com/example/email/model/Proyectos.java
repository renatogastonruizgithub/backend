package com.example.email.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
@Entity
@Table(name="proyectos")
@SQLDelete(sql = "UPDATE proyectos SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Proyectos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean deleted = Boolean.FALSE;
	@Lob
	@Column(columnDefinition = "LONGTEXT" )
	private String descripcion;
	private String nombre;
	private String imagen;
		
	public Proyectos() {
		
	}
	public Proyectos(boolean deleted, String descripcion, String nombre, String imagen) {
		
		this.deleted = deleted;
		this.descripcion = descripcion;
		this.nombre = nombre;
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
	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the descripion
	 */
	public String getDescripion() {
		return descripcion;
	}
	/**
	 * @param descripion the descripion to set
	 */
	public void setDescripion(String descripcion) {
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
	
	
}
