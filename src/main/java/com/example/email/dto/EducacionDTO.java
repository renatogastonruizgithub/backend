package com.example.email.dto;


public class EducacionDTO {

	private Long id;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la fecha de titulo")
	private String titulo;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la fecha de info")
	private String info;
	@javax.validation.constraints.NotEmpty(message = "Es requrido la fecha de instituto")
	private  String instituto;
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
