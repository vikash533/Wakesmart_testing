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

/*
Updated as per the new UI **08**
 										*/
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

	@AfterClass(enabled=true)
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
		permission.getChoseUsers(prop.getProperty("ManagementAddNewPermissionGroup"));
		action.click(driver, permission.getAddNewPermissionGroupPopupText());
		action.JSClick(driver,permission.getEditGroupPermissionButton());
		action.scrollByVisibilityOfElement(driver, permission.getEditGroupPermissionGroupName());
		String editedGroupName = permission.getEditGroupPermissionGroupName().getText();
		System.out.println("----->"+editedGroupName);
		permission.clickEditGroupPermissionGroupNameCheckbox(driver);
		action.JSClick(driver, permission.getEditGroupPermissionCancelButton());
		action.JSClick(driver,permission.getEditGroupPermissionButton());
		action.scrollByVisibilityOfElement(driver, permission.getEditGroupPermissionGroupName());
		permission.clickEditGroupPermissionGroupNameCheckboxSingleTime(driver);
		action.JSClick(driver, permission.getEditGroupPermissionSaveButton());
		action.JSClick(driver, permission.getAddNewPermissionGroupSubmitButton());
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),prop.getProperty("CreatedMessageOnPopUp"));
		permission.PermissionGroupNameVerify(driver,prop.getProperty("ManagementPermissonGroupName"));
		action.fluentWait(driver, indexpage.getErrorMsg());
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ManagementPermissonGroupDeletePopup"));
		softAssert.assertAll();
		
		
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
