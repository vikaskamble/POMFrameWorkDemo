package com.afour.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty9.server.ResourceService.WelcomeFactory;

import com.afour.base.ExtentTestManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class HomePage {
	
	ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest test;
	protected  WebDriver driver;
	private By signInButton = By.linkText("Sign in");
	
	private By loginPage = By.id("divLogo");
	private By username_texBox = By.id("txtUsername");
	private By password_texBox = By.id("txtPassword");
	private By login_Bbtn = By.id("btnLogin");
	private By welcome_msg = By.id("welcome");
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * This method is use to navigate Login Page
	 */
	public void loginPage() throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "Login Page Navigated successfully");
		WebElement loginPage_ele = driver.findElement(loginPage);
		if(loginPage_ele.isDisplayed()) {
			System.out.println("Login Page navigated.");
			ExtentTestManager.getTest().log(Status.PASS, "Login Page Navigated successfully");
		}else {
			System.out.println("Element not found");
			ExtentTestManager.getTest().log(Status.FAIL, "Login Page Element not found.");
		}
	}	
	
	
	
	public SignInPage clickSignInBtn()throws Exception {
		System.out.println("clicking on sign in button");
		WebElement signInBtnElement = driver.findElement(signInButton);
		if (signInBtnElement.isDisplayed() || signInBtnElement.isEnabled())
			signInBtnElement.click();
		else
			System.out.println("Element not found");
		return new SignInPage(driver);
	}

	
	
	public void clickImagesLink() throws Exception {
		// It should have a logic to click on images link
		// And it should navigate to google images page
	}

	public String getPageTitle() throws Exception {
		String title = driver.getTitle();
		return title;
	}

	public boolean verifyBasePageTitle() throws Exception {
		String expectedPageTitle = "Google";
		return getPageTitle().contains(expectedPageTitle);
	}

	
	
	
	/**
	 * This method is use to valid login
	 * 
	 * @param username username
	 * @param password password
	 * @author vikas.k
	 * @since 2019-05-10
	 */

	public void _ValidLogin(String username, String password) throws Exception {
		enterUserName(username);
		enterPassword(password);
		clickOnLogin();
		isLoginSuccess();

	}

	private void isLoginSuccess() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Verifying is login successful..?");
		WebElement welcome_msg_ele = driver.findElement(welcome_msg);
		if (welcome_msg_ele.isDisplayed() && welcome_msg_ele.isEnabled()) {			
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, "Application logged in successfully.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Login verification failed.");
		}

	}

	private void clickOnLogin() {
		ExtentTestManager.getTest().log(Status.INFO, "Clicking on login button.");
		WebElement login_Bbtn_ele = driver.findElement(login_Bbtn);
		if (login_Bbtn_ele.isDisplayed() && login_Bbtn_ele.isEnabled()) {			
			login_Bbtn_ele.click();
			ExtentTestManager.getTest().log(Status.PASS, "login button clicked on successfully.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "login button WebElement was not found.");
		}
	}

	private void enterPassword(String password) {
		ExtentTestManager.getTest().log(Status.INFO, "Enterning password in password textbox.");
		WebElement password_texBox_ele = driver.findElement(password_texBox);
		if (password_texBox_ele.isDisplayed() && password_texBox_ele.isEnabled()) {
			password_texBox_ele.clear();
			password_texBox_ele.sendKeys(password);
			ExtentTestManager.getTest().log(Status.PASS, "password entered successfully in password textbox.");
		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "password textbox WebElement was not found.");
		}
	}

	/**
	 * This methos is use enter username in username text box.
	 * @param username username
	 * @throws Exception exception
	 * @author vikas.k
	 * @since 2019-05-10
	 */
	private void enterUserName(String username) throws Exception {
		ExtentTestManager.getTest().log(Status.INFO, "Enterning user name in username textbox.");
		WebElement username_texBox_ele = driver.findElement(username_texBox);
		if(username_texBox_ele.isDisplayed() && username_texBox_ele.isEnabled()) {
			username_texBox_ele.clear();
			username_texBox_ele.sendKeys(username);		
			ExtentTestManager.getTest().log(Status.PASS, "user name entered successfully in username textbox.");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "username textbox WebElement was not found.");
		}
	}
}
