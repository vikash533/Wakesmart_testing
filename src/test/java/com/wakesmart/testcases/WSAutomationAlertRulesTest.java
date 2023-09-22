package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSAutomationPage;

/*
Updated for the new UI by shreyas kumar
 										*/

public class WSAutomationAlertRulesTest extends BaseClass{

	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSAutomationPage automation;
	
	@BeforeClass
	public void browserLaunch() {
		try {
			driver = launchBrowser();
			driver.get(prop.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(enabled = true)
	public void tearDown() {
			driver.quit();
	}
	
	@Test
	public void newAutomationAlertRules() throws IOException, InterruptedException {
		automation= new WSAutomationPage(driver);
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		
		action.JSClick(driver, automation.getAutomationTab());
		softAssert.assertEquals(automation.getAutomationTextInnerTab(), prop.getProperty("AutomationTabInnerText"),"Mismatch in automation Jims LLC");
		softAssert.assertEquals(automation.getAutomationTableHeader(), automation.getgetAutomationTableHeaderDataToVerify(prop)," Mismatch automation table header text");
		
		action.JSClick(driver, automation.getAlertRules());
		
		softAssert.assertEquals(automation.getAlertRulesContent(),prop.getProperty("AlertRulesContent")," Mismatch alert policy rules content");
	
		softAssert.assertAll();
	}
	
	
}
