package edu.bicheva.OnlineShop.model.entity;

import java.util.*;

public class Group extends NamedEntity {

	private static final long serialVersionUID = 5513908215852461288L;

	private List<Goods> goods;
	
	private List<Group> childrens;

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public List<Group> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Group> childrens) {
		this.childrens = childrens;
	}
	
	
}
