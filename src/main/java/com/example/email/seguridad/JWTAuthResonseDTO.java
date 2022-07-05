package com.example.email.seguridad;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JWTAuthResonseDTO {
	private String tokenDeAcceso;
	private String tipoDeToken = "Bearer";
	private String username;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public JWTAuthResonseDTO(String tokenDeAcceso,String username,
			Collection<? extends GrantedAuthority> authorities) {
		
		this.tokenDeAcceso = tokenDeAcceso;		
		this.username = username;
		this.authorities = authorities;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @return the authorities
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public JWTAuthResonseDTO() {
		
	}
	

	public String getTokenDeAcceso() {
		return tokenDeAcceso;
	}

	public void setTokenDeAcceso(String tokenDeAcceso) {
		this.tokenDeAcceso = tokenDeAcceso;
	}

	public String getTipoDeToken() {
		return tipoDeToken;
	}

	public void setTipoDeToken(String tipoDeToken) {
		this.tipoDeToken = tipoDeToken;
	}
}
