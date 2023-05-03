package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
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
	
	
	
	By ManagementTab = By.xpath("(//div[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters css-m92ebk'])[1]");
	
	//Policies
	By Policies = By.xpath("(//div[@class='MuiList-root css-1xidfkz'])/a[3]/div[2]");
	By PolicyManagement = By.xpath("(//div[@class='MuiCardHeader-root css-fw4u9m'])//div/span");
	By PolicyManagementTableHeaderText = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-item css-g8a0ev'])//div/p");
	By PoliciesInnerTableHeaderText = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-12 css-15j76c0'])//table/thead/tr/th");
	By AddPolicyBtn = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8'])//button");
	By PolicyName = By.xpath("(//div[@class='MuiFormControl-root MuiTextField-root css-feqhe6'])[1]/div/input");
	By PolicyDescription = By.xpath("(//div[@class='MuiFormControl-root MuiTextField-root css-feqhe6'])[2]/div/input");
	By AddSchemeButton = By.xpath("(//div[@class='MuiBox-root css-blgins'])/div/div[2]/button");
	
	By AddNewSchemeHeaderText = By.xpath("(//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm css-1pwda69'])[2]/h2");
	By PoliciesSchemeName = By.xpath("(//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm css-1pwda69'])[2]/h2");
	By SchemeName = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 css-1s50f5r'])[1]/div/div/input");
	
	By NewSchemeName = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1nj3ori'])[3]/input");
	By NewSchemeDescription = By.xpath("(//div[@class='MuiDialogContent-root css-1ws0q2s'])/div[1]/div/div[2]/div/div/input");
	By WeekDaysCheckBox = By.xpath("(//div[@class='MuiBox-root css-1yuhvjn'])/div/label/span[1]");
	By NewSchemeStartTime = By.xpath("(//div[@class='MuiBox-root css-1qm1lh'])/div/div[1]/input");
	By NewSchemeEndTime = By.xpath("(//div[@class='MuiBox-root css-1qm1lh'])/div/div[2]/input");
	By displayInactivityTimeout = By.xpath("//input[@name='displayInactivityTimeoutAC']");
	By DisplayInactivityDropdown = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li");
	By USBSleepONAC = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9'])//li");
	By CPUMax = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-tuxzvu'])[4]/div[6]/div/div/input");
	By DiskMax = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-tuxzvu'])[4]/div[7]/div/div/input");
	By NetworkMax =By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-tuxzvu'])[4]/div[8]/div/div/input");
	By ScreenDim = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-tuxzvu'])[4]/div[9]/div/div/input");
	By Brightness = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-tuxzvu'])[4]/div[10]/div/div/input");
	By AddNewSchemeSaveButton = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc'])[2]/button[2]");
	By NewSchemeEndTimeVerifyText = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[2]/td[4]");
	By DefaultSchemeEndTimeVerifyText = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[1]/td[4]");
	By NewSchemeStartTimeVerifyText = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[2]/td[3]");
	By DefaultSchemeStartTimeVerifyText = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[1]/td[3]");
	By NewSchemeDaysVerifyText = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[2]/td[2]");
	By DefaultSchemeDaysVerifyText = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[1]/td[2]");
	By NewSchemeNameVerifyText = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[2]/td[1]");
	By NewDefaultSchemeNameVerifyText = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[1]/td[1]");
	By EventSelectorDropDownList = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9'])//li");
	By ScduledEventAddButton = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8'])[3]/button");
	By ScheduledDays = By.xpath("(//div[@class='MuiDialogContent-root css-1ws0q2s'])/div[1]/div/label/span[1]");
	By EventSelector = By.xpath("(//div[@class='MuiBox-root css-1qm1lh'])/div/div[1]/div/div/div");
	By EventStartTime = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 css-1s50f5r'])[2]/input");
	By EventStartPreWarningTime = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-adornedEnd css-ggczlc'])[1]/input");
	By EventStartDelayTime = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 css-1s50f5r'])[4]/div/div/input");
	By EventStartSaveButton = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc'])[2]/button[2]");
	By EventStartMessege = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1nj3ori'])[3]/input");
	By ScheduledEventNameTextVerify = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])[2]//tbody/tr/td[1]");
	By ScheduledEventdaysTextVerify = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])[2]//tbody/tr/td[2]");
	By ScheduledEventStartTextVerify = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])[2]//tbody/tr/td[3]");
	By ScheduledEventCancelButton = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc'])[2]/button[1]");
	By DefaultPolicyDeleteButton = By.xpath("(//table[@class='MuiTable-root css-h2vfmc'])//tbody/tr[1]/td[5]/div/button[2]");
	By WarningMessegePopupOnDeleteDefaultScheme = By.xpath("(//div[@class='Toastify__toast-container Toastify__toast-container--top-right'])/div/div/div[2]");
	By AddNewPolicySubmitButton = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc'])/button[2]");
	By PolicyNameVerify = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-12 css-15j76c0'])/table/tbody/tr/td[1]");
	By PolicyDescriptionVerify = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-lg-12 css-15j76c0'])/table/tbody/tr/td[2]");
	
	
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
		List<String> textVerify = new ArrayList<>(3);
		
		textVerify.add(prop.getProperty("PoliciesManagementPolicyNameTableHeaderText"));
		textVerify.add(prop.getProperty("PoliciesManagementDescriptionTableHeaderText"));
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

	
}
