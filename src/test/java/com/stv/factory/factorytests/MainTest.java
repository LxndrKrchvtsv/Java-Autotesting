package com.stv.factory.factorytests;

import com.stv.factory.factorypages.InMotionMainPage;
import com.stv.factory.factorypages.InMotionContactUsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.inmotionhosting.com/");
	}

	@Test(description = "Reproducing Bug Report #1: Menu doesn't close when clicking on the header")
	public void testBug001_DropdownDoesNotCloseOnHeaderClick() {
		InMotionMainPage mainPage = new InMotionMainPage(driver);

		InMotionContactUsPage contactUsPage = mainPage
				.acceptCookiesIfPresent()
				.clickContactUsMenuItem();

		Assert.assertTrue(contactUsPage.isDropdownMenuDisplayed(), "The menu should open after clicking on ContactUsMenuItem");

		contactUsPage.clickOnHeaderTag();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(contactUsPage.isDropdownMenuDisplayed(),
				"BUG CONFIRMED: Dropdown menu did not close after clicking on the header tag!");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}