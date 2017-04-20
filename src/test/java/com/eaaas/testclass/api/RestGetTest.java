package com.eaaas.testclass.api;


import com.eaaas.api.main.Rest_Get_Validation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RestGetTest //extends Rest_Get_Validation
{
	@Given("I putted the details for GET POD on REST API")
	public void I_putted_the_details_for_GET_POD_on_REST_API() throws Throwable {
		System.out.println("****************************Staring TC:GET POD LIST****************************************");
		//	System.out.println("CODE---"+getAuthCode().toString());
	} 

	@Then("I Verify Response Code and Response Body")
	public void I_Verify_Response_Code_and_Response_Body() throws Throwable {
		System.out.println("HERE");

		Rest_Get_Validation.PODListing();
	}

}