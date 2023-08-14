package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.wakesmart.base.BaseClass;

public class WSManagement extends BaseClass{
	
	
	public WSManagement(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<String> getTableHeaderTextVerify(List<WebElement> list) {

		List<String> textVerify = new ArrayList<>();

		for (WebElement element : list) {
			textVerify.add(element.getText());
		}
		return textVerify;
	}
	
	
	
	By ManagementTab = By.xpath("(//div[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters css-1oip95y-MuiButtonBase-root-MuiListItemButton-root'])[1]");
	
	//Policies
	By Policies = By.xpath("(//div[@class='MuiList-root css-uppwh0-MuiList-root'])/a[3]/div[2]");
	By PolicyManagement = By.xpath("(//div[@class='MuiCardHeader-root css-1nvdc5e-MuiCardHeader-root'])//div/span");
	By PolicyManagementTableHeaderText = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item css-4c1867-MuiGrid-root'])//div/p");
	By PoliciesInnerTableHeaderText = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-12 css-1idn90j-MuiGrid-root'])//table/thead/tr/th");
	By AddPolicyBtn = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-1equabv-MuiGrid-root'])//button");
	By PolicyName = By.xpath("(//div[@class='MuiFormControl-root MuiTextField-root css-136h9lv-MuiFormControl-root-MuiTextField-root'])[1]/div/input");
	By PolicyDescription = By.xpath("(//div[@class='MuiFormControl-root MuiTextField-root css-136h9lv-MuiFormControl-root-MuiTextField-root'])[2]/div/input");
	By AddSchemeButton = By.xpath("(//div[@class='MuiBox-root css-blgins'])/div/div[2]/button");
	//pending
	By AddNewSchemeHeaderText = By.xpath("(//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm css-1pwda69'])[2]/h2");
	By PoliciesSchemeName = By.xpath("(//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm css-1pwda69'])[2]/h2");
	By SchemeName = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 css-1s50f5r'])[1]/div/div/input");
	
	By NewSchemeName = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1lf2b4f-MuiInputBase-root-MuiOutlinedInput-root'])[3]/input");
	By NewSchemeDescription = By.xpath("(//div[@class='MuiDialogContent-root css-3fsl0h-MuiDialogContent-root'])/div[1]/div/div[2]/div/div/input");
	By WeekDaysCheckBox = By.xpath("(//div[@class='MuiBox-root css-1yuhvjn'])/div/label/span[1]");
	By NewSchemeStartTime = By.xpath("(//div[@class='MuiBox-root css-1qm1lh'])/div/div[1]/input");
	
	By NewSchemeEndTime = By.xpath("(//div[@class='MuiBox-root css-1qm1lh'])/div/div[2]/input");
	By displayInactivityTimeout = By.xpath("//input[@name='displayInactivityTimeoutAC']");
	By DisplayInactivityDropdown = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-6hp17o-MuiList-root-MuiMenu-list']//li");
	By USBSleepONAC = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-6hp17o-MuiList-root-MuiMenu-list'])//li");
	By CPUMax = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-a5rdam-MuiGrid-root'])[4]/div[6]/div/div/input");
	By DiskMax = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-a5rdam-MuiGrid-root'])[4]/div[7]/div/div/input");
	By NetworkMax =By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-a5rdam-MuiGrid-root'])[4]/div[8]/div/div/input");
	By ScreenDim = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-a5rdam-MuiGrid-root'])[4]/div[9]/div/div/input");
	By Brightness = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-a5rdam-MuiGrid-root'])[4]/div[10]/div/div/input");
	By AddNewSchemeSaveButton = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root'])[2]/button[2]");
	By NewSchemeEndTimeVerifyText = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[2]/td[4]");
	By DefaultSchemeEndTimeVerifyText = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[1]/td[4]");
	By NewSchemeStartTimeVerifyText = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[2]/td[3]");
	By DefaultSchemeStartTimeVerifyText = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[1]/td[3]");
	By NewSchemeDaysVerifyText = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[2]/td[2]");
	By DefaultSchemeDaysVerifyText = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[1]/td[2]");
	By NewSchemeNameVerifyText = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[2]/td[1]");
	By NewDefaultSchemeNameVerifyText = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[1]/td[1]");
	By EventSelectorDropDownList = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-6hp17o-MuiList-root-MuiMenu-list'])//li");
	By ScduledEventAddButton = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-1equabv-MuiGrid-root'])[3]/button");
	By ScheduledDays = By.xpath("(//div[@class='MuiDialogContent-root css-3fsl0h-MuiDialogContent-root'])/div[1]/div/label/span[1]");
	By EventSelector = By.xpath("(//div[@class='MuiBox-root css-1qm1lh'])/div/div[1]/div/div/div");
	By EventStartTime = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 css-1osj8n2-MuiGrid-root'])[2]/input");
	By EventStartPreWarningTime = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-adornedEnd css-168lbrh-MuiInputBase-root-MuiOutlinedInput-root'])[1]/input");
	By EventStartDelayTime = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 css-1osj8n2-MuiGrid-root'])[4]/div/div/input");
	By EventStartSaveButton = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root'])[2]/button[2]");
	By EventStartMessege = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1lf2b4f-MuiInputBase-root-MuiOutlinedInput-root'])[3]/input");
	By ScheduledEventNameTextVerify = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])[2]//tbody/tr/td[1]");
	By ScheduledEventdaysTextVerify = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])[2]//tbody/tr/td[2]");
	By ScheduledEventStartTextVerify = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])[2]//tbody/tr/td[3]");
	By ScheduledEventCancelButton = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root'])[2]/button[1]");
	By DefaultPolicyDeleteButton = By.xpath("(//table[@class='MuiTable-root css-1upwpwx-MuiTable-root'])//tbody/tr[1]/td[5]/div/button[2]");
	By WarningMessegePopupOnDeleteDefaultScheme = By.xpath("(//div[@class='Toastify__toast-container Toastify__toast-container--top-right'])/div/div/div[2]");
	By AddNewPolicySubmitButton = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root'])/button[2]");
	By PolicyNameVerify = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-12 css-1idn90j-MuiGrid-root'])/table/tbody/tr/td[1]");
	By PolicyDescriptionVerify = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-12 css-1idn90j-MuiGrid-root'])/table/tbody/tr/td[2]");
	
	
	public List<WebElement> getPolicyDescriptionVerify() {
		return driver.findElements(PolicyDescriptionVerify);
	}
	public List<WebElement> getPolicyNameVerify() {
		return driver.findElements(PolicyNameVerify);
	}
	
	public WebElement getAddNewPolicySubmitButton() {
		return driver.findElement(AddNewPolicySubmitButton);
	}
	
	public WebElement getWarningMessegePopupOnDeleteDefaultScheme() {
		return driver.findElement(WarningMessegePopupOnDeleteDefaultScheme);
	}
	
	public WebElement getDefaultPolicyDeleteButton() {
		return driver.findElement(DefaultPolicyDeleteButton);
	}
	
	
	public WebElement getDefaultSchemeEndTimeVerifyText() {
		return driver.findElement(DefaultSchemeEndTimeVerifyText);
	}
	public WebElement getDefaultSchemeStartTimeVerifyText() {
		return driver.findElement(DefaultSchemeStartTimeVerifyText);
	}
	
	public WebElement getDefaultSchemeDaysVerifyText() {
		return driver.findElement(DefaultSchemeDaysVerifyText);
	}
	
	public WebElement getNewDefaultSchemeNameVerifyText() {
		return driver.findElement(NewDefaultSchemeNameVerifyText);
	}
	
	public WebElement getScheduledEventCancelButton() {
		return driver.findElement(ScheduledEventCancelButton);
	}
	
	public String getScheduledEventStartTextVerify() {
		return driver.findElement(ScheduledEventStartTextVerify).getText();
	}
	
	
	public String getScheduledEventdaysTextVerify() {
		return driver.findElement(ScheduledEventdaysTextVerify).getText();
	}

	public String getScheduledEventNameTextVerify() {
		return driver.findElement(ScheduledEventNameTextVerify).getText();
	}
	
	
	
	public List<WebElement> getEventSelectorDropDownList() {
		return driver.findElements(EventSelectorDropDownList);
	}
	
	public WebElement getScduledEventAddButton() {
		return driver.findElement(ScduledEventAddButton);
	}

	public void getScheduledDays() {
		for (WebElement element : driver.findElements(ScheduledDays)) {
			element.click();
		}
	}

	public void getEventSelector() {
		 driver.findElement(EventSelector).click();
	}

	public WebElement getEventStartTime() {
		return driver.findElement(EventStartTime);
	}

	public WebElement getEventStartPreWarningTime() {
		return driver.findElement(EventStartPreWarningTime);
	}

	public WebElement getEventStartDelayTime() {
		return driver.findElement(EventStartDelayTime);
	}

	public WebElement getEventStartMessege() {
		return driver.findElement(EventStartMessege);
	}

	public WebElement getEventStartSaveButton() {
		return driver.findElement(EventStartSaveButton);
	}
	

	public String getNewSchemeNameVerifyText() {
		return driver.findElement(NewSchemeNameVerifyText).getText();
	}

	public String getNewSchemeDaysVerifyText() {
		return driver.findElement(NewSchemeDaysVerifyText).getText();
	}

	public String getNewSchemeStartTimeVerifyText() {
		return driver.findElement(NewSchemeStartTimeVerifyText).getText();
	}

	public String getNewSchemeEndTimeVerifyText() {
		return driver.findElement(NewSchemeEndTimeVerifyText).getText();
	}
	public WebElement getAddNewSchemeSaveButton() {
		return driver.findElement(AddNewSchemeSaveButton);
	}
	
	public WebElement getDiskMax() {
		return driver.findElement(DiskMax);
	}
	
	public WebElement getNetworkMax() {
		return driver.findElement(NetworkMax);
	}
	
	public WebElement getScreenDim() {
		return driver.findElement(ScreenDim);
	}
	
	public WebElement getBrightness() {
		return driver.findElement(Brightness);
	}
	
	
	
	
	
	
	public List<WebElement> getUSBSleepONAC() {
		return driver.findElements(USBSleepONAC);
	}
	
	public WebElement getCPUMax() {
		return driver.findElement(CPUMax);
	}
	
	
	public List<WebElement> getDisplayInactivityDropdown() {
		return driver.findElements(DisplayInactivityDropdown);
	}
	
	
	public List<String> getVerifyTimeIntervalDropdownContent() {
		
		List<String> dropDonContent =  new ArrayList<String>(15);
		for(WebElement ele : getDisplayInactivityDropdown()) {
			dropDonContent.add(ele.getText());
		}
		return dropDonContent;
	}
	
	public List<String> getVerifyTimeIntervalDropdownContentList(Properties prop) {

		List<String> dropDonContentList = new ArrayList<String>(15);
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameOneMin"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameFiveMin"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameTenMin"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameFifMin"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameTweMin"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameThityMin"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameFourtyFiveMin"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameSixtyMin"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameTwoHours"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameThreeHours"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameFourHours"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameFiveHours"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameSixHours"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameSevenHours"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameEightHours"));
		dropDonContentList.add(prop.getProperty("PoliciesManagementDropdownTimeFrameNever"));

		return dropDonContentList;
	}
	
	public WebElement getNewSchemeName() {
		return driver.findElement(NewSchemeName);
	}
	
	public WebElement getNewSchemeDescription() {
		return driver.findElement(NewSchemeDescription);
	}
	
	public WebElement getNewSchemeStartTime() {
		return driver.findElement(NewSchemeStartTime);
	}
	
	public void time() {
		driver.findElement(NewSchemeStartTime).sendKeys("1045");
	}
	
	
	public void getSelectDaysCheckbox() {
		for (WebElement ele : driver.findElements(WeekDaysCheckBox)) {
			ele.click();
		}
	}
	
	public WebElement getNewSchemeEndTime() {
		return driver.findElement(NewSchemeEndTime);
	}
	
	public WebElement getdisplayInactivityTimeout() {
		return driver.findElement(displayInactivityTimeout);
	}
	
	
	public void KeyBoardAction(int Count) {
		int count =1;
		Actions act = new Actions(driver);
		
		while(count<=Count) {
			act.sendKeys(Keys.TAB).build().perform();
			count++;
		}
		act.sendKeys(Keys.ENTER).build().perform();;
	}
	
	
	
	public WebElement getPolicyName() {
		return driver.findElement(PolicyName);
	}
	public WebElement getPolicyDescription() {
		return driver.findElement(PolicyDescription);
	}
	public WebElement getAddSchemeButton() {
		return driver.findElement(AddSchemeButton);
	}
	
	public WebElement getAddPolicyBtn() {
		return driver.findElement(AddPolicyBtn);
	}
	
	public List<String> getPoliciesTableHeaderDataToVerify(Properties prop) {
		List<String> textVerify = new ArrayList<>();
		
		textVerify.add(prop.getProperty("PoliciesManagementPolicyNameTableHeaderText"));
		textVerify.add(prop.getProperty("PoliciesManagementDescriptionTableHeaderText"));
		textVerify.add(prop.getProperty("PoliciesManagementLockedTableHeaderText"));
		textVerify.add(prop.getProperty("PoliciesManagementOptionsTableHeaderText"));

	return textVerify;
	}

	public List<WebElement> PoliciesInnerTableHeaderText() {
		return driver.findElements(PoliciesInnerTableHeaderText);
	}
	
	public String getPolicyManagementTableHeaderText() {
		return driver.findElement(PolicyManagementTableHeaderText).getText();
	}
	
	public String getPolicyManagement() {
		return driver.findElement(PolicyManagement).getText();
	}
	
	public WebElement getPolicies() {
		return driver.findElement(Policies);
	}
	
	public WebElement getManagementTab() {
		return driver.findElement(ManagementTab);
	}

	
	
	//Groups
	
	By Groups = By.xpath("//div[@class='MuiList-root css-uppwh0-MuiList-root']//a[2]");
	By AddGroupButton = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-sm-3 MuiGrid-grid-md-3 css-auylq4-MuiGrid-root'])//button");
	By IsParentCheckBox = By.xpath("(//div[@class='MuiBox-root css-0'])/label/span[1]");
	By GroupCreatedNameVerify = By.xpath("//li[@role='listitem']/ul/li/div/div[2]/p");
	By GroupEditButton = By.xpath("(//div[@class='MuiBox-root css-19hvn7'])/button[2]");
	By ParentGroupDropDown = By.xpath("(//div[@class='MuiFormControl-root css-1cr99xm-MuiFormControl-root'])/div/div");
	By ParentGroupDropDownList = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-6hp17o-MuiList-root-MuiMenu-list'])/li");
	By ArrowDownInTable= By.xpath("(//div[@class='tree-node CustomNode_root__6RKGp'])[1]/div[1]/span");
	By SubGroupNameVerify = By.xpath("(//div[@class='MuiBox-root css-1yuhvjn'])//ul/li/div/div[2]/p");
	
	public List<WebElement> getSubGroupNameVerify() {
		return driver.findElements(SubGroupNameVerify);
	}
	
	public WebElement getArrowDownInTable() {
		return driver.findElement(ArrowDownInTable);
	}

	public List<WebElement> getParentGroupDropDownList() {
		return driver.findElements(ParentGroupDropDownList);
	}
	
	public WebElement getParentGroupDropDown() {
		return driver.findElement(ParentGroupDropDown);
	}
	
	public WebElement getGroupEditButton() {
		return driver.findElement(GroupEditButton);
	}
	
	public List<WebElement> getGroupCreatedNameVerify() {
		return driver.findElements(GroupCreatedNameVerify);
	}
	
	
	public WebElement getIsParentCheckBox() {
		return driver.findElement(IsParentCheckBox);
	}
	
	public WebElement getAddGroupButton() {
		return driver.findElement(AddGroupButton);
	}
	
	public WebElement getGroups() {
		return driver.findElement(Groups);
	}
	
