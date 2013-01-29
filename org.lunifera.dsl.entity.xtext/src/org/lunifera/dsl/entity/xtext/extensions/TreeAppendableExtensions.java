package org.lunifera.dsl.entity.xtext.extensions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;

/**
 * This is an extension library for {@link ITreeAppendable}s.
 * It provides some overloaded operators especially for handling automatic type imports.
 * 
 * @see ITreeAppendable
 * @see ImportManager
 *
 * @author Robert Handschmann
 */
@SuppressWarnings("restriction")
public class TreeAppendableExtensions {

	/**
	 * The operator {@code +=} appends the specified string.
	 */
	public ITreeAppendable operator_add(ITreeAppendable p, CharSequence s) {
		if (s == null) return p;
		return p.append(s);
	}
	/**
	 * The operator {@code >>} appends the specified string.
	 */
	public ITreeAppendable operator_doubleGreaterThan(ITreeAppendable p, CharSequence s) {
		if (s == null) return p;
		return p.append(s);
	}
	/**
	 * The operator {@code >>>} is used to begin a code block. It is usually called with a "{".
	 * It appends the specified string then increases the indent and adds a new line. 
	 */
	public ITreeAppendable operator_tripleGreaterThan(ITreeAppendable p, CharSequence s) {
		if (s == null) return p;
		p.append(s);
		p.increaseIndentation().newLine(); 
		return p;
	}
	/**
	 * The operator {@code <<<} is used to end a code block. It is usually called with a "}".
	 * It decreases the indent, adds a new line, 
	 * then appends the specified string and adds a final new line.
	 */
	public ITreeAppendable operator_tripleLessThan(ITreeAppendable p, CharSequence s) {
		if (s == null) return p;
		p.decreaseIndentation().newLine();
		p.append(s).newLine();
		return p;
	}

	/**
	 * The operator {@code +=} appends the specified {@link JvmType} and thereby imports it.
	 */
	public ITreeAppendable operator_add(ITreeAppendable p, JvmType jvmType) {
		return p.append(jvmType);
	}
	/**
	 * The operator {@code >>} appends the specified {@link JvmType} and thereby imports it.
	 */
	public ITreeAppendable operator_doubleGreaterThan(ITreeAppendable p, JvmType jvmType) {
		return p.append(jvmType);
	}

	/**
	 * The operator {@code +=} appends the specified {@link JvmTypeReference} and thereby imports it.
	 * A {@link JvmParameterizedTypeReference} is handled as well,
	 * i.e. appends "Map<Foo, Bar>" and imports "java.util.Map" and both "Foo" and "Bar".
	 */
	public ITreeAppendable operator_add(ITreeAppendable p, JvmTypeReference jvmTypeRef) {
		p.append(jvmTypeRef.getType());
		if (jvmTypeRef instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference ptf = (JvmParameterizedTypeReference) jvmTypeRef;
			EList<JvmTypeReference> params = ptf.getArguments();
			if (!params.isEmpty()) {
				p.append("<");
				String sep = "";
				for (JvmTypeReference param: params) {
					p.append(sep);
					p.append(param.getType());
					sep = ", ";
				}
				p.append(">");
			}
		}
		return p;
	}
	public ITreeAppendable operator_doubleGreaterThan(ITreeAppendable p, JvmTypeReference jvmTypeRef) {
		return operator_add(p, jvmTypeRef);
	}

//	Using a static extension allows to inline generated code.
//	
//	@Inline(value = "/*1*/ $1.append($2)")
//	public static ITreeAppendable operator_add(ITreeAppendable p, CharSequence s) {
//		return p.append(s);
//	}
//	@Inline(value = "/*3*/ $1.append($2)")
//	public static ITreeAppendable operator_doubleGreaterThan(ITreeAppendable p, CharSequence s) {
//		return p.append(s);
//	}
//
//	@Inline(value = "$1.append($2)")
//	public static ITreeAppendable operator_add(ITreeAppendable p, JvmType jvmType) {
//		return p.append(jvmType);
//	}
//	@Inline(value = "$1.append($2)")
//	public static ITreeAppendable operator_doubleGreaterThan(ITreeAppendable p, JvmType jvmType) {
//		return p.append(jvmType);
//	}
//
//	public static ITreeAppendable operator_add(ITreeAppendable p, JvmTypeReference jvmTypeRef) {
//		p.append(jvmTypeRef.getType());
//		if (jvmTypeRef instanceof JvmParameterizedTypeReference) {
//			JvmParameterizedTypeReference ptf = (JvmParameterizedTypeReference) jvmTypeRef;
//			for (JvmTypeReference param: ptf.getArguments()) {
//				p.append(param.getType());
//			}
//		}
//		return p;
//	}
//	public static ITreeAppendable operator_doubleGreaterThan(ITreeAppendable p, JvmTypeReference jvmTypeRef) {
//		return operator_add(p, jvmTypeRef);
//	}
	
}
