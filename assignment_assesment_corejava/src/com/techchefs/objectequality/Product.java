package com.techchefs.objectequality;

public class Product {

	private String productName;
	private String productType;
	private Float cost;

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

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		Product p = (Product) obj;
		if (getProductName().equals(p.getProductName()) && getCost() == p.getCost()
				&& getProductType().equals(p.getProductType())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		return result;
	}
}
