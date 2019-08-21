package com.tc.lms.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tc.lms.beans.Response;
import com.tc.lms.beans.User;
import com.tc.lms.common.UserConstants;
import com.tc.lms.repository.UserRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response doLogin(Integer id, String password) {
		Response response = new Response();
		User user = userRepository.findById(id).get();
		if (user != null && user.getPassword().equals(password)) {
			response.setUsers(Arrays.asList(user));
			setResponse(response, 201, UserConstants.SUCCESS_MSG, "user logged in succesful");
			return response;
		}
		setResponse(response, 401, UserConstants.FAILED_MSG, "user credential failed");
		return response;
	}

	private Response setResponse(Response response, Integer statusCode, String msg, String desc) {
		response.setStatusCode(statusCode);
		response.setMessage(msg);
		response.setDescription(desc);
		return response;
	}
}
