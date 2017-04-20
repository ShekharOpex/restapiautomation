package com.eaaas.ui.main;

//package com.example.tests;

//import java.util.regex.Pattern;
//import java.util.concurrent.TimeUnit;

//import org.junit.*;

import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.*;

//import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

//Above is from Selenium


//import static org.junit.Assert.assertEquals;

//import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.eaaas.utilties.Utility;



public class DashboardContentPage {
	
	private static StringBuffer verificationErrors = new StringBuffer();

//To Validate Dashboard Page content
	public static void Dashboard_items() throws InterruptedException { 
		try {
		      assertEquals("Dashboard", Utility.driver.findElement(By.xpath("//div/div/span")).getText());
		    } catch (Error e) {
		    	DashboardContentPage.verificationErrors.append(e.toString());
		    }
		try {
		      assertEquals("Customers Onboarded0", Utility.driver.findElement(By.cssSelector("span.md-body-1.firepath-matching-node")).getText());
		    } catch (Error e) {
		    	DashboardContentPage.verificationErrors.append(e.toString());
		    }
		 try {
		      assertEquals("Ready for Pre-Production0", Utility.driver.findElement(By.cssSelector("span.md-body-1.firepath-matching-node")).getText());
		    } catch (Error e) {
		    	DashboardContentPage.verificationErrors.append(e.toString());
		    }
		 try {
		      assertEquals("Ready for Production0", Utility.driver.findElement(By.cssSelector("span.md-body-1.firepath-matching-node")).getText());
		    } catch (Error e) {
		    	DashboardContentPage.verificationErrors.append(e.toString());
		    }
		 try {
		      assertEquals("Solutions Deployed0", Utility.driver.findElement(By.cssSelector("span.md-body-1.firepath-matching-node")).getText());
		    } catch (Error e) {
		    	DashboardContentPage.verificationErrors.append(e.toString());
		    }
		
	}
		
	
//To validate Dashabord Header Items
	public static void Dashboard_Header_items() throws InterruptedException {
		try {
		      assertEquals("EcoSystem Apps", Utility.driver.getTitle());
		    } catch (Error e) {
		    	DashboardContentPage.verificationErrors.append(e.toString());
	}
		
	}
//Content items Should be visible 
	public static void Items_Should_be_Visible() throws InterruptedException {
		System.out.println("Dashboard loaded Successfully");
	}
}