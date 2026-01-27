package com.stv.bdd.steps;

import com.stv.factory.factorypages.InMotionContactUsPage;
import com.stv.factory.factorypages.InMotionMainPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class InMotionSteps {
	private static WebDriver driver;
	private InMotionMainPage mainPage;
	private InMotionContactUsPage contactUSPage;

	@Given("The user is on the InMotion Hosting main page")
	public void userIsOnMainPage() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		if (!driver.getCurrentUrl().equals("https://www.inmotionhosting.com/")) {
			driver.get("https://www.inmotionhosting.com/");
		}

		mainPage = new InMotionMainPage(driver);
	}

	@When("The user checks the tooltip of the Contact Us menu item")
	public void userChecksTheTooltipOfContactUsMenuItem() {
		String tooltip = mainPage.getContactUsTooltip();
		Assert.assertNotNull(tooltip, "Tooltip not found!");
	}

	@And("The user clicks on the Contact Us menu item")
	public void clickContactUsMenuItem() {
		mainPage.clickContactUsMenuItem();
	}

	@And("The dropdown menu should be displayed")
	public void dropdownMenuShouldBeDisplayed() {
		mainPage.isDropdownMenuDisplayed();
	}

	@And("The user selects Contact Us from the dropdown")
	public void selectContactUsSubMenuItem() {
		this.contactUSPage = mainPage.clickContactUsSubmenuItem();
	}

	@Then("The Contact Us page is displayed with the correct URL")
	public void contactUsPageIsDisplayedWithCorrectURL() {
		Assert.assertTrue(contactUSPage.isContactUsPageOpen(),
				"The URL does not contain 'contact'");
	}

	@When("The user navigates back using the browser button")
	public void navigateBack() {
		driver.navigate().back();
	}

	@Then("The Main page is displayed correctly")
	public void verifyMainPageIsBack() {
		String currentUrl = driver.getCurrentUrl();

		Assert.assertEquals(currentUrl, mainPage.getMainPageUrl(), "The user is not on the main page!");
		Assert.assertTrue(mainPage.isMainPageHeroVisible(), "Main Page content is not visible!");
	}

	@When("The user clicks {string} on Main page")
	public void clickOnMainPage(String buttonName) {
		mainPage.clickTalkWithExpert();
	}

	@Then("The expert window should be displayed")
	public void verifyExpertWindow() {
		org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(d -> mainPage.getWindowCount() > 1);

		Assert.assertTrue(mainPage.getWindowCount() > 1, "Новое окно браузера не открылось!");

		mainPage.switchToNewWindow();
		System.out.println("Заголовок нового окна: " + mainPage.getWindowTitle());

		mainPage.switchToMainWindow();
	}

	@When("The user tries to close it by clicking {string}")
	public void clickTalkWithExpertAgain(String btnName) {
		mainPage.clickTalkWithExpert();
	}

	@Then("The expert window should be re-opened")
	public void verifyExpertWindowReOpened() {
		Assert.assertTrue(mainPage.getWindowCount() > 1, "Окно эксперта закрылось от повторного клика, а не должно было!");
	}

	@When("The user closes the expert window via browser close button")
	public void closeViaBrowserLogic() {
		mainPage.switchToNewWindow();

		driver.close();

		try {
			org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			System.out.println("Подтверждение закрытия принято.");
		} catch (Exception e) {
			System.out.println("Окно закрылось без дополнительного подтверждения или Alert не успел появиться.");
		}

		mainPage.switchToMainWindow();
	}

	@Then("The expert window should be closed and focus should be returned to Main page")
	public void verifyExpertWindowClosedAndFocus() {
		mainPage.switchToMainWindow();

		Assert.assertEquals(mainPage.getWindowCount(), 1, "Окно эксперта закрылось от повторного клика, а не должно " +
				"было!");

		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, mainPage.getMainPageUrl(), "The user is not on the main page!");

		Assert.assertTrue(mainPage.isMainPageHeroVisible(), "Контент главной страницы не отображается или недоступен!");

		System.out.println("Успех: Окно закрыто, фокус на главной странице.");

		driver.close();
	}
}