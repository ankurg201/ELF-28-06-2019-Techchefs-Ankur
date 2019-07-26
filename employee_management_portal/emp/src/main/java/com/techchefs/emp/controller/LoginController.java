package com.techchefs.emp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.dao.EmployeeDAO;
import com.techchefs.emp.dao.EmployeeDAOFactory;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@PostMapping("/dologin")
	public String doLogin(int empId, String password, ModelMap modelMap) {
		
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean empBean = employeeDAO.getEmployeeInfo(empId);

		String url = null;
		if (empBean != null && empBean.getPassword().equals(password)) {
			modelMap.addAttribute("empBean", empBean);
			url="home";
		} else {
			modelMap.addAttribute("msg", "Invalid credential");
			url="login";
		}
		return url;
	}
	
	@GetMapping("/getform")
	public String getLoginForm() {
		return "login";
	}
}
