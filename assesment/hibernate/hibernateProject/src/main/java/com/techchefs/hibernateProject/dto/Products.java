package com.techchefs.hibernateProject.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "products")
@Entity
@Data
public class Products {
	
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "weight")
	private Double weight;
}
