package com.eaaas.testclass.ui;

//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

//import com.eaaas.ui.main.CustomerPage;
import com.eaaas.ui.main.DashboardContentPage;
import com.eaaas.ui.main.LoginPage;
import com.eaaas.utilties.Utility;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardContentTest extends DashboardContentPage {
	
	public static By Users_Btn_Xpath = By
			.xpath("html/body/qs-app/qs-main/td-layout/md-sidenav-layout/md-content/menu-items/a[5]/div");

	@Given("I have to validate Dashboard Customer Environment content")
	public void Login_in_Ecosystem_and_start_to_Validate_Dashboard_Contents() throws InterruptedException {
		Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Dashboard_items();
		Thread.sleep(2500);
	
	}

	@And("Ecosystem Header")
	public void I_should_be_validate_dashboard_Header_Items() throws InterruptedException {
		Thread.sleep(5000);
		Dashboard_Header_items();
		
	}

	@Then("I complete Content Validation All Environment content should be visible")
	public void Dashboard_Page_Should_be_Load_as_expected() throws InterruptedException {
		Items_Should_be_Visible();
		
	}
}
	