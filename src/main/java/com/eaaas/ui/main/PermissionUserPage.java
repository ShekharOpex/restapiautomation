package com.eaaas.ui.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.eaaas.utilties.Utility;

public class PermissionUserPage {

	public static String FIRST_NAME, LAST_NAME, USER_NAME, PWD;
	public static String EMAIL_ID = "Test@gmail.com";
	public static String PASSWORD = "Test@123";
	public static String CONFIRM_PASSWORD = "Test@123";
	public static String EDIT_FIRST_NAME = "TestName";
	public static String EDIT_LAST_NAME = "TestLastName";
	private static String sheetName = "User";

	public static void clickOnUserIcon() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("permissions_tab_xpath")));

		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("permission_page_heading")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("permission_page_heading")))
						.getText(), "Permissions");

	}

	public static void click_on_adduser() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop.getProperty("users_icon")));
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("users_heading_title")))
				.getText());
		assertEquals(
				"FAILS if stop executing job pop-up message not received",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("users_heading_title"))).getText(),
				"Users");
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("add_user_btn")));
		System.out.println("done with add user button click");
	}

	public static void on_adduser_page() throws InterruptedException {

		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("add_user_page_title")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("add_user_page_title"))).getText(),
				"Add User");

	}

	public static void fill_add_user_form() throws Exception {
		Utility.getRowDataOfLastCell(sheetName, "NO");
		FIRST_NAME = Utility.data[0];
		LAST_NAME = Utility.data[1];
		USER_NAME = Utility.data[2];
		PWD = Utility.data[4];

		Utility.sendKeys(By.xpath(Utility.prop.getProperty("first_Name_text_box")),
				FIRST_NAME);
		Utility.sendKeys(By.xpath(Utility.prop.getProperty("last_Name_text_box")),
				LAST_NAME);
		Utility.sendKeys(By.xpath(Utility.prop.getProperty("user_Name_text_box")),
				USER_NAME);
		Utility.sendKeys(By.xpath(Utility.prop.getProperty("mail_id_text_box")),
				EMAIL_ID);
		Utility.sendKeys(By.xpath(Utility.prop.getProperty("password_text_box")),
				PASSWORD);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("confirm_password_text_box")),
				CONFIRM_PASSWORD);

	}

//	public static void selectRoles() throws InterruptedException {
//		if (!Utility.data[5].isEmpty()) {
//			String[] Roles = Utility.data[5].split(",");
//
//			for (int i = 0; i < Roles.length; i++) {
//				System.out.println(Roles[i].trim());
//				Utility.clickToElement(By
//						.xpath(".//span[contains(@class,'md-slide-toggle-content')][contains(.,'"
//								+ Roles[i] + "')]"));
//			}
//		}
//	}

//	public static void addUserSaveBtn() throws Exception {
//		System.out.println("enter in save user");
//		Thread.sleep(5000);
//		Utility.clickToElement(By.xpath(Utility.prop
//				.getProperty("add_users_save_btn")));
//		Thread.sleep(3000);
//		System.out.println("out from save user");
//		Utility.setCellData(sheetName, Utility.RowNum, Utility.lastCellNum - 1,
//				"Yes");
//	}

//	public static void userSaveSuccessMsgBx() throws InterruptedException {
//
//		// Thread.sleep(2000);
//		System.out.println(Utility.driver.findElement(
//				By.xpath(Utility.prop
//						.getProperty("user_save_success_popup_msg_bx")))
//				.getText());
//		assertEquals(
//				"		",
//				Utility.driver
//						.findElement(
//								By.xpath(Utility.prop
//										.getProperty("user_save_success_popup_msg_bx")))
//						.getText(), USER_NAME + " added successfully");
//
//	}

//	public static void usersListPage() throws InterruptedException {
//		Thread.sleep(3000);
//		System.out.println("UUUUUUUSERS");
//		System.out.println(Utility.driver.findElement(
//				By.xpath(Utility.prop.getProperty("users_heading_title")))
//				.getText());
//		assertEquals(
//				"	FAILS if stop executing job pop-up message not received	",
//				Utility.driver.findElement(
//						By.xpath(Utility.prop
//								.getProperty("users_heading_title"))).getText(),
//				"Users");
//		Thread.sleep(3000);
//
//	}

