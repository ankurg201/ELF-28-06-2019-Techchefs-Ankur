package com.techchefs.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techchefs.mywebapp.beans.EmployeeInfoBean;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EmployeeInfoBean empInfo = new EmployeeInfoBean();
		empInfo.setId(101);
		empInfo.setName("rakesh");
		empInfo.setEmail("rakesh@gmail.com");
		empInfo.setPhone(987654L);
		// pass the above object to employeesearchservlet
		req.setAttribute("info", empInfo);
		
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("info", empInfo);
		
		String url = "search?id=1";
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}
}
