package com.kulkarni.pp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kulkarni.pp.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByAuthority(String authority);
	
}
