package com.sliit.orderpublisher;

import java.util.ArrayList;

public class Order {
	long id;
	int userId;
	ArrayList<OrderMedicine> medicines;
	float totalPrice;

	public Order(long id, int userId, ArrayList<OrderMedicine> medicines, float totalPrice) {
		super();
		this.id = id;
		this.userId = userId;
		this.medicines = medicines;
		this.totalPrice = totalPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ArrayList<OrderMedicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(ArrayList<OrderMedicine> medicines) {
		this.medicines = medicines;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
