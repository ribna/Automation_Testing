# Automation_Testing 
This repository contains samples for automation test cases. This project created by using selenium webdriver framework.
Theis project is implemented by using the POM design hence it contains  pages and test scripts. 
data.properties file contains all external data.

following data should be changed in data.properties file according to local environment 

chromeBrowserPath =D:\\Webdriver\\chromedriver_win32\\chromedriver.exe
reportPath =D:\\TestReport\\automation_report.html
screenshotDirectory = D:\\TestReport\\
imageFilePath = C:/Users/Reeshan/Pictures/nature.jpg



**Test Case 1**: 

Google Search (verifyGoogleTestResult.java)
To execute verifyGoogleTestResult.java below data derived from data.properties file,

googleUrl =  https://www.google.com/ncr
searchText = Selenium Webdriver
expectedThirdResult = What is Selenium WebDriver?
chromeBrowserPath =D:\\Webdriver\\chromedriver_win32\\chromedriver.exe

**Test Case 2**: 

File loading (verifyFileUpload.java)
To execute verifyFileUpload.java below data derived from data.properties file,

fileLoadUrl = https://the-internet.herokuapp.com/
renderedElementText = Hello World!


