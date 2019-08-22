package com.tc.lms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tc.lms.beans.Book;
import com.tc.lms.beans.BookAllotment;
import com.tc.lms.beans.Response;
import com.tc.lms.beans.User;
import com.tc.lms.common.UserConstants;
import com.tc.lms.repository.BookAllotmentRepository;
import com.tc.lms.repository.BookRepository;
import com.tc.lms.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookAllotmentRepository bookAllotmentRepository;

	@Autowired
	private BookRepository bookRepository;

	@GetMapping(path = "/alluser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllUser() {
		Response response = new Response();
		List<User> users = userRepository.findAll();
		if (users != null) {
			response.setUsers(users);
			setResponse(response, 201, UserConstants.SUCCESS_MSG, "all user fetched");
		} else {
			setResponse(response, 401, UserConstants.FAILED_MSG, "all user not fetched");
		}
		return response;
	}

	@PostMapping(path = "/issueBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response issueBook(@RequestBody BookAllotment bookAllotment) {
		Response response = new Response();
		BookAllotment bookAllotmentBean = bookAllotmentRepository.save(bookAllotment);
		if (bookAllotmentBean == null) {
			return setResponse(response, 401, UserConstants.FAILED_MSG, "book allotment request failed");
		}
		response.setBookAllotments(Arrays.asList(bookAllotmentBean));
		return setResponse(response, 201, UserConstants.SUCCESS_MSG, "book allotment request succesful");
	}

	@GetMapping(path = "/searchBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response searchBook(String bookSearch) {
		Response response = new Response();
		List<Book> books = bookRepository.findByNameContaining(bookSearch);
		if (books != null) {
			response.setBooks(books);
			setResponse(response, 201, UserConstants.SUCCESS_MSG, "search book by category succesful");
		} else {
			return setResponse(response, 401, UserConstants.FAILED_MSG, "book not found failed");
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
