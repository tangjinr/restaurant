package com.tangz.domain;

import java.io.Serializable;

public class CartItem implements Serializable {
	private Dish dish;
	private int quantity;
	private double totalprice;

	public CartItem(Dish dish, int quantity) {
		this.dish = dish;
		this.quantity = quantity;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return dish.getPrice() * quantity;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

}
