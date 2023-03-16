package com.sliit.orderpublisher;

public class OrderMedicine {
	int medicineId;
	int quantity;
	float price;

	public OrderMedicine(int medicineId, int quantity, float price) {
		super();
		this.medicineId = medicineId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
