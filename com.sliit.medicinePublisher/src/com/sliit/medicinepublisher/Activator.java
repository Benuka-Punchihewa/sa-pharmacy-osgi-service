package com.sliit.medicinepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;


	public void start(BundleContext context) throws Exception {

		System.out.println("Publisher Start");
		ServicePublish servicePublish = new ServicePublishImpl();
		publishServiceRegistration = context.registerService(ServicePublish.class.getName(), servicePublish, null);
	}

	public void stop(BundleContext context) throws Exception {

		System.out.println("Publisher Stop");
		publishServiceRegistration.unregister();
	}

}
