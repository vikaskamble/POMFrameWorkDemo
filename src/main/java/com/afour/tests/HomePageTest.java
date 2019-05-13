package com.afour.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.afour.base.ExtentTestManager;
import com.afour.base.TestBase;
import com.afour.pages.HomePage;
import com.aventstack.extentreports.Status;

public class HomePageTest extends TestBase {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	/*
	 * public HomePageTest() { driver = getDriver(); }
	 */

	@Test(priority = 0)
	public void verifyHomePage() throws Exception {
		ExtentTestManager.getTest().assignCategory("Sanity Test");
		System.out.println("Home page test...");
		
		HomePage homePage = new HomePage(driver);		
		homePage.loginPage();		
		ExtentTestManager.getTest().log(Status.PASS, "Login Page Verification Pass.");
		//Assert.assertTrue(true);	
		
		// Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't
		// match");
	}
	
		
	@Test(priority = 1)
	public void validLogin() throws Exception {
		ExtentTestManager.getTest().assignCategory("Sanity Test");
		HomePage homePage = new HomePage(driver);		
		homePage._ValidLogin("Admin", "admin123");
	}
	
	
	
	

	/*
	 * @Test public void loginApplication() {
	 * ExtentTestManager.getTest().assignCategory("Regression");
	 * ExtentTestManager.getTest().log(Status.PASS, "TC PASS");
	 * 
	 * }
	 * 
	 * @Test public void baseTest1() {
	 * ExtentTestManager.getTest().assignCategory("Functional");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
	 * System.out.println("Hey im in test1 test");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 1");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 2");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 3");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 4");
	 * 
	 * }
	 * 
	 * @Test public void baseTest2() throws InterruptedException {
	 * ExtentTestManager.getTest().assignCategory("Functional");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test2");
	 * System.out.println("Hey im in test2 test"); Thread.sleep(3000);
	 * ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test2 1");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test2 2"); }
	 * 
	 * @Test public void baseTest3() {
	 * ExtentTestManager.getTest().assignCategory("Functional");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test3");
	 * System.out.println("Hey im in test3 test");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test3 1");
	 * ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test3 2"); }
	 */

}
