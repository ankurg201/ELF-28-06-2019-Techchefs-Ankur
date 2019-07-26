package com.techchefs.emp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techchefs.emp.dto.UserBean;

@Controller
@RequestMapping("/forms")
public class FormHandlingController {

	@GetMapping("/getForm")
	public String getForm() {
		return "myForm";
	}

	@PostMapping("/formSubmit")
	public String submitForm(HttpServletRequest req) {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String pwd = req.getParameter("password");

		req.setAttribute("userId", userId);
		req.setAttribute("pass", pwd);

		return "formDataDisplay";
	}

	@PostMapping("/formSubmit2")
	public String submitForm2(int userId, String password, ModelMap modelMap) {
		modelMap.addAttribute("userId", userId);
		modelMap.addAttribute("password", password);

		return "formDataDisplay";
	}

	@PostMapping("/formSubmit3")
	public String submitForm3(UserBean userBean, ModelMap modelMap) {
		modelMap.addAttribute(userBean);
		return "formDataBeanDisplay";
	}

	@PostMapping("/formSubmit4")
	public String submitForm4(@RequestParam(name = "userId") int userId,
			@RequestParam(name = "password") String password, ModelMap modelMap) {
		modelMap.addAttribute("userId", userId);
		modelMap.addAttribute("password", password);
		return "formDataDisplay";
	}

	@PostMapping("/formSubmit5")
	public String submitForm5(@RequestParam(name = "userId") int userId,
			@RequestParam(name = "password") String password, ModelMap modelMap) {
		modelMap.addAttribute("userId", userId);
		modelMap.addAttribute("password", password);
		return "formDataDisplayEL";
	}
	
	@PostMapping("/formSubmit6")
	public String submitForm6(UserBean userBean, ModelMap modelMap) {
		modelMap.addAttribute(userBean);
		return "formDataBeanDisplayEL";
	}
}
