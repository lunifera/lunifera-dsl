/*******************************************************************************
 * Copyright (c) 2011 Sigasi N.V. (http://www.sigasi.com) and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.lunifera.dsl.xtext.cache.nodemodel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker.InconsistentNodeModelException;
import org.eclipse.xtext.nodemodel.impl.SerializableNodeModel;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.compiler.CompilationStrategyAdapter;
import org.eclipse.xtext.xbase.compiler.CompilationTemplateAdapter;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.common.types.LunTypesFactory;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LEntityReference;
import org.lunifera.dsl.semantic.entity.LunEntityFactory;
import org.lunifera.dsl.xtext.cache.CacheAwareJvmModelAssociator;
import org.lunifera.dsl.xtext.cache.CacheAwareJvmModelAssociator.Adapter;
import org.lunifera.dsl.xtext.cache.model.XCCacheContent;
import org.lunifera.dsl.xtext.cache.model.XCJvmModelAssociation;
import org.lunifera.dsl.xtext.cache.model.XCMemberInfo;
import org.lunifera.dsl.xtext.cache.model.XtextCacheFactory;
import org.lunifera.dsl.xtext.cache.resource.CachingResource;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

/**
 * @author Mark Christiaens - Initial contribution
 * 
 * @since 2.3
 */
