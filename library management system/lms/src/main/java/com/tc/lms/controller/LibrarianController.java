package com.tc.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tc.lms.beans.BookAllotment;
import com.tc.lms.beans.Response;
import com.tc.lms.repository.BookAllotmentRepository;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	
	@Autowired
	private BookAllotmentRepository bookAllotmentRepository;
	
	
	public Response approveBook() {
		
		return null;
	}
	
	@GetMapping(path = "/notificationData", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response issueBookRequestedData(Integer issueStatus) {
		Response response = new Response();
		List<BookAllotment> allotments = bookAllotmentRepository.findAllByStatus(issueStatus);
		response.setBookAllotments(allotments);
		return response;
	}
	
	@GetMapping(path = "/notificationCount", produces = MediaType.APPLICATION_JSON_VALUE)
	public Long issueBookRequestedCount(Integer issueStatus) {
		Response response = new Response();
		Long count = bookAllotmentRepository.countByStatus(issueStatus);
		return count;
	}
}
