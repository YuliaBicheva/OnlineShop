package edu.bicheva.OnlineShop.model.entity;

import edu.bicheva.OnlineShop.model.bean.Money;

public class Goods extends NamedEntity {

	private static final long serialVersionUID = -5329305371369280206L;

	public Goods() {
	}
	
	private Long serialNo;
	
	private String description;
	
	private String brand;
	
	private String type;
	
	private String countryOfOrigin;
	
	private Money price;
	
	private boolean availability;

	public Long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

}
