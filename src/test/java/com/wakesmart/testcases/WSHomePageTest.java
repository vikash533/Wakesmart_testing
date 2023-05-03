package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.WSHomePage;
import com.wakesmart.pageObjects.IndexPage;

public class WSHomePageTest extends BaseClass {
	
	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSHomePage homepage;
	
	@BeforeClass
	public void browserLaunch()  {
		try {
			driver = launchBrowser();
			driver.get(prop.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(enabled=true)
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	@Test(priority=1)
	public void HomePageValidation() throws InterruptedException {
		homepage = new  WSHomePage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		indexpage = new IndexPage(driver);
		
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"));
		
		try {
			action.click(driver, homepage.getMenuButton());
			Thread.sleep(3000);
			//action.explicitWait(driver, homepage.getGeneralMenu(), 5);
			softAssert.assertFalse(homepage.getGeneralMenu().isDisplayed());
			action.click(driver, homepage.getMenuButton());
			action.explicitWait(driver, homepage.getGeneralMenu(), 3);
			softAssert.assertTrue(homepage.getGeneralMenu().isDisplayed());
		
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
