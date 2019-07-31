package com.techchefs.hibernateProject.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techchefs.hibernateProject.dto.Customer;
import com.techchefs.hibernateProject.dto.EmployeeInfoBean;
import com.techchefs.hibernateProject.dto.Products;
import com.techchefs.hibernateProject.dto.Student;
import com.techchefs.hibernateProject.dto.StudentOtherInfo;
import com.techchefs.hibernateProject.dto.TestDto;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private HibernateUtil() {
	}

	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Products.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(StudentOtherInfo.class)
				.addAnnotatedClass(EmployeeInfoBean.class).addAnnotatedClass(TestDto.class).buildSessionFactory();
	}

	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}

	public static Session openSession() {
		return getSessionFactory().openSession();
	}
}
