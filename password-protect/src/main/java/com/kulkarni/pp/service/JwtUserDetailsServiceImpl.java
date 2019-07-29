package com.kulkarni.pp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.kulkarni.pp.dao.JwtUserDetailsREpository;
import com.kulkarni.pp.entity.JwtUserDetails;
import com.kulkarni.pp.entity.Role;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {
	
	Logger log = LoggerFactory.getLogger(JwtUserDetailsServiceImpl.class);
	
	@Autowired
	private JwtUserDetailsREpository jwtUserDetailsREpository;
	
	@Autowired
	private RoleServiceImpl roleService;
	
	@PostConstruct
	public void addFirstUser() {
		addJwtUserDetails("Bhaskar", "$2a$10$MFyZvrdXnYlnmktee5tswe9eMLRTXxTbuxnib3yPQ57eAD3fabyB2", "Admin");
	}

	public JwtUserDetails addJwtUserDetails(String username, String password, String role) {
		JwtUserDetails details = new JwtUserDetails();
	    details.setUsername(username);
	    details.setPassword(password);
//	    details.setRoles(roles);
	    details = jwtUserDetailsREpository.save(details);
		Role userRole = roleService.saveRole(role);
		return details;
	}
	
	public UserDetails loadUserByUsername(String username) {
		UserDetails details = null;
		try {
			details = jwtUserDetailsREpository.findJwtUserDetailsByUsername(username).get();
			log.info("The size of the roles are"+details.getAuthorities().size());
		} catch (Exception e) {
			log.error("Exception ocuured while getting user details with username : "+username);
		}
		return details;
	}
}
