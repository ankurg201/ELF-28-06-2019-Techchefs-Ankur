package com.techchefs.hibernateapp.criteria;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.techchefs.hibernateapp.dto.EmployeeInfoBean;
import com.techchefs.hibernateapp.util.HibernateUtil;

public class GetAllDetails {

	private static final Logger LOGGER = Logger.getLogger("GetAllDetails");

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(EmployeeInfoBean.class).add(Restrictions.gt("salary", 20000.00));
		// Criterion criterion = Restrictions.eq("id", 1);
		// criteria.add(criterion);
		// EmployeeInfoBean bean = (EmployeeInfoBean) criteria.uniqueResult();
		List<EmployeeInfoBean> beans = criteria.list();

		for (EmployeeInfoBean bean : beans) {
			LOGGER.info(bean.getName());
			LOGGER.info(String.valueOf(bean.getAge()));
			LOGGER.info(String.valueOf(bean.getAccountNumber()));
			LOGGER.info(bean.getGender());
			LOGGER.info(String.valueOf(bean.getId()));
		}
	}

}
