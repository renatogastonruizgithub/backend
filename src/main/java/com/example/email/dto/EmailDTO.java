package com.example.email.dto;

public class EmailDTO {
	@javax.validation.constraints.NotEmpty(message = "Es requrido el mensaje")
	private String body;
	private  String subject;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el nombre")
	private String name;
	@javax.validation.constraints.NotEmpty(message = "Es requrido el email de contacto")
	private String mail;
	
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	public EmailDTO(String body, String subject, String name, String mail) {
	
		this.body = body;
		this.subject = subject;
		this.name = name;
		this.mail = mail;
	}
	public EmailDTO() {
	
	}
	
	
	
	
	
}
