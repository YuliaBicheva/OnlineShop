package edu.bicheva.OnlineShop.model.entity;

public enum Status {
	IN_PROCCESS, WAIT_PAYMENT, PAID, DELIVERED;
	
	public String toString(){
		return  this.name().replaceAll("_", " ").toLowerCase();
	}
}
