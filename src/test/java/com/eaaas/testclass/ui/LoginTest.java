package com.eaaas.testclass.ui;

import com.eaaas.ui.main.LoginPage;
import com.eaaas.utilties.Utility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginTest extends LoginPage {
		
	@Given("I am logging as Default System Admin")
	public void I_login_with_user_and_password() throws InterruptedException {
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
	}

	@Then("I Verify Dashboard Page")
	public void I_should_be_on_home_page() throws Throwable {
		LoginPage.verifyDashboardPageOnScreen();
	}

	@Given("I am logging as Inavlid username")
	public void I_login_with_invalid_username() throws InterruptedException {
		LoginPage.loginToEAss("amdin001", Utility.credProp.getProperty(Utility.AdminUsername));
	}

	@Then("I should be on login screen with invalid credential error message")
	public void I_should_be_on_error_screen() throws Throwable {
		LoginPage.verifyInvalidCredentialMessage();

	}

	@Given("I am logging as Invalid password")
	public void I_login_with_invalid_password() throws InterruptedException {
		LoginPage.loginToEAss(Utility.AdminUsername, "1234");
	}

	@Given("I am logging as blank space pass and username")
	public void I_login_with_blank_user_pass() throws InterruptedException {
		LoginPage.loginToEAss(" ", " ");
	}
}