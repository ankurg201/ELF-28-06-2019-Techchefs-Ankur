package com.techchefs.hibernateapp.hql;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techchefs.hibernateapp.util.HibernateUtil;

public class DeleteDemo {
	
	private static final Logger LOGGER = Logger.getLogger("DeleteDemo");
	
	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "delete from EmployeeInfoBean where id=:eid";
			Query query = session.createQuery(hql);
			query.setParameter("eid", 3);
			Integer result = query.executeUpdate();
			tx.commit();
			LOGGER.info("deleted = "+result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
}
