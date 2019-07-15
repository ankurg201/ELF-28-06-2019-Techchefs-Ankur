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

@WebServlet("/createcookie")
public class CreateCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie myNameCookie = new Cookie("myName", "ankur");
		resp.addCookie(myNameCookie);
		
		Cookie myLocationCookie = new Cookie("myLocation", "bangalore");
		myLocationCookie.setMaxAge(7*24*60*60);
		resp.addCookie(myLocationCookie);
		PrintWriter out = resp.getWriter();
		
		out.println("created the cookie!!");
	}
}
