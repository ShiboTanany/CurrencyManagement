package com.test.CurrencyManagement.entities;

import java.io.Serializable;

public class AuthToken implements Serializable {

	
	private String token ;

	public AuthToken(String token) {
		super();
		this.token = token;
	}

	
}
