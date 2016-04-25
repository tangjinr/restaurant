package com.tangz.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
	private Map<Integer, CartItem> cartitems = new HashMap<Integer, CartItem>();
	private double amount;

	public Map<Integer, CartItem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(Map<Integer, CartItem> cartitems) {
		this.cartitems = cartitems;
	}

	public double getAmount() {
		amount = 0;
		for (Map.Entry<Integer, CartItem> entry : cartitems.entrySet()) {
			amount += entry.getValue().getTotalprice();
		}
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void addDish(Dish dish) {
		CartItem currcartitem = (CartItem) cartitems.get(dish.getDishid());
		if (currcartitem == null) {
			CartItem cartitem = new CartItem(dish, 1);
			cartitems.put(dish.getDishid(), cartitem);
		} else {
			currcartitem.setQuantity(currcartitem.getQuantity() + 1);
		}
	}
}
