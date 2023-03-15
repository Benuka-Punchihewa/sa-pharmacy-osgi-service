package com.sliit.orderpublisher;

import java.util.ArrayList;

public class Order {
	long id;
	int userId;
	ArrayList<Medicine> medicines;

	public Order() {
		super();
	}

	public Order(long id, int userId, ArrayList<Medicine> medicines) {
		super();
		this.id = id;
		this.userId = userId;
		this.medicines = medicines;
	}

	public long getId(long id) {
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

	public ArrayList<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(ArrayList<Medicine> medicines) {
		this.medicines = medicines;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", medicines=" + medicines + "]";
	}

}
