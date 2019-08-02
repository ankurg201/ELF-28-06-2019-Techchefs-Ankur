package com.techchefs.emp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techchefs.emp.common.EMPConstants;

@Controller
@RequestMapping("/validator")
public class SessionValidateController {

	@GetMapping("/validate/{url1}/{url2}")
	public String validate(HttpSession session, ModelMap modelMap, @Value("${invalidSessionMsg}") String msg,
			@PathVariable("url1") String url1, @PathVariable("url2") String url2) {
		if (session.isNew()) {
			modelMap.addAttribute("msg", msg);
			return EMPConstants.VIEW_LOGIN_PAGE;
		}
		return "forward:/" + url1 + "/" + url2;
	}

	@PostMapping("/validate/{url1}/{url2}")
	public String validatePost(HttpSession session, ModelMap modelMap, @Value("${msg}") String msg,
			@PathVariable("url1") String url1, @PathVariable("url2") String url2) {
		return validate(session, modelMap, msg, url1, url2);
	}
}
