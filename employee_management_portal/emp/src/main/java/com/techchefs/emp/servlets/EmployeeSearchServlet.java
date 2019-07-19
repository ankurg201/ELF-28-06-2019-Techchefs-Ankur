package com.techchefs.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		List<EmployeeInfoBean> beans = dao.getEmployeesInfo(idValue, record);

		PrintWriter out = resp.getWriter();

		if (beans == null) {
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<H1><span style=\"color: green\"> Employees not Found... </span>");
			out.println("</BODY>");
			out.println("</HTML>");
		}

		for (EmployeeInfoBean bean : beans) {

			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<BR>");
			out.println("<BR> <a href = '/emp/search?empId=" + bean.getId() + "&record=1'>" + bean.getId() + "</a>");
			if (record != null) {
				out.println("<BR> name : " + bean.getName());
				out.println("<BR> age : " + bean.getAge());
				out.println("<BR> email : " + bean.getEmail());
				out.println("<BR> gender : " + bean.getGender());
				out.println("<BR> designation : " + bean.getDesignation());
				out.println("<BR> account no : " + bean.getAccountNumber());
			}
			out.println("</BODY>");
			out.println("</HTML>");

		}
	}
}
