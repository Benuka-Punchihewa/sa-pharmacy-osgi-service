package com.sliit.ordersubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.orderpublisher.Medicine;
import com.sliit.orderpublisher.Order;
import com.sliit.orderpublisher.ServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start  Subscriber Service");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) context.getService(serviceReference);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			while (true) {
				int option = 0;
				int userId = 0;
				ArrayList<Medicine> medicines = new ArrayList<Medicine>();

				System.out.println("Enter 1 to create a new order");

				// get option input
				try {
					System.out.print("Option: ");
					option = Integer.parseInt(in.readLine());
				} catch (NumberFormatException ex) {
					System.out.println("Only integers are allowed!");
				}

				// process options
				switch (option) {
				case 1:

					// get user id
					try {
						System.out.print("User ID: ");
						userId = Integer.parseInt(in.readLine());
					} catch (NumberFormatException ex) {
						System.out.println("Only integers are allowed!");
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
							System.out.println("Only integers are allowed!");
						}

						// TODO: Validate medicine

						// get medicine quantity
						try {
							System.out.print("Medicine Quanity: ");
							quantity = Integer.parseInt(in.readLine());
						} catch (NumberFormatException ex) {
							System.out.println("Only integers are allowed!");
						}

						// TODO: Validate stock

						// add medicine
						Medicine medicine = new Medicine(medicineId, quantity);
						medicines.add(medicine);

						try {
							System.out.println(
									"Enter 1 to add a new medicine to order. \nEnter any number to proceed order.");
							System.out.print("Option:");
							medicineOption = Integer.parseInt(in.readLine());
						} catch (NumberFormatException ex) {
							System.out.println("Only integers are allowed!");
						}
					}

					// save order
					Order order = servicePublish.createOrder(userId, medicines);
					System.out.println(order.toString());

					break;
				default:
					System.out.println("Please select a valid option!");
					continue;
				}

			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye!");
		context.ungetService(serviceReference);
	}

}
