package com.sliit.orderpublisher;

import java.util.ArrayList;

public class Order {
	 @Override
	public String toString() {
		return "Order [userId=" + userId + ", medicines=" + medicines + "]";
	}

	int userId;
	 ArrayList<Medicine> medicines;
	
	public Order(int userId, ArrayList<Medicine> medicines) {
		super();
		this.userId = userId;
		this.medicines = medicines;
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
	
	
}
