/**
 * Copyright (c) 2011 - 2014, Lunifera GmbH (Gross Enzersdorf), Loetz KG (Heidelberg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 * 		Florian Pirchner - Initial implementation
 */
package org.lunifera.dsl.metadata.services.impl;

import static com.google.common.collect.Iterables.addAll;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.lunifera.dsl.metadata.services.IBuilderParticipant;
import org.lunifera.dsl.metadata.services.IMetadataBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

@Component(immediate = true)
public class MetadataBuilder implements BundleTrackerCustomizer<Bundle>,
		FrameworkListener, IMetadataBuilderService {

	private static final Logger logger = org.slf4j.LoggerFactory
			.getLogger(MetadataBuilder.class);

	private ComponentContext context;
	private Set<Bundle> bundles = new HashSet<Bundle>();
	private BundleTracker<Bundle> bundleTracker;
	private XtextResourceSet resourceSet;
	private ResourceDescriptionsProvider resourceDescriptionsProvider;
	private IQualifiedNameConverter converter;

	private List<IBuilderParticipant> participants = new ArrayList<IBuilderParticipant>();

	private Injector injector;

	@Activate
	protected void activate(ComponentContext context) {
		this.context = context;
		context.getBundleContext().addFrameworkListener(this);
		doSetup();
		converter = new IQualifiedNameConverter.DefaultImpl();
		resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceDescriptionsProvider = injector
				.getInstance(ResourceDescriptionsProvider.class);
	}

	protected void doSetup() {
		for (IBuilderParticipant participant : participants
				.toArray(new IBuilderParticipant[participants.size()])) {
			Injector injector = participant.setupGrammars();
			if (this.injector == null) {
				this.injector = injector;
			}
		}
	}

	@Deactivate
	protected void deactivate() {
		if (bundleTracker != null) {
			bundleTracker.close();
			bundleTracker = null;
		}

		// notify each participant that the builder was deactivated
		for (IBuilderParticipant participant : participants
				.toArray(new IBuilderParticipant[participants.size()])) {
			participant.builderDeactivated();
		}

		for (Resource rs : new ArrayList<Resource>(resourceSet.getResources())) {
			rs.unload();
		}
		resourceSet = null;
		resourceDescriptionsProvider = null;
	}

	/**
	 * Returns the metadata model element for the given parameters. Or
	 * <code>null</code> if no model could be found.
	 * 
	 * @param qualifiedName
	 * @param type
	 * @return
	 */
	public synchronized EObject getMetadata(String qualifiedName, EClass type) {
		return getEObjectForFQN(converter.toQualifiedName(qualifiedName), type);
	}

	public EObject getEObjectForFQN(QualifiedName fqn, EClass type) {
		EObject result = null;
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider
				.getResourceDescriptions(resourceSet);
		Iterable<IEObjectDescription> descriptions = resourceDescriptions
				.getExportedObjects(type, fqn, false);
		for (IEObjectDescription desc : descriptions) {
			result = desc.getEObjectOrProxy();
		}

		return result;
	}

	/**
	 * Resolves all models for all proper model bundles.
	 */
	private synchronized void resolveAllModels() {
		for (Bundle bundle : context.getBundleContext().getBundles()) {
			for (URL url : findModels(bundle)) {
				logger.info("Adding model " + url.toString()
						+ " to model cache.");
				resourceSet.getResource(URI.createURI(url.toString()), true);
			}
		}

		EcoreUtil.resolveAll(resourceSet);

		List<Issue> validationResults = validate(resourceSet);
		for (Issue issue : validationResults) {
			logger.error(issue.toString());
		}

		logger.info("Models resolved. In case of error, see messages before.");
	}

	/**
	 * Registers all services.
	 */
	protected void registerServices() {
		for (IBuilderParticipant participant : participants
				.toArray(new IBuilderParticipant[participants.size()])) {
			participant.registerServices(this);
		}
	}

	/**
	 * Starts the tracking of bundles.
	 */
	private synchronized void startTracking() {
		bundleTracker = new BundleTracker<Bundle>(context.getBundleContext(),
				BundleEvent.RESOLVED, MetadataBuilder.this);
		bundleTracker.open();
	}

	/**
	 * Resolves the models contained in the given bundle.
	 * 
	 * @param bundle
	 */
	private synchronized void resolveModels(Bundle bundle) {
		List<URL> urls = findModels(bundle);
		if (urls.isEmpty()) {
			return;
		}
		for (URL url : urls) {
			logger.info("Added " + url.toString() + " to metadata cache.");
			resourceSet.getResource(URI.createURI(url.toString()), true);
		}

		EcoreUtil.resolveAll(resourceSet);

		List<Issue> validationResults = validate(resourceSet);
		for (Issue issue : validationResults) {
			logger.error(issue.toString());
		}
	}

	/**
	 * Unresolves the models contained in the given bundle.
	 * 
	 * @param bundle
	 */
	private synchronized void unresolveModels(Bundle bundle) {
		List<URL> urls = findModels(bundle);
		if (urls.isEmpty()) {
			return;
		}

		for (URL url : urls) {
			logger.info("Unregistered " + url.toString());
			Resource rs = resourceSet.getResource(
					URI.createURI(url.toString()), true);
			rs.unload();
		}

		EcoreUtil.resolveAll(resourceSet);

		List<Issue> validationResults = validate(resourceSet);
		for (Issue issue : validationResults) {
			System.out.println(issue.getMessage());
		}
	}

	protected List<Issue> validate(ResourceSet resourceSet) {
		List<Issue> issues = Lists.newArrayList();
		List<Resource> resources = Lists.newArrayList(resourceSet
				.getResources());
		for (Resource resource : resources) {
			IResourceServiceProvider resourceServiceProvider = IResourceServiceProvider.Registry.INSTANCE
					.getResourceServiceProvider(resource.getURI());
			if (resourceServiceProvider != null) {
				IResourceValidator resourceValidator = resourceServiceProvider
						.getResourceValidator();
				List<Issue> result = resourceValidator.validate(resource,
						CheckMode.ALL, null);
				addAll(issues, result);
			}
		}
		return issues;
	}

	/**
	 * Looks up for all models available.
	 * 
	 * @param bundleContext
	 * @return
	 */
	private List<URL> findModels(Bundle suspect) {

		List<URL> result = new ArrayList<URL>();
		// iterate all participants
		for (IBuilderParticipant participant : participants
				.toArray(new IBuilderParticipant[participants.size()])) {
			result.addAll(participant.getModels(suspect));
		}

		if (result.size() > 0) {
			bundles.add(suspect);
		}

		return result;
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {

		// the bundle was already scanned
		if (bundles.contains(bundle)) {
			return bundle;
		}

		resolveModels(bundle);

		return bundle;
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event, Bundle object) {

	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		// the bundle was already scanned
		if (!bundles.contains(bundle)) {
			return;
		}

		unresolveModels(bundle);

		bundles.remove(bundle);
	}

	@Override
	public void frameworkEvent(FrameworkEvent event) {
		if (event.getType() == FrameworkEvent.STARTED) {

			// Starts a new thread to resolve all bundles
			new Thread(new Runnable() {
				@Override
				public void run() {
					resolveAllModels();
					registerServices();
					startTracking();
				}
			}).start();

		}
	}

	/**
	 * Called by OSGi-DS.
	 * 
	 * @param participant
	 */
	@Reference(cardinality = ReferenceCardinality.AT_LEAST_ONE, unbind = "removeParticipant")
	protected void addParticipant(IBuilderParticipant participant) {
		if (!participants.contains(participant)) {
			participants.add(participant);
		}
	}

	/**
	 * Called by OSGi-DS.
	 * 
	 * @param participant
	 */
	protected void removeParticipant(IBuilderParticipant participant) {
		participants.remove(participant);
	}
}
