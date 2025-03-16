package com.stech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@GetMapping("/orders")
	public String getOrder() {
		return "Order Service!!";
	}
}
