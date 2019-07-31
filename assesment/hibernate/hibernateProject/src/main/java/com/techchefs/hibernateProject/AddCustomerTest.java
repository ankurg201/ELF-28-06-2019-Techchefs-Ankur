package com.techchefs.hibernateProject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techchefs.hibernateProject.dto.Customer;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class AddCustomerTest {

	public static void main(String[] args) {
		
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			
			Customer customer = new Customer();
			customer.setId(1);
			customer.setAddress("jpnagar");
			customer.setCity("bangalore");
			customer.setContactNumber(9887654321L);
			customer.setCountry("india");
			customer.setFirstName("Ankur");
			customer.setLastName("gupta");
			customer.setState("Karnataka");
			
			transaction = session.beginTransaction();
			session.save(customer);
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
