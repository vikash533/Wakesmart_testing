package com.wakesmart.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
import com.wakesmart.pageObjects.Settings;
import com.wakesmart.pageObjects.User;


public class HomePageTest extends BaseClass {

	public WebDriver driver;
	private Action action;
	private HomePage homepage;
	private IndexPage indexpage;
	private User user;
	private About about;
	private Reporting reporting;
	private Manage manage;
	private Automation automation;
	private Settings settings;
	SoftAssert softAssert;

	@BeforeClass
	public void browserLaunch()  {
		try {
			driver = launchBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

	@Test(priority=1)
	public void validUserLogin() {
		indexpage = new IndexPage(driver);
		homepage = new HomePage(driver);
		action = new Action();
		softAssert = new SoftAssert();

		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLogin());
//		action.fluentWait(driver, indexpage.getErrorMsg());
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("WelcomeMessgeOnHomeNewPage"));
		
		softAssert.assertAll();
	}

	@Test(dependsOnMethods= {"validUserLogin"},priority=2)
	public void user() {
		homepage = new HomePage(driver);
		action = new Action();
		user = new User(driver);
		softAssert = new SoftAssert();
		
		String userName = homepage.getuserIconUserID().getText();
		
		softAssert.assertEquals(userName,  prop.getProperty("ValidUserName"));
		action.JSClick(driver, homepage.getuserIcon());

		String actualmessege = user.getUserTitleHomePageMessege().getText();
		softAssert.assertEquals(actualmessege,  prop.getProperty("UserTitleMessege"));
		String actualMessegeContent = user.getAboutContent().getText();
		
		softAssert.assertTrue(actualMessegeContent.contains(prop.getProperty("UserContentMessege")));
		softAssert.assertAll();
	}	

	@Test(priority=3,enabled=false)
	public void about() {
		action = new Action();
		homepage = new HomePage(driver);
		about = new About(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getAboutIcon());
		String actualmessegeheader = about.getAboutHeader().getText();
		String actualmessegecontent = about.getAboutContent().getText();
		
		softAssert.assertTrue(actualmessegeheader.contains(prop.getProperty("AboutTitleMessege")));
		softAssert.assertTrue(actualmessegecontent.contains(prop.getProperty("AboutContentMessege")));
		softAssert.assertAll();
	}

	@Test(priority=4,enabled=false)
	public void reporting() throws InterruptedException, ParseException {
		homepage = new HomePage(driver);
		reporting = new Reporting(driver);
		softAssert = new SoftAssert();
		
		
		action.click(driver, homepage.getReportsIcon());
		
		String reportingHeader = reporting.getHeaderTitle().getText();
		softAssert.assertEquals(reportingHeader,  prop.getProperty("ReportingPageHeaderMessege"));
		
		String actualOperationalReports = reporting.getoperationalReports().getText();
		softAssert.assertEquals(actualOperationalReports,  prop.getProperty("ReportingOperationalMessege"));
		
		String actualActivityReports = reporting.getActivityReports().getText();
		softAssert.assertEquals(actualActivityReports,  prop.getProperty("ReportingActivityMessege"));
		
		String actualEnergyReports = reporting.getEnergyReports().getText();
		softAssert.assertEquals(actualEnergyReports,  prop.getProperty("ReportingEnergyMessege"));
		
		// Battery Health
		String actaualBatteryHealthText = reporting.getBatteryHealthText().getText();
		softAssert.assertEquals(actaualBatteryHealthText,  prop.getProperty("BatteryHealthText"));
		action.click(driver, reporting.getBatteryHealthIcon());

		String actualStartdateText = reporting.getStartDateText().getText();
		softAssert.assertEquals(actualStartdateText,  prop.getProperty("StartDateText"));

		action.type(reporting.getStartDate(), prop.getProperty("BatteryHealthStartDate"));
		action.type(reporting.getEndDate(), prop.getProperty("BatteryHealthEndDate"));
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.click(driver, reporting.getOKButton());

		String actualExporttext = reporting.getExport().getText();
		softAssert.assertEquals(actualExporttext,  prop.getProperty("ExportText"));
		String actualstartdateverify = action.dateFormat(prop.getProperty("BatteryHealthStartDate"));
		String expectedstartdate = reporting.getStartDateVerifyAtExport().getText();
		softAssert.assertEquals(actualstartdateverify, expectedstartdate);
		

		String expectedGroupSelectionTest = reporting.getFinalGroupSelectionverifyText().getText();
		softAssert.assertEquals(expectedGroupSelectionTest,  prop.getProperty("FinalGroupSelectionverifyText"));
		
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());

		driver.navigate().back();

		// verify for one week
		action.click(driver, reporting.getBatteryHealthIcon());
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRange"), reporting.getDateRange());
		action.click(driver, reporting.getOKButton());

		
		String startDateAtSevenDays = reporting.getStartDateVerifyAtExport().getText();
		softAssert.assertEquals(startDateAtSevenDays,  action.currentDateMinusSeven(8));
		
