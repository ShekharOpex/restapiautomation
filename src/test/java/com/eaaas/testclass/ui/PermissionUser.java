package com.eaaas.testclass.ui;

import org.openqa.selenium.By;

import com.eaaas.ui.main.LoginPage;
import com.eaaas.ui.main.PermissionUserPage;
import com.eaaas.utilties.Utility;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PermissionUser {

	public static By Users_Btn_Xpath = By
			.xpath("html/body/qs-app/qs-main/td-layout/md-sidenav-layout/md-content/menu-items/a[5]/div");

	@Given("I click on add user button")
	public void create_new_user() throws InterruptedException {
		// Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		LoginPage.clickOnTeradataMenuIcon();
		Thread.sleep(3000);
		PermissionUserPage.clickOnUserIcon();
		PermissionUserPage.click_on_adduser();
	}

	@Then("I should get add user page")
	public void I_should_be_on_add_user_page() throws InterruptedException {

		PermissionUserPage.on_adduser_page();
	}

	@When("I fill all add user page mandatory details")
	public void I_fill_user_page_form() throws Exception {

		PermissionUserPage.fill_add_user_form();
	}

	@When("I select roles for user")
	public void select_user_role() throws InterruptedException {

		PermissionUserPage.selectRoles();
	}

	@When("I click on save button")
	public void I_click_on_save_button() throws Exception {

		PermissionUserPage.addUserSaveBtn();
	}

	@Then("I Should get user save success message")
	public void I_Should_get_user_save_success_message()
			throws InterruptedException {

		PermissionUserPage.userSaveSuccessMsgBx();
	}

	@Then("I should get users listing page")
	public void I_should_get_users_listing_page() throws InterruptedException {

		PermissionUserPage.usersListPage();
	}

	@Given("I click on delete user button")
	public void I_click_on_delete_user_button() throws Exception {
		// Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		LoginPage.clickOnTeradataMenuIcon();
		Thread.sleep(3000);
		PermissionUserPage.clickOnUserIcon();
		Thread.sleep(3000);
		PermissionUserPage.clickOnDeleteUserBtn();
	}

	@Then("I Should get user delete success message")
	public void I_Should_get_user_delete_success_message() throws Exception {

		PermissionUserPage.userDeleteSuccessMsg();
	}

	@Given("I click on edit user button")
	public void I_click_on_edit_user_button() throws Exception {
		// Thread.sleep(1000);
		LoginPage.loginToEAss(Utility.AdminUsername, Utility.credProp.getProperty(Utility.AdminUsername));
		Thread.sleep(2500);
		LoginPage.clickOnTeradataMenuIcon();
		Thread.sleep(3000);
		PermissionUserPage.clickOnUserIcon();
		Thread.sleep(3000);
		PermissionUserPage.clickOnUserEditBtn();
	}

	@Then("I will edit user details")
	public void Edit_user_form_should_display() throws InterruptedException {

		PermissionUserPage.fillEditUserForm();
	}

	@When("I click on update user button")
	public void I_click_on_update_button() throws InterruptedException {

		PermissionUserPage.clickUpdateBtn();

	}

	@Then("I should get user update successfully message")
	public void I_should_get_user_update_successfully_message()
			throws InterruptedException {

		PermissionUserPage.updateUserSuccessMsg();
	}
}