package com.techchefs.emp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.dao.EmployeeDAO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	@Qualifier("hibernate")
	private EmployeeDAO employeeDAO;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@GetMapping("/search")
	public String employeeSearch(String empId, ModelMap map) {
		List<EmployeeInfoBean> beans = employeeDAO.getEmployeesInfoWithPattern(empId);
		map.addAttribute("emplist", beans);
		return "search";
	}
	
	@GetMapping("/createPage")
	public String getCreateEmpForm() {
		return "createemployee";
	}
	
	@PostMapping("/createEmployee")
	public String createEmployee(EmployeeInfoBean infoBean, ModelMap map) {
		map.addAttribute("empBean", infoBean);
		return "homePage";
	}
}
