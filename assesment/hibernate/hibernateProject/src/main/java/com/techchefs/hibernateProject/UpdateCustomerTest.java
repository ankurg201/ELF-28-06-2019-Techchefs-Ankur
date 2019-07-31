package com.techchefs.hibernateProject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techchefs.hibernateProject.dto.Customer;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class UpdateCustomerTest {

	public static void main(String[] args) {
		
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			
			Customer customer = session.get(Customer.class, 1);
			customer.setContactNumber(8888888888L);
			customer.setFirstName("vinod");
			customer.setLastName("khanna");
			
			transaction = session.beginTransaction();
			session.saveOrUpdate(customer);
			transaction.commit();
			
		} catch (Exception ex) {
			log.info(ex + "");
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
}
