package edu.bicheva.OnlineShop.entity;

import java.io.Serializable;

public enum UserStatus implements Serializable {

	BLOCKED, ACTIVE, NEED_VERIFICATION;
	
	public String toString(){
		return this.name().replaceAll("_", " ").toLowerCase();
	}
}
