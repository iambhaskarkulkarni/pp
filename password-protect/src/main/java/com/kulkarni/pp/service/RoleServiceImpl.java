package com.kulkarni.pp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kulkarni.pp.dao.RoleRepository;
import com.kulkarni.pp.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role saveRole(String role) {
		Role userRole = roleRepository.findByAuthority(role);
		if (userRole == null) {
			userRole = new Role();
			userRole.setAuthority(role);
			userRole.setCurrentState("Active");
			userRole.setCreatedOn(new Date());
			userRole = roleRepository.save(userRole);
		}
		return userRole;
	}
}
