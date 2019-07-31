package com.techchefs.hibernateProject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techchefs.hibernateProject.dto.Customer;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class FetchCustomerTest {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			Customer customer = session.get(Customer.class, 1);
			
			log.info(customer.getAddress());
			log.info(customer.getCity());
			log.info(customer.getCountry());
			log.info(customer.getFirstName());
			log.info(customer.getLastName());
			
		} catch (Exception ex) {
			log.info(ex + "");
		} finally {
			session.close();
		}
	}
}
