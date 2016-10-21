package edu.bicheva.OnlineShop.entity;

import java.io.Serializable;

public class CartItem implements Serializable{
	
	private static final long serialVersionUID = 2599961951384778275L;

	private Goods goods;
	
	private int amount;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
