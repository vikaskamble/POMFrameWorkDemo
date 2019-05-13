package com.afour.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase extends InitPages{
	
	private static final String String = null;
	private WebDriver driver;
	
	//private static String driverPath = "C:\\JAVA Work\\POMFrameWorkDemo\\Drivers\\";
	private static String driverPath = System.getProperty("user.dir")+"\\"+"Drivers"+"\\";
	

	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * This method is use to set the browser
	 * @param browserType Browser Type is first parameter 
	 * @param appURL Application URL is second parameter
	 * @throws Exception
	 * @author vikas.k
	 * @since 2019-05-08
	 */
	
	private void setDriver(String browserType, String appURL) throws Exception {
		switch (browserType.toLowerCase()) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}
	
	/**
	 * This method is use to initialize the firefox browser
	 * @param appURL url
	 * @return driver
	 * @throws InterruptedException
	 * @author vikas.k
	 * @since 2019-05-08
	 */

	private WebDriver initFirefoxDriver(String appURL) throws InterruptedException {
		//System.out.println("Launching Firefox browser..");
		Reporter.log("===== Launching fire fox browser ... =====", true);	
		Reporter.log("===== Browser Session Started =====", true);
		
		System.setProperty("webdriver.gecko.driver", driverPath +"geckodriver.exe");	
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette",true);
		WebDriver driver = new FirefoxDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * This method is use to initialize the google chrome browser
	 * @param appURL URL is first parameter
	 * @return driver
	 * @throws Exception
	 */
	private WebDriver initChromeDriver(String appURL) throws Exception {		
		Reporter.log("===== Launching google chrome with new profile... =====", true);	
		Reporter.log("===== Browser Session Started =====", true);		
		
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		Reporter.log("Navigating URL : " + appURL, true);
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	

	/**
	 * This method is use to set driver 
	 * @param browserType browser Type is first parameter 
	 * @param appURL Application URL is second parameter
	 * @return none
	 * @author vikas.k
	 * @since 2019-05-08
	 */
	
	@Parameters({ "browserType", "appURL" })
	@BeforeMethod
	public void initializeTestBaseSetup(@Optional String browserType, @Optional String appURL) {
		try {
			if (browserType == null || appURL == null) {	
				String browser = GlobalData.config("browser");
				String url = GlobalData.config("url");
				setDriver(browser, url);
			} else {
				setDriver(browserType, appURL);
			}

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterMethod
	public void aftermethod() {
		driver.close();
		driver.quit();
	}

	
	@BeforeClass
	public void beforeclass() {
		//System.out.println("You are in before class.");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		//driver.quit();
		Thread.sleep(5000);		
		SendMail.sendMail();
		Thread.sleep(200);
	}	
	
}
