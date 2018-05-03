package com.firebirdcss.api.simple_json_mapper.tests;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.firebirdcss.api.simple_json_mapper.util.JsonUtils;

/**
 * This Unit test is for the testing of the various JSON utility methods
 * of the {@link JsonUtils} class.
 * 
 * @author Scott Griffis
 *
 */
public final class JsonUtilsTest {
	
	@Test
	public void testDataPathToHopsNoQuotes() {
		String[] answer = new String[] {
			"abc",
			"defg",
			"hij",
			"klmnop"
		};
		
		Assert.assertArrayEquals(answer, JsonUtils.DataPathToHops("abc.defg.hij.klmnop"));
	}
	
	@Test
	public void testDataPathToHopsWithQuotes() {
		String[] answer = new String[] {
			"abc.defg",
			"hij",
			"klmnop"
		};
		
		Assert.assertArrayEquals(answer, JsonUtils.DataPathToHops("\"abc.defg\".hij.klmnop"));
	}
	
	@Test
	public void testIsNumericTrue() {
		String[] numeric = {
				"1",
				"123",
				"9876",
				"836503",
				"4.3",
				"-234"
		};
		
		for (String n : numeric) {
			assertTrue(n, JsonUtils.isNumeric(n));
		}
	}
	
	@Test
	public void testIsNumericFalse() {
		String[] nonNumeric = {
				"7687-87",
				"",
				null,
				"3sdkfj32",
				"3..3",
				".234.3"
		};
		
		for (String n : nonNumeric) {
			assertFalse(n, JsonUtils.isNumeric(n));
		}
	}
}
