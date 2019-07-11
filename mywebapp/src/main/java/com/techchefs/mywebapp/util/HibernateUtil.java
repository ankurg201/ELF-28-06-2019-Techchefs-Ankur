package com.techchefs.mywebapp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techchefs.mywebapp.beans.DepartmentInfoBean;
import com.techchefs.mywebapp.beans.EmployeeInfoBean;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().addAnnotatedClass(EmployeeInfoBean.class)
				.addAnnotatedClass(DepartmentInfoBean.class).buildSessionFactory();
	}

	private HibernateUtil() {
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
