package edu.bicheva.OnlineShop.entity;

public class Attribute extends NamedEntity {

	private static final long serialVersionUID = -6009267773151662839L;
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
