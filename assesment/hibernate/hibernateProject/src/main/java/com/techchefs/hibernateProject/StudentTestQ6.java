package com.techchefs.hibernateProject;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

import com.techchefs.hibernateProject.dto.Student;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class StudentTestQ6 {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();
		Query query = session.createNamedQuery("studentnamedquery");
		query.setParameter("rn", 101);
		query.setParameter("sub", "hindi");
		List<Student> list = query.list();
		
		
		for(Student obj : list) {
			log.info(obj.getFirstName()+" "+obj.getTotalMarks());
		}
	}

}
