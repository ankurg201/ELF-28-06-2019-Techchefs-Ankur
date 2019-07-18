package com.techchefs.hibernateapp.hql;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.techchefs.hibernateapp.onetoone.EmployeeInfoBean;
import com.techchefs.hibernateapp.util.HibernateUtil;

public class ReadDemo {

	private static final Logger LOGGER = Logger.getLogger("DesignePatternsTest");

	public static void main(String[] args) {

		getEmployeeinfo();

		getNames();
	}

	private static void getEmployeeinfo() {
		Session session = HibernateUtil.openSession();
		String hql = "from EmployeeInfoBean";
		Query query = session.createQuery(hql);
		List<EmployeeInfoBean> employeeInfoBeans = query.list();
		for (EmployeeInfoBean bean : employeeInfoBeans) {
			LOGGER.info(bean.getName());
			LOGGER.info(String.valueOf(bean.getAge()));
			LOGGER.info(String.valueOf(bean.getAccountNumber()));
			LOGGER.info(bean.getGender());
			LOGGER.info(String.valueOf(bean.getId()));
		}
	}

	private static void getNames() {
		Session session = HibernateUtil.openSession();
		String hql = "select name from EmployeeInfoBean";
		Query query = session.createQuery(hql);
		List<String> names = query.list();
		for (String name : names) {
			LOGGER.info(name);
		}
	}
}
