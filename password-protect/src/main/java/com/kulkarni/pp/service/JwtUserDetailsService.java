package com.kulkarni.pp.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.kulkarni.pp.entity.JwtUserDetails;

public interface JwtUserDetailsService {

	public JwtUserDetails addJwtUserDetails(String username, String password, String role);
	
	public UserDetails loadUserByUsername(String username);
	
}
