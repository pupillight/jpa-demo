package org.yj.demo.jpa.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/jpa")
public class Hello {

	@GetMapping("/hi")
	public String sayHi() {
		return "hi jpa!";

	}

}
