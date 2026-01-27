package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(id = "resourcesDropDown")
	private WebElement resourcesButton;

	@FindBy(xpath = "//*[@aria-labelledby='resourcesDropDown']")
	private WebElement resourcesDropdown;

	@FindBy(id = "imh-main-menu")
	private WebElement headerSection;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void openResourcesMenu() {
		waitService.waitForVisibility(resourcesButton).click();
	}

	public boolean isDropdownDisplayed() {
		try {
			// Используем проверку видимости элемента
			return resourcesDropdown.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOutsideOnHeader() {
		waitService.waitForVisibility(headerSection).click();
	}
}