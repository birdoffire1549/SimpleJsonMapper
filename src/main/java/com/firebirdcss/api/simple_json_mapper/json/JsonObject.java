package com.firebirdcss.api.simple_json_mapper.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.firebirdcss.api.simple_json_mapper.mapping.MappedItem;
import com.firebirdcss.api.simple_json_mapper.mapping.MappedItems;
import com.firebirdcss.api.simple_json_mapper.util.JsonUtils;

/**
 * This item makes up a JSON Object and contains functionality required
 * to make use of the object and retrieve its values.
 * 
 * @author Scott Griffis
 *
 */
public class JsonObject {
	private final String json;
	private final MappedItems mappedItems;
	private final Map<String, Value> cachedValues = new HashMap<>();
	private final int startIndex;
	private final int endIndex;
	
	/**
	 * CONSTRUCTOR: Used to initialize this class.
	 *
	 * @param json - The JSON of the object as {@link String}
	 * @param mappedItems - The mappedItems which describe the contents 
	 * of this object as {@link MappedItems}
	 */
	public JsonObject(String json, MappedItems mappedItems) {
		this.json = json;
		this.mappedItems = mappedItems;
		MappedItem item = mappedItems.getFirstItem();
		startIndex = item.getOpenIndex();
		endIndex = item.getCloseIndex();
	}
	
	/**
	 * Allows for a value to be fetched using its dataPath.
	 * 
	 * @param dataPath - The dataPath of the desired value as {@link String}
	 * @return Returns the desired value as {@link Value}
	 */
	public Value getValue(String dataPath) {
		
		return getValue(JsonUtils.DataPathToHops(dataPath));
	}
	
	/**
	 * Allows for a value to be fetched using an array of hops that make up
	 * a value's dataPath.
	 * 
	 * @param dataPathHops - An array of {@link String}s which are the hops of
	 * the given dataPath.
	 * @return Returns the desired value as {@link Value}
	 */
	public Value getValue(String[] dataPathHops) {
		if (dataPathHops != null) {
			String currentHop = dataPathHops[0];
			
			String arrayIndex = null; 
			int startBracketIndex = currentHop.indexOf('[');
			if (startBracketIndex != -1) {
				arrayIndex = currentHop.substring(startBracketIndex, currentHop.length());
				currentHop = currentHop.substring(0, startBracketIndex);
			}
			
			Value value = getValueFromCache(currentHop, arrayIndex, dataPathHops);
			if (value != null) {
				
				return value;
			}
			
			return getValueFromJson(currentHop, arrayIndex, dataPathHops);
		}
		
		return null;
	}
	
