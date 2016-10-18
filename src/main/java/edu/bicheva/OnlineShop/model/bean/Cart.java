package edu.bicheva.OnlineShop.model.bean;

import java.io.Serializable;
import java.util.*;

import edu.bicheva.OnlineShop.model.entity.Goods;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = 4339080856729393203L;
	
	private List<CartItem> items = new ArrayList<>();

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	public void addItem(Goods goods, int amount){
		items.add(new CartItem(goods, amount));
	}

}
