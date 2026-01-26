package com.stv.bdd.steps;

import com.stv.factory.factorypages.InMotionContactUsPage;
import com.stv.factory.factorypages.InMotionMainPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class InMotionSteps {
	private WebDriver driver;
	private InMotionMainPage mainPage;
	private InMotionContactUsPage contactUsPage;

	@Given("The user is on the InMotion Hosting main page")
	public void userIsOnMainPage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.inmotionhosting.com/");
		mainPage = new InMotionMainPage(driver);
	}

	@Given("The user accepts cookies if they appear")
	public void acceptCookies() {
		mainPage.acceptCookiesIfPresent();
	}

	@When("The user clicks on the Contact Us menu item")
	public void clickContactUs() {
		contactUsPage = mainPage.clickContactUsMenuItem();
	}

	@Then("The dropdown menu should be displayed")
	public void verifyDropdown() {
		Assert.assertTrue(contactUsPage.isDropdownMenuDisplayed(), "Dropdown is not visible!");
		driver.quit();
	}

	@When("The user clicks on the {string} link")
	public void clickResourceLink(String resourceType) {
		System.out.println("Attempting to click: " + resourceType);

		mainPage.clickOnLinkByText(resourceType);
	}

	@Then("The page title should contain {string}")
	public void verifyTitle(String expectedWord) {
		org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> d.getTitle() != null && d.getTitle().length() > 0);

		String actualTitle = driver.getTitle();
		System.out.println("Actual Title: " + actualTitle);

		Assert.assertTrue(actualTitle.toLowerCase().contains(expectedWord.toLowerCase()),
				"Title '" + actualTitle + "' doesn't contain '" + expectedWord + "'");

		driver.quit();
	}
}