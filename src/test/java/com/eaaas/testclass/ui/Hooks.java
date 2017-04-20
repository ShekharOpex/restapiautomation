package com.eaaas.testclass.ui;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.eaaas.reporting.UPAReporter;
import com.eaaas.utilties.Utility;
import com.eaaas.utilties.readXLS;
import com.eaaas.utilties.restExecutor;
import com.eaaas.utilties.restValidator;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	public static Select selectvalue;
	public static readXLS testAPIExcel = null;
	public static restExecutor executor = new restExecutor(null);
	public static String strContentType = "application/json";
	public static String defaultSheetName = "APIList";
	public static restValidator strResponse = null;
	public static Properties prop = null;
	public static FileInputStream file = null;
	
	@Before
	public static void init() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------------------- In HOOKS INIT () ---------------------------");
		System.out.println("In init");
		Utility.setup();
	}
	
	@After
	public static void cleanUp() {
		System.out.println("--------------------- In HOOKS CLEAN UP ------------------");
		System.out.println("***************I close driver");
		Utility.driver.quit();
		Utility.driver = null;
	}
}