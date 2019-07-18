package com.techchefs.hibernateapp.criteria;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.techchefs.hibernateapp.onetoone.EmployeeInfoBean;
import com.techchefs.hibernateapp.util.HibernateUtil;

public class CallingStoreProcedure {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();
		StoredProcedureQuery query = session.createStoredProcedureCall("empdata");
		List<EmployeeInfoBean> list = query.getResultList();
	}

}
