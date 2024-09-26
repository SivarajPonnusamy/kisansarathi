package com.kisansarathi.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.uncommons.reportng.HTMLReporter;

import com.aventstack.extentreports.ExtentReports;
import com.kisansarathi.pageobjects.LoginPage;
import com.kisansarathi.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_test {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static Properties browser = new Properties();
	public FileInputStream read;
	static Readconfig readconfig = new Readconfig();

	public static String mobileno = readconfig.getmobileNO();
	public static String pinno = readconfig.getPin();

	@BeforeClass
	public void setUp() throws IOException {
		if (driver == null) {

			System.out.println("the path is" + System.getProperty("user.dir"));

			// URL and browser getting passed.
			String file1 = System.getProperty("user.dir") + "/src/test/resources/configfiles/url.properties";

			FileInputStream read1 = new FileInputStream(file1);

			prop.load(read1);
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

				System.out.println("Browser value from configfile: " + prop.getProperty("browser"));

				WebDriverManager.chromedriver().setup();

				// driver.manage().window().maximize();
				// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				/*
				 * DesiredCapabilities caps = new DesiredCapabilities();
				 * caps.setAcceptInsecureCerts(true); ChromeOptions options = new
				 * ChromeOptions(); options.addArguments("--disable-infobars");
				 * options.addArguments("--disable-notifications"); options.merge(caps);
				 */

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");

				options.addArguments("--incognito");

				driver = new ChromeDriver(options);
				driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();

			}

			else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				System.out.println("Browser value from configfile: " + prop.getProperty("browser"));

				// WebDriverManager.firefoxdriver().setup();
				WebDriverManager.firefoxdriver().setup();
				System.out.println("wvedv");
				FirefoxOptions options = new FirefoxOptions();
				options.setProfile(new FirefoxProfile());
				options.addPreference("dom.webnotifications.enabled", false);
				driver = new FirefoxDriver(options);
				driver.get(prop.getProperty("url"));

				driver.manage().window().maximize();

			}
			LoginPage login = new LoginPage(driver);
			login.setmobileNO(mobileno);
			login.nextButton();
			login.setpinNo(pinno);
			login.loginButton();
		}
	}

	@AfterClass
	public void tearDown() {

		driver.close();
		System.out.println("BSF testing Completed");
	}

	@AfterTest
	public void driverQuit() {
		driver.quit();
		System.out.println("Driver get quit successfully after test completion...");
	}

}
