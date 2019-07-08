package com.techchefs.hibernateapp.hql;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techchefs.hibernateapp.util.HibernateUtil;

public class UpdateRecord {

	private static final Logger LOGGER = Logger.getLogger("DesignePatternsTest");

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// String hql = "update from EmployeeInfoBean set name=:ename where id=:eid";
			String hql = "update from EmployeeInfoBean set name="+args[0] +"where id="+args[1];
			Query query = session.createQuery(hql);
			query.setParameter("eid", 3);
			query.setParameter("ename", "arab");
			Integer result = query.executeUpdate();
			tx.commit();
			LOGGER.info(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
