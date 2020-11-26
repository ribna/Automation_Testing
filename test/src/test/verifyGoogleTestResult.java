package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.googleSearchPage;

public class verifyGoogleTestResult extends TestBase {

	/**
	 * Test case 1 Launch the Google web page. Set the search text and get the
	 * google search result.Validate the third result with expected result
	 */

	@Test(priority = 0)
	public void searchResult() throws Exception {
		googleSearchPage searchPage = PageFactory.initElements(driver, googleSearchPage.class);

		searchPage.goToPage(propertiesReader.getValue("googleUrl"));
		test.log(LogStatus.INFO,
				"Start Google Search Page" + test.addScreenCapture(screenShots.getScreenshot(driver, "googleSearch")));

		searchPage.enterSearchText(propertiesReader.getValue("searchText"));
		test.log(LogStatus.INFO,
				"Set Search Text" + test.addScreenCapture(screenShots.getScreenshot(driver, "searchText")));

		searchPage.clickOnSearchBtn();
		test.log(LogStatus.INFO,
				"Display Web Results " + test.addScreenCapture(screenShots.getScreenshot(driver, "webResult")));

		searchPage.validateThirdResult(propertiesReader.getValue("expectedThirdResult"));
	}
}