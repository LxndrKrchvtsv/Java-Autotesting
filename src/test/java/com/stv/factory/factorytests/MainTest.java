package com.stv.factory.factorytests;

import com.stv.factory.factorypages.InMotionContactUsPage;
import com.stv.factory.factorypages.InMotionMainPage;
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

	@Test(description = "Test case #1: Menu doesn't close when clicking on the header")
	public void testDropdownOpens() {
		InMotionMainPage mainPage = new InMotionMainPage(driver);
		InMotionContactUsPage contactUsPage = mainPage
				.acceptCookiesIfPresent()
				.clickContactUsMenuItem();

		Assert.assertTrue(contactUsPage.isDropdownMenuDisplayed(), "Dropdown should be visible after click");
	}

	@Test(description = "Test case №2: Click on the header", dependsOnMethods = "testDropdownOpens")
	public void testDropdownDoesNotCloseOnHeaderClick() {
		InMotionContactUsPage contactUsPage = new InMotionContactUsPage(driver);
		contactUsPage.clickOnHeaderTag();

		Assert.assertTrue(contactUsPage.isDropdownMenuDisplayed(), "BUG: Dropdown closed after clicking on header!");
	}

	@Test(description = "Кейс №3: Click on main (Check close)", dependsOnMethods = "testDropdownDoesNotCloseOnHeaderClick")
	public void testDropdownClosesOnMainClick() {
		InMotionContactUsPage contactUsPage = new InMotionContactUsPage(driver);

		if (!contactUsPage.isDropdownMenuDisplayed()) {
			new InMotionMainPage(driver).clickContactUsMenuItem();
		}

		contactUsPage.clickOnMainSection();

		Assert.assertFalse(contactUsPage.isDropdownMenuDisplayed(), "Dropdown should close after clicking on main section");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}