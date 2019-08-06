package com.techchefs.hibernateMappings.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techchefs.hibernateMappings.bean.onetoone.DepartmentInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeAddressInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeEducationInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeExperienceInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeOtherInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.TrainingInfoBean;
import com.techchefs.hibernateMappings.primary.EmployeeInfoBean;

public class HibernateImpl {

	private Configuration config = new Configuration();
	private SessionFactory factory = config.configure().addAnnotatedClass(EmployeeInfoBean.class)
			.addAnnotatedClass(EmployeeOtherInfoBean.class).addAnnotatedClass(EmployeeAddressInfoBean.class)
			.addAnnotatedClass(EmployeeEducationInfoBean.class).addAnnotatedClass(EmployeeExperienceInfoBean.class)
			.addAnnotatedClass(TrainingInfoBean.class).addAnnotatedClass(DepartmentInfoBean.class)
			.buildSessionFactory();

	public void createEmployee(EmployeeInfoBean infoBean, EmployeeOtherInfoBean otherInfoBean,
			List<EmployeeAddressInfoBean> addressInfoBeanList, List<EmployeeEducationInfoBean> educationInfoBeanList,
			List<EmployeeExperienceInfoBean> experienceInfoBeanList, TrainingInfoBean trainingInfoBean) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(infoBean);
		session.save(otherInfoBean);
		for (EmployeeAddressInfoBean addressInfoBean : addressInfoBeanList) {
			session.save(addressInfoBean);
		}

		for (EmployeeEducationInfoBean educationInfoBean : educationInfoBeanList) {
			session.save(educationInfoBean);
		}

		for (EmployeeExperienceInfoBean experienceInfoBean : experienceInfoBeanList) {
			session.save(experienceInfoBean);
		}

		session.save(trainingInfoBean);
		transaction.commit();
		session.close();
	}

	public void createEmployee1(TrainingInfoBean trainingInfoBean) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(trainingInfoBean);
		transaction.commit();
		session.close();
	}

	public void createEmployee2(EmployeeInfoBean bean) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(bean);
		transaction.commit();
		session.close();
	}

	public EmployeeInfoBean getEmployeeInfoBean(int id) {
		Session session = factory.openSession();
		EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, id);
		session.close();
		return bean;
	}
}
