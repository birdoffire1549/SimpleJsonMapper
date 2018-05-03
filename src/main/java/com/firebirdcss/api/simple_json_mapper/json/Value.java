package com.firebirdcss.api.simple_json_mapper.json;

import java.util.Arrays;

import com.firebirdcss.api.simple_json_mapper.util.JsonUtils;

/**
 * This object stores a value as derived from JSON.
 * <p>
 * All stored values will be one of three types which are
 * as follows:
 * <ul>
 * 		<li> JsonObject
 * 		<li> JsonArray
 * 		<li> String
 * </ul>
 * 
 * Things that are strings could also be considered to be numeric if 
 * they could be converted to a number without exception.
 * 
 * @author Scott Griffis
 *
 */
public class Value {
	private boolean isJsonObject = false;
	private boolean isJsonArray = false;
	private boolean isString = false;
	
	private Object value = null;
	
	/**
	 * Used to ensure that the type booleans are all done being set 
	 * prior to anyone else trying to modify them. Eliminates the 
	 * potential for collisions which could result in multiple types being
	 * true at once.
	 */
	private Object lock = new Object();
	
	/**
	 * CONSTRUCTOR: Basic no parameter constructor.
	 *
	 */
	public Value() {
		// Does nothing except guarantee it is here for use.
	}
	
	/**
	 * Allows for the value to be set.
	 * 
	 * @param valueString - The value as a {@link String}
	 */
	public void setValue(String valueString) {
		synchronized(lock) {
			value = valueString;
			isJsonObject = false;
			isJsonArray = false;
			isString = true;
		}
	}
	
	/**
	 * Allows for the value to be set.
	 * 
	 * @param jsonObject - The value as a {@link JsonObject}
	 */
	public void setValue(JsonObject jsonObject) {
		synchronized(lock) {
			value = jsonObject;
			isJsonObject = true;
			isJsonArray = false;
			isString = false;
		}
	}
	
	/**
	 * Allows for the value to be set.
	 * 
	 * @param jsonArray - The value as a {@link JsonArray}
	 */
	public void setValue(JsonArray jsonArray) {
		synchronized(lock) {
			value = jsonArray;
			isJsonObject = false;
			isJsonArray = true;
			isString = false;
		}
	}
	
	/**
	 * @return Returns true if stored value is of type JsonObject, otherwise
	 * returns false as <code>boolean</code>.
	 * 
	 */
	public boolean isObject() {
		
		return isJsonObject;
	}
	
	/**
	 * @return Returns true if stored value could be converted to a number
	 * from a string, otherwise returns false as <code>boolean</code>.
	 * 
	 */
	public boolean isNumeric() {
		if (isString()) {
		
		return JsonUtils.isNumeric((String) value);
		}
		
		return false;
	}
	
	/**
	 * @return Returns true if stored value is of type String, otherwise
	 * returns false as <code>boolean</code>.
	 * 
	 */
	public boolean isString() {
		
		return isString;
	}
	
	/**
	 * @return Returns true if the stored value is of type JsonArray, otherwise
	 * returns false as <code>boolean</code>.
	 * 
	 */
	public boolean isArray() {
		
		return isJsonArray;
	}
	
	/**
	 * Allows for the value to be returned as a JsonObject if that is what
	 * was stored, otherwise a null is returned.
	 * 
	 * @return Returns the value as a {@link JsonObject}, otherwise null.
	 */
	public JsonObject getAsJsonObject() {
		if (isJsonObject) {
			
			return (JsonObject) value;
		}
		
		return null;
	}
	
	/**
	 * Allows for the value to be returned as a JsonArray if that is what
	 * was stored, otherwise a null is returned.
	 * 
	 * @return Returns the value as a {@link JsonArray}, otherwise null.
	 */
	public JsonArray getAsArray() {
		if (isArray()) {
			
			return (JsonArray) value;
		}
		
		return null;
	}
	
	/**
	 * @return Returns the value as a {@link String}.
	 * 
	 */
	public String getAsString() {
		if (isString) {
			
			return (String) value;
		}
		
		return null;
	}
	
	/**
	 * Allows for a numeric {@link String} value to be returned as an {@link Integer} value.
	 * 
	 * @return Returns the value as an {@link Integer} unless it is not numeric in which
	 * case it would be returned as null.
	 */
	public Integer getAsInteger() {
		if (isString && JsonUtils.isNumeric((String) value)) {
			
			return Integer.valueOf((String) value);
		}
		
		return null;
	}
	
	/**
	 * Allows for a numeric {@link String} value to be returned as a {@link Long} value.
	 * 
	 * @return Returns the value as a {@link Long} unless it is not numeric in which
	 * case it would be returned as null.
	 */
	public Long getAsLong() {
		if (isString && JsonUtils.isNumeric((String) value)) {
			
			return Long.valueOf((String) value);
		}
		
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (isString) {
			
			return (String) value;
		} else if (isJsonObject) {
			
			return ((JsonObject) value).toString();
		} else if (isJsonArray) {
			
			return Arrays.toString(((JsonArray) value).toArray());
		}
		
		return null;
	}
}
