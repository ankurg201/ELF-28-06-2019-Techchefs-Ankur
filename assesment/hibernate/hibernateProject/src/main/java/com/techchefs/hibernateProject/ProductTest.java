package com.techchefs.hibernateProject;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.techchefs.hibernateProject.dto.Products;
import com.techchefs.hibernateProject.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
public class ProductTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = HibernateUtil.openSession();

		Criteria criteria = session.createCriteria(Products.class);
		criteria.add(Restrictions.lt("price", 100.00));
		List<Products> productListPriceFilter = criteria.list();

		for (Products product : productListPriceFilter) {
			log.info("productListPriceFilter = " + product.getPrice());
		}
		
		
		Criteria criteria2 = session.createCriteria(Products.class);
		criteria.add(Restrictions.like("productName", "a*"));
		List<Products> productListNameFilter = criteria.list();

		for (Products product : productListNameFilter) {
			log.info("productListNameFilter = " + product.getProductName());
		}
	}
}
