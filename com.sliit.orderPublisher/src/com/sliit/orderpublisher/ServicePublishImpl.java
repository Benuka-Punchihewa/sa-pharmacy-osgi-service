package com.sliit.orderpublisher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServicePublishImpl implements ServicePublish {

	@Override
	public Order createOrder(int userId, ArrayList<Medicine> medicines) {

		long orderId = System.currentTimeMillis();

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

		Order order = new Order(orderId, userId, medicines);
		return order;
	}

	@Override
	public Order getById(long orderId) {
		Order order = new Order();
		
		try {
			FileReader reader = new FileReader("orders.txt");
			BufferedReader buffer = new BufferedReader(reader);

			String line;
			while ((line = buffer.readLine()) != null) {
				String[] parts = line.split(":");
				
				long id = Long.parseLong(parts[0]);
				int userId = Integer.parseInt(parts[1]);
				String medicineListString = parts[2];
				
				if (id != orderId) continue;

				// parse medicines list
				ArrayList<Medicine> medicines = new ArrayList<Medicine>();
				String[] medicineStrings = medicineListString.split(";");
				for (String medicineString : medicineStrings) {
					String[] medicineParts = medicineString.split(",");
					int medicineId = Integer.parseInt(medicineParts[0]);
					int quantity = Integer.parseInt(medicineParts[1]);
					medicines.add(new Medicine(medicineId, quantity));
				}
				
				// set values to order
				order.setId(id);
				order.setUserId(userId);
				order.setMedicines(medicines);
				
				break;
			}

			buffer.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		return order;
	}

}
