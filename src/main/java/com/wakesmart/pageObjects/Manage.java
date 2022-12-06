package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class Manage extends BaseClass {

	public Manage(WebDriver driver) {
		this.driver = driver;
	}

	By ManageIcon = By.xpath("//input[@id='manage']");

	public WebElement getManageIcon() {
		return driver.findElement(ManageIcon);
	}

	// groups

	By Groups = By.xpath("//input[@name='Groups']");

	public WebElement getGroups() {
		return driver.findElement(Groups);
	}

	By GroupManagementHeader = By.xpath("//div[@class='screentitle']");

	public String getGroupManagementHeaderText() {
		return driver.findElement(GroupManagementHeader).getText();
	}

	By OptionsDropDown = By.xpath("//select[@id='optionSelector']");

	public WebElement getOptionsDropDown() {
		return driver.findElement(OptionsDropDown);
	}

	By CreateGroupPopupHeaderText = By.xpath("//label[@id='groupDialoglabel']");

	public WebElement getCreateGroupPopupHeaderText() {
		return driver.findElement(CreateGroupPopupHeaderText);
	}

	By NewGroupName = By.xpath("//input[@id='groupNameInput']");

	public WebElement getNewGroupName() {
		return driver.findElement(NewGroupName);
	}

	By NewGroupDescription = By.xpath("//input[@id='groupDesc']");

	public WebElement getNewGroupDescription() {
		return driver.findElement(NewGroupDescription);
	}

	By NewGroupParent = By.xpath("//select[@id='parentSelector']");

	public WebElement getNewGroupParent() {
		return driver.findElement(NewGroupParent);
	}

	By NewGroupSubmitButton = By.xpath("//input[@id='Savebtn']");

	public WebElement getNewGroupSubmitButton() {
		return driver.findElement(NewGroupSubmitButton);
	}

	By TableHeaderGroupNameText = By.xpath("//th[normalize-space()='GROUP NAME']");

	public WebElement getTableHeaderGroupName() {
		return driver.findElement(TableHeaderGroupNameText);
	}

	By TableDescriptionHeaderText = By.xpath("//th[normalize-space()='DESCRIPTION']");

	public WebElement getTableDescriptionHeaderText() {
		return driver.findElement(TableDescriptionHeaderText);
	}

	By TableAutomationHeaderText = By.xpath("//th[normalize-space()='AUTOMATED']");

	public WebElement getTableAutomationHeaderText() {
		return driver.findElement(TableAutomationHeaderText);
	}

	By GroupNameVeriyText = By.xpath("//tbody/tr/td[1]");

	public List<WebElement> getGroupNameVeriyText() {
		return driver.findElements(GroupNameVeriyText);
	}
	
	
	public void getVerifyTextClickOnElement(String str) {
		driver.findElement(By.xpath("(//*[contains(text(),'"+str+"')])[1]")).click();	
	}
	

	By GroupNameDescriptionVeriftText = By.xpath("//tbody/tr/td[2]");

	public List<WebElement> getGroupNameDescriptionVeriftText() {
		return driver.findElements(GroupNameDescriptionVeriftText);
	}

	// Devices
	
	
	By NoCompuersReportingText = By.xpath("//span[normalize-space()='No computers reporting']");
	
	public WebElement getNoCompuersReportingText() {
		return driver.findElement(NoCompuersReportingText);
	}
	

	By DevicesList = By.xpath("//input[@name='Devices']");

	public WebElement getDevicesList() {
		return driver.findElement(DevicesList);
	}

	By DevicePageHeaderText = By.xpath("//div[@class='screentitle']");

	public WebElement getDevicePageHeaderText() {
		return driver.findElement(DevicePageHeaderText);
	}

	By PanelHeaderText = By.xpath("//div[@class='right-panel-header']");

	public WebElement getDevicePanelHeaderText() {
		return driver.findElement(PanelHeaderText);
	}

	By GroupsList = By.xpath("//body/div[2]/div/div[4]/div");

	public List<WebElement> getGroupsList() {
		return driver.findElements(GroupsList);
	}

	By OrderColumns = By.xpath("//button[@id='columns']");

	public WebElement getOrderColumns() {
		return driver.findElement(OrderColumns);
	}

	By OrderColumnsDropDown = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[3]/form[2]/div[1]/div[1]/div/input");

	public List<WebElement> getOrderColumnsDropDown() {
		return driver.findElements(OrderColumnsDropDown);
	}

	// unclick check box
	public void unClickOnCheckBox() {

		List<WebElement> str = getOrderColumnsDropDown();

		for (WebElement ele : str) {

			if (ele.isSelected()) {
				ele.click();
			}
		}
	}

	// click check box
	public void clickOnCheckBox() {

		List<WebElement> str = getOrderColumnsDropDown();

		for (WebElement ele : str) {
			ele.click();
		}
	}

	By OrderColumnsSaveButton = By.xpath("//button[@id='colSelect_btn']");

	public WebElement getOrderColumnsSaveButton() {
		return driver.findElement(OrderColumnsSaveButton);
	}

	By DevicesTableHeaderText = By.xpath("//body/div/div/div[5]/div/table/thead/tr/th");

	public List<WebElement> getDevicesTableHeaderText() {
		return driver.findElements(DevicesTableHeaderText);
	}

	List<String> list = new ArrayList<>();

	public int countTable = 0;

	public int tableHeaderText() {
		List<WebElement> webelementlist = getDevicesTableHeaderText();

		for (WebElement ele : webelementlist) {
			list.add(ele.getText());
			countTable++;
		}
		return countTable;
	}

	By TableHeaderText = By.xpath("//th[@class='deviceheader']");

	public WebElement getTableHeaderText() {
		return driver.findElement(TableHeaderText);
	}
	
	
	//policies
	
	By PoliciesIcon = By.xpath("//input[@name='Policies']");
	
	public WebElement getPoliciesIcon() {
		return driver.findElement(PoliciesIcon);
	}
	
	
	By PoliciesHeaderTitle = By.xpath("//div[@class='screentitle']");
	
	public WebElement getPoliciesHeaderTitle() {
		return driver.findElement(PoliciesHeaderTitle);
	}
	
	
	By SelectAPolicyToEditHeaderText = By.xpath("//h4[@id='EncourageSelect']");
	
	public WebElement getSelectAPolicyToEditHeaderText() {
		return driver.findElement(SelectAPolicyToEditHeaderText);
	}
	
	By NewPolicyButtonClick = By.xpath("//button[@id='newPolicyBtn']");
	
	public WebElement getNewPolicyButtonClick() {
		return driver.findElement(NewPolicyButtonClick);
	}
	
	
	By NewpolicyName = By.xpath("//input[@id='policyname']");
	
	public WebElement getNewpolicyName() {
		return driver.findElement(NewpolicyName);
	}
	
	By NewPolicyDescription = By.xpath("//input[@id='policydescription']");
	
	public WebElement getNewPolicyDescription() {
		return driver.findElement(NewPolicyDescription);
	}
	
	By SchemesVerifyText = By.xpath("//td[@id='schemeTD']");
	
	public WebElement getSchemesVerifyText() {
		return driver.findElement(SchemesVerifyText);
	}
	
	By SchemesEditButton = By.xpath("//button[@id='editScheme0']");
	
	public WebElement getSchemesEditButton() {
		return driver.findElement(SchemesEditButton);
	}
	
	By SchemeNameText = By.xpath("//span[@id='schemename0']");
	
	public String getSchemeNameText() {
		return driver.findElement(SchemeNameText).getText();
	}
	
	By SchemeDaysText = By.xpath("//span[@id='days0']");
	
	public String getSchemeDaysText() {
		return driver.findElement(SchemeDaysText).getText();
	}
	
	By SchemeStartText = By.xpath("//span[@id='start0']");
	
	public String getSchemeStartText() {
		return driver.findElement(SchemeStartText).getText();
	}
	
	By SchemeEndText = By.xpath("//span[@id='end0']");
	
	public String getSchemeEndText() {
		return driver.findElement(SchemeEndText).getText();
	}
	
	
	
	
	By displayInactivityTimeout = By.xpath("//td[normalize-space()='Display inactivity timeout']");
	
	By ONACdisplayInActivityTimeOut = By.xpath("//select[@id='dispacSelect']");
	
	By ONACpuInActivityTimeOut =  By.xpath("//select[@id='cpuacSelect']");
	

	By ONDCdisplayInActivityTimeOut = By.xpath("//select[@id='dispdcSelect']");
	
	By ONDCpuInActivityTimeOut =  By.xpath("//select[@id='cpudcSelect']");
	
	
	
	


	

}
