package com.kulkarni.pp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kulkarni.pp.dto.HelloWorldBean;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WelcomeController {
	
	@GetMapping("/hellow-world")
	public HelloWorldBean welcome() {
		HelloWorldBean bean = new HelloWorldBean("welcome to spring Boot programming");
		return bean;
	}

}
