package com.techchefs.hibernateProject;

import javax.persistence.Query;

import org.hibernate.Session;

import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class InsertDataQ3 {

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();

		String hql = "insert into TestDto (id, firstName, lastName, city)  select id, firstName, lastName, city from Customer";

		Query query = session.createQuery(hql);
		int count = query.executeUpdate();

		log.info(count + " ");
	}

}
