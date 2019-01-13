package com.test.CurrencyManagement.services;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.CurrencyManagement.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenService  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
	public static final String SIGNING_KEY = "devglan123r";
	public static final String HEADER_STRING = "Authorization";
	
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token);
	}

	public Date getClaimFromToken(String token) {
		final Claims claims = getAllClaimsFromToken(token);

		return claims.getExpiration();
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public String generateToken(User user) {
		return doGenerateToken(user.getUserName());
	}

	private String doGenerateToken(String subject) {

		Claims claims = Jwts.claims().setSubject(subject);
		
		return Jwts.builder().setClaims(claims).setIssuer("http://devglan.com")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
				.signWith(SignatureAlgorithm.HS256, SIGNING_KEY).compact();
	}

	public Boolean validateToken(String token, User userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUserName()) && !isTokenExpired(token));
	}

	public String getUsernameFromToken(String token) {
		final Claims claims = getAllClaimsFromToken(token);
		return claims.getSubject();
	}

}
