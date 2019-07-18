package com.techchefs.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techchefs.emp.beans.EmployeeInfoBean;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeInfoBean bean = (EmployeeInfoBean) req.getAttribute("empInfo");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H2><span style=\"color: green\"> Employee Found... </span>");
		out.println("<BR>");
		out.println("<BR> ID : " + bean.getId());
		out.println("<BR> name : " + bean.getName());
		out.println("<BR> age : " + bean.getAge());
		out.println("<BR> email : " + bean.getEmail());
		out.println("<BR> gender : " + bean.getGender());
		out.println("<BR> designation : " + bean.getDesignation());
		out.println("<BR> account no : " + bean.getAccountNumber());
		out.println("</BODY>");
		out.println("</HTML>");
	}
}
