package com.eaaas.ui.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;

import com.eaaas.utilties.Utility;

public class PermissionRolePage {

	public static String ROLE_NAME = "TestRole25";
	public static String ROLE_DESC = "Test role created";
	private static String sheetName= "Role";

	public static void click_on_roleicon() throws InterruptedException {
		clickOnPermissionBtn();

		Utility.clickToElement(By.xpath(Utility.prop.getProperty("Roles_icon")));
		System.out.println("done with role icon click");
		Thread.sleep(3000);
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("Roles_title"))).getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop.getProperty("Roles_title")))
						.getText(), "Roles");

	}

	private static void clickOnPermissionBtn() {
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

	public static void click_on_addrole() throws InterruptedException {

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("Add_roles_btn")));
		System.out.println("done with add role button click");
	}

	public static void on_addrole_page() throws InterruptedException {

		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("add_role_page_title")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("add_role_page_title"))).getText(),
				"Create Role");

	}

	public static void fill_add_role_form() throws Exception {
		

		
		Utility.getRowDataOfLastCell(sheetName, "no");
		ROLE_NAME = Utility.data[0];
		ROLE_DESC = Utility.data[1];
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("role_name")),
				ROLE_NAME);

		System.out.println("enter in add rolel form");
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("role_description")),
				ROLE_DESC);
		System.out.println("enter in add rolel form");

	}

	public static void select_roles() throws InterruptedException {
		String[] roles = Utility.data[2].split(",");
		for (int i = 0; i < roles.length; i++) {
			Utility.clickToElement(By.xpath(".//div/span[contains(text(),'"
					+ roles[i] + "')]"));
		}
	}

	public static void add_role_save_btn() throws InterruptedException {
		System.out.println("enter in save role");
		Thread.sleep(1000);
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("add_roles_save_btn")));
		// Thread.sleep(1000);
		System.out.println("out from save role");

	}

	public static void role_save_success_msg_bx() throws Exception {

		System.out.println(Utility.driver
				.findElement(
						By.xpath(Utility.prop
								.getProperty("role_create_success_msg_bx")))
				.getText());
		assertEquals(
				"	zczd	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("role_create_success_msg_bx")))
						.getText(), ROLE_NAME + " added successfully");
		Utility.setCellData(sheetName, Utility.RowNum, Utility.lastCellNum - 1,
				"Yes");
		System.out.println("==========================");

	}

	public static void roles_list_page() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("UUUUUUroleS");
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("Roles_title"))).getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop.getProperty("Roles_title")))
						.getText(), "Roles");
		Thread.sleep(3000);

	}

	public static void click_on_deleterole_btn() throws Exception {

		Utility.getRowDataOfLastCell(sheetName, "yes");
		ROLE_NAME = Utility.data[0];
		Utility.clickToElement(By.xpath(".//h2[contains(text(), '" + ROLE_NAME
				+ "')]/following::span/span[contains(., 'delete')]"));
		System.out.println("done with delete role btn");
		Thread.sleep(2000);
		Utility.driver.switchTo().alert().accept();
	}

	public static void role_delet_success_msg() throws InterruptedException {

		// Thread.sleep(2000);
		System.out.println(Utility.driver
				.findElement(
						By.xpath(Utility.prop
								.getProperty("role_delete_success_msg_bx")))
				.getText());
		assertEquals(
				"		",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("role_delete_success_msg_bx")))
						.getText(), ROLE_NAME + " deleted successfully");
	}

	public static void click_on_edit_btn() throws Exception {

		Utility.getRowDataOfLastCell(sheetName, "yes");
		ROLE_NAME = Utility.data[0];
		Utility.clickToElement(By.xpath(".//h2[contains(text(), '" + ROLE_NAME
				+ "')]/following::span/span[contains(., 'edit')]"));
		System.out.println("done with edit role btn click");
		Thread.sleep(2000);

	}

	public static void fill_edit_role_form() throws InterruptedException {

		String ROLE_DESC1 = "Test role created and edited";
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("role_description")),
				ROLE_DESC1);
		System.out.println("edited role description");

	}

	public static void select_permissions_for_role_edit()
			throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop.getProperty("add_role")));
		Utility.clickToElement(By.xpath(Utility.prop.getProperty("remove_role")));

	}

	public static void click_update_btn() throws InterruptedException {

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("edit_role_update_btn")));
		System.out.println("done with update click");

	}

	public static void update_role_success_msg() throws InterruptedException {

		Thread.sleep(2500);
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop
						.getProperty("edit_roles_update_sucess_msg_bx")))
				.getText());
		System.out.println("enter in edit success msg box");
		assertEquals(
				"		",
				Utility.driver
						.findElement(
								By.xpath(Utility.prop
										.getProperty("edit_roles_update_sucess_msg_bx")))
						.getText(), ROLE_NAME+" updated successfully");
	}
	
	public static void isRoleDeletedFromListing() throws InterruptedException {
		Thread.sleep(2000);
		assertFalse(
				"Fail, Role is not deleted from listing",
				Utility.isElementPresent(By.xpath(".//h2[contains(text(), '"
						+ ROLE_NAME + "')]")));
	}

}
