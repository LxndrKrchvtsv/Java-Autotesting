package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InMotionMainPage {
	private WebDriver driver;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement acceptCookiesBtn;

	@FindBy(id = "phoneDropDown")
	private WebElement contactUsMenuItem;

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

	public InMotionContactUsPage clickContactUsMenuItem() {
		contactUsMenuItem.click();
		return new InMotionContactUsPage(driver);
	}

	public void clickOnHostingLink(String linkText) {
		WebElement link = driver.findElement(org.openqa.selenium.By.partialLinkText(linkText));
		link.click();
	}

	public void clickOnLinkByText(String linkText) {
		try { Thread.sleep(1000); } catch (InterruptedException e) {}

		org.openqa.selenium.WebElement link = driver.findElement(org.openqa.selenium.By.partialLinkText(linkText));

		org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", link);
	}
}