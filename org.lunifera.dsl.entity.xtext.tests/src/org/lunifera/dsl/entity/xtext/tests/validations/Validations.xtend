package org.lunifera.dsl.entity.xtext.tests.validations

import com.google.inject.Inject
import java.util.Map
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.validation.Issue
import org.junit.Test
import org.junit.runner.RunWith
import org.lunifera.dsl.common.xtext.validation.CommonGrammarJavaValidator
import org.lunifera.dsl.entity.xtext.tests.InjectorProvider
import org.lunifera.dsl.entity.xtext.tests.ParseHelper
import org.lunifera.dsl.semantic.entity.LEntityModel

import static org.eclipse.xtext.diagnostics.Severity.*
import static org.lunifera.dsl.common.xtext.validation.CommonGrammarJavaValidator.*
import static org.lunifera.dsl.entity.xtext.validation.EntityGrammarJavaValidator.*

import static extension org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(InjectorProvider))
class Validations {

	@Inject extension ValidationTestHelper;
	@Inject extension ParseHelper<LEntityModel>;

	Map<String, Issue> result
	Map<String, Issue> result2

	@Test
	def void id_1() {
		result = '''
		package org.lunifera.dsl.^entity.xtext.tests {
		
		datatype long jvmType Long as primitive;
		
			entity Test { 										// warn: no id
		
			}
		
			entity Test2 {
				id long id; 
				id long other; 									// error: duplicate id
			}
		}'''.parse.validate.toMap[it.code]

		CODE__MISSING_ID.severity.assertSame(WARNING)
		CODE__MISSING_ID.lineNumber.assertEquals(5)
		CODE__DUPLICATE_ID.severity.assertSame(ERROR)
		CODE__DUPLICATE_ID.lineNumber.assertEquals(10)
	}

	@Test
	def void id_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
				datatype long jvmType Long as primitive;
				 
				entity Test {
					id long id;
				}
				
