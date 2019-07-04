package com.techchefs.hibernateapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.hibernate.Session;
import org.hibernate.Transaction;
import com.techchefs.hibernateapp.dto.EmployeeInfoBean;
import com.techchefs.hibernateapp.util.HibernateUtil;


public class SaveDemo {
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		employeeInfoBean.setId(15);
		employeeInfoBean.setName("bhupindra");
		employeeInfoBean.setAge(32);
		employeeInfoBean.setDesignation("project manager");
		employeeInfoBean.setEmail("vishal@gmail.com");
		employeeInfoBean.setGender("male");
		employeeInfoBean.setJoiningDate(new Date());
		employeeInfoBean.setMngrId(1);
		employeeInfoBean.setSalary(30000000);
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		try {
			employeeInfoBean.setDob(formatter.parse("1997-11-21"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(employeeInfoBean);
		transaction.commit();
	}

}
