-------------------------------------------------------------------------------------------------
-----------------  C U S T O M    O P E R A T I O N    -    LClassImpl  ------------------
-------------------------------------------------------------------------------------------------
	
	
	Replace the current method getAnnotations() by following. Same issue as above!
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LAnnotationDef> getAnnotationsGen() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<LAnnotationDef>(LAnnotationDef.class, this, EntityPackage.LCLASS__ANNOTATIONS);
		}
		return annotations;
	}
	
	@Override
	public EList<LAnnotationDef> getAnnotations() {
		if (getAnnotationInfo() != null) {
			return getAnnotationInfo().getAnnotations();
		}
		return getAnnotationsGen();
	}
	
	-----------------------------
	------ WHY DO SO? -----------
	-----------------------------
	It delegates the call to the annotation info. That is required to avoid antlr parser errors.
	Therefore see also Entity.xtext:
	
	LClass:
	{LClass} annotations+=LAnnotationDef*
	
	({LBean.annotationInfo=current}
		(((abstract?='abstract')? &
		(serializable?='serializable')?)
		
		'bean' name=ValidIDWithKeywords ('extends' superType=[LBean])?
			'{' properties+=LBeanProp*
				operations+=LOperation* '}'
		) 
	|
		({LEntity.annotationInfo=current}
		((abstract?='abstract')?
		
		'entity' name=ValidIDWithKeywords ('extends' superType=[LClass])?
				(historized?='historized')?
			'{' properties+=LEntityProp*
				operations+=LOperation* 
			'}')
		)
	)
	;