package edu.bicheva.OnlineShop.model.bean;

import java.io.Serializable;
import java.util.*;

import edu.bicheva.OnlineShop.model.entity.Goods;
import edu.bicheva.OnlineShop.model.entity.Group;

public class Shop implements Serializable {

	private static final long serialVersionUID = 2885999109864474306L;

	private List<Cart> carts = new ArrayList<>();
	
	private Group root;

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Group getRoot() {
		return root;
	}

	public void setRoot(Group root) {
		this.root = root;
	}
	
	public void buyItem(Goods goods, int amount){
		//TODO buyItem
	}
	
	public Group getCatalog(){
		return this.root;
	}
	
}
