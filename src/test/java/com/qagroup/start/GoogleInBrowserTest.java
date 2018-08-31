package com.qagroup.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GoogleInBrowserTest {

	/**
	 * Chrome driver property variable
	 */
	private static final String CHROME_DRIVER_PATH_VARIABLE = "webdriver.chrome.driver";

	/**
	 * Hard-coded path to chromedriver.exe as downloaded by driver-binary-downloader-maven-plugin :-)
	 */
	private static final String PATH_TO_CHROME_DRIVER = getPathToDriver();

	private WebDriver driver;

	@Test
	public void testGoogle() {
		System.setProperty(CHROME_DRIVER_PATH_VARIABLE, PATH_TO_CHROME_DRIVER);
		driver = new ChromeDriver();
		waitFor(2);
		driver.navigate().to("http://www.google.com.ua");
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("QA Group!");
		//By.xpath("//*[@id='lst-ib']")
		
		waitFor(2);
	}
	
	@AfterClass(alwaysRun = true)
	public void cleanUp() {
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

	private static String getPathToDriver() {
		return System.getProperty("user.dir")
				+ "\\selenium_standalone_binaries\\windows\\googlechrome\\64bit\\chromedriver.exe";
	}
}
