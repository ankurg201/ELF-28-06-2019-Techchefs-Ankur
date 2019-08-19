package com.tc.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tc.springboot.beans.EmployeeAddressInfoBean;
import com.tc.springboot.beans.EmployeeEducationInfoBean;
import com.tc.springboot.beans.EmployeeExperienceInfoBean;
import com.tc.springboot.beans.EmployeeInfoBean;
import com.tc.springboot.beans.EmployeeOtherInfoBean;
import com.tc.springboot.beans.EmployeeResponse;
import com.tc.springboot.common.EMPConstants;
import com.tc.springboot.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public String helloWorld() {
		return "Hello World";
	}

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse createEmployee(EmployeeInfoBean infoBean) {

		EmployeeResponse response = new EmployeeResponse();
		if (repository.existsById(infoBean.getId())) {
			return setEmployeeResponse(response, 401, EMPConstants.FAILED_MSG, "Employee data already exist in  Db");
		}

		infoBean.getOtherInfo().setInfoBean(infoBean);
		for (EmployeeAddressInfoBean addressInfoBean : infoBean.getAddressInfoBeans()) {
			addressInfoBean.getAddressPKBean().setInfoBean(infoBean);
		}
		for (EmployeeEducationInfoBean educationInfoBean : infoBean.getEducationInfoBeans()) {
			educationInfoBean.getEducationPKBean().setInfoBean(infoBean);
		}
		for (EmployeeExperienceInfoBean employeeExperienceInfoBean : infoBean.getExperienceInfoBeans()) {
			employeeExperienceInfoBean.getExperiencePKBean().setInfoBean(infoBean);
		}
		infoBean.setMngrId(repository.findById(infoBean.getMngrId().getId()).get());

		try {
			repository.save(infoBean);
			return setEmployeeResponse(response, 201, EMPConstants.SUCCESS_MSG, "addedd succesfully");
		} catch (Exception ex) {
			return setEmployeeResponse(response, 401, EMPConstants.FAILED_MSG, "Employee data not created in  Db");
		}
	}

	@GetMapping(path = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployee(int id) {
		EmployeeResponse response = new EmployeeResponse();
		EmployeeInfoBean bean = repository.findById(id).get();
		if (bean != null) {
			response.setInfoBeanList(Arrays.asList(bean));
			setEmployeeResponse(response, 201, EMPConstants.SUCCESS_MSG, "fetched successfully");
		} else {
			setEmployeeResponse(response, 401, EMPConstants.FAILED_MSG, "data not found");
		}
		return response;
	}
	
	@PutMapping(path = "/updateEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse modifyEmployee(EmployeeInfoBean bean) {
		EmployeeResponse response = new EmployeeResponse();

			List<EmployeeEducationInfoBean> eduBeans = bean.getEducationInfoBeans();
			for (EmployeeEducationInfoBean employeeEducationInfoBean : eduBeans) {
				employeeEducationInfoBean.getEducationPKBean().setInfoBean(bean);
			}
			List<EmployeeAddressInfoBean> addressBeans = bean.getAddressInfoBeans();
			for (EmployeeAddressInfoBean employeeAddressInfoBean : addressBeans) {
				employeeAddressInfoBean.getAddressPKBean().setInfoBean(bean);
			}
			List<EmployeeExperienceInfoBean> expBeans = bean.getExperienceInfoBeans();
			for (EmployeeExperienceInfoBean employeeExperienceInfoBean : expBeans) {
				employeeExperienceInfoBean.getExperiencePKBean().setInfoBean(bean);
			}

			EmployeeOtherInfoBean otherInfo = bean.getOtherInfo();
			otherInfo.setInfoBean(bean);

			bean.setMngrId(repository.findById(bean.getMngrId().getId()).get());
			EmployeeInfoBean result = repository.save(bean);

			if (result != null) {
				response.setStatusCode(200);
				response.setMessage(EMPConstants.SUCCESS_MSG);
				response.setDescription("data updated succesfully");
			} else {
				setEmployeeResponse(response, 401, EMPConstants.FAILED_MSG, "data not updated");
			}
			return response;
	}

	private EmployeeResponse setEmployeeResponse(EmployeeResponse response, int statusCode, String msg, String desc) {
		response.setStatusCode(statusCode);
		response.setMessage(msg);
		response.setDescription(desc);
		return response;
	}
}