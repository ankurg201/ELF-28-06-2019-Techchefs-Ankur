package com.tc.lms.beans;

import java.util.List;

import lombok.Data;

@Data
public class Response {
	
	private Integer statusCode;
	private String message;
	private String description;
	
	private List<User> users;
	private List<BookAllotment> bookAllotments;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<BookAllotment> getBookAllotments() {
		return bookAllotments;
	}
	public void setBookAllotments(List<BookAllotment> bookAllotments) {
		this.bookAllotments = bookAllotments;
	}
	
	
}
