package com.firebirdcss.api.simple_json_mapper.util;

import java.util.ArrayList;

import com.firebirdcss.util.json_tools.JsonUtilities;
import com.firebirdcss.util.json_tools.mapping.CharType;
import com.firebirdcss.util.json_tools.mapping.MappedItem;

/**
 * This class contains some general utility methods.
 * 
 * @author Scott Griffis
 *
 */
public final class JsonUtils {
	/**
	 * CONSTRUCTOR: Prevents class instantiation. 
	 *
	 */
	private JsonUtils() {}
	
	/**
	 * Converts a dataPath to an array of hops.
	 * <p>
	 * Example: 'abc.defg.hij.klmnop', would be an array of 4 strings,
	 * those 4 strings would be as follows: abc, defg, hij, klmnop.
	 * <p>
	 * Another Example: '"abc.defg".hij.klmnop', would be an array of
	 * 3 strings, those 3 strings would be: abc.defg, hij, klmnop.
	 * 
	 * @param dataPath - The period delimited path as {@link String}
	 * @return Returns an array of type {@link String} containing each hop in path
	 */
	public static String[] DataPathToHops(String dataPath) {
		boolean inQuotes = false;
		ArrayList<String> hops = new ArrayList<>();
		StringBuilder hop = new StringBuilder();
		if (dataPath != null) {
			for (char c : dataPath.toCharArray()) {
				if (c != '"') {
					if (c == '.' && !inQuotes) {
						hops.add(hop.toString());
						hop = new StringBuilder();
					} else {
						hop.append(c);
					}
				} else {
					inQuotes = !inQuotes; // Toggles the value
				}
			}
			if (hop.length() > 0) {
				hops.add(hop.toString());
			}
		}
		
		return hops.toArray(new String[]{});
	}
	
	/**
	 * Used to determine if a given string contains all numeric 
	 * values.
	 * 
	 * @param string - The string to examine as {@link String}
	 * @return Returns the result as <code>boolean</code>
	 */
	public static boolean isNumeric(String string) {
		if (string == null || string.isEmpty()) {
			
			return false;
		}
		
		boolean isFirstChar = true;
		boolean isFirstDot = true;
		
		for (char c : string.toCharArray()) {
			if (!((c >= '0' && c <= '9') || (isFirstChar && c == '-'))) {
				if (isFirstDot && c == '.') {
					isFirstDot = false;
				} else {
					return false;
				}
			}
			isFirstChar = false;
		}
		
		return true;
	}
}
