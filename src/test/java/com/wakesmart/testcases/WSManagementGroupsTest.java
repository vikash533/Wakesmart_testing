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

public class WSManagementGroupsTest extends BaseClass {

	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSManagement management;
	
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
	
	@Test
	public void managementGroups() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"));
		
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, management.getGroups());
		
		softAssert.assertEquals(management.getPolicyManagement(),prop.getProperty("GroupsManagementHeaderText"));
		softAssert.assertEquals(management.getPolicyManagementTableHeaderText(),prop.getProperty("GroupsManagementInnerTableHeaderText"));
		action.JSClick(driver, management.getAddGroupButton());
		action.type(management.getPolicyName(), prop.getProperty("GroupsManagementGroupName"));
		action.type(management.getPolicyDescription(), prop.getProperty("GroupsManagementGroupDescription"));
		action.JSClick(driver, management.getIsParentCheckBox());
		action.click(driver, management.getAddNewPolicySubmitButton());
		
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("GroupsManagementGroupCretaedSuccessMessage"));
		
		action.click(driver, indexpage.getPopupCloseIcon());
		
		Thread.sleep(2000);
		
		String groupName =action.nameVerifyFromTable(management.getGroupCreatedNameVerify(), prop.getProperty("GroupsManagementGroupName"));
		
		softAssert.assertEquals(groupName,prop.getProperty("GroupsManagementGroupName"));
		
		boolean result = false;
		
		if (groupName.equalsIgnoreCase(prop.getProperty("GroupsManagementGroupName"))) {
			result = management.nameVerifyFromTableAndMouseHover(driver, groupName);
		}
		
		softAssert.assertEquals(result,true);
		
		boolean editGroup=false;
		
		if(result==true) {
				action.type(management.getPolicyName(), prop.getProperty("GroupsManagementGroupReName"));
				management.getIsParentCheckBox().click();
				action.click(driver, management.getParentGroupDropDown());
				action.getSelectOptionFromDropdown(management.getParentGroupDropDownList(), prop.getProperty("GroupsManagementDefaultGroupTop"));
				action.click(driver, management.getAddNewPolicySubmitButton());
				action.fluentWait(driver, indexpage.getErrorMsg());
				softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("GroupsManagementGroupUpdatedSuccessMessage"));
				action.click(driver, indexpage.getPopupCloseIcon());
				editGroup=true;
		}
		
		boolean resultOfTop = false;
		if(editGroup==true) {
			action.click(driver, management.getArrowDownInTable());
			
			resultOfTop =management.nameVerifyFromTableAndMouseHoverAfterRename(driver, prop.getProperty("GroupsManagementGroupReName"));
			}
		
		softAssert.assertEquals(resultOfTop,true);
		
		
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
