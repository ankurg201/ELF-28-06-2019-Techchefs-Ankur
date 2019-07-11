package com.techchefs.mywebapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techchefs.mywebapp.beans.DepartmentInfoBean;
import com.techchefs.mywebapp.dao.DepartmentDAO;
import com.techchefs.mywebapp.dao.DepartmentDAOFactory;

@WebServlet("/createdepartment")
public class CreateDepartmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DepartmentInfoBean bean = new DepartmentInfoBean();
		try {
			bean.setDeptId(Integer.parseInt(req.getParameter("dept_id")));
			bean.setDeptName(req.getParameter("dept_name"));
		} catch (Exception e) {

		}

		DepartmentDAO dao = DepartmentDAOFactory.getInstance();
		boolean isSave = dao.createDepartmentInfo(bean);

		PrintWriter out = resp.getWriter();

		if (isSave == false) {
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<H1><span style=\"color: green\"> department not saved... </span>");
			out.println("</BODY>");
			out.println("</HTML>");
		} else {
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<H2><span style=\"color: green\"> department saved... </span>");
			out.println("</BODY>");
			out.println("</HTML>");
		}
	}
}
