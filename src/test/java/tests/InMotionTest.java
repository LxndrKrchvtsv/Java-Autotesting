package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class InMotionTest extends BaseTest {

	@Test(description = "Verify that dropdown closes when clicking on the header section")
	public void testDropdownShouldCloseAfterClickOnHeader() {
		HomePage homePage = new HomePage(driver);

		homePage.openResourcesMenu();
		Assert.assertTrue(homePage.isDropdownDisplayed(), "Dropdown menu should be visible!");

		homePage.clickOutsideOnHeader();

		Assert.assertTrue(homePage.isDropdownDisplayed(),
				"Bug AK-FB-001 (not reproduced): Dropdown did close after clicking on the header section!");
	}
}