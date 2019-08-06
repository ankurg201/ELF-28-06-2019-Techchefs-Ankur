package com.techchefs.hibernateMappings.primary;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.techchefs.hibernateMappings.bean.onetoone.DepartmentInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeAddressInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeEducationInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeExperienceInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.EmployeeOtherInfoBean;
import com.techchefs.hibernateMappings.bean.onetoone.TrainingInfoBean;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "employee_info")
@Data
public class EmployeeInfoBean implements Serializable {

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "infoBean")
	private EmployeeOtherInfoBean otherInfoBean;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPKBean.infoBean")
	private List<EmployeeAddressInfoBean> addressInfoBeans;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPKBean.infoBean")
	private List<EmployeeEducationInfoBean> educationInfoBeans;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "experincePKBean.infoBean")
	private List<EmployeeExperienceInfoBean> expInfoBeans;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "infoBeans")
	private List<TrainingInfoBean> trainingInfoBeans;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "account_number")
	private Long accountNumber;

	@Column(name = "designation")
	private String designation;

	@Column(name = "phone")
	private Long phone;

	@Column(name = "email")
	private String email;

	@Column(name = "gender")
	private String gender;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "joining_date")
	private Date joiningDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mngr_id", referencedColumnName = "id")
	private EmployeeInfoBean mngrId;

	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "dept_id")
	private DepartmentInfoBean deptInfoBean;

}
