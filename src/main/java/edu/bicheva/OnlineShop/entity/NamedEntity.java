package edu.bicheva.OnlineShop.entity;

public class NamedEntity extends BaseEntity {
	
	private static final long serialVersionUID = -6535062646273541435L;
	
	
	
	public NamedEntity() {
		super();
	}

	public NamedEntity(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
