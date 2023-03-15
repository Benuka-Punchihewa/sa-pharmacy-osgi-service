package com.sliit.orderpublisher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServicePublishImpl implements ServicePublish {

	@Override
	public Order createOrder(int userId, ArrayList<Medicine> medicines) {
		Order order = new Order(userId, medicines);

		// write to file
		try {
			FileWriter writer = new FileWriter("orders.txt", true);

			StringBuilder sb = new StringBuilder();
			sb.append(userId).append(":");

			for (int i = 0; i < medicines.size(); i++) {
				Medicine medicine = medicines.get(i);
				sb.append(medicine.getMedicineId()).append(",").append(medicine.getQuantity());
				if (i < medicines.size() - 1) {
					sb.append(";");
				}
			}
			sb.append(System.lineSeparator());
			writer.write(sb.toString());

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return order;
	}

}
