/**
 * 
 */
package com.parasoft.parabank.tests;

import com.parasoft.parabank.tests.page.ParaBankWelcomeOnlineBankingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ADummyTest {

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
		driver = new ChromeDriver(opts); //initialize ChromeDriver with ChromeOptions setting
	}

	@After
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Name: parabank_billPay
	 * Description: Test billPay on gamora:8091
	 *
	 * Parasoft recorded Selenium test on Thu Aug 08 2019 11:38:54 GMT-0700 (Pacific Daylight Time)
	 */
	@Test
	public void testDummy() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL)
				+ "/index.htm");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
	}

}
