package com.techchefs.springmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/name")
public class NameController {

	@GetMapping("/view1")
	public String getView1() {
		
		return "view1";
	}
	
	@GetMapping("/get")
	public String getName() {
		
		return null;
	}
}
