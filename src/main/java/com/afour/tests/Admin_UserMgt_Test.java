package com.afour.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.afour.base.ExtentTestManager;
import com.afour.base.TestBase;
import com.afour.pages.Admin_UserMgt_Page;
import com.afour.pages.HomePage;
import com.aventstack.extentreports.Status;

public class Admin_UserMgt_Test extends TestBase {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	@Test
	public void addUser() throws Exception {
		//ExtentTestManager.getTest().assignCategory("Sanity Test");		
		HomePage homePage = new HomePage(driver);		
		homePage._ValidLogin("Admin", "admin123");
		Admin_UserMgt_Page usr_Mgt = new Admin_UserMgt_Page(driver);
		usr_Mgt.addUser();
	}
}
