package com.sliit.userpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("User Publisher Started");
		
		UserServicePublish servicePublish = new UserServicePublishImpl();
		publishServiceRegistration = context.registerService(UserServicePublish.class.getName(), servicePublish, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Publisher Stoped");
		publishServiceRegistration.unregister();
	}

}
