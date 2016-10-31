package edu.bicheva.OnlineShop.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum UserStatus implements Serializable {

	@XmlEnumValue(value = "blocked") BLOCKED, 
	@XmlEnumValue(value = "active") ACTIVE, 
	@XmlEnumValue(value = "need verification") NEED_VERIFICATION;
	
	public String toString(){
		return this.name().replaceAll("_", " ").toLowerCase();
	}
}
