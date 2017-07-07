package com.eaaas.api.main;

//import java.util.HashMap;
//import java.util.Map;

import com.eaaas.utilties.Utility;


public class fire_All_Post extends Utility{
	
	
	public static  void post_call() {
		Integer strTestID=testAPIExcel.retrieveRowNo(defaultSheetName, "GETPODLIST");
		//String code=getAuthCode().toString();		
		//System.out.println("CODE---"+code);
		String strURL=testAPIExcel.retrieveCell(defaultSheetName, "URL", strTestID);
		//String strBody=testAPIExcel.retrieveCell(defaultSheetName, "Body", strTestID);
		String strExResponse=testAPIExcel.retrieveCell(defaultSheetName, "Response", strTestID);
		
		//Map<String, String> hsHeader=new HashMap <String,String>();
		//hsHeader.put("authToken",code);
		strResponse=executor.post(path, headers, xmlContent, contentType)
	             .expectCode(200)
	             .expectInBody(strExResponse);
		
		System.out.println("Expected Response Body>"+strExResponse);
		
		}
			

}