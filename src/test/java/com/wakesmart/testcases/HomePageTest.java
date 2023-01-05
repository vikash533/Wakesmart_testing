package com.wakesmart.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.About;
import com.wakesmart.pageObjects.Automation;
import com.wakesmart.pageObjects.HomePage;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.Manage;
import com.wakesmart.pageObjects.Reporting;
import com.wakesmart.pageObjects.User;
import com.wakesmart.pageObjects.Settings;


public class HomePageTest extends BaseClass {

	public WebDriver driver;
	public Action action;
	private HomePage homepage;
	private IndexPage indexpage;
	private User user;
	private About about;
	private Reporting reporting;
	private Manage manage;
	private Automation automation;
	private Settings settings;
	SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	public void browserLaunch() throws IOException {
		driver = launchBrowser();
		driver.get(prop.getProperty("url"));
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

	@Test(priority=1)
	public void validUserLogin() {
		indexpage = new IndexPage(driver);
		homepage = new HomePage(driver);
		action = new Action();

		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		action.fluentWait(driver, homepage.getScreenTitle());
		String actualmessege = homepage.getScreenTitle().getText();
		
		action.softAssertion(actualmessege,  prop.getProperty("WelcomeMessgeOnHomePage"));
	}

	@Test(priority=2)
	public void user() {
		homepage = new HomePage(driver);
		action = new Action();
		user = new User(driver);

		String userName = homepage.getuserIconUserID().getText();
		
		action.softAssertion(userName,  prop.getProperty("ValidUserName"));
		action.JSClick(driver, homepage.getuserIcon());

		String actualmessege = user.getUserTitleHomePageMessege().getText();
		action.softAssertion(actualmessege,  prop.getProperty("UserTitleMessege"));
		String actualMessegeContent = user.getAboutContent().getText();
		
		Assert.assertTrue(actualMessegeContent.contains(prop.getProperty("UserContentMessege")));
	}	

	@Test(priority=3)
	public void about() {
		action = new Action();
		homepage = new HomePage(driver);
		about = new About(driver);

		action.click(driver, homepage.getAboutIcon());
		String actualmessegeheader = about.getAboutHeader().getText();
		String actualmessegecontent = about.getAboutContent().getText();
		
		Assert.assertTrue(actualmessegeheader.contains(prop.getProperty("AboutTitleMessege")));
		Assert.assertTrue(actualmessegecontent.contains(prop.getProperty("AboutContentMessege")));
	}

	@Test(priority=4)
	public void reporting() throws InterruptedException, ParseException {
		homepage = new HomePage(driver);
		reporting = new Reporting(driver);

		action.click(driver, homepage.getReportsIcon());
		
		String reportingHeader = reporting.getHeaderTitle().getText();
		action.softAssertion(reportingHeader,  prop.getProperty("ReportingPageHeaderMessege"));
		
		String actualOperationalReports = reporting.getoperationalReports().getText();
		action.softAssertion(actualOperationalReports,  prop.getProperty("ReportingOperationalMessege"));
		
		String actualActivityReports = reporting.getActivityReports().getText();
		action.softAssertion(actualActivityReports,  prop.getProperty("ReportingActivityMessege"));
		
		String actualEnergyReports = reporting.getEnergyReports().getText();
		action.softAssertion(actualEnergyReports,  prop.getProperty("ReportingEnergyMessege"));

		// Battery Health
		String actaualBatteryHealthText = reporting.getBatteryHealthText().getText();
		action.softAssertion(actaualBatteryHealthText,  prop.getProperty("BatteryHealthText"));
		action.click(driver, reporting.getBatteryHealthIcon());

		String actualStartdateText = reporting.getStartDateText().getText();
		action.softAssertion(actualStartdateText,  prop.getProperty("StartDateText"));

		action.type(reporting.getStartDate(), prop.getProperty("BatteryHealthStartDate"));
		action.type(reporting.getEndDate(), prop.getProperty("BatteryHealthEndDate"));
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.click(driver, reporting.getOKButton());

		String actualExporttext = reporting.getExport().getText();
		action.softAssertion(actualExporttext,  prop.getProperty("ExportText"));
		String actualstartdateverify = action.dateFormat(prop.getProperty("BatteryHealthStartDate"));
		String expectedstartdate = reporting.getStartDateVerifyAtExport().getText();
		action.softAssertion(actualstartdateverify, expectedstartdate);
		

		String expectedGroupSelectionTest = reporting.getFinalGroupSelectionverifyText().getText();
		action.softAssertion(expectedGroupSelectionTest,  prop.getProperty("FinalGroupSelectionverifyText"));
		
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());

		driver.navigate().back();

		// verify for one week
		action.click(driver, reporting.getBatteryHealthIcon());
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRange"), reporting.getDateRange());
		action.click(driver, reporting.getOKButton());

		String startDateAtSevenDays = reporting.getStartDateVerifyAtExport().getText();
		action.softAssertion(startDateAtSevenDays,  action.currentDateMinusSeven(8));
		
		String endDateAtSevenDays = reporting.getEndDateVerifyAtExport().getText();
		action.softAssertion(endDateAtSevenDays,  action.currentDateMinusone());
		
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());

