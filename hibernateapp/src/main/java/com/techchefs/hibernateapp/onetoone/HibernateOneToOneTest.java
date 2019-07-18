package com.techchefs.hibernateapp.onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techchefs.hibernateapp.util.HibernateUtil;
import com.techchefs.hibernateapp.util.PrepareDataUtil;

public class HibernateOneToOneTest {

	public static void main(String[] args) {
		int id = 111;
		EmployeeInfoBean data = PrepareDataUtil.prepareData(id);

		save(data);
	}

	private static void save(EmployeeInfoBean data) {
		Transaction txn = null;
		try (Session session = HibernateUtil.openSession()) {
			txn = session.beginTransaction();
			session.save(data);
			txn.commit();
		} catch (Exception e) {

			if (txn != null) {
				txn.rollback();
			}
		}
	}
}
