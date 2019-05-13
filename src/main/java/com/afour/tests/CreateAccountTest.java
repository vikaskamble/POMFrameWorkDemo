package com.afour.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.afour.base.TestBase;
import com.afour.pages.CreateAccountPage;
import com.afour.pages.HomePage;
import com.afour.pages.SignInPage;

public class CreateAccountTest extends TestBase{

	private WebDriver driver;
	private SignInPage signInPage;
	private HomePage homePage;
	private CreateAccountPage createAccountPage;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void verifyCreateAnAccountPage() throws Exception {
		System.out.println("Create An Account page test...");
		homePage = new HomePage(driver);
		signInPage = homePage.clickSignInBtn();
		createAccountPage = signInPage.clickonCreateAnAccount();
		Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
		Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
	}

	@Test
	public void createAccountExample1() {
		System.out.println("Hey im in example1 test");
	}

	@Test
	public void createAccountExample2() {
		System.out.println("Hey im in Example2 test");
	}
}
