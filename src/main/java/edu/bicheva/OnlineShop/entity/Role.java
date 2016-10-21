package edu.bicheva.OnlineShop.entity;

import java.io.Serializable;

public enum Role implements Serializable {
	
	ADMIN, CUSTOMER, ANONYM;

	public String toString(){
		return this.name().toLowerCase();
	}
}
