package com.firebirdcss.api.simple_json_mapper.util;

import java.util.ArrayList;

import com.firebirdcss.api.simple_json_mapper.json.CharType;
import com.firebirdcss.api.simple_json_mapper.mapping.MappedItem;

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
	
	/**
	 * PRIVATE METHOD: This method scans the given JSON string and maps out
	 * the location of important characters to aid in further processing of
	 * the JSON in the future.
	 * 
	 * @param json - The JSON to be scanned and mapped as {@link String}
	 */
	public static ArrayList<MappedItem> mapJson(String json) {
		ArrayList<MappedItem> mappedItems = new ArrayList<>();
		boolean inQuotes = false;
		
		for (int index = 0; index < json.length(); index ++) {
			char c = json.charAt(index);
			if (c == '\\') { // Needs handled first...
				if (Character.toLowerCase(json.charAt(index + 1)) == 'u') {
					index += 3; // Jump past Unicode, next cycle adds 4th jump.
				} else {
					index ++; // Jump past escaped char, next cycle adds 2nd jump.
				}
				
				continue;
			} else if (c == '"') { // This needs second highest priority...
				inQuotes = !inQuotes;
				if (inQuotes) {
					MappedItem mappedItem = new MappedItem(CharType.DOUBLE_QUOTE, index);
					mappedItems.add(mappedItem);
				} else {
					int lastIndex = getLastUnclosedIndex(mappedItems, CharType.DOUBLE_QUOTE);
					if (lastIndex != -1) {
						mappedItems.get(lastIndex).setCloseIndex(index);
					}
				}
			} else {
				if (!inQuotes) {
					if (c == '{') {
						MappedItem mappedItem = new MappedItem(CharType.CURLY_BRACKET, index);
						mappedItems.add(mappedItem);
					} else if (c == '}') {
						int lastIndex = getLastUnclosedIndex(mappedItems,CharType.CURLY_BRACKET);
						if (lastIndex != -1) {
							mappedItems.get(lastIndex).setCloseIndex(index);
						}
					} else if (c == '[') {
						MappedItem mappedItem = new MappedItem(CharType.SQUARE_BRACKET, index);
						mappedItems.add(mappedItem);
					} else if (c == ']') {
						int lastIndex = getLastUnclosedIndex(mappedItems,CharType.SQUARE_BRACKET);
						if (lastIndex != -1) {
							mappedItems.get(lastIndex).setCloseIndex(index);
						}
					} else if (c == ':' ) {
						MappedItem mappedItem = new MappedItem(CharType.COLON, index);
						mappedItems.add(mappedItem);
					} else if (c == ',') {
						MappedItem mappedItem = new MappedItem(CharType.COMMA, index);
						mappedItems.add(mappedItem);
					}
				}
			}
		}
		
		return mappedItems;
	}
	
	/**
	 * PRIVATE METHOD: Used to fetch the last unclosed par of a specific charType.
	 * 
	 * @param charType - The charType as {@link CharType}
	 * @return Returns the index location of the last unclosed pair of a particular charType, as <code>int</code>
	 * 
	 */
	private static int getLastUnclosedIndex(ArrayList<MappedItem> mappedItems, CharType charType) {
		for (int p = (mappedItems.size() - 1); p >= 0; p --) {
			MappedItem item = mappedItems.get(p);
			if (item != null && item.getCharType() == charType && !item.isClosed()) {
				
				return p;
			}
		}
		
		return -1;
	}
}
