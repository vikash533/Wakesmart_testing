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


/*
Updated as per the new UI **10**
 										*/
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

	@AfterClass(enabled=true)
	public void tearDown() {
	        driver.quit();
	}
	
	@Test
	public void managementGroups() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		
		action.JSClick(driver, management.getManagementTab());
 		action.JSClick(driver, management.getGroups());
		
		softAssert.assertEquals(management.getPolicyManagement(),prop.getProperty("GroupsManagementHeaderText"));
		softAssert.assertEquals(management.getPolicyManagementTableHeaderText(),prop.getProperty("GroupsManagementInnerTableHeaderText"));
		action.JSClick(driver, management.getAddGroupButton());
		action.type(management.getPolicyName(), prop.getProperty("GroupsManagementGroupName"));
		action.type(management.getPolicyDescription(), prop.getProperty("GroupsManagementGroupDescription"));
//		action.JSClick(driver, management.getIsParentCheckBox());
		action.click(driver, management.getParentGroupDropDown());
		action.getSelectOptionFromDropdown(management.getParentGroupDropDownList(), prop.getProperty("GroupsManagementDefaultGroupTop"));
		
//		action.fluentWait(driver, management.getAddNewPolicySubmitButton());
		action.JSClick(driver, management.getAddNewPolicySubmitButton());
		
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("GroupsManagementGroupCretaedSuccessMessage"));
		
		action.click(driver, indexpage.getPopupCloseIcon());
		
		Thread.sleep(2000);
		String GroupNameWithDescription = prop.getProperty("GroupsManagementGroupName")+ " - "+ prop.getProperty("GroupsManagementGroupDescription");
		String groupName =action.nameVerifyFromTable(management.getGroupCreatedNameVerify(), GroupNameWithDescription);
		System.out.println(groupName);
		softAssert.assertEquals(groupName,GroupNameWithDescription);
		boolean result = false;
		if (groupName.equalsIgnoreCase(GroupNameWithDescription)) {
			result = management.nameVerifyFromTableAndMouseHover(driver, groupName);

		}
		Assert.assertEquals(result,true);
		
		action.type(management.getPolicyName(), prop.getProperty("GroupsManagementGroupReName"));
		action.type(management.getPolicyDescription(), prop.getProperty("GroupsManagementGroupDescription"));
//		management.getIsParentCheckBox().click();
		action.click(driver, management.getParentGroupDropDown());
		action.getSelectOptionFromDropdown(management.getParentGroupDropDownList(), prop.getProperty("GroupsManagementDefaultGroupTop"));
		action.click(driver, management.getAddNewPolicySubmitButton());
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("GroupsManagementGroupUpdatedSuccessMessage"));
		action.click(driver, indexpage.getPopupCloseIcon());
		action.click(driver, management.getArrowDownInTable());
		
		boolean	resultOfTop =management.nameVerifyFromTableAndMouseHoverAfterRename(driver, prop.getProperty("GroupsManagementGroupReName")+" - "+prop.getProperty("GroupsManagementGroupDescription"));
		
		softAssert.assertEquals(resultOfTop,true);
		
		softAssert.assertAll();
	}
}
