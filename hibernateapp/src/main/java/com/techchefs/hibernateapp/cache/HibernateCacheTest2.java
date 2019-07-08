package com.techchefs.hibernateapp.cache;

import java.util.logging.Logger;

import org.hibernate.Session;

import com.techchefs.hibernateapp.util.HibernateUtil;

public class HibernateCacheTest2 {
	
	private static final Logger LOGGER = Logger.getLogger("GetAllDetails");

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();
		NewEmployeeInfoBean bean1 =session.get(NewEmployeeInfoBean.class, 1);
		LOGGER.info(bean1.toString());
		
		NewEmployeeInfoBean bean2 =session.get(NewEmployeeInfoBean.class, 1);
		LOGGER.info(bean2.toString());
		
		NewEmployeeInfoBean bean3 =session.get(NewEmployeeInfoBean.class, 1);
		LOGGER.info(bean3.toString());
	}

}
