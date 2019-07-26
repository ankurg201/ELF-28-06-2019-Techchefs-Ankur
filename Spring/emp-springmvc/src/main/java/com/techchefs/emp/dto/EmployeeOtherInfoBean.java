package com.techchefs.emp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "other_info")
@Data
public class EmployeeOtherInfoBean {

	@Id
	@Column(name = "emp_id")
	private int id;

	@Column(name = "pan")
	private String pan;

	@Column(name = "aadhar")
	private long aadhar;

	@Column(name = "passport")
	private String passport;

	@Column(name = "ismarried")
	private boolean ismarried;

	@Column(name = "blood_grp")
	private String bloodGroup;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "emergency_contact_number")
	private long emergencyContactNum;

	@Column(name = "emergency_contact_name")
	private String emergencyContactName;

	@Column(name = "religion")
	private String religion;

	@Column(name = "mother_nm")
	private String motherName;

	@Column(name = "father_nm")
	private String fatherName;

	@Column(name = "spouse_nm")
	private String spouseName;

	@Column(name = "ischallanged")
	private boolean isChallanged;
}
