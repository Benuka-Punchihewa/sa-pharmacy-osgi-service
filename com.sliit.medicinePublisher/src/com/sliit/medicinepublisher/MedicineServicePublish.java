package com.sliit.medicinepublisher;

public interface MedicineServicePublish {
	
	public Medicine createMedicine(int id , String name, float price, int stock);
	public Medicine getMedicineById(int id);
	
}
