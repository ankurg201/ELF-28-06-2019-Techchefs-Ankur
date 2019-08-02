package com.techchefs.emp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.dao.EmployeeDAO;
import com.techchefs.emp.dao.EmployeeDAOFactory;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/employee")
@Log
@PropertySource("classpath:msg.properties")
public class EmployeeController {

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@PostMapping("/login")
	public String doLogin(int empId, String password, ModelMap modelMap, HttpServletRequest req) {

		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean empBean = employeeDAO.getEmployeeInfo(empId);

		String url = null;
		if (empBean != null && empBean.getPassword().equals(password)) {
			HttpSession session = req.getSession(true);
			modelMap.addAttribute("empBean", empBean);
			url = "home";
		} else {
			modelMap.addAttribute("msg", "Invalid credential");
			url = "login";
		}
		return url;
	}

	@PostMapping("/create")
	public String createEmployee(EmployeeInfoBean bean, ModelMap modelMap) {
		log.info(bean.getOtherInfo() + " ");
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance();
		boolean isSave = employeeDAO.createEmployeeInfo(bean);
		log.info(isSave + " ");
		String msg = null;
		if (isSave == false) {
			msg = "employee not saved";
		} else {
			msg = "employee saved";
		}

		modelMap.addAttribute("msg", msg);
		return "create";
	}

	@GetMapping("/logout")
	public String doLogout(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("msg", "logout succesfully");
		return "login";
	}

	@GetMapping("/validate")
	public String validateSession(HttpSession session, ModelMap modelMap, @RequestParam String url,
			@Value("${msg}") String msg) {
		if (session.isNew()) {
			modelMap.addAttribute("msg", msg);
			session.invalidate();
			return "login";
		}
		return "forward:/employee/" + url;
	}

	@GetMapping("/validate2/{url}")
	public String validateSession2(HttpSession session, ModelMap modelMap, @Value("${msg}") String msg,
			@PathVariable("url") String url) {
		if (session.isNew()) {
			modelMap.addAttribute("msg", msg);
			session.invalidate();
			return "login";
		}
		return "forward:/employee/" + url;
	}

	@PostMapping("/validate")
	public String validateSessionPost(HttpSession session, ModelMap modelMap, @RequestParam String url,
			@Value("${msg}") String msg) {
		return validateSession(session, modelMap, url, msg);
	}

	@PostMapping("/validate2/{url}")
	public String validateSessionPost2(HttpSession session, ModelMap modelMap, @Value("${msg}") String msg,
			@PathVariable("url") String url) {
		return validateSession2(session, modelMap, msg, url);
	}

	@GetMapping("/search")
	public String search(HttpSession session, ModelMap modelMap, @RequestParam String empId) {
		EmployeeDAO dao = EmployeeDAOFactory.getInstance();
		List<EmployeeInfoBean> beans = dao.getEmployeesInfoWithPattern(empId);

		if (beans != null) {
			modelMap.addAttribute("empList", beans);
		}
		return "search";
	}
	
	@GetMapping("/id/{id}")
	public String getEmployee(HttpSession session, ModelMap modelMap, @PathVariable("id") String id) {
		EmployeeDAO dao = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean bean = dao.getEmployeeInfo(id);
		modelMap.addAttribute("empBean", bean);
		return "home";
	}
}
