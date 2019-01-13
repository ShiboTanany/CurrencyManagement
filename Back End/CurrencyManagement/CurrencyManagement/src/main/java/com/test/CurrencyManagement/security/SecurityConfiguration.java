package com.test.CurrencyManagement.security;

import java.util.Collections;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.test.CurrencyManagement.services.JwtTokenService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled =true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	  @Override
	  public void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable();
	    http.authorizeRequests()
	        .antMatchers("/css/**", "/js/**", "/images/**", "/static/**", "/**/favicon.ico").permitAll()
	        .antMatchers(HttpMethod.POST, "/tokens/*").permitAll()
	        .antMatchers("/api/*").permitAll();
	        //.anyRequest().authenticated();
	  }

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public FilterRegistrationBean<JwtAuthenticationFilter> loggingFilter() {

		System.out.println("Setting up loginRegistrationBean");

		FilterRegistrationBean<JwtAuthenticationFilter> filterRegistrationBean = new FilterRegistrationBean<JwtAuthenticationFilter>();
		filterRegistrationBean.setFilter(new JwtAuthenticationFilter());
		filterRegistrationBean.setUrlPatterns(Collections.singletonList("/api/*"));

		return filterRegistrationBean;

	}

}