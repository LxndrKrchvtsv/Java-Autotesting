package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.InMotionPage;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InMotionTest {
	WebDriver driver;
	InMotionPage page;
	WebDriverWait wait;

	@BeforeEach
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.get("https://www.inmotionhosting.com/");
		page = new InMotionPage(driver);

		// Close cookies
		try {
			WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(page.acceptCookiesButton));
			acceptBtn.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("onetrust-consent-sdk")));
		} catch (Exception e) {
			System.out.println("Cookies button is not visible.");
		}
	}

	@Test
	@DisplayName("Issue 1: Click to a header don't close the dropdown menu")
	public void testDropdownDoesNotCloseOnHeaderClick() {
		// Click to the Contact us
		WebElement contactUs = wait.until(ExpectedConditions.elementToBeClickable(page.resourcesMenuItem));
		System.out.println("contactUs has found: " + contactUs);
		contactUs.click();

		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(page.dropdownMenu));
		System.out.println("Dropdown container: " + dropdown);
		System.out.println("Check dropdown visibility: " + dropdown.isDisplayed());
		assertTrue(dropdown.isDisplayed(), "Dropdown should be displayed after clicking on the dropdown menu.");

		page.headerSection.click();

		try { Thread.sleep(1000); } catch (InterruptedException e) {}

		boolean isMenuStillVisible = driver.findElement(page.dropdownMenu).isDisplayed();
		assertTrue(isMenuStillVisible, "BUG CONFIRMED: Dropdown menu is still visible after clicking on the header section.");
	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}