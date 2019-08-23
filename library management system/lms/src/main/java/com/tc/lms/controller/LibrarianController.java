package com.tc.lms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tc.lms.beans.BookAllotment;
import com.tc.lms.beans.Response;
import com.tc.lms.common.UserConstants;
import com.tc.lms.repository.BookAllotmentRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/librarian")
public class LibrarianController {

	@Autowired
	private BookAllotmentRepository bookAllotmentRepository;

	@GetMapping(path = "/requestBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response requestBook(Integer bookAllotmentId, Integer actionType) {
		Response response = new Response();
		BookAllotment bookAllotment = bookAllotmentRepository.findById(bookAllotmentId).get();
		bookAllotment.setStatus(actionType);
		BookAllotment allotment = bookAllotmentRepository.save(bookAllotment);
		if (allotment != null) {
			response.setBookAllotments(Arrays.asList(allotment));
			setResponse(response, 201, UserConstants.SUCCESS_MSG, "book issued or rejected succesful");
		} else {
			setResponse(response, 401, UserConstants.FAILED_MSG, "book issue or rejected failed");
		}
		return response;
	}

	@GetMapping(path = "/notificationData", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response issueBookRequestedData(Integer issueStatus) {
		Response response = new Response();
		List<BookAllotment> allotments = bookAllotmentRepository.findAllByStatus(issueStatus);
		response.setBookAllotments(allotments);
		setResponse(response, 201, UserConstants.SUCCESS_MSG, "notification data fetched succesful");
		return response;
	}

	@GetMapping(path = "/notificationCount", produces = MediaType.APPLICATION_JSON_VALUE)
	public Long issueBookRequestedCount(Integer issueStatus) {
		Response response = new Response();
		Long count = bookAllotmentRepository.countByStatus(issueStatus);
		return count;
	}

	private Response setResponse(Response response, Integer statusCode, String msg, String desc) {
		response.setStatusCode(statusCode);
		response.setMessage(msg);
		response.setDescription(desc);
		return response;
	}
}
