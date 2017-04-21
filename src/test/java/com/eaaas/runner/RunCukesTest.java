package com.eaaas.runner;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.Select;

import com.eaaas.listener.ExtentCucumberFormatter;
import com.eaaas.utilties.readXLS;
import com.eaaas.utilties.restExecutor;
import com.eaaas.utilties.restValidator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/api/APICreateRole.feature"}, glue = {"com.eaaas.testclass.api"},monochrome = true,
plugin = {"com.eaaas.listener.ExtentCucumberFormatter","pretty", "json:target/cucumber/index.json"})
public class RunCukesTest {
   
	public static Select selectvalue;	
	public static  readXLS testAPIExcel;
	public static restExecutor executor= new restExecutor(null);	
	public static String strContentType="application/json";
	public static String defaultSheetName="APIList";
	public static restValidator strResponse=null;


	@BeforeClass
    public static void setup() throws Exception {
		System.out.println("In BeforeClass");
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);

    	System.out
		.println("------------====================------------------");

        
  }
}