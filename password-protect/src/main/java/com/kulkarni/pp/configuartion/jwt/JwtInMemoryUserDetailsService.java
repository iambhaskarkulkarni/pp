package com.kulkarni.pp.configuartion.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kulkarni.pp.service.JwtUserDetailsService;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	@Autowired
    JwtUserDetailsService jwtUserDetailsService;

//	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

// {
//	  
//		jwtUserDetailsService.addJwtUserDetails("Bhaskar", "$2a$10$MFyZvrdXnYlnmktee5tswe9eMLRTXxTbuxnib3yPQ57eAD3fabyB2", "Admin");
////    inMemoryUserList.add(new JwtUserDetails(1L, "Bhaskar",
////        "$2a$10$MFyZvrdXnYlnmktee5tswe9eMLRTXxTbuxnib3yPQ57eAD3fabyB2", "ROLE_USER_2"));
//  }


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//				.filter(user -> user.getUsername().equals(username)).findFirst();
//
//		if (!findFirst.isPresent()) {
//			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
//		}
//
//		return findFirst.get();
		return jwtUserDetailsService.loadUserByUsername(username);
	}

}
