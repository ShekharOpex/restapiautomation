package com.eaaas.utilties;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;

public class restValidator {

	private restResponse response;

	restValidator(restResponse response) {
		this.response = response;
	}

	public restValidator expectCode(int expectedCode) {
		System.out.println("code"+expectedCode);
		assertEquals(expectedCode, response.getResponseCode());
		return this;
	}

	public restValidator expectMessage(String message) {
		assertEquals(message, response.getResponseMessage());
		return this;
	}

	public restValidator expectHeader(String headerName, String headerValue) {
		assertEquals(headerValue, response.getHeader(headerName));
		return this;
	}

	public restValidator expectHeaders(HashMap<String, String> headers) {
		Set<String> keys = headers.keySet();
		for (String key : keys) {
			assertEquals("Incorrect header - " + key, headers.get(key), response.getHeader(key));
		}
		return this;
	}

	public restValidator expectInBody(String content) {
		Assert.assertTrue(response.getResponseBody().trim().contains(content));
		return this;
	}
	
	public restValidator printBody(){
		System.out.println(response.getResponseBody());
		return this;
	}
	
	public restResponse getResponse(){
		return response;
	}

}
