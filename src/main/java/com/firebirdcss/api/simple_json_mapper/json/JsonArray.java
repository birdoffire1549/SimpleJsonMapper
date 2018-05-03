package com.firebirdcss.api.simple_json_mapper.json;

import java.util.ArrayList;
import java.util.Arrays;

import com.firebirdcss.api.simple_json_mapper.mapping.MappedItem;
import com.firebirdcss.api.simple_json_mapper.mapping.MappedItems;
import com.firebirdcss.api.simple_json_mapper.util.JsonUtils;

/**
 * This item makes up a JSON Array and contains functionality required
 * to make use of the array and retrieve its values.
 * 
 * @author Scott Griffis
 *
 */
public class JsonArray {
	private final ArrayList<Value> valueArray = new ArrayList<>();
	private final int endIndex;
	
	/**
	 * CONSTRUCTOR: Used to initialize the class.
	 *
	 * @param json - The JSON which makes up this Array as {@link String}
	 * @param mappedItems - The {@link MappedItems} which make up this array
	 */
	public JsonArray(String json, MappedItems mappedItems) {
		MappedItem item = mappedItems.removeFirstItem(); // move past bracket...
		endIndex = item.getCloseIndex();
		while (mappedItems.size() > 0) {
			Value newValue = null;
			item = mappedItems.getFirstItem();
			if (item.getCharType() == CharType.CURLY_BRACKET) { // Object Found...
				JsonObject obj = new JsonObject(json, mappedItems.pullEncapsulatedItems(item));
				newValue = new Value();
				newValue.setValue(obj);
				if (mappedItems.size() > 0 && mappedItems.getFirstItem().getCharType() == CharType.COMMA) {
					mappedItems.removeFirstItem(); // Remove comma...
				}
			} else if (item.getCharType() == CharType.SQUARE_BRACKET) { // Array Found...
				JsonArray array = new JsonArray(json, mappedItems.pullEncapsulatedItems(item));
				newValue = new Value();
				newValue.setValue(array);
				if (mappedItems.size() > 0 && mappedItems.getFirstItem().getCharType() == CharType.COMMA) {
					mappedItems.removeFirstItem(); // Remove comma...
				}
			} else if (item.getCharType() == CharType.DOUBLE_QUOTE) { 
				newValue = new Value();
				String tempValue = json.substring(item.getOpenIndex() + 1, item.getCloseIndex());
				newValue.setValue(tempValue);
				mappedItems.removeFirstItem(); // removes quotes...
				if (mappedItems.size() > 0 && mappedItems.getFirstItem().getCharType() == CharType.COMMA) {
					mappedItems.removeFirstItem(); // Remove comma...
				}
			} else if (item.getCharType() == CharType.COMMA) { // Unquoted Value...
				MappedItem prev = mappedItems.recallPreviousItem();	
				int prevIndex = (prev.getCloseIndex() != -1 && prev.getCharType() != CharType.SQUARE_BRACKET ? prev.getCloseIndex() : prev.getOpenIndex());
				newValue = new Value();
				newValue.setValue(json.substring(prevIndex + 1, item.getOpenIndex()).trim());
				if (mappedItems.size() > 0 && mappedItems.getFirstItem().getCharType() == CharType.COMMA) {
					mappedItems.removeFirstItem(); // Remove Comma...
				}
			}
			
			valueArray.add(newValue);
		}
		
		/* Pickup last unquoted value if applicable */
		MappedItem prev = mappedItems.recallPreviousItem();
		if (prev != null && prev.getCharType() == CharType.COMMA) { // Last item is not quoted...
			Value newValue = new Value();
			String tempValue = json.substring(prev.getOpenIndex() + 1, endIndex).trim();
			newValue.setValue(tempValue);
			
			valueArray.add(newValue);
		}
	}
	
