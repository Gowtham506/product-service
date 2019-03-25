package com.epam.dtos;

public class ProductDTO {

	private Long productRequestId;
	private String productName;
	private String productType;
	private float price;

	public Long getProductRequestId() {
		return productRequestId;
	}

	public void setProductRequestId(Long productRequestId) {
		this.productRequestId = productRequestId;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
