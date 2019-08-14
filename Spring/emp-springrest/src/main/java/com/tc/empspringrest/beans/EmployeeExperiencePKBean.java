package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
}
