package edu.bicheva.OnlineShop.entity;

/**
 * Producer entity.
 * 
 * @author YuliaBicheva
 *
 */
public class Producer extends NamedEntity {

	private static final long serialVersionUID = -5521768692009261662L;

	private String contryOfOrigin;
	
	public Producer() {
		super();
	}

	public Producer(String name) {
		super(name);
	}

	public String getContryOfOrigin() {
		return contryOfOrigin;
	}

	public void setContryOfOrigin(String contryOfOrigin) {
		this.contryOfOrigin = contryOfOrigin;
	}

	
}
