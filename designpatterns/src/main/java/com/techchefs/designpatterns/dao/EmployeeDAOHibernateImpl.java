package com.techchefs.designpatterns.dao;

import java.util.List;

import org.hibernate.Session;

import com.techchefs.designpatterns.beans.EmployeeInfoBean;
import com.techchefs.hibernateapp.util.HibernateUtil;

public class EmployeeDAOHibernateImpl  implements EmployeeDAO{

	@Override
	public List<EmployeeInfoBean> getAllEmployeeInfo() {
		// TO DO
		return null;
	}

	@Override
	public EmployeeInfoBean getEmployeeInfo(String id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.get(EmployeeInfoBean.class, Integer.parseInt(id));
	}

	@Override
	public EmployeeInfoBean getEmployeeInfo(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.get(EmployeeInfoBean.class, id);
	}
}
