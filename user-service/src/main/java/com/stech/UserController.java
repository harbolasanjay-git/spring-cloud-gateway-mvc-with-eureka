package com.stech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/getUser")
	public String getUser() {
		return "Id: 101, Name: Sanjay";
	}
	
	@GetMapping("/getAllUsers")
	public String getAllUsers() {
		return "Id: 101, Name: Sanjay, Id: 102, Name: Harshil";
	}
	
}
