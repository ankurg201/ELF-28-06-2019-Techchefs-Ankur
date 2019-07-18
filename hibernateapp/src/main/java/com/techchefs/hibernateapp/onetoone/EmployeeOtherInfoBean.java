package com.techchefs.hibernateapp.onetoone;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "other_info")
public class EmployeeOtherInfoBean implements Serializable{

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public boolean isIsmarried() {
		return ismarried;
	}

	public void setIsmarried(boolean ismarried) {
		this.ismarried = ismarried;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public long getEmergencyContactNum() {
		return emergencyContactNum;
	}

	public void setEmergencyContactNum(long emergencyContactNum) {
		this.emergencyContactNum = emergencyContactNum;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public boolean isChallanged() {
		return isChallanged;
	}

	public void setChallanged(boolean isChallanged) {
		this.isChallanged = isChallanged;
	}
}
