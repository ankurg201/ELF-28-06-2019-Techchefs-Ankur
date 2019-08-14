package com.tc.empspringrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Entity
@Table(name = "employee_addressinfo")
//@XmlRootElement(name = "employee-address-info")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "employee-address-info")
@Data
public class EmployeeAddressInfoBean implements Serializable {
	
	@EmbeddedId
	//@XmlElement(name="address-pk")
	private EmployeeAddressPKBean addressPKBean;
	@Column(name = "address1")
	private String address1;
	@Column(name = "address2")
	private String address2;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "pin")
	private int pin;
}
