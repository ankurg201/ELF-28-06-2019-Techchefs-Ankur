package com.techchefs.hibernateProject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "student_otherinfo")
@Entity
@Data
public class StudentOtherInfo {
	
	@Id
	@Column(name = "roll_num")
	private Integer rollNum;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "religion")
	private String religion;
	
	@Column(name = "nationality")
	private String nationality;
}
