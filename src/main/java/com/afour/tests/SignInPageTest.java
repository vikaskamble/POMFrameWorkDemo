package com.afour.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.afour.base.TestBase;
import com.afour.pages.HomePage;
import com.afour.pages.SignInPage;

public class SignInPageTest extends TestBase{
	
	private WebDriver driver;
	private SignInPage signInPage;
	private HomePage basePage;
	
	/*
	 * public SignInPageTest() { driver = getDriver(); }
	 */


	@BeforeClass public void setUp() { 
		//Get driver 
		driver = getDriver(); 
		}
	
	 

	@Test
	public void verifySignInFunction() {
		
		System.out.println("Sign In functionality details...");
		basePage = new HomePage(driver);
		//signInPage = basePage.clickSignInBtn();
		//Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		//Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
		//Assert.assertTrue(signInPage.verifySignIn(), "Unable to sign in");
	}

	@Test
	public void SignInPageTestOne() {
		System.out.println("Hey im in example test One");
	}

	@Test
	public void SignInPageTestTwo() {
		System.out.println("Hey im in example test two");
	}

	@Test
	public void SignInPageTestThree() {
		System.out.println("Hey im in example test three");
	}

}
