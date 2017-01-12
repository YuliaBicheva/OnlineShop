package edu.bicheva.OnlineShop.exception;


public enum MessageType {
	INFO, ERROR;
	
	public String getString() {
		return this.name().toLowerCase();
	}
}
