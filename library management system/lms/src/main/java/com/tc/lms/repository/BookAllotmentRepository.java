package com.tc.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tc.lms.beans.BookAllotment;

@Repository
public interface BookAllotmentRepository extends JpaRepository<BookAllotment, Integer>{

	List<BookAllotment> findAllByStatus(Integer issueStatus);
	
	Long countByStatus(Integer status);
}
