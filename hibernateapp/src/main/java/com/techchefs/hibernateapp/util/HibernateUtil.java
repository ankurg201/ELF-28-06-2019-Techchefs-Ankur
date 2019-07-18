package com.techchefs.hibernateapp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techchefs.hibernateapp.onetoone.EmployeeInfoBean;
import com.techchefs.hibernateapp.onetoone.EmployeeOtherInfoBean;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().addAnnotatedClass(EmployeeInfoBean.class)
				.addAnnotatedClass(EmployeeOtherInfoBean.class).buildSessionFactory();
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
