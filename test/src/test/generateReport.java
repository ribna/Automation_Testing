package test;

import com.relevantcodes.extentreports.ExtentReports;

public class generateReport {
	/**
	 * This method return the ExtentReports.
	 * 
	 * @param path get the report path
	 * @return return the report path
	 */

	public static ExtentReports getInstance() throws Exception {
		ExtentReports extent;
		String path = propertiesReader.getValue("reportPath");
		extent = new ExtentReports(path, false);
		extent.addSystemInfo("Selenium version", "4.0.0").addSystemInfo("Platform", "Windows");
		return extent;
	}
}
