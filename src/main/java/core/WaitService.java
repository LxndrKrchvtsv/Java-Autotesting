package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitService {
	private WebDriverWait wait;

	public WaitService(WebDriver driver, Duration timeout) {
		this.wait = new WebDriverWait(driver, timeout);
	}

	public WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean waitForInvisibility(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
}