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
package org.lunifera.dsl.entity.xtext.linker;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.linking.XbaseLazyLinker;
import org.lunifera.dsl.entity.xtext.extensions.Constants;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LScalarType;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.common.types.LunTypesFactory;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;
import org.lunifera.dsl.semantic.entity.LunEntityFactory;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class EntityLinker extends XbaseLazyLinker {

	/**
	 * Move to DerivedStateAwareResource#installDerivedState
	 */

	@Inject
	private OnChangeEvictingCache cache;

	@Override
	protected void doLinkModel(final EObject model, IDiagnosticConsumer consumer) {
		super.doLinkModel(model, consumer);

		cache.execWithoutCacheClear(model.eResource(),
				new IUnitOfWork.Void<Resource>() {
					@Override
					public void process(Resource state) throws Exception {
						TreeIterator<EObject> iterator = model.eAllContents();
						while (iterator.hasNext()) {
							EObject eObject = iterator.next();
							if (eObject instanceof LEntity) {
								LEntity entity = (LEntity) eObject;
								if (entity.isHistorized()) {
									applyHistorized(entity);
								} else if (entity.isTimedependent()) {
									applyTimedependent(entity);
								}
							}
						}
					}
				});
	}

	/**
	 * Applies the synthetic attributes for historized entities.
	 * 
	 * @param entity
	 */
	protected void applyHistorized(LEntity entity) {

		LTypedPackage pkg = (LTypedPackage) entity.eContainer();

		LEntityAttribute ooid = LunEntityFactory.eINSTANCE
				.createLEntityAttribute();
		ooid.setName(Constants.PROP__OID);
		ooid.setType(findInternalOID(entity, pkg));
		entity.getFeatures().add(ooid);

		LEntityAttribute version = LunEntityFactory.eINSTANCE
				.createLEntityAttribute();
		version.setName(Constants.PROP__VERSION);
		version.setType(findInternalDatatype(entity, pkg,
				Constants.DT_INTERNAL_OBJECT_VERSION));
		entity.getFeatures().add(version);

		LEntityAttribute current = LunEntityFactory.eINSTANCE
				.createLEntityAttribute();
		current.setName(Constants.PROP__ISCURRENT);
		current.setType(findInternalDatatype(entity, pkg,
				Constants.DT_INTERNAL_IS_CURRENT_VERSION));
		entity.getFeatures().add(current);
	}

	/**
	 * Applies the synthetic attributes for historized entities.
	 * 
	 * @param entity
	 */
	protected void applyTimedependent(LEntity entity) {

		LTypedPackage pkg = (LTypedPackage) entity.eContainer();

		LEntityAttribute ooid = LunEntityFactory.eINSTANCE
				.createLEntityAttribute();
		ooid.setName(Constants.PROP__OID);
		ooid.setType(findInternalOID(entity, pkg));
		entity.getFeatures().add(ooid);

		LEntityAttribute validFrom = LunEntityFactory.eINSTANCE
				.createLEntityAttribute();
		validFrom.setName(Constants.PROP__VALID_FROM);
		validFrom.setType(findInternalValidDate(entity, pkg,
				Constants.DT_INTERNAL_VALID_FROM));
		entity.getFeatures().add(validFrom);

		LEntityAttribute validUntil = LunEntityFactory.eINSTANCE
				.createLEntityAttribute();
		validUntil.setName(Constants.PROP__VALID_UNTIL);
		validUntil.setType(findInternalValidDate(entity, pkg,
				Constants.DT_INTERNAL_VALID_UNTIL));
		entity.getFeatures().add(validUntil);
	}

	/**
	 * Tries to find the datatype to be used for valid from and valid until.
	 * 
	 * @param entity
	 * @param pkg
	 * @return
	 */
	private LDataType findInternalValidDate(LEntity entity, LTypedPackage pkg,
			String dtName) {
		LDataType datatype = null;
		for (LType type : pkg.getTypes()) {
			if (type instanceof LDataType) {
				LDataType temp = (LDataType) type;
				if (temp.getName().equals(dtName)) {
					datatype = temp;
					break;
				}
			}
		}

		if (datatype == null) {
			datatype = LunTypesFactory.eINSTANCE.createLDataType();
			datatype.setName(dtName);
			datatype.setDate(true);
			datatype.setDateType(entity.getTimedependentDateType());
			pkg.getTypes().add(datatype);
		}
		return datatype;
	}

	/**
	 * Tries to find the datatype to be used for valid from and valid until.
	 * 
	 * @param entity
	 * @param pkg
	 * @return
	 */
	private LScalarType findInternalOID(LEntity entity, LTypedPackage pkg) {
		LDataType datatype = null;
		for (LType type : pkg.getTypes()) {
			if (!type.eIsProxy() && type instanceof LDataType) {
				LDataType temp = (LDataType) type;
				if (temp.getName().equals(Constants.DT_INTERNAL_OBJECT_ID)) {
					datatype = temp;
					break;
				}
			}
		}

		if (datatype == null) {
			datatype = LunTypesFactory.eINSTANCE.createLDataType();
			datatype.setName(Constants.DT_INTERNAL_OBJECT_ID);
			datatype.setSyntheticFlag(true);
			datatype.setSyntheticSelector(Constants.DT_INTERNAL_OBJECT_ID);
			// will be resolved later to avoid entity.super calls. Entity.super
			// would resolve cross references too early.
			datatype.setSyntheticType(entity);
			pkg.getTypes().add(datatype);
		}
		return datatype;
	}

	/**
	 * Tries to find the datatype to be used for valid from and valid until.
	 * 
	 * @param entity
	 * @param pkg
	 * @return
	 */
	private LDataType findInternalDatatype(LEntity entity, LTypedPackage pkg,
			String syntheticType) {
		LDataType datatype = null;
		for (LType type : pkg.getTypes()) {
			if (type instanceof LDataType) {
				LDataType temp = (LDataType) type;
				if (temp.getName().equals(syntheticType)) {
					datatype = temp;
					break;
				}
			}
		}

		if (datatype == null) {
			datatype = LunTypesFactory.eINSTANCE.createLDataType();
			datatype.setName(syntheticType);
			datatype.setSyntheticFlag(true);
			datatype.setSyntheticSelector(syntheticType);
			pkg.getTypes().add(datatype);
		}
		return datatype;
	}

	// protected EObject createProxy(EObject obj, INode node, EReference eRef) {
	//
	// if(eRef == LunTypesPackage.Literals.LATTRIBUTE__TYPE){
	// final Resource resource = obj.eResource();
	// if (resource == null)
	// throw new
	// IllegalStateException("object must be contained in a resource");
	// final URI uri = resource.getURI();
	// final URI encodedLink = uri.appendFragment(encoder.encode(obj, eRef,
	// node));
	// EClass referenceType = ecoreGenericsUtil.getReferenceType(eRef,
	// obj.eClass());
	// EClass instantiableType = instantiableSubTypes.get(referenceType);
	// final EObject proxy = EcoreUtil.create(instantiableType);
	// ((InternalEObject) proxy).eSetProxyURI(encodedLink);
	// return proxy;
	// }
	//
	// return super.createProxy(obj, node, eRef);
	// }
}
