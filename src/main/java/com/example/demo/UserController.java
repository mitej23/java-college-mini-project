package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@GetMapping("/index")
	public String GetForm(Model model) {
		model.addAttribute("User" , new User());
		return "index";
	}
	
	@PostMapping("/calculate")
	public String PostForm(@ModelAttribute User user, BindingResult result,Model model) {
		
		
		model.addAttribute("User" , user);
		if(Integer.parseInt(user.getSalary()) > 10000) {
			model.addAttribute("tax" , 100);
		}else {
			model.addAttribute("tax" , 10);
		}
		
		
		return "tax";
	}
	
}
