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
//@XmlRootElement(name = "employee-address-pk")
//@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "employee-address-pk")
@Embeddable
@Data
public class EmployeeAddressPKBean implements Serializable {
	
	//@XmlTransient
	@JoinColumn(name = "id")
	@ManyToOne
	@JsonIgnore
	private EmployeeInfoBean infoBean;
	@Column(name = "address_type")
	
	//@XmlElement(name="address-type")
	private String addressType;
	public EmployeeInfoBean getInfoBean() {
		return infoBean;
	}
	public void setInfoBean(EmployeeInfoBean infoBean) {
		this.infoBean = infoBean;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	
}
