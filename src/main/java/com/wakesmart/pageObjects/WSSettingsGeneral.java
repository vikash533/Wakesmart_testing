package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSSettingsGeneral {
	public WebDriver driver;

	public WSSettingsGeneral(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "(//ul[@class='MuiList-root MuiList-padding MuiList-subheader css-p64g7a-MuiList-root'])[2]/a[1]")
	 public WebElement getGeneral;
	 
	 @FindBy(xpath = "//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content']/span")
	 public WebElement getGeneralSettingsText;
	 
	 @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-1rf1nql-MuiGrid-root']/p")
	 public WebElement getSystemOptionsText;
	 
	 @FindBy(xpath = "(//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content'])[2]")
	 public WebElement getGeneralSettingsBoxText;	
	 
	 @FindBy(xpath = "(//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content'])[3]")
	 public WebElement getEnergyValuesText;
	 
	 @FindBy(xpath = "(//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content'])[4]")
	 public WebElement getGreenhouseGasComparisonsText;
	 
	 @FindBy(xpath = "(//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content'])[5]")
	 public WebElement getDashboardPanelSelectionText;
	
	By devicesToShow = By.xpath("//input[@name='showRows']");
	By dataRetention = By.xpath("//input[@name='dataRetention']");
	By checkInterval = By.xpath("//input[@name='checkinInterval']");
	By unlicensedAfter = By.xpath("//input[@name='unlicensedAfter']");
	By showUnlicensedFor = By.xpath("//input[@name='showUnlicensedFor']");
	
	
	public String getDevicesToShow() {
		return driver.findElement(devicesToShow).getAttribute("value");
	}
	public String getdataRetention() {
		return driver.findElement(dataRetention).getAttribute("value");
	}
	public String getcheckInterval() {
		return driver.findElement(checkInterval).getAttribute("value");
	}
	public String getunlicensedAfter() {
		return driver.findElement(unlicensedAfter).getAttribute("value");
	}
	public String getshowUnlicensedFor() {
		return driver.findElement(showUnlicensedFor).getAttribute("value");
	}
	
	
	
	
	
	
}
