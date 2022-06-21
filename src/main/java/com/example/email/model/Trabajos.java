package com.example.email.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
@Entity



@Table(name="trabajos")
@SQLDelete(sql = "UPDATE trabajos SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Trabajos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String nombre;
	@Lob
	@Column(columnDefinition = "LONGTEXT" )
	private String descripcion;
	private String cargo;
	@Column(name = "inicio_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate inicio;
	@Column(name = "fin_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fin;
	private boolean deleted = Boolean.FALSE;
	
	
	public Trabajos() {
		
	}

	
	
	public Trabajos(Long id, String nombre, String descripcion, String cargo, LocalDate inicio, LocalDate fin) {
	
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cargo = cargo;
		this.inicio = inicio;
		this.fin = fin;
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
	public LocalDate getInicio() {
		return inicio;
	}
	/**
	 * @param inicio the inicio to set
	 */
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	/**
	 * @return the fin
	 */
	public LocalDate getFin() {
		return fin;
	}
	/**
	 * @param fin the fin to set
	 */
	public void setFin(LocalDate fin) {
		this.fin = fin;
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
	
}
