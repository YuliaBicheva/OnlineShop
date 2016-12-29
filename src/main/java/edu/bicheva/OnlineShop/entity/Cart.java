package edu.bicheva.OnlineShop.entity;

import java.util.List;

public class Cart extends Entity {

	private static final long serialVersionUID = -8943208168165058903L;
	
	private List<CartItem> items;

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public void addItem(Goods goods, int amount){
		CartItem cartItem = new CartItem();
		cartItem.setGoods(goods);
		cartItem.setAmount(amount);
		this.items.add(cartItem);
	}
	
}
