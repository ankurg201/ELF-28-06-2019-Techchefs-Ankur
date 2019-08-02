package com.techchefs.emp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techchefs.emp.beans.EmployeeInfoBean;
import com.techchefs.emp.dao.EmployeeDAO;
import com.techchefs.emp.dao.EmployeeDAOFactory;

@WebServlet(urlPatterns = "/search", initParams = { @WebInitParam(name = "actress", value = "basanti") })
public class EmployeeSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idValue = req.getParameter("empId");

		String record = req.getParameter("record");

		EmployeeDAO dao = EmployeeDAOFactory.getInstance();
		List<EmployeeInfoBean> beans = dao.getEmployeesInfoWithPattern(idValue);

		if (beans != null) {
			req.setAttribute("empList", beans);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/search.jsp");
		dispatcher.forward(req, resp);
	}
}
