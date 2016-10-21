package edu.bicheva.OnlineShop.entity;

public class Address extends BaseEntity {
	
	private static final long serialVersionUID = 6970326974524359019L;

	private String country;
	
	private String region;
	
	private String city;

	private Integer postalCode;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