	/**
	 * Attempts to retrieve a value from cache if it exists, otherwise null.
	 * 
	 * @param currentHop - The currentHop as {@link String}
	 * @param arrayIndex - The arrayIndex(es) as {@link String}
	 * @param dataPathHops - The dataPathHops as an array of {@link String}s
	 * @return Returns the desired value as {@link Value}
	 */
	private Value getValueFromCache(String currentHop, String arrayIndex, String[] dataPathHops) {
		Value value = cachedValues.get(currentHop);
		if (value != null) {
			if (dataPathHops.length == 1) { // These ARE the droids I am looking for...
				if (arrayIndex != null) { // Addressing an array...
					if (value.isArray()) { // Good array so fetch value now...
						
						return value.getAsArray().getValue(arrayIndex);
					} // Addressed as array a non-array, oops, fall-through as null...
				} else { // Not addressing an array...
					
					return value;
				}
			} else if (dataPathHops.length > 1) { // Starting to feel like a rabbit, more hops left...
				if (value.isObject() && arrayIndex == null) { // More hops are only valid for an object, or maybe array...
					String[] modHops = Arrays.copyOfRange(dataPathHops, 1, dataPathHops.length);
					
					return value.getAsJsonObject().getValue(modHops);
				} else if (value.isArray()) { // More hops with an array requires an index...
					if (arrayIndex != null) { // Oh good we have an index...
						String[] modHops = Arrays.copyOfRange(dataPathHops, 1, dataPathHops.length);
						
						value = value.getAsArray().getValue(arrayIndex);
						if (value.isObject()) {
							
							return value.getAsJsonObject().getValue(modHops);
						}
					}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Attempts to retrieve a value from the source JSON.
	 * 
	 * @param currentHop - The currentHop as {@link String}
	 * @param arrayIndex - The arrayIndex(es) as {@link String}
	 * @param dataPathHops - The dataPathHops as an array of {@link String}s
	 * @return Returns the desired value as {@link Value}
	 */
	private Value getValueFromJson(String currentHop, String arrayIndex, String[] dataPathHops) {
		if (mappedItems != null) {
			String key = null;
			
			if (mappedItems.getFirstItem() != null && mappedItems.getFirstItem().getCharType() == CharType.CURLY_BRACKET) {
				mappedItems.removeFirstItem(); // move past curly...
			}
			
			while (mappedItems.size() > 0) {
				MappedItem item = mappedItems.getFirstItem(); // Got an item, now process it...
				
				Value value = null;
				if (item.getCharType() == CharType.CURLY_BRACKET) { // <-----------------------------{ Object Found...
					JsonObject obj = new JsonObject(json, mappedItems.pullEncapsulatedItems(item));
					this.cachedValues.put(key, obj.toValue()); // #### CACHE IT! ####
					
					if (dataPathHops.length > 1) {
						value = obj.getValue(Arrays.copyOfRange(dataPathHops, 1, dataPathHops.length));
					} else {
						value = new Value();
						value.setValue(obj);
					}
					if (mappedItems.size() > 0 && mappedItems.getFirstItem().getCharType() == CharType.COMMA) {
						mappedItems.removeFirstItem(); // remove comma
					}
				} else if (item.getCharType() == CharType.SQUARE_BRACKET) { // <---------------------{ Array Found...
					JsonArray array = new JsonArray(json, mappedItems.pullEncapsulatedItems(item));
					this.cachedValues.put(key, array.toValue()); // #### CACHE IT! ####
					
					value = array.getValue(arrayIndex);
					
					if (dataPathHops.length > 1) {
						if (value != null && value.isObject()) {
							value = value.getAsJsonObject().getValue(Arrays.copyOfRange(dataPathHops, 1, dataPathHops.length));
						} else {
							value = null; // more hops but no one to give them to...
						}
					}
					if (mappedItems.size() > 0 && mappedItems.getFirstItem().getCharType() == CharType.COMMA) {
						mappedItems.removeFirstItem(); // remove comma
					}
				} else { // Must be a key or value???
					if (item.getCharType() == CharType.DOUBLE_QUOTE 
							&& mappedItems.peekSecondItem().getCharType() == CharType.COLON
					) { // <-------------------------------------------------------------------------{ Key Found...
						key = json.substring(item.getOpenIndex() + 1, item.getCloseIndex());
						value = null;
						mappedItems.removeFirstItem(); // removes quotes...
						mappedItems.removeFirstItem(); // removes colon...
					} else if (item.getCharType() == CharType.COLON) { // <--------------------------{ Key Found...
						/* Get the Key */
						MappedItem prev = mappedItems.recallPreviousItem();
						int startIndex = (prev.getCharType() != CharType.CURLY_BRACKET && prev.getCloseIndex() != -1 ? prev.getCloseIndex() : prev.getOpenIndex());
						key = json.substring(startIndex + 1, item.getOpenIndex()).trim();
						value = null;
						mappedItems.removeFirstItem(); // removes colon...
					} else if (item.getCharType() == CharType.DOUBLE_QUOTE) { // <-------------------{ Value Found...
							value = new Value();
							value.setValue(json.substring(item.getOpenIndex() + 1, item.getCloseIndex()));
							this.cachedValues.put(key, value); // #### CACHE IT! ####
							
							if (item.getCharType() == CharType.DOUBLE_QUOTE) {
								mappedItems.removeFirstItem();
							}
							if (mappedItems.size() > 0 && mappedItems.getFirstItem().getCharType() == CharType.COMMA) {
								mappedItems.removeFirstItem(); // Remove the comma...
							}
					} else { // <--------------------------------------------------------------------{ Value Found...
						value = new Value();
						String tmpValue = json.substring((mappedItems.recallPreviousItem().getCloseIndex() == -1 ? mappedItems.recallPreviousItem().getOpenIndex() : mappedItems.recallPreviousItem().getCloseIndex()) + 1, item.getOpenIndex());
						value.setValue((tmpValue == null ? null : tmpValue.trim()));
						this.cachedValues.put(key, value); // #### CACHE IT! ####
						
						if (mappedItems.size() > 0 && mappedItems.getFirstItem().getCharType() == CharType.COMMA) {
							mappedItems.removeFirstItem(); // removes the comma...
						}
					}
				}
				
				/* Pickup last item if applicable */
				MappedItem prev = mappedItems.recallPreviousItem();
				if (value == null && mappedItems.size() == 0 && prev != null && prev.getCharType() == CharType.COLON) { // Get last unquoted value...
					value = new Value();
					String tempValue = json.substring(mappedItems.recallPreviousItem().getOpenIndex() + 1, endIndex).trim();
					value.setValue(tempValue);
					this.cachedValues.put(key, value); // #### CACHE IT! ####
				}
				
				/* 
				 * Return a value if we have one; 
				 * This prevents from returning on key or other non-value syntax 
				 */
				if (value != null) {
				
					return value;
				}
			}
		}
		
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return json.substring(startIndex, endIndex + 1);
	}
	
	/**
	 * @return Gets this JsonObject as a {@link Value} Object.
	 * 
	 */
	public Value toValue() {
		Value value = new Value();
		value.setValue(this);
		
		return value;
	}
	
	/**
	 * This method allows for a Child Node to get the JSON from it's
	 * Parent Node. 
	 * <p>
	 * In particular this is used for the recursive parsing of the JSON so we don't
	 * have to look at any part of the JSON more than once.
	 * 
	 * @return Returns the parent's JSON as {@link String}
	 */
	protected String getJson() {
	
		return this.json;
	}
}
