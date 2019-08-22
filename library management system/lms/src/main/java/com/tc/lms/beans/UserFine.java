package com.tc.lms.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Entity
@Table(name = "User_fine")
@JsonRootName(value = "UserFine")
@Data
public class UserFine implements Serializable{
	
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne
	private User user;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "fine")
	private Float fine;
	@Column(name = "fine_desc")
	private String fineDesc;
	@Column(name = "payment_status")
	private String paymentStatus;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Float getFine() {
		return fine;
	}
	public void setFine(Float fine) {
		this.fine = fine;
	}
	public String getFineDesc() {
		return fineDesc;
	}
	public void setFineDesc(String fineDesc) {
		this.fineDesc = fineDesc;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
