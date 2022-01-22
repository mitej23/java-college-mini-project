package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@GetMapping("/salaried-person")
	public String GetSalariedPersonForm(Model model) {
		model.addAttribute("User" , new SalariedUser());
		return "salaried";
	}
	
	@GetMapping("/business-person")
	public String GetBusinessPersonForm(Model model) {
		model.addAttribute("User" , new BusinessUser());
		return "business";
	}
	
	@PostMapping("/salaried-tax")
	public String PostSalariedUserForm(@ModelAttribute SalariedUser user, BindingResult result,Model model) {
		
		model.addAttribute("User" , user);
		model.addAttribute("tax",user.tax());
		
		return "tax";
	}
	
	@PostMapping("/business-tax")
	public String PostBusinessUserForm(@ModelAttribute BusinessUser user, BindingResult result,Model model) {
		
		model.addAttribute("User" , user);
		model.addAttribute("tax",user.tax());
		
		return "tax";
	}
	
	
	
}
