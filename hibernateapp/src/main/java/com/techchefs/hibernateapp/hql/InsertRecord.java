package com.techchefs.hibernateapp.hql;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techchefs.hibernateapp.util.HibernateUtil;

public class InsertRecord {

	private static final Logger LOGGER = Logger.getLogger("InsertRecord");

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "insert into EmployeeInfoBean(id, name, age) "
					+ "select name, age from EmployeeInfoBean where id=1";
			Query query = session.createQuery(hql);
			//query.setParameter("eid", 3);
			Integer result = query.executeUpdate();
			tx.commit();
			LOGGER.info("inserted = " + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
