package com.techchefs.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readcookie")
public class ReadCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] receivedCookies = req.getCookies();
		
		PrintWriter out = resp.getWriter();
	
		if(receivedCookies == null) {
			out.print("cookies are not present!!!");
		}else {
			out.print("Cookies are present...");
			
			for(Cookie rcvdCookie : receivedCookies) {
				out.print(" cookie name : "+rcvdCookie.getName());
				out.print(" cookie value : "+rcvdCookie.getValue());
			}
		}
	}
}
