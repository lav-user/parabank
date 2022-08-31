/**
 * 
 */
package com.parasoft.parabank.tests;

import com.parasoft.annotations.WorkItem;
import com.parasoft.parabank.tests.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.tests.page.ParaBankLoanRequestPage;
import com.parasoft.parabank.tests.page.ParaBankWelcomeOnlineBankingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLoanRequest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL", "http://localhost:8080") to change base URL at run time.
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
	 * Name: TestLoanRequest
	 * Description: Testing request loan on gamora:8091
	 * @pr PAR-222
	 *
	 * Parasoft recorded Selenium test on Mon Oct 14 2019 14:56:59 GMT-0700 (Pacific Daylight Time)
	 */
	@WorkItem(type=WorkItem.Type.REQ, id="PAR-222", url="https://jira-stage.parasoft.com/browse/PAR-222")
	@Test
	public void testLoanRequest() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL)
				+ "/index.htm;jsessionid=D10E26D4A5732F5A0369D4BA6140F2DC");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");

		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");

		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickRequestLoanLink();

		ParaBankLoanRequestPage paraBankLoanRequestPage = new ParaBankLoanRequestPage(driver);
		paraBankLoanRequestPage.setField("1000");

		paraBankLoanRequestPage.setField2("100");

		paraBankLoanRequestPage.clickApplyNowButton();

		paraBankLoanRequestPage.clickLogOutLink();

	}

}