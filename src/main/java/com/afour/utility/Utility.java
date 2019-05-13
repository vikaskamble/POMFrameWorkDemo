package com.afour.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.afour.base.TestBase;

public class Utility extends TestBase {
	
	public static WebDriver driver;
	
	public Utility(WebDriver driver) {
		this.driver = getDriver();
	}
	
	
	/**
	 * This Method is use to capcture screen shot.  
	 * @param driver         This is first parameter to pass the driver.
	 * @param screenshotName This is second parameter to pass the screenshot name
	 * @return It return screenshot destination path
	 * @throws IOException It throws IO exception
	 * @since 2019-05-06
	 * @author vikas kamble
	 */
	
	public static String capcture() throws IOException {//WebDriver driver, String screenshotName
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "/ErrorScreenshots/" + "Screenshot" + ".png";//screenshotName
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}

}
