package com.test.CurrencyManagement.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.test.CurrencyManagement.entities.User;
import com.test.CurrencyManagement.services.JwtTokenService;
import com.test.CurrencyManagement.services.UserService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Component
@Configuration
public class JwtAuthenticationFilter implements javax.servlet.Filter {

	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
	public static final String SIGNING_KEY = "devglan123r";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

	private final static Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);


	@Autowired
	private UserService userService;

	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	  public void init(FilterConfig filterConfig) throws ServletException {
	    System.out.println("init /rest/* filter");
	  }
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		JwtTokenService jwtTokenService = new JwtTokenService();
		
		String header = ((HttpServletRequest) request).getHeader(HEADER_STRING);
		String username = null;
		String authToken = null;
		if (header != null ) {
			authToken = header ;
			try {
				username = jwtTokenService.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
				logger.error("an error occured during getting username from token", e);
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,
						"an error occured during getting username from token");
			} catch (ExpiredJwtException e) {
				logger.warn("the token is expired and not valid anymore", e);
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,
						"the token is expired and not valid anymore");

			} catch (SignatureException e) {
				logger.error("Authentication Failed. Username or Password not valid.");
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,
						"Authentication Failed. Username or Password not valid.");

			}
		}else {
			logger.error("No header existed");
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,
					"No header existed");

		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			User user = userService.findOne(username);

			if (jwtTokenService.validateToken(authToken, user)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
						null);
				authentication
						.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));
				logger.info("authenticated user " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
				chain.doFilter((HttpServletRequest) request, (HttpServletResponse) response);
			} else {
				logger.error("Authentication Failed. token isn't existed .");
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,
						"Authentication Failed. token isn't existed .");

			}
		}

	}
}