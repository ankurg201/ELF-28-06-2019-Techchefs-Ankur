package com.techchefs.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// String googleUrl = "http://www.google.com";
		RequestDispatcher dispatcher = null;
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("1111111111111111111111");

		out.println("<BR>");
		dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.include(req, resp);
		out.println("<BR>");

		out.println("22222222222222222222222222");

		out.println("<BR>");
		dispatcher = req.getRequestDispatcher("currentdate?fname=ankur");
		dispatcher.include(req, resp);
		out.println("<BR>");

		out.println("33333333333333333333333333");

		out.println("<BR>");
		dispatcher = req.getRequestDispatcher("search?id=999");
		dispatcher.include(req, resp);
		out.println("<BR>");
	}
}
