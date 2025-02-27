package com.wakesmart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver launchBrowser() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\Config.Properties");
		FileInputStream fis1 = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\Configuration.Properties");

		prop = new Properties();
		prop.load(fis);
		prop.load(fis1);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}    

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destinationFile = (System.getProperty("user.dir") + "\\reports\\screenshot\\" + testCaseName + ".png");
		FileUtils.copyFile(source, new File(destinationFile));

		return destinationFile;

	}

}
