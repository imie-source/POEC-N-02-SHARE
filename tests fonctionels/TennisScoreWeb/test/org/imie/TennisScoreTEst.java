package org.imie;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TennisScoreTEst {

	static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {

		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/TennisScoreWeb/TennisScore");

	}
	
	@AfterClass
	public static void tearDown() throws Exception {

		driver.quit();

	}

	@Test
	public void testTitle() {

		
		assertEquals("Score du Tennis", driver.getTitle());
	}
	
	@Test
	public void testinit() {

		WebElement userName = driver.findElement(By.id("score"));
		assertEquals("0-0",userName.getText());
	}

}
