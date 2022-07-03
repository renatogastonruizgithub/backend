package com.example.email.model;

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.Collection;

import java.util.List;

import javax.persistence.*;


import org.springframework.format.annotation.DateTimeFormat;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="persona")
@AllArgsConstructor //con parametros
@NoArgsConstructor //constructor vacio
@Data //crea setter y getter


public class Persona {
	//shape= JsonFormat.Shape.STRING ,
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nombre;
	private String apellido;	
	@Column(name = "creation_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate  nacimiento;
	private String ocupacion;
	private String stack;	
	private String nacionalidad;
	private String provincia;
	private String domicilio;
	@Lob
	@Column(columnDefinition = "LONGTEXT" )
	private String descripion;
	private String imgBanner;
	private String imgAbout;
	private String tituloAbout;
	private String nro;	
	

	
	@OneToMany(cascade = CascadeType.ALL)	
	private Collection<Educacion> educacion;
	@OneToMany(cascade = CascadeType.ALL)	
	private Collection<Habilidades> habilidades;
    @OneToMany( orphanRemoval = true,cascade = CascadeType.ALL)   
	 private List<Trabajos> trabajos=new ArrayList<Trabajos>();
    @OneToMany( orphanRemoval = true,cascade = CascadeType.ALL)   
	 private List<Proyectos> proyectos=new ArrayList<Proyectos>();
    
	public Persona() {
		
	}
	public Persona(Long id, String nombre, String apellido, LocalDate  nacimiento, String ocupacion, String stack,
			String nacionalidad, String provincia, String domicilio, String descripion, String imgBanner,
			String imgAbout, String tituloAbout, String nro, Collection<Educacion> educacion) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = nacimiento;
		this.ocupacion = ocupacion;
		this.stack = stack;
		this.nacionalidad = nacionalidad;
		this.provincia = provincia;
		this.domicilio = domicilio;
		this.descripion = descripion;
		this.imgBanner = imgBanner;
		this.imgAbout = imgAbout;
		this.tituloAbout = tituloAbout;
		this.nro = nro;
		this.educacion = educacion;
	}
	
	
	
	
	
	/**
	 * @return the proyectos
	 */
	public List<Proyectos> getProyectos() {
		return proyectos;
	}
	/**
	 * @param proyectos the proyectos to set
	 */
	public void setProyectos(List<Proyectos> proyectos) {
		this.proyectos = proyectos;
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
	/**
	 * @return the nacimiento
	 */
	public LocalDate getNacimiento() {
		return nacimiento;
	}
	/**
	 * @param nacimiento the nacimiento to set
	 */
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}
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
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}
	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	/**
	 * @return the descripion
	 */
	public String getDescripion() {
		return descripion;
	}
	/**
	 * @param descripion the descripion to set
	 */
	public void setDescripion(String descripion) {
		this.descripion = descripion;
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
	 * @return the imgAbout
	 */
	public String getImgAbout() {
		return imgAbout;
	}
	/**
	 * @param imgAbout the imgAbout to set
	 */
	public void setImgAbout(String imgAbout) {
		this.imgAbout = imgAbout;
	}
	/**
	 * @return the tituloAbout
	 */
	public String getTituloAbout() {
		return tituloAbout;
	}
	/**
	 * @param tituloAbout the tituloAbout to set
	 */
	public void setTituloAbout(String tituloAbout) {
		this.tituloAbout = tituloAbout;
	}
	/**
	 * @return the nro
	 */
	public String getNro() {
		return nro;
	}
	/**
	 * @param nro the nro to set
	 */
	public void setNro(String nro) {
		this.nro = nro;
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
	/**
	 * @return the trabajos
	 */
	public List<Trabajos> getTrabajos() {
		return trabajos;
	}
	/**
	 * @param trabajos the trabajos to set
	 */
	public void setTrabajos(List<Trabajos> trabajos) {
		this.trabajos = trabajos;
	}
	/**
	 * @return the habilidades
	 */
	public Collection<Habilidades> getHabilidades() {
		return habilidades;
	}
	/**
	 * @param habilidades the habilidades to set
	 */
	public void setHabilidades(Collection<Habilidades> habilidades) {
		this.habilidades = habilidades;
	}
	
	
	
}
