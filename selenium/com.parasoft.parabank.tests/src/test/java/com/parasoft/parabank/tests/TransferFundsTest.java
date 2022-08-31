/**
 * 
 */
package com.parasoft.parabank.tests;

import com.parasoft.annotations.WorkItem;
import com.parasoft.parabank.tests.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.tests.page.ParaBankErrorPage;
import com.parasoft.parabank.tests.page.ParaBankTransferFundsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TransferFundsTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANKV2_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANKV2_BASE_URL", "http://localhost:8080") to change base URL at run time.
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
	 * Name: Parabank_Transfer_Funds
	 *
	 * Parasoft recorded Selenium test on Tue Nov 19 2019 06:21:36 GMT-0800 (Pacific Standard Time)
	 */
	@WorkItem(type=WorkItem.Type.REQ, id="PAR-221", url="https://jira-stage.parasoft.com/browse/PAR-221")
	@Test
	public void testParabank_Transfer_Funds() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/requestloan.htm");

		ParaBankErrorPage paraBankErrorPage = new ParaBankErrorPage(driver);
		paraBankErrorPage.setUsernameField("john");

		paraBankErrorPage.setPasswordField("demo");

		paraBankErrorPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickTransferFundsLink();

		ParaBankTransferFundsPage paraBankTransferFundsPage = new ParaBankTransferFundsPage(driver);
		paraBankTransferFundsPage.setInputField("1");

		paraBankTransferFundsPage.clickFORM();

		paraBankTransferFundsPage.clickFORM();

		paraBankTransferFundsPage.selectFromAccountIdDropdown("12900");

		paraBankTransferFundsPage.selectNgUntouchedDropdown("13233");

		paraBankTransferFundsPage.clickTransferButton();

		paraBankTransferFundsPage.clickAccountsOverviewLink();

	}

}