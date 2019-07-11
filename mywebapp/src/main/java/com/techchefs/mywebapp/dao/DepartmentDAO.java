package com.techchefs.mywebapp.dao;

import java.util.List;

import com.techchefs.mywebapp.beans.DepartmentInfoBean;
import com.techchefs.mywebapp.beans.EmployeeInfoBean;


public interface DepartmentDAO {

	List<DepartmentInfoBean> getAllDepartmentInfo();

	DepartmentInfoBean getDepartmentInfo(String id);

	DepartmentInfoBean getDepartmentInfo(int id);

	boolean createDepartmentInfo(DepartmentInfoBean bean);

	boolean updateDepartmentInfo(DepartmentInfoBean bean);

	boolean deleteDepartmentInfo(int id);

	boolean deleteDepartmentInfo(String id);

	
}
