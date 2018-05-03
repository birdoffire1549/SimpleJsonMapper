package com.firebirdcss.api.simple_json_mapper.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.firebirdcss.api.simple_json_mapper.SimpleJsonMapper;
import com.firebirdcss.api.simple_json_mapper.json.Value;

/**
 * The primary purpose of this Unit Test is to ensure the 
 * proper functionality of the {@link JsonArray} class.
 * 
 * @author Scott Griffis
 *
 */
public class JsonArrayTest {

	@Test
	public final void test() {
		String json = ""
				+ "{\n"
					+ "\"multi\":[a,b, c ,d,[aa,bb,cc], {name:scott}]\n"
				+ "}";
		
		SimpleJsonMapper sjm = new SimpleJsonMapper(json);
		Value value = sjm.getValue("multi");
		assertTrue(value.isArray());
		assertEquals(value.toString(), 6, value.getAsArray().length());
		assertEquals("a", sjm.getValue("multi[0]").toString());
		assertEquals("b", sjm.getValue("multi[1]").toString());
		assertEquals("c", sjm.getValue("multi[2]").toString());
		assertEquals("d", sjm.getValue("multi[3]").toString());
		Value v2 = sjm.getValue("multi[4]");
		assertTrue(v2.isArray());
		assertEquals(3, v2.getAsArray().length());
		assertEquals("aa", v2.getAsArray().getValue(0).toString());
		assertEquals("aa", sjm.getValue("multi[4][0]").toString());
		assertEquals("bb", v2.getAsArray().getValue(1).toString());
		assertEquals("bb", sjm.getValue("multi[4][1]").toString());
		assertEquals("cc", v2.getAsArray().getValue(2).toString());
		assertEquals("cc", sjm.getValue("multi[4][2]").toString());
		Value obj = sjm.getValue("multi[5]");
		assertTrue(obj.isObject());
		assertEquals("scott", sjm.getValue("multi[5].name").toString());
	}
}
