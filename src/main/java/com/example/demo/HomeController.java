package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//It will send the index.html file
	
	@RequestMapping("/")
	public String test() {
		return "index";
	}
}