		// verify for two weeks
		driver.navigate().back();
		action.click(driver, reporting.getBatteryHealthIcon());
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRangeTwoWeeks"), reporting.getDateRange());
		action.click(driver, reporting.getOKButton());
		String startDateAtTwoweeks = reporting.getStartDateVerifyAtExport().getText();
		action.softAssertion(startDateAtTwoweeks,  action.currentDateMinusSeven(15));
		
		String endDateAtTwoWeeks = reporting.getEndDateVerifyAtExport().getText();
		action.softAssertion(endDateAtTwoWeeks,  action.currentDateMinusone());
		
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());

		driver.navigate().back();
	}
	

	@Test(priority=5)
	public void assetInventory() throws InterruptedException {

		reporting = new Reporting(driver);

		action.click(driver, reporting.getAssetInventoryIcon());

		action.fluentWait(driver, reporting.getAssetInventoryHeader());
		
		String ActualTextAssetInventoryHeader = reporting.getAssetInventoryHeader().getText();
		action.softAssertion(ActualTextAssetInventoryHeader,   prop.getProperty("AssetInventoryHeader"));
		
		String ActualTextAssetInventoryReportMessege = reporting.getAssetInventoryReportMessege().getText();
		action.softAssertion(ActualTextAssetInventoryReportMessege, prop.getProperty("AssetInventoryReportMessege"));
		
		String ActualTextGroupsSelected = reporting.getAssetInventoryGroupsSelectedText().getText();
		action.softAssertion(ActualTextGroupsSelected, prop.getProperty("AssetInventoryGroupsSelectedText"));
		
		String ActualTextDevicesTypeSelected = reporting.getAssetInventoryDeviceTypesSelectedText().getText();
		action.softAssertion(ActualTextDevicesTypeSelected, prop.getProperty("AssetInventoryDeviceTypesSelectedText"));
		

		action.dropdown(reporting.getAssetInventoryGroupsSelectedOptions(),
				prop.getProperty("AssetInventoryGropsSelected"));
		action.dropdown(reporting.getAssetInventoryGroupsSelectedOptions(),
				prop.getProperty("AssetInventoryDeviceTypesSelected"));
		action.click(driver, reporting.getAssetInventoryOkButton());
	}

	@Test(priority = 6)
	public void manage_Device_Groups() throws InterruptedException {
		manage = new Manage(driver);

		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getGroups());

		action.softAssertion(manage.getGroupManagementHeaderText(), prop.getProperty("ManageGroupsHeaderText"));

		action.softAssertion(manage.getTableHeaderGroupName().getText(), prop.getProperty("ManageTableHeaderGroupName"));
		
		action.softAssertion(manage.getTableDescriptionHeaderText().getText(), prop.getProperty("TableDescriptionHeaderText"));
		
		
		action.softAssertion(manage.getTableAutomationHeaderText().getText(), prop.getProperty("TableAutomationHeaderText"));

		action.dropdown(manage.getOptionsDropDown(), prop.getProperty("ManageNewGroupCreate"));

		action.softAssertion(manage.getCreateGroupPopupHeaderText().getText(), prop.getProperty("ManagePopupScreenHeaderText"));

		action.type(manage.getNewGroupName(), prop.getProperty("ManageNewGroupName"));
		action.type(manage.getNewGroupDescription(), prop.getProperty("ManageNewGroupDescription"));
		action.click(driver, manage.getNewGroupSubmitButton());

		String newGroupName = action.nameVerifyFromTable(manage.getGroupNameVeriyText(),prop.getProperty("ManageNewGroupName"));
		
		action.softAssertion(newGroupName, prop.getProperty("ManageNewGroupName"));
		System.out.println(newGroupName);
		System.out.println(prop.getProperty("ManageNewGroupName"));
		String newgroupdescription = action.nameVerifyFromTable(manage.getGroupNameDescriptionVeriftText(),
				prop.getProperty("ManageNewGroupDescription"));
		action.softAssertion(newgroupdescription, prop.getProperty("ManageNewGroupDescription"));

		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getDevicesList());
		
		action.softAssertion(manage.getDevicePageHeaderText().getText(), prop.getProperty("DevicesPageHeaderText"));

		String Groupnameverify = action.nameVerifyFromTable(manage.getGroupsList(),
				prop.getProperty("ManageNewGroupName"));

		action.softAssertion(Groupnameverify, prop.getProperty("ManageNewGroupName"));
		
		
		action.nameVerifyFromTableAndClick(manage.getGroupsList(),prop.getProperty("ManageNewGroupName"));
		
		action.fluentWait(driver, manage.getNoCompuersReportingText());
		
		String NoCompuersReportingText = manage.getNoCompuersReportingText().getText();
		
		action.softAssertion(NoCompuersReportingText, prop.getProperty("getNoCompuersReportingText"));
		
		action.click(driver, manage.getOrderColumns());

		manage.unClickOnCheckBox();

		action.click(driver, manage.getOrderColumnsSaveButton());

		manage.tableHeaderText();

		action.softAssertionInt(1, manage.countTable);

		action.click(driver, manage.getOrderColumns());

		manage.clickOnCheckBox();

		action.click(driver, manage.getOrderColumnsSaveButton());

		manage.tableHeaderText();

		action.softAssertionInt(22, manage.countTable);

	}

	@Test(priority=7)
	public void manageEditGroups() {
		
		manage = new Manage(driver);
		
		// Edit group name

		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getGroups());

		manage.getVerifyTextClickOnElement(prop.getProperty("ManageNewGroupName"));
		
		action.dropdown(manage.getOptionsDropDown(), prop.getProperty("ManageNewGroupEditGroup"));
		
		action.type(manage.getNewGroupName(), prop.getProperty("ManageNewGroupReName"));
		
		action.click(driver, manage.getNewGroupSubmitButton());
		
		String newGroupName = action.nameVerifyFromTable(manage.getGroupNameVeriyText(),
				prop.getProperty("ManageNewGroupReName"));
		
		action.softAssertion(newGroupName, prop.getProperty("ManageNewGroupReName"));
	}
	
	//(dependsOnMethods= {"validUserLogin"})
	@Test(priority=8)
	public void managePolicies() {
		
		manage = new Manage(driver);
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getPoliciesIcon());
		
		action.softAssertion(manage.getPoliciesHeaderTitle().getText(), prop.getProperty("PoliciesHeaderTitleText"));
		action.softAssertion(manage.getSelectAPolicyToEditHeaderText().getText(), prop.getProperty("SelectAPolicyToEditHeaderText"));
		action.click(driver, manage.getNewPolicyButtonClick());
		
		action.type(manage.getNewpolicyName(), prop.getProperty("ManageNewPolicyName"));
		action.type(manage.getNewPolicyDescription(), prop.getProperty("ManageNewPolicyDescription"));
		
		String schemeVerifyText = manage.getSchemesVerifyText().getText();
		
		action.softAssertion(schemeVerifyText, prop.getProperty("ManageSchemeVerifyText"));
		
		action.softAssertion(manage.getSchemeNameText(), prop.getProperty("getSchemeNameTextVerify"));
		action.softAssertion(manage.getSchemeStartText(), prop.getProperty("getSchemeStartTextVerify"));
		action.softAssertion(manage.getSchemeDaysText(), prop.getProperty("getSchemeDaysTextVerify"));
		action.softAssertion(manage.getSchemeEndText(), prop.getProperty("getSchemeEndTextVerify"));
		
		action.click(driver, manage.getSchemesEditButton());
		
		action.type(manage.getDescriptionEdit(), prop.getProperty("ManagePoliciesPopUpDescription"));
		
		action.dropdown(manage.getdisplayInactivityTimeout(), prop.getProperty("DisplayInactivityTimeOut"));
		
		action.dropdown(manage.getONDCdisplayInActivityTimeOut(),prop.getProperty("DisplayInactivityTimeOut") );
		action.dropdown(manage.getONACpuInActivityTimeOut(), prop.getProperty("DisplayInactivityTimeOut"));
		action.dropdown(manage.getONDCpuInActivityTimeOut(), prop.getProperty("DisplayInactivityTimeOut"));

		action.dropdown(manage.getUSBSleepONAC(), prop.getProperty("DisabledText"));
		action.dropdown(manage.getUSBSleepONDC(), prop.getProperty("DisabledText"));
		action.dropdown(manage.getWakeTimersONAC(), prop.getProperty("DisabledText"));
		action.dropdown(manage.getWakeTimersONDC(), prop.getProperty("DisabledText"));
		action.dropdown(manage.getHIDWake(), prop.getProperty("DisabledText"));
		
		action.type(manage.getCPUMAx(),prop.getProperty("PoliciesCPUmax") );
		action.type(manage.getScreenDim(), prop.getProperty("PoliciesScreenDim"));
		action.type(manage.getDiskMax(), prop.getProperty("PoliciesDiskMax"));
		action.type(manage.getBrightness(), prop.getProperty("PoliciesBrightness"));
		action.type(manage.getNetworkMax(), prop.getProperty("PoliciesNetworkMax"));
		action.click(driver, manage.getSaveButton());
		
		action.softAssertion(manage.getWakeTimerONACVerifyText(), prop.getProperty("DisabledText"));
		action.softAssertion(manage.getUsbSleepONACVerifyText(), prop.getProperty("DisabledText"));
		action.softAssertion(manage.getHidWakeONACVerifyText(), prop.getProperty("DisabledText"));
		action.softAssertion(manage.getCPUMaxONACVerifyText(), prop.getProperty("PoliciesCPUmax"));
		action.softAssertion(manage.getDiskMaxONACVerifyText(), prop.getProperty("PoliciesDiskMax"));
		action.softAssertion(manage.getNetworkMaxONACVerifyText(), prop.getProperty("PoliciesNetworkMax"));
		action.softAssertion(manage.getWakeTimerONDCVerifyText(), prop.getProperty("DisabledText"));
		action.softAssertion(manage.getUSBSleepONDCV(), prop.getProperty("DisabledText"));
	}
	
	@Test(priority=9)
	public void manage_Policies_AddNewScheme() {
		action.click(driver, manage.getADDSchemeButton());
		manage.getSelectDaysCheckbox();
		action.type(manage.getNewSchemeName(), prop.getProperty("NewSchemeName"));
		
		action.type(manage.getNewSchemeDescription(),prop.getProperty("PoliciesNewSchemeDescription"));
		action.type(manage.getNewSchemeStartTime(), prop.getProperty("PoliciesNewSchemeStartTime"));
		action.keyBoardKeys(driver, Keys.ARROW_DOWN);
		action.type(manage.getNewSchemeEndTime(), prop.getProperty("PoliciesNewSchemeEndTime"));
		action.keyBoardKeys(driver, Keys.ARROW_DOWN);
		
		action.dropdown(manage.getdisplayInactivityTimeout(), prop.getProperty("DisplayInactivityTimeOut"));
		
		action.dropdown(manage.getONDCdisplayInActivityTimeOut(),prop.getProperty("DisplayInactivityTimeOut") );
		action.dropdown(manage.getONACpuInActivityTimeOut(), prop.getProperty("DisplayInactivityTimeOut"));
		action.dropdown(manage.getONDCpuInActivityTimeOut(), prop.getProperty("DisplayInactivityTimeOut"));

		action.dropdown(manage.getUSBSleepONAC(), prop.getProperty("DisabledText"));
		action.dropdown(manage.getUSBSleepONDC(), prop.getProperty("DisabledText"));
		action.dropdown(manage.getWakeTimersONAC(), prop.getProperty("DisabledText"));
		action.dropdown(manage.getWakeTimersONDC(), prop.getProperty("DisabledText"));
		action.dropdown(manage.getHIDWake(), prop.getProperty("DisabledText"));
		
		action.type(manage.getCPUMAx(),prop.getProperty("PoliciesCPUmax") );
		action.type(manage.getScreenDim(), prop.getProperty("PoliciesScreenDim"));
		action.type(manage.getDiskMax(), prop.getProperty("PoliciesDiskMax"));
		action.type(manage.getBrightness(), prop.getProperty("PoliciesBrightness"));
		action.type(manage.getNetworkMax(), prop.getProperty("PoliciesNetworkMax"));
		action.click(driver, manage.getSaveButton());
		
		
		action.softAssertion(manage.getNewSchemeDaysVerifyText(), prop.getProperty("getSchemeDaysTextVerify"));
		action.softAssertion(manage.getNewSchemeStartTimeVerifyText(), prop.getProperty("PoliciesNewSchemeStartTimeVerify"));
		action.softAssertion(manage.getNewSchemeEndTimeVerifyText(), prop.getProperty("PoliciesNewSchemeEndTimeVerify"));
		

	}
	
	@Test(priority=10)
	public void managePolicies_Scheduled_Events() {
		manage = new Manage(driver);
		
		action.click(driver, manage.getScduledEventAddButton());
		manage.getScheduledDays();
		
		action.dropdown(manage.getEventSelector(), prop.getProperty("PoliciesEventSelector"));
		action.type(manage.getEventStartTime(), prop.getProperty("PoliciesEventStartTime"));
		action.keyBoardKeys(driver, Keys.ARROW_DOWN);
		action.type(manage.getEventStartPreWarningTime(), prop.getProperty("PoliciesEventStartPreWarningTime"));
		action.type(manage.getEventStartDelayTime(), prop.getProperty("PoliciesEventStartDelayTime"));
		action.type(manage.getEventStartMessege(), prop.getProperty("PoliciesEventStartMessege"));
		action.click(driver, manage.getEventStartSaveButton());
		
		action.softAssertion(manage.getScheduledEventNameTextVerify(), prop.getProperty("PoliciesEventSelector"));
		action.softAssertion(manage.getScheduledEventdaysTextVerify(), prop.getProperty("getSchemeDaysTextVerify"));
		action.softAssertion(manage.getScheduledEventStartTextVerify(), prop.getProperty("PoliciesEventStartTimeVeriftText"));
		
		action.click(driver, manage.getNewPolicySaveButton());
	}
	
	@Test(priority=11)
	public void new_Policy_Verify() {
		manage = new Manage(driver);
		
		action.softAssertion(manage.getPolicyNameVerify(prop.getProperty("ManageNewPolicyName")), prop.getProperty("ManageNewPolicyName"));
		action.softAssertion(manage.getPolicyDescriptionVerify(prop.getProperty("ManageNewPolicyDescription")), prop.getProperty("ManageNewPolicyDescription"));
			
	}
	
	@Test(priority=12)
	public void assign_Policy_To_Sytstem() {
		manage = new Manage(driver);
		
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getDevicesList());
		action.click(driver, manage.getDefaultGroupName());
		action.click(driver, manage.getDeviceNameInGroupTest());
		action.rightclick(driver, manage.getDeviceNameInGroupTest());
		action.click(driver, manage.getAssignPolicy());
		action.dropdown(manage.getPolicySelectorFromDropdown(), prop.getProperty("ManageNewPolicyName"));
		action.click(driver, manage.getAssignPolicyOKButton());
		action.softAssertion(manage.getPolicyAssignVerifyText(prop.getProperty("ManageNewPolicyName")), prop.getProperty("ManageNewPolicyName"));
	}
	
	
	@Test(priority=13)
	public void deleteAssignedPolicy() {
		manage = new Manage(driver);
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getPoliciesIcon());
		manage.getPolicyNameVerifyAndClick(prop.getProperty("ManageNewPolicyName"));
		action.click(driver, manage.getpolicyDeleteButton());
		String Text = manage.getPolicyDeleteAlertMessege();
		softAssert.assertTrue(Text.contains(prop.getProperty("DeletePolicyAlertText")));
	}
	
	
	@Test(priority=14)
	public void Unassign_Policy_To_Sytstem() {
		manage = new Manage(driver);
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getDevicesList());
		action.click(driver, manage.getDefaultGroupName());
		action.click(driver, manage.getDeviceNameInGroupTest());
		action.rightclick(driver, manage.getDeviceNameInGroupTest());
		action.click(driver, manage.getAssignPolicy());
		action.dropdown(manage.getPolicySelectorFromDropdown(), prop.getProperty("DefaultOTSTestingPolicy"));
		action.click(driver, manage.getAssignPolicyOKButton());
		action.softAssertion(manage.getPolicyAssignVerifyText(prop.getProperty("DefaultOTSTestingPolicy")), prop.getProperty("DefaultOTSTestingPolicy"));
	}
	
	@Test(enabled=false)
	public void delete_UnAssigned_Policy() {
		
		
		
	}
	
	@Test(priority=15)
	public void manage_User() {
		manage = new Manage(driver);
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getUsers());
		softAssert.assertEquals(manage.getUsersHeaderText(), prop.getProperty("UsersHeaderTextVerify"));
		action.click(driver, manage.getNewUserGroup());
		softAssert.assertEquals(manage.getpopUpNewUserGroupText(), prop.getProperty("PopUpNewUserGroupText"));
		
		action.type(manage.getUsersGroupName(), prop.getProperty("UsersGroupName"));
		action.type(manage.getUsersGroupDescription(), prop.getProperty("UsersGroupDescription"));
		action.click(driver, manage.getAddUserButton());
		action.dropdown(manage.getChooseUserFromExistingUserListDropDown(), prop.getProperty("ValidUserName"));
		
		softAssert.assertEquals(manage.getExistingUserNameTextVerify().getText(), prop.getProperty("ValidUserName"));
		action.click(driver, manage.getExistingUserNameTextVerify());
		action.click(driver, manage.getDeleteUser());
		
		action.click(driver, manage.getAddUserButton());
		action.type(manage.getUserName(), prop.getProperty("NewUserName"));
		action.type(manage.getUserEmailAddress(), prop.getProperty("yopemailforADDUSer"));
		action.type(manage.getUserConfirmEmail(), prop.getProperty("yopemailforADDUSer"));
		action.click(driver, manage.getAddUserDialougeBox());
		action.click(driver, manage.getAddUserSaveButton());
		
		softAssert.assertEquals(manage.getExistingUserNameTextVerify().getText(), prop.getProperty("NewUserName"));
		action.click(driver, manage.getNewPolicySaveButton());
		
		softAssert.assertEquals(manage.getGroupCreateSuccessMessege(), prop.getProperty("GroupCreateSuccessMessegeTextVerify"));
		action.click(driver, manage.getGroupCreateOkButton());
		
		softAssert.assertAll();
	}

	
	@Test(priority=16)
	public void manage_Users_GroupPermission() throws InterruptedException {
		manage = new Manage(driver);
		
		//Temperory implementation
		//action.click(driver, manage.getManageIcon());
		//action.click(driver, manage.getUsers());
		
		action.click(driver, manage.getUsersGroupPermissions());
		action.dropdown(manage.getUsersGroupSelectDropDown(), prop.getProperty("UsersGroupName"));
		softAssert.assertEquals(action.nameVerifyFromTable(manage.getUserGroupsVerifyText(), prop.getProperty("ManageNewGroupReName")),prop.getProperty("ManageNewGroupReName"));
		
	
		softAssert.assertAll();
	}
	//(dependsOnMethods= {"validUserLogin"})
	
	@Test(priority=17)
	public void manage_Licences() {
		manage = new Manage(driver);
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getLicences());
		action.click(driver, manage.getUpdateLicenceButton());
		softAssert.assertEquals(manage.getLicenceUpdatedMessge(), prop.getProperty("ManageLicenceUpdatedMessge"));
		action.click(driver, manage.getLicenceMessegePopUpOKButton());
		
		softAssert.assertEquals(manage.getLicenceTabletextVerify(), manage.output(prop));
		softAssert.assertAll();
		
	}
	
	@Test(priority=18)
	public void manage_Reference() {
		manage = new Manage(driver);
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getReference());
		
		softAssert.assertEquals(manage.getreferenceScreenTitle(), prop.getProperty("ManagegetreferenceScreenTitle"));
		softAssert.assertEquals(manage.getInstallerDownloadsVerifyText(), prop.getProperty("ManagegetInstallerDownloadsVerifyText"));
		softAssert.assertEquals(manage.getPluginDownloadsVerifyText(), prop.getProperty("ManagegetPluginDownloadsVerifyText"));
		softAssert.assertEquals(manage.getDocumentationVerifyText(), prop.getProperty("ManagegetDocumentationVerifyText"));
		
		softAssert.assertAll();
	}
	
	@Test(priority=19)
	public void manage_Automation() {
		automation = new Automation(driver);
		
		action.click(driver, automation.getAutomateIcon());
		softAssert.assertEquals(automation.getAutomationHeaderText(), prop.getProperty("AutomationScreenTitle"));
		softAssert.assertEquals(automation.getPolicyRulesVerifyText(), prop.getProperty("AutomationgetPolicyRulesVerifyText"));
		softAssert.assertEquals(automation.getAlertRulesVerifyText(), prop.getProperty("AutomationgetAlertRulesVerifyText"));
		softAssert.assertEquals(automation.getGroupRulesVerifyText(), prop.getProperty("AutomationgetGroupRulesVerifyText"));
		
		action.click(driver, automation.getNewRuleButton());
		
		softAssert.assertEquals(automation.getCreateRuleHeaderText(), prop.getProperty("AutomationgetCreateRuleHeaderText"));
		
		action.click(driver, automation.getEnabledCheckBox());
		action.dropdown(automation.getOrderDropdown(), prop.getProperty("AutomationgetOrderDropdown"));
		action.type(automation.getRuleName(), prop.getProperty("AutomationgetRuleName"));
		action.type(automation.getRuleDescription(), prop.getProperty("AutomationgetRuleDescription"));
		action.dropdown(automation.getGroup(), prop.getProperty("ManageNewGroupReName"));
		
		// First Rule
		action.dropdown(automation.getAttributeIF(), prop.getProperty("AutomationgetAttributeIF"));
		action.dropdown(automation.getOperatorDropDown(), prop.getProperty("AutomationgetOperatorDropDown"));
		action.type(automation.getValue(), prop.getProperty("ValidUserName"));
		action.click(driver, automation.getBlankSpacetoClick());
		action.click(driver, automation.getAddClauseButton());
	
		//Second Rule
		action.dropdown(automation.getAttributeIFSecondRow(), prop.getProperty("AutomationgetAttributeIFSecondRow"));
		action.click(driver, automation.getNotCheckBoxSecondRow());
		action.dropdown(automation.getOperatorDropDownSecondRow(), prop.getProperty("AutomationgetOperatorDropDownSecondRow"));
		action.type(automation.getValueSecondRow(), prop.getProperty("AutomationValueSecondUser"));
		action.click(driver, automation.getBlankSpacetoClick());
		action.click(driver, automation.getCreateRuleSaveButton());
		
		softAssert.assertAll();
	}
	
	@Test(priority=20)
	public void Automation_rule_Presence_verify() {
		automation = new Automation(driver);
		
		action.click(driver, automation.getAutomateIcon());
		automation.getRuleNameVerifyText(prop.getProperty("AutomationgetRuleName"));
		action.click(driver, automation.getEditRuleButton());
		
		action.dropdown(automation.getSecondRuleOrDropDown(), prop.getProperty("AutomationgetSecondRuleOrDropDown"));
		action.click(driver, automation.getAddClauseButton());
		
		//Third Rule
		action.dropdown(automation.getAttributeIFThirdRow(), prop.getProperty("AutomationgetAttributeIFThirdRow"));
		action.dropdown(automation.getOperatorDropdownThirdRow(), prop.getProperty("AutomationgetOperatorDropDownThirdRow"));
		action.type(automation.getValueThrirdRow(), prop.getProperty("AutomationgetOperatorDropDownThirdRow"));
		action.click(driver, automation.getBlankSpacetoClick());
		action.click(driver, automation.getCreateRuleSaveButton());
		
		boolean flag =automation.getRuleVerifyText(prop.getProperty("AutomationgetRuleVerifyText"));
		
		softAssert.assertTrue(flag);
		
		softAssert.assertAll();
	}
	
	
	@Test(priority=21)
	public void Automation_PolicyRules() {
		automation = new Automation(driver);		
		  
		//need to delete
		action.click(driver, automation.getAutomateIcon());
		action.click(driver, automation.getPolicyRules());
		
		action.click(driver, automation.getNewRuleButton());
		
		softAssert.assertEquals(automation.getCreateRuleHeaderText(), prop.getProperty("AutomationgetCreateRuleHeaderText"));
		
		action.click(driver, automation.getEnabledCheckBox());
		action.dropdown(automation.getPolicyRulesDropdown(), prop.getProperty("AutomationPolicyRulesgetOrderDropdown"));
		action.type(automation.getRuleName(), prop.getProperty("AutomationPolicyRulesgetRuleName"));
		action.type(automation.getRuleDescription(), prop.getProperty("AutomationPolicyRulesgetRuleDescription"));
		action.dropdown(automation.getPolicySeclectDropDown(), prop.getProperty("ManageNewPolicyName"));
		
		// First Rule
				action.dropdown(automation.getAttributeIF(), prop.getProperty("AutomationgetAttributeIF"));
				action.dropdown(automation.getOperatorDropDown(), prop.getProperty("AutomationgetOperatorDropDown"));
				action.type(automation.getValue(), prop.getProperty("ValidUserName"));
				action.click(driver, automation.getBlankSpacetoClick());
				action.click(driver, automation.getAddClauseButton());
	
				//Second Rule
				action.dropdown(automation.getAttributeIFSecondRow(), prop.getProperty("AutomationgetAttributeIFSecondRow"));
				action.click(driver, automation.getNotCheckBoxSecondRow());
				action.dropdown(automation.getOperatorDropDownSecondRow(), prop.getProperty("AutomationgetOperatorDropDownSecondRow"));
				action.type(automation.getValueSecondRow(), prop.getProperty("AutomationValueSecondUser"));
				action.click(driver, automation.getBlankSpacetoClick());
				action.click(driver, automation.getCreateRuleSaveButton());
				
				boolean flag =automation.getPolicyRulesTableNmaeVerfy(prop.getProperty("AutomationPolicyRulesgetRuleName"));
				boolean flagRule =automation.getPoliciesRuleVerifyText(prop.getProperty("AutomationPolicyRulsgetRuleVerifyTextRule"));
				
				softAssert.assertEquals(flag, true);
				softAssert.assertEquals(flagRule, true);
				
				softAssert.assertAll();	
	}
	
	@Test(priority=22)
	public void getAutomation_AlertRules() {
		automation = new Automation(driver);
		
		action.click(driver, automation.getAlertRulesTab());
		softAssert.assertEquals(automation.getAlertRulesTabText(), prop.getProperty("AutomationAlertrulesVerifyText"));
		softAssert.assertAll();	
	}
	

	@Test(priority=23)
	public void Settings() {
		settings = new Settings(driver);
		
		action.click(driver, settings.getSettings());
		action.click(driver, settings.getSettingsAdvanced());

		//Advanced
		softAssert.assertEquals(settings.getScreenHeader(), prop.getProperty("SettingsTitleHeader"));
		softAssert.assertEquals(settings.getInttelligentUpdateTextVerify(), prop.getProperty("SettingsgetInttelligentUpdateTextVerify"));
		softAssert.assertEquals(settings.getDemandReductionTextVerify(), prop.getProperty("SettingsgetDemandReductionTextVerify"));
		softAssert.assertEquals(settings.getRaptorApplianceConnectionsTextVerify(), prop.getProperty("SettingsgetRaptorApplianceConnectionsTextVerify"));
		softAssert.assertEquals(settings.getEnableIbutton(), true);
		softAssert.assertEquals(settings.getEnablePriorityUpdateButton(), true);
		softAssert.assertEquals(settings.getEnableDemandreductionButton(), true);
		softAssert.assertEquals(settings.getDisplayDimmingAmount(), prop.getProperty("SettingsgetDisplayDimmingAmount"));
		softAssert.assertEquals(settings.getMinimumInactivityTimeOut(), prop.getProperty("SettingsgetMinimumInactivityTimeOut"));
		softAssert.assertEquals(settings.getRaptorApplianceConnectionsButton(), true);
		
		
		softAssert.assertEquals(settings.getEnableDemandReduction(), prop.getProperty("SettingsEnableDemandReduction"));
		softAssert.assertEquals(settings.getEnablePriorityUpdate(), prop.getProperty("SettingsEnablePriorityUpdate"));
		softAssert.assertEquals(settings.getEnableIUpdate(), prop.getProperty("SettingsEnableIUpdate"));
	
		//Security
		action.click(driver, settings.getSettings());
		action.click(driver, settings.getSecurity());
		
		
		softAssert.assertEquals(settings.getActiveTwoFactorAuthenticationButton(), prop.getProperty("SettingsSecurityActiveTwoFactorAuthenticationButton"));
		softAssert.assertEquals(settings.getMinimumLengthField(), prop.getProperty("SettingsSecuritygetMinimumLengthField"));
		softAssert.assertEquals(settings.getRequireCapitalLetterFiled(), prop.getProperty("SettingsSecuritygetRequireCapitalLetterFiled"));
		softAssert.assertEquals(settings.getRequireLowerCaseField(), prop.getProperty("SettingsSecuritygetRequireLowerCaseField"));
		softAssert.assertEquals(settings.getRequireNumberField(), prop.getProperty("SettingsSecuritygetRequireNumberField"));
		softAssert.assertEquals(settings.getRequireSpecialCharacterField(), prop.getProperty("SettingsSecuritygetRequireSpecialCharacterField"));
		softAssert.assertEquals(settings.getMissedAttemptsLimitField(), prop.getProperty("SettingsSecuritygetMissedAttemptsLimitField"));
		softAssert.assertEquals(settings.getExpirirationLimitField(), prop.getProperty("SettingsSecuritygetExpirirationLimitField"));
		softAssert.assertEquals(settings.getReuseCycleField(), prop.getProperty("SettingsSecuritygetReuseCycleField"));
		

		softAssert.assertEquals(settings.getpasswordComplexitySettings(), prop.getProperty("SettingsSecurityPasswordComplexitySettings"));
		softAssert.assertEquals(settings.getActiveTwoFactorAuthentication(), prop.getProperty("SettingsSecuritygetActiveTwoFactorAuthentication"));
		softAssert.assertEquals(settings.getMinimumLength(), prop.getProperty("SettingsSecuritygetMinimumLength"));
		softAssert.assertEquals(settings.getRequireCapitalLetter(), prop.getProperty("SettingsSecuritygetRequireCapitalLetter"));
		softAssert.assertEquals(settings.getRequireLowerCase(), prop.getProperty("SettingsSecuritygetRequireLowerCase"));
		softAssert.assertEquals(settings.getRequireNumber(), prop.getProperty("SettingsSecuritygetRequireNumber"));
		softAssert.assertEquals(settings.getRequireSpecialCharacter(), prop.getProperty("SettingsSecuritygetRequireSpecialCharacter"));
		
		softAssert.assertEquals(settings.getMissedAttemptsLimits(), prop.getProperty("SettingsSecuritygetMissedAttemptsLimits"));
		softAssert.assertEquals(settings.getExpirirationLimit(), prop.getProperty("SettingsSecuritygetExpirirationLimit"));
		softAssert.assertEquals(settings.getReuseCycle(), prop.getProperty("SettingsSecuritygetReuseCycle"));
		
		softAssert.assertEquals(settings.getAutoUpgrade(), prop.getProperty("SettingsSecuritygetAutoUpgrade"));
		softAssert.assertEquals(settings.getClientVersions(), prop.getProperty("SettingsSecuritygetClientVersions"));
		softAssert.assertEquals(settings.getWindowsClientVersionText(), prop.getProperty("SettingsSecuritygetWindowsClientVersionText"));
		softAssert.assertEquals(settings.getMacOSClientVersionText(), prop.getProperty("SettingsSecuritygetMacOSClientVersionText"));
		softAssert.assertEquals(settings.getChromeBookClientVersionText(), prop.getProperty("SettingsSecuritygetChromeBookClientVersionText"));
		softAssert.assertEquals(settings.getWindowsVersion(prop.getProperty("SettingsSecuritygetWindowsVersion")), prop.getProperty("SettingsSecuritygetWindowsVersion"));
		softAssert.assertEquals(settings.getMacOSVersion(prop.getProperty("SettingsSecuritygetMacOSVersion")), prop.getProperty("SettingsSecuritygetMacOSVersion"));
		softAssert.assertEquals(settings.getChromebookVersion(prop.getProperty("SettingsSecuritygetChromebookVersion")), prop.getProperty("SettingsSecuritygetChromebookVersion"));
		
		action.click(driver, settings.getSettings());
		action.click(driver, settings.getSettingsGeneral());
		
		softAssert.assertEquals(settings.getGeneralSettings(), prop.getProperty("SettingsSecuritygetGeneralSettings"));
		softAssert.assertEquals(settings.getDevicesShown(), prop.getProperty("DeviceToShow"));
		softAssert.assertEquals(settings.getDataRetention(), prop.getProperty("DataRetention"));
		softAssert.assertEquals(settings.getCheckInInterval(), prop.getProperty("CheckInInterval"));
		softAssert.assertEquals(settings.getUnLicenceAfter(), prop.getProperty("UnLicenceAfter"));
		softAssert.assertEquals(settings.getShowUnlicencedFor(), prop.getProperty("ShowUnlicencedFor"));
		softAssert.assertEquals(settings.getAlwaysShowUnlicenced(), prop.getProperty("AlwaysShowUnlicensedDevices"));
		
		softAssert.assertEquals(settings.getGreenPower(), prop.getProperty("SettingsGreenPower"));
		softAssert.assertEquals(settings.getCO2(), prop.getProperty("SettingsCO2"));
		softAssert.assertEquals(settings.getEnergyCost(), prop.getProperty("SettingsEnergyCost"));
		
		action.click(driver, settings.getAlwaysShowUnlicencedClick());
		action.click(driver, settings.getSettingsSaveButton());
		softAssert.assertEquals(settings.getAlwaysShowUnlicenced(), prop.getProperty("AlwaysShowUnlicensedDevicesAfterChange"));
		action.click(driver, settings.getAlwaysShowUnlicencedClick());
		action.click(driver, settings.getSettingsSaveButton());
		softAssert.assertEquals(settings.getAlwaysShowUnlicenced(), prop.getProperty("AlwaysShowUnlicensedDevices"));
		
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




