package com.insurance.controller;


import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@GetMapping(value = {"/", "/home"})
	public String home(Principal principal, Model model) {
		return "index";
		
	}
	
	@GetMapping(value = "contact-us")
	public String contact(Principal principal, Model model) {
		return "contact-us";
	}
	
	@GetMapping(value = "insurance")
	public String insurance(Principal principal, Model model) {
		return "insurance";
	}
}
