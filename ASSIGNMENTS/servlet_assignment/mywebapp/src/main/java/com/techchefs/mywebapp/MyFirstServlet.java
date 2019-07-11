package com.techchefs.mywebapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String fnameValue = req.getParameter("fname");
		res.setContentType("text/html");// setting the content type
		// res.setContentType("application/pdf");
		res.setContentType("html/text");
		PrintWriter pw = res.getWriter();// get the stream to write the data

		// writing html in the stream
		pw.println("<html><body>");
		pw.println("Welcome to servlet : "+fnameValue);
		pw.println("</body></html>");

		pw.close();// closing the stream
	}
}
