package com.kulkarni.pp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.kulkarni.pp.dao.JwtUserDetailsREpository;
import com.kulkarni.pp.entity.JwtUserDetails;
import com.kulkarni.pp.entity.Role;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {
	
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
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleService.saveRole(role));
	    details.setUsername(username);
	    details.setPassword(password);
	    details.setRoles(roles);
		return jwtUserDetailsREpository.save(details);
	}
	
	public UserDetails loadUserByUsername(String username) {
		return jwtUserDetailsREpository.findJwtUserDetailsByUsername(username).get();
	}
}
