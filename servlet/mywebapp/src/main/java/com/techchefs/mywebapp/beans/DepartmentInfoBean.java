package com.techchefs.mywebapp.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "department_info")
public class DepartmentInfoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 857411351457373236L;

	@Id
	@Column(name = "dept_id")
	private int deptId;
	
	@Column(name = "dept_name")
	private String deptName;
}
