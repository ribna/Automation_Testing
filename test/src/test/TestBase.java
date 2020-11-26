package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver = null;
	ExtentTest test;
	ExtentReports report;

	/**
	 * @BeforeClass Start the Report. Launch the Chrome browser and maximize the
	 *              window
	 */

	@BeforeClass
	public void setup() throws Exception {

		report = generateReport.getInstance();
		test = report.startTest("Test Case");
		// set the location of chrome browser
		System.setProperty("webdriver.chrome.driver", propertiesReader.getValue("chromeBrowserPath"));
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser Started");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Screen Maximized");
	}

	/**
	 * @AfterMethod Get the method result and report with screen shot
	 * @param path
	 * @param imagePath
	 */
	@AfterMethod
	public void getResult(ITestResult testResult) throws Exception {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = screenShots.getScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Display Failed Test Case Message" + testResult.getThrowable());
			// Display the Error Failed Message
			test.log(LogStatus.FAIL, testResult.getThrowable());
			test.log(LogStatus.FAIL, "Test Failed" + imagePath);
		} else {

			test.log(LogStatus.INFO, "Test Passed Successfully");
		}
	}

	@AfterClass
	public void teardown() {
		// closing the webdriver
		TestBase.driver.quit();
		report.endTest(test);
		report.flush();
	}
}