		String endDateAtSevenDays = reporting.getEndDateVerifyAtExport().getText();
		softAssert.assertEquals(endDateAtSevenDays,  action.currentDateMinusone());
		
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());

		// verify for two weeks
		driver.navigate().back();
		action.click(driver, reporting.getBatteryHealthIcon());
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRangeTwoWeeks"), reporting.getDateRange());
		action.click(driver, reporting.getOKButton());
		String startDateAtTwoweeks = reporting.getStartDateVerifyAtExport().getText();
		softAssert.assertEquals(startDateAtTwoweeks,  action.currentDateMinusSeven(15));
		
		String endDateAtTwoWeeks = reporting.getEndDateVerifyAtExport().getText();
		softAssert.assertEquals(endDateAtTwoWeeks,  action.currentDateMinusone());
		
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());

		driver.navigate().back();
		softAssert.assertAll();
	}
	
	
	//
	@Test(priority=5,enabled=false)
	public void manage_Device_Groups() throws InterruptedException {
		manage = new Manage(driver);
		softAssert = new SoftAssert();

		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getGroups());

		softAssert.assertEquals(manage.getGroupManagementHeaderText(), prop.getProperty("ManageGroupsHeaderText"));

		softAssert.assertEquals(manage.getTableHeaderGroupName().getText(), prop.getProperty("ManageTableHeaderGroupName"));
		
		softAssert.assertEquals(manage.getTableDescriptionHeaderText().getText(), prop.getProperty("TableDescriptionHeaderText"));
		
		
		softAssert.assertEquals(manage.getTableAutomationHeaderText().getText(), prop.getProperty("TableAutomationHeaderText"));

		action.dropdown(manage.getOptionsDropDown(), prop.getProperty("ManageNewGroupCreate"));

		softAssert.assertEquals(manage.getCreateGroupPopupHeaderText().getText(), prop.getProperty("ManagePopupScreenHeaderText"));

		action.type(manage.getNewGroupName(), prop.getProperty("ManageNewGroupName"));
		action.type(manage.getNewGroupDescription(), prop.getProperty("ManageNewGroupDescription"));
		action.click(driver, manage.getNewGroupSubmitButton());

		String newGroupName = action.nameVerifyFromTable(manage.getGroupNameVeriyText(),prop.getProperty("ManageNewGroupName"));
		
		softAssert.assertEquals(newGroupName, prop.getProperty("ManageNewGroupName"));
		String newgroupdescription = action.nameVerifyFromTable(manage.getGroupNameDescriptionVeriftText(),
				prop.getProperty("ManageNewGroupDescription"));
		softAssert.assertEquals(newgroupdescription, prop.getProperty("ManageNewGroupDescription"));

		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getDevicesList());
		
		softAssert.assertEquals(manage.getDevicePageHeaderText().getText(), prop.getProperty("DevicesPageHeaderText"));

		String Groupnameverify = action.nameVerifyFromTable(manage.getGroupsList(),
				prop.getProperty("ManageNewGroupName"));

		softAssert.assertEquals(Groupnameverify, prop.getProperty("ManageNewGroupName"));
		
		
		action.nameVerifyFromTableAndClick(manage.getGroupsList(),prop.getProperty("ManageNewGroupName"));
		
		action.fluentWait(driver, manage.getNoCompuersReportingText());
		
		String NoCompuersReportingText = manage.getNoCompuersReportingText().getText();
		
		softAssert.assertEquals(NoCompuersReportingText, prop.getProperty("getNoCompuersReportingText"));
		
		action.click(driver, manage.getOrderColumns());

		manage.unClickOnCheckBox();

		action.click(driver, manage.getOrderColumnsSaveButton());

		manage.tableHeaderText();

		softAssert.assertEquals(1, manage.countTable);

		action.click(driver, manage.getOrderColumns());

		manage.clickOnCheckBox();

		action.click(driver, manage.getOrderColumnsSaveButton());

		manage.tableHeaderText();

		softAssert.assertEquals(22, manage.countTable);
		
		manage.getDeviceSearchFunctionality().click();;
		manage.getDeviceSearchFunctionality().sendKeys(prop.getProperty("DeviceNeedsToBeSearch"));

		
		//action.type(manage.getDeviceSearchFunctionality(), prop.getProperty("DeviceNeedsToBeSearch"));
		
		manage.getDeviceSearchFunctionality().submit();
		
		
		softAssert.assertEquals(manage.getDeviceListVerifyFromTable(prop.getProperty("DeviceNeedsToBeSearch")),true,"On search");
		
		action.click(driver, manage.getGroupsOption());
		
		manage.getSelectGroups(prop.getProperty("AssetInventoryGropsSelected"));
		
		action.click(driver, manage.getSearchBtn());
		
		softAssert.assertEquals(manage.getDeviceListVerifyFromTable(prop.getProperty("DeviceNeedsToBeSearch")),true,"Groups selected");
		
		action.click(driver, manage.getDeviceType());
		
		manage.getSelectDevicesTypes(prop.getProperty("AssetInventoryDeviceTypesSelected"));
		
		action.click(driver, manage.getSearchBtnDeviceType());
		
		softAssert.assertEquals(manage.getDeviceListVerifyFromTable(prop.getProperty("DeviceNeedsToBeSearch")),true,"Device Type selected");
		
		manage.getActionsOnSystem();
		
		//softAssert.assertEquals(manage.getVerifyOptionsInListfromWEB(), manage.getVerifyOptionsInListfromLocal(prop));
		
		manage.getActionsNeedToBePerformed(prop.getProperty("DeviceSearchAssignGroupTextVerify"));
		
		softAssert.assertEquals(manage.getGroupSelectedDevices(), prop.getProperty("GroupSelectedDevicesText"));
		
		action.dropdown(manage.getGroupSelectDropDown(), prop.getProperty("ManageNewGroupName"));
		
		action.click(driver, manage.getGroupSelectDevicesOKButton());
		
		manage.getDeviceSearchFunctionality().click();;
		manage.getDeviceSearchFunctionality().sendKeys(prop.getProperty("DeviceNeedsToBeSearch"));
		
		manage.getDeviceSearchFunctionality().submit();
		
		softAssert.assertEquals(manage.getGroupAssignedStatusVerifyAfterAssign(prop.getProperty("ManageNewGroupName")),true,"On search");

		
		manage.getActionsOnSystem();
				
		manage.getActionsNeedToBePerformed(prop.getProperty("DeviceSearchAssignGroupTextVerify"));
		
		action.dropdown(manage.getGroupSelectDropDown(), prop.getProperty("DefaulftGroupOnDevicesearchPage"));
		
		action.click(driver, manage.getGroupSelectDevicesOKButton());
		
		manage.getDeviceSearchFunctionality().click();;
		manage.getDeviceSearchFunctionality().sendKeys(prop.getProperty("DeviceNeedsToBeSearch"));
		
		manage.getDeviceSearchFunctionality().submit();
		
		softAssert.assertEquals(manage.getGroupAssignedStatusVerifyAfterAssign(prop.getProperty("ManageNewGroupName")),false,"On search");
		
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=6,enabled=false)
	public void manageEditGroups() throws InterruptedException {
		
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		// Edit group name

		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getGroups());

		manage.getVerifyTextClickOnElement(prop.getProperty("ManageNewGroupName"));
		
		action.dropdown(manage.getOptionsDropDown(), prop.getProperty("ManageNewGroupEditGroup"));
		
		action.type(manage.getNewGroupName(), prop.getProperty("ManageNewGroupReName"));
		
		manage.getNewGroupDescription().clear();
		
		action.click(driver, manage.getNewGroupSubmitButton());
		
		String newGroupName = action.nameVerifyFromTable(manage.getGroupNameVeriyText(),prop.getProperty("ManageNewGroupReName"));
		
		softAssert.assertEquals(manage.getDescriptionPresentUpdate(prop.getProperty("ManageNewGroupDescription")), true);
		softAssert.assertEquals(newGroupName, prop.getProperty("ManageNewGroupReName"));
		
		//manage.getVerifyTextClickOnElement(prop.getProperty("ManageNewGroupReName"));
		
		//action.dropdown(manage.getOptionsDropDown(), prop.getProperty("ManageNewGroupEditGroup"));
		
		//action.type(manage.getNewGroupDescription(), prop.getProperty("ManageNewGroupDescription"));
		
		//action.click(driver, manage.getDialougeBox());
		//action.click(driver, manage.getNewGroupSubmitButton());
		
		//String newgroupdescription = action.nameVerifyFromTable(manage.getGroupNameDescriptionVeriftText(),prop.getProperty("ManageNewGroupDescription"));
		
		//softAssert.assertEquals(newgroupdescription, prop.getProperty("ManageNewGroupDescription"));
		
		softAssert.assertAll();
	}
	
	//(dependsOnMethods= {"validUserLogin"})
	@Test(priority=7,enabled=false)
	public void managePolicies() {
		
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getPoliciesIcon());
		
		softAssert.assertEquals(manage.getPoliciesHeaderTitle().getText(), prop.getProperty("PoliciesHeaderTitleText"));
		softAssert.assertEquals(manage.getSelectAPolicyToEditHeaderText().getText(), prop.getProperty("SelectAPolicyToEditHeaderText"));
		action.click(driver, manage.getNewPolicyButtonClick());
		
		action.type(manage.getNewpolicyName(), prop.getProperty("ManageNewPolicyName"));
		action.type(manage.getNewPolicyDescription(), prop.getProperty("ManageNewPolicyDescription"));
		
		String schemeVerifyText = manage.getSchemesVerifyText().getText();
		
		softAssert.assertEquals(schemeVerifyText, prop.getProperty("ManageSchemeVerifyText"));
		
		softAssert.assertEquals(manage.getSchemeNameText(), prop.getProperty("getSchemeNameTextVerify"));
		softAssert.assertEquals(manage.getSchemeStartText(), prop.getProperty("getSchemeStartTextVerify"));
		softAssert.assertEquals(manage.getSchemeDaysText(), prop.getProperty("getSchemeDaysTextVerify"));
		softAssert.assertEquals(manage.getSchemeEndText(), prop.getProperty("getSchemeEndTextVerify"));
		
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
		
		softAssert.assertEquals(manage.getWakeTimerONACVerifyText(), prop.getProperty("DisabledText"));
		softAssert.assertEquals(manage.getUsbSleepONACVerifyText(), prop.getProperty("DisabledText"));
		softAssert.assertEquals(manage.getHidWakeONACVerifyText(), prop.getProperty("DisabledText"));
		softAssert.assertEquals(manage.getCPUMaxONACVerifyText(), prop.getProperty("PoliciesCPUmax"));
		softAssert.assertEquals(manage.getDiskMaxONACVerifyText(), prop.getProperty("PoliciesDiskMax"));
		softAssert.assertEquals(manage.getNetworkMaxONACVerifyText(), prop.getProperty("PoliciesNetworkMax"));
		softAssert.assertEquals(manage.getWakeTimerONDCVerifyText(), prop.getProperty("DisabledText"));
		softAssert.assertEquals(manage.getUSBSleepONDCV(), prop.getProperty("DisabledText"));
		softAssert.assertAll();
	}
	
	@Test(priority=8,enabled=false)
	public void manage_Policies_AddNewScheme() {
		softAssert = new SoftAssert();
		
		
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
		
		
		softAssert.assertEquals(manage.getNewSchemeDaysVerifyText(), prop.getProperty("getSchemeDaysTextVerify"));
		softAssert.assertEquals(manage.getNewSchemeStartTimeVerifyText(), prop.getProperty("PoliciesNewSchemeStartTimeVerify"));
		softAssert.assertEquals(manage.getNewSchemeEndTimeVerifyText(), prop.getProperty("PoliciesNewSchemeEndTimeVerify"));
		softAssert.assertAll();
		

	}
	
	@Test(priority=10,enabled=false)
	public void managePolicies_Scheduled_Events() {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, manage.getScduledEventAddButton());
		manage.getScheduledDays();
		
		action.dropdown(manage.getEventSelector(), prop.getProperty("PoliciesEventSelector"));
		action.type(manage.getEventStartTime(), prop.getProperty("PoliciesEventStartTime"));
		action.keyBoardKeys(driver, Keys.ARROW_DOWN);
		action.type(manage.getEventStartPreWarningTime(), prop.getProperty("PoliciesEventStartPreWarningTime"));
		action.type(manage.getEventStartDelayTime(), prop.getProperty("PoliciesEventStartDelayTime"));
		action.type(manage.getEventStartMessege(), prop.getProperty("PoliciesEventStartMessege"));
		action.click(driver, manage.getEventStartSaveButton());
		
		softAssert.assertEquals(manage.getScheduledEventNameTextVerify(), prop.getProperty("PoliciesEventSelector"));
		softAssert.assertEquals(manage.getScheduledEventdaysTextVerify(), prop.getProperty("getSchemeDaysTextVerify"));
		softAssert.assertEquals(manage.getScheduledEventStartTextVerify(), prop.getProperty("PoliciesEventStartTimeVeriftText"));
		
		action.click(driver, manage.getNewPolicySaveButton());
		softAssert.assertAll();
	}
	
	@Test(priority=11,enabled=false)
	public void new_Policy_Verify() {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		softAssert.assertEquals(manage.getPolicyNameVerify(prop.getProperty("ManageNewPolicyName")), prop.getProperty("ManageNewPolicyName"));
		softAssert.assertEquals(manage.getPolicyDescriptionVerify(prop.getProperty("ManageNewPolicyDescription")), prop.getProperty("ManageNewPolicyDescription"));
		softAssert.assertAll();
	}
	
	//(dependsOnMethods= {"validUserLogin"})
	//
	@Test(priority=12,enabled=false)
	public void assign_Policy_To_Sytstem() {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getDevicesList());
		action.click(driver, manage.getDefaultGroupName());
		action.click(driver, manage.getDeviceNameInGroupTest());
		action.rightclick(driver, manage.getDeviceNameInGroupTest());
		action.click(driver, manage.getAssignPolicy());
		action.dropdown(manage.getPolicySelectorFromDropdown(), prop.getProperty("ManageNewPolicyName"));
		action.click(driver, manage.getAssignPolicyOKButton());
		softAssert.assertEquals(manage.getPolicyAssignVerifyText(prop.getProperty("ManageNewPolicyName")), prop.getProperty("ManageNewPolicyName"));
		softAssert.assertAll();
	}
	
	
	@Test(priority=13,enabled=false)
	public void deleteAssignedPolicy() {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getPoliciesIcon());
		manage.getPolicyNameVerifyAndClick(prop.getProperty("ManageNewPolicyName"));
		action.click(driver, manage.getpolicyDeleteButton());
		String Text = manage.getPolicyDeleteAlertMessege();
		softAssert.assertTrue(Text.contains(prop.getProperty("DeletePolicyAlertText")));
		softAssert.assertAll();
	}
	
	
	@Test(priority=14,enabled=false)
	public void Unassign_Policy_To_Sytstem() {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getDevicesList());
		action.click(driver, manage.getDefaultGroupName());
		action.click(driver, manage.getDeviceNameInGroupTest());
		action.rightclick(driver, manage.getDeviceNameInGroupTest());
		action.click(driver, manage.getAssignPolicy());
		action.dropdown(manage.getPolicySelectorFromDropdown(), prop.getProperty("DefaultOTSTestingPolicy"));
		action.click(driver, manage.getAssignPolicyOKButton());
		softAssert.assertEquals(manage.getPolicyAssignVerifyText(prop.getProperty("DefaultOTSTestingPolicy")), prop.getProperty("DefaultOTSTestingPolicy"));
		softAssert.assertAll();
	}
	
	@Test(enabled=false)
	public void delete_UnAssigned_Policy() {
		
		
		
	}
	
	//(priority=15)
	@Test(dependsOnMethods= {"validUserLogin"},enabled=false)
	public void manage_User() {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
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
		
		action.click(driver, manage.getNewPolicySaveButton());
		
		action.fluentWait(driver, manage.getGroupCreateSuccessMessege());
		
		softAssert.assertEquals(manage.getGroupCreateSuccessMessege().getText(), prop.getProperty("GroupCreateSuccessMessegeTextVerify"));
		action.click(driver, manage.getGroupCreateOkButton());
		
		manage.getClickOnGroupAdminCheckBox();
		
		action.click(driver, manage.getuserGroupSaveButton());
		
		manage.getEditGroupButton();
		
		action.click(driver, manage.getAddUserButton());
		action.type(manage.getUserName(), prop.getProperty("NewUserName"));
		action.type(manage.getUserEmailAddress(), prop.getProperty("yopemailforADDUSer"));
		action.type(manage.getUserConfirmEmail(), prop.getProperty("yopemailforADDUSer"));
		action.click(driver, manage.getAddUserDialougeBox());
		action.click(driver, manage.getAddUserDialougeBox());
		action.click(driver, manage.getAddUserSaveButton());
		
		softAssert.assertEquals(manage.getExistingUserNameTextVerify().getText(), prop.getProperty("NewUserName"));
		action.click(driver, manage.getNewPolicySaveButton());
		
		softAssert.assertEquals(manage.getUserAddedAlertMessege(), prop.getProperty("UserAddedSuccessmessegeAlert"));
		
		action.click(driver, manage.getUserAddedAlertMessegeOKButton());
		
		softAssert.assertAll();
	}

	
	@Test(priority=16,enabled=false)
	public void manage_Users_GroupPermission() throws InterruptedException {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		//Temperory implementation
		//action.click(driver, manage.getManageIcon());
		//action.click(driver, manage.getUsers());
		
		action.click(driver, manage.getUsersGroupPermissions());
		action.dropdown(manage.getUsersGroupSelectDropDown(), prop.getProperty("UsersGroupName"));
		softAssert.assertEquals(action.nameVerifyFromTable(manage.getUserGroupsVerifyText(), prop.getProperty("ManageNewGroupReName")),prop.getProperty("ManageNewGroupReName"));
		
	
		softAssert.assertAll();
	}
	//(dependsOnMethods= {"validUserLogin"})
	
	@Test(priority=17,enabled=false)
	public void manage_Licences() {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getLicences());
		action.click(driver, manage.getUpdateLicenceButton());
		softAssert.assertEquals(manage.getLicenceUpdatedMessge(), prop.getProperty("ManageLicenceUpdatedMessge"));
		action.click(driver, manage.getLicenceMessegePopUpOKButton());
		
		softAssert.assertEquals(manage.getLicenceTabletextVerify(), manage.output(prop));
		softAssert.assertAll();
		
	}
	
	@Test(priority=18,enabled=false)
	public void manage_Reference() {
		manage = new Manage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, manage.getManageIcon());
		action.click(driver, manage.getReference());
		
		softAssert.assertEquals(manage.getreferenceScreenTitle(), prop.getProperty("ManagegetreferenceScreenTitle"));
		softAssert.assertEquals(manage.getInstallerDownloadsVerifyText(), prop.getProperty("ManagegetInstallerDownloadsVerifyText"));
		softAssert.assertEquals(manage.getPluginDownloadsVerifyText(), prop.getProperty("ManagegetPluginDownloadsVerifyText"));
		softAssert.assertEquals(manage.getDocumentationVerifyText(), prop.getProperty("ManagegetDocumentationVerifyText"));
		
		softAssert.assertAll();
	}
	
	@Test(priority=19,enabled=false)
	public void manage_Automation() {
		automation = new Automation(driver);
		softAssert = new SoftAssert();
		
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
	
	//
	@Test(priority=20,enabled=false)
	public void Automation_rule_Presence_verify() {
		automation = new Automation(driver);
		softAssert = new SoftAssert();
		
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
	
	
	@Test(priority=21,enabled=false)
	public void Automation_PolicyRules() {
		automation = new Automation(driver);	
		softAssert = new SoftAssert();
		  
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
	
	@Test(priority=22,enabled=false)
	public void getAutomation_AlertRules() {
		automation = new Automation(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, automation.getAlertRulesTab());
		softAssert.assertEquals(automation.getAlertRulesTabText(), prop.getProperty("AutomationAlertrulesVerifyText"));
		softAssert.assertAll();	
	}
	

	@Test(priority=23,enabled=false)
	public void Settings() {
		settings = new Settings(driver);
		softAssert = new SoftAssert();
		
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
	
	//5 need to implement for none and none
	@Test(priority=24,enabled=false)
	public void assetInventory() throws InterruptedException {

		reporting = new Reporting(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getReportsIcon());
		action.click(driver, reporting.getAssetInventoryIcon());

		action.fluentWait(driver, reporting.getAssetInventoryHeader());
		
		String ActualTextAssetInventoryHeader = reporting.getAssetInventoryHeader().getText();
		softAssert.assertEquals(ActualTextAssetInventoryHeader,   prop.getProperty("AssetInventoryHeader"));
		
		String ActualTextAssetInventoryReportMessege = reporting.getAssetInventoryReportMessege().getText();
		softAssert.assertEquals(ActualTextAssetInventoryReportMessege, prop.getProperty("AssetInventoryReportMessege"));
		
		String ActualTextGroupsSelected = reporting.getAssetInventoryGroupsSelectedText().getText();
		softAssert.assertEquals(ActualTextGroupsSelected, prop.getProperty("AssetInventoryGroupsSelectedText"));
		
		String ActualTextDevicesTypeSelected = reporting.getAssetInventoryDeviceTypesSelectedText().getText();
		softAssert.assertEquals(ActualTextDevicesTypeSelected, prop.getProperty("AssetInventoryDeviceTypesSelectedText"));
		
		action.dropdown(reporting.getAssetInventoryGroupsSelectedOptions(),prop.getProperty("ManageNewGroupReName"));
		action.dropdown(reporting.getAssetInventoryDeviceTypeSelectorOptions(),prop.getProperty("AssetInventoryDeviceTypesSelected"));
		action.click(driver, reporting.getAssetInventoryOkButton());
		softAssert.assertAll();
	}
	
	// completed
	@Test(priority=25,enabled=false)
	public void reporting_DeviceUsage() throws ParseException {
		reporting = new Reporting(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getReportsIcon());
		action.click(driver, reporting.getDeviceUsage());
		
		softAssert.assertEquals(reporting.getReportMessegeText(), prop.getProperty("DeviceUsagePopupHeader"));

		action.type(reporting.getStartDate(), prop.getProperty("BatteryHealthStartDate"));
		action.type(reporting.getEndDate(), prop.getProperty("BatteryHealthEndDate"));
		action.selectByVisibleText(prop.getProperty("ManageNewPolicyName"), reporting.getPolicySelector());
		action.click(driver, reporting.getOKButton());

		//Verification for the Start date, end date and Policy name
		softAssert.assertEquals(reporting.getStartDateVerifyAtExport().getText(), prop.getProperty("BatteryHealthStartDateTextVerify") );
		softAssert.assertEquals(reporting.getEndDateVerifyAtExport().getText(), prop.getProperty("BatteryHealthEndDateTextVerify") );
		softAssert.assertEquals(action.removeFirstLetter(reporting.getFinalGroupSelectionverifyText().getText()), prop.getProperty("ManageNewPolicyName") );
		
//		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
//		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());
		
		action.click(driver, homepage.getReportsIcon());
		action.click(driver, reporting.getDeviceUsage());
		
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRange"), reporting.getDateRange());
		action.selectByVisibleText(prop.getProperty("ManageNewPolicyName"), reporting.getPolicySelector());
		action.click(driver, reporting.getOKButton());
		
		softAssert.assertEquals(reporting.getStartDateVerifyAtExport().getText(), action.currentDateMinusSeven(8));
		softAssert.assertEquals(reporting.getEndDateVerifyAtExport().getText(), action.currentDateMinusSeven(1));
		
		softAssert.assertEquals(action.removeFirstLetter(reporting.getFinalGroupSelectionverifyText().getText()), prop.getProperty("ManageNewPolicyName") );
		
		action.click(driver, homepage.getReportsIcon());
		action.click(driver, reporting.getDeviceUsage());
		
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRangeTwoWeeks"), reporting.getDateRange());
		action.selectByVisibleText(prop.getProperty("ManageNewPolicyName"), reporting.getPolicySelector());
		action.click(driver, reporting.getOKButton());
		
		softAssert.assertEquals(reporting.getStartDateVerifyAtExport().getText(), action.currentDateMinusSeven(15));
		softAssert.assertEquals(reporting.getEndDateVerifyAtExport().getText(), action.currentDateMinusSeven(1));
		
		softAssert.assertEquals(action.removeFirstLetter(reporting.getFinalGroupSelectionverifyText().getText()), prop.getProperty("ManageNewPolicyName") );
		
		softAssert.assertAll();
	}
	
	//completed
	@Test(priority=26,enabled=false)
	public void reporting_Licence_Summary() throws ParseException {
		reporting = new Reporting(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getReportsIcon());
		action.click(driver, reporting.getLicenseSummary());
		action.click(driver, reporting.getcancelButton());
		action.click(driver, reporting.getLicenseSummary());
		
		softAssert.assertEquals(reporting.getLicenseSummary().getText(), prop.getProperty("LicenseSummaryHeaderText"));
		softAssert.assertEquals(reporting.getBatteryHealthPopUpHeader().getText(), prop.getProperty("LicenseSummaryHeaderText"));
		softAssert.assertEquals(reporting.getLicenseSummaryContentText(), prop.getProperty("LicenseSummaryContentText"));
		action.click(driver, reporting.getOKButton());
		softAssert.assertEquals(action.verifyDropdown(reporting.getExportOption()),action.verifyDropdownList());
		softAssert.assertEquals(reporting.getLicenseStartDate(), action.currentDate());
		softAssert.assertEquals(reporting.getLicenseEnddate(), action.currentDate());
		
		softAssert.assertAll();
	}

	//Completed
	@Test(priority=27,enabled=false)
	public void reporting_Policy_Summary() throws ParseException {
		reporting = new Reporting(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getReportsIcon());
		softAssert.assertEquals(reporting.getPolicySummary().getText(), prop.getProperty("PolicySummaryHeaderText"));
		action.click(driver, reporting.getPolicySummary());
		action.click(driver, reporting.getcancelButton());
		action.click(driver, reporting.getPolicySummary());
		
		softAssert.assertEquals(reporting.getBatteryHealthPopUpHeader().getText(), prop.getProperty("PolicySummaryHeaderText"));
		softAssert.assertEquals(reporting.getLicenseSummaryContentText(), prop.getProperty("PolicySummaryContentText"));
		action.click(driver, reporting.getOKButton());
		softAssert.assertEquals(action.verifyDropdown(reporting.getExportOption()),action.verifyDropdownList());
		
		//Need to check with days
		softAssert.assertEquals(reporting.getLicenseStartDate(), action.currentDateMinusSeven(31));
		softAssert.assertEquals(reporting.getLicenseEnddate(),action.currentDate() );
		
		softAssert.assertAll();		
	}
	
	// working need to add more dropdown content
	@Test(priority=28,enabled=false)
	public void reporting_DevicesVStime() {
		reporting = new Reporting(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getReportsIcon());
		softAssert.assertEquals(reporting.getDeviceVStime().getText(),prop.getProperty("DevicevstimetextVerify") );
		action.click(driver, reporting.getDeviceVStime());
		action.click(driver, reporting.getcancelButton());
		action.click(driver, reporting.getDeviceVStime());
		softAssert.assertEquals(reporting.getBatteryHealthPopUpHeader().getText(), prop.getProperty("DevicevstimeHeaderText"));
		softAssert.assertEquals(reporting.getLicenseSummaryContentText(), prop.getProperty("DevicevstimeContentText"));
		
		
		
		action.type(reporting.getStartDate(), prop.getProperty("BatteryHealthStartDate"));
		action.type(reporting.getEndDate(), prop.getProperty("BatteryHealthEndDate"));
		action.selectByVisibleText(prop.getProperty("ManageNewGroupReName"), reporting.getGroupsSelected());
		action.click(driver, reporting.getOKButton());

		//Verification for the Start date, end date and Policy name
		softAssert.assertEquals(reporting.getStartDateVerifyAtExport().getText(), prop.getProperty("BatteryHealthStartDateTextVerify") );
		softAssert.assertEquals(reporting.getEndDateVerifyAtExport().getText(), prop.getProperty("BatteryHealthEndDateTextVerify") );
		softAssert.assertEquals(action.removeFirstLetter(reporting.getFinalGroupSelectionverifyText().getText()), prop.getProperty("ManageNewGroupReName") );
		
		softAssert.assertAll();	
	}
	
	//Completed
	@Test(priority=29,enabled=false)
	public void reporting_DeviceTypebyPercentage() throws ParseException {

		reporting = new Reporting(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getReportsIcon());
		softAssert.assertEquals(reporting.getDeviceTypePercentage().getText(),prop.getProperty("ReportingDeviceTypePercentageText") );
		action.click(driver,reporting.getDeviceTypePercentage() );
		
		softAssert.assertEquals(reporting.getBatteryHealthPopUpHeader().getText(), prop.getProperty("ReportingDeviceTypePercentageHeaderText"));
		softAssert.assertEquals(reporting.getLicenseSummaryContentText(), prop.getProperty("ReportingDeviceTypePercentageContentText"));
		
		action.selectByVisibleText(prop.getProperty("ManageNewGroupReName"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("ManageNewPolicyName"), reporting.getPolicySelector());
		action.click(driver, reporting.getOKButton());
		
		softAssert.assertEquals(reporting.getStartDateVerifyAtExport().getText(),action.currentDateMinusSeven(31) );
		softAssert.assertEquals(reporting.getEndDateVerifyAtExport().getText(),action.currentDate());
		
		
		softAssert.assertEquals(action.removeFirstLetter(reporting.getFinalGroupSelectionverifyText().getText()), prop.getProperty("ManageNewGroupReName") );
		softAssert.assertEquals(action.removeFirstLetter(reporting.getPolicySelection().getText()), prop.getProperty("ManageNewPolicyName") );
		
		
		action.click(driver, homepage.getReportsIcon());
		softAssert.assertEquals(reporting.getDeviceTypePercentage().getText(),prop.getProperty("ReportingDeviceTypePercentageText") );
		action.click(driver,reporting.getDeviceTypePercentage() );
		
		action.selectByVisibleText(prop.getProperty("GroupsAndPoliciesSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("GroupsAndPoliciesSelected"), reporting.getPolicySelector());
		action.click(driver, reporting.getOKButton());
		
		softAssert.assertEquals(reporting.getStartDateVerifyAtExport().getText(),action.currentDateMinusSeven(31) );
		softAssert.assertEquals(reporting.getEndDateVerifyAtExport().getText(),action.currentDate());
		
		
		softAssert.assertAll();	
	}
	
	// Completed
	@Test(priority=30,enabled=false)
	public void reporting_Power_State_Report() throws ParseException {

		reporting = new Reporting(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getReportsIcon());
		softAssert.assertEquals(reporting.getPowerStateReport().getText(),prop.getProperty("ReportingPowerStateReportVerifyText") );
		action.click(driver,reporting.getPowerStateReport() );
		
		softAssert.assertEquals(reporting.getBatteryHealthPopUpHeader().getText(), prop.getProperty("ReportingPowerStateReportPopUpHeader"));
		softAssert.assertEquals(reporting.getLicenseSummaryContentText(), prop.getProperty("ReportingPowerStateReportPopupContentText"));
		
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRange"), reporting.getDateRange());
	
		action.selectByVisibleText(prop.getProperty("ManageNewGroupReName"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("ManageNewPolicyName"), reporting.getPolicySelector());
		action.dropdown(reporting.getAssetInventoryDeviceTypeSelectorOptions(),prop.getProperty("AssetInventoryDeviceTypesSelected"));
		action.dropdown(reporting.getExportDropDown(),prop.getProperty("ReportingPowerStateReportTimeInterval"));
		action.click(driver, reporting.getOKButton());
		
		softAssert.assertEquals(action.removeFirstLetter(reporting.getFinalGroupSelectionverifyText().getText()), prop.getProperty("ManageNewGroupReName") );
		softAssert.assertEquals(action.removeFirstLetter(reporting.getPolicySelection().getText()), prop.getProperty("ManageNewPolicyName"));
		softAssert.assertEquals(action.removeFirstLetter(reporting.getDeviceSelection().getText()), prop.getProperty("AssetInventoryDeviceTypesSelected"));
		
		action.click(driver, homepage.getReportsIcon());
		softAssert.assertEquals(reporting.getPowerStateReport().getText(),prop.getProperty("ReportingPowerStateReportVerifyText") );
		action.click(driver,reporting.getPowerStateReport() );
		
		action.type(reporting.getStartDate(), prop.getProperty("BatteryHealthStartDate"));
		action.type(reporting.getEndDate(), prop.getProperty("BatteryHealthEndDate"));
		
		action.selectByVisibleText(prop.getProperty("GroupsAndPoliciesSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("GroupsAndPoliciesSelected"), reporting.getPolicySelector());
		action.dropdown(reporting.getExportDropDown(),prop.getProperty("GroupsAndPoliciesSelected"));
		action.click(driver, reporting.getOKButton());
		
		softAssert.assertEquals(reporting.getStartDateVerifyAtExport().getText(), prop.getProperty("BatteryHealthStartDateTextVerify") );
		softAssert.assertEquals(reporting.getEndDateVerifyAtExport().getText(), prop.getProperty("BatteryHealthEndDateTextVerify") );
		
		action.click(driver, homepage.getReportsIcon());
		softAssert.assertEquals(reporting.getPowerStateReport().getText(),prop.getProperty("ReportingPowerStateReportVerifyText") );
		action.click(driver,reporting.getPowerStateReport() );
		
		
		action.selectByVisibleText(prop.getProperty("ReportingPowerStateReportDateRange"), reporting.getDateRange());
		action.dropdown(reporting.getExportDropDown(),prop.getProperty("ReportingPowerStateReportTimeIntervalDay"));
		action.selectByVisibleText(prop.getProperty("GroupsAndPoliciesSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("GroupsAndPoliciesSelected"), reporting.getPolicySelector());
		action.click(driver, reporting.getOKButton());
		
		softAssert.assertEquals(reporting.getStartDateVerifyAtExport().getText(),action.currentDateMinusSeven(31) );
		softAssert.assertEquals(reporting.getLicenseEnddate(), action.currentDate());
		
		softAssert.assertAll();	
	}
	
	//(priority=31)
	@Test(dependsOnMethods= {"validUserLogin"},enabled=false)
	public void logOutFunctionality() {
		homepage = new HomePage(driver);
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getlogout());
		softAssert.assertEquals(indexpage.getLoginDialougeTitle().getText(), prop.getProperty("LoginDialougeTitle"));
		
		action.click(driver, indexpage.getForgotPassword());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ForgotPasswordHeaderMessege"));
		
		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getEmailIDForReset(), prop.getProperty("UnregistredMailID"));
		
		action.click(driver, indexpage.getLogin());
		
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ErorMessege"));
		
		action.click(driver, indexpage.getForgotPassword());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ForgotPasswordHeaderMessege"));
		
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getEmailIDForReset(), prop.getProperty("skumarRegistredMailID"));
		
		action.click(driver, indexpage.getLogin());
		
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ErorMessege"));

		softAssert.assertAll();
	}
}






