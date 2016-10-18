package edu.bicheva.OnlineShop.model.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 8307925724095122155L;

	public BaseEntity() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer id;

}
