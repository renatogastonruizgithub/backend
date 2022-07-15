package com.example.email.seguridad;





public class JWTAuthResonseDTO {
	private String tokenDeAcceso;
	/*private String tipoDeToken = "Bearer";
	private String username;
	private Collection<? extends GrantedAuthority> authorities;
	*/
	
	public JWTAuthResonseDTO(String tokenDeAcceso) {
		
		this.tokenDeAcceso = tokenDeAcceso;		
	
	}


	public JWTAuthResonseDTO() {
		
	}
	

	public String getTokenDeAcceso() {
		return tokenDeAcceso;
	}

	public void setTokenDeAcceso(String tokenDeAcceso) {
		this.tokenDeAcceso = tokenDeAcceso;
	}


}
