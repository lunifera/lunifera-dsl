package org.lunifera.dsl.entity.xtext.tests;

import javax.persistence.EntityManagerFactory;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private static Activator instance;
	public BundleContext context;

	@Override
	public void start(BundleContext context) throws Exception {
		this.context = context;
		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		this.context = null;
		instance = null;
	}

	/**
	 * @return the instance
	 */
	public static Activator getInstance() {
		return instance;
	}

	/**
	 * Returns the entity manager factory or <code>null</code>.
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EntityManagerFactory getEMF() {
		ServiceReference[] refs;
		try {
			refs = context.getServiceReferences(
					EntityManagerFactory.class.getName(),
					"(osgi.unit.name=dbDerby)");
			if (refs != null) {
				return (EntityManagerFactory) context.getService(refs[0]);
			}
		} catch (InvalidSyntaxException e) {
			throw new RuntimeException(e);
		}

		return null;
	}
}
