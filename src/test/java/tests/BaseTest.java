package tests;

import core.BrowserService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new BrowserService().getDriver();
		driver.get("https://www.inmotionhosting.com");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}