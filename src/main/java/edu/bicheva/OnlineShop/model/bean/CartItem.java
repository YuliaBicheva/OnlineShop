package edu.bicheva.OnlineShop.model.bean;

import java.io.Serializable;

import edu.bicheva.OnlineShop.model.entity.Goods;

public class CartItem implements Serializable {

	private static final long serialVersionUID = -8637786800012726876L;

	private Goods goods;
	
	private int amount;
	
	public CartItem() {
		super();
	}

	public CartItem(Goods goods, int amount) {
		super();
		this.goods = goods;
		this.amount = amount;
	}

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
