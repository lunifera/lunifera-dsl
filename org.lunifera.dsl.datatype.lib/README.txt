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
	
	
-------------------------------------------------------------------------------------------------
-----------------  C O M P I L E R   T E M P L A T E                           ------------------
-------------------------------------------------------------------------------------------------
	
The package org.lunifera.dsl.entity.xtext.jvmmodel.services contains some interfaces. The core is
delegating to them to ensure the right compiler is chosen. Each of the interfaces requires the implementation
of method

boolean isResponsible(LCompilerType compilerType);

It should return true, if the implementation should be used for the compiler types.

Providing them:
See org.lunifera.dsl.entity.xtext.jvmmodel.services.jpa.DefaultJPACompiler.entitymodel
This model provides the JPA Compiler as a template to the Xtext document in the IDE editor.

Currently 2 different compilers are implemented:
EntityCompiler -> No compilerType definition file required since this is the default
JPACompiler -> Generates all the entities in JPA type and adds default annotations to the beans.

They can be overridden by specifying annotations directly in the entitymodel file. Note the 'exclude' modifier
of all entity definitions. It can be used to suppress the generation of that types of annotations.