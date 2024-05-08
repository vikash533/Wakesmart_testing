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

/*
Updated as per the new UI **11**
 										*/
// Not completed

public class WSManagementDevicesTest extends BaseClass {
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

	@Test(priority = 0, groups = "test")
	public void devicesShowAndHideColumns() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		management = new WSManagement(driver);
		devices = new WSManagementDevices(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, devices.getManagementDevices());

		// Need to enable it after bug fixes
		softAssert.assertEquals(devices.getDevicesPageText().getText(),prop.getProperty("ManagementDevicesPageHeaderText"));
		softAssert.assertEquals(devices.getManagedSystemsText.getText(),prop.getProperty("ManagementManagedSystemsText"));

		action.fluentWait(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("GroupsManagementGroupReName")));
		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupsManagementGroupReName"));

		action.JSClick(driver, devices.getShowAndHideColumnsButton);
		Thread.sleep(5000);
		devices.uncheckAllCheckboxes();
		action.click(driver, devices.getSubmitButton);
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("UpdationPopupConfirmation"));
		action.click(driver, indexpage.getPopupCloseIcon());

//		Assert.assertFalse(devices.getTableHeader());
		devices.gettableHeaderTextVerify();

		action.JSClick(driver, devices.getShowAndHideColumnsButton);
		devices.checkAllCheckboxes();
		action.click(driver, devices.getSubmitButton);
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("UpdationPopupConfirmation"));
		action.click(driver, indexpage.getPopupCloseIcon());

