package com.techchefs.emp.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAOFactory {

	@Bean(name = "jdbc")
	public static EmployeeDAO getInstanceJdbc() {
		// return new EmployeeDAOJDBCImpl();
		return null;
	}

	@Bean(name = "hibernate")
	public static EmployeeDAO getInstanceHibernate() {
		return new EmployeeDAOHibernateImpl();
	}
}
