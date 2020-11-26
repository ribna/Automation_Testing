package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class propertiesReader {

	/**
	 * This method gets the external data which stored in the properties file
	 * 
	 * @param flie get the data properties file path
	 * @return return the property with specified key
	 */

	public static String getValue(String key) throws Exception {

		File file = new File("D:/Eclipse/Eclipse-Workspace/test/data.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
}
