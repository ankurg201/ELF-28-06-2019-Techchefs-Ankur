package com.techchefs.hibernateapp.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_experince_info")
public class EmployeeExperienceInfoBean {
	
	@Id
	@Column(name = "emp_id")
	private int id;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "joining_date")
	private Date joiningDate;
	
	@Column(name = "leaving_date")
	private Date leavingDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

}
