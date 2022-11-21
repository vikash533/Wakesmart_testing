package com.wakesmart.pageObjects;

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
}
