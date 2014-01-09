package org.lunifera.dsl.entity.xtext.linker;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.linking.XbaseLazyLinker;
import org.lunifera.dsl.entity.xtext.extensions.Constants;
import org.lunifera.dsl.semantic.common.types.LDataType;
import org.lunifera.dsl.semantic.common.types.LType;
import org.lunifera.dsl.semantic.common.types.LTypedPackage;
import org.lunifera.dsl.semantic.common.types.LunTypesFactory;
import org.lunifera.dsl.semantic.entity.EntityFactory;
import org.lunifera.dsl.semantic.entity.LEntity;
import org.lunifera.dsl.semantic.entity.LEntityAttribute;

import com.google.inject.Inject;

public class EntityLinker extends XbaseLazyLinker {

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
								applyHistorized(entity);
							}
						}
					}
				});
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
			datatype.setDateType(entity.getHistorizedDateType());
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
	private LDataType findInternalOID(LEntity entity, LTypedPackage pkg) {
		LDataType datatype = null;
		for (LType type : pkg.getTypes()) {
			if (type instanceof LDataType) {
				LDataType temp = (LDataType) type;
				if (temp.getName().equals(Constants.DT_INTERNAL_OID)) {
					datatype = temp;
					break;
				}
			}
		}

		if (datatype == null) {
			for (LEntityAttribute att : entity.getAllAttributes()) {
				if (att.isId() || att.isUuid()) {
					datatype = (LDataType) EcoreUtil2.cloneWithProxies(att.getType());
					datatype.setName(Constants.DT_INTERNAL_OID);
					pkg.getTypes().add(datatype);
					break;
				}
			}
		}
		return datatype;
	}

	/**
	 * Applies the synthetic attributes for historized entities.
	 * 
	 * @param entity
	 */
	protected void applyHistorized(LEntity entity) {
		if (entity.isHistorized()) {
			LTypedPackage pkg = (LTypedPackage) entity.eContainer();

			LEntityAttribute ooid = EntityFactory.eINSTANCE
					.createLEntityAttribute();
			ooid.setName(Constants.PROP__OID);
			ooid.setType(findInternalOID(entity, pkg));
			entity.getFeatures().add(ooid);

			LEntityAttribute validFrom = EntityFactory.eINSTANCE
					.createLEntityAttribute();
			validFrom.setName(Constants.PROP__VALID_FROM);
			validFrom.setType(findInternalValidDate(entity, pkg,
					Constants.DT_INTERNAL_VALID_FROM));
			entity.getFeatures().add(validFrom);

			LEntityAttribute validUntil = EntityFactory.eINSTANCE
					.createLEntityAttribute();
			validUntil.setName(Constants.PROP__VALID_UNTIL);
			validUntil.setType(findInternalValidDate(entity, pkg,
					Constants.DT_INTERNAL_VALID_UNTIL));
			entity.getFeatures().add(validUntil);
		}
	}
}
