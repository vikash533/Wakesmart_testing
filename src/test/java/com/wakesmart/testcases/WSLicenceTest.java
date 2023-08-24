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
import com.wakesmart.pageObjects.WSLicence;
import com.wakesmart.pageObjects.WSManagement;

/*
Updated for the new UI by shreyas kumar
 										*/

public class WSLicenceTest extends BaseClass{
	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSManagement management;
	private WSLicence licence;

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
	
	@Test(priority = 0)
	public void managementLicences() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);
		licence = new WSLicence(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"));
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, licence.getLicence);
		
		softAssert.assertEquals(licence.getLicenceManagement.getText(),prop.getProperty("ManagementLicencesPageHeaderText"));
		softAssert.assertEquals(licence.getTableHeaderText.getText(),prop.getProperty("AutomationtabOwnerText"));
		softAssert.assertEquals(licence.tableTextVerify(),licence.tableTextVerifyFromLocal(prop));
		
		//Verify the count of the Licences
		licence.verifyCount();
		
		
		
		
		
		
		softAssert.assertAll();
	}
	
	

}
