package com.techchefs.mywebapp.dao;

public class DepartmentDAOFactory {

	private static String dbInteractionType = "hibernate";
	
	private DepartmentDAOFactory() {}

	public static DepartmentDAO getInstance() {
		DepartmentDAO dao = null;
		
		if(dbInteractionType.equalsIgnoreCase("jdbc")){
			dao = new DepartmentDAOJDBCImpl();
		} else if(dbInteractionType.equalsIgnoreCase("hibernate")){
			dao = new DepartmentDAOHibernateImpl();
		}
		return dao;
	}
}
