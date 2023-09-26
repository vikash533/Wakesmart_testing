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
import com.wakesmart.pageObjects.WSPermissionManagement;

//In progress  ---- Pending Page is loading Data as on 26/09/2023

public class WSPermissionManagementTest  extends BaseClass{

	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSManagement management;
	private WSPermissionManagement permission;
	
	@BeforeClass
	public void browserLaunch()  {
		try {
			driver = launchBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}

	@AfterClass(enabled=false)
	public void tearDown() {
	        driver.quit();
	}
	
	@Test(priority=1 ,groups= {"smoke"})
	public void managementPermissions() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);
		permission = new WSPermissionManagement(driver);
		
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
	
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, permission.getPermission);
		
		softAssert.assertEquals(permission.getPermissionPageText.getText(),prop.getProperty("ManagementPermissonPageHeaderText"));
		softAssert.assertEquals(permission.getPermissionTableHeaderText.getText(),prop.getProperty("AutomationtabOwnerText"));
		softAssert.assertEquals(permission.tableTextVerify(),permission.tableTextVerifyFromLocal(prop));
		
		action.click(driver, permission.getNewPermissionGroupButton);
		softAssert.assertEquals(permission.getAddNewPermissionGroupPopupText.getText(),prop.getProperty("ManagementAddNewPermissionGroupPopupText"));
		
		action.type(permission.getGroupName, prop.getProperty("ManagementPermissonGroupName"));
		action.type(permission.getGroupDescription, prop.getProperty("ManagementPermissonGroupDescrption"));
		
		
		//Verify the text of admin roles
		softAssert.assertEquals(permission.adminRolesTextVerify(),permission.adminRolesTextVerifyData(prop));
		
		action.click(driver, permission.getorgAdminCheckBox());
		action.click(driver, permission.getchooseUsersDropdown());
		
		// pending
		
		
		softAssert.assertAll();
		
		
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
