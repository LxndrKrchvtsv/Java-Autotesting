package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InMotionMainPage {
	private WebDriver driver;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement acceptCookiesBtn;

	@FindBy(xpath = "//div[@id='imh-main-menu']//a[@id='phoneDropDown' and contains(normalize-space(), 'Contact Us')]")
	private WebElement contactUsMenuItem;

	public InMotionMainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public InMotionMainPage acceptCookiesIfPresent() {
		try {
			acceptCookiesBtn.click();
		} catch (Exception e) {
			System.out.println("Cookies banner not found");
		}
		return this;
	}

	public InMotionContactUsPage clickContactUsMenuItem() {
		contactUsMenuItem.click();
		return new InMotionContactUsPage(driver);
	}
}