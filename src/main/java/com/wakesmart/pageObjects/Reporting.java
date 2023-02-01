package com.wakesmart.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class Reporting extends BaseClass {

	public Reporting(WebDriver driver) {
		this.driver = driver;
	}

	By HeaderTitle = By.xpath("//div[@class='screentitle']");
	By operationalReports = By.xpath("//label[normalize-space()='Operational Reports']");
	By ActivityReports = By.xpath("//label[normalize-space()='Activity Reports']");
	By EnergyReports = By.xpath("//label[normalize-space()='Energy Reports']");
	
	//Battery Health
	By BatteryHealthIcon = By.xpath("//button[@id='bathealth']");
	By BatteryHealthText = By.xpath("//label[normalize-space()='Battery Health']");
	By BatteryHealthPopUpHeader = By.xpath("//div[@id='reportsDlgheader']");
	By StartDateText = By.xpath("//label[normalize-space()='Start Date']");
	By EndDateText = By.xpath("//label[normalize-space()='End Date']");
	By DateRangeText = By.xpath("//label[normalize-space()='Date Range']");
	By GroupSelectedText = By.xpath("//label[normalize-space()='Groups Selected']");
	By StartDate = By.xpath("//input[@id='startdateinput']");
	By EndDate= By.xpath("//input[@id='enddateinput']");
	By DateRange =By.xpath("//select[@id='spanSelector']");
	By GroupsSelected = By.xpath("//select[@id='grpSelector']");
	By OKButton = By.xpath("//button[@id='saveBtn']");
	By Export = By.xpath("//label[normalize-space()='Export']");
	By ExportDropDown = By.xpath("//select[@id='intervalSelector']");
	By StartVerifyAtExport = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/label[2]");
	By FinalGroupSelectionverifyText = By.xpath("//div[1]//label[6]");
	By EndDateVerifyAtExport = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/label[4]");
	
	public WebElement getFinalGroupSelectionverifyText() {
		return driver.findElement(FinalGroupSelectionverifyText);
	}
	
	public WebElement getStartDateVerifyAtExport() {
		return driver.findElement(StartVerifyAtExport);
	}
	
	
	
	public WebElement getExport() {
		return driver.findElement(Export);
	}
	
	public WebElement getExportDropDown() {
		return driver.findElement(ExportDropDown);
	}
	public WebElement getOKButton() {
		return driver.findElement(OKButton);
	}
	
	public WebElement getDateRange() {
		return driver.findElement(DateRange);
	}
	
	public WebElement getGroupsSelected() {
		return driver.findElement(GroupsSelected);
	}
	
	public WebElement getEndDate() {
		return driver.findElement(EndDate);
	}
	
	public WebElement getStartDateText() {
		return driver.findElement(StartDateText);
	}
	public WebElement getEndDateText() {
		return driver.findElement(EndDateText);
	}
	public WebElement getGroupSelectedText() {
		return driver.findElement(GroupSelectedText);
	}
	
	public WebElement getDateRangeText() {
		return driver.findElement(DateRangeText);
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
	
	public WebElement getBatteryHealthIcon() {
		return driver.findElement(BatteryHealthIcon);
	}
	
	public WebElement getBatteryHealthText() {
		return driver.findElement(BatteryHealthText);
	}
	public WebElement getBatteryHealthPopUpHeader() {
		return driver.findElement(BatteryHealthPopUpHeader);
	}
	public WebElement getStartDate() {
		return driver.findElement(StartDate);
	}

	public WebElement getEndDateVerifyAtExport() {
	
		return driver.findElement(EndDateVerifyAtExport);
	}
	
	//Asset Inventory
	
	
	By AssetInventoryIcon = By.xpath("(//button[@class='photothumb'])[2]");
	
	public WebElement getAssetInventoryIcon() {
		return driver.findElement(AssetInventoryIcon);
	}
	
	
	By AssetInventoryHeader = By.xpath("//div[@id='reportsDlgheader']");
	
	public WebElement getAssetInventoryHeader() {
		return driver.findElement(AssetInventoryHeader);
	}
	
	By AssetInventoryReportMessege = By.xpath("//p[@id='reportsMessage']");
	
	public WebElement getAssetInventoryReportMessege() {
		return driver.findElement(AssetInventoryReportMessege);
	}
	
	
	By AssetInventoryGroupsSelectedText = By.xpath("//label[normalize-space()='Groups Selected']");
	
	public WebElement getAssetInventoryGroupsSelectedText() {
		return driver.findElement(AssetInventoryGroupsSelectedText);
	}
	
	By AssetInventoryGroupsSelectedOptions = By.xpath("//select[@id='grpSelector']");
	public WebElement getAssetInventoryGroupsSelectedOptions() {
		return driver.findElement(AssetInventoryGroupsSelectedOptions);
	}
	
	By AssetInventoryDeviceTypesSelected = By.xpath("//label[normalize-space()='Device Types Selected']");
	
	public WebElement getAssetInventoryDeviceTypesSelectedText() {
		return driver.findElement(AssetInventoryDeviceTypesSelected);
	}
	
	By AssetInventoryDeviceTypeSelectorOptions = By.xpath("//select[@id='typeSelector']");
	
	public WebElement getAssetInventoryDeviceTypeSelectorOptions() {
		return driver.findElement(AssetInventoryDeviceTypeSelectorOptions);
	}
	
	By AssetInventoryOkButton = By.xpath("//button[@id='saveBtn']");
	
	public WebElement getAssetInventoryOkButton() {
		return driver.findElement(AssetInventoryOkButton);
	}
	
	
	//Device Usage
	
	By DeviceUsage = By.xpath("//label[normalize-space()='Device Usage']");
	By ReportMessegeText = By.xpath("//p[@id='reportsMessage']");
	By PolicySelector = By.xpath("//select[@id='polSelector']");
	
	public WebElement getPolicySelector() {
		return driver.findElement(PolicySelector);
	}
	
	
	public WebElement getDeviceUsage() {
		return driver.findElement(DeviceUsage);
	}
	
	public String getReportMessegeText() {
		return driver.findElement(ReportMessegeText).getText();
	}
	
	
	//License summary 
	
	By LicenseSummary = By.xpath("//label[normalize-space()='License Summary']");
	By LicenseSummaryContentText = By.xpath("(//div[@id='reportsMessageArea'])/section/div[2]/p");
	By LicenseStartDate = By.xpath("//div[1]//label[2]");
	By LicenseEnddate = By.xpath("//body/div[@class='page']/div[@class='main']/div[@class='full-right-panel']/div[@class='chartsection']/div[1]/div[1]/label[4]");
	By cancelButton = By.xpath("//button[@id='Cancelbtn']");
	By ExportOption = By.xpath("(//select[@id='intervalSelector'])//option");
	
	
	public List<WebElement> getExportOption() {
		return driver.findElements(ExportOption);
	}
	
	public WebElement getcancelButton() {
		return driver.findElement(cancelButton);
	}
	
	public String getLicenseEnddate() {
		return driver.findElement(LicenseEnddate).getText();
	}
	
	
	public String getLicenseStartDate() {
		return driver.findElement(LicenseStartDate).getText();
	}
	
	public WebElement getLicenseSummary() {
		return driver.findElement(LicenseSummary);
	}
	
	public String getLicenseSummaryContentText() {
		return driver.findElement(LicenseSummaryContentText).getText();
	}
	
	
	//Policy Summary
	
	By PolicySummary = By.xpath("//label[normalize-space()='Policy Summary']");
	
	public WebElement getPolicySummary() {
		return driver.findElement(PolicySummary);
	}
	
	//Devices vs Time
	
	By DeviceVStime = By.xpath("//label[normalize-space()='Devices vs. Time']");
	
	
	public WebElement getDeviceVStime() {
		return driver.findElement(DeviceVStime);
	}
	
	
	//Device Type by Percentage
	
	By DeviceTypePercentage = By.xpath("//label[normalize-space()='Device Type by Percentage']");
	By PolicySelection = By.xpath("//div[1]//label[8]");
	
	public WebElement getDeviceTypePercentage() {
		return driver.findElement(DeviceTypePercentage);
	}
	
	public WebElement getPolicySelection() {
		return driver.findElement(PolicySelection);
	}
	
	
	
	
	// Powerstate Report
	
	By PowerStateReport = By.xpath("//label[normalize-space()='Powerstate Report']");
	By DeviceSelection = By.xpath("//div[1]//label[10]");
	
	
	public WebElement getDeviceSelection() {
		return driver.findElement(DeviceSelection);
	}
	
	public WebElement getPowerStateReport() {
		return driver.findElement(PowerStateReport);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
