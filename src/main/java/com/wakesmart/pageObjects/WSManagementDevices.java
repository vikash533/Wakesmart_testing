package com.wakesmart.pageObjects;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	By DevicesPageText = By.xpath("//div[@class='MuiCardHeader-root css-1dj5oyi']//span[text()='Device Management - Joel Inc']");


	@FindBy(xpath = "//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-1vskg8q']//button[2]")
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
	By managedSystemsGroupSelection = By.xpath("//ul[@role='tree']//li/div/div[2]");


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
		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1vb6jjw";

		for (int i = 1; i < 24; i++) {
			WebElement ele = driver
					.findElement(By.xpath("//div[@class='MuiBox-root css-1sdcacc']/div/div[" + i + "]/label/span[1]"));
			if (ele.getAttribute("class").equalsIgnoreCase(value)) {
				ele.click();
			}
		}
	}

	public void checkAllCheckboxes() throws InterruptedException {

		//		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary css-dt6pu2-MuiButtonBase-root-MuiCheckbox-root";
		String value = "MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1vb6jjw";

		for (int i = 1; i < 24; i++) {
			WebElement ele = driver.findElement(By.xpath("//div[@class='MuiBox-root css-1sdcacc']/div/div[" + i + "]/label/span[1]"));
			if (ele.getAttribute("class").equalsIgnoreCase(value)) {
//				Thread.sleep(4000);
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

	//	 By DevicesList = By.xpath("(//div[@role='presentation'])/div/div/div/div[3]/div");
	By DevicesList = By.xpath("//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/child::div/child::div[3]");
	@FindBy(xpath = "//button[@title='Go to next page']")
	public WebElement GoToNextPage;


	public boolean getDevicesList(String deviceName) {
		Actions act = new Actions(driver);
		boolean result = false;
		for (WebElement ele : driver.findElements(DevicesList)) {
			System.out.println("device name "+ele.getText());
			if (ele.getText().equalsIgnoreCase(deviceName)) {
//				ele.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click()", ele);
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
					System.out.println("device name "+ele.getText());
					if (ele.getText().equalsIgnoreCase(deviceName)) {
//						ele.click();
						JavascriptExecutor js = (JavascriptExecutor) driver;
			            js.executeScript("arguments[0].click()", ele);
						act.contextClick(ele).perform();
						result = true;
						break;
					}
				}
			}
		}
		if(!result) {
			if (!result) {
		        
		    }
		}
		return result;
	}




	public boolean getDevicesListSelect(String deviceName) {
		Actions act = new Actions(driver);
		boolean result = false;
		int elementCounter =0;
		for (WebElement ele : driver.findElements(DevicesList)) {
			System.out.println(ele.getText());
			if (ele.getText().equalsIgnoreCase(deviceName)) {
//									ele.click();
				act.contextClick(ele).perform();
				result = true;
				break;
			}
		}

		if(!result) {
			while(!result) {
				GoToNextPage.click();
				System.out.println("next page -----------------------------");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (WebElement ele : driver.findElements(DevicesList)) {
					System.out.println(ele.getText());
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
	public boolean getDevicesListSelect1(String deviceName) {
		Actions act = new Actions(driver);
		boolean result = false;
		for (WebElement ele : driver.findElements(DevicesList)) {
			if (ele.getText().equalsIgnoreCase(deviceName)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click()", ele);
//									ele.click();
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
						//ele.click();
						JavascriptExecutor js = (JavascriptExecutor) driver;
			            js.executeScript("arguments[0].click()", ele);
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
		return  Arrays.asList("Wake","Sleep","Restart","ShutDown","Send Message","Assign Group","Assign Policy","Assign Label","Change Device Name","Upgrade/No Upgrade","License/Unlicensed","Get TIS Data");
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
	//Wake
	By wakeSlectedDevice = By.xpath("//h2[text()='Wake Selected Device']");
	By wakeReasonforActionInputField = By.xpath("(//input[@type='text'])[2]");
	By WakeSaveButton = By.xpath("//button[normalize-space()='Save']");
	public WebElement getwakeSlectedDeviceText() {
		return driver.findElement(wakeSlectedDevice);
	}
	public WebElement getwakeReasonforActionInputField () {
		return driver.findElement(wakeReasonforActionInputField);
	}
	public WebElement getclickSaveButton() {
		return driver.findElement(WakeSaveButton);
		
	}



	//Select group
	@FindBy(xpath = "(//h2[normalize-space()='Group Selected Device'])[1]")
	public WebElement groupSelectedDeviceHeaderText;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl  css-1fzlj8j']/child::div")
	public WebElement groupSelectDropdownClick;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	public List<WebElement> groupSelectDropdownOptionsToSelect;


	public boolean groupSelectForDevice(String groupNeedToSelect) throws InterruptedException {
		Thread.sleep(2000);
		//			JavascriptExecutor executor = (JavascriptExecutor)driver;
		//			executor.executeScript("arguments[0].click();", groupSelectDropdownClick);
		groupSelectDropdownClick.click();
		boolean flag = false;

		for(WebElement ele : groupSelectDropdownOptionsToSelect ) {
			if(ele.getText().equalsIgnoreCase(groupNeedToSelect)) {
				Thread.sleep(2000);
				ele.click();
				flag= true;
				break;
			}
		}
		return flag;
	}





	public boolean getDevicesListVerify(String deviceName) {
		Actions act = new Actions(driver);
		boolean result = false;

		for (WebElement ele : driver.findElements(DevicesList)) {
			if (ele.getText().equalsIgnoreCase(deviceName)) {
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
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}

	//Write xpath and implementation method on policy selected device



	@FindBy(xpath="(//h2[normalize-space()='Policy Selected Device'])[1]")
	public WebElement policySelectedDeviceHeaderText;

	@FindBy(xpath="(//div[@role='combobox' and @aria-haspopup='listbox'])[2]")
	public WebElement policyDropdownClick;

	@FindBy(xpath = "//ul[@role='listbox']/li")
	public List<WebElement> policySelectDropdownOptionsToSelect;

	public boolean policySelectDropdown(String policyNeedToSelect) throws InterruptedException {
		Thread.sleep(3000);
		boolean flag =false;
		policyDropdownClick.click();
		for(WebElement element:policySelectDropdownOptionsToSelect)
		{
			if(element.getText().equalsIgnoreCase(policyNeedToSelect)) {
				Thread.sleep(2000);
				element.click();
				flag=true;
				break;

			}
		}
		return flag;

	}
	@FindBy(xpath="//div[@class='MuiDataGrid-scrollbar MuiDataGrid-scrollbar--vertical css-1b9e9gy']")
	public WebElement horizonatlPageScroller;
	@FindBy(xpath="(//div[normalize-space()='Wake smart UI automation'])[4]")
	public WebElement groupNameVerify;

	@FindBy(xpath="//div[@title='Automation Policy']")
	public WebElement policyNameVerify;

	@FindBy(xpath="//input[@id='input-search-header']")
	public WebElement searchFunctionality;
	
	@FindBy(xpath="//h2[text()='Device Client Label']")
	public WebElement deviceClientLabel;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	public WebElement deviceClientLabeltextField;

	@FindBy(xpath="//div[contains(text(),'Device Name')]")
	public WebElement deviceNameColumn;
	
	@FindBy(xpath="//div[contains(text(),'MAC Address')]")
	public WebElement macAddresColumn;
	
	@FindBy(xpath="//div[contains(text(),'IP Address')]")
	public WebElement ipAddress;
	
	@FindBy(xpath="//div[contains(text(),'OS Version')]")
	public WebElement osVersion;
	
	@FindBy(xpath="//div[contains(text(),'OS Name')]")
	public WebElement osName;
	
	@FindBy(xpath="//button[normalize-space()='Save Column Order']")
	public WebElement saveColumnorder;
	
	//forLicense/Unlicensed device
	@FindBy(xpath = "(//h2[normalize-space()='License Selection For Selected Device'])[1]")
	public WebElement LicenseSelectionForSelectedDevice;
	
	@FindBy(xpath="//div[normalize-space()='Use Rule']")
	public WebElement LisceneseDropdown;
	
	@FindBy(xpath="//ul[@role='listbox']//li")
	public List<WebElement> LisceneseDropdowList;
	
	@FindBy(xpath="//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-1vskg8q']/button[2]")
	public WebElement submitButton;
	
	
	public void LiscenceSelectDropdown(String LiscenesNeedToSelect) throws InterruptedException {
		Thread.sleep(3000);
		boolean flag =false;
		LisceneseDropdown.click();
		for(WebElement element:LisceneseDropdowList)
		{
			if(element.getText().equalsIgnoreCase(LiscenesNeedToSelect)) {
				Thread.sleep(2000);
				element.click();
				flag=true;
				break;

			}
		}

	}

	public boolean getDevicesListSelect2(String deviceName) {
	    Actions act = new Actions(driver);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    boolean result = false;
	    int elementCounter = 0;
	    int scrollBatchSize = 8;  // Scroll every 8 elements
	    int scrollAmount = 500;   // Scroll down by 500 pixels

	    while (!result) {
	        // Get the list of device elements on the current page
	        List<WebElement> deviceElements = driver.findElements(DevicesList);
	        int elementsCount = deviceElements.size();  // Count elements for edge case handling

	        for (WebElement ele : deviceElements) {
	            elementCounter++;
	            System.out.println(ele.getText());

	            if (ele.getText().equalsIgnoreCase(deviceName)) {
	                // Right-click on the device element (context-click)
	                act.contextClick(ele).perform();
	                result = true;
	                break;
	            }

	            // Scroll down the page after every 8th element
	            if (elementCounter % scrollBatchSize == 0 && elementCounter < elementsCount) {
	                js.executeScript("window.scrollBy(0, " + scrollAmount + ");");
	                System.out.println("Scrolled down the page");
	                try {
	                    // Small wait for scroll action to complete and load any new elements
	                    Thread.sleep(1000);  
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        // If the device was not found on the current page, go to the next page
	        if (!result) {
	            try {
	                // Check if the "Next" page button is available and click
	                if (GoToNextPage.isDisplayed()) {
	                    GoToNextPage.click();
	                    System.out.println("Next page -----------------------------");
	                    try {
	                        // Wait for the next page to load
	                        Thread.sleep(2000);  
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    // Reset element counter for the next page
	                    elementCounter = 0;
	                } else {
	                    System.out.println("No more pages to navigate.");
	                    break;  // Exit loop if no more pages are available
	                }
	            } catch (NoSuchElementException e) {
	                System.out.println("No 'Next' page button found.");
	                break;  // Exit loop if no "Next" button is found
	            }
	        }
	    }

	    return result;
	}

}


