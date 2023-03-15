package com.sliit.orderpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Publisher Started");
		ServicePublish publisherService = new ServicePublishImpl();
		publishServiceRegistration = context.registerService(ServicePublish.class.getName(), publisherService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Publisher Stoped");
		publishServiceRegistration.unregister();
	}

}
