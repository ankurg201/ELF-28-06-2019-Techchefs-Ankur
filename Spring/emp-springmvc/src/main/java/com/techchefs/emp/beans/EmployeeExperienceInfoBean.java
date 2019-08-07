package com.techchefs.emp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "employee_experince_info")
@Data
@ToString
public class EmployeeExperienceInfoBean implements Serializable {

	@EmbeddedId
	private EmployeeExperincePKBean experincePKBean;

	@Column(name = "designation")
	private String designation;

	@Column(name = "joining_date")
	private Date joiningDate;

	@Column(name = "leaving_date")
	private Date leavingDate;

}
