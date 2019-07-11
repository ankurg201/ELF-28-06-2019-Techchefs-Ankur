package com.techchefs.mywebapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.techchefs.mywebapp.beans.DepartmentInfoBean;
import com.techchefs.mywebapp.beans.EmployeeInfoBean;
import com.techchefs.mywebapp.util.HibernateUtil;

public class DepartmentDAOHibernateImpl implements DepartmentDAO {

	@Override
	public List<DepartmentInfoBean> getAllDepartmentInfo() {
		Session session = HibernateUtil.openSession();
		String hql = "from DepartmentInfoBean";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public DepartmentInfoBean getDepartmentInfo(String id) {
		Session session = HibernateUtil.openSession();
		return session.get(DepartmentInfoBean.class, Integer.parseInt(id));
	}

	@Override
	public DepartmentInfoBean getDepartmentInfo(int id) {
		Session session = HibernateUtil.openSession();
		return session.get(DepartmentInfoBean.class, id);
	}

	@Override
	public boolean createDepartmentInfo(DepartmentInfoBean bean) {
		return saveOrUpdate(bean);
	}

	@Override
	public boolean updateDepartmentInfo(DepartmentInfoBean bean) {
		return saveOrUpdate(bean);
	}

	@Override
	public boolean deleteDepartmentInfo(int id) {
		Transaction txn = null;
		DepartmentInfoBean bean = new DepartmentInfoBean();
		bean.setDeptId(id);

		try {
			Session session = HibernateUtil.openSession();
			txn = session.beginTransaction();
			session.delete(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteDepartmentInfo(String id) {
		deleteDepartmentInfo(Integer.parseInt(id));
		return false;
	}

	private boolean saveOrUpdate(DepartmentInfoBean bean) {
		Transaction txn = null;
		try {
			Session session = HibernateUtil.openSession();
			txn = session.beginTransaction();
			session.saveOrUpdate(bean);
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
			return false;
		}
	}
}