//	public boolean nameVerifyFromTableAndMouseHover(WebDriver driver, List<WebElement> ele, WebElement element, String str) {
//
//		Actions act = new Actions(driver);
//		String tablename = "";
//		boolean result = false;
//		
//		for (WebElement option : ele) {
//
//			if (option.getText().equalsIgnoreCase(str)) {
//				tablename = option.getText();
//				act.moveToElement(option).build().perform();
//				if(getGroupEditButton().isDisplayed()) {
//					getGroupEditButton().click();
//					result = true;
//				}
//				break;
//			}
//		}
//		return result;
//	}
	
	public void moveEle(WebDriver driver , WebElement elem) {

		// Use the JavascriptExecutor to trigger the onmouseover event
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "var mouseEvent = document.createEvent('MouseEvents');" +
		                "mouseEvent.initEvent('mouseover', true, true);" +
		                "arguments[0].dispatchEvent(mouseEvent);";
		js.executeScript(script, elem);

	}
	
	
	public boolean nameVerifyFromTableAndMouseHover(WebDriver driver, String str) {
		boolean result = false;
		try {
			WebElement option = getGroupCreatedNameVerify().stream().filter(e -> e.getText().equalsIgnoreCase(str)).findFirst().orElse(null);
			if (option != null) {
				//act.moveToElement(option).perform();
				moveEle(driver,option);
				if (getGroupEditButton().isDisplayed()) {
					getGroupEditButton().click();
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	public boolean nameVerifyFromTableAndMouseHoverAfterRename(WebDriver driver, 
			String str) {
		Actions act = new Actions(driver);
		boolean result = false;
		try {
			
			for (WebElement option : getSubGroupNameVerify()) {
				//
							if (option.getText().equalsIgnoreCase(str)) {
								act.moveToElement(option).build().perform();
								if(getGroupEditButton().isDisplayed()) {
								getGroupEditButton().click();
									result = true;
								}
								break;
							}
						}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
			
			/*
			
			WebElement option = getSubGroupNameVerify().stream().filter(e -> e.getText().equalsIgnoreCase(str)).findFirst().orElse(null);
			if (option != null) {
				//act.moveToElement(option).perform();
				moveEle(driver,option);
				if (getGroupEditButton().isDisplayed()) {
					getGroupEditButton().click();
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
