package edu.bicheva.OnlineShop.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Root of all entities which have name field.
 * 
 * @author YuliaBicheva
 *
 */
@XmlRootElement
public class NamedEntity extends Entity {
	
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
