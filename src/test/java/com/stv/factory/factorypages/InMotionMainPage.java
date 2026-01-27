package com.stv.factory.factorypages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InMotionMainPage {
	private WebDriver driver;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement acceptCookiesBtn;

	@FindBy(id = "phoneDropDown")
	private WebElement contactUsMenuItem;

	@FindBys({
			@FindBy(id = "imh-main-menu"),
			@FindBy(css = ".phone-numbers-submenu")
	})
	private WebElement dropdownMenu;

	@FindBy(xpath = "//div[@aria-labelledby='phoneNumbersDropDown']//a[@aria-label='Contact Us']")
	private WebElement contactUsSubmenuLink;

	@FindBy(id = "imh-main-menu")
	private WebElement headerTag;

	@FindBy(id = "masthead")
	private WebElement mainSection;

	@FindBy(xpath = "//a[contains(text(), 'Talk with an Expert')]")
	private WebElement talkWithExpertBtn;

	public InMotionMainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public InMotionMainPage acceptCookiesIfPresent() {
		try {
			if (acceptCookiesBtn.isDisplayed()) acceptCookiesBtn.click();
		} catch (Exception e) {
			System.out.println("Cookies banner not found");
		}
		return this;
	}

	public String getContactUsTooltip() {
		System.out.println(contactUsMenuItem.getDomProperty("id"));
		return contactUsMenuItem.getDomAttribute("title");
	}

	public InMotionMainPage clickContactUsMenuItem() {
		contactUsMenuItem.click();
		return new InMotionMainPage(driver);
	}

	public String getContactUsSubmenuLink() {
		return contactUsSubmenuLink.getText();
	}

	public InMotionContactUsPage clickContactUsSubmenuItem() {
		contactUsSubmenuLink.click();
		return new InMotionContactUsPage(driver);
	}

	public InMotionMainPage clickOnHeaderTag() {
		headerTag.click();
		return this;
	}

	public InMotionMainPage clickOnMainSection() {
		mainSection.click();
		return this;
	}

	public String getMainPageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isMainPageDisplayed() {
		return driver.getCurrentUrl().equals("https://www.inmotionhosting.com/");
	}

	public boolean isMainPageHeroVisible() {
		return mainSection.isDisplayed();
	}

	public boolean isDropdownMenuDisplayed() {
		try {
			return dropdownMenu.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}


	private String mainWindowHandle;
	public void clickTalkWithExpert() {
		mainWindowHandle = driver.getWindowHandle();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(talkWithExpertBtn));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", talkWithExpertBtn);

		talkWithExpertBtn.click();
	}

	public int getWindowCount() {
		return driver.getWindowHandles().size();
	}

	public void switchToNewWindow() {
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}

	public void switchToMainWindow() {
		if (mainWindowHandle != null) {
			driver.switchTo().window(mainWindowHandle);
		}
	}

	public String getWindowTitle() {
		return driver.getTitle();
	}
}