package com.techchefs.hibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techchefs.hibernateapp.dto.DepartmentInfoBean;

public class SaveDataDepartment {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(DepartmentInfoBean.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		DepartmentInfoBean departmentInfoBean = new DepartmentInfoBean();
		departmentInfoBean.setDeptId(10);
		departmentInfoBean.setDeptName("payroll");
		
		Transaction transaction = session.beginTransaction();
		session.save(departmentInfoBean);
		transaction.commit();
	}
}
