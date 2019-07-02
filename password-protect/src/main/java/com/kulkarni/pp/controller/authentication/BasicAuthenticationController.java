package com.kulkarni.pp.controller.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kulkarni.pp.dto.AuthunticationDTO;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {

	@GetMapping("/basicauth")
	public AuthunticationDTO getAuthentication() {
		return new AuthunticationDTO("You are authenticated");
	}
}
