package com.techchefs.hibernateapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.techchefs.hibernateapp.onetoone.EmployeeInfoBean;
import com.techchefs.hibernateapp.onetoone.EmployeeOtherInfoBean;

public class PrepareDataUtil {

	private PrepareDataUtil() {}
	
	public static EmployeeInfoBean prepareData(int id) {
		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		employeeInfoBean.setId(id);
		employeeInfoBean.setName("bhupindra");
		employeeInfoBean.setAge(32);
		employeeInfoBean.setDesignation("project manager");
		employeeInfoBean.setEmail("vishal@gmail.com");
		employeeInfoBean.setGender("male");
		employeeInfoBean.setJoiningDate(new Date());
		employeeInfoBean.setMngrId(1);
		employeeInfoBean.setSalary(30000.00);
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		try {
			employeeInfoBean.setDob(formatter.parse("1997-11-21"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		EmployeeOtherInfoBean otherInfo = new EmployeeOtherInfoBean();
		otherInfo.setAadhar(2345);
		otherInfo.setId(id);
		otherInfo.setBloodGroup("AB+");
		otherInfo.setFatherName("LC gupta");
		otherInfo.setChallanged(false);
		otherInfo.setEmergencyContactName("ankur");
		otherInfo.setEmergencyContactNum(9876543218L);
		otherInfo.setIsmarried(true);
		otherInfo.setMotherName("sarala gupta");
		employeeInfoBean.setOtherInfo(otherInfo);
		return employeeInfoBean;
	}
}
