package com.sliit.medicinepublisher;

import java.io.Serializable;

public class Medicine implements Serializable{
	
	private int id;
	private String name;
	private float price;
	private int stock;
	
	
	public Medicine(int id, String name, float price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}


	public Medicine() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		// display medicine details
		sb.append("Medicine ID: " + this.getId() + "\tName: " + this.getName() + "\tPrice: "
				+ this.getPrice() + "\tStock: " + this.getStock());
		
		return sb.toString();
	}

}
