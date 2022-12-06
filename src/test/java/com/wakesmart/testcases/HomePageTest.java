package com.wakesmart.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.About;
import com.wakesmart.pageObjects.HomePage;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.Manage;
import com.wakesmart.pageObjects.Reporting;
import com.wakesmart.pageObjects.User;

public class HomePageTest extends BaseClass {

	public WebDriver driver;
	public Action action;
	private HomePage homepage;
	private IndexPage indexpage;
	private User user;
	private About about;
	private Reporting reporting;
	private Manage manage;

	@BeforeClass
	public void browserLaunch() throws IOException {
		driver = launchBrowser();
		driver.get(prop.getProperty("url"));
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

	@Test
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

	@Test(dependsOnMethods = { "validUserLogin" })
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

	@Test(dependsOnMethods = { "user" })
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

	@Test(dependsOnMethods = { "about" })
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
	

	@Test(dependsOnMethods = { "reporting" })
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

	@Test(priority = 1)
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

		String newGroupName = action.nameVerifyFromTable(manage.getGroupNameVeriyText(),
				prop.getProperty("ManageNewGroupName"));
		action.softAssertion(newGroupName, prop.getProperty("ManageNewGroupName"));

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

	@Test(priority = 2)
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
	@Test(dependsOnMethods= {"validUserLogin"},priority = 3)
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
		
		
		
		
		
		
	}

}
