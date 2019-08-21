package com.tc.lms.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Entity
@Table(name = "Book")
@JsonRootName(value = "Book")
@Data
public class Book implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "author")
	private String author;
	@Column(name = "category")
	private String category;
	@Column(name = "price")
	private Float price;
	@Column(name = "book_count")
	private Integer bookCount;
	@Column(name = "image")
	private String image;
}
