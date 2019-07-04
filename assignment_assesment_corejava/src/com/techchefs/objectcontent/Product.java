package com.techchefs.objectcontent;

public class Product {
	
	private String productName;
	private String productType;
	private float cost;
	
	
	public Product(String productName, String productType, float cost) {
		this.productName = productName;
		this.productType = productType;
		this.cost = cost;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
}
