package com.sliit.medicinepublisher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MedicineServicePublishImpl implements MedicineServicePublish {

	String fileName = "medicines.txt";
	File file = new File(fileName);

	@Override
	public Medicine createMedicine(int id, String name, float price, int stock) {
		Medicine medicine = new Medicine(id, name, price, stock);

		// write to file
		try {
			FileWriter writer = new FileWriter(file, true);

			StringBuilder sb = new StringBuilder();
			sb.append(id).append(":");
			sb.append(name).append(":");
			sb.append(price).append(":");
			sb.append(stock).append(":");

			sb.append(System.lineSeparator());
			writer.write(sb.toString());

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return medicine;

	}

	@Override
	public Medicine getMedicineById(int id) {

		Medicine medicine = null;

		try {
			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);

			String line;
			while ((line = buffer.readLine()) != null) {
				String[] parts = line.split(":");

				int Mid = Integer.parseInt(parts[0]);
				String name = parts[1];
				float price = Float.parseFloat(parts[2]);
				int stock = Integer.parseInt(parts[3]);

				if (Mid != id)
					continue;

				// set values to medicine
				medicine = new Medicine();
				medicine.setId(Mid);
				medicine.setName(name);
				medicine.setPrice(price);
				medicine.setStock(stock);
				break;
			}

			buffer.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return medicine;

	}

}
