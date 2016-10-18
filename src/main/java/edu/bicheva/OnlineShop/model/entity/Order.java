package edu.bicheva.OnlineShop.model.entity;

import java.time.LocalDateTime;

import edu.bicheva.OnlineShop.model.bean.Cart;

public class Order extends BaseEntity {

	private static final long serialVersionUID = 4702688204051344930L;

	private Cart cart;
	
	private LocalDateTime createDate;
	
	private Status status;
	
	private Payment payment;
	
	private Transportation transportation;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}
	
	
}
