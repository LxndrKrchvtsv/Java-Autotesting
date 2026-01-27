package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class InMotionContactUsPage {
	private WebDriver driver;


	public InMotionContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isContactUsPageOpen() {
		return Objects.requireNonNull(driver.getCurrentUrl()).contains("contact");
	}
}