package com.techchefs.emp.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "training_info")
@Data
public class TrainingInfoBean implements Serializable {

	@Id
	@Column(name = "course_id")
	private int courseId;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "duration")
	private String duration;

	@Column(name = "course_type")
	private String courseType;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_training_info", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private List<EmployeeInfoBean> infoBeans;
}
