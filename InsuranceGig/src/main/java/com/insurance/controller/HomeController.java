package com.insurance.controller;


import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

	@GetMapping(value = {"/", "/home"})
	public String home(Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("username", principal.getName());
		}
		
		return "index";
		
	}
	
	@GetMapping(value = "plans")
	public String plans(Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("username", principal.getName());
		}
		
		return "plans";
		
	}
	
	@GetMapping(value = "contact-us")
	public String contact(Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("username", principal.getName());
		}
		
		return "contact-us";
	}
	
	@GetMapping(value = "application")
	public String insurance(Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("username", principal.getName());
		}
		
		return "application";
	}
	
	@GetMapping(value = "/login")
	public String login(@RequestParam(required = false) String logout, @RequestParam(required = false) String error,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
		String message = "";
		if (error != null) {
			message = "Invalid Credentials";
		}
		if (logout != null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
			}
			message = "Logout";
			return "login";
		}
		model.addAttribute("Message", message);
		return "login";

	}
	

}
