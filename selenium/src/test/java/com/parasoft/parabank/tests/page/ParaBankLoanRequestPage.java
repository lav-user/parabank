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
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankLoanRequestPage {

	@FindBy(xpath = "//table/tbody/tr[td[1][normalize-space()=\"Loan Amount: $\"]]/td[2]/input")
	private WebElement field;

	@FindBy(xpath = "//table/tbody/tr[td[1][normalize-space()=\"Down Payment: $\"]]/td[2]/input")
	private WebElement field2;

	@FindBy(css = "input[value='Apply Now']")
	private WebElement applyNowButton;

	@FindBy(linkText = "Log Out")
	private WebElement logOutLink;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

	private static final String[] TITLE_WORDS = { "ParaBank", "Loan", "Request" };

	public ParaBankLoanRequestPage(WebDriver driver) {
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

	public void setField(String text) {
		waitUntilClickable(field).clear();
		field.sendKeys(text);
	}

	public void setField2(String text) {
		waitUntilClickable(field2).clear();
		field2.sendKeys(text);
	}

	public void clickApplyNowButton() {
		waitUntilClickable(applyNowButton).click();
	}

	public void clickLogOutLink() {
		waitUntilClickable(logOutLink).click();
	}

}