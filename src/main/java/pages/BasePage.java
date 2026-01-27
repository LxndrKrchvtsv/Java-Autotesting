package pages;

import core.WaitService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public abstract class BasePage {
	protected WebDriver driver;
	protected WaitService waitService;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.waitService = new WaitService(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}