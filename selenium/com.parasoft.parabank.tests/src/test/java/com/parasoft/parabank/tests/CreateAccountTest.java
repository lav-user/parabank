/**
 * 
 */
package com.parasoft.parabank.tests;

import static com.parasoft.annotations.WorkItem.Type.*;
import static org.junit.Assert.assertEquals;

import com.parasoft.annotations.WorkItem;
import com.parasoft.parabank.tests.page.ParaBankAccountActivityPage;
import com.parasoft.parabank.tests.page.ParaBankAccountsOverviewPage;
import com.parasoft.parabank.tests.page.ParaBankOpenAccountPage;
import com.parasoft.parabank.tests.page.ParaBankWelcomeOnlineBankingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccountTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL2=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL2", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = "http://qa1.parasoft.com:8090/parabank";

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
	 * Name: testCreateAccount
	 * Recording file: testCreateAccount.json
	 *
	 * Parasoft recorded Selenium test on Tue Aug 31 2021 10:26:26 GMT-0700 (Pacific Daylight Time)
	 */
	@Test
	@WorkItem(type = REQ, id = "PAR-220", url = "https://jira-stage.parasoft.com/browse/PAR-220")
	public void testCreateAccount() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/index.htm");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");
		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickOpenNewAccountLink();

		ParaBankOpenAccountPage paraBankOpenAccountPage = new ParaBankOpenAccountPage(driver);
		paraBankOpenAccountPage.clickOpenNewAccountButton();
		paraBankOpenAccountPage.clickLink2();

		ParaBankAccountActivityPage paraBankAccountActivityPage = new ParaBankAccountActivityPage(driver);
		assertEquals("$100.00", paraBankAccountActivityPage.getBalanceFieldText());
		paraBankAccountActivityPage.clickAccountsOverviewLink();
	}

}