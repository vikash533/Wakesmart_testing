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
import com.wakesmart.pageObjects.WSHomePage;
import com.wakesmart.pageObjects.WSManagement;
import com.wakesmart.pageObjects.WSManagementDevices;

public class TestDevice extends BaseClass {
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
//	@Test(priority = 0, groups = "test")
//	public void devicesShowAndHideColumns() throws IOException, InterruptedException {
//		indexpage = new IndexPage(driver);
//		action = new Action();
//		SoftAssert softAssert = new SoftAssert();
//		management = new WSManagement(driver);
//		devices = new WSManagementDevices(driver);
//
//		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
//		action.JSClick(driver, management.getManagementTab());
//		action.JSClick(driver, devices.getManagementDevices());
//
//		// Need to enable it after bug fixes
//		softAssert.assertEquals(devices.getDevicesPageText().getText(),prop.getProperty("ManagementDevicesPageHeaderText"));
//		softAssert.assertEquals(devices.getManagedSystemsText.getText(),prop.getProperty("ManagementManagedSystemsText"));
//
//		action.fluentWait(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("GroupsManagementGroupReName")));
//		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupsManagementGroupReName"));
//
//		action.JSClick(driver, devices.getShowAndHideColumnsButton);
//		Thread.sleep(5000);
//		devices.uncheckAllCheckboxes();
//		action.click(driver, devices.getSubmitButton);
//		action.fluentWait(driver, indexpage.getErrorMsg());
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("UpdationPopupConfirmation"));
//		action.click(driver, indexpage.getPopupCloseIcon());
//
////		Assert.assertFalse(devices.getTableHeader());
//		devices.gettableHeaderTextVerify();
//
//		action.JSClick(driver, devices.getShowAndHideColumnsButton);
//		devices.checkAllCheckboxes();
//		action.click(driver, devices.getSubmitButton);
//		action.fluentWait(driver, indexpage.getErrorMsg());
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("UpdationPopupConfirmation"));
//		action.click(driver, indexpage.getPopupCloseIcon());
//
////		Assert.assertTrue(devices.getTableHeader());
//
//		softAssert.assertAll();
//	}
//
//	@Test(dependsOnMethods= "devicesShowAndHideColumns")
//	public void devicesRightClickOnDeviceAndOptionsVerify() throws InterruptedException {
//
//		indexpage = new IndexPage(driver);
//		action = new Action();
//		SoftAssert softAssert = new SoftAssert();
//		management = new WSManagement(driver);
//		devices = new WSManagementDevices(driver);
//
//		action.fluentWait(driver, devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("GroupsManagementDefaultGroupTopWithOrg")));
//		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupsManagementDefaultGroupTopWithOrg"));
//
//		Thread.sleep(5000);
//		devices.getDevicesListSelect(prop.getProperty("GroupManagementDeviceName"));
//
//		Thread.sleep(2000); 
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ManagementDevicesToasterText"));
//
//		Thread.sleep(2000);
//		action.click(driver, indexpage.getPopupCloseIcon());
//		Thread.sleep(2000);
//		boolean devicePresent = devices.getDevicesList(prop.getProperty("GroupManagementDeviceName"));
//
//		Assert.assertEquals(devicePresent, true);
//
//		//Commented for now
//		softAssert.assertEquals(devices.getRightClickOptionVerify(), devices.getRightClickOptionVerifyText(),"Mis match in the options of device right click");
//
//		softAssert.assertAll();
//	}
	@Test
	public void deviceAssingLabel() throws InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		management = new WSManagement(driver);
		devices = new WSManagementDevices(driver);
		
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, devices.getManagementDevices());

		
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		devices.getDevicesListSelect1(prop.getProperty("GroupManagementDeviceName"));
		Thread.sleep(3000);
		Assert.assertTrue(devices.selectOption("Assign Label"),"DeviceSearching and assignLabel failed");
		Thread.sleep(3000);
		softAssert.assertEquals(devices.deviceClientLabel.getText(),prop.getProperty("ManagementDeviceClientLabel"));
		action.type(devices.deviceClientLabeltextField,prop.getProperty("ManagementDevicesDeviceClientLabeltextfield"));
		action.JSClick(driver, devices.getSaveButton());
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),prop.getProperty("ManagementDevicesSendMessageConfirmationPopup1"));
		action.click(driver, indexpage.getPopupCloseIcon());
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesDeviceClientLabeltextfield"));
		softAssert.assertAll();
		
		
	}
@Test
public void searchDevice() {
		
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		management = new WSManagement(driver);
		devices = new WSManagementDevices(driver);
		
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, devices.getManagementDevices());

		
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesSearchDeviceName"));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesSearchIp_Address"));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesSearchOs_Version"));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesSearchInvalidKeyword"));
			
	}
@Test
public void dragAndDropColumnsOrder() throws InterruptedException {
	indexpage = new IndexPage(driver);
	action = new Action();
	SoftAssert softAssert = new SoftAssert();
	management = new WSManagement(driver);
	devices = new WSManagementDevices(driver);
	
	indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
	action.JSClick(driver, management.getManagementTab());
	action.JSClick(driver, devices.getManagementDevices());

	
	action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
	action.draganddrop(driver, devices.deviceNameColumn, devices.macAddresColumn);
//	Thread.sleep(3000);
	action.draganddrop(driver, devices.deviceNameColumn, devices.ipAddress);
	Thread.sleep(3000);
	action.draganddrop(driver, devices.deviceNameColumn, devices.osVersion);
//	Thread.sleep(3000);
	action.draganddrop(driver, devices.deviceNameColumn, devices.osName);
//	Thread.sleep(3000);
	action.draganddrop(driver, devices.deviceNameColumn, devices.macAddresColumn);
	action.JSClick(driver, devices.saveColumnorder);
	
	
}
@Test
public void deviceWake() throws InterruptedException {
	
	indexpage = new IndexPage(driver);
	action = new Action();
	SoftAssert softAssert = new SoftAssert();
	management = new WSManagement(driver);
	devices = new WSManagementDevices(driver);
	indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
	action.JSClick(driver, management.getManagementTab());
	action.JSClick(driver, devices.getManagementDevices());
	boolean devicePresent = devices.getDevicesList(prop.getProperty("GroupManagementDeviceName"));
	Assert.assertEquals(devicePresent, true);
//	action.rightclick(driver, null);
	Assert.assertTrue(devices.selectOption("Wake"));
	softAssert.assertEquals(devices.getwakeSlectedDeviceText().getText(), prop.getProperty("ManagementDevicesDeviceWakeSelectedDevice"));
	action.JSClick(driver, devices.getwakeReasonforActionInputField());
//	String attributValue = devices.getwakeReasonforActionInputField().getAttribute("value");
//	System.out.println(attributValue);
	action.typeAndHitEnter(devices.getwakeReasonforActionInputField(), "Wake Test for Users ");
	action.click(driver, devices.getclickSaveButton());
	Thread.sleep(1200);
	action.explicitWait(driver, indexpage.getErrorMsg(), 20);
	softAssert.assertEquals(indexpage.getErrorMsg().getText(),prop.getProperty("ManagementDevicesSendMessageConfirmationPopup1"));
	action.click(driver, indexpage.getPopupCloseIcon());
	softAssert.assertAll();
	
	
	
}

}
