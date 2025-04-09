package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.entity.LoginData;

import jakarta.validation.Valid;

@Controller
public class Mycontroller {

	@GetMapping("/form")
	public String openform(Model m) {
		
		m.addAttribute("loginData",new LoginData());
		return "form";
	}
	
	// Handler for process form
	@PostMapping("/process")
	public String processFrom(@Valid @ModelAttribute("loginData") LoginData user,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		
		// Data process
		System.out.println(user);
		return "success";
	}
}
