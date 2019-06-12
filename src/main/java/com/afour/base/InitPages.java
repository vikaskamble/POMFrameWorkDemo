package com.afour.base;

import org.openqa.selenium.WebDriver;

import com.afour.pages.HomePage;

public class InitPages {
	WebDriver driver = null;
	public GlobalData globalData = null;
	public SendMail sendMail = null;
	

	InitPages get() {
		return new InitPages();		
	}
	
	
	/**
	 * This method use to initialize web pages
	 * @return none
	 * @throws Exception exception
	 * @author vikas.k
	 * @since 2019-05-08
	 */
	public void initializeOnlyWebPages() throws Exception {
		globalData = new GlobalData();		
		sendMail = new SendMail();
		
	}
}
