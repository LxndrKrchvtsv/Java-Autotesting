package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserService {
	private WebDriver driver;

	public BrowserService() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("--start-maximized");

		driver = new ChromeDriver(chromeOptions);
	}

	public WebDriver getDriver() {
		return driver;
	}
}