package com.sliit.orderpublisher;

import java.util.ArrayList;

public class Order {
	long id;
	String userId;
	ArrayList<OrderMedicine> medicines;
	float totalPrice;

	public Order(long id, String userId, ArrayList<OrderMedicine> medicines, float totalPrice) {
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		// display order details
		sb.append("Order ID: " + this.getId() + "\tUser ID: " + this.getUserId() + "\tTotal Price: "
				+ this.getTotalPrice() + "\nMedicines\n");
		// display medicines
		for (OrderMedicine orderMedicine : this.getMedicines()) {
			sb.append("Medicine ID: " + orderMedicine.getMedicineId() + "\tQuantity: " + orderMedicine.getQuantity()
					+ "\tNet Price: " + orderMedicine.getPrice());
		}

		return sb.toString();
	}

}
