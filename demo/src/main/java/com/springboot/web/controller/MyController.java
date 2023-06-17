package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

}
