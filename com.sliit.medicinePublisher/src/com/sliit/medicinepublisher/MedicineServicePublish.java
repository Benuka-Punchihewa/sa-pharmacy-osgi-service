package com.sliit.medicinepublisher;

import java.util.ArrayList;

public interface MedicineServicePublish {
	
	public Medicine createMedicine(int id , String name, float price, int stock);
	public Medicine getMedicineById(int id);
	public ArrayList<Medicine> getMedicines();
	
}
