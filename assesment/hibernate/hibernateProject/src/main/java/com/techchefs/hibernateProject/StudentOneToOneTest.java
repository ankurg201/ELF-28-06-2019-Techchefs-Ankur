package com.techchefs.hibernateProject;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.techchefs.hibernateProject.dto.Student;
import com.techchefs.hibernateProject.dto.StudentOtherInfo;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class StudentOneToOneTest {

	public static void main(String[] args) {

		Student student = new Student();
		student.setRollNum(204);
		student.setFirstName("ankur");
		student.setLastName("gupta");

		StudentOtherInfo otherInfo = new StudentOtherInfo();
		otherInfo.setFatherName("lc gupta");
		otherInfo.setRollNum(student.getRollNum());
		student.setOtherInfo(otherInfo);
		Transaction tx = null;
		Session session = null;

		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception ex) {
			log.info(ex + " ");
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

}
