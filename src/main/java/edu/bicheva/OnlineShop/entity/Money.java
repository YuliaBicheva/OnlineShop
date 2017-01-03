package edu.bicheva.OnlineShop.entity;

import java.io.Serializable;
import java.util.Currency;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Money implements Serializable {

	private static final long serialVersionUID = -6224047896119965237L;
	
	private static final Currency DEFAULT_CURRENCY = Currency.getInstance("UAH");

	private int integralPart;
	
	private int fractionalPart;
	
	private Currency currency;

	public Money() {
		super();
	}

	public Money(int integralPart, int fractionalPart) {
		this(integralPart, fractionalPart, DEFAULT_CURRENCY);
	}

	public Money(int integralPart, int fractionalPart, Currency currency) {
		super();
		this.integralPart = integralPart;
		this.fractionalPart = fractionalPart;
		this.currency = currency;
	}

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
	
	public static Money valueOf(double price, String currency){
		int integral = (int)price;
		int fractional = (int)(price*100 - integral*100);
		
		Money moneyValue = new Money();
		moneyValue.setIntegralPart(integral);
		moneyValue.setFractionalPart(fractional);
		moneyValue.setCurrency(Currency.getInstance(currency));
		
		return moneyValue;
	}
	
	public static Money valueOf(double price){
		int integral = (int)price;
		int fractional = (int)(price*100 - integral*100);
		
		Money moneyValue = new Money();
		moneyValue.setIntegralPart(integral);
		moneyValue.setFractionalPart(fractional);
		moneyValue.setCurrency(DEFAULT_CURRENCY);
		
		return moneyValue;
	}
	
	public double doubleValue(){
		return Double.valueOf(integralPart + "." + fractionalPart);
	}
}
