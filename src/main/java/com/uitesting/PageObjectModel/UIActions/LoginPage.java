package com.uitesting.PageObjectModel.UIActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	// Define all the webElement of the Login Page
	// Using Encapsulation and Abstraction
	@FindBy(id = "email")
	private WebElement userName;

	public WebElement getuserName() {
		return userName;
	}

	@FindBy(id = "pass")
	private WebElement password;

	public WebElement getpassword() {
		return password;
	}

	@FindBy(xpath = "// input[contains(@value,'Log In')]")
	private WebElement loginButton;

	public WebElement getloginButton() {
		return loginButton;
	}

	public static LoginPage getLoginPage(WebDriver driver) {

		return PageFactory.initElements(driver, LoginPage.class);

	}
}
