package com.techchefs.designpatterns;

import java.util.List;
import java.util.logging.Logger;

import com.techchefs.designpatterns.beans.EmployeeInfoBean;
import com.techchefs.designpatterns.dao.EmployeeDAO;
import com.techchefs.designpatterns.dao.EmployeeDAOFactory;
import com.techchefs.designpatterns.dao.EmployeeDAOHibernateImpl;
import com.techchefs.designpatterns.dao.EmployeeDAOJDBCImpl;

import lombok.extern.java.Log;

/**
 * Hello world!
 *
 */
@Log
public class DesignePatternsTest 
{
	private static final Logger LOGGER = Logger.getLogger("DesignePatternsTest");
    public static void main( String[] args )
    {
        // EmployeeDAO dao = new EmployeeDAOJDBCImpl();
        EmployeeDAO dao = EmployeeDAOFactory.getInstance();
        printInfo(dao.getEmployeeInfo(1));
        printInfo(dao.getEmployeeInfo("2"));
        
		/*
		 * List<EmployeeInfoBean> beans = dao.getAllEmployeeInfo(); for(EmployeeInfoBean
		 * bean : beans) { printInfo(bean); }
		 */
    }
    
    private static void printInfo(EmployeeInfoBean bean) {
    	LOGGER.info(bean.getName());
    	LOGGER.info(String.valueOf(bean.getAge()));
    	LOGGER.info(String.valueOf(bean.getAccountNumber()));
    	LOGGER.info(bean.getGender());
    	LOGGER.info(String.valueOf(bean.getId()));
    }
}
