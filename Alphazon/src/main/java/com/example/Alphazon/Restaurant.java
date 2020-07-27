package com.example.Alphazon;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	private String name;
	private String dishName;
	private int quantity;
	private String price;
	private static List<String> restaurants = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		Restaurant.restaurants.add(name);
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public static List<String> getRestaurants() {
		return restaurants;
	}
	
	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", dishName=" + dishName + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
}
