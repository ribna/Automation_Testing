package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class googleSearchPage {

	WebDriver driver;

	public googleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "q")
	WebElement searchTextBox;

	@FindBy(xpath = "//input[@value='Google Search']")
	WebElement searchBtn;

	//get the URL
	public void goToPage(String url) {
		driver.get(url);
	}

	// Set search text in search textbox
	public void enterSearchText(String searchText) {
		searchTextBox.sendKeys(searchText);
	}

	public void clickOnSearchBtn() {
		searchBtn.click();
	}

	/**
	 * This method gets the loaded search results and removes the empty and null
	 * values. 
	 * Assert and verification of expected third result and actual third result
	 * displayed
	 * @param webPageThirdResult
	 * @param expectedThirdResult
	 */
	public void validateThirdResult(String expectedThirdResult) {
		List<String> strings = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
		for (WebElement e : elements) {
			strings.add(e.getText());
		}
		strings.removeAll(Arrays.asList("", null));
		String webPageThirdResult = strings.get(2);
		Assert.assertEquals(webPageThirdResult, expectedThirdResult);
	}
}