//		Assert.assertTrue(devices.getTableHeader());

		softAssert.assertAll();
	}

	@Test(dependsOnMethods= "devicesShowAndHideColumns")
	public void devicesRightClickOnDeviceAndOptionsVerify() throws InterruptedException {

		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		management = new WSManagement(driver);
		devices = new WSManagementDevices(driver);

		action.fluentWait(driver, devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("GroupsManagementDefaultGroupTopWithOrg")));
		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupsManagementDefaultGroupTopWithOrg"));

		Thread.sleep(5000);
		devices.getDevicesListSelect(prop.getProperty("GroupManagementDeviceName"));

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

	@Test(dependsOnMethods = "devicesRightClickOnDeviceAndOptionsVerify")
	public void deviceSendMessage() throws InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		devices = new WSManagementDevices(driver);

		Assert.assertTrue(devices.selectOption("Send Message"));	

		softAssert.assertEquals(devices.getSendMesageToDevices().getText(),prop.getProperty("ManagementDevicesSendMessagePopUPText"));

		action.type(devices.getSendMessageInputField(), prop.getProperty("ManagementDevicesSendMessageInputFieild"));
		action.click(driver, devices.getSaveButton());
		Thread.sleep(1200);
		action.explicitWait(driver, indexpage.getErrorMsg(), 20);
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),prop.getProperty("ManagementDevicesSendMessageConfirmationPopup1"));
		action.click(driver, indexpage.getPopupCloseIcon());

		softAssert.assertAll();
	}
	@Test(dependsOnMethods = "deviceSendMessage",enabled=false)
	public void deviceWake() {
		
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		devices = new WSManagementDevices(driver);
		boolean devicePresent = devices.getDevicesList(prop.getProperty("GroupManagementDeviceName"));
		Assert.assertEquals(devicePresent, true);
		action.rightclick(driver, null);
		Assert.assertTrue(devices.selectOption("Wake"));
		softAssert.assertEquals(devices.getwakeSlectedDeviceText().getText(), prop.getProperty("ManagementDevicesDeviceWakeSelectedDevice"));
		action.JSClick(driver, devices.getwakeReasonforActionInputField());
		String attributValue = devices.getwakeReasonforActionInputField().getAttribute("value");
		System.out.println(attributValue);
	}


	@Test(dependsOnMethods = "deviceSendMessage")
	public void deviceAssignGroup() throws InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		devices = new WSManagementDevices(driver);
		Thread.sleep(3000);

		devices.getDevicesListSelect(prop.getProperty("GroupManagementDeviceName"));
		Thread.sleep(3000);
		Assert.assertTrue(devices.selectOption("Assign Group"),"DeviceSearching assign group text vefiy failed");

		softAssert.assertEquals(devices.groupSelectedDeviceHeaderText.getText(),prop.getProperty("ManagementDevicesSelectGroupHeaderText"));
		
		//To select Wake smart UI automation group from the dropdown
		Assert.assertTrue(devices.groupSelectForDevice(prop.getProperty("GroupManagementGroupAssign")));
		
		action.JSClick(driver, devices.getSaveButton());
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),prop.getProperty("ManagementDevicesSendMessageConfirmationPopup1"));
		action.click(driver, indexpage.getPopupCloseIcon());
		Thread.sleep(3000);
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupManagementGroupAssign"));
		Thread.sleep(3000);
		action.scrollToLeft(driver,"document.querySelector(\".MuiDataGrid-virtualScroller\").scrollLeft=1000000");
		action.fluentWait(driver, devices.groupNameVerify);
		softAssert.assertEquals(devices.groupNameVerify.getText(),prop.getProperty("GroupManagementGroupAssign"));
		
		softAssert.assertAll();
	}
	
	
	
	// Pending worked on 10/19/2023
	@Test(dependsOnMethods = "deviceAssignGroup",enabled = true)
	public void deviceAssignPolicy() throws InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		devices = new WSManagementDevices(driver);
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		devices.getDevicesListSelect(prop.getProperty("GroupManagementDeviceName"));
		Thread.sleep(3000);
		Assert.assertTrue(devices.selectOption("Assign Policy"),"DeviceSearching assign group text vefiy failed");
		Thread.sleep(3000);
		softAssert.assertEquals(devices.policySelectedDeviceHeaderText.getText(),prop.getProperty("DevicePolicyHeaderText"));
		
		//To select JumpGrowth (OTS Testing) group from the dropdown
		Assert.assertTrue(devices.policySelectDropdown(prop.getProperty("DevicePolicyAssign")),"AssingPolicyNotAssinged");
		action.fluentWait(driver, devices.getSaveButton());
		action.JSClick(driver, devices.getSaveButton());
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),prop.getProperty("ManagementDevicesSendMessageConfirmationPopup1"));
		action.click(driver, indexpage.getPopupCloseIcon());
		Thread.sleep(3000);
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		devices.getmanagedSystemsGroupSelection(prop.getProperty("GroupManagementGroupAssign"));
		Thread.sleep(3000);
		action.scrollToLeft(driver,"document.querySelector(\".MuiDataGrid-virtualScroller\").scrollLeft=1000000");
		action.fluentWait(driver, devices.groupNameVerify);
		softAssert.assertEquals(devices.policyNameVerify.getText(),prop.getProperty("DevicePolicyAssign"));
		
		softAssert.assertAll();

		
	}
	@Test(dependsOnMethods = "deviceAssignPolicy",enabled = true)
	public void deviceAssingLabel() throws InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		devices = new WSManagementDevices(driver);
		
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		devices.getDevicesListSelect1(prop.getProperty("GroupManagementDeviceAssing"));
		Thread.sleep(3000);
		Assert.assertTrue(devices.selectOption("Assign Label"),"DeviceSearching and assignLabel failed");
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
	
	@Test(dependsOnMethods = "deviceAssingLabel",enabled = true)
	public void searchDevice() {
		
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		devices = new WSManagementDevices(driver);
		
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesSearchDeviceName"));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesSearchIp_Address"));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesSearchOs_Version"));
		action.typeAndHitEnter(devices.searchFunctionality,prop.getProperty("ManagementDevicesSearchInvalidKeyword"));
			
	}
	@Test(dependsOnMethods= "searchDevice")
	public void dragAndDropColumnsOrder() throws InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		SoftAssert softAssert = new SoftAssert();
		devices = new WSManagementDevices(driver);
		
		action.JSClick(driver,devices.getmanagedSystemsGroupSelectionForWait(prop.getProperty("DefaulftGroupOnDevicesearchPage1")));
		action.draganddrop(driver, devices.deviceNameColumn, devices.macAddresColumn);
//		Thread.sleep(3000);
		action.draganddrop(driver, devices.deviceNameColumn, devices.ipAddress);
		Thread.sleep(3000);
		action.draganddrop(driver, devices.deviceNameColumn, devices.osVersion);
//		Thread.sleep(3000);
		action.draganddrop(driver, devices.deviceNameColumn, devices.osName);
//		Thread.sleep(3000);
		action.draganddrop(driver, devices.deviceNameColumn, devices.macAddresColumn);
		action.JSClick(driver, devices.saveColumnorder);
		
		
	}
	
	
	

}
