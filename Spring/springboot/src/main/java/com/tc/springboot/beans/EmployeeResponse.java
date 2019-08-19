package com.tc.springboot.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@JsonRootName("employee-response")
@Data
public class EmployeeResponse {
	
	@JsonProperty("status-code")
	private Integer statusCode;
	private String message;
	private String Description;
	
	private List<EmployeeInfoBean> infoBeanList;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<EmployeeInfoBean> getInfoBeanList() {
		return infoBeanList;
	}

	public void setInfoBeanList(List<EmployeeInfoBean> infoBeanList) {
		this.infoBeanList = infoBeanList;
	}
	
	
}
