package com.techchefs.emp.dao;

import java.util.List;

import com.techchefs.emp.beans.EmployeeInfoBean;


public interface EmployeeDAO {

	List<EmployeeInfoBean> getAllEmployeeInfo();

	EmployeeInfoBean getEmployeeInfo(String id);

	EmployeeInfoBean getEmployeeInfo(int id);
	
	boolean createEmployeeInfo(EmployeeInfoBean bean);
	
	boolean updateEmployeeInfo(EmployeeInfoBean bean);
	
	boolean deleteEmployeeIfo(int id);
	
	boolean deleteEmployeeIfo(String id);
}
