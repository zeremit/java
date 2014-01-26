package com.kharevich.pricetools.logic;

import java.math.BigDecimal;

public class ProductData {
	
	private String iD;
	
	private String code;
	
	private String model;
	
	private BigDecimal price;
	
	private BigDecimal partnerPrice;
		
	private Integer quantity;
	
	private String description;
	
	private String sku;

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPartnerPrice() {
		return partnerPrice;
	}

	public void setPartnerPrice(BigDecimal partnerPrice) {
		this.partnerPrice = partnerPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}
