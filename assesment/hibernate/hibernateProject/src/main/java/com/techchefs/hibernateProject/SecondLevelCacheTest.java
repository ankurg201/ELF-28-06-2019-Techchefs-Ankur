package com.techchefs.hibernateProject;

import org.hibernate.Session;

import com.techchefs.hibernateProject.dto.EmployeeInfoBean;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class SecondLevelCacheTest {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();
		
		EmployeeInfoBean bean1 = session.get(EmployeeInfoBean.class, 1);
		
		log.info(bean1+"");
		EmployeeInfoBean bean2 = session.get(EmployeeInfoBean.class, 1);
		log.info(bean2+"");
		EmployeeInfoBean bean3 = session.get(EmployeeInfoBean.class, 1);
		log.info(bean3+"");
	}

}
