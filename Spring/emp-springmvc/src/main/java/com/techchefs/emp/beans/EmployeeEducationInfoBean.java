package com.techchefs.emp.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "employee_educational_info")
@Data
@ToString
public class EmployeeEducationInfoBean implements Serializable{
	
	@EmbeddedId
	private EmployeeEducationPKBean educationPKBean;
	
	@Column(name = "college_name")
	private String collegeName;
	
	@Column(name = "university")
	private String university;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "degree_type")
	private String degreeType;
	
	@Column(name = "percentage")
	private String percentage;
	
	@Column(name = "yop")
	private int yop;
}
