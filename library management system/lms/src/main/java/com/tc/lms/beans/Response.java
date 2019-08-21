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
}
