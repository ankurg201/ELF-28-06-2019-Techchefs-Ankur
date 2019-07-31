package com.techchefs.hibernateProject;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;

import com.techchefs.hibernateProject.dto.Student;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class StudentTestQ8 {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSession();
		StoredProcedureQuery procedureQuery = session.createStoredProcedureCall("StudentProcedure");
		List<Student> list = procedureQuery.getResultList();
		
		for(Student std : list) {
			log.info(std+" ");
		}
	}
}
