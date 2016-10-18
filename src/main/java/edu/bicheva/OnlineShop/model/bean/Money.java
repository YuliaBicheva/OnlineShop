package edu.bicheva.OnlineShop.model.bean;

import java.io.Serializable;

public class Money implements Serializable {

	private static final long serialVersionUID = 417956143200206477L;

	private int integralPart;
	
	private int fractionalPart;

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
	
	
	
}
