package com.eaaas.testclass.ui;

import org.openqa.selenium.By;

import com.eaaas.ui.main.CustomerPage;
import com.eaaas.ui.main.LoginPage;
import com.eaaas.ui.main.PermissionRolePage;
import com.eaaas.ui.main.PermissionRolePage;
import com.eaaas.utilties.Utility;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PermissionRole extends PermissionRolePage {

	public static By roles_Btn_Xpath = By
			.xpath("html/body/qs-app/qs-main/td-layout/md-sidenav-layout/md-content/menu-items/a[5]/div");

	@Given("I click on add Role button")
	public void create_new_role() throws InterruptedException {
		// Thread.sleep(1000);
		LoginPage.loginToEAss("paras", "Opex@123");
		Thread.sleep(2500);
		LoginPage.clickOnTeradataMenuIcon();
		Thread.sleep(3000);
		PermissionRolePage.click_on_roleicon();
		Thread.sleep(3000);
		PermissionRolePage.click_on_addrole();
	}

	@Then("I should get add role page")
	public void I_should_be_on_add_role_page() throws InterruptedException {

		PermissionRolePage.on_addrole_page();
	}

	@When("I fill all add role page mandatory details")
	public void I_fill_role_page_form() throws Exception {

		PermissionRolePage.fill_add_role_form();
	}

	@When("I select permissions for role")
	public void select_role_role() throws InterruptedException {

		PermissionRolePage.select_roles();
	}

	@When("I click on role save button")
	public void I_click_on_save_button() throws InterruptedException {

		PermissionRolePage.add_role_save_btn();
	}

	@Then("I Should get role save success message")
	public void I_Should_get_role_save_success_message()
			throws Exception {

		PermissionRolePage.role_save_success_msg_bx();
	}

	@Then("I should get role listing page")
	public void I_should_get_roles_listing_page() throws InterruptedException {

		PermissionRolePage.roles_list_page();
	}

	@Given("I click on delete role button")
	public void I_click_on_delete_role_button() throws Exception {
		// Thread.sleep(1000);
		LoginPage.loginToEAss("ganesh", "Opex@123");
		Thread.sleep(2500);
		LoginPage.clickOnTeradataMenuIcon();
		Thread.sleep(3000);
		PermissionRolePage.click_on_roleicon();
		Thread.sleep(3000);
		PermissionRolePage.click_on_deleterole_btn();
	}

	@Then("I Should get role delete success message")
	public void I_Should_get_role_delete_success_message()
			throws InterruptedException {

		PermissionRolePage.role_delet_success_msg();
	}

	@Given("I click on edit role button")
	public void I_click_on_edit_role_button() throws Exception {
		// Thread.sleep(1000);
		LoginPage.loginToEAss("paras", "Opex@123");
		Thread.sleep(2500);
		LoginPage.clickOnTeradataMenuIcon();
		Thread.sleep(3000);
		PermissionRolePage.click_on_roleicon();
		Thread.sleep(3000);
		PermissionRolePage.click_on_edit_btn();
	}

	@Then("I will edit role details")
	public void Edit_role_form_should_display() throws InterruptedException {

		PermissionRolePage.fill_edit_role_form();
		PermissionRolePage.select_permissions_for_role_edit();
	}

	@When("I click on update button")
	public void I_click_on_update_button() throws InterruptedException {

		PermissionRolePage.click_update_btn();

	}

	@Then("I should get role update successfully message")
	public void I_should_get_role_update_successfully_message()
			throws InterruptedException {

		PermissionRolePage.update_role_success_msg();
	}
	
	@And("I verify role deleted from listing")
	public void I_verify_role_deleted_from_listing() throws InterruptedException{
		PermissionRolePage.isRoleDeletedFromListing();
	}
	
	//Defining for new Scenario 
	
	@Given("Given I click on edit role button to  assign user")
	public void I_click_on_edit_role_button_to_assign_user() throws Exception {
		// Thread.sleep(1000);
		LoginPage.loginToEAss("paras", "Opex@123");
		Thread.sleep(2500);
		LoginPage.clickOnTeradataMenuIcon();
		Thread.sleep(3000);
		PermissionRolePage.click_on_roleicon();
		Thread.sleep(3000);
		PermissionRolePage.click_on_edit_btn();
	}
	@Then ("I type assign user name to role")
	public void I_type_assign_user_name_to_role() throws InterruptedException{
		Thread.sleep(1000);
		
	}
	
	@Then ("Then I click on Update")
	public void I_click_on_Update() throws InterruptedException{
		Thread.sleep(1000);
		
	}
	
	@Then ("Then I should get role assign Successfully message")
	public void I_should_get_role_assign_Successfully_message() throws InterruptedException{
		Thread.sleep(1000);
	}		
}