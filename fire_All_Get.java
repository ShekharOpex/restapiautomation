package com.eaaas.api.main;

//import java.util.HashMap;
//import java.util.Map;

import com.eaaas.utilties.Utility;


public class fire_All_Get extends Utility{
	

	
	public static  void PODListing() {
		Integer strTestID=testAPIExcel.retrieveRowNo(defaultSheetName, "GETPODLIST");
		//String code=getAuthCode().toString();		
		//System.out.println("CODE---"+code);
		String strURL=testAPIExcel.retrieveCell(defaultSheetName, "URL", strTestID);
		//String strBody=testAPIExcel.retrieveCell(defaultSheetName, "Body", strTestID);
		String strExResponse=testAPIExcel.retrieveCell(defaultSheetName, "Response", strTestID);
		
		//Map<String, String> hsHeader=new HashMap <String,String>();
		//hsHeader.put("authToken",code);
		strResponse=executor.get(strURL)
	             .expectCode(200)
	             .expectInBody(strExResponse);
		
		System.out.println("Expected Response Body>"+strExResponse);
		
		}
			

}