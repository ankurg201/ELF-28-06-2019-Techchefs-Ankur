package com.techchefs.designpatterns;

import java.util.List;
import java.util.logging.Logger;

import com.techchefs.designpatterns.beans.EmployeeInfoBean;
import com.techchefs.designpatterns.dao.EmployeeDAO;
import com.techchefs.designpatterns.dao.EmployeeDAOFactory;
import lombok.extern.java.Log;

/**
 * Hello world!
 *
 */
@Log
public class DesignePatternsTest {
	private static final Logger LOGGER = Logger.getLogger("DesignePatternsTest");

	public static void main(String[] args) {
		
		// fetch record from employee info table for particulat id.
		EmployeeDAO dao = EmployeeDAOFactory.getInstance();
		printInfo(dao.getEmployeeInfo(1));
		printInfo(dao.getEmployeeInfo("2"));
		
		// create record in employee info table.
		EmployeeInfoBean bean = new EmployeeInfoBean();
		bean.setName("titu");
		bean.setAge(32);
		bean.setId(20);
		LOGGER.info(String.valueOf(dao.createEmployeeInfo(bean)));
		
		// delete record employee info 
		LOGGER.info(String.valueOf(dao.deleteEmployeeIfo(4)));
		
		// print all record from employee info table.
		List<EmployeeInfoBean> employeeInfoBeans = dao.getAllEmployeeInfo();
		for (EmployeeInfoBean infoBean : employeeInfoBeans) {
			printInfo(infoBean);
		}
	}

	private static void printInfo(EmployeeInfoBean bean) {
		LOGGER.info(bean.getName());
		LOGGER.info(String.valueOf(bean.getAge()));
		LOGGER.info(String.valueOf(bean.getAccountNumber()));
		LOGGER.info(bean.getGender());
		LOGGER.info(String.valueOf(bean.getId()));
	}
}
