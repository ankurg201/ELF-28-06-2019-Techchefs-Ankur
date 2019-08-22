package com.tc.lms.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "user")
@JsonRootName(value = "user")
@JsonIdentityInfo(generator = 
ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
public class User implements Serializable{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonProperty(value = "book-allotment")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BookAllotment> bookAllotments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonProperty(value = "user-fine")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<UserFine> userFines;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "user_type")
	private String userType;
	@Column(name = "roll_no")
	private String rollNo;
	@Column(name = "phone")
	private Long phone;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "image")
	private String image;
}
