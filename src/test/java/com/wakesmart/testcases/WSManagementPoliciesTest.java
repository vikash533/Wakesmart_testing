package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSManagement;

// Updated as per the new UI


public class WSManagementPoliciesTest extends BaseClass{

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
	
	@Test(priority=1)
	public void managementPolicies() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"));
		
		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, management.getPolicies());
		softAssert.assertEquals(management.getPolicyManagement(),prop.getProperty("PoliciesManagementHeaderText"));
		softAssert.assertEquals(management.getPolicyManagementTableHeaderText(),prop.getProperty("PoliciesManagementTableHeaderText"));
		softAssert.assertEquals(management.getTableHeaderTextVerify(management.PoliciesInnerTableHeaderText()), management.getPoliciesTableHeaderDataToVerify(prop)," Mismatch automation table header text");
		action.JSClick(driver, management.getAddPolicyBtn());
		action.type(management.getPolicyName(), prop.getProperty("PoliciesManagementPolicyName"));
		action.type(management.getPolicyDescription(), prop.getProperty("PoliciesManagementPolicyDescription"));
		
		
		action.click(driver, management.getDefaultPolicyDeleteButton());
		action.fluentWait(driver, management.getWarningMessegePopupOnDeleteDefaultScheme());
		softAssert.assertEquals(management.getWarningMessegePopupOnDeleteDefaultScheme().getText(), prop.getProperty("PoliciesManagementPoliciesWarningMessegePopupOnDeleteDefaultScheme"));
		
		action.JSClick(driver, management.getAddSchemeButton());
		
		action.type(management.getNewSchemeName(), prop.getProperty("PoliciesManagementNewSchemeName"));
		action.type(management.getNewSchemeDescription(),prop.getProperty("PoliciesManagementNewSchemeDescription"));
		management.getSelectDaysCheckbox();
		action.type(management.getNewSchemeStartTime(), prop.getProperty("PoliciesManagementPoliciesNewSchemeStartTime"));
		action.keyBoardKeys(driver, Keys.ARROW_DOWN);
		action.type(management.getNewSchemeEndTime(), prop.getProperty("PoliciesManagementPoliciesNewSchemeEndTime"));
		action.keyBoardKeys(driver, Keys.ARROW_DOWN);
		management.KeyBoardAction(2);
		softAssert.assertEquals(management.getVerifyTimeIntervalDropdownContent(), management.getVerifyTimeIntervalDropdownContentList(prop), "Missmatch in dropdown content");
		action.getSelectOptionFromDropdown(management.getDisplayInactivityDropdown(), prop.getProperty("PoliciesManagementDisplayInactivityTimeOutAC"));
		management.KeyBoardAction(1);
		softAssert.assertEquals(management.getVerifyTimeIntervalDropdownContent(), management.getVerifyTimeIntervalDropdownContentList(prop), "Missmatch in dropdown content");
		action.getSelectOptionFromDropdown(management.getDisplayInactivityDropdown(), prop.getProperty("PoliciesManagementDisplayInactivityTimeOutDC"));
		management.KeyBoardAction(1);
		softAssert.assertEquals(management.getVerifyTimeIntervalDropdownContent(), management.getVerifyTimeIntervalDropdownContentList(prop), "Missmatch in dropdown content");
		action.getSelectOptionFromDropdown(management.getDisplayInactivityDropdown(), prop.getProperty("PoliciesManagementDisplayInactivityTimeOutDC"));
		management.KeyBoardAction(1);
		softAssert.assertEquals(management.getVerifyTimeIntervalDropdownContent(), management.getVerifyTimeIntervalDropdownContentList(prop), "Missmatch in dropdown content");
		action.getSelectOptionFromDropdown(management.getDisplayInactivityDropdown(), prop.getProperty("PoliciesManagementDisplayInactivityTimeOutDC"));
		management.KeyBoardAction(1);
		action.getSelectOptionFromDropdown(management.getUSBSleepONAC(), prop.getProperty("PoliciesManagementDropDownOptionDisabled"));
		
		management.KeyBoardAction(1);
		action.getSelectOptionFromDropdown(management.getUSBSleepONAC(), prop.getProperty("PoliciesManagementDropDownOptionDisabled"));
		management.KeyBoardAction(1);
		action.getSelectOptionFromDropdown(management.getUSBSleepONAC(), prop.getProperty("PoliciesManagementDropDownOptionDisabled"));
		management.KeyBoardAction(1);
		action.getSelectOptionFromDropdown(management.getUSBSleepONAC(), prop.getProperty("PoliciesManagementDropDownOptionDisabled"));
		management.KeyBoardAction(1);
		action.getSelectOptionFromDropdown(management.getUSBSleepONAC(), prop.getProperty("PoliciesManagementDropDownOptionEnabled"));
		
		action.type(management.getCPUMax(), prop.getProperty("PoliciesManagementCPUMax"));
		action.type(management.getDiskMax(), prop.getProperty("PoliciesManagementPoliciesDiskMax"));
		action.type(management.getNetworkMax(), prop.getProperty("PoliciesManagementPoliciesNetworkMax"));
		action.type(management.getScreenDim(), prop.getProperty("PoliciesManagementPoliciesScreenDim"));
		action.type(management.getBrightness(), prop.getProperty("PoliciesManagementPoliciesBrightness"));
		action.click(driver, management.getAddNewSchemeSaveButton());
		
		softAssert.assertEquals(management.getNewSchemeNameVerifyText(), prop.getProperty("PoliciesManagementNewSchemeName"));
		softAssert.assertEquals(management.getNewSchemeDaysVerifyText(), prop.getProperty("PoliciesManagementNewSchemeDayVerifyText"));
		softAssert.assertEquals(management.getNewSchemeStartTimeVerifyText(), prop.getProperty("PoliciesManagementPoliciesNewSchemeStartTimeVerifyText"));
		softAssert.assertEquals(management.getNewSchemeEndTimeVerifyText(), prop.getProperty("PoliciesManagementPoliciesNewSchemeEndTimeVerifyText"));
		
		softAssert.assertEquals(management.getNewDefaultSchemeNameVerifyText().getText(), prop.getProperty("PoliciesManagementDefaultSchemeName"));
		softAssert.assertEquals(management.getDefaultSchemeDaysVerifyText().getText(), prop.getProperty("PoliciesManagementDefaultSchemeDayVerifyText"));
		softAssert.assertEquals(management.getDefaultSchemeStartTimeVerifyText().getText(), prop.getProperty("PoliciesManagementPoliciesDefaultSchemeStartTimeVerifyText"));
		softAssert.assertEquals(management.getDefaultSchemeEndTimeVerifyText().getText(), prop.getProperty("PoliciesManagementPoliciesDefaultSchemeEndTimeVerifyText"));
		
		//new scheduled events
		action.click(driver, management.getScduledEventAddButton());
		management.getScheduledDays();
		
		management.getEventSelector();
		action.getSelectOptionFromDropdown(management.getEventSelectorDropDownList(), prop.getProperty("PoliciesManagementScheduledEventSelector"));
		action.type(management.getEventStartTime(), prop.getProperty("PoliciesManagementPoliciesNewSchemeStartTime"));
		action.keyBoardKeys(driver, Keys.ARROW_DOWN);
		action.type(management.getEventStartPreWarningTime(), prop.getProperty("PoliciesScheduledEventStartPreWarningTime"));
		action.type(management.getEventStartDelayTime(), prop.getProperty("PoliciesScheduledEventStartDelayTime"));
		action.type(management.getEventStartMessege(), prop.getProperty("PoliciesScheduledEventStartMessege"));
		action.click(driver, management.getEventStartSaveButton());
		softAssert.assertEquals(management.getScheduledEventNameTextVerify(), prop.getProperty("PoliciesManagementScheduledEventSelector"));
		softAssert.assertEquals(management.getScheduledEventdaysTextVerify(), prop.getProperty("PoliciesManagementNewSchemeDayVerifyText"));
		softAssert.assertEquals(management.getScheduledEventStartTextVerify(), prop.getProperty("PoliciesManagementPoliciesNewSchemeStartTimeVerifyText"));
		
		action.click(driver, management.getScduledEventAddButton());
		management.getScheduledDays();
		action.click(driver, management.getScheduledEventCancelButton());
		action.click(driver, management.getAddNewPolicySubmitButton());
		
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("CreatedMessageOnPopUp"));
		
		String rulesCreated = action.nameVerifyFromTable(management.getPolicyNameVerify(), prop.getProperty("PoliciesManagementPolicyName"));
		String rulesCreatedDescription = action.nameVerifyFromTable(management.getPolicyDescriptionVerify(), prop.getProperty("PoliciesManagementPolicyDescription"));
		
		softAssert.assertEquals(rulesCreated, prop.getProperty("PoliciesManagementPolicyName"));
		softAssert.assertEquals(rulesCreatedDescription, prop.getProperty("PoliciesManagementPolicyDescription"));
		
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
