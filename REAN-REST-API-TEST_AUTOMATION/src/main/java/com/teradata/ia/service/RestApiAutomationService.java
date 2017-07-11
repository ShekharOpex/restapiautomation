package com.teradata.ia.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface RestApiAutomationService {

	public String testGet(String endPoint,String Token) throws ClientProtocolException, IOException;
	public String testDelete(String endpoint,String token) throws ClientProtocolException, IOException;
	public String testPost(String endPoint,String data,String token);
	public String testUpdate(String endPoint,String data,String token);
}
