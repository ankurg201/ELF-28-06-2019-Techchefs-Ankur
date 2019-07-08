package com.techchefs.designpatterns.builder;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;

@Getter
public class EmployeeData implements Serializable {

	private Integer id;

	private Integer deptId;

	private String name;

	private Integer age;

	private Date dob;

	private Long accountNumber;

	private String designation;

	private Long phone;

	private String email;

	private String gender;

	private Double salary;

	private Date joiningDate;

	private Integer mngrId;
	
	public EmployeeData(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
