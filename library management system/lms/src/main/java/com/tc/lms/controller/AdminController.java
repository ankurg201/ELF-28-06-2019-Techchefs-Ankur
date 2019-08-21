package com.tc.lms.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tc.lms.beans.Response;
import com.tc.lms.beans.User;
import com.tc.lms.common.UserConstants;
import com.tc.lms.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserRepository repository;

	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response createUser(@RequestBody User user) {
		Response response = new Response();
		try {
			User userBean = repository.save(user);
			response.setUsers(Arrays.asList(userBean));
			setResponse(response, 201, UserConstants.SUCCESS_MSG, "user created succesfully");
		} catch (Exception ex) {
			setResponse(response, 401, UserConstants.FAILED_MSG, "user creation failed");
			ex.printStackTrace();
		}
		return response;
	}
	
	@PostMapping(path = "/remove", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response removeUser(Integer id) {
		Response response = new Response();
		try {
			repository.deleteById(id);
			setResponse(response, 201, UserConstants.SUCCESS_MSG, "user deleted succesfully");
		} catch (Exception ex) {
			setResponse(response, 401, UserConstants.FAILED_MSG, "user deletion failed");
			ex.printStackTrace();
		}
		return response;
	}
	
	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateUser(@RequestBody User user) {
		Response response = new Response();
		try {
			User userBean = repository.save(user);
			response.setUsers(Arrays.asList(userBean));
			setResponse(response, 201, UserConstants.SUCCESS_MSG, "user updated succesfully");
		} catch (Exception ex) {
			setResponse(response, 401, UserConstants.FAILED_MSG, "user updation failed");
			ex.printStackTrace();
		}
		return response;
	}

	private Response setResponse(Response response, Integer statusCode, String msg, String desc) {
		response.setStatusCode(statusCode);
		response.setMessage(msg);
		response.setDescription(desc);
		return response;
	}
}
