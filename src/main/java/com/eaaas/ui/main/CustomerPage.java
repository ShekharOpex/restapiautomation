package com.eaaas.ui.main;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eaaas.utilties.Utility;

public class CustomerPage {

	public static String CUSTOMER_NAME = "Paras2";
	public static String MAIL_ID = "paras.mishra@reancloud.com";
	public static String ACCOUNT_NO = "000";
	public static String CONTACT_NO = "9112345678";
	public static String REGION = "US West (Oregon)";
	public static String ACCESS_KEY = "AKIAJYOVKRKRB5KCEBOQ";
	public static String SECRET_KEY = "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";
	public static String instance_ip = "255.155.45.20";
	public static String ipsec_pass = "Test@123";
	public static String ip_window = "255.155.45.21";
	public static String ip_subnet = "255.155.45.21";
	public static String ip_viewpoint_server = "255.155.45.22";
	public static String ip_add_linux_load_server = "255.155.45.22";
	public static String root_block_size = "366";
	public static String ebs_block_volume_size = "257";
	public static String VPC_CIDR = "10.26.6.0/24";

	// To add new customer
	public static void addCustomer() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("customers_tab_xpath")));
		System.out.println(Utility.driver
				.findElement(
						By.xpath(Utility.prop
								.getProperty("customer_list_title_xpath")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("customer_list_title_xpath")))
						.getText(), "Customer List");

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("Add_customer_button")));
	}

	// To fill customer onboard details
	public static void fill_customer_onboard_form() throws InterruptedException {
		Utility.sendKeys(By.xpath(Utility.prop.getProperty("customer_name")),
				CUSTOMER_NAME);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("customer_mail_id")), MAIL_ID);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("customer_account_no")),
				ACCOUNT_NO);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("customer_contact_no")),
				CONTACT_NO);
		Utility.sendKeys(By.xpath(Utility.prop
				.getProperty("sub_account_aws_access_key")), ACCESS_KEY);
		Utility.sendKeys(By.xpath(Utility.prop
				.getProperty("sub_account_aws_secret_key")), SECRET_KEY);
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("customer_region")));
		Thread.sleep(2000);
		Utility.clickToElement(By
				.xpath(".//span[contains(text(),'US West (Oregon)')]"));
		Utility.sendKeys(By.xpath(Utility.prop
				.getProperty("VPC_CIDR")),VPC_CIDR);
				
				
	}

	/*// To fill CCU details
	public static void fill_CCU_details() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("CCU_add_instance_btn")));
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("CCU_instance1")));
		Utility.sendKeys(By.xpath(Utility.prop.getProperty("CCU_instance_ip")),
				instance_ip);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("CCU_ipsec_tunnel_pass")),
				ipsec_pass);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("CCU_ip_for_window")),
				ip_window);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("CCU_ip_subnet_address")),
				ip_subnet);
		Utility.sendKeys(By.xpath(Utility.prop
				.getProperty("CCU_ip_add_viewpoint_server")),
				ip_viewpoint_server);
		Utility.sendKeys(By.xpath(Utility.prop
				.getProperty("CCU_ip_add_linux_load_server")),
				ip_add_linux_load_server);
	}
*/
	// Click on Submit button.
	public static void click_on_csonboard_submit() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("customer_submit_btn")));
		Thread.sleep(2000);
		System.out.println("done with submit click");
	}

	// verify customer list page is display
	public static void customer_list_page() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(Utility.driver
				.findElement(
						By.xpath(Utility.prop
								.getProperty("customer_list_title_xpath")))
				.getText());
		assertEquals(
				"FAILS if stop executing job pop-up message not received",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("customer_list_title_xpath")))
						.getText(), "Customer List");

	}

	public static void validate_created_customer() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("Teradata_icon_button")));
		Thread.sleep(3000);
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("customers_tab_xpath")));
		// Thread.sleep(7000);
		System.out.println(Utility.driver
				.findElement(
						By.xpath(Utility.prop
								.getProperty("customer_list_title_xpath")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("customer_list_title_xpath")))
						.getText(), "Customer List");

	}

	public static void cust_validate_result() throws InterruptedException {
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("first_row_customer_name")))
				.getText());
		assertEquals(
				"FAILS",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("first_row_customer_name")))
						.getText(), CUSTOMER_NAME);
		Thread.sleep(1200);
	}

	public static void fetch_status_icon() throws InterruptedException {

		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("cust_onboard_status")))
				.getText());

	}

	public static void onboard_status() throws InterruptedException {

		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("cust_onboard_status"))).getText(),
				"Success");
	}

	public static void click_on_deploy_icon() throws InterruptedException {

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("deploy_icon_xpath")));
		Thread.sleep(5000);
	}

	public static void on_deploy_app_page() throws InterruptedException {

		System.out
				.println(Utility.driver.findElement(
						By.xpath(Utility.prop.getProperty("solutions_page")))
						.getText());

		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop.getProperty("solutions_page")))
						.getText(), "Solutions");
		Thread.sleep(4000);
	}

	public static void select_app_for_deployment() throws InterruptedException {
		// Utility.isElementPresent(By.xpath(Utility.prop.getProperty("deploy_lastsolution_from_list")));

		/*
		 * assertEquals(" solution is not available in list",Utility.driver.
		 * findElement
		 * (By.xpath(Utility.prop.getProperty("deploy_lastsolution_from_list")))
		 * .isDisplayed(), true);
		 */

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("deploy_lastsolution_from_list")));
		Thread.sleep(2000);
	}

	public static void input_parameter_page() throws InterruptedException {

		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("input_perameter_page")))
				.getText());

		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("input_perameter_page")))
						.getText(), "Solution Deployment Input Parameters");
	}

	public static void fill_input_perameter() throws InterruptedException {

		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("root_block_volume_size")),
				root_block_size);
		Utility.sendKeys(
				By.xpath(Utility.prop.getProperty("ebs_block_volume_size")),
				ebs_block_volume_size);
	}

	public static void clickon_deploy_solution() throws InterruptedException {

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("deploy_btn_input_perameter_page")));
		Thread.sleep(2000);
	}

	public static void app_deploy_success_msg() throws InterruptedException {

		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop
						.getProperty("solution_deploy_req_sucess_mag")))
				.getText());

		assertEquals(
				"	FAILS if solution deploy request fails",
				Utility.driver
						.findElement(
								By.xpath(Utility.prop
										.getProperty("solution_deploy_req_sucess_mag")))
						.getText(),
				"Solution deploy request submitted successfully.");

	}

	public static void click_on_action_menu_btn() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("action_menu_btn")));

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("action_deploy_solution")));
		// Thread.sleep(7000);
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("cust_solution_list_title")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("cust_solution_list_title")))
						.getText(), "Solution List");

	}

	public static void check_sol_deploy_status() throws InterruptedException {
		// The int here is the maximum time in seconds the element can wait.
		WebDriverWait wait = new WebDriverWait(Utility.driver, 1800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(Utility.prop.getProperty("solution_deploy_status_icon"))));
		System.out
				.println(Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("solution_deploy_status_icon")))
						.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("solution_deploy_status_icon")))
						.getText(), "Success");

	}

	public static void click_on_edit_cust() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("action_menu_btn")));

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("edit_customer_details")));

		// Thread.sleep(7000);
		System.out.println(Utility.driver
				.findElement(
						By.xpath(Utility.prop
								.getProperty("cust_contact_details_page")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver.findElement(
						By.xpath(Utility.prop
								.getProperty("cust_contact_details_page")))
						.getText(), "Contact Details");

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("contact_details_edit_btn")));

		Utility.sendKeys(By.xpath(Utility.prop.getProperty("edit_mail_id")),
				"edit_mail@rio.com");

	}

	public static void check_ccu_details() throws InterruptedException {
		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("action_menu_btn")));

		Utility.clickToElement(By.xpath(Utility.prop
				.getProperty("edit_CCU_details")));

	}

	public static void ccu_details_page() throws InterruptedException {
		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop.getProperty("ccu_details_title")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver
						.findElement(
								By.xpath(Utility.prop
										.getProperty("ccu_details_title")))
						.getText(), "CCU Details");

	}

	public static void edit_cust_success_msg() throws InterruptedException {

		System.out.println(Utility.driver.findElement(
				By.xpath(Utility.prop
						.getProperty("cust_details_update_success_masg")))
				.getText());
		assertEquals(
				"	FAILS if stop executing job pop-up message not received	",
				Utility.driver
						.findElement(
								By.xpath(Utility.prop
										.getProperty("cust_details_update_success_masg")))
						.getText(), "Updated customer successfully!");

	}

}