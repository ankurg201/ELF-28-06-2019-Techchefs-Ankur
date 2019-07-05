package com.techchefs.hibernateapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techchefs.designpatterns.beans.EmployeeInfoBean;

public class HibernateUtil {
	
	private static SessionFactory factory = null;
	
	private HibernateUtil() {}
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(EmployeeInfoBean.class);
		factory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
