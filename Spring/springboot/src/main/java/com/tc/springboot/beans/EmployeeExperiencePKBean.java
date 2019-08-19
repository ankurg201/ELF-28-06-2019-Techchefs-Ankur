package com.tc.springboot.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;


@SuppressWarnings("serial")
@Embeddable
//@XmlRootElement(name = "employee-experience-pk")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "employee-experience-pk")
@Data
public class EmployeeExperiencePKBean implements Serializable{

	@JoinColumn(name = "id")
	@ManyToOne
	//@XmlTransient
	@JsonIgnore
	private EmployeeInfoBean infoBean;
	@Column(name = "company_name")
	//@XmlElement(name="company-name")
	private String companyName;
	public EmployeeInfoBean getInfoBean() {
		return infoBean;
	}
	public void setInfoBean(EmployeeInfoBean infoBean) {
		this.infoBean = infoBean;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
