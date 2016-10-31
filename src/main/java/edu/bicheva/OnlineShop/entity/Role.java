package edu.bicheva.OnlineShop.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Role{
	
	@XmlEnumValue("admin") ADMIN, 
	@XmlEnumValue("customer") CUSTOMER, 
	@XmlEnumValue("anonym") ANONYM;

	public String toString(){
		return this.name().toLowerCase();
	}
}
