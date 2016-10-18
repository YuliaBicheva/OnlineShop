package edu.bicheva.OnlineShop.model.entity;

public class Payment extends NamedEntity {

	private static final long serialVersionUID = -6465213512536457445L;
	private String userDetails;

	public String getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}
	
}
