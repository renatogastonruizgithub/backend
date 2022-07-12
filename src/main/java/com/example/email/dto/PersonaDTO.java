package com.example.email.dto;



import lombok.Data;

@Data
public class PersonaDTO {
	private Long id;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el nombre")
	private String nombre;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el apellido")
	private String apellido;
	@javax.validation.constraints.NotEmpty(message = "Es requrido nacimiento")
	private String nacimiento;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la ocupacion")
	private String ocupacion;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el stack")
	private String stack;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la nacionalidad")
	private String nacionalidad;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la provincia")
	private String provincia;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la domicilio")
	private String domicilio;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la descripion")
	private String descripion;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la imagen")
	private String imgBanner;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la imagen")
	private String imgAbout;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el titulo pagina sobre mi")
	private String tituloAbout;
	private String nro;
	
	
	
	/**
	 * @return the nacimiento
	 */
	public String  getNacimiento() {
		return nacimiento;
	}
	/**
	 * @param nacimiento the nacimiento to set
	 */
	public void setNacimiento(String  nacimiento) {
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
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
