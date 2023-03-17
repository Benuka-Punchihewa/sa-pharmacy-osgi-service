package com.sliit.ordersubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.medicinepublisher.Medicine;
import com.sliit.medicinepublisher.MedicineServicePublish;
import com.sliit.orderpublisher.Order;
import com.sliit.orderpublisher.OrderMedicine;
import com.sliit.orderpublisher.OrderServicePublish;
import com.sliit.userpublisher.User;
import com.sliit.userpublisher.UserServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start  Subscriber Service");

		serviceReference = context.getServiceReference(OrderServicePublish.class.getName());
		OrderServicePublish orderServicePublish = (OrderServicePublish) context.getService(serviceReference);

		serviceReference = context.getServiceReference(MedicineServicePublish.class.getName());
		MedicineServicePublish medicineServicePublish = (MedicineServicePublish) context.getService(serviceReference);

		serviceReference = context.getServiceReference(UserServicePublish.class.getName());
		UserServicePublish userServicePublish = (UserServicePublish) context.getService(serviceReference);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			Boolean isExit = false;

			while (isExit == false) {
				int option = 0;

				System.out.println("Enter 1 to Create a New Order.\nEnter 2 View Orders.\nEnter 3 Exit.");

				// get option input
				try {
					System.out.print("Option: ");
					option = Integer.parseInt(in.readLine());
				} catch (NumberFormatException ex) {
					System.out.println("Only Integers are Allowed!");
				}

				// process options
				switch (option) {
				case 1:
					String userId = "";
					ArrayList<OrderMedicine> medicines = new ArrayList<OrderMedicine>();

					// get user id
					try {
						System.out.print("User ID: ");
						userId = in.readLine();
					} catch (NumberFormatException ex) {
						System.out.println("Only Integers are Allowed!");
					}

					// Validate user
					User user = userServicePublish.getUsereById(userId);
					if (user == null) {
						System.out.println("User not found, Please try again!");
						continue;
					}

					int medicineOption = 1;
					int medicineId = 0;
					int quantity = 0;

					// add medicines to cart
					while (medicineOption == 1) {
						// get medicine id
						try {
							System.out.print("Medicine ID: ");
							medicineId = Integer.parseInt(in.readLine());
						} catch (NumberFormatException ex) {
							System.out.println("Only Integers are Allowed!");
						}

						// validate medicine
						Medicine medicine = medicineServicePublish.getMedicineById(medicineId);
						if (medicine == null) {
							System.out.println("Medicine not found, Please try again!");
							continue;
						}

						// get medicine quantity
						try {
							System.out.print(medicine.getName() + " Quanity: ");
							quantity = Integer.parseInt(in.readLine());
						} catch (NumberFormatException ex) {
							System.out.println("Only Integers are Allowed!");
						}

						float orderMedicinePrice = 0;
						int stock = medicine.getStock();
						float price = medicine.getPrice();

						// validate stock
						if (quantity > stock) {
							System.out.println("Does not have enough stock, Please try again!");
							continue;
						} else {
							orderMedicinePrice = price * quantity;
						}

						// add medicine
						OrderMedicine orderMedicine = new OrderMedicine(medicineId, quantity, orderMedicinePrice);
						medicines.add(orderMedicine);

						try {
							System.out.println(
									"Enter 1 to Add a New Medicine to Order. \nEnter Any Number to Proceed Order.");
							System.out.print("Option:");
							medicineOption = Integer.parseInt(in.readLine());
						} catch (NumberFormatException ex) {
							System.out.println("Only Integers are Allowed!");
						}
					}

					// save order
					Order order1 = orderServicePublish.createOrder(userId, medicines);
					System.out.println("Order has been created successfully with ID," + order1.getId());

					break;
				case 2:
					// get order
					ArrayList<Order> orders = orderServicePublish.getOrders();

					// print orders
					for (Order order : orders) {
						System.out.println(order.toString());
						System.out.println();
					}

					break;
				case 3:
					isExit = true;
					break;
				default:
					System.out.println("Please Select a Valid Option!");
					break;
				}

			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		System.out.println();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!");
		context.ungetService(serviceReference);
	}

}
