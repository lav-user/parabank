/**
 * 
 */
package com.parasoft.parabank.tests.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankBillPayPage {

	@FindBy(xpath = "/descendant::td[normalize-space(.)='Account #:']")
	private WebElement account;

	@FindBy(xpath = "/descendant::tr[normalize-space(.)='Account #: Account number is required. Please enter a valid number.']")
	private WebElement accountAccountNumberIsRequiredPleaseEnterAValidNumber;

	@FindBy(className = "form2")
	private WebElement form;

	@FindBy(xpath = "//table/tbody/tr[12]/td[1]")
	private WebElement webElement;

	@FindBy(name = "fromAccountId")
	private WebElement fromAccountIdDropdown;

	@FindBy(name = "payee.name")
	private WebElement payeeNameField;

	@FindBy(name = "payee.address.street")
	private WebElement payeeAddressStreetField;

	@FindBy(name = "payee.address.city")
	private WebElement payeeAddressCityField;

	@FindBy(name = "payee.address.state")
	private WebElement payeeAddressStateField;

	@FindBy(name = "payee.address.zipCode")
	private WebElement payeeAddressZipCodeField;

	@FindBy(name = "payee.phoneNumber")
	private WebElement payeePhoneNumberField;

	@FindBy(name = "payee.accountNumber")
	private WebElement payeeAccountNumberField;

	@FindBy(name = "verifyAccount")
	private WebElement verifyAccountField;

	@FindBy(name = "amount")
	private WebElement amountField;

	@FindBy(css = "input[value='Send Payment']")
	private WebElement sendPaymentButton;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

	private static final String[] TITLE_WORDS = { "ParaBank", "Bill", "Pay" };

	public ParaBankBillPayPage(WebDriver driver) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		Arrays.stream(TITLE_WORDS).forEach(word -> {
			wait.until(attributeContains(By.tagName("title"), "innerHTML", word));
		});
		PageFactory.initElements(driver, this);
	}

	private WebElement waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		return wait.until(elementToBeClickable(element));
	}

	public void setPayeeNameField(String text) {
		waitUntilClickable(payeeNameField).clear();
		payeeNameField.sendKeys(text);
	}

	public void setPayeeAddressStreetField(String text) {
		waitUntilClickable(payeeAddressStreetField).clear();
		payeeAddressStreetField.sendKeys(text);
	}

	public void setPayeeAddressCityField(String text) {
		waitUntilClickable(payeeAddressCityField).clear();
		payeeAddressCityField.sendKeys(text);
	}

	public void setPayeeAddressStateField(String text) {
		waitUntilClickable(payeeAddressStateField).clear();
		payeeAddressStateField.sendKeys(text);
	}

	public void setPayeeAddressZipCodeField(String text) {
		waitUntilClickable(payeeAddressZipCodeField).clear();
		payeeAddressZipCodeField.sendKeys(text);
	}

	public void setPayeePhoneNumberField(String text) {
		waitUntilClickable(payeePhoneNumberField).clear();
		payeePhoneNumberField.sendKeys(text);
	}

	public void setPayeeAccountNumberField(String text) {
		waitUntilClickable(payeeAccountNumberField).clear();
		payeeAccountNumberField.sendKeys(text);
	}

	public void setVerifyAccountField(String text) {
		waitUntilClickable(verifyAccountField).clear();
		verifyAccountField.sendKeys(text);
	}

	public void setAmountField(String text) {
		waitUntilClickable(amountField).clear();
		amountField.sendKeys(text);
	}

	public void clickSendPaymentButton() {
		waitUntilClickable(sendPaymentButton).click();
	}

	public void clickWebElement() {
		click(webElement);
	}

	public void selectFromAccountIdDropdown(String text) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(
				webdriver -> new Select(fromAccountIdDropdown).getFirstSelectedOption().getText().trim().length() > 0);
		Select dropdown = new Select(fromAccountIdDropdown);
		dropdown.selectByVisibleText(text);
	}

	private WebElement waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		return wait.until(elementToBeClickable(element));
	}

	private WebElement scrollTo(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
		return element;
	}

	protected WebElement click(WebElement element) {
		WebElement webElement = scrollTo(waitFor(element));
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		return wait.ignoring(ElementClickInterceptedException.class).until(webDriver -> {
			webElement.click();
			return webElement;
		});
	}

	public void clickAccount() {
		click(account);
	}

	public void clickAccountAccountNumberIsRequiredPleaseEnterAValidNumber() {
		click(accountAccountNumberIsRequiredPleaseEnterAValidNumber);
	}

	public void clickForm() {
		click(form);
	}

}