				entity Test2 extends Test {
					var long someValue;
					id long other;								// error: duplicate id
				}
			}
		'''.parse.validate.toMap[it.code]
		CODE__DUPLICATE_ID.severity.assertSame(ERROR)
		CODE__DUPLICATE_ID.lineNumber.assertEquals(10)
	}

	@Test
	def void version_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
			
				}
			
				entity Test2 {
					version long version;
					version long other;								// error: duplicate version
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_VERSION.severity.assertSame(ERROR)
		CODE__DUPLICATE_VERSION.lineNumber.assertEquals(10)
	}

	@Test
	def void version_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
				datatype long jvmType Long as primitive;
				 
				entity Test {
					version long version;
				}
				
				entity Test2 extends Test {
					var long someValue;
					version long other;							// error: duplicate version
				}
			}
		'''.parse.validate.toMap[it.code]
		CODE__DUPLICATE_VERSION.severity.assertSame(ERROR)
		CODE__DUPLICATE_VERSION.lineNumber.assertEquals(10)
	}

	@Test
	def void featureName_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
			
				}
			
				entity Test2 {
					var long xxyy;									// error: duplicate property
					var long other;
					var long xxyy;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_PROPERTY_NAME.severity.assertSame(ERROR)
		CODE__DUPLICATE_PROPERTY_NAME.lineNumber.assertEquals(10)
	}

	@Test
	def void featureName_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
				datatype long jvmType Long as primitive;
				 
				entity Test {
					var long xxyy;
				}
				
				entity Test2 extends Test {
					var long someValue;
					var long xxyy;								// error: duplicate property (supertype)
				}
			}
		'''.parse.validate.toMap[it.code]
		CODE__DUPLICATE_PROPERTY_NAME.severity.assertSame(ERROR)
		CODE__DUPLICATE_PROPERTY_NAME.lineNumber.assertEquals(10)
	}

	@Test
	def void featureName_3() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
			
				}
			
				entity Test2 {
					var long other;
					ref Test xxyy;									// error: duplicate property var-ref
					var long xxyy;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_PROPERTY_NAME.severity.assertSame(ERROR)
		CODE__DUPLICATE_PROPERTY_NAME.lineNumber.assertEquals(11)
	}

	@Test
	def void featureName_4() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
			
				}
			
				entity Test2 {
					id long xxyy;									// error: duplicate property id-ref
					ref Test xxyy;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_PROPERTY_NAME.severity.assertSame(ERROR)
		CODE__DUPLICATE_PROPERTY_NAME.lineNumber.assertEquals(10)
	}

	@Test
	def void featureName_5() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
			
				}
			
				entity Test2 {
					id long xxyy;									// error: duplicate property id-var
					var long xxyy;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_PROPERTY_NAME.severity.assertSame(ERROR)
		CODE__DUPLICATE_PROPERTY_NAME.lineNumber.assertEquals(10)
	}

	@Test
	def void duplicatePackage_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
			
				}
			
				entity Test2 {
					id long xxyy;
					var long xxyy;
				}
			}
			package org.lunifera.dsl.^entity.xtext.tests {			// error: duplicate package
			
			datatype long jvmType Long as primitive;
			
				entity Test {
			
				}
			
				entity Test2 {
					id long xxyy;
					var long xxyy;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_LPACKAGE_IN_FILE.severity.assertSame(ERROR)
		CODE__DUPLICATE_LPACKAGE_IN_FILE.lineNumber.assertEquals(14)
	}

	@Test
	def void duplicateType_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
					id long id;
					var long xy;
				}
			
				entity Test {										// error: duplicate type (entity)
					var long xxyy;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_LTYPE_IN_PROJECT.severity.assertSame(ERROR)
		CODE__DUPLICATE_LTYPE_IN_PROJECT.lineNumber.assertEquals(10)
	}

	@Test
	def void duplicateType_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype number jvmType Long as primitive;
			datatype number jvmType Float as primitive; 			// error: duplicate type (datatype)
			
				entity Test {
					id long id;
					var long xy;
				}
			
				entity Test2 {
					var long xxyy;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_LTYPE_IN_PROJECT.severity.assertSame(ERROR)
		CODE__DUPLICATE_LTYPE_IN_PROJECT.lineNumber.assertEquals(4)
	}

	@Test
	def void duplicateType_3() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests1 {
			
			datatype long jvmType Long as primitive;
			
				entity Test1 {
					id long xxyy;
					var long abc;
				}
			}
			package org.lunifera.dsl.^entity.xtext.tests2 {
			
			datatype long jvmType Long as primitive;				// error: duplicate type (in other package)
			
				entity Test2 {
					id long cde;
					var long ghi;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_LTYPE_IN_PROJECT.severity.assertSame(ERROR)
		CODE__DUPLICATE_LTYPE_IN_PROJECT.lineNumber.assertEquals(12)
	}

	@Test
	def void invalidPrimitive_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype xyz jvmType String as primitive;				// error: no such primitive Java type
			
				entity Test {
					id xyz id;
				}
			
				
			}
		'''.parse.validate.toMap[it.code]

		CODE__NOT_A_VALID_PRIMITIVE.severity.assertSame(ERROR)
		CODE__NOT_A_VALID_PRIMITIVE.lineNumber.assertEquals(3)
	}

	@Test
	def void invalidPrimitive_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype abc jvmType Long as primitive;					// ok
			datatype xyz jvmType String as primitive;				// error: no such primitive Java type
			
				entity Test {
					id xyz id;
				}
			
				
			}
		'''.parse.validate.toMap[it.code]

		CODE__NOT_A_VALID_PRIMITIVE.severity.assertSame(ERROR)
		CODE__NOT_A_VALID_PRIMITIVE.lineNumber.assertEquals(4)
	}

	@Test
	def void javaKeyword() {
		for (String keyword : CommonGrammarJavaValidator.javakeywords) {
			result = '''
				package org.lunifera.dsl.^entity.xtext.tests {
					entity Test {
						var long «keyword»; 						// each keyword produces error
					}
				}
			'''.parse.validate.toMap[it.code]
			result.values.iterator.next.severity.assertSame(ERROR)
		}
	}

	@Test
	def void bidirectionalAssociation_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
					id long id;
					ref Test2[*] mytests;						// error: no opposite reference given
				}
			
				entity Test2 {
					id long id;
					var long mynumber;	
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__MISSING_OPPOSITE_REFERENCE.severity.assertSame(ERROR)
		CODE__MISSING_OPPOSITE_REFERENCE.lineNumber.assertEquals(7)
	}

	@Test
	def void bidirectionalAssociation_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
					id long id;
					ref Test2[*] mytests opposite nosuchthing;		// error: type of opposite ref cannot be resolved
				}
			
				entity Test2 { 
					id long id;
					var long mynumber;
				}
			} 
		'''.parse.validate.toMap[it.code]

		result.values.iterator.next.severity.assertSame(ERROR)
	}

	@Test
	def void bidirectionalAssociation_3() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
					id long id;
					ref Test2[*]									// error: no opposite reference given
				}
			
				bean Test2 { 
					var long mynumber;
				}
			} 
		'''.parse.validate.toMap[it.code]

		result.values.iterator.next.severity.assertSame(ERROR)
	}

	@Test
	def void bidirectionalAssociation_4() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
			
				entity Test {
					id long id;
					ref Test2[*] mytests opposite nosuchthing;		// error: type of opposite ref cannot be resolved
				}
			
				bean Test2 { 
					var long mynumber;
				}
			} 
		'''.parse.validate.toMap[it.code]

		result.values.iterator.next.severity.assertSame(ERROR)
	}

	@Test
	def void manyToMany_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
				datatype long jvmType Long as primitive;
								          
				entity Test {
					id long id;
					var long x;
					var long mynumber;
					ref Test2[1..*] mytests opposite xyz;
					}
								       
				entity Test2 { 
					id long id;
					var long x;
					var long mynumber;
					ref Test[*] xyz opposite mytests;				// error: many-to-many between entities
					}
			}
		'''.parse.validate.toMap[it.code]

		CODE__MANY_TO_MANY__NOT_SUPPORTED.severity.assertSame(ERROR)
		CODE__MANY_TO_MANY__NOT_SUPPORTED.lineNumber.assertEquals(16)

	}

	@Test
	def void manyToMany_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
				datatype long jvmType Long as primitive;
								          
				bean Test {
					id long id;
					var long x;
					var long mynumber;
					ref Test2[1..*] mytests opposite xyz;
					}
								       
				bean Test2 { 
					id long id;
					var long x;
					var long mynumber;
					ref Test[*] xyz opposite mytests;				// error: many-to-many between beans
					}
			}
		'''.parse.validate.toMap[it.code]

		CODE__MANY_TO_MANY__NOT_SUPPORTED.severity.assertSame(ERROR)
		CODE__MANY_TO_MANY__NOT_SUPPORTED.lineNumber.assertEquals(16)

	}

	@Test
	def void cascade_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
				datatype long jvmType Long as primitive;
			
				entity Test {
					id long id;
					var long x;
					var long mynumber;
					ref cascade Test2[1..*] mytests opposite xyz;	// error: cascade goes only one way (entities)
				}
			
				entity Test2 { 
					id long id;
					var long x;
					var long mynumber;
					ref cascade Test xyz;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__BIDIRECTIONAL_CASCADE_INVALID.severity.assertSame(ERROR)
		CODE__BIDIRECTIONAL_CASCADE_INVALID.lineNumber.assertEquals(9)

	}

	@Test
	def void cascade_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
				datatype long jvmType Long as primitive;
			
				bean Test {
					id long id;
					var long x;
					var long mynumber;
					ref cascade Test2[1..*] mytests opposite xyz;	// error: cascade goes only one way (beans)
				}
			
				bean Test2 { 
					id long id;
					var long x;
					var long mynumber;
					ref cascade Test xyz;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__BIDIRECTIONAL_CASCADE_INVALID.severity.assertSame(ERROR)
		CODE__BIDIRECTIONAL_CASCADE_INVALID.lineNumber.assertEquals(9)

	}

	@Test
	def void cascade_3() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					id long id;
					var long x;
					var long mynumber;
					ref cascade Test2[1] mytests opposite xyz;		// error: cascade must not go from many to one common parent
				}
								       
				entity Test2 { 
					id long id;
					var long x;
					var long mynumber;
					ref Test[*] xyz opposite mytests;
				}
			} 
		'''.parse.validate.toMap[it.code]

		CODE__CASCADE_DIRECTION_INVALID.severity.assertSame(ERROR)
		CODE__CASCADE_DIRECTION_INVALID.lineNumber.assertEquals(9)

	}

	@Test
	def void cascade_4() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				bean Test {
					id long id;
					var long x;
					var long mynumber;
					ref cascade Test2[1] mytests opposite xyz;		// error: cascade must not go from many to one common parent
				}
								       
				bean Test2 { 
					id long id;
					var long x;
					var long mynumber;
					ref Test[*] xyz opposite mytests;
				}
			} 
		'''.parse.validate.toMap[it.code]

		CODE__CASCADE_DIRECTION_INVALID.severity.assertSame(ERROR)
		CODE__CASCADE_DIRECTION_INVALID.lineNumber.assertEquals(9)

	}

	@Test
	def void inheritance_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					inheritance per class {}
					id long id;
					var long x;
					var long mynumber;
				}
				
				entity Test2 extends Test {
					inheritance per subclass {}  					// warning: inheritance mismatch
					var long y;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE.severity.assertSame(WARNING)
		CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE.lineNumber.assertEquals(13)

	}

	@Test
	def void inheritance_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					inheritance per subclass {}
					id long id;
					var long x;
					var long mynumber;
				}
				
				entity Test2 extends Test {
					inheritance per class {}  					// warning: inheritance mismatch
					var long y;
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE.severity.assertSame(WARNING)
		CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE.lineNumber.assertEquals(13)
	}

	@Test
	def void inheritance_3() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					inheritance per class {
						discriminatorColumn disc;
						discriminatorType STRING;
						discriminatorValue MAINTYPE;
					}
					id long id;
				}
				
				entity Test2 extends Test {
					inheritance per class {
						discriminatorColumn disc;					// warning: ignored
					}
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE.severity.assertSame(WARNING)
		CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE.lineNumber.assertEquals(16)
	}
	
	@Test
	def void inheritance_4() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					inheritance per class {
						discriminatorColumn disc;
						discriminatorType STRING;
						discriminatorValue MAINTYPE;
					}
					id long id;
				}
				
				entity Test2 extends Test {
					inheritance per class {
						discriminatorType INT;						// warning: ignored
					}
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE.severity.assertSame(WARNING)
		CODE__DIFFERING_INHERITANCE_FROM_SUPERTYPE.lineNumber.assertEquals(16)
	}
	
	@Test
	def void inheritance_5() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					inheritance per class {
						discriminatorColumn disc;
						discriminatorType STRING;
						discriminatorValue MAINTYPE;
					}
					id long id;
				}
				
				entity Test2 extends Test {
					inheritance per class {
						discriminatorValue MAINTYPE;				// error: not unique
					}
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__INHERITANCE_DISCRIMINATOR_VALUE_NOT_UNIQUE.severity.assertSame(ERROR)
		CODE__INHERITANCE_DISCRIMINATOR_VALUE_NOT_UNIQUE.lineNumber.assertEquals(15)
	}

	@Test
	def void persistence_1() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					tableName testtable;
					id long id;
				}
				
				entity Test2 extends Test {
					tableName testtable;							// error: table name in use
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_PERSISTENCE.severity.assertSame(ERROR)
		CODE__DUPLICATE_PERSISTENCE.lineNumber.assertEquals(11)
	}
	
	@Test
	def void persistence_2() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					tableName testtable;
					id long id;
				}
				
				entity Test2 extends Test {
					tableName Testtable;							// error: table name equal in CAPITALS
				}
			}
		'''.parse.validate.toMap[it.code]

		CODE__DUPLICATE_PERSISTENCE.severity.assertSame(ERROR)
		CODE__DUPLICATE_PERSISTENCE.lineNumber.assertEquals(11)
	}

	@Test
	def void persistence_3() {
		result = '''
			package org.lunifera.dsl.^entity.xtext.tests {
			
			datatype long jvmType Long as primitive;
				
				entity Test {
					tableName testtable;
					id long id;
				}
				
				entity Test2 extends Test {
					tableName testTable;							// no error: CamelCase recognized -> TEST_TABLE
				}
			}
		'''.parse.validate.toMap[it.code]
		
		result.size.assertEquals(0)
	}

	/**
 	* Helper methods 
 	*/
	def int lineNumber(String code) {
		result.get(code).lineNumber
	}

	def Severity severity(String code) {
		result.get(code).severity
	}

}
