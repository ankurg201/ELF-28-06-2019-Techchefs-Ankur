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

public class BidirectionalApp {

	public static void main(String[] args) {
		EmployeeInfoBean infoBean = new EmployeeInfoBean();
		infoBean.setId(5);
		infoBean.setName("mohit");
		infoBean.setDesignation("md");

		EmployeeOtherInfoBean otherInfoBean = new EmployeeOtherInfoBean();
		otherInfoBean.setAadhar(78965);
		otherInfoBean.setPan("pan1234");
		otherInfoBean.setInfoBean(infoBean);

		// address info
		EmployeeAddressPKBean addressPKBean1 = new EmployeeAddressPKBean();
		addressPKBean1.setAddressType("T");
		addressPKBean1.setInfoBean(infoBean);
		EmployeeAddressPKBean addressPKBean2 = new EmployeeAddressPKBean();
		addressPKBean2.setAddressType("P");
		addressPKBean2.setInfoBean(infoBean);

		EmployeeAddressInfoBean addressInfoBean1 = new EmployeeAddressInfoBean();
		addressInfoBean1.setAddress1("jpnagar");
		addressInfoBean1.setAddressPKBean(addressPKBean1);
		EmployeeAddressInfoBean addressInfoBean2 = new EmployeeAddressInfoBean();
		addressInfoBean2.setAddress1("koramangala");
		addressInfoBean2.setAddressPKBean(addressPKBean2);

		// education info
		EmployeeEducationPKBean educationPKBean1 = new EmployeeEducationPKBean();
		educationPKBean1.setEducationType("graduation");
		educationPKBean1.setInfoBean(infoBean);
		EmployeeEducationPKBean educationPKBean2 = new EmployeeEducationPKBean();
		educationPKBean2.setEducationType("master");
		educationPKBean2.setInfoBean(infoBean);

		EmployeeEducationInfoBean educationInfoBean1 = new EmployeeEducationInfoBean();
		educationInfoBean1.setBranch("computer");
		educationInfoBean1.setCollegeName("sirmvit");
		educationInfoBean1.setEducationPKBean(educationPKBean1);

		EmployeeEducationInfoBean educationInfoBean2 = new EmployeeEducationInfoBean();
		educationInfoBean2.setBranch("computer");
		educationInfoBean2.setCollegeName("sirmvit");
		educationInfoBean2.setEducationPKBean(educationPKBean2);

		// experince info.
		EmployeeExperincePKBean experincePKBean1 = new EmployeeExperincePKBean();
		experincePKBean1.setCompany("mindtree");
		experincePKBean1.setInfoBean(infoBean);

		EmployeeExperincePKBean experincePKBean2 = new EmployeeExperincePKBean();
		experincePKBean2.setCompany("cisco");
		experincePKBean2.setInfoBean(infoBean);

		EmployeeExperienceInfoBean experienceInfoBean1 = new EmployeeExperienceInfoBean();
		experienceInfoBean1.setDesignation("sd");
		experienceInfoBean1.setExperincePKBean(experincePKBean1);

		EmployeeExperienceInfoBean experienceInfoBean2 = new EmployeeExperienceInfoBean();
		experienceInfoBean2.setDesignation("manager");
		experienceInfoBean2.setExperincePKBean(experincePKBean2);

		// training info bean
		TrainingInfoBean trainingInfoBean1 = new TrainingInfoBean();
		trainingInfoBean1.setCourseType("fulll time");
		trainingInfoBean1.setCourseId(101);
		trainingInfoBean1.setCourseName("java");
		//trainingInfoBean1.setInfoBeans(Arrays.asList(infoBean));
		
		TrainingInfoBean trainingInfoBean2 = new TrainingInfoBean();
		trainingInfoBean2.setCourseType("fulll time");
		trainingInfoBean2.setCourseId(102);
		trainingInfoBean2.setCourseName("servlet");
		//trainingInfoBean1.setInfoBeans(Arrays.asList(infoBean));

		infoBean.setOtherInfoBean(otherInfoBean);
		infoBean.setAddressInfoBeans(Arrays.asList(addressInfoBean1, addressInfoBean2));
		infoBean.setEducationInfoBeans(Arrays.asList(educationInfoBean1, educationInfoBean2));
		infoBean.setExpInfoBeans(Arrays.asList(experienceInfoBean1, experienceInfoBean2));
		infoBean.setTrainingInfoBeans(Arrays.asList(trainingInfoBean1, trainingInfoBean2));

		HibernateImpl impl = new HibernateImpl();
		impl.createEmployee2(infoBean);
	}
}