@SuppressWarnings("restriction")
public class DefaultSerializationService implements ISerializationService {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DefaultSerializationService.class);

	private static final Version MINIMUM_BINARY_CAPABLE_EMF_VERSION = new Version(
			2, 6, 0);

	@Inject
	private ILinker linker;
	@Inject
	private CompilerPhases phases;

	public XtextResource loadResource(XtextResource xr, InputStream emfIn,
			InputStream nodeModelIn, String completeContent) throws IOException {
		loadEMFModel(xr, emfIn);
		augmentWithNodeModel(xr, nodeModelIn, completeContent);

		return xr;
	}

	protected XtextResource loadEMFModel(XtextResource xr, InputStream emfIn)
			throws IOException {
		deserializeEMFModel(xr, emfIn);
		return xr;
	}

	@Override
	public XtextResource loadDerivedState(XtextResource xr, InputStream dsIn,
			String completeContent) throws IOException {
		deserializeDSModel(xr, dsIn);
		fixupProxies(xr);
		return xr;
	}

	protected void deserializeEMFModel(Resource resource, InputStream in)
			throws IOException {
		if (isCapableEMFVersion()) {

			LOGGER.info("Start deserializing " + resource.getURI());

			EObjectInputStream objectInputStream = new BinaryResourceImpl.EObjectInputStream(
					in, ImmutableMap.of());
			objectInputStream.loadResource(resource);

		} else {
			XMLResourceImpl intermediate = new XMLResourceImpl();
			intermediate.setEncoding("UTF-8");
			intermediate.load(in, ImmutableMap.of());
			resource.getContents().addAll(intermediate.getContents());
		}
	}

	protected void deserializeDSModel(Resource resource, InputStream in)
			throws IOException {
		if (isCapableEMFVersion()) {

			LOGGER.info("Start deserializing " + resource.getURI());

			XMLResourceImpl intermediate = new XMLResourceImpl(
					resource.getURI());
			// intermediate.load(in, ImmutableMap.of());
			EObjectInputStream objectInputStream = new BinaryResourceImpl.EObjectInputStream(
					in, ImmutableMap.of());
			try {
				objectInputStream.loadResource(intermediate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// EObject result = resource.getContents().get(1);
			// if (result instanceof JvmGenericType) {
			// JvmGenericType type = (JvmGenericType) result;
			// for (JvmTypeReference typeRef : type.getSuperTypes()) {
			// if (typeRef instanceof JvmUnknownTypeReference) {
			// System.out.println("hoppala");
			// }
			// }
			// }

			EObject lastElement = intermediate.getContents().get(
					intermediate.getContents().size() - 1);
			if (lastElement instanceof XCCacheContent) {
				XCCacheContent cacheContent = (XCCacheContent) lastElement;

				CacheAwareJvmModelAssociator.Adapter.setupAdapter(
						cacheContent.getModelAssociation(),
						(XtextResource) resource);

				Map<EObject, XCMemberInfo> infosMap = new HashMap<EObject, XCMemberInfo>();
				for (XCMemberInfo info : cacheContent.getMembersInfo()) {
					infosMap.put(info.getMember(), info);
				}

				// create operation bodies, documentation,...
				TreeIterator<EObject> allContents = intermediate
						.getAllContents();
				while (allContents.hasNext()) {
					EObject object = allContents.next();
					if (object instanceof JvmOperation) {
						final XCMemberInfo info = infosMap.get(object);
						if (info == null) {
							continue;
						}

						if (info.getDocumentation() != null
								&& !info.getDocumentation().equals("")) {
							DocumentationAdapter docAdapter = new DocumentationAdapter();
							docAdapter
									.setDocumentation(info.getDocumentation());
							object.eAdapters().add(docAdapter);
						}

						if (info.getBody() != null
								&& !info.getBody().equals("")) {
							CompilationStrategyAdapter bodyAdapter = new CompilationStrategyAdapter();
							object.eAdapters().add(bodyAdapter);
							bodyAdapter
									.setCompilationStrategy(new Procedures.Procedure1<ITreeAppendable>() {
										@Override
										public void apply(
												ITreeAppendable appendable) {
											appendable.append(info.getBody());
										}
									});
						}
					}
				}

				// remove the last element. Was just a helper element
				intermediate.getContents().remove(cacheContent);

				for (EObject content : intermediate.getContents()) {
					if (content instanceof XCCacheContent) {
						System.out.println("Uuups!");
					}
				}
			}

			resource.getContents().addAll(intermediate.getContents());

		} else {
			XMLResourceImpl intermediate = new XMLResourceImpl();
			intermediate.load(in, ImmutableMap.of());
			resource.getContents().addAll(intermediate.getContents());
		}
	}

	protected void augmentWithNodeModel(XtextResource xr,
			InputStream nodeModelIn, String completeContent)
			throws IOException, UnsupportedEncodingException {
		if (nodeModelIn == null) {
			return;
		}

		DeserializationConversionContext deserContext = new DeserializationConversionContext(
				xr, completeContent);

		SerializableNodeModel nodeModel = new SerializableNodeModel();
		nodeModel.readObjectData(new DataInputStream(new BufferedInputStream(
				nodeModelIn)), deserContext);

		checkInvariants(nodeModel);

		xr.setParseResult(new ParseResult(getRoot(xr), nodeModel.root,
				deserContext.hasErrors()));
	}

	protected void checkInvariants(SerializableNodeModel nodeModel) {
		if (LOGGER.isDebugEnabled()) {
			try {
				InvariantChecker checker = new InvariantChecker();
				checker.checkInvariant(nodeModel.root);
			} catch (InconsistentNodeModelException e) {
				LOGGER.error("{}", e);
				throw e;
			}
		}
	}

	protected EObject getRoot(Resource resource) {
		TreeIterator<EObject> allContents = resource.getAllContents();
		if (allContents.hasNext()) {
			return allContents.next();
		}

		return null;
	}

	public void write(XtextResource resource, OutputStream emfOut,
			OutputStream nodeModelOut) throws IOException,
			SerializeVetoException {

		serializeEMF(resource, emfOut);
		serializeNodeModel(resource, nodeModelOut);
	}

	public void writeDerivedState(XtextResource resource, OutputStream emfOut)
			throws IOException, SerializeVetoException {
		serializeDerivedState(resource, emfOut);
	}

	protected void serializeEMF(XtextResource resource, OutputStream out)
			throws IOException, SerializeVetoException {
		if (isCapableEMFVersion()) {
			((CachingResource) resource).resolveLazyCrossReferences(null);
			fixupSerializeProxies(resource);

			EObjectOutputStream objectOutputStream = new BinaryResourceImpl.EObjectOutputStream(
					out, ImmutableMap.of());
			objectOutputStream.saveResource(resource);
		} else {
			XMLResourceImpl intermediate = new XMLResourceImpl();
			try {
				// CachingResource cachingResource = (CachingResource) resource;
				// // load the derived state
				// cachingResource.getContentsWithDerivedState();
				intermediate.getContents().addAll(resource.getContents());
				intermediate.save(out, ImmutableMap.of());
			} finally {
				/*
				 * TODO: A bit worried whether this could trigger listener
				 * updates or something.
				 */
				resource.getContents().addAll(intermediate.getContents());
			}
		}
	}

	protected void serializeDerivedState(XtextResource resource,
			OutputStream out) throws IOException, SerializeVetoException {
		if (isCapableEMFVersion()) {
			EObjectOutputStream objectOutputStream = new BinaryResourceImpl.EObjectOutputStream(
					out, ImmutableMap.of());

			XMLResource intermediate = new XMLResourceImpl(resource.getURI());
			// intermediate.setEncoding("UTF-8");

			CachingResource cachingResource = (CachingResource) resource;

			// load the derived state
			cachingResource.installDerivedStateDirectly();
			// cachingResource.resolveLazyCrossReferences(null);

			intermediate.getContents().addAll(
					cachingResource.getContents().subList(1,
							cachingResource.getContents().size()));

			// EList<EObject> contents = cachingResource.getContents();
			// Iterator<EObject> contentsIter =
			// cachingResource.getAllContents();
			// while (contentsIter.hasNext()) {
			// EObject result = contentsIter.next();
			// if (result instanceof JvmGenericType) {
			// JvmGenericType type = (JvmGenericType) result;
			//
			// } else if (result instanceof JvmField) {
			// JvmField field = (JvmField) result;
			// if (field.getSimpleName() == null) {
			// throw new SerializeVetoException("Huhu");
			// }
			// }
			// }

			try {
				fixupSerializeProxies(intermediate);
			} catch (SerializeVetoException e) {
				// No serializiation MUST be done
				LOGGER.info(e.getMessage());
				// throw e;
			}

			CacheAwareJvmModelAssociator.Adapter adapter = (Adapter) EcoreUtil
					.getAdapter(cachingResource.eAdapters(),
							CacheAwareJvmModelAssociator.Adapter.class);

			// create contents for the cache
			XCCacheContent cacheContent = XtextCacheFactory.eINSTANCE
					.createXCCacheContent();

			// create model associations
			XCJvmModelAssociation modelAssociations = adapter.getCacheContent();
			cacheContent.setModelAssociation(modelAssociations);

			// create operation bodies, documentation,...
			TreeIterator<EObject> allContents = intermediate.getAllContents();
			while (allContents.hasNext()) {
				EObject object = allContents.next();
				if (object instanceof JvmOperation) {
					XCMemberInfo info = XtextCacheFactory.eINSTANCE
							.createXCMemberInfo();
					info.setMember(object);
					boolean toAdd = false;
					DocumentationAdapter docAdapter = (DocumentationAdapter) EcoreUtil
							.getAdapter(object.eAdapters(),
									DocumentationAdapter.class);
					if (docAdapter != null) {
						info.setDocumentation(docAdapter.getDocumentation());
						toAdd = true;
					}

					CompilationStrategyAdapter bodyAdapter = (CompilationStrategyAdapter) EcoreUtil
							.getAdapter(object.eAdapters(),
									CompilationStrategyAdapter.class);
					if (bodyAdapter != null) {
						FakeTreeAppendableCustom appendable = new FakeTreeAppendableCustom();
						bodyAdapter.getCompilationStrategy().apply(appendable);
						info.setBody(appendable.toString());
						// appendable.getImportManager().getImports()
						toAdd = true;
					} else {
						CompilationTemplateAdapter templateAdapter = (CompilationTemplateAdapter) EcoreUtil
								.getAdapter(object.eAdapters(),
										CompilationTemplateAdapter.class);
						if (templateAdapter != null) {
							StringConcatenation body = new StringConcatenation();
							body.append(templateAdapter
									.getCompilationTemplate());
							info.setBody(body.toString());
							toAdd = true;
						}
					}

					if (toAdd) {
						cacheContent.getMembersInfo().add(info);
					}
				}
			}

			intermediate.getContents().add(cacheContent);
			// intermediate.save(out, null);
			objectOutputStream.saveResource(intermediate);

			// remove the cacheContent after serializiation
			intermediate.getContents().remove(cacheContent);

			cachingResource.getContents().addAll(intermediate.getContents());
		} else {
			XMLResourceImpl intermediate = new XMLResourceImpl();
			try {
				// CachingResource cachingResource = (CachingResource) resource;
				// // load the derived state
				// cachingResource.getContentsWithDerivedState();
				intermediate.getContents().addAll(resource.getContents());
				intermediate.save(out, ImmutableMap.of());
			} finally {
				/*
				 * TODO: A bit worried whether this could trigger listener
				 * updates or something.
				 */
				resource.getContents().addAll(intermediate.getContents());
			}
		}
	}

	private Map<EObject, URI> collectXtextProxies(
			CachingResource cachingResource) {
		Map<EObject, URI> result = new HashMap<EObject, URI>();

		TreeIterator<EObject> allContents = cachingResource.getAllContents();
		while (allContents.hasNext()) {
			EObject object = allContents.next();
			EClass c = object.eClass();
			EList<EReference> references = c.getEAllReferences();
			for (EReference reference : references) {
				if (!reference.isContainment()) {
					if (reference.isMany()) {
						@SuppressWarnings("unchecked")
						InternalEList<EObject> targets = (InternalEList<EObject>) object
								.eGet(reference, false);
						for (int i = 0; i < targets.size(); ++i) {
							EObject target = targets.basicGet(i);
							collectXtextProxy(target, result);
						}
					} else {
						EObject target = (EObject) object
								.eGet(reference, false);
						collectXtextProxy(target, result);
					}
				}
			}
		}

		return result;
	}

	private void collectXtextProxy(EObject target, Map<EObject, URI> result) {
		if (target == null) {
			return;
		}
		if (target.eIsProxy()) {
			InternalEObject internal = (InternalEObject) target;
			URI proxyURI = internal.eProxyURI();
			if (proxyURI.fragment().startsWith(LazyURIEncoder.XTEXT_LINK)) {
				result.put(target, proxyURI);
			}
		}
	}

	protected void serializeNodeModel(XtextResource resource, OutputStream out)
			throws IOException {
		SerializableNodeModel model = new SerializableNodeModel(resource);

		SerializationConversionContext serContext = new SerializationConversionContext(
				resource);

		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
				out));
		try {
			model.writeObjectData(dos, serContext);
		} finally {
			dos.flush();
		}
	}

	public static boolean isCapableEMFVersion() {
		Version emfVersion = getEMFVersion();

		if (emfVersion != null) {
			return MINIMUM_BINARY_CAPABLE_EMF_VERSION.compareTo(emfVersion) <= 0;
		}

		return false;
	}

	public static Version getEMFVersion() {
		final Bundle bundle = Platform.getBundle("org.eclipse.emf.common");

		if (bundle == null) {
			return null;
		}

		return bundle.getVersion();
	}

	protected void fixupProxies(XtextResource xr) {
		// URI uri = xr.getURI();
		// TreeIterator<EObject> allContents = xr.getAllContents();
		// while (allContents.hasNext()) {
		// EObject object = allContents.next();
		// EClass c = object.eClass();
		// EList<EReference> references = c.getEAllReferences();
		// for (EReference reference : references) {
		// if (!reference.isContainment()) {
		// if (reference.isMany()) {
		// @SuppressWarnings("unchecked")
		// InternalEList<EObject> targets = (InternalEList<EObject>) object
		// .eGet(reference, false);
		// for (int i = 0; i < targets.size(); ++i) {
		// EObject target = targets.basicGet(i);
		// fixupProxy(target, uri, reference);
		// }
		// } else {
		// EObject target = (EObject) object
		// .eGet(reference, false);
		// fixupProxy(target, uri, reference);
		// }
		// }
		// }
		// }
	}

	protected void fixupProxy(EObject target, URI newResourceURI,
			EReference reference) {
	}

	protected void fixupSerializeProxies(Resource xr)
			throws SerializeVetoException {
		URI uri = xr.getURI();
		TreeIterator<EObject> allContents = xr.getAllContents();
		while (allContents.hasNext()) {
			EObject object = allContents.next();
			EClass c = object.eClass();
			EList<EReference> references = c.getEAllReferences();
			for (EReference reference : references) {
				if (reference.isMany()) {
					@SuppressWarnings("unchecked")
					EList<EObject> targets = (EList<EObject>) object.eGet(
							reference, false);
					for (int i = 0; i < targets.size(); ++i) {
						EObject target = targets.get(i);
						fixupSerializeProxy(object, target, uri, reference, xr);
					}
				} else {
					EObject target = (EObject) object.eGet(reference, false);
					fixupSerializeProxy(object, target, uri, reference, xr);
				}
			}
		}
	}

	protected void fixupSerializeProxy(EObject featureHolder, EObject target,
			URI newResourceURI, EReference reference, Resource xr)
			throws SerializeVetoException {
		if (target != null) {
			if (target instanceof LEntityAttribute) {
				LScalarType lType = ((LEntityAttribute) target).getType();
				if (!lType.eIsProxy()) {
					InternalEObject internal = (InternalEObject) LunTypesFactory.eINSTANCE
							.createLScalarType();
					Resource thisResource = lType.eResource();
					URI thisResourceResourceURI = thisResource.getURI();
					thisResourceResourceURI = thisResourceResourceURI
							.appendFragment("luniferaattlink:"
									+ lType.getName().toString());
					internal.eSetProxyURI(thisResourceResourceURI);
					((LEntityAttribute) target).setType((LScalarType) internal);
				} else{
					System.out.println("noproxy");
				}
			} else if (target instanceof LEntityReference) {
				LEntity lType = ((LEntityReference) target).getType();
				if (!lType.eIsProxy()) {
					InternalEObject internal = (InternalEObject) LunEntityFactory.eINSTANCE
							.createLEntity();
					Resource thisResource = lType.eResource();
					URI thisResourceResourceURI = thisResource.getURI();
					thisResourceResourceURI = thisResourceResourceURI
							.appendFragment("luniferareflink:"
									+ lType.getName().toString());
					internal.eSetProxyURI(thisResourceResourceURI);
					((LEntityReference) target).setType((LEntity) internal);
				} else{
					System.out.println("noproxy");
				}
			} else if (target instanceof JvmTypeReference) {
				JvmTypeReference typeRef = (JvmTypeReference) target;
				URI uri = null;
				JvmType type = typeRef.getType();
				if (type == null) {

				} else if (type.eIsProxy()) {
					uri = ((InternalEObject) type).eProxyURI();
				} else {
					uri = EcoreUtil.getURI(type);
				}
				if ((type != null && type.eResource() instanceof TypeResource)
						|| uri != null
						&& uri.fragment().startsWith("xtextLink")) {
					// everything is fine
				} else {
					if (target instanceof JvmUnknownTypeReference) {
						if (typeRef.getQualifiedName() == null
								|| typeRef.getQualifiedName().equals("")) {
							// never ever serialize unknown type references!
							// throw new SerializeVetoException(
							// String.format(
							// "JvmUnknownTypeReference detected for %s::%s",
							// target.toString(),
							// reference.toString()));
							return;
						}

						JvmParameterizedTypeReference newTypeRef = (JvmParameterizedTypeReference) TypesFactory.eINSTANCE
								.createJvmParameterizedTypeReference();
						// create new JvmGenericTypeProxy
						InternalEObject internal = (InternalEObject) TypesFactory.eINSTANCE
								.createJvmGenericType();
						Resource thisResource = typeRef.eResource();
						if (thisResource instanceof TypeResource) {
							System.out.println("uuuuups");
						}
						URI thisResourceResourceURI = thisResource.getURI();
						thisResourceResourceURI = thisResourceResourceURI
								.appendFragment("unresolvedtypeslink:"
										+ typeRef.getQualifiedName().toString());
						internal.eSetProxyURI(thisResourceResourceURI);
						// set proxy to generic type
						newTypeRef.setType((JvmType) internal);

						if (reference.isMany()) {
							@SuppressWarnings("unchecked")
							EList<EObject> targets = (EList<EObject>) featureHolder
									.eGet(reference, false);
							int index = targets.indexOf(target);
							targets.remove(target);
							targets.add(index, newTypeRef);
						} else {
							featureHolder.eSet(reference, newTypeRef);
						}

					} else {
						if (type instanceof JvmTypeParameter) {
							JvmTypeParameter typeParam = (JvmTypeParameter) type;
							typeParam.getQualifiedName();
							for (JvmTypeConstraint constraint : typeParam
									.getConstraints()) {
								JvmTypeReference constRef = constraint
										.getTypeReference();
								if (constRef == null) {
									continue;
								}
								if (constRef instanceof JvmUnknownTypeReference) {
									if (constRef.getQualifiedName() == null
											|| constRef.getQualifiedName()
													.equals("")) {
										// never ever serialize unknown type
										// references!
										// throw new SerializeVetoException(
										// String.format(
										// "JvmUnknownTypeReference detected for %s::%s",
										// constRef.toString(),
										// "constraints"));
										return;
									}

									JvmParameterizedTypeReference newTypeRef = (JvmParameterizedTypeReference) TypesFactory.eINSTANCE
											.createJvmParameterizedTypeReference();
									// create new JvmGenericTypeProxy
									InternalEObject internal = (InternalEObject) TypesFactory.eINSTANCE
											.createJvmGenericType();
									Resource thisResource = constRef
											.eResource();
									if (thisResource instanceof TypeResource) {
										System.out.println("uuuuups");
									}
									URI thisResourceURI = thisResource.getURI();
									thisResourceURI = thisResourceURI
											.appendFragment("unresolvedtypeslink:"
													+ constRef
															.getQualifiedName()
															.toString());
									internal.eSetProxyURI(thisResourceURI);
									// set proxy to generic type
									newTypeRef.setType((JvmType) internal);

									constraint.setTypeReference(newTypeRef);
								} else {
									JvmParameterizedTypeReference newTypeRef = (JvmParameterizedTypeReference) TypesFactory.eINSTANCE
											.createJvmParameterizedTypeReference();
									// create new JvmGenericTypeProxy
									InternalEObject internal = (InternalEObject) TypesFactory.eINSTANCE
											.createJvmGenericType();
									try {
										// URI newProxyURI =
										// URI.createURI(String.format(
										// "%s/%s#%s",
										// IndexResolvingURIConstants.BASE_URI
										// .toString(), constRef
										// .getQualifiedName(), constRef
										// .getQualifiedName()));
										JvmType parameterType = constRef
												.getType();
										Resource derivedStateResource = parameterType
												.eResource();
										if (derivedStateResource instanceof TypeResource) {
											System.out.println("uuuuups");
										}
										URI derivedStateResourceURI = derivedStateResource
												.getURI();
										derivedStateResourceURI = derivedStateResourceURI
												.appendFragment("typeslink:"
														+ constRef
																.getQualifiedName()
																.toString());
										internal.eSetProxyURI(derivedStateResourceURI);
										newTypeRef.setType((JvmType) internal);

										constraint.setTypeReference(newTypeRef);
									} catch (NullPointerException e) {
										throw e;
									}
								}
							}
						} else {
							JvmParameterizedTypeReference newTypeRef = (JvmParameterizedTypeReference) TypesFactory.eINSTANCE
									.createJvmParameterizedTypeReference();
							// create new JvmGenericTypeProxy
							InternalEObject internal = (InternalEObject) TypesFactory.eINSTANCE
									.createJvmGenericType();

							if (typeRef.getType().eIsProxy()) {
								return;
							}

							Resource derivedStateResource = typeRef.getType()
									.eResource();
							if (derivedStateResource instanceof TypeResource) {
								System.out.println("uuuuups");
							}
							URI derivedStateResourceURI = derivedStateResource
									.getURI();
							derivedStateResourceURI = derivedStateResourceURI
									.appendFragment("typeslink:"
											+ typeRef.getQualifiedName()
													.toString());
							internal.eSetProxyURI(derivedStateResourceURI);
							newTypeRef.setType((JvmType) internal);
							if (reference.isMany()) {
								@SuppressWarnings("unchecked")
								EList<EObject> targets = (EList<EObject>) featureHolder
										.eGet(reference, false);
								int index = targets.indexOf(target);
								targets.remove(target);
								targets.add(index, newTypeRef);
							} else {
								featureHolder.eSet(reference, newTypeRef);
							}
						}
					}
				}
			}

			if (target.eIsProxy()) {

			} else {
				// if (target instanceof JvmType) {
				// JvmType type = (JvmType) target;
				// InternalEObject internal = (InternalEObject) target;
				//
				// if (type instanceof JvmPrimitiveType) {
				// URI newProxyURI = URI.createURI(String.format(
				// "java:/Primitives/%s#%s",
				// type.getQualifiedName(),
				// type.getQualifiedName()));
				// internal.eSetProxyURI(newProxyURI);
				// } else {
				// URI newProxyURI = URI.createURI(String.format(
				// "java:/Objects/%s#%s", type.getQualifiedName(),
				// type.getQualifiedName()));
				// internal.eSetProxyURI(newProxyURI);
				// }
				// }
			}

			// if (target instanceof JvmTypeReference) {
			// JvmTypeReference type = (JvmTypeReference) target;
			// InternalEObject internal = (InternalEObject) target;
			// }
		}
	}

	private EClass getProxyType(EClass referenceType) {
		if (referenceType == TypesPackage.Literals.JVM_TYPE
				|| referenceType == TypesPackage.Literals.JVM_IDENTIFIABLE_ELEMENT)
			return TypesPackage.Literals.JVM_VOID;
		if (referenceType == TypesPackage.Literals.JVM_DECLARED_TYPE)
			return TypesPackage.Literals.JVM_GENERIC_TYPE;
		return referenceType;
	}

	private class FakeTreeAppendableCustom extends FakeTreeAppendable {
		@Override
		protected ImportManager getImportManager() {
			return super.getImportManager();
		}
	}

	private class ImportManagerCustom extends ImportManager {

		public ImportManagerCustom() {
			super(false);
		}

		@Override
		public void appendType(JvmType type, StringBuilder builder) {
			super.appendType(type, builder);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.xtext.xbase.compiler.ImportManager#appendType(java.lang
		 * .Class, java.lang.StringBuilder)
		 */
		@Override
		public void appendType(Class<?> type, StringBuilder builder) {
			// TODO Auto-generated method stub
			super.appendType(type, builder);
		}

	}

	public class SerializeVetoException extends Exception {
		public SerializeVetoException(String message) {
			super(message);
		}
	}

}