//	public static void clickOnDeleteUserBtn() throws Exception {
//		Utility.getRowDataOfLastCell(sheetName, "yes");
//		USER_NAME = Utility.data[2];
//
//		Utility.clickToElement(By.xpath(Utility.prop
//				.getProperty("user_delete_btn")));
//		System.out.println("done with delete user btn");
//		Thread.sleep(2000);
//		Utility.driver.switchTo().alert().accept();
//	}

//	public static void userDeleteSuccessMsg() throws Exception {
//
//		Thread.sleep(1000);
//		System.out.println(Utility.driver.findElement(
//				By.xpath(Utility.prop
//						.getProperty("user_delete_sucess_popup_msg_bx")))
//				.getText());
//		assertEquals(
//				"		",
//				Utility.driver
//						.findElement(
//								By.xpath(Utility.prop
//										.getProperty("user_delete_sucess_popup_msg_bx")))
//						.getText(), USER_NAME + " deleted successfully");
//		Utility.setCellData(sheetName, Utility.RowNum, Utility.lastCellNum - 1,
//				"No");
//	}

//	public static void clickOnUserEditBtn() throws Exception {
//		Utility.getRowDataOfLastCell(sheetName, "yes");
//		FIRST_NAME = Utility.data[0];
//		LAST_NAME = Utility.data[1];
//		USER_NAME = Utility.data[2];
//		Utility.clickToElement(By.xpath(Utility.prop
//				.getProperty("user_edit_btn")));
//		System.out.println("done with edit user btn click");
//		Thread.sleep(2000);
//
//	}

	
	public static void select_permissions_for_user_edit()
			throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop.getProperty("new_role")));

	}

