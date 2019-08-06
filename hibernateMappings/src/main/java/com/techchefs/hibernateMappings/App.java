package com.techchefs.hibernateMappings;

import java.util.Arrays;

import com.techchefs.hibernateMappings.bean.onetoone.EmployeeAddressInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeAddressPKBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeEducationInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeEducationPKBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeExperienceInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeExperincePKBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeOtherInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.TrainingInfoBean;
import com.techchefs.hibernateMappings.model.HibernateImpl;
import com.techchefs.hibernateMappings.primary.EmployeeInfoBean;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/*
		 * EmployeeInfoBean infoBean = new EmployeeInfoBean(); infoBean.setId(6);
		 * infoBean.setName("ankur"); infoBean.setDesignation("sd");
		 * infoBean.setAccountNumber(1234567L); infoBean.setAge(24);
		 * infoBean.setGender("male");
		 * 
		 * EmployeeInfoBean infoBean2 = new EmployeeInfoBean(); infoBean2.setId(7);
		 * infoBean2.setName("amit"); infoBean2.setDesignation("sd");
		 * infoBean2.setAccountNumber(1234567L); infoBean2.setAge(24);
		 * infoBean2.setGender("male");
		 * 
		 * // other info EmployeeOtherInfoBean otherInfoBean = new
		 * EmployeeOtherInfoBean(); otherInfoBean.setAadhar(123456);
		 * otherInfoBean.setPan("pan1234"); otherInfoBean.setInfoBean(infoBean);
		 * 
		 * // address info EmployeeAddressPKBean addressPKBean1 = new
		 * EmployeeAddressPKBean(); addressPKBean1.setAddressType("T");
		 * addressPKBean1.setInfoBean(infoBean); EmployeeAddressPKBean addressPKBean2 =
		 * new EmployeeAddressPKBean(); addressPKBean2.setAddressType("P");
		 * addressPKBean2.setInfoBean(infoBean);
		 * 
		 * EmployeeAddressInfoBean addressInfoBean1 = new EmployeeAddressInfoBean();
		 * addressInfoBean1.setAddress1("jpnagar");
		 * addressInfoBean1.setAddressPKBean(addressPKBean1); EmployeeAddressInfoBean
		 * addressInfoBean2 = new EmployeeAddressInfoBean();
		 * addressInfoBean2.setAddress1("koramangala");
		 * addressInfoBean2.setAddressPKBean(addressPKBean2);
		 * 
		 * // education info EmployeeEducationPKBean educationPKBean1 = new
		 * EmployeeEducationPKBean(); educationPKBean1.setEducationType("graduation");
		 * educationPKBean1.setInfoBean(infoBean); EmployeeEducationPKBean
		 * educationPKBean2 = new EmployeeEducationPKBean();
		 * educationPKBean2.setEducationType("master");
		 * educationPKBean2.setInfoBean(infoBean);
		 * 
		 * EmployeeEducationInfoBean educationInfoBean1 = new
		 * EmployeeEducationInfoBean(); educationInfoBean1.setBranch("computer");
		 * educationInfoBean1.setCollegeName("sirmvit");
		 * educationInfoBean1.setEducationPKBean(educationPKBean1);
		 * 
		 * EmployeeEducationInfoBean educationInfoBean2 = new
		 * EmployeeEducationInfoBean(); educationInfoBean2.setBranch("computer");
		 * educationInfoBean2.setCollegeName("sirmvit");
		 * educationInfoBean2.setEducationPKBean(educationPKBean2);
		 * 
		 * // experince info. EmployeeExperincePKBean experincePKBean1 = new
		 * EmployeeExperincePKBean(); experincePKBean1.setCompany("mindtree");
		 * experincePKBean1.setInfoBean(infoBean);
		 * 
		 * EmployeeExperincePKBean experincePKBean2 = new EmployeeExperincePKBean();
		 * experincePKBean2.setCompany("cisco"); experincePKBean2.setInfoBean(infoBean);
		 * 
		 * EmployeeExperienceInfoBean experienceInfoBean1 = new
		 * EmployeeExperienceInfoBean(); experienceInfoBean1.setDesignation("sd");
		 * experienceInfoBean1.setExperincePKBean(experincePKBean1);
		 * 
		 * EmployeeExperienceInfoBean experienceInfoBean2 = new
		 * EmployeeExperienceInfoBean(); experienceInfoBean2.setDesignation("manager");
		 * experienceInfoBean2.setExperincePKBean(experincePKBean2);
		 * 
		 * // training info bean TrainingInfoBean trainingInfoBean = new
		 * TrainingInfoBean(); trainingInfoBean.setCourseType("fulll time");
		 * trainingInfoBean.setCourseId(101); trainingInfoBean.setCourseName("java");
		 * trainingInfoBean.setInfoBeans(Arrays.asList(infoBean, infoBean2));
		 */
		
		EmployeeInfoBean infoBean = new EmployeeInfoBean();
		infoBean.setId(1);
		infoBean.setName("ankur");
		infoBean.setDesignation("SD");
		
		EmployeeInfoBean infoBean1 = new EmployeeInfoBean();
		infoBean1.setId(2);
		infoBean1.setName("ankur");
		infoBean1.setDesignation("SD");
		infoBean1.setMngrId(infoBean);
		
		EmployeeInfoBean infoBean2 = new EmployeeInfoBean();
		infoBean2.setId(3);
		infoBean2.setName("ankur");
		infoBean2.setDesignation("SD");
		infoBean2.setMngrId(infoBean);

		HibernateImpl impl = new HibernateImpl();
		impl.createEmployee2(infoBean);
		impl.createEmployee2(infoBean1);
		impl.createEmployee2(infoBean2);
		/*impl.createEmployee(infoBean, otherInfoBean, Arrays.asList(addressInfoBean1, addressInfoBean2),
				Arrays.asList(educationInfoBean1, educationInfoBean2),
				Arrays.asList(experienceInfoBean1, experienceInfoBean2), trainingInfoBean);*/
		
		//impl.createEmployee1(trainingInfoBean);
		
		TrainingInfoBean trainingInfoBean = new TrainingInfoBean();
		trainingInfoBean.setCourseType("fulll time");
		trainingInfoBean.setCourseId(101);
		trainingInfoBean.setCourseName("java");
		
		impl.getEmployeeInfoBean(2);
		trainingInfoBean.setInfoBeans(Arrays.asList(infoBean, infoBean2));
	}
}
