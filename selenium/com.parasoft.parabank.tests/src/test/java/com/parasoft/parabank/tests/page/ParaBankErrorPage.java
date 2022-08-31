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

public class ParaBankErrorPage {

	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(css = "input[value='Log In']")
	private WebElement logInButton;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

	private static final String[] TITLE_WORDS = { "ParaBank", "Error" };

	public ParaBankErrorPage(WebDriver driver) {
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

	public void setUsernameField(String text) {
		waitUntilClickable(usernameField).clear();
		usernameField.sendKeys(text);
	}

	public void setPasswordField(String text) {
		waitUntilClickable(passwordField).clear();
		passwordField.sendKeys(text);
	}

	public void clickLogInButton() {
		waitUntilClickable(logInButton).click();
	}

}