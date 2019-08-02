package com.techchefs.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.common.EMPConstants;
import com.techchefs.emp.dao.EmployeeDAO;

@Controller
@RequestMapping("/login")
@PropertySource(EMPConstants.PROP_EMP)
public class LoginController {

	@Autowired
	@Qualifier("hibernate")
	private EmployeeDAO employeeDAO;

	@GetMapping("/loginPage")
	public String loginPage() {
		return EMPConstants.VIEW_LOGIN_PAGE;
	}

	@PostMapping("/authenticate")
	public String authenticate(int empId, String password, HttpServletRequest req,
			@Value(EMPConstants.PROP_LOGIN_FAIL) String loginFail) {

		EmployeeInfoBean empBean = employeeDAO.getEmployeeInfo(empId);

		String url = null;
		if (empBean != null && empBean.getPassword().equals(password)) {
			HttpSession session = req.getSession(true);
			session.setAttribute(EMPConstants.EMP_BEAN, empBean);
			url = EMPConstants.VIEW_HOME_PAGE;
		} else {
			req.setAttribute("msg", loginFail);
			url = EMPConstants.VIEW_LOGIN_PAGE;
		}
		return url;
	}

	@GetMapping("/logout")
	public String doLogout(ModelMap modelMap, HttpSession session,
			@Value(EMPConstants.PROP_LOGOUT) String logoutSuccess) {
		session.invalidate();
		modelMap.addAttribute("msg", logoutSuccess);
		return EMPConstants.VIEW_LOGIN_PAGE;
	}
}
