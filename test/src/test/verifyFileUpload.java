package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.fileUploadDownloadPage;

public class verifyFileUpload extends TestBase {

	/**
	 * Test case 2 Launch the web page herokuapp.com. Get the file upload link and
	 * get the file loader page.Choose file and upload.Validate the successful
	 * upload with uploaded file name actual file name f
	 */

	@Test(priority = 0)
	public void uploadImage() throws Exception {
		fileUploadDownloadPage fileUploadPage = PageFactory.initElements(driver, fileUploadDownloadPage.class);
		fileUploadPage.goToPage(propertiesReader.getValue("fileLoadUrl"));
		test.log(LogStatus.INFO,
				" Load herokuapp.com " + test.addScreenCapture(screenShots.getScreenshot(driver, "herokuapp")));

		fileUploadPage.clickOnFileUploadLink();
		test.log(LogStatus.INFO,
				" Open File Uploader Page" + test.addScreenCapture(screenShots.getScreenshot(driver, "fileUploader")));

		fileUploadPage.ChooseFile();
		test.log(LogStatus.INFO,
				"Choose File to Upload" + test.addScreenCapture(screenShots.getScreenshot(driver, "file")));

		fileUploadPage.clickOnUploadBtn();
		test.log(LogStatus.INFO,
				"Upload Success Page" + test.addScreenCapture(screenShots.getScreenshot(driver, "uploadSuccess")));

		fileUploadPage.validateUploadedFileName();
	}

	/**
	 * Test case 3 Launch the web page herokuapp.com.Get the file Dynamic loading.
	 * link and get the dynamic load page. Select example 2 and load element
	 * Validate the rendered element text.
	 */

	@Test(priority = 1)
	public void renderedElement() throws Exception {
		fileUploadDownloadPage dynamicLoadPage = PageFactory.initElements(driver, fileUploadDownloadPage.class);

		dynamicLoadPage.goToPage(propertiesReader.getValue("fileLoadUrl"));
		test.log(LogStatus.INFO,
				" Load herokuapp.com " + test.addScreenCapture(screenShots.getScreenshot(driver, "herokuapp")));

		dynamicLoadPage.clickOnDynamicLoadingLink();
		test.log(LogStatus.INFO, " Open Dynamic Loading Page "
				+ test.addScreenCapture(screenShots.getScreenshot(driver, "dynamicLoader")));

		dynamicLoadPage.clickOnExample2Link();
		test.log(LogStatus.INFO,
				" Example 2 Element rendered " + test.addScreenCapture(screenShots.getScreenshot(driver, "example2")));

		dynamicLoadPage.clickOnStartBtn();
		test.log(LogStatus.INFO,
				"Loading Page Element  " + test.addScreenCapture(screenShots.getScreenshot(driver, "loadingElement")));

		dynamicLoadPage.validateRenderedElementText(propertiesReader.getValue("renderedElementText"));
	}
}