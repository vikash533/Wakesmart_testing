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

public class TestDevice1 extends BaseClass {
	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
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

	@AfterClass(enabled = true)
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void devicesRightClickOnDeviceAndOptionsVerify() throws InterruptedException {

		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		management = new WSManagement(driver);
		devices = new WSManagementDevices(driver);
		
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, devices.getManagementDevices());

		action.fluentWait(driver, devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("GroupsManagementDefaultGroupTopWithOrg")));
		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupsManagementDefaultGroupTopWithOrg"));

		Thread.sleep(5000);
		devices.getDevicesListSelect2(prop.getProperty("GroupManagementDeviceName"));

		Thread.sleep(2000);
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ManagementDevicesToasterText"));

		Thread.sleep(2000);
		action.click(driver, indexpage.getPopupCloseIcon());
		Thread.sleep(2000);
		boolean devicePresent = devices.getDevicesList(prop.getProperty("GroupManagementDeviceName"));

		Assert.assertEquals(devicePresent, true);

		//Commented for now
		softAssert.assertEquals(devices.getRightClickOptionVerify(), devices.getRightClickOptionVerifyText(),"Mis match in the options of device right click");

		softAssert.assertAll();
	}

}
