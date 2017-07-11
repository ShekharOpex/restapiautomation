package com.teradata.ia.restAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.teradata.ia.service.RestApiAutomationService;
import com.teradata.ia.service.impl.RestApiAutomationServiceImpl;
/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
public class RestApiAutomation {
     
    String excelFilePath = "temp.xlsx";
    RestApiAutomationService restApiAutomationService=new RestApiAutomationServiceImpl();
    String api,method,url,headers,responseBody,requestBody,token;
	public void testRestApi() throws IOException
	{
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();         
        while (iterator.hasNext()) {
        	
        	Row nextRow = iterator.next();
        	if(nextRow.getRowNum()==0 ){
     		   continue; //just skip the rows if row number is 0
     		  }
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            this.api = cellIterator.hasNext() ? cellIterator.next().getStringCellValue(): "";
            this.url = cellIterator.hasNext() ? cellIterator.next().getStringCellValue(): "";
            this.method = cellIterator.hasNext() ? cellIterator.next().getStringCellValue(): "";
            this.headers = cellIterator.hasNext() ? cellIterator.next().getStringCellValue(): "";
            this.token = cellIterator.hasNext() ? cellIterator.next().getStringCellValue(): "";
            this.requestBody = cellIterator.hasNext() ? cellIterator.next().getStringCellValue(): "";
            this.responseBody = cellIterator.hasNext() ? cellIterator.next().getStringCellValue(): "";

          System.out.println("=============================================================================");
            switch (this.method) {
            
            case "GET":
            	restApiAutomationService.testGet(this.url,this.token);
            	break;
           	case "POST":
            	restApiAutomationService.testPost(this.url,this.requestBody,this.token);
            	break;
           	case "PATCH":
           		restApiAutomationService.testUpdate(this.url,this.requestBody,this.token);
            	break;
           	case "DELETE":
            	restApiAutomationService.testDelete(this.url,this.token);

            	break;
            	
            }
    
      }
	}
        
}