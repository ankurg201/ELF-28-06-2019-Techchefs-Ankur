package com.techchefs.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.dao.EmployeeDAO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	@Qualifier("hibernate")
	private EmployeeDAO employeeDAO;

	@GetMapping("/search")
	public String employeeSearch(String empId, ModelMap map) {
		List<EmployeeInfoBean> beans = employeeDAO.getEmployeesInfoWithPattern(empId);
		map.addAttribute("emplist", beans);
		return "search";
	}
}
