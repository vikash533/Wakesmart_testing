package com.wakesmart.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSHomePage;
import com.wakesmart.pageObjects.WSManagement;
import com.wakesmart.pageObjects.WSReports;

public class WSReportsTest extends BaseClass {
	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSReports report;
	
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
	
	@Test(priority = 1)
	public void operationalReports() throws InterruptedException {
		
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		report = new WSReports(driver);
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		Thread.sleep(6000);
		action.JSClick(driver,report.getoperationalReports());
		
		String BatteryHealth = action.getElementvalueusingJS(driver, report.getBatteryHealthIcon());
		String AssetInventory = action.getElementvalueusingJS(driver, report.getAssetInventoryIcon());
		String DeviceType = action.getElementvalueusingJS(driver, report.getDeviceTypeIcon());
		String LicenseSummary = action.getElementvalueusingJS(driver, report.getLicenseSummaryIcon());
		String PolicySummary = action.getElementvalueusingJS(driver, report.getPolicySummaryIcon());
		String GroupSummary = action.getElementvalueusingJS(driver, report.getGroupSummaryIcon());
		softAssert.assertEquals(BatteryHealth,prop.getProperty("BatteryHealthText") );
		softAssert.assertEquals(AssetInventory,prop.getProperty("AssetInventoryHeader") );
		softAssert.assertEquals(DeviceType,prop.getProperty("DeviceText") );
		softAssert.assertEquals(LicenseSummary,prop.getProperty("LicenseSummaryHeaderText") );
		softAssert.assertEquals(PolicySummary,prop.getProperty("PolicySummaryHeaderText") );
		softAssert.assertEquals(GroupSummary,prop.getProperty("GroupSummaryText") );
		action.click(driver,report.getoperationalReportArrowMark());
		softAssert.assertAll();
	}
	@Test(priority = 3,dependsOnMethods = {"operationalReports"})
	public void validateBatteryHealth()  {
		try {
		action.fluentWait(driver, report.getBatteryHealthIcon());
		action.JSClick(driver, report.getBatteryHealthIcon());
		softAssert.assertEquals(report.getBatteryHealthPopUpHeader().getText(), prop.getProperty("BatteryHealthStatisticsText"));
		softAssert.assertEquals(report.getGroupSelectedText().getText(), prop.getProperty("GroupSelectedText"));
		softAssert.assertEquals(report.getStartDateText().getText(), prop.getProperty("StartDateText"));
		softAssert.assertEquals(report.getEndDateText().getText(), prop.getProperty("EndDateText"));
		action.click(driver, report.getGroupsSelectedIcon());
		Thread.sleep(4000);
		action.getSelectOptionFromDropdown(report.getGroupsSelected(), prop.getProperty("GroupSelectDropdownText"));
		action.isEnabled(driver, report.getSubmitButton());
		action.click(driver, report.getSubmitButton());
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
		
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test(priority=2,dependsOnMethods = {"operationalReports"},enabled = false)
	public void validateFutureDate() throws InterruptedException  {
	
		action.fluentWait(driver, report.getBatteryHealthIcon());
		action.JSClick(driver, report.getBatteryHealthIcon());
		action.click(driver, report.getStartDateCalenderIcon());
		action.selectDateFromCalendar(driver,report.getCalendarMonthYear(), report.getCalendarBackward(), report.getCalendarDate(), "2", "March", "2023");
	
	}

	@Test(priority=4,dependsOnMethods = {"operationalReports"})
	public void assetInventorySelectGroup() throws InterruptedException {
		action.fluentWait(driver, report.getBatteryHealthIcon());
		action.JSClick(driver, report.getAssetInventoryIcon());
		softAssert.assertEquals(report.getAssetInventoryHeader().getText(), prop.getProperty("AssetInventoryHeader"));
		action.click(driver, report.getSubmitButtonAssetInventory());
		softAssert.assertEquals(report.getAssetInventoryHeader().getText(), prop.getProperty("AssetInventoryHeader"));
		action.click(driver, report.getAssetInventoryExportButton());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
		action.refreshPage(driver);
		Thread.sleep(4000);
		System.out.println(report.getAssetInventorySelectGroup().getText());
		softAssert.assertEquals(report.getAssetInventorySelectGroup().getText(),prop.getProperty("AssetInventoryDefaultGropsSelected"));
		action.click(driver,report.getAssetInventorySelectGroup());
		System.out.println(action.verifyDropdown(report.getAssetInventorySelectGroupOptions()));
		action.getSelectOptionFromDropdown(report.getAssetInventorySelectGroupOptions(), prop.getProperty("AssetInventoryDefaultGropsSelected1"));
		action.click(driver,report.getAssetInventorySelectDevice());
		System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
		action.getSelectOptionFromDropdown(report.getAssetInventorySelectDeviceOptions(), prop.getProperty("AssetInventoryDeviceTypesSelected"));
		action.click(driver, report.getSubmitButtonAssetInventory());
		action.click(driver, report.getAssetInventoryExportButton());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
		action.refreshPage(driver);
		softAssert.assertAll();
	}
	@Test(priority=3,dependsOnMethods = {"operationalReports"})
	public void DeviceType() throws InterruptedException {
		action.fluentWait(driver, report.getDeviceTypeIcon());
		action.JSClick(driver, report.getDeviceTypeIcon());
		softAssert.assertEquals(report.getDeviceSummaryHeaderText().getText(), prop.getProperty("DeviceSummaryHeaderText"));
		softAssert.assertEquals(report.getDeviceSummaryContextText().getText(), prop.getProperty("DeviceSummaryContextText"));
		action.click(driver,report.getDeviceTypeSelectGroup());
		Thread.sleep(4000);
		
		
		
	}
	@Test(priority=5,dependsOnMethods = {"operationalReports"})
	public void licenceSummary() {
//		action.JSClick(driver,report.getoperationalReports());
		action.scrollByVisibilityOfElement(driver, report.getLicenseSummaryIcon());
		action.fluentWait(driver, report.getLicenseSummaryIcon());
		action.click(driver, report.getLicenseSummaryIcon());
		softAssert.assertEquals(report.getLicenseSummaryHeaderText().getText(), prop.getProperty("LicenseSummaryHeaderText"));
		System.out.println(report.getLicenseSummaryUsage().getText());
		action.click(driver, report.getAssetInventoryExportButton());
		System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
		action.refreshPage(driver);
		
	}
	@Test(priority=6,dependsOnMethods = {"operationalReports"})
	public void policySummary() {
		action.scrollByVisibilityOfElement(driver, report.getPolicySummaryIcon());
		action.fluentWait(driver, report.getPolicySummaryIcon());
		action.click(driver, report.getPolicySummaryIcon());
		softAssert.assertEquals(report.getPolicySummaryText().getText(), prop.getProperty("PolicySummaryHeaderText"));
		softAssert.assertEquals(report.getListOfPolicyText().getText(), prop.getProperty("PolicySummaryContentText"));
		action.click(driver, report.getAssetInventoryExportButton());
		System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
		
	}
	@Test(priority=7,dependsOnMethods = {"operationalReports"})
	public void groupSummary() {
		action.scrollByVisibilityOfElement(driver, report.getGroupSummaryIcon());
		action.fluentWait(driver, report.getGroupSummaryIcon());
		action.click(driver, report.getGroupSummaryIcon());
		softAssert.assertEquals(report.getGroupSummaryText().getText(), prop.getProperty("GroupSummaryText"));
		softAssert.assertEquals(report.getListOfGroupText().getText(), prop.getProperty("GroupSummaryContentText"));
		action.click(driver, report.getAssetInventoryExportButton());
		System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
		
	}
	@Test(priority=8,dependsOnMethods = {"operationalReports"})
	public void ActivityReport() throws InterruptedException {
		action.JSClick(driver,report.getoperationalReports());
		action.scrollByVisibilityOfElement(driver, report.getActivityReportsIcon());
		action.fluentWait(driver, report.getActivityReportsIcon());
		action.click(driver, report.getActivityReportsDeviceUsage());
		softAssert.assertEquals(report.getActivityReportsDeviceUsageSummaryText().getText(), prop.getProperty("DeviceUsageText"));
		softAssert.assertEquals(report.getActivityReportsDeviceUsageContentText().getText(), prop.getProperty("DeviceUsageContentText"));
		action.click(driver, report.getActivityReportsDeviceDateRange());
		Thread.sleep(4000);
		List<String> listOfDateRange = action.verifyDropdown(report.getActivityReportsDeviceDateRangeOptions());
		System.out.println(listOfDateRange);
		action.nameVerifyFromTableAndClick(report.getActivityReportsDeviceDateRangeOptions(),prop.getProperty("DeviceUsageDateRangeText"));
		Thread.sleep(4000);
		action.click(driver, report.getActivityReportsDeviceSelectGroup());
		List<String> listofGroupSelected = action.verifyDropdown(report.getActivityReportsDeviceSelectGroupOptions());
		System.out.println(listofGroupSelected);
		action.nameVerifyFromTableAndClick(report.getActivityReportsDeviceSelectGroupOptions(),prop.getProperty("DeviceUsageDateGroupText"));
		action.fluentWait(driver, report.getSubmitButton());
		action.JSClick(driver, report.getSubmitButton());
		action.click(driver, report.getAssetInventoryExportButton());
		System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
	}
	@Test(priority=8,dependsOnMethods = {"operationalReports","ActivityReport"})
	public void DeviceVsTime() throws InterruptedException {
		action.JSClick(driver,report.getActivityReportsDeviceVsTime());
		softAssert.assertEquals(report.getActivityReportsDeviceVsTimeHeaderText().getText(), prop.getProperty("DevicevstimetextVerify"));
		softAssert.assertEquals(report.getActivityReportsDevicevstimeContentText().getText(), prop.getProperty("DevicevstimeContentText"));
		action.click(driver, report.getActivityReportsDeviceDateRange());
		Thread.sleep(4000);
		List<String> listOfDateRange = action.verifyDropdown(report.getActivityReportsDeviceDateRangeOptions());
		System.out.println(listOfDateRange);
		action.nameVerifyFromTableAndClick(report.getActivityReportsDeviceDateRangeOptions(),prop.getProperty("DeviceUsageDateRangeText"));
		Thread.sleep(4000);
		action.click(driver, report.getActivityReportsDeviceSelectGroup());
		List<String> listofGroupSelected = action.verifyDropdown(report.getActivityReportsDeviceSelectGroupOptions());
		System.out.println(listofGroupSelected);
		action.nameVerifyFromTableAndClick(report.getActivityReportsDeviceSelectGroupOptions(),prop.getProperty("DeviceVsTimeselectGroup"));
		Thread.sleep(4000);
		action.fluentWait(driver, report.getActivityReportsDevicevstimesubmitButton());
		action.click(driver, report.getActivityReportsDevicevstimesubmitButton());
		action.click(driver, report.getAssetInventoryExportButton());
		System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
		action.click(driver, report.getExport());
		action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
	}


}
