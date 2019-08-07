package com.techchefs.hibernateProj;

import org.hibernate.Session;

import com.techchefs.hibernateProj.beans.EmployeeInfoBean;
import com.techchefs.hibernateProj.util.HibernateUtil;

import lombok.extern.java.Log;

/**
 * Hello world!
 *
 */
@Log
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Session session = HibernateUtil.openSession();
		EmployeeInfoBean bean = session.get(EmployeeInfoBean.class, 1);
		log.info("1st employee = "+bean.getName());
		log.info("1st employee = "+bean.getOtherInfo().getAadhar());
		
		EmployeeInfoBean bean2 = session.get(EmployeeInfoBean.class, 1);
		log.info("2st employee = "+bean2.getName());
	
		
		Session session2 = HibernateUtil.openSession();
		EmployeeInfoBean bean3 = session2.get(EmployeeInfoBean.class, 1);
		log.info("3st employee = "+bean3.getName());
		
		
		// hql
		/*
		 * Transaction tx = session.beginTransaction(); Query query =
		 * session.createQuery("update EmployeeInfoBean set name=:nm where id =:id");
		 * query.setParameter("id", 1); query.setParameter("nm", "vinod");
		 * log.info("updated record = "+query.executeUpdate()); tx.commit();
		 * 
		 * 
		 * Query query2 = session.createQuery("from EmployeeInfoBean where id =:id");
		 * query2.setParameter("id", 1); List<EmployeeInfoBean> beanList =
		 * query2.list();
		 * 
		 * 
		 * log.info("list = "+beanList.get(0).getName());
		 * 
		 * Criteria criteria = session.createCriteria(EmployeeInfoBean.class);
		 * criteria.add(Restrictions.gt("id", 1)); List<EmployeeInfoBean> beanList2 =
		 * criteria.list(); log.info("Criteria list = "+beanList2.size());
		 * 
		 * Criteria criteria2 = session.createCriteria(EmployeeInfoBean.class);
		 * Projection proj1 = Projections.property("id"); Projection proj2 =
		 * Projections.property("name"); ProjectionList projList =
		 * Projections.projectionList(); projList.add(proj1); projList.add(proj2);
		 * criteria.setProjection(projList);
		 * 
		 * List<Object[]> obj = criteria.list();
		 * 
		 * for(Object[] object : obj) { log.info(object[0]+" "+object[1]); }
		 */
		
		
	}
}
