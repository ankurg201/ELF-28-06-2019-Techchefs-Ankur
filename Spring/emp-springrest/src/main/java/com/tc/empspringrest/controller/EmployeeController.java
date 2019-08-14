package com.tc.empspringrest.controller;

import static com.tc.empspringrest.common.EMPConstants.DB_INTERACTION_TYPE;
import static com.tc.empspringrest.common.EMPConstants.PROPERTY_FILENAME;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tc.empspringrest.beans.EmployeeAddressInfoBean;
import com.tc.empspringrest.beans.EmployeeEducationInfoBean;
import com.tc.empspringrest.beans.EmployeeExperienceInfoBean;
import com.tc.empspringrest.beans.EmployeeInfoBean;
import com.tc.empspringrest.beans.EmployeeOtherInfoBean;
import com.tc.empspringrest.beans.EmployeeResponse;
import com.tc.empspringrest.common.EMPConstants;
import com.tc.empspringrest.dao.EmployeeDao;

@RestController
@RequestMapping("/employee")
@PropertySource(PROPERTY_FILENAME)
public class EmployeeController {

	@Autowired
	@Qualifier(DB_INTERACTION_TYPE)
	EmployeeDao dao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@DeleteMapping("/removeEmployee/{id}")
	public EmployeeResponse deleteEmployee(@PathVariable("id") int id, HttpServletRequest request) {
		EmployeeResponse response = new EmployeeResponse();
		if (request.getSession(false) != null) {
			boolean result = dao.deleteEmployeeInfo(id);
			if (result) {
				response.setStatusCode(200);
				response.setMessage(EMPConstants.SUCCESS_MSG);
				response.setDescription("data deleted succesfully");
			} else {
				response.setStatusCode(401);
				response.setMessage(EMPConstants.FAILED_MSG);
				response.setDescription("data not deleted");
			}
			return response;
		} else {
			return setEmployeeResponse(response, 501, EMPConstants.FAILED_MSG, "please login first");
		}
	}

	@GetMapping(path = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployee(@RequestParam(name = "empId") int id, HttpServletRequest request) {
		EmployeeResponse response = new EmployeeResponse();
		if (request.getSession(false) != null) {
			EmployeeInfoBean bean = dao.getEmployeeInfo(id);
			if (bean != null) {
				response.setInfoBeanList(Arrays.asList(bean));
				setEmployeeResponse(response, 201, EMPConstants.SUCCESS_MSG, "fetched successfully");
			} else {
				setEmployeeResponse(response, 401, EMPConstants.FAILED_MSG, "data not found");
			}
			return response;
		} else {
			return setEmployeeResponse(response, 501, EMPConstants.FAILED_MSG, "please login first");
		}
	}

	@GetMapping(path = "/getAllEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployee(HttpServletRequest request) {
		EmployeeResponse response = new EmployeeResponse();
		if (request.getSession(false) != null) {
			List<EmployeeInfoBean> beans = dao.getAllEmployeeInfo();
			if (beans != null) {
				response.setInfoBeanList(beans);
				setEmployeeResponse(response, 201, EMPConstants.SUCCESS_MSG, "fetched successfully");
			} else {
				setEmployeeResponse(response, 401, EMPConstants.FAILED_MSG, "data not found");
			}
			return response;
		} else {
			return setEmployeeResponse(response, 501, EMPConstants.FAILED_MSG, "data not found");
		}
	}

	@PostMapping(path = "/createEmployee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean bean) {

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

		bean.setMngrId(dao.getEmployeeInfo(bean.getMngrId().getId()));
		boolean result = dao.createEmployeeInfo(bean);
		EmployeeResponse response = new EmployeeResponse();
		if (result) {
			response.setStatusCode(200);
			response.setMessage(EMPConstants.SUCCESS_MSG);
			response.setDescription("data added succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage(EMPConstants.FAILED_MSG);
			response.setDescription("data not added");
		}
		return response;

	}

	@PutMapping(path = "/updateEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse modifyEmployee(EmployeeInfoBean bean, HttpSession session, HttpServletRequest request) {
		EmployeeResponse response = new EmployeeResponse();
		if (request.getSession(false) != null) {

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

			bean.setMngrId(dao.getEmployeeInfo(bean.getMngrId().getId()));
			boolean result = dao.updateEmployeeInfo(bean);

			if (result) {
				response.setStatusCode(200);
				response.setMessage(EMPConstants.SUCCESS_MSG);
				response.setDescription("data updated succesfully");
			} else {
				setEmployeeResponse(response, 401, EMPConstants.FAILED_MSG, "data not updated");
			}
			return response;
		} else {
			return setEmployeeResponse(response, 501, EMPConstants.FAILED_MSG, "please login first");
		}
	}

	private EmployeeResponse setEmployeeResponse(EmployeeResponse response, int statusCode, String msg, String desc) {
		response.setStatusCode(200);
		response.setMessage(msg);
		response.setDescription(desc);
		return response;
	}
}
