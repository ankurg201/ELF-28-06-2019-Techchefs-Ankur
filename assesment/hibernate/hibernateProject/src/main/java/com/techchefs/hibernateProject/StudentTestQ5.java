package com.techchefs.hibernateProject;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.techchefs.hibernateProject.dto.Student;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class StudentTestQ5 {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		Projection firstNameProj = Projections.property("firstName");
		Projection totalMarksProj = Projections.property("totalMarks");
		ProjectionList projList = Projections.projectionList();
		projList.add(firstNameProj);
		projList.add(totalMarksProj);
		
		List<Object[]> list = criteria.list();
		
		for(Object[] obj : list) {
			log.info(obj[0]+" "+obj[1]);
		}
	}
}
