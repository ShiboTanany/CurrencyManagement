package com.test.CurrencyManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.CurrencyManagement.entities.AuthToken;
import com.test.CurrencyManagement.entities.User;
import com.test.CurrencyManagement.services.JwtTokenService;
import com.test.CurrencyManagement.services.UserService;

@RestController
@RequestMapping("/token")
public class AuthenticationController {
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
//	public ResponseEntity register(@RequestBody User loginUser) throws AuthenticationException {
//
//		final Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getHashedPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		final User user = userService.findOne(loginUser.getUserName());
//		final String token = jwtTokenUtil.generateToken(user);
//		return ResponseEntity.ok(new AuthToken(token));
//	}

}
