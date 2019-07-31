package com.techchefs.hibernateProject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class StudentTestQ7 {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();
		String hql = "select Min(totalMarks), max(totalMarks), avg(totalMarks) from Student";
		Query query = session.createQuery(hql);
		
		List<Object[]> list = query.list();
		
		for(Object[] obj : list) {
			log.info(obj[0]+"  "+obj[1]+"  "+obj[2]);
		}
	}
}
