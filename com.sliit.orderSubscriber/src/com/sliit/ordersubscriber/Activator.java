package com.sliit.ordersubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.orderpublisher.Order;
import com.sliit.orderpublisher.OrderMedicine;
import com.sliit.orderpublisher.OrderServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start  Subscriber Service");
		
		serviceReference = context.getServiceReference(OrderServicePublish.class.getName());
		OrderServicePublish orderServicePublish = (OrderServicePublish) context.getService(serviceReference);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (true) {
				int option = 0;

				System.out.println("Enter 1 to Create a New Order\nEnter 2 View Orders");

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
					int userId = 0;
					ArrayList<OrderMedicine> medicines = new ArrayList<OrderMedicine>();

					// get user id
					try {
						System.out.print("User ID: ");
						userId = Integer.parseInt(in.readLine());
					} catch (NumberFormatException ex) {
						System.out.println("Only Integers are Allowed!");
					}

					// TODO: Validate user

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
					


						// get medicine quantity
						try {
							System.out.print("Medicine Quanity: ");
							quantity = Integer.parseInt(in.readLine());
						} catch (NumberFormatException ex) {
							System.out.println("Only Integers are Allowed!");
						}

						float orderMedicinePrice = 0;
						// TODO: Validate stock

						// add medicine
						OrderMedicine medicine = new OrderMedicine(medicineId, quantity, orderMedicinePrice);
						medicines.add(medicine);

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
					System.out.println(order1.toString());

					break;
				case 2:
					// get order
					ArrayList<Order> orders = orderServicePublish.getOrders();
					
					// print orders
					for (Order order: orders) {
						System.out.println(order.toString());
					}

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
