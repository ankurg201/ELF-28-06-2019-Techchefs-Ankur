package com.techchefs.hibernateapp.criteria;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import com.techchefs.hibernateapp.dto.EmployeeInfoBean;
import com.techchefs.hibernateapp.util.HibernateUtil;

public class GetDetailsProjection {

	private static final Logger LOGGER = Logger.getLogger("GetAllDetails");

	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();
		Criteria criteria = session.createCriteria(EmployeeInfoBean.class);
		Projection pro1 = Projections.property("name");
		Projection pro2 = Projections.property("id");
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(pro1);
		projectionList.add(pro2);
		criteria.setProjection(projectionList);
		List<Object[]> list = criteria.list();

		for (Object[] obj : list) {

			LOGGER.info(obj[0].toString()+" "+obj[1].toString());
		}

	}
}
