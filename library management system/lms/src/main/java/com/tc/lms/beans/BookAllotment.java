package com.tc.lms.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Entity
@Table(name = "Book_allotment")
@JsonRootName(value = "BookAllotment")
@Data
public class BookAllotment implements Serializable{
	
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Book book;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "issue_date")
	private Date issueDate;
	@Column(name = "return_date")
	private Date returnDate;
	@Column(name = "status")
	private Integer status;
}
