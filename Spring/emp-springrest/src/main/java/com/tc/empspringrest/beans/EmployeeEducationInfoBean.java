package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Entity
@Table(name = "employee_educationinfo")
//@XmlRootElement(name = "employee-education-info")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "employee-education-info")
@Data
public class EmployeeEducationInfoBean implements Serializable {
	
	@EmbeddedId
	//@XmlElement(name="education-pk")
	private EmployeeEducationPKBean educationPKBean;
	@Column(name = "degree_type")
	//@XmlElement(name="degree-type")
	private String degreeType;
	@Column(name = "college_nm")
	//@XmlElement(name="college-name")
	private String collegeNM;
	@Column(name = "university")
	private String university;
	@Column(name = "yop")
	//@XmlElement(name="y-o-p")
	private String yop;
	@Column(name = "percentage")
	private String percentage;
	@Column(name = "location")
	private String location;
}
