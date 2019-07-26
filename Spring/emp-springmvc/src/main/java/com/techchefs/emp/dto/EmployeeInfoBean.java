package com.techchefs.emp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.print.attribute.standard.MediaSize.Other;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
public class EmployeeInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private EmployeeOtherInfoBean otherInfo;

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name="password")
	private String password;

	@Column(name = "dept_id")
	private Integer deptId;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "account_number")
	private Long accountNumber;

	@Column(name = "designation")
	private String designation;

	@Column(name = "phone")
	private Long phone;

	@Column(name = "email")
	private String email;

	@Column(name = "gender")
	private String gender;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "joining_date")
	private Date joiningDate;

	@Column(name = "mngr_id")
	private Integer mngrId;
}
