package edu.bicheva.OnlineShop.model;

import java.util.*;

import edu.bicheva.OnlineShop.entity.*;

public class GoodsModel {
	
	public Goods find(){
		return new Goods(3241, "goods1", "", true, 20, Money.valueOf(30.5, "UAH"), new ArrayList<Attribute>(), new Producer("ASUS"), new Country("China"));
	}
	
	public List<Goods> findAll(){
		List<Goods> result = new ArrayList<Goods>();
		result.add(new Goods(3241, "goods1", "", true, 20, Money.valueOf(30.5, "UAH"), new ArrayList<Attribute>(), new Producer("ASUS"), new Country("China")));
		result.add(new Goods(3242, "goods2", "", true, 30, Money.valueOf(33.5, "UAH"), new ArrayList<Attribute>(), new Producer("Samsung"), new Country("China")));
		result.add(new Goods(3243, "goods3", "", true, 40, Money.valueOf(332.5, "UAH"), new ArrayList<Attribute>(), new Producer("Apple"), new Country("China")));
		
		return result;
	}
}
