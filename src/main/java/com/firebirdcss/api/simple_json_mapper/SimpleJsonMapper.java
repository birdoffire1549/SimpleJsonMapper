package com.firebirdcss.api.simple_json_mapper;

import java.util.ArrayList;

import com.firebirdcss.api.simple_json_mapper.json.JsonObject;
import com.firebirdcss.api.simple_json_mapper.json.Value;
import com.firebirdcss.util.json_tools.JsonUtilities;
import com.firebirdcss.util.json_tools.mapping.MappedItem;
import com.firebirdcss.util.json_tools.mapping.MappedItems;

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
		mappedItems.clear();
		mappedItems.addAll(JsonUtilities.mapJson(json));
		baseObject = new JsonObject(json, new MappedItems(mappedItems));
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
	
	/**
	 * @return Returns the JSON's base object as {@link JsonObject)
	 * 
	 */
	public JsonObject getBaseObject() {
		
		return this.baseObject; 
	}
}
