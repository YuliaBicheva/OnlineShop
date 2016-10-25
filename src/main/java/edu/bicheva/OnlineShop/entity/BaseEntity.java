package edu.bicheva.OnlineShop.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 5657982775252079801L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
