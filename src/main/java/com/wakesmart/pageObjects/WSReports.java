package com.wakesmart.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class WSReports extends BaseClass {
	public WebDriver driver;
	
	public WSReports(WebDriver driver) {
		this.driver = driver;
	}
	
	By HeaderTitle = By.xpath("//span[normalize-space()='Reports']");
	By operationalReports = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiList-subheader css-19o40po'])[3]/div[1]");
	By operationalReportArrowMark = By.xpath("(//*[name()='svg'][@class='icon icon-tabler icon-tabler-chevron-down'])[2]");
	By ActivityReports = By.xpath("//p[normalize-space()='Activity Reports']");
	By EnergyReports = By.xpath("//p[normalize-space()='Energy Reports']");
	By CustomReports = By.xpath("//p[normalize-space()='Custom Reports']");
	
	//Battery Health
	By BatteryHealthIcon = By.xpath("(//div[@class='MuiList-root css-1xidfkz']/a/div[2])[1]");
	By BatteryHealthPopUpHeader = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	By StartDateText = By.xpath("//label[normalize-space()='Start Date']");
	By EndDateText = By.xpath("//label[normalize-space()='End Date']");

	By GroupSelectedText = By.xpath("//label[normalize-space()='Select Group']");
	By StartDateCalenderIcon = By.xpath("(//div[@class='MuiFormControl-root MuiTextField-root css-feqhe6']/div/div/button)[1]");
	By StartDate = By.xpath("//input[@id=':r0:']");
	By EndDate= By.xpath("//input[@id=':r1:']");
	By EndDateCalendarIcon= By.xpath("(//div[@class='MuiFormControl-root MuiTextField-root css-feqhe6']/div/div/button)[2]");

	By GroupsSelectedIcon = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-l4rh9y'])[2]/div");
	By GroupsSelected = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	By SubmitButton = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-l4rh9y'])[3]/button");
	By Export = By.xpath("//button[@id='basic-button']");
	By ExportDropDown = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	By CalendarBackward = By.xpath("(//div[@class='MuiPickersArrowSwitcher-root css-k008qs']/button)[1]");
	By CalendarMonthYear = By.xpath("//div[@class='MuiPickersFadeTransitionGroup-root css-1bx5ylf']");
	By CalendarForward = By.xpath("(//div[@class='MuiPickersArrowSwitcher-root css-k008qs']/button)[2]");
	By CalendarDate =By.xpath("//div[@class='PrivatePickersSlideTransition-root MuiDayPicker-slideTransition css-1cnkspq']/div/div/button/span");
//	By CalendarDate =By.xpath("//div[@class='MuiDayPicker-weekContainer css-mvmu1r']/button[normalize-space()='18']");
	By CalendarYearDropdown =By.xpath("//button[@aria-label='calendar view is open, switch to year view']//*[name()='svg']");
	By NumberOfYear =By.xpath("//div[@class='MuiPickersFadeTransitionGroup-root MuiCalendarPicker-viewTransitionContainer css-1h73gvd']//button");
	public WebElement getoperationalReportArrowMark() {
		return driver.findElement(operationalReportArrowMark);
	}
	
	public List<WebElement> getNumberOfYear() {
		return driver.findElements(NumberOfYear);
	}
	public WebElement getHeaderTitle() {
		return driver.findElement(HeaderTitle);
	}
	public WebElement getoperationalReports() {
		return driver.findElement(operationalReports);
	}
	public WebElement getActivityReports() {
		return driver.findElement(ActivityReports);
	}
	public WebElement getEnergyReports() {
		return driver.findElement(EnergyReports);
	}
	public WebElement getCustomReports() {
		return driver.findElement(CustomReports);
	}
	public WebElement getBatteryHealthIcon() {
		return driver.findElement(BatteryHealthIcon);
	}
	public WebElement getBatteryHealthPopUpHeader() {
		return driver.findElement(BatteryHealthPopUpHeader);
	}
	public WebElement getStartDateText() {
		return driver.findElement(StartDateText);
	}
	public WebElement getStartDateCalenderIcon() {
		return driver.findElement(StartDateCalenderIcon);
	}
	public WebElement getCalendarYearDropdown() {
		return driver.findElement(CalendarYearDropdown);
	}
	public WebElement getCalendarMonthYear() {
		return driver.findElement(CalendarMonthYear);
	}
	public WebElement getCalendarBackward() {
		return driver.findElement(CalendarBackward);
	}
	public WebElement getCalendarForward() {
		return driver.findElement(CalendarForward);
	}
	public WebElement getEndDateCalendarIcon() {
		return driver.findElement(EndDateCalendarIcon);
	}
	public List<WebElement> getCalendarDate() {
		return driver.findElements(CalendarDate);
	}
	public WebElement getEndDateText() {
		return driver.findElement(EndDateText);
	}
	public WebElement getGroupSelectedText() {
		return driver.findElement(GroupSelectedText);
	}
	public WebElement getStartDate() {
		return driver.findElement(StartDate);
	}
	public WebElement getEndDate() {
		return driver.findElement(EndDate);
	}
	public WebElement getGroupsSelectedIcon() {
		return driver.findElement(GroupsSelectedIcon);
	}
	public List<WebElement> getGroupsSelected() {
		return driver.findElements(GroupsSelected);
	}
	public WebElement getSubmitButton() {
		return driver.findElement(SubmitButton);
	}
	public WebElement getExport() {
		return driver.findElement(Export);
	}
	public List<WebElement> getExportDropDown() {
		return driver.findElements(ExportDropDown);
	}
	
	
//	By AssetInventoryIcon = By.xpath("(//div[@class='MuiList-root css-1xidfkz']/a/div[2])[2]");
	By AssetInventoryIcon = By.xpath("((//div[@class='MuiList-root css-1xidfkz']/a/div[2])[2])/p");
	By SubmitButtonAssetInventory = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']//button");
	By AssetInventorySelectGroup = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']/div/div)[1]/div/div");
	By AssetInventorySelectDevice = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']/div/div)[2]/div/div");
	public By AssetInventorySelectGroupOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	By AssetInventorySelectDeviceOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	By AssetInventoryExportButton =By.xpath("//div[@class='MuiGrid-root css-1haci7g']/button");
	
	public WebElement getAssetInventoryIcon() {
		return driver.findElement(AssetInventoryIcon);
	}
	public WebElement getSubmitButtonAssetInventory() {
		return driver.findElement(SubmitButtonAssetInventory);
	}
	public WebElement getAssetInventorySelectGroup() {
		return driver.findElement(AssetInventorySelectGroup);
	}
	public List<WebElement> getAssetInventorySelectGroupOptions() {
		return driver.findElements(AssetInventorySelectGroupOptions);
	}
	public WebElement getAssetInventorySelectDevice() {
		return driver.findElement(AssetInventorySelectDevice);
	}
	public List<WebElement> getAssetInventorySelectDeviceOptions() {
		return driver.findElements(AssetInventorySelectDeviceOptions);
	}
	public WebElement getAssetInventoryExportButton() {
		return driver.findElement(AssetInventoryExportButton);
	}
	
	
	By DeviceTypeIcon = By.xpath("//div[@class='MuiList-root css-1xidfkz']/a[3]//p");
	public WebElement getDeviceTypeIcon() {
		return driver.findElement(DeviceTypeIcon);
	}
	By DeviceSummaryHeaderText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	public WebElement getDeviceSummaryHeaderText() {
		return driver.findElement(DeviceSummaryHeaderText);
	}
	By DeviceSummaryContextText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-10 css-1v3pb4k']/p");
	public WebElement getDeviceSummaryContextText() {
		return driver.findElement(DeviceSummaryContextText);
	}
	By DeviceTypeSelectGroup = By.xpath("//div[@id='mui-component-select-group']");
	public WebElement getDeviceTypeSelectGroup() {
		return driver.findElement(DeviceTypeSelectGroup);
	}
	By DeviceTypeSelectGroupOptions = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']/div/div)[1]/div/div");
	public List<WebElement> getDeviceTypeSelectGroupOptions() {
		return driver.findElements(DeviceTypeSelectGroupOptions);
	}
	By DeviceTypeSelectPolicy = By.xpath("//div[@id='mui-component-select-policy']");
	public WebElement getDeviceTypeSelectPolicy() {
		return driver.findElement(DeviceTypeSelectPolicy);
	}
	By DeviceTypeSelectPolicyOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	public List<WebElement> getDeviceTypeSelectPolicyOptions() {
		return driver.findElements(DeviceTypeSelectPolicyOptions);
	}
	By DeviceTypeSubmitButton = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-l4rh9y'])[2]/button");
	public WebElement getDeviceTypeSubmitButton() {
		return driver.findElement(DeviceTypeSubmitButton);
	}
	
	
	
	
	By AssetInventoryHeader = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	public WebElement getAssetInventoryHeader() {
		return driver.findElement(AssetInventoryHeader);
	}
	
	
	By LicenseSummaryIcon = By.xpath("((//div[@class='MuiList-root css-1xidfkz']/a/div[2])[4])/p");
	public WebElement getLicenseSummaryIcon() {
		return driver.findElement(LicenseSummaryIcon);
	}
	By LicenseSummaryHeaderText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	public WebElement getLicenseSummaryHeaderText() {
		return driver.findElement(LicenseSummaryHeaderText);
	}
	By LicenseSummaryUsage = By.xpath("//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-15r4zcf']/table/thead");
	public WebElement getLicenseSummaryUsage() {
		return driver.findElement(LicenseSummaryUsage);
	}
	By LicenseSummaryUsagevalue = By.xpath("(//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-15r4zcf']/table/tbody/tr)[1]/td");
	public List<WebElement> getLicenseSummaryUsagevalue() {
		return driver.findElements(LicenseSummaryUsage);
	}
	
	
	By PolicySummaryIcon = By.xpath("((//div[@class='MuiList-root css-1xidfkz']/a/div[2])[5])/p");
	public WebElement getPolicySummaryIcon() {
		return driver.findElement(PolicySummaryIcon);
	}
	By PolicySummaryText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	public WebElement getPolicySummaryText() {
		return driver.findElement(PolicySummaryText);
	}
	By ListOfPolicyText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-10 css-1v3pb4k']/p");
	public WebElement getListOfPolicyText() {
		return driver.findElement(ListOfPolicyText);
	}
	
	
	By GroupSummaryIcon = By.xpath("((//div[@class='MuiList-root css-1xidfkz']/a/div[2])[6])/p");
	public WebElement getGroupSummaryIcon() {
		return driver.findElement(GroupSummaryIcon);
	}
	By GroupSummaryText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	public WebElement getGroupSummaryText() {
		return driver.findElement(PolicySummaryText);
	}
	By ListOfGroupText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-10 css-1v3pb4k']/p");
	public WebElement getListOfGroupText() {
		return driver.findElement(ListOfPolicyText);
	}
	
	By ActivityReportsIcon = By.xpath("(//div[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters css-m92ebk'])[3]/div[2]");
	public WebElement getActivityReportsIcon() {
		return driver.findElement(ActivityReportsIcon);
	}
	By ActivityReportsDeviceUsage = By.xpath("(//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//div[@class='MuiListItemText-root css-n5xu2x'])[1]");
	public WebElement getActivityReportsDeviceUsage() {
		return driver.findElement(ActivityReportsDeviceUsage);
	}
	By ActivityReportsDeviceUsageSummaryText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	public WebElement getActivityReportsDeviceUsageSummaryText() {
		return driver.findElement(ActivityReportsDeviceUsageSummaryText);
	}
	By ActivityReportsDeviceUsageContentText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-10 css-1v3pb4k']/p");
	public WebElement getActivityReportsDeviceUsageContentText() {
		return driver.findElement(ActivityReportsDeviceUsageContentText);
	}
	By ActivityReportsDeviceDateRange = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']/div[3]//div[@id='mui-component-select-date_range']");
	public WebElement getActivityReportsDeviceDateRange() {
		return driver.findElement(ActivityReportsDeviceDateRange);
	}
	By ActivityReportsDeviceDateRangeOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	public List<WebElement> getActivityReportsDeviceDateRangeOptions() {
		return driver.findElements(ActivityReportsDeviceDateRangeOptions);
	}
	By ActivityReportsDeviceSelectGroup = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']/div[4]/div[@class='MuiFormControl-root css-tzsjye']");
	public WebElement getActivityReportsDeviceSelectGroup() {
		return driver.findElement(ActivityReportsDeviceSelectGroup);
	}
	By ActivityReportsDeviceSelectGroupOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	public List<WebElement> getActivityReportsDeviceSelectGroupOptions() {
		return driver.findElements(ActivityReportsDeviceSelectGroupOptions);
	}
	By ActivityReportsDeviceUsageSubmitButton = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-l4rh9y'])[4]/button");
	public WebElement getActivityReportsDeviceUsageSubmitButton() {
		return driver.findElement(ActivityReportsDeviceUsageSubmitButton);
	}
	
	
	By ActivityReportsDeviceVsTime = By.xpath("(//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//div[@class='MuiListItemText-root css-n5xu2x'])[2]");
	public WebElement getActivityReportsDeviceVsTime() {
		return driver.findElement(ActivityReportsDeviceVsTime);
	}
	By ActivityReportsDeviceVsTimeHeaderText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	public WebElement getActivityReportsDeviceVsTimeHeaderText() {
		return driver.findElement(ActivityReportsDeviceVsTimeHeaderText);
	}
	By ActivityReportsDevicevstimeContentText = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-10 css-1v3pb4k']/p");
	public WebElement getActivityReportsDevicevstimeContentText() {
		return driver.findElement(ActivityReportsDevicevstimeContentText);
	}
	By ActivityReportsDevicevstimesubmitButton = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-l4rh9y'])[4]/button");
	public WebElement getActivityReportsDevicevstimesubmitButton() {
		return driver.findElement(ActivityReportsDevicevstimesubmitButton);
	}
	
	
	
	
	By ActivityReportsPowerstateVsTime = By.xpath("(//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']//div[@class='MuiListItemText-root css-n5xu2x'])[3]");
	public WebElement getActivityReportsPowerstateVsTime() {
		return driver.findElement(ActivityReportsPowerstateVsTime);
	}
	By ActivityReportsPowerandActivityReport = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");
	public WebElement getActivityReportsSavingsSummary() {
		return driver.findElement(ActivityReportsPowerandActivityReport);
	}
	By ActivityReportsPowerStateVsTimeDateRange = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']/div[3]//div[@id='mui-component-select-date_range']");
	public WebElement getActivityReportsPowerStateVsTimeDateRange() {
		return driver.findElement(ActivityReportsPowerStateVsTimeDateRange);
	}
	By ActivityReportsPowerStateVsTimeDateRangeOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	public List<WebElement> getActivityReportsPowerStateVsTimeDateRangeOptions() {
		return driver.findElements(ActivityReportsPowerStateVsTimeDateRangeOptions);
	}
	By ActivityReportsPowerStateVsTimeDateTimeInterval = By.xpath("//div[@id='mui-component-select-time_interval']");
	public WebElement getActivityReportsPowerStateVsTimeDateTimeInterval() {
		return driver.findElement(ActivityReportsPowerStateVsTimeDateTimeInterval);
	}
	By ActivityReportsPowerStateVsTimeIntervalOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	public List<WebElement> getActivityReportsPowerStateVsTimeIntervalOptions() {
		return driver.findElements(ActivityReportsPowerStateVsTimeIntervalOptions);
	}
	By ActivityReportsPowerStateVsTimeSelectDeviceType = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']/div[4]/div");
	public WebElement getActivityReportsPowerStateVsTimeSelectDeviceType() {
		return driver.findElement(ActivityReportsPowerStateVsTimeSelectDeviceType);
	}
	By ActivityReportsPowerStateVsTimeSelectDeviceOption = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li");
	public List<WebElement> getActivityReportsPowerStateVsTimeSelectDeviceOption() {
		return driver.findElements(ActivityReportsPowerStateVsTimeSelectDeviceOption);
	}
	By ActivityReportsPowerStateVsTimeSubmitButton = By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye']/div[8]");
	public WebElement getActivityReportsPowerStateVsTimeSubmitButton() {
		return driver.findElement(ActivityReportsPowerStateVsTimeSubmitButton);
	}
	By ActivityReportsPowerStateVsTimeExportButton = By.xpath("//div[@class='MuiGrid-root css-1haci7g']/button");
	public WebElement getActivityReportsPowerStateVsTimeExprotButton() {
		return driver.findElement(ActivityReportsPowerStateVsTimeExportButton);
	}
	

}
