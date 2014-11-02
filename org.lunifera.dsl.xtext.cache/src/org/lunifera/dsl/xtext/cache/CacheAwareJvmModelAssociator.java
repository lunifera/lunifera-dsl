package org.lunifera.dsl.xtext.cache;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation;
import org.lunifera.dsl.xtext.cache.model.XCLogicalContainer;
import org.lunifera.dsl.xtext.cache.model.XCSourceToTarget;
import org.lunifera.dsl.xtext.cache.model.XCTargetToSource;
import org.lunifera.dsl.xtext.cache.model.XtextCacheFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;

@SuppressWarnings("restriction")
public class CacheAwareJvmModelAssociator extends JvmModelAssociator {

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	public Adapter getOrInstall(Resource resource) {
		if (!(resource instanceof XtextResource))
			return new Adapter();
		if (!languageName.equals(((XtextResource) resource).getLanguageName()))
			return new Adapter();
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(resource.eAdapters(),
				Adapter.class);
		if (adapter == null) {
			adapter = new Adapter();
			resource.eAdapters().add(adapter);
		}
		return adapter;
	}

	public static class Adapter extends JvmModelAssociator.Adapter {

		/**
		 * Applies the associated values to the jvmModel associations adapter.
		 * 
		 * @param model
		 * @param resource
		 */
		public static void setupAdapter(XCJvmModelAssociation model,
				XtextResource resource) {

			Adapter adapter = (Adapter) EcoreUtil.getAdapter(
					resource.eAdapters(), Adapter.class);
			if (adapter == null) {
				adapter = new Adapter();
				resource.eAdapters().add(adapter);
			}

			adapter.setCacheContent(model);
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return Adapter.class == type;
		}

		/**
		 * Returns the model association as cacheable model.
		 * 
		 * @return
		 */
		public XCJvmModelAssociation getCacheContent() {

			XCJvmModelAssociation content = XtextCacheFactory.eINSTANCE
					.createXCJvmModelAssociation();

			// map source to target
			for (Map.Entry<EObject, Set<EObject>> sourceToTarget : this.sourceToTargetMap
					.entrySet()) {
				XCSourceToTarget temp = XtextCacheFactory.eINSTANCE
						.createXCSourceToTarget();
				temp.setKey(sourceToTarget.getKey());

				for (EObject value : sourceToTarget.getValue()) {
					temp.getValues().add(value);
				}
				content.getSourceToTargets().add(temp);
			}

			// map target to source
			for (Map.Entry<EObject, Set<EObject>> targetToSource : this.targetToSourceMap
					.entrySet()) {
				XCTargetToSource temp = XtextCacheFactory.eINSTANCE
						.createXCTargetToSource();
				temp.setKey(targetToSource.getKey());

				for (EObject value : targetToSource.getValue()) {
					temp.getValues().add(value);
				}
				content.getTargetToSources().add(temp);
			}

			// map logical container
			for (Entry<EObject, JvmIdentifiableElement> logicalContainer : this.logicalContainerMap
					.entrySet()) {
				XCLogicalContainer temp = XtextCacheFactory.eINSTANCE
						.createXCLogicalContainer();
				temp.setKey(logicalContainer.getKey());
				temp.setValue(logicalContainer.getValue());

				content.getLocalContainers().add(temp);
			}

			return content;
		}

		public void setCacheContent(XCJvmModelAssociation model) {
			this.sourceToTargetMap.clear();
			this.targetToSourceMap.clear();
			this.logicalContainerMap.clear();

			// map logical container
			for (XCLogicalContainer temp : model.getLocalContainers()) {
				logicalContainerMap.put(temp.getKey(),
						(JvmIdentifiableElement) temp.getValue());
			}

			// map source to target
			for (XCSourceToTarget temp : model.getSourceToTargets()) {
				sourceToTargetMap.put(temp.getKey(),
						new HashSet<EObject>(temp.getValues()));
			}

			// map target to source
			for (XCTargetToSource temp : model.getTargetToSources()) {
				targetToSourceMap.put(temp.getKey(),
						new HashSet<EObject>(temp.getValues()));
			}
		}
	}
}
