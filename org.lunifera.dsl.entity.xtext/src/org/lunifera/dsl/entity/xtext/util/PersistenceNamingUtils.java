package org.lunifera.dsl.entity.xtext.util;


public class PersistenceNamingUtils {

    /**
     * Converts the given <code>String</code>,
     * that contains camel-case characters,
     * to uppercase, thereby inserting underline ("_") characters
     * before uppercase characters.
     * <br/>
     * E.g.: "camelCaseToUpperCase" -> "CAMEL_CASE_TO_UPPER_CASE".
     *
     * @param  pCamelCaseString The <code>String</code> to convert.
     * @return                  The converted <code>String</code>.
     */
    public static String camelCaseToUpperCase(String pCamelCaseString)
    {
        if (pCamelCaseString.equals(pCamelCaseString.toUpperCase())) {
            return pCamelCaseString; // Nothing to do.
        }
        StringBuilder sb = new StringBuilder(pCamelCaseString);
        for (int i = 1; i < sb.length() - 1; i++) {
            if (  sb.charAt(i - 1) != '_'                 &&
                  Character.isUpperCase(sb.charAt(i    )) &&
                ! Character.isUpperCase(sb.charAt(i + 1))   )
            {
                sb.insert(i, '_');
                i++;
            }
        }
        return sb.toString().toUpperCase();
    }
}
