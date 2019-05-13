package com.afour.pages;

import org.openqa.selenium.WebDriver;

import com.afour.base.ExtentTestManager;
import com.aventstack.extentreports.Status;

public class Admin_UserMgt_Page {

	private WebDriver driver;

	public Admin_UserMgt_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void addUser() throws Exception {
		navigate_AdminTab();
		navigate_User_Mget_SubTab();
		navigate_User();
		is_navigate_User();
	}

	private void is_navigate_User() {
		ExtentTestManager.getTest().log(Status.INFO, "Verifying Navigated User Tab.");
		
	}

	private void navigate_User() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "Navigating User Tab");

	}

	private void navigate_User_Mget_SubTab() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "Navigating User User Management Sub Tab");

	}

	private void navigate_AdminTab() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "Navigating Admin Tab");

	}

}