	/**
	 * Allows for the retrieval of a value from this array object based on 
	 * its index location in the array.
	 * 
	 * @param index - The index of the desired value as <code>int</code>
	 * @return Returns the desired {@link Value}
	 */
	public Value getValue(int index) {
		if (valueArray.size() >= index) {
			
			return valueArray.get(index);
		}
		
		return null;
	}
	
	/**
	 * Allows for the retrieval of a value from this array object based on 
	 * a given string of indexes.
	 * Example: '[2][21][3]'
	 * 
	 * @param indexes - The given {@link String} of index(es)
	 * @return Returns the desired {@link Value}
	 */
	public Value getValue(String indexes) {
		if (indexes == null) {
			Value value = new Value();
			value.setValue(this);
			
			return value;
		}
		
		if (indexes.contains("[")) {
			ArrayList<Integer> tempIndexes = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			for (char c : indexes.toCharArray()) {
				if (c == '[') {
					sb = new StringBuilder();
				} else if (c == ']') {
					if (JsonUtils.isNumeric(sb.toString())) {
						tempIndexes.add(Integer.parseInt(sb.toString()));
					} else {
						
						return null; // <-------------------------------------- [Exit Point]
					}
				} else if (Character.isDigit(c)) {
					sb.append(c);
				} else {
					
					return null; // <------------------------------------------ [Exit Point]
				}
			}
			
			int[] result = new int[tempIndexes.size()];
			for (int i = 0; i < tempIndexes.size(); i++) {
				result[i] = tempIndexes.get(i).intValue();
			}
			
			return getValue(result); // <-------------------------------------- [Exit Point]
		} else if (indexes.contains(",")) { // Comma separated indexes...
			String[] tempIndexes = indexes.split(",");
			int[] results = new int[tempIndexes.length];
			int i = -1;
			for (String inx : tempIndexes) {
				i++ ;
				if (JsonUtils.isNumeric(inx)) {
					results[i] = Integer.parseInt(inx);
				} else {
					
					return null; // <------------------------------------------ [Exit Point]
				}
			}
			
			return getValue(results); // <------------------------------------- [Exit Point]
		} else if (JsonUtils.isNumeric(indexes)) { // Only one index...
			
			return getValue(Integer.parseInt(indexes)); // <------------------- [Exit Point]
		} // Not an index type we will consider valid...
		
		return null; // <------------------------------------------------------ [Exit Point]
	}
	
	/**
	 * Allows for the retrieval of a value from this array object based on 
	 * a given array of indexes.
	 * 
	 * @param indexes - Indexes as an array of <code>int</code>
	 * @return Returns the desired {@link Value}
	 */
	public Value getValue(int[] indexes) {
		if (indexes != null && indexes.length > 0) {
			if (indexes.length == 1) { // only one??? Easy...
				if (valueArray.size() > indexes[0]) {
				
					return valueArray.get(indexes[0]);
				} 
				
				return null;
			} else { // More than one...
				Value value = null;
				for (int i : indexes) {
					if (value != null && value.isArray()) { // It exists and It's an array!
						if (value.getAsArray().length() > i) { // Prevents IndexOutOfBounds Exception...
							value = value.getAsArray().getValue(i);
						} else { // If the address isn't valid we can't continue...
							
							break;
						}
					} else if (value == null) { // value hasn't been loaded yet...
						if (valueArray.size() > i) { 
							value = valueArray.get(i);
						} else { // Oops, you broke it...
							
							break;
						}
					} else { // Value isn't an array, so the index make it an invalid data path...
						value = null;
						
						break;
					}
				}
				
				return value;
			}
		}
		
		return null;
	}
	
	/**
	 * @return Returns an array of the {@link Value}s contained within this
	 * array object.
	 * 
	 */
	public Value[] toArray() {
		
		return valueArray.toArray(new Value[]{});
	}
	
	/**
	 * @return Returns the length of the array as <code>int</code>
	 */
	public int length() {
		
		return valueArray.size();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return Arrays.toString(valueArray.toArray(new Value[]{}));
	}
}
