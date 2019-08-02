package com.techchefs.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class FormController {
	
	@GetMapping("/loginform")
	public String getLoginForm() {
		return "login";
	}
	
	@GetMapping("/createform")
	public String getCreateForm() {
		return "createEmployeeInfo";
	}
}