//	public static void updateUserSuccessMsg() throws InterruptedException {
//
//		// Thread.sleep(2000);
//		System.out.println(Utility.driver.findElement(
//				By.xpath(Utility.prop
//						.getProperty("edit_user_update_sucess_msg_bx")))
//				.getText());
//		assertEquals(
//				"		",
//				Utility.driver
//						.findElement(
//								By.xpath(Utility.prop
//										.getProperty("edit_user_update_sucess_msg_bx")))
//						.getText(), USER_NAME+" updated successfully");
//	}

	public static void clickOnPermissionBtn() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("permissions_tab_xpath")));
		Utility.waitForElementBecomeVisible(
				By.xpath(Utility.prop.getProperty("permission_page_heading")),
				10000);
	}

	public static void clickOnUsersBtn() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("users_option")));
	}

	public static void clickOnRolesBtn() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("roles_option")));
	}

	public static void clickOnAddUserBtn() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("add_user_btn")));
		Utility.waitForElementBecomeVisible(
				By.xpath(Utility.prop.getProperty("add_user_page_title")),
				10000);
	}

	public static void onAddUserPage() throws InterruptedException {

		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("add_user_page_title")))
				.getText());
		assertEquals(
				"FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("add_user_page_title"))).getText(),
				"Add User");
	}

	public static void fillAddUserForm() throws Exception {
		Utility.getRowDataOfLastCell(sheetName, "NO");
		FIRST_NAME = Utility.data[0];
		LAST_NAME = Utility.data[1];
		USER_NAME = Utility.data[2];
		PWD = Utility.data[4];

		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("first_Name_text_box")),
				FIRST_NAME);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("last_Name_text_box")),
				LAST_NAME);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("user_Name_text_box")),
				USER_NAME);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("mail_id_text_box")),
				Utility.data[3]);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("password_text_box")),
				Utility.data[4]);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("confirm_password_text_box")),
				Utility.data[4]);
	}

	public static void selectRoles() throws InterruptedException {

		if (!Utility.data[5].isEmpty()) {
			String[] Roles = Utility.data[5].split(",");

			for (int i = 0; i < Roles.length; i++) {
				System.out.println(Roles[i].trim());
				Utility.clickToElement(By
						.xpath(".//span[contains(@class,'md-slide-toggle-content')][contains(.,'"
								+ Roles[i] + "')]"));
			}
		}
	}

	public static void addUserSaveBtn() throws Exception {
		System.out.println("enter in save user");
		Thread.sleep(5000);
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("add_users_save_btn")));
		Thread.sleep(3000);
		System.out.println("out from save user");
		Utility.setCellData(sheetName, Utility.RowNum, Utility.lastCellNum - 1,
				"Yes");
	}

	public static void userSaveSuccessMsgBx() throws InterruptedException {

		// Thread.sleep(2000);
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop
						.getProperty("user_save_success_popup_msg_bx")))
				.getText());
		assertEquals(
				"		",
				Utility.driver
						.findElement(
								By.xpath(Utility.prop
										.getProperty("user_save_success_popup_msg_bx")))
						.getText(), USER_NAME + " added successfully");

	}

	public static void usersListPage() throws InterruptedException {
		Utility.waitForElementBecomeVisible(
				By.xpath(Utility.prop.getProperty("users_title")), 10);
		assertEquals(
				"FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop.getProperty("users_title")))
						.getText(), "Users");
	}

	public static void clickOnDeleteUserBtn() throws Exception {
		Utility.getRowDataOfLastCell(sheetName, "yes");
		USER_NAME = Utility.data[2];
		Utility.clickToElement(By
				.xpath(".//div/h3[contains(., '"
						+ EDIT_FIRST_NAME
						+ " "
						+ EDIT_LAST_NAME
						+ "')]/following-sibling::p[contains(text(), 'User Name : "
						+ USER_NAME
						+ "')]/following::span/span[contains(., 'delete')]"));
		System.out.println("done with delete user btn");
		Thread.sleep(2000);
		Utility.driver.switchTo().alert().accept();
	}

	public static void userDeleteSuccessMsg() throws Exception {

		Thread.sleep(1000);
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop
						.getProperty("user_delete_sucess_popup_msg_bx")))
				.getText());
		assertEquals(
				"		",
				Utility.driver
						.findElement(
								By.xpath(Utility.prop
										.getProperty("user_delete_sucess_popup_msg_bx")))
						.getText(), USER_NAME + " deleted successfully");
		Utility.setCellData(sheetName, Utility.RowNum, Utility.lastCellNum - 1,
				"No");
	}

	public static void clickOnUserEditBtn() throws Exception {
		Utility.getRowDataOfLastCell(sheetName, "yes");
		FIRST_NAME = Utility.data[0];
		LAST_NAME = Utility.data[1];
		USER_NAME = Utility.data[2];
		Utility.clickToElement(By.xpath(".//div/h3[contains(., '" + FIRST_NAME
				+ " " + LAST_NAME
				+ "')]/following-sibling::p[contains(text(), 'User Name : "
				+ USER_NAME + "')]/following::span/span[contains(., 'edit')]"));
		System.out.println("done with edit user btn click");
		Thread.sleep(2000);

	}

	public static void fillEditUserForm() throws InterruptedException {

		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("first_Name_text_box")),
				EDIT_FIRST_NAME);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("last_Name_text_box")),
				EDIT_LAST_NAME);
		System.out.println("edited user description");

	}

	public static void selectPermissionsForUserEdit()
			throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop.getProperty("new_role")));

	}

	public static void clickUpdateBtn() throws InterruptedException {

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("edit_user_update_btn")));

	}

	public static void updateUserSuccessMsg() throws InterruptedException {

		// Thread.sleep(2000);
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop
						.getProperty("edit_user_update_sucess_msg_bx")))
				.getText());
		assertEquals(
				"		",
				Utility.driver
						.findElement(
								By.xpath(Utility.prop
										.getProperty("edit_user_update_sucess_msg_bx")))
						.getText(), USER_NAME + " updated successfully");
	}

	public static void isUserInList() throws InterruptedException {
		PermissionUserPage.clickOnRolesBtn();
		PermissionUserPage.clickOnUsersBtn();
		Thread.sleep(2000);
		assertTrue(
				"Fail, User is not present in list",
				Utility.isElementPresent(By
						.xpath(".//div/h3[contains(., '"
								+ FIRST_NAME
								+ " "
								+ LAST_NAME
								+ "')]/following-sibling::p[contains(text(), 'User Name : "
								+ USER_NAME + "')]")));
	}

	public static void isUserDeletedFromListing() {
		assertFalse(
				"Fail, User is not deleted from listing",
				Utility.isElementPresent(By
						.xpath(".//div/h3[contains(., '"
								+ FIRST_NAME
								+ " "
								+ LAST_NAME
								+ "')]/following-sibling::p[contains(text(), 'User Name : "
								+ USER_NAME + "')]")));
	}

	public static void createUser() throws Exception {
		// Tdrivpage.tdriveToolbarPage();
		clickOnPermissionBtn();
		clickOnUsersBtn();
		clickOnAddUserBtn();
		onAddUserPage();
		fillAddUserForm();
		selectRoles();
		addUserSaveBtn();
		userSaveSuccessMsgBx();
		usersListPage();
	}

}
