package com.uitesting.PageObjectModel.Module.LoginPage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uitesting.PageObjectModel.TestBase.Utility;
import com.uitesting.PageObjectModel.UIActions.LoginPage;

//Use of Inheritance
public class LoginTest extends Utility {

	@BeforeTest
	public void setUpBrwoser() throws IOException {

		Utility.getDriver(Utility.getProperty("browserName"),
				Utility.getProperty("url"));

	}

	@Test
	public void TCC01_LoginWithValidCredentials()
			throws IOException {
		System.out.println("Inside Test Method");
		LoginPage object = LoginPage.getLoginPage(driver);

		WebElement name = object.getuserName();
		System.out.println(name);
		name.sendKeys(Utility.getProperty("userName"));
		WebElement pass = object.getpassword();
		pass.sendKeys(Utility.getProperty("password"));
		WebElement login = object.getloginButton();
		login.click();

	}
}
