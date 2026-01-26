package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class InMotionContactUsPage {
	private WebDriver driver;

	@FindBys({
			@FindBy(id = "imh-main-menu"),
			@FindBy(css = ".phone-numbers-submenu")
	})
	private WebElement dropdownMenu;

	@FindBy(id = "imh-main-menu")
	private WebElement headerTag;

	@FindBy(id = "post-2")
	private WebElement mainSection;

	public InMotionContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public InMotionContactUsPage clickOnHeaderTag() {
		headerTag.click();
		return this;
	}

	public InMotionContactUsPage clickOnMainSection() {
		mainSection.click();
		return this;
	}

	public boolean isDropdownMenuDisplayed() {
		try {
			return dropdownMenu.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}