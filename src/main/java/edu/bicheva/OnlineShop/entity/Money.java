package edu.bicheva.OnlineShop.entity;

import java.io.Serializable;
import java.util.Currency;

public class Money implements Serializable {

	private static final long serialVersionUID = -6224047896119965237L;

	private int integralPart;
	
	private int fractionalPart;
	
	private Currency currency;

	public int getIntegralPart() {
		return integralPart;
	}

	public void setIntegralPart(int integralPart) {
		this.integralPart = integralPart;
	}

	public int getFractionalPart() {
		return fractionalPart;
	}

	public void setFractionalPart(int fractionalPart) {
		this.fractionalPart = fractionalPart;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Money valueOf(double price, String currency){
		int integral = (int)price;
		int fractional = (int)(price*100 - integral*100);
		
		Money moneyValue = new Money();
		moneyValue.setIntegralPart(integral);
		moneyValue.setFractionalPart(fractional);
		moneyValue.setCurrency(Currency.getInstance(currency));
		
		return moneyValue;
	}
	
	public double doubleValue(){
		return Double.valueOf(integralPart + "." + fractionalPart);
	}
}
