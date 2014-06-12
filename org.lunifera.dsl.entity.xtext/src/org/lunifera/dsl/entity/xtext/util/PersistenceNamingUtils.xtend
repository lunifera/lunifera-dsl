package org.lunifera.dsl.entity.xtext.util

class PersistenceNamingUtils {

	/**
	 * Converts the given <code>String</code>, that contains camel-case
	 * characters, to uppercase, thereby inserting underline ("_") characters
	 * before uppercase characters. <br/>
	 * E.g.: "camelCaseToUpperCase" -> "CAMEL_CASE_TO_UPPER_CASE".
	 * 
	 * @param pCamelCaseString
	 *            The <code>String</code> to convert.
	 * @return The converted <code>String</code>.
	 */
	def static String camelCaseToUpperCase(String pCamelCaseString) {
		if (pCamelCaseString == null) {
			return "";
		}
		if (pCamelCaseString.equals(pCamelCaseString.toUpperCase())) {
			return pCamelCaseString; // Nothing to do.
		}
		val StringBuilder sb = new StringBuilder(pCamelCaseString);
		val StringBuilder sbOut = new StringBuilder(pCamelCaseString);
		val maxIndex = sb.length - 1;
		var offset = 0;
		for (i : 1 .. (sb.length() - 1)) {
			try {
				if (i < maxIndex && sb.charAt(i - 1) != '_' && Character.isUpperCase(sb.charAt(i)) &&
					!Character.isUpperCase(sb.charAt(i + 1))) {
					sbOut.insert(i + offset, '_');
					offset = offset + 1;
				}
			} catch (Exception ex) {
				println(ex)
			}
		}
		return sbOut.toString().toUpperCase();
	}

}
