package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
@Entity
@Table(name="department_info")
//@XmlRootElement(name="department-info")
//@XmlAccessorType(XmlAccessType.FIELD)
//@JsonRootName(value = "department_info")
@Data
public class DepartmentInfoBean implements Serializable {

	@Id
	@Column(name="dept_id")
	//@XmlElement(name="department-id")
	private int departmentId;
	
	@Column(name="dept_name")
	//@XmlElement(name="department-name")
	private String departmentName;
	
}
