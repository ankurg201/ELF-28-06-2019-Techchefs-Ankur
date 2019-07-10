package com.techchefs.designpatterns.dao;

import java.util.List;

import com.techchefs.designpatterns.beans.EmployeeInfoBean;


public interface EmployeeDAO {

	List<EmployeeInfoBean> getAllEmployeeInfo();

	EmployeeInfoBean getEmployeeInfo(String id);

	EmployeeInfoBean getEmployeeInfo(int id);
	
	boolean createEmployeeInfo(EmployeeInfoBean bean);
	
	boolean updateEmployeeInfo(EmployeeInfoBean bean);
	
	boolean deleteEmployeeIfo(int id);
	
	boolean deleteEmployeeIfo(String id);
}
