package com.techchefs.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	public static void main(String[] args) {
		System.out.println("hello in main");
	}

	public MyFirstServlet() {
		this(20);
		System.out.println("inside myfirst constructor 1...");
	}

	public MyFirstServlet(int i) {
		this("");
		System.out.println("inside myfirst constrtor 2...");
	}

	public MyFirstServlet(String string) {
		System.out.println("inside myfirst constructor 3...");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		String movieName = ctx.getInitParameter("movie");

		ServletConfig config = getServletConfig();
		String actorName = config.getInitParameter("actor");

		String fnameValue = req.getParameter("fname");
		res.setContentType("text/html");// setting the content type
		// res.setContentType("application/pdf");
		// res.setContentType("html/text");
		PrintWriter pw = res.getWriter();// get the stream to write the data

		// writing html in the stream
		pw.println("<html><body>");
		pw.println("Welcome to servlet : " + fnameValue + " " + movieName + " " + actorName);
		pw.println("</body></html>");

		pw.close();// closing the stream
	}
}
