package com.wakesmart.pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WSManagementDevices {

public WebDriver driver;
	
	public WSManagementDevices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By ManagementDevices = By.xpath("//div[@class='MuiList-root css-uppwh0-MuiList-root']//a[1]");
	By DevicesPageText = By.xpath("//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content']/span");
	
	
	 @FindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root']/button[2]")
	 public WebElement getSubmitButton;
	
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
	
	public WebElement getManagementDevices() {
		return driver.findElement(ManagementDevices);
	}
	
	public WebElement getDevicesPageText() {
		return driver.findElement(DevicesPageText);
	}
	
	
	//Managed systems - click on Wakesmart UI automation
	By managedSystemsGroupSelection = By.xpath("//ul[@role='tree']/li/div/div[2]");
			
			
	public WebElement getmanagedSystemsGroupSelectionForWait(String groupName) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+ groupName +"')]"));
	}
	public List<WebElement> GetmanagedSystemsGroupSelectionList() {
		return  driver.findElements(managedSystemsGroupSelection);
	}
	
	public void getmanagedSystemsGroupSelection(String groupName) {
		
		for(WebElement  element : GetmanagedSystemsGroupSelectionList()) {
			if(element.getText().equalsIgnoreCase(groupName)) {
				element.click();
				break;
			}
		}
	}
	
	
	public void uncheckAllCheckboxes() {

		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary Mui-checked css-dt6pu2-MuiButtonBase-root-MuiCheckbox-root";

		for (int i = 1; i < 23; i++) {
			WebElement ele = driver
					.findElement(By.xpath("//div[@class='MuiBox-root css-1sdcacc']/div/div[" + i + "]/label/span[1]"));
			if (ele.getAttribute("class").equalsIgnoreCase(value)) {
				ele.click();
			}
		}
	}
	
	public void checkAllCheckboxes() {

		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary css-dt6pu2-MuiButtonBase-root-MuiCheckbox-root";

		for (int i = 1; i < 23; i++) {
			WebElement ele = driver.findElement(By.xpath("//div[@class='MuiBox-root css-1sdcacc']/div/div[" + i + "]/label/span[1]"));
			if (ele.getAttribute("class").equalsIgnoreCase(value)) {
				ele.click();
			}
		}
	}
	
	@FindBy(xpath = "//span[@class='ag-header-cell-text']")
	public List<WebElement> tableHeaderTextVerify;

	public void gettableHeaderTextVerify() {
		for (WebElement element : tableHeaderTextVerify) {

			if(element.isDisplayed()) {
				Assert.fail();
			}
		}
	}
}
	

	
	

