package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSManagement;
import com.wakesmart.pageObjects.WSManagementDevices;

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

	@Test(priority = 0)
	public void managementDevices() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);
		devices = new WSManagementDevices(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"));
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, devices.getManagementDevices());
//		softAssert.assertEquals(devices.getDevicesPageText().getText(),prop.getProperty("ManagementDevicesPageHeaderText"));
//		softAssert.assertEquals(devices.getManagedSystemsText.getText(),prop.getProperty("ManagementManagedSystemsText"));
		Thread.sleep(10000);
		for(WebElement ele : driver.findElements(By.xpath("//div[@class='ag-header-viewport ']//div/div/div/div[3]/div/div/span"))) {
			System.out.println(ele.getText());
		}
		Thread.sleep(5000);
		action.JSClick(driver, devices.getShowAndHideColumnsButton);
		devices.uncheckCheckbox();
		action.JSClick(driver, devices.getEditDeviceOrderColumnsSaveButton);
		action.fluentWait(driver, devices.getPopUpMessage);
		softAssert.assertEquals(devices.getPopUpMessage.getText(),prop.getProperty("UpdationPopupConfirmation"));
		
		
	////div[@class='ag-header-viewport ']//div/div/div/div[3]/div/div/span
		////div[@class='ag-cell-label-container']//div/span
		
		
		for(WebElement ele : driver.findElements(By.xpath("//div[@class='ag-header-viewport ']//div/div/div/div[3]/div/div/span"))) {
			System.out.println(ele.getText());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		softAssert.assertAll();
	}
}
