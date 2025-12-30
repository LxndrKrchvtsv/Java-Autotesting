package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InMotionContactUsPage {
	private WebDriver driver;

	@FindBy(css = "#imh-main-menu .phone-numbers-submenu")
	private WebElement dropdownMenu;

	@FindBy(id = "imh-main-menu")
	private WebElement headerTag;

	public InMotionContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public InMotionContactUsPage clickOnHeaderTag() {
		headerTag.click();
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