package edu.bicheva.OnlineShop.entity;

import java.io.Serializable;

public enum OrderStatus implements Serializable {

	IN_PROCCESS, PAID, SEND, DELIVERED;
	
	public String toString() {
		return this.name().replaceAll("_", " ").toLowerCase();
	};
}
