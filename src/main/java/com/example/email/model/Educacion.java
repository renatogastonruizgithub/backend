package com.example.email.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="educacion")/*
@SQLDelete(sql = "UPDATE educacion SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")*/

public class Educacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String instituto;
	private String titulo;
	@Lob
	@Column(columnDefinition = "LONGTEXT" )
	private String info;	
	@Column(name = "inicio_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate inicio;
	@Column(name = "fin_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fin;
	/*private boolean deleted = Boolean.FALSE;*/
	
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return the instituto
	 */
	public String getInstituto() {
		return instituto;
	}
	/**
	 * @param instituto the instituto to set
	 */
	public void setInstituto(String instituto) {
		this.instituto = instituto;
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
	public Educacion(Long id, String instituto, String titulo, String info, LocalDate inicio, LocalDate fin
			)
	{
		
		this.id = id;
		this.instituto = instituto;
		this.titulo = titulo;
		this.info = info;
		this.inicio = inicio;
		this.fin = fin;

	}
	public Educacion() {
		
	}
	
	
}
