package com.sliit.orderpublisher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrderServicePublishImpl implements OrderServicePublish {

	@Override
	public Order createOrder(int userId, ArrayList<OrderMedicine> medicines) {

		long orderId = System.currentTimeMillis();
		float totalPrice = 0;

		// write to file
		try {
			FileWriter writer = new FileWriter("orders.txt", true);

			StringBuilder sb = new StringBuilder();

			// id
			sb.append(orderId).append(":");

			// user ID
			sb.append(userId).append(":");

			// medicines
			for (int i = 0; i < medicines.size(); i++) {
				OrderMedicine medicine = medicines.get(i);

				// total price calculation
				totalPrice += medicine.getPrice();

				sb.append(medicine.getMedicineId()).append(",").append(medicine.getQuantity()).append(",")
						.append(medicine.getPrice());
				if (i < medicines.size() - 1) {
					sb.append(";");
				}
			}

			// Total price
			sb.append(totalPrice).append(":");

			sb.append(System.lineSeparator());
			writer.write(sb.toString());

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Order order = new Order(orderId, userId, medicines, totalPrice);
		return order;
	}

	@Override
	public ArrayList<Order> getOrders() {

		ArrayList<Order> orders = new ArrayList<>();

		try {
			FileReader reader = new FileReader("orders.txt");
			BufferedReader buffer = new BufferedReader(reader);

			String line;
			while ((line = buffer.readLine()) != null) {
				String[] parts = line.split(":");

				long id = Long.parseLong(parts[0]);
				int userId = Integer.parseInt(parts[1]);
				String medicineListString = parts[2];
				float totalPrice = Float.parseFloat(parts[3]);

				// parse medicines list
				ArrayList<OrderMedicine> medicines = new ArrayList<OrderMedicine>();
				String[] medicineStrings = medicineListString.split(";");
				for (String medicineString : medicineStrings) {
					String[] medicineParts = medicineString.split(",");
					int medicineId = Integer.parseInt(medicineParts[0]);
					int quantity = Integer.parseInt(medicineParts[1]);
					float price = Float.parseFloat(medicineParts[2]);
					medicines.add(new OrderMedicine(medicineId, quantity, price));
				}

				// create order object
				Order order = new Order(id, userId, medicines, totalPrice);
				orders.add(order);
			}

			buffer.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return orders;
	}

}
