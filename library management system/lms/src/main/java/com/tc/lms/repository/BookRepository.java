package com.tc.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tc.lms.beans.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByNameContaining(String bookSearch);
}
