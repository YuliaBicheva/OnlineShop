package edu.bicheva.OnlineShop.entity;

import java.time.LocalDate;

public class Order extends BaseEntity {

	private static final long serialVersionUID = 1712968972165767407L;

	private Long number;
	
	private Cart cart;
	
	private OrderStatus status;
	
	private LocalDate createDate;
	
	private Transportation transportation;
	
	private Payment payment;
	
	
	public Long getNumber() {
		return number;
	}


	public void setNumber(Long number) {
		this.number = number;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public LocalDate getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}


	public Transportation getTransportation() {
		return transportation;
	}


	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	public double caculateTotalPrice(){
		double result = 0.;
		for(CartItem ci: cart.getItems()){
			result += (ci.getGoods().getPrice().doubleValue() * ci.getAmount());
		}
		return result;
	}
}
