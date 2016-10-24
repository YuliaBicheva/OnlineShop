package edu.bicheva.OnlineShop.entity;

import java.util.List;

public class Goods extends NamedEntity {

	private static final long serialVersionUID = 76746459836029632L;

	private Long serialNo;
	
	private String description;
	
	private String imageUrl;
	
	private boolean availability;
	
	private Integer quantity;
	
	private Money price;
	
	private List<Attribute> attributes;
	
	private Producer producer;
	
	private Country countryOfOrigin;
	
	

	public Goods() {
		super();
	}

	public Goods(long serialNo, String description, String imageUrl, boolean availability, int quantity,
			Money price, List<Attribute> attributes, Producer producer, Country countryOfOrigin) {
		super();
		this.serialNo = serialNo;
		this.description = description;
		this.imageUrl = imageUrl;
		this.availability = availability;
		this.quantity = quantity;
		this.price = price;
		this.attributes = attributes;
		this.producer = producer;
		this.countryOfOrigin = countryOfOrigin;
	}

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Country getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(Country countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
}
