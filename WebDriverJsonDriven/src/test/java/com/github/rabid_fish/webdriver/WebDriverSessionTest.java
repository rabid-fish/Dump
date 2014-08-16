package com.github.rabid_fish.webdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSessionTest {

	@Test
	public void testStartSession() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.quit();
	}
	
}
