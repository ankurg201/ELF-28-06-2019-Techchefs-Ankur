package com.tc.empspringrest.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tc.empspringrest.beans.EmployeeInfoBean;
import com.tc.empspringrest.beans.EmployeeResponse;
import com.tc.empspringrest.common.EMPConstants;
import com.tc.empspringrest.dao.EmployeeDao;

@RestController
@RequestMapping("/login")
@PropertySource(EMPConstants.PROPERTY_FILENAME)
public class LoginController {

	@Autowired
	@Qualifier(EMPConstants.DB_INTERACTION_TYPE)
	private EmployeeDao employeeDao;

	@PostMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse login(int id, String password, HttpServletRequest request) {
		EmployeeInfoBean bean = employeeDao.getEmployeeInfo(id);

		EmployeeResponse response = new EmployeeResponse();
		if (bean != null && bean.getPassword().equals(password)) {
			response.setDescription("Login Successfully");
			response.setMessage(EMPConstants.SUCCESS_MSG);
			response.setStatusCode(201);
			response.setInfoBeanList(Arrays.asList(bean));
			request.getSession().setAttribute("bean", bean);
		} else {
			response.setDescription("login failed");
			response.setMessage(EMPConstants.FAILED_MSG);
			response.setStatusCode(401);
		}
		return response;
	}

	@GetMapping(path = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse logout(HttpSession session) {
		session.invalidate();
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(201);
		response.setMessage(EMPConstants.SUCCESS_MSG);
		response.setDescription("loggedout succesfully");
		return response;
	}

	@GetMapping(path = "/readcookie", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse readCookie(@CookieValue(name = "JSESSIONID") String sessionId) {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(201);
		response.setMessage(EMPConstants.SUCCESS_MSG);
		response.setDescription("JSESSIONID : "+sessionId);
		return response;
	}
}
