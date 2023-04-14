package com.acti.driver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	/*script: Driver Manager
	 * Description: This class manages all the driver instances and also a parent class for other driver classes which uses driver
	 * Developed By: Priyad
	 * Approved by : Tom
	 * Developed Date:2023-04-11
	 */

	public static WebDriver driver;
	static Properties prop;
	/*
	 * DriverManager Constructor to load the properties file
	 */

	public DriverManager() {
		try {
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("unable to load the properties file" + e.getMessage());
			e.printStackTrace();
		}

	}

	/*initApplication method to get the browser properties file value and launch the browser accordingly
	 * Note: @Test remove after unit testing is done
	 */
	public void initApplication() {
		String browser = prop.getProperty("browser");
		System.out.println("browser selected: " + browser);

	
			if (browser.trim().equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browser.trim().equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browser.trim().equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			}

		else {
			System.out.println("browser not supported please check the config.proprties file");
		}
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getAppURL();

		}
	public void getAppURL()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	public void quitBrowser()
	{
		driver.close();
	}
}