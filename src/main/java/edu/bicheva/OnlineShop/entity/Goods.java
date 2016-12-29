package edu.bicheva.OnlineShop.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Goods entity.
 * 
 * @author YuliaBicheva
 *
 */
@XmlRootElement
public class Goods extends NamedEntity {

	private static final long serialVersionUID = 76746459836029632L;

	private Long serialNo;
	
	private String description;
		
	private boolean availability;
	
	private Integer quantity;
	
	private Money price;	

	public Goods() {
		super();
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

	
}
