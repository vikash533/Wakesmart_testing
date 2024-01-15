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
import com.wakesmart.pageObjects.WSManagement;
import com.wakesmart.pageObjects.WSOrganization;

//Completed as per the new UI

//Deleted on the new UI

public class WSManagementOrganizationTest extends BaseClass{
	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSManagement management;
	private WSOrganization organization;

	@BeforeClass
	public void browserLaunch() {
		try {
			driver = launchBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}

	@AfterClass(enabled = true)
	public void tearDown() {
		driver.quit();
	}
	
	@Test(enabled = false)
	public void managementOrganization() {
		indexpage = new IndexPage(driver);
		action = new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);
		organization = new WSOrganization(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, organization.getOrganizations);
			
		softAssert.assertEquals(organization.getOrganizationsPageText.getText(),prop.getProperty("ManagementOrganizationsPageHeaderText"));
		softAssert.assertEquals(organization.getOrganizationsTableHeaderText.getText(),prop.getProperty("AutomationtabOwnerText"));
		softAssert.assertEquals(organization.tableTextVerify(),organization.tableTextVerifyFromLocal(prop));
		
		
		
		
		softAssert.assertAll();
	}
	
	
	
	
}
