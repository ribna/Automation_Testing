package test;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenShots {
	/**
	 * Captures and embeds screenshot in generated HTML report. Reports can be found
	 * in directory.
	 * 
	 * @param directory   takes the screenshot directory path
	 * @param SourceFile  holds the screen shot reference
	 * @param destination save the screen shot at desired path
	 * @return destination captured file path
	 */

	public static String getScreenshot(WebDriver driver, String fileName) throws Exception {

		fileName = fileName + ".png";
		String directory = propertiesReader.getValue("screenshotDirectory");
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Save Image at destination
		FileHandler.copy(SourceFile, new File(directory + fileName));
		String destination = directory + fileName;
		// return the path where the screen shot is saved
		return destination;
	}
}
