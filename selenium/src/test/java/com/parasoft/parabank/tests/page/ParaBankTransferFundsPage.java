/**
 * 
 */
package com.parasoft.parabank.tests.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankTransferFundsPage {

	@FindBy(name = "input")
	private WebElement inputField;

	@FindBy(tagName = "FORM")
	private WebElement fORM;

	@FindBy(css = "select[id='fromAccountId']")
	private WebElement fromAccountIdDropdown;

	@FindBy(className = "ng-untouched")
	private WebElement ngUntouchedDropdown;

	@FindBy(css = "input[value='Transfer']")
	private WebElement transferButton;

	@FindBy(linkText = "Accounts Overview")
	private WebElement accountsOverviewLink;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

	private static final String[] TITLE_WORDS = { "ParaBank", "Transfer", "Funds" };

	public ParaBankTransferFundsPage(WebDriver driver) {
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

	public void setInputField(String text) {
		waitUntilClickable(inputField).clear();
		inputField.sendKeys(text);
	}

	public void clickFORM() {
		waitUntilClickable(fORM).click();
	}

	public void selectFromAccountIdDropdown(String text) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.until(
				webdriver -> new Select(fromAccountIdDropdown).getFirstSelectedOption().getText().trim().length() > 0);
		Select dropdown = new Select(fromAccountIdDropdown);
		dropdown.selectByVisibleText(text);
	}

	public void selectNgUntouchedDropdown(String text) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.until(webdriver -> new Select(ngUntouchedDropdown).getFirstSelectedOption().getText().trim().length() > 0);
		Select dropdown = new Select(ngUntouchedDropdown);
		dropdown.selectByVisibleText(text);
	}

	public void clickTransferButton() {
		waitUntilClickable(transferButton).click();
	}

	public void clickAccountsOverviewLink() {
		waitUntilClickable(accountsOverviewLink).click();
	}

}