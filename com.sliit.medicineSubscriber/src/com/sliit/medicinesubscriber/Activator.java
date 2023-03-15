package com.sliit.medicinesubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.sliit.medicinepublisher.Medicine;
import com.sliit.medicinepublisher.ServicePublish;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {

		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) context.getService(serviceReference);
		try {
			System.out.println("Enter a option => \n Option 1 = Create Medicien \n Option 2 = Get Medicine Using Id");
			int option;
			Scanner input = new Scanner(System.in);

			// Loop endlessly.
			while (true) {
				// Ask the user to enter a word.
				System.out.print("Enter Option: ");
				option = input.nextInt();

				switch (option) {
				case 1:
					System.out.print("Enter Medicin Id: ");
					int id = input.nextInt();
					System.out.print("Enter Medicin Name: ");
					String name = input.next();
					System.out.print("Enter Medicin Price: ");
					float price = input.nextFloat();
					System.out.print("Enter Medicin Stock: ");
					int stock = input.nextInt();

					Medicine medicine = servicePublish.createMedicine(id, name, price, stock);
					System.out.println("Medicine created successfully!");
					System.out.println("ID:" + medicine.getId() + "\tName:" + medicine.getName() + "\tPrice:"
							+ medicine.getPrice() + "\tStock:" + medicine.getStock());

					break;
				case 2:
					System.out.print("Enter Medicin Id: ");
					int Medid = input.nextInt();

					Medicine medicine2 = servicePublish.getMedicineById(Medid);
					System.out.println("Found Medicine!");
					System.out.println("ID:" + medicine2.getId() + "\tName:" + medicine2.getName() + "\tPrice:"
							+ medicine2.getPrice() + "\tStock:" + medicine2.getStock());

					break;
				default:
					System.out.println("Something went wrong!");
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
