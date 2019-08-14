package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;


@SuppressWarnings("serial")
@Embeddable
//@XmlRootElement(name = "employee-education-pk")
@JsonRootName(value = "employee-education-pk")
//@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class EmployeeEducationPKBean implements Serializable{

	@JoinColumn(name = "id")
	@ManyToOne
	//@XmlTransient
	@JsonIgnore
	private EmployeeInfoBean infoBean;
	@Column(name = "educational_type")
	//@XmlElement(name="educational-type")
	@JsonProperty(value = "educational-type")
	private String educationalType;
}
