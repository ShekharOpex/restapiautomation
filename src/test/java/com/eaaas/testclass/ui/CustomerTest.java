package com.eaaas.testclass.ui;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.eaaas.ui.main.CustomerPage;
import com.eaaas.ui.main.LoginPage;
import com.eaaas.utilties.Utility;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerTest extends CustomerPage {

	public static By Users_Btn_Xpath = By
			.xpath("html/body/qs-app/qs-main/td-layout/md-sidenav-layout/md-content/menu-items/a[5]/div");

	@Given("I click on add customer button")
	public void I_create_a_new_customer() throws InterruptedException {
		Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		LoginPage.clickOnTeradataMenuIcon();
		Thread.sleep(3000);
		CustomerPage.addCustomer();
	}

	@Then("I should get On-board Customer page")
	public void I_should_be_on_customer_page() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("onboard_customer_title")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("onboard_customer_title")))
						.getText(), "Onboard Customer");
	}

	@When("I fill all the mandatory details")
	public void I_fill_all_the_mandatory_details() throws InterruptedException {

		CustomerPage.fill_customer_onboard_form();
		//CustomerPage.fill_CCU_details();
	}

	@When("I click on submit button")
	public void click_on_submit_button() throws InterruptedException {
		CustomerPage.click_on_csonboard_submit();

	}

	@Then("I should get Customer listing page")
	public void customer_listing_page() throws InterruptedException {

		CustomerPage.customer_list_page();
	}

	@Given("I search created customer in list")
	public void Created_user_should_dispaly_on_screen()
			throws InterruptedException {
		Thread.sleep(5000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		CustomerPage.validate_created_customer();

	}

	@Then("I will get true or false according")
	public void result_customer() throws InterruptedException {

		CustomerPage.cust_validate_result();
	}

	@Given("I search customer on-boarding status")
	public void Customer_onborading_status() throws InterruptedException {
		Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		CustomerPage.validate_created_customer();
		CustomerPage.cust_validate_result();
		CustomerPage.fetch_status_icon();

	}

	@Then("I will get on-boarding status")
	public void csutomer_onboard_status() throws InterruptedException {
		System.out.println("enter in status section");
		CustomerPage.onboard_status();
	}

	@Given("I get on boarding status is success")
	public void I_get_on_boarding_status_is_success()
			throws InterruptedException {

		Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		CustomerPage.validate_created_customer();
		CustomerPage.cust_validate_result();
		Thread.sleep(120000);
		CustomerPage.fetch_status_icon();
		CustomerPage.onboard_status();

	}

	@When("I click on deploy icon")
	public void I_click_on_deploy_button() throws InterruptedException {
		CustomerPage.click_on_deploy_icon();
		Thread.sleep(5000);
	}

	@Then("I should get solutions page")
	public void I_should_get_deploy_application_screen()
			throws InterruptedException {
		CustomerPage.on_deploy_app_page();

	}

	@When("I click to select application")
	public void I_click_to_select_application() throws InterruptedException {

		CustomerPage.select_app_for_deployment();
	}

	@When("I click deploy on solution")
	public void I_click_deploy_on_solution() throws InterruptedException {

		CustomerPage.select_app_for_deployment();
	}

	@Then("I will get input parameter page")
	public void I_will_get_input_perameter_page() throws InterruptedException {
		CustomerPage.input_parameter_page();

	}

	@When("I fill required input parameter")
	public void I_fill_required_input_parameter() throws InterruptedException {

		CustomerPage.fill_input_perameter();
	}

	@When("I click on Deploy button")
	public void I_click_on_Deploy_button() throws InterruptedException {
		CustomerPage.clickon_deploy_solution();

	}

	@Then("I should get deployment lunch successful pop up message box")
	public void lunch_sucess_msg() throws InterruptedException {
		CustomerPage.app_deploy_success_msg();

	}

	@Given("I search solution deployment status for specific customer")
	public void cust_solution_deploy_status() throws InterruptedException {

		Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		CustomerPage.validate_created_customer();
		CustomerPage.click_on_action_menu_btn();
	}

	@Then("I will get success or failed status")
	public void status_result() throws InterruptedException {
		CustomerPage.check_sol_deploy_status();
	}

	@Given("I edit customer details for specific customer")
	public void edit_cust_details() throws InterruptedException {

		Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		CustomerPage.validate_created_customer();
		CustomerPage.click_on_edit_cust();
	}

	@Then("I will get edit customer details success message")
	public void success_msg() throws InterruptedException {
		CustomerPage.edit_cust_success_msg();
	}

	@Given("I will click on edit ccu details")
	public void click_edit_ccu_details() throws InterruptedException {

		Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		CustomerPage.validate_created_customer();
		CustomerPage.check_ccu_details();
	}

	@Then("I will get edit ccu detail page")
	public void ccu_edit_page() throws InterruptedException {
		CustomerPage.ccu_details_page();
	}
}