package com.uitesting.PageObjectModel.TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {

	public static WebDriver driver;
	public static Properties pobject;

	public static void getDriver(String browserName, String URL) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

	}

	public static void loadProperties() throws IOException {

		pobject = new Properties();
		try {
			File file = new File(
					System.getProperty("user.dir")
							+ "\\src\\main\\java\\com\\uitesting\\PageObjectModel\\Properties\\loginDetails.properties");

			FileReader reader = new FileReader(file);
			pobject.load(reader);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public static String getProperty(String PROPERTY_NAME) throws IOException {

		loadProperties();

		return pobject.getProperty(PROPERTY_NAME);
	}

}
