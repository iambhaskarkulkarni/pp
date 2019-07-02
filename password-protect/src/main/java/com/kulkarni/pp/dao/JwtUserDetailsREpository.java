package com.kulkarni.pp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kulkarni.pp.entity.JwtUserDetails;

@Repository
public interface JwtUserDetailsREpository extends JpaRepository<JwtUserDetails, Long>{
	
	public Optional<JwtUserDetails> findJwtUserDetailsByUsername(String username);
	
}
