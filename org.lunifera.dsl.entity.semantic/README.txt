-------------------------------------------------------------------------------------------------
-----------------  C U S T O M    O P E R A T I O N    -    LEntityMemberImpl  ------------------
-------------------------------------------------------------------------------------------------
LEntityMemberImpl contains custom operation
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<LAnnotationDef> getAnnotations() {
		if (getAnnotationInfo() != null) {
			return getAnnotationInfo().getAnnotations();
		}
		return super.getAnnotations();
	}
	
It delegates the call to the annotation info. That is required to avoid antlr parser errors.
Therefore see also Entity.xtext
Rule:
EntityMember returns LEntityMember:
	{LEntityMember}
	annotations+=LAnnotationDef*
	({LProperty.annotationInfo=current}
		'var' ((id?='id') | (version?='version') | (transient?='transient'))? type=JvmTypeReference
		multiplicity=LMultiplicity?
		name=ValidIDWithKeywords ('=' defaultValueLiteral=STRING)?
	| {LRefers.annotationInfo=current}
		'refers' ((lazy?='lazy')? & (notnull?='notnull')?)
		type=[LEntity|LFQN]
	...
	...
	...