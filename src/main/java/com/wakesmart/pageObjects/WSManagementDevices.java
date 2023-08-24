package com.wakesmart.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSManagementDevices {

public WebDriver driver;
	
	public WSManagementDevices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By ManagementDevices = By.xpath("//div[@class='MuiList-root css-uppwh0-MuiList-root']//a[1]");
	By DevicesPageText = By.xpath("//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content']/span");
	
	 @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1rr20st-MuiTypography-root']")
	 public WebElement getManagedSystemsText;
	 
	 @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-sm-9 MuiGrid-grid-md-9 css-13krxle-MuiGrid-root']//button[2]")
	 public WebElement getShowAndHideColumnsButton;
	 
	 @FindBy(xpath = "//div[@role='dialog']/h2")
	 public WebElement getEditDeviceOrderColumnsHeaderText;
	 
	 @FindBy(xpath = "//label[@class='MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd css-j204z7-MuiFormControlLabel-root']/span[1]")
	 public List<WebElement> getEditDeviceOrderColumnsCheckbox;
	 
	 @FindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root']/button[2]")
	 public WebElement getEditDeviceOrderColumnsSaveButton;
	 
	 
	 @FindBy(xpath = "//div[@class='Toastify__toast-body']/div[2]")
	 public WebElement getPopUpMessage;
	 
	 
	 
	 public void uncheckCheckbox() {
		 for(WebElement ele: getEditDeviceOrderColumnsCheckbox) {
			 if(!ele.isSelected()) {
				 ele.click();
			 }
		 }
	 }
	
	
	public WebElement getManagementDevices() {
		return driver.findElement(ManagementDevices);
	}
	
	public WebElement getDevicesPageText() {
		return driver.findElement(DevicesPageText);
	}
	
}
