package com.techchefs.hibernateapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_training")
public class EmployeeTrainingBean {

	@Id
	@Column(name = "emp_id")
	private int id;

	@Column(name = "course_id")
	private int courseId;
}
