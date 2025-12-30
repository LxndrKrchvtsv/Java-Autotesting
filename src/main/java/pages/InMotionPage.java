package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InMotionPage {
	WebDriver driver;

	public InMotionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "onetrust-accept-btn-handler")
	public WebElement acceptCookiesButton;

	@FindBy(xpath = "//div[@id='imh-main-menu']//a[@id='phoneDropDown' and contains(normalize-space(), 'Contact Us')]")
	public WebElement resourcesMenuItem;

	@FindBy(id = "imh-main-menu")
	public WebElement headerSection;

	public By dropdownMenu = By.cssSelector("#imh-main-menu .phone-numbers-submenu");
}