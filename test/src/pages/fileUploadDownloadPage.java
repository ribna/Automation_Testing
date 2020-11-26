package pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.propertiesReader;

public class fileUploadDownloadPage {

	WebDriver driver;

	public fileUploadDownloadPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(linkText = "File Upload")
	WebElement fileuploadLink;

	@FindBy(linkText = "Dynamic Loading")
	WebElement dynamicLoadingLink;

	@FindBy(linkText = "Example 2: Element rendered after the fact")
	WebElement example2Link;

	@FindBy(id = "file-upload")
	WebElement chooseFileBtn;

	@FindBy(xpath = "//button[text()='Start']")
	WebElement startBtn;

	@FindBy(id = "file-submit")
	WebElement uploadBtn;

	@FindBy(id = "uploaded-files")
	WebElement uploadedFileName;

	@FindBy(id = "finish")
	WebElement renderedElement;

	@FindBy(id = "loading")
	WebElement loadingImage;

	// Get the Url
	public void goToPage(String url) {
		driver.get(url);
	}

	public void clickOnFileUploadLink() {
		fileuploadLink.click();
	}

	// Choose file
	public void ChooseFile() throws Exception {
		chooseFileBtn.sendKeys(propertiesReader.getValue("imageFilePath"));
	}

	public void clickOnUploadBtn() {
		uploadBtn.click();
	}

	/**
	 * Assertion and verification of uploaded file name and actual file name
	 * 
	 * @param file
	 * @param uploadedFileName
	 */
	public void validateUploadedFileName() throws Exception {
		waitElementToBeLoad(uploadedFileName);
		File file = new File(propertiesReader.getValue("imageFilePath"));
		Assert.assertEquals(file.getName(), uploadedFileName.getText());
	}

    // wait until element loaded
	public void waitElementToBeLoad(WebElement loadingElement) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(loadingElement));
	}

	public void clickOnDynamicLoadingLink() {
		dynamicLoadingLink.click();
	}

	public void clickOnExample2Link() {
		example2Link.click();
	}

	public void clickOnStartBtn() {
		startBtn.click();
	}
	/**
	 * Assertion and verification of rendered element text and expected text
	 * 
	 * @param expectedText
	 * @param renderedElement
	 */

	public void validateRenderedElementText(String expectedText) throws InterruptedException {

		waitElementToBeLoad(renderedElement);
		Assert.assertEquals(renderedElement.getText(), expectedText);
	}
}
