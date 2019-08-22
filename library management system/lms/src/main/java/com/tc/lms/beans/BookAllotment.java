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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Entity
@Table(name = "Book_allotment")
@JsonRootName(value = "BookAllotment")
@Data
public class BookAllotment implements Serializable{
	
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"isbn","author","category","price", "bookCount", "image"})
	private User user;
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"password","userType","rollNo","phone", "email", "address", "image"})
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
