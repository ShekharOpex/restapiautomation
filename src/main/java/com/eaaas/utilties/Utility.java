package com.eaaas.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eaaas.reporting.UPAReporter;

public class Utility {

	public static WebDriver driver;
	public static Select selectvalue;
	public static readXLS testAPIExcel = null;
	public static restExecutor executor = new restExecutor(null);
	public static String strContentType = "application/json";
	public static String defaultSheetName = "APIList";
	public static restValidator strResponse = null;
	public static Properties prop, credProp = null;
	public static FileInputStream objFile, credFile = null;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static String XlsFilePath = "src/test/resources/TestData.xlsx";
	public static String[] data = null;
	public static int RowNum, lastCellNum;
	public static String AdminUsername = "milind";

	public static void setup() throws Exception {
		System.out.println("Setting up Pre-Reqs");
		System.out.println("-------------- in IF ---------------");
		if (driver == null) {

			objFile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/object.properties");
			System.out.println("start reading file");
			prop = new Properties();
			System.out.println("enter in prop");
			prop.load(objFile);
			
			credFile = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/UserCredentials.properties");
			credProp = new Properties();
			credProp.load(credFile);

			String browser = System.getenv("BROWSER");
			if (browser == null) {
				browser = "firefox";
			}
			System.out.println("Browser selected is " + browser);
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				driver.manage().timeouts()
						.pageLoadTimeout(60, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts()
						.setScriptTimeout(60, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("device")) {
				String deviceName = System.getenv("VERSION");
				deviceName = deviceName.replace("_", " ");
				Map<String, String> mobileEmulation = new HashMap<String, String>();
				mobileEmulation.put("deviceName", deviceName);

				Map<String, Object> chromeOptions = new HashMap<String, Object>();
				chromeOptions.put("mobileEmulation", mobileEmulation);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY,
						chromeOptions);
				driver = new ChromeDriver(capabilities);
				driver.manage().timeouts()
						.pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts()
						.setScriptTimeout(60, TimeUnit.SECONDS);

			} else if (browser.equalsIgnoreCase("ie")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setJavascriptEnabled(true);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new RemoteWebDriver(
						new URL(
								"http://dev-vpc-967400985.us-east-1.elb.amazonaws.com/"),
						cap);
				driver.manage().timeouts()
						.pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts()
						.setScriptTimeout(60, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("opera")) {
				DesiredCapabilities cap = DesiredCapabilities.operaBlink();
				cap.setBrowserName("opera");
				OperaOptions options = new OperaOptions();
				options.setBinary("/usr/bin/opera");
				options.addArguments("--ignore-certificate-errors");
				cap.setCapability(OperaOptions.CAPABILITY, options);
				OperaDriverService service = new OperaDriverService.Builder()
						.usingDriverExecutable(
								new File("/usr/local/bin/operadriver"))
						.usingAnyFreePort().build();
				service.start();
				driver = new RemoteWebDriver(service.getUrl(), cap);
				driver.manage().timeouts()
						.pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts()
						.setScriptTimeout(60, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("android")) {
				driver = new RemoteWebDriver(DesiredCapabilities.android());
			} else {
				FirefoxProfile profile = new FirefoxProfile();
				/*
				 * if (System.getenv("IS_UPA").equalsIgnoreCase("true")) { File
				 * netexport = new File(
				 * "/home/vagrant/testNow/TestNow/testnowjavaexample/src/test/resources/har/netExport-0.8.xpi"
				 * ); File firebug = new File(
				 * "/home/vagrant/testNow/TestNow/testnowjavaexample/src/test/resources/har/firebug-2.0.13.xpi"
				 * ); profile.addExtension(netexport);
				 * profile.addExtension(firebug);
				 * profile.setPreference("app.update.enabled", false); String
				 * domain = "extensions.firebug."; profile.setPreference(domain
				 * + "currentVersion", "2.0.13"); profile.setPreference(domain +
				 * "allPagesActivation", "on"); profile.setPreference(domain +
				 * "defaultPanelName", "net"); profile.setPreference(domain +
				 * "net.enableSites", true); profile.setPreference(domain +
				 * "netexport.alwaysEnableAutoExport", true);
				 * profile.setPreference(domain + "netexport.showPreview",
				 * false); File harFolder = new
				 * File(System.getProperty("user.dir") +
				 * "/target/reports/har/"); profile.setPreference(domain +
				 * "netexport.defaultLogDir", harFolder.getAbsolutePath()); }
				 */
				driver = new FirefoxDriver(profile);
				driver.manage().timeouts()
						.pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts()
						.setScriptTimeout(60, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				UPAReporter reporter = new UPAReporter();
			}
			// driver.get("http://dev-vpc-967400985.us-east-1.elb.amazonaws.com/");
			if (System.getenv("TEST_URL") != null) {
				driver.get(System.getenv("TEST_URL"));
				System.out.println("Parameters used:");
				if (System.getenv("API_PORT") != null) {
					System.out.println("API Port" + System.getenv("API_PORT"));
					System.out.println("API Port" + System.getenv("TEST_URL"));
					executor = new restExecutor(System.getenv("TEST_URL") + ":"
							+ System.getenv("API_PORT"));
				} else {
					System.out
							.println("Blank Port. You may face issues with the API Testcases");
				}
				testAPIExcel = new readXLS(
						System.getProperty("user.dir")
								+ "/src/main/java/com/eaaas/excel/Intelliflex_API_Data.xls");
				System.out.println("testAPIExcel:" + testAPIExcel);
			} else {
				System.out.println("No TEST_URL parameter found");
				System.exit(1);
			}
		}
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void sendKeys(By locator, String string) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(string);
	}

	public static void clickToElement(By string) {
		driver.findElement(string).click();
	}

	public static Boolean isElementPresent(By locator) {

		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void waitForElementBecomeVisible(By locator, int time) {
		WebDriverWait wait = new WebDriverWait(Utility.driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/*
	 * public static Boolean findelement(By locator) { return
	 * driver.findElement(locator).isDisplayed(); }
	 */
	public static void GetfieldTextLength(By locator) {

		WebElement element = driver.findElement(locator);
		element.getText().length();
		System.out.println(element);
	}

	public static String GetfieldText(By locator) {

		WebElement element = driver.findElement(locator);
		return element.getText();
	}

	/*
	 * get Authentication token
	 */
	public static String getAuthCode() {
		Integer strTestID = testAPIExcel.retrieveRowNo(defaultSheetName,
				"User Login");
		String strURL = testAPIExcel.retrieveCell(defaultSheetName, "URL",
				strTestID);
		String strBody = testAPIExcel.retrieveCell(defaultSheetName, "Body",
				strTestID);
		System.out.println("URL:" + strURL);
		strResponse = executor.post(strURL, strBody, strContentType)
				.expectCode(200).expectInBody("authToken").expectInBody("name");
		String AUthCode = strResponse.getResponse().getResponseBody();
		if (AUthCode.isEmpty()) {
			System.exit(0);
		}
		String processAuth = AUthCode.substring(AUthCode.indexOf(":\"") + 2,
				AUthCode.lastIndexOf("\",\"name"));
		System.out.println("Auth Token returned-->" + processAuth);
		return processAuth;

	}

	// Select DropDown option using its visible text
	public static void selectDropDownOption(By locator, String value) {
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(value);
	}

	// This method is to set the File path and to open the Excel file,
	// Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String sheetName) throws Exception {

		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(XlsFilePath);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);

		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell,
	// in this we are passing parameters as Row num and Col num

	public static String getCellData(String sheetName, int RowNum, int ColNum)
			throws Exception {

		setExcelFile(sheetName);
		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	// This method is to write in the Excel cell,
	// Row num and Col num are the parameters

	public static void setCellData(String sheetName, int RowNum, int ColNum,
			String Result) throws Exception {
		setExcelFile(sheetName);
		try {

			Row = ExcelWSheet.getRow(RowNum);
			XSSFCell Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}

			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(XlsFilePath);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			throw (e);
		}
	}

	public static int findCellIndexOfString(String sheetName, String text)
			throws Exception {
		setExcelFile(sheetName);
		int i;
		int rowCount = ExcelWSheet.getLastRowNum()
				- ExcelWSheet.getFirstRowNum();

		for (i = 1; i < rowCount; i++) {
			XSSFRow row = ExcelWSheet.getRow(i);
			Cell = row.getCell(row.getLastCellNum() - 1);
			String CellData = Cell.getStringCellValue();
			if (CellData.equalsIgnoreCase(text)) {
				break;
			}
		}

		return i;
	}

	public static void getRowDataOfLastCell(String sheetName, String text)
			throws Exception {
		if (text.equalsIgnoreCase("yes"))
			RowNum = findCellIndexOfString(sheetName, "no") - 1;
		else
			RowNum = findCellIndexOfString(sheetName, text);
		lastCellNum = ExcelWSheet.getRow(RowNum).getLastCellNum();
		data = new String[lastCellNum];
		for (int i = 0; i < lastCellNum; i++) {
			System.out.println(getCellData(sheetName, RowNum, i));
			data[i] = getCellData(sheetName, RowNum, i);
		}
	}
}