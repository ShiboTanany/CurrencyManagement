package com.test.CurrencyManagement.entities;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JWTAuthenticationToken  extends UsernamePasswordAuthenticationToken{
	private static final long serialVersionUID = 1L;
	private String token ;

	public JWTAuthenticationToken(String token
			) {
		super(null, null);
		this.token =token ;
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
