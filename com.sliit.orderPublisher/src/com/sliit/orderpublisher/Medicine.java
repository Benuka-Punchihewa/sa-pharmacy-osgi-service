package com.sliit.orderpublisher;

public class Medicine {
	 int medicineId;
	 int quantity;
	
	public Medicine(int medicineId, int quantity) {
		super();
		this.medicineId = medicineId;
		this.quantity = quantity;
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
}

