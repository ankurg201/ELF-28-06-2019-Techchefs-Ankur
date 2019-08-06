package com.techchefs.hibernateMappings.bean.onetoone;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.techchefs.hibernateMappings.primary.EmployeeInfoBean;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "employee_address_info")
@Data
@ToString
@SuppressWarnings("serial")
public class EmployeeAddressInfoBean implements Serializable{
	
	@EmbeddedId
	private EmployeeAddressPKBean addressPKBean;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name = "landmark")
	private String landmark;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "pincode")
	private int pincode;
}
