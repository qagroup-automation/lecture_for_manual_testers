package com.qagroup.start;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LocalHtmlFileInBrowserTest {
	/**
	 * Chrome driver property variable
	 */
	private static final String CHROME_DRIVER_PATH_VARIABLE = "webdriver.chrome.driver";

	/**
	 * Hard-coded path to chromedriver.exe as downloaded by driver-binary-downloader-maven-plugin :-)
	 */
	private static final String PATH_TO_CHROME_DRIVER = getPathToDriver();

	/**
	 * Hard-coded path to {@code example.html} :-)
	 */
	private static final String PATH_TO_EXAMPLE_HTML = getPathToExmapleHtml();

	WebDriver driver;
	Alert alert;
	
	@Test
	public void testStartBrowser() {
		//System.setProperty(CHROME_DRIVER_PATH_VARIABLE, PATH_TO_CHROME_DRIVER);
		driver = new ChromeDriver();
		//waitFor(2);

		driver.navigate().to(PATH_TO_EXAMPLE_HTML);

		//waitFor(2);

		driver.findElement(By.cssSelector("button")).click();
		//waitFor(2);

		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "Hello world.", "Text on alert is not correct:");
	}

	@AfterClass(alwaysRun = true)
	public void cleanUp() {
		alert.accept();
		//waitFor(2);

		driver.close();
	}

	/**
	 * Sleeps for a few {@code seconds}
	 * 
	 * @param seconds
	 */
	private void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			// Nothing to do here
		}
	}

	private static String getPathToExmapleHtml() {
		return System.getProperty("user.dir") + "\\html\\example.html";
	}

	private static String getPathToDriver() {
		return System.getProperty("user.dir")
				+ "\\selenium_standalone_binaries\\windows\\googlechrome\\64bit\\chromedriver.exe";
	}
	
	public static void main(String[] args) {
		System.setProperty(CHROME_DRIVER_PATH_VARIABLE, PATH_TO_CHROME_DRIVER);
		new ChromeDriver();
	}
}
