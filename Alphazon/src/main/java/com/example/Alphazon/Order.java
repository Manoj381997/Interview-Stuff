package com.example.Alphazon;

import java.util.Date;

public class Order {
	private Date date;
	private String name;
	private String dishName;
	private int quantity;
	private int price;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [date=" + date + ", name=" + name + ", dishName=" + dishName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
}
