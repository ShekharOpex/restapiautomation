package com.eaaas.ui.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.eaaas.utilties.Utility;

public class LoginPage {
	public static String INVALID_USER_NAME = "123";
	public static String INVALID_PWD = "123";
	public static String BLANK_SPACE_USER_NAME = " ";
	public static String BLANK_SPACE_PWD = " ";

	public static void loginToEAss(String username, String password)
			throws InterruptedException {
		
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("Login_Username_TB_Xpath")),
				username);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("Login_Password_TB_XPath")),
				password);
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("Login_Sign_In_Btn_XPath")));
	}

	public static void clickOnTeradataMenuIcon() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("Teradata_icon_button")));
	}

	public static void verifyDashboardPageOnScreen() {
		assertTrue("Failed, Unable to Login TDrive.",
				Utility.isElementPresent(By.xpath(Utility.prop
						.getProperty("Teradata_icon_button"))));
	}

	public static void logoutFromTDrive() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("user_name_drop_down")));
		Utility.clickToElement(By.xpath(Utility.prop.getProperty("logout_icon")));
	}

	public static void verifyInvalidCredentialMessage() {
		Utility.waitForElementBecomeVisible(
				By.xpath(Utility.prop.getProperty("invalid_credential_msg")),
				10);
		assertEquals(Utility.GetfieldText(By.xpath(Utility.prop
				.getProperty("invalid_credential_msg"))),
				"The user name or password you entered isn't correct. Try entering it again.");
	}
}