package com.qagroup.start;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LocalHtmlFileInBrowserTest {
	/**
	 * Chrome driver property variable
	 */
	private static final String CHROME_DRIVER_PATH_VARIABLE = "webdriver.chrome.driver";

	/**
	 * Hard-coded path to chromedriver.exe on my computer :-)
	 */
	private static final String PATH_TO_CHROME_DRIVER = "E:\\workspace\\eclipse_neon\\aqa_simple\\selenium_standalone_binaries\\windows\\googlechrome\\64bit\\chromedriver.exe";

	/**
	 * Hard-coded path to {@code example.html} file on my computer :-)
	 */
	private static final String PATH_TO_EXAMPLE_HTML = "E:\\qagroup\\spring_2017\\html\\example.html";

	WebDriver driver;
	
	
	@Test
	public void testStartBrowser() {
		System.setProperty(CHROME_DRIVER_PATH_VARIABLE, PATH_TO_CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.navigate().to(PATH_TO_EXAMPLE_HTML);
		
		driver.findElement(By.xpath("//button")).click();
		
		waitFor(2);
		
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "Hello world!", "Text on alert is not correct:");
		
		alert.accept();
		
		waitFor(2);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void cleanUp() {
		driver.close();
	}
	
	
	/**
	 * Sleeps for a few {@code seconds}
	 * @param seconds
	 */
	private void waitFor(int seconds) {
		try{
			Thread.sleep(seconds * 1000); 
		} catch (Exception e) {
			// Nothing to do here
		}
	}
}
