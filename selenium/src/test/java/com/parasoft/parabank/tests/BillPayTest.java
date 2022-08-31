/**
 * 
 */
package com.parasoft.parabank.tests;

import static com.parasoft.annotations.WorkItem.Type.*;

import com.parasoft.annotations.WorkItem;
import com.parasoft.parabank.tests.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.tests.page.ParaBankBillPayPage;
import com.parasoft.parabank.tests.page.ParaBankBillPaymentCompletePage;
import com.parasoft.parabank.tests.page.ParaBankWelcomeOnlineBankingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BillPayTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DBASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("BASE_URL", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = "http://localhost:8090/parabank";

	private WebDriver driver;

	@Before
	public void beforeTest() {
		ChromeOptions opts = new ChromeOptions(); //needed to run on Appstream VM
		opts.addArguments("--start-maximized");
		opts.addArguments("--disable-geolocation");
		opts.addArguments("--incognito");
		opts.addArguments("--enable-automation");
		opts.addArguments("--headless");
		opts.addArguments("--enable-strict-powerful-feature-restrictions");
		opts.addArguments("--no-sandbox");
		opts.addArguments("--disable-infobars");
		opts.addArguments("--disable-dev-shm-usage");
		opts.addArguments("--disable-browser-side-navigation");
		opts.addArguments("--disable-gpu");
		driver = new ChromeDriver(opts);
	}

	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Name: TestBillPay
	 * Recording file: TestBillPay.json
	 *
	 * Parasoft recorded Selenium test on Mon Aug 23 2021 23:08:24 GMT-0700 (Pacific Daylight Time)
	 */
	@Test
	@WorkItem(type = REQ, id = "PAR-219", url = "https://jira-stage.parasoft.com/browse/PAR-219")
	public void testBillPay() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/index.htm?ConnType=JDBC");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");
		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickBillPayLink();

		ParaBankBillPayPage paraBankBillPayPage = new ParaBankBillPayPage(driver);
		paraBankBillPayPage.setPayeeNameField("Wilhelm");
		paraBankBillPayPage.setPayeeAddressStreetField("1766 Griffith Park Blvd., Unit 1, Unit 1");
		paraBankBillPayPage.setPayeeAddressCityField("Los Angeles");
		paraBankBillPayPage.setPayeeAddressStateField("California");
		paraBankBillPayPage.setPayeeAddressZipCodeField("90026");
		paraBankBillPayPage.setPayeePhoneNumberField("6196661353");
		paraBankBillPayPage.setPayeeAccountNumberField("12345");
		paraBankBillPayPage.setVerifyAccountField("12345");
		paraBankBillPayPage.setAmountField("10");
		paraBankBillPayPage.clickSendPaymentButton();

		ParaBankBillPaymentCompletePage paraBankBillPaymentCompletePage = new ParaBankBillPaymentCompletePage(driver);
		paraBankBillPaymentCompletePage.clickAccountsOverviewLink();
	}

}