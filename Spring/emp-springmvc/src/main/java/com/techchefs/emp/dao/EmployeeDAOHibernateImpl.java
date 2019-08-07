package com.techchefs.emp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.techchefs.emp.beans.EmployeeInfoBean;

public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<EmployeeInfoBean> getAllEmployeeInfo() {
		Session session = sessionFactory.openSession();
		String hql = "from EmployeeInfoBean";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public EmployeeInfoBean getEmployeeInfo(String id) {
		Session session = sessionFactory.openSession();
		return session.get(EmployeeInfoBean.class, Integer.parseInt(id));
	}

	@Override
	public EmployeeInfoBean getEmployeeInfo(int id) {
		Session session = sessionFactory.openSession();
		return session.get(EmployeeInfoBean.class, id);
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBean bean) {
		return saveOrUpdate(bean);
	}

	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBean bean) {
		return saveOrUpdate(bean);
	}

	@Override
	public boolean deleteEmployeeIfo(int id) {
		Transaction txn = null;
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setId(id);

		try {
			Session session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.delete(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			if (txn != null)
				txn.rollback();
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteEmployeeIfo(String id) {
		deleteEmployeeIfo(Integer.parseInt(id));
		return false;
	}

	private boolean saveOrUpdate(EmployeeInfoBean bean) {
		Transaction txn = null;
		try {
			Session session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.saveOrUpdate(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<EmployeeInfoBean> getEmployeesInfoWithPattern(String id) {
		Session session = sessionFactory.openSession();
		String hql = "from EmployeeInfoBean where str(id) like :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id + "%");
		List<EmployeeInfoBean> empList = query.list();
		return empList;
	}
}
