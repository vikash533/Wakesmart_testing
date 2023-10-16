package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSManagement;
import com.wakesmart.pageObjects.WSManagementDevices;

// Not completed

public class WSManagementDevicesTest extends BaseClass {
	public WebDriver driver; 
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSManagement management;
	private WSManagementDevices devices;

	@BeforeClass
	public void browserLaunch() {
		try {
			driver = launchBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}

	@AfterClass(enabled = false)
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 0,groups = "test")
	public void managementDevices() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);
		devices = new WSManagementDevices(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, devices.getManagementDevices());
		
		//Need to enable it after bug fixes
//		softAssert.assertEquals(devices.getDevicesPageText().getText(),prop.getProperty("ManagementDevicesPageHeaderText"));
		softAssert.assertEquals(devices.getManagedSystemsText.getText(),prop.getProperty("ManagementManagedSystemsText"));
				
		action.fluentWait(driver, devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("GroupsManagementGroupReName")));
		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupsManagementGroupReName"));
		
		action.JSClick(driver, devices.getShowAndHideColumnsButton);
		Thread.sleep(5000);
		devices.uncheckAllCheckboxes();
		action.click(driver, devices.getSubmitButton);
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("UpdationPopupConfirmation"));
		action.click(driver, indexpage.getPopupCloseIcon());
		
//		Assert.assertFalse(devices.getTableHeader());
		devices.gettableHeaderTextVerify();
		
		action.JSClick(driver, devices.getShowAndHideColumnsButton);
		devices.checkAllCheckboxes();
		action.click(driver, devices.getSubmitButton);
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("UpdationPopupConfirmation"));
		action.click(driver, indexpage.getPopupCloseIcon());
		
		
//		Assert.assertTrue(devices.getTableHeader());
		
		// click on the JIMs LLC
		action.fluentWait(driver, devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("GroupsManagementDefaultGroupTopWithOrg")));
		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupsManagementDefaultGroupTopWithOrg"));
		
		
		boolean devicePresent = devices.getDevicesList(prop.getProperty("GroupManagementDeviceName"));
		
		Assert.assertEquals(devicePresent, true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		softAssert.assertAll();
	}
	
	
	
	
}
