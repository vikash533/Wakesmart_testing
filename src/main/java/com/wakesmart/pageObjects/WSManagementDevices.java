package com.wakesmart.pageObjects;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WSManagementDevices {

public WebDriver driver;
	
	public WSManagementDevices(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By ManagementDevices = By.xpath("//div[@class='MuiList-root css-1xidfkz']//a[1]");
	By DevicesPageText = By.xpath("//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content']/span");
	
	
	 @FindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc']/button[2]")
	 public WebElement getSubmitButton;
	
	 @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ilqee0']")
	 public WebElement getManagedSystemsText;
	 
	 @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-sm-9 MuiGrid-grid-md-9 css-vr9lha']//button[2]")
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

//		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary Mui-checked css-dt6pu2-MuiButtonBase-root-MuiCheckbox-root";
		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary Mui-checked css-1vb6jjw";

		for (int i = 1; i < 23; i++) {
			WebElement ele = driver
					.findElement(By.xpath("//div[@class='MuiBox-root css-1sdcacc']/div/div[" + i + "]/label/span[1]"));
			if (ele.getAttribute("class").equalsIgnoreCase(value)) {
				ele.click();
			}
		}
	}
	
	public void checkAllCheckboxes() {

//		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary css-dt6pu2-MuiButtonBase-root-MuiCheckbox-root";
		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary css-1vb6jjw";

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
//	
//	By TableHeader = By.xpath("//div[@role='row']/div[2]");
//	
//	public boolean getTableHeader() {
//		return driver.findElement(TableHeader).isDisplayed();
//	}
//	
	
	 By DevicesList = By.xpath("(//div[@role='presentation'])/div/div/div/div[2]/div");
	
	 @FindBy(xpath = "//button[@title='Go to next page']")
	 public WebElement GoToNextPage;
	 
	 
		public boolean getDevicesList(String deviceName) {
			Actions act = new Actions(driver);
			boolean result = false;
			for (WebElement ele : driver.findElements(DevicesList)) {
				if (ele.getText().equalsIgnoreCase(deviceName)) {
					ele.click();
					act.contextClick(ele).perform();
					result = true;
					break;
				}
			}
			
			if(!result) {
				while(!result) {
					GoToNextPage.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (WebElement ele : driver.findElements(DevicesList)) {
						if (ele.getText().equalsIgnoreCase(deviceName)) {
							ele.click();
							act.contextClick(ele).perform();
							result = true;
							break;
						}
					}
				}
			}
			return result;
		}
		
		
		
		public boolean getDevicesListSelect(String deviceName) {
			Actions act = new Actions(driver);
			boolean result = false;
			for (WebElement ele : driver.findElements(DevicesList)) {
				if (ele.getText().equalsIgnoreCase(deviceName)) {
//					ele.click();
					act.contextClick(ele).perform();
					result = true;
					break;
				}
			}
			
			if(!result) {
				while(!result) {
					GoToNextPage.click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for (WebElement ele : driver.findElements(DevicesList)) {
						if (ele.getText().equalsIgnoreCase(deviceName)) {
//							ele.click();
							act.contextClick(ele).perform();
							result = true;
							break;
						}
					}
				}
			}
			return result;
		}
		
		By RightClickOptionVerify = By.xpath("//ul[@role='menu']/li");
		
		public List<String> getRightClickOptionVerify() {
			List<WebElement> list = driver.findElements(RightClickOptionVerify);
			
			return list.stream().map(WebElement::getText).collect(Collectors.toList());
		}
		
		public List<String> getRightClickOptionVerifyText() {
			return  Arrays.asList("Wake","Sleep","Restart","ShutDown","Send Message","Assign Group","Assign Policy","Assign Label","Change Device Name","Set Baseline","Get Log File","Upgrade/No Upgrade","License/Unlicensed");
		}
		
		
		
		public boolean selectOption(String optionToSelect) {
			List<WebElement> list = driver.findElements(RightClickOptionVerify);
			boolean flag = false;
			
			for(WebElement ele : list) {
				if(ele.getText().equals(optionToSelect)) {
					ele.click();
					flag=true;
					break;
				}
			}
			return flag;
		}
		
		
		//Send Message
		By SendMessageInputField = By.xpath("(//input[@type='text'])[2]");
		By SendMesageToDevices = By.xpath("(//h2[normalize-space()='Send Message To Device'])[1]");
		By SaveButton = By.xpath("//button[normalize-space()='Save']");
		
		
		public WebElement getSendMessageInputField() {
			return driver.findElement(SendMessageInputField);
		}
		
		public WebElement getSendMesageToDevices() {
			return driver.findElement(SendMesageToDevices);
		}
		
		public WebElement getSaveButton() {
			return driver.findElement(SaveButton);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

