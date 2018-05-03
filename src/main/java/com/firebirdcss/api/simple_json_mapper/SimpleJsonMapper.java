package com.firebirdcss.api.simple_json_mapper;

import java.util.ArrayList;

import com.firebirdcss.api.simple_json_mapper.json.CharType;
import com.firebirdcss.api.simple_json_mapper.json.JsonObject;
import com.firebirdcss.api.simple_json_mapper.json.Value;
import com.firebirdcss.api.simple_json_mapper.mapping.MappedItem;
import com.firebirdcss.api.simple_json_mapper.mapping.MappedItems;

/**
 * This is a SIMPLE JSON Mapper...
 * <p>
 * The point of this object is to make working with JSON in Java simple, flexible and efficient.
 * The belief behind this object is that it should be easy to get values from a JSON object without
 * needing to know the entire exact model the of said object.
 * 
 * @author Scott Griffis
 *
 */
public class SimpleJsonMapper {
	private ArrayList<MappedItem> mappedItems = new ArrayList<>();
	
	private JsonObject baseObject = null;
	
	/**
	 * CONSTRUCTOR: Used to instantiate an instance of this object. 
	 *
	 * @param json - The JSON to be mapped and thereafter associated 
	 * with this object instance, as {@link String}
	 */
	public SimpleJsonMapper(String json) {
		scanJson(json);
		baseObject = new JsonObject(json, new MappedItems(mappedItems));
	}
	
	/**
	 * PRIVATE METHOD: This method scans the given JSON string and maps out
	 * the location of important characters to aid in further processing of
	 * the JSON in the future.
	 * 
	 * @param json - The JSON to be scanned and mapped as {@link String}
	 */
	private void scanJson(String json) {
		mappedItems.clear();
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
					int lastIndex = getLastUnclosedIndex(CharType.DOUBLE_QUOTE);
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
						int lastIndex = getLastUnclosedIndex(CharType.CURLY_BRACKET);
						if (lastIndex != -1) {
							mappedItems.get(lastIndex).setCloseIndex(index);
						}
					} else if (c == '[') {
						MappedItem mappedItem = new MappedItem(CharType.SQUARE_BRACKET, index);
						mappedItems.add(mappedItem);
					} else if (c == ']') {
						int lastIndex = getLastUnclosedIndex(CharType.SQUARE_BRACKET);
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
	}
	
	/**
	 * PRIVATE METHOD: Used to fetch the last unclosed par of a specific charType.
	 * 
	 * @param charType - The charType as {@link CharType}
	 * @return Returns the index location of the last unclosed pair of a particular charType, as <code>int</code>
	 * 
	 */
	private int getLastUnclosedIndex(CharType charType) {
		for (int p = (mappedItems.size() - 1); p >= 0; p --) {
			MappedItem item = mappedItems.get(p);
			if (item != null && item.getCharType() == charType && !item.isClosed()) {
				
				return p;
			}
		}
		
		return -1;
	}
	
	/**
	 * Get a value from the JSON using the given dataPath.
	 * 
	 * @param dataPath - The dataPath as {@link String}
	 * @return Returns the desired value as {@link Value}
	 */
	public Value getValue(String dataPath) {
		
		return baseObject.getValue(dataPath);
	}
}
