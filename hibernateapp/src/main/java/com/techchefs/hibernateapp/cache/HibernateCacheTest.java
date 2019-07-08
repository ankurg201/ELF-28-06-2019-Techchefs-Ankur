package com.techchefs.hibernateapp.cache;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCacheTest {
	
	private static final Logger LOGGER = Logger.getLogger("HibernateCacheTest");

	public static void main(String[] args) {
		LOGGER.info(getEmployeeData(1).toString());
		LOGGER.info(getEmployeeData(1).toString());
		LOGGER.info(getEmployeeData(1).toString());
	}
	
	private static NewEmployeeInfoBean getEmployeeData(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("com/techchefs/hibernateapp/cache/hibernate.cache.cfg.xml");
		cfg.addAnnotatedClass(NewEmployeeInfoBean.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		NewEmployeeInfoBean bean1 =session.get(NewEmployeeInfoBean.class, 1);
		LOGGER.info(bean1.toString());
		return bean1;
	}
}
