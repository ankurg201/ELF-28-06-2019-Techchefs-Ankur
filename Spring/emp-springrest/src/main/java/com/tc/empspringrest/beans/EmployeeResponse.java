package com.tc.empspringrest.beans;

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
}
