package com.techchefs.hibernateapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_educational_info")
public class EmployeeEducationInfoBean {
	
	@Id
	@Column(name = "emp_id")
	private int id;
	
	@Id
	@Column(name = "education_type")
	private String educationType;
	
	@Column(name = "college_nn")
	private String collegeName;
	
	@Column(name = "university")
	private String university;
	
	@Column(name = "emp_id")
	private String location;
	
	@Column(name = "emp_id")
	private String branch;
	
	@Column(name = "degree_type")
	private String degreeType;
	
	@Column(name = "percentage")
	private String percentage;
	
	@Column(name = "yop")
	private int yop;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEducationType() {
		return educationType;
	}

	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

}
