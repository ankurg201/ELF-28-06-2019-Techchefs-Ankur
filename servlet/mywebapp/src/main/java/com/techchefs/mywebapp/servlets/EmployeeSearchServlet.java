package com.techchefs.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techchefs.mywebapp.beans.EmployeeInfoBean;
import com.techchefs.mywebapp.dao.EmployeeDAO;
import com.techchefs.mywebapp.dao.EmployeeDAOFactory;

@WebServlet(urlPatterns = "/search", initParams = { 
		@WebInitParam(name = "actress", value = "basanti")
		}
)
// @WebServlet("/search/employeesearch")
public class EmployeeSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		String movieName = ctx.getInitParameter("movie");

		ServletConfig config = getServletConfig();
		String actorName = config.getInitParameter("actor");
		String actoressName = config.getInitParameter("actress");

		String idValue = req.getParameter("id");

		EmployeeDAO dao = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean bean = dao.getEmployeeInfo(idValue);

		PrintWriter out = resp.getWriter();

		if (bean == null) {
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<H1><span style=\"color: green\"> Employee not Found... </span>");
			out.println("</BODY>");
			out.println("</HTML>");
		} else {
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
			out.println("<BR>" + movieName + " " + actorName + " " + actoressName);
			out.println("</BODY>");
			out.println("</HTML>");
		}
	}
}
