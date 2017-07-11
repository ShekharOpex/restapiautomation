package com.teradata.ia.service.impl;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.teradata.ia.service.RestApiAutomationService;
public class RestApiAutomationServiceImpl  implements RestApiAutomationService  {

	
    private final static Logger logger = LoggerFactory.getLogger(RestApiAutomationServiceImpl.class);

	@Override
	public String testGet(String endPoint,String token) throws ClientProtocolException, IOException {
		try{
		System.out.println("Testing GET:"+endPoint);
		HttpUriRequest request = new HttpGet(endPoint);
		request.addHeader("Authorization",token);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		System.out.println("response:" +httpResponse.getStatusLine().getStatusCode());
		//System.out.println("response:" +httpResponse.getEntity().toString());
		//System.out.println("response:" +httpResponse.getStatusLine().toString());
		//System.out.println("response:" +httpResponse.toString());
		//System.out.println("response:" +httpResponse.);
		String responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println(responseString);
		}
		catch(HttpResponseException httpResponseException){
			logger.info("Exception from highland API GET/"+endPoint, httpResponseException);			
		}
		catch(Exception e){
		
			 logger.info("Exception from highland API GET/"+endPoint,e);
		}
		return "done";
		
	}

	
	@Override
	public String testDelete(String endPoint,String token) throws ClientProtocolException, IOException {
		try{
			System.out.println("Testing DELETE:"+endPoint);
		
		HttpUriRequest request = new HttpDelete(endPoint);
		request.addHeader("Authorization",token);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		System.out.println("response:" +httpResponse.getStatusLine().getStatusCode());
		String responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println(responseString);
		
		}
		catch(HttpResponseException httpResponseException){
			logger.info("Exception from highland API DELETE/"+endPoint, httpResponseException);			
		}
		catch(Exception e){
			
			 logger.info("Exception from highland API DELETE/"+endPoint,e);
		}
		return "done";
	}


	@Override
	public String testPost(String endPoint, String data, String token) {
		try{
			System.out.println("Testing POST :"+endPoint);
		
		HttpPost request = new HttpPost(endPoint);
		StringEntity params =new StringEntity(data);
	    request.setEntity(params);
		request.addHeader("Authorization",token);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		System.out.println("response:" +httpResponse.getStatusLine().getStatusCode());
		String responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println(responseString);
		
		}
		catch(HttpResponseException httpResponseException){
			logger.info("Exception from highland API POST/"+endPoint, httpResponseException);			
		}
		catch(Exception e){
			
			 logger.info("Exception from highland API POST/"+endPoint,e);
		}
		return "done";
	}


	@Override
	public String testUpdate(String endPoint, String data, String token) {
		try{
			System.out.println("Testing PATCH :"+endPoint);
		
		HttpPatch request = new HttpPatch(endPoint);
		StringEntity params =new StringEntity(data);
	    request.setEntity(params);
		request.addHeader("Authorization",token);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		System.out.println("response:" +httpResponse.getStatusLine().getStatusCode());
		String responseString = new BasicResponseHandler().handleResponse(httpResponse);
		System.out.println(responseString);
		
		}
		catch(HttpResponseException httpResponseException){
			logger.info("Exception from highland API PATCH/"+endPoint, httpResponseException);			
		}
		catch(Exception e){
			
			 logger.info("Exception from highland API PATCH/"+endPoint,e);
		}
		return "done";
	}
 
}
