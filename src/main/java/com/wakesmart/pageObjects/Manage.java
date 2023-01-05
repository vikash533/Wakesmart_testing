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
		driver.findElement(By.xpath("(//*[contains(text(),'" + str + "')])[1]")).click();
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

	// policies

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

	By DescriptionEdit = By.xpath("//input[@id='schemeEditordesc']");

	public WebElement getDescriptionEdit() {
		return driver.findElement(DescriptionEdit);
	}

	By displayInactivityTimeout = By.xpath("(//table/tbody/tr[7]/td[2])//select[@id='dispacSelect']");

	By ONACdisplayInActivityTimeOut = By.xpath("//select[@id='dispacSelect']");

	By ONACpuInActivityTimeOut = By.xpath("//select[@id='cpuacSelect']");

	By ONDCdisplayInActivityTimeOut = By.xpath("//select[@id='dispdcSelect']");

	By ONDCpuInActivityTimeOut = By.xpath("//select[@id='cpudcSelect']");

	public WebElement getdisplayInactivityTimeout() {
		return driver.findElement(displayInactivityTimeout);
	}

	public WebElement getONACdisplayInActivityTimeOut() {
		return driver.findElement(ONACdisplayInActivityTimeOut);
	}

	public WebElement getONACpuInActivityTimeOut() {
		return driver.findElement(ONACpuInActivityTimeOut);
	}

	public WebElement getONDCdisplayInActivityTimeOut() {
		return driver.findElement(ONDCdisplayInActivityTimeOut);
	}

	public WebElement getONDCpuInActivityTimeOut() {
		return driver.findElement(ONDCpuInActivityTimeOut);
	}

	By USBSleepONAC = By.xpath("//select[@id='usbacEnabler']");

	By USBSleepONDC = By.xpath("//select[@id='usbdcEnabler']");

	By WakeTimersONAC = By.xpath("//select[@id='waketmacEnabler']");

	By WakeTimersONDC = By.xpath("//select[@id='waketmdcEnabler']");

	By HIDWake = By.xpath("//select[@id='hidwakeEnabler']");

	By CPUMAx = By.xpath("//input[@id='cpumaxEnabler']");

	By ScreenDim = By.xpath("//input[@id='screendimEnabler']");

	By DiskMax = By.xpath("//input[@id='diskmaxEnabler']");

	By Brightness = By.xpath("//input[@id='brightEnabler']");

	By NetworkMax = By.xpath("//input[@id='netmaxEnabler']");

	By SaveButton = By.xpath("//button[@id='schemeEditSaveBtn']");

	By CancelButton = By.xpath("//button[@id='schemeEditCancelBtn']");

	By DeleteButton = By.xpath("//button[@id='schemeEditDelBtn']");

	public WebElement getUSBSleepONAC() {
		return driver.findElement(USBSleepONAC);
	}

	public WebElement getUSBSleepONDC() {
		return driver.findElement(USBSleepONDC);
	}

	public WebElement getWakeTimersONAC() {
		return driver.findElement(WakeTimersONAC);
	}

	public WebElement getWakeTimersONDC() {
		return driver.findElement(WakeTimersONDC);
	}

	public WebElement getHIDWake() {
		return driver.findElement(HIDWake);
	}

	public WebElement getCPUMAx() {
		return driver.findElement(CPUMAx);
	}

	public WebElement getScreenDim() {
		return driver.findElement(ScreenDim);
	}

	public WebElement getDiskMax() {
		return driver.findElement(DiskMax);
	}

	public WebElement getBrightness() {
		return driver.findElement(Brightness);
	}

	public WebElement getNetworkMax() {
		return driver.findElement(NetworkMax);
	}

	public WebElement getSaveButton() {
		return driver.findElement(SaveButton);
	}

	public WebElement getCancelButton() {
		return driver.findElement(CancelButton);
	}

	public WebElement getDeleteButton() {
		return driver.findElement(DeleteButton);
	}

	By ADDSchemeButton = By.xpath("//button[@id='addScheme']");

	public WebElement getADDSchemeButton() {
		return driver.findElement(ADDSchemeButton);
	}

	By SelectDaysCheckbox = By.xpath("(//div[@id='schemeEditor'])//table/tbody/tr[2]/td/input");

	public void getSelectDaysCheckbox() {
		for (WebElement ele : driver.findElements(SelectDaysCheckbox)) {
			ele.click();
		}
	}

	By NewSchemeName = By.xpath("//input[@id='schemeEditorname']");

	public WebElement getNewSchemeName() {
		return driver.findElement(ADDSchemeButton);
	}

	By NewSchemeDescription = By.xpath("(//input[@id='schemeEditordesc'])[1]");

	public WebElement getNewSchemeDescription() {
		return driver.findElement(NewSchemeDescription);
	}

	By NewSchemeStartTime = By.xpath("//input[@id='startSelect']");

	public WebElement getNewSchemeStartTime() {
		return driver.findElement(NewSchemeStartTime);
	}

	By NewSchemeEndTime = By.xpath("//input[@id='endSelect']");

	public WebElement getNewSchemeEndTime() {
		return driver.findElement(NewSchemeEndTime);
	}

	// scheme name verify

	By NewSchemeNameVerifyText = By.xpath("(//span[@id='schemename1'])[1]");

	public WebElement getNewSchemeNameVerifyText() {
		return driver.findElement(NewSchemeNameVerifyText);
	}

	By NewSchemeDaysVerifyText = By.xpath("(//span[@id='days1'])[1]");

	public String getNewSchemeDaysVerifyText() {
		return driver.findElement(NewSchemeDaysVerifyText).getText();
	}

	By NewSchemeStartTimeVerifyText = By.xpath("(//span[@id='start1'])[1]");

	public String getNewSchemeStartTimeVerifyText() {
		return driver.findElement(NewSchemeStartTimeVerifyText).getText();
	}

	By NewSchemeEndTimeVerifyText = By.xpath("(//span[@id='end1'])[1]");

	public String getNewSchemeEndTimeVerifyText() {
		return driver.findElement(NewSchemeEndTimeVerifyText).getText();
	}

	// Scheduled Event

	By ScduledEventAddButton = By.xpath("//button[@id='addEvent']");

	public WebElement getScduledEventAddButton() {
		return driver.findElement(ScduledEventAddButton);
	}

	By ScheduledDays = By.xpath("(//div[@class='eventEditor'])//table/tbody/tr[2]/td/input");

	public void getScheduledDays() {
		for (WebElement element : driver.findElements(ScheduledDays)) {
			element.click();
		}
	}

	By EventSelector = By.xpath("//select[@id='eventSelector']");

	public WebElement getEventSelector() {
		return driver.findElement(EventSelector);
	}

	By EventStartTime = By.xpath("//input[@id='eventstart']");

	public WebElement getEventStartTime() {
		return driver.findElement(EventStartTime);
	}

	By EventStartPreWarningTime = By.xpath("//input[@id='warningtime']");

	public WebElement getEventStartPreWarningTime() {
		return driver.findElement(EventStartPreWarningTime);
	}

	By EventStartDelayTime = By.xpath("//input[@id='delaytime']");

	public WebElement getEventStartDelayTime() {
		return driver.findElement(EventStartDelayTime);
	}

	By EventStartMessege = By.xpath("//input[@id='msg']");

	public WebElement getEventStartMessege() {
		return driver.findElement(EventStartMessege);
	}

	By EventStartSaveButton = By.xpath("//button[@id='eventEditSaveBtn']");

	public WebElement getEventStartSaveButton() {
		return driver.findElement(EventStartSaveButton);
	}

	By ScheduledEventNameTextVerify = By.xpath("(//span[@id='eventname1'])[1]");

	public String getScheduledEventNameTextVerify() {
		return driver.findElement(ScheduledEventNameTextVerify).getText();
	}

	By ScheduledEventdaysTextVerify = By.xpath("(//span[@id='eventdays1'])[1]");

	public String getScheduledEventdaysTextVerify() {
		return driver.findElement(ScheduledEventdaysTextVerify).getText();
	}

	By ScheduledEventStartTextVerify = By.xpath("(//span[@id='eventstart1'])[1]");

	public String getScheduledEventStartTextVerify() {
		return driver.findElement(ScheduledEventStartTextVerify).getText();
	}

	By WakeTimerONACVerifyText = By.xpath("//span[@id='waketmac']");
	By UsbSleepONACVerifyText = By.xpath("//span[@id='usbac']");
	By HidWakeONACVerifyText = By.xpath("//span[@id='hidwake']");
	By CPUMaxONACVerifyText = By.xpath("//span[@id='cpumax']");
	By DiskMaxONACVerifyText = By.xpath("//span[@id='diskmax']");
	By NetworkMaxONACVerifyText = By.xpath("//span[@id='netmax']");
	By WakeTimerONDCVerifyText = By.xpath("//span[@id='waketmdc']");
	By USBSleepONDCV = By.xpath("//span[@id='usbdc']");

	public String getWakeTimerONACVerifyText() {
		return driver.findElement(WakeTimerONACVerifyText).getText();
	}

	public String getUsbSleepONACVerifyText() {
		return driver.findElement(UsbSleepONACVerifyText).getText();
	}

	public String getHidWakeONACVerifyText() {
		return driver.findElement(HidWakeONACVerifyText).getText();
	}

	public String getCPUMaxONACVerifyText() {
		return driver.findElement(CPUMaxONACVerifyText).getText();
	}

	public String getDiskMaxONACVerifyText() {
		return driver.findElement(DiskMaxONACVerifyText).getText();
	}

	public String getNetworkMaxONACVerifyText() {
		return driver.findElement(NetworkMaxONACVerifyText).getText();
	}

	public String getWakeTimerONDCVerifyText() {
		return driver.findElement(WakeTimerONDCVerifyText).getText();
	}

	public String getUSBSleepONDCV() {
		return driver.findElement(USBSleepONDCV).getText();
	}

	By NewPolicySaveButton = By.xpath("//button[@id='saveBtn']");

	public WebElement getNewPolicySaveButton() {
		return driver.findElement(NewPolicySaveButton);
	}

	By PolicyNameVerify = By.xpath("//div[@class='policyListGroup']//table/tbody/tr/td[1]");

	public String getPolicyNameVerify(String NewPolicyName) {

		String name = "";

		for (WebElement ele : driver.findElements(PolicyNameVerify)) {
			System.out.println(ele.getText());
			if (ele.getText().equalsIgnoreCase(NewPolicyName)) {
				name = ele.getText();
			}
		}
		return name;
	}

	public void getPolicyNameVerifyAndClick(String NewPolicyName) {

		for (WebElement ele : driver.findElements(PolicyNameVerify)) {
			if (ele.getText().equalsIgnoreCase(NewPolicyName)) {
				ele.click();
			}
		}
	}

	By PolicyDescriptionVerify = By.xpath("//div[@class='policyListGroup']//table/tbody/tr/td[2]");

	public String getPolicyDescriptionVerify(String NewPolicyDescription) {

		String name = "";

		for (WebElement ele : driver.findElements(PolicyDescriptionVerify)) {
			System.out.println(ele.getText());
			if (ele.getText().equalsIgnoreCase(NewPolicyDescription)) {
				name = ele.getText();
			}
		}
		return name;
	}

	By DefaultGroupName = By.xpath("//span[normalize-space()='Test']");

	public WebElement getDefaultGroupName() {
		return driver.findElement(DefaultGroupName);
	}

	By DeviceNameInGroupTest = By.xpath("(//div[@class='right-panel'])//div/table/tbody/tr[1]");

	public WebElement getDeviceNameInGroupTest() {
		return driver.findElement(DeviceNameInGroupTest);
	}

	By AssignPolicy = By.xpath("//p[normalize-space()='Assign Policy']");

	public WebElement getAssignPolicy() {
		return driver.findElement(AssignPolicy);
	}

	By PolicySelectorFromDropdown = By.xpath("//select[@id='policySelector']");

	public WebElement getPolicySelectorFromDropdown() {
		return driver.findElement(PolicySelectorFromDropdown);
	}

	By AssignPolicyOKButton = By.xpath("//form[@id='assignPolicy']//input[@id='assignBtn']");

	public WebElement getAssignPolicyOKButton() {
		return driver.findElement(AssignPolicyOKButton);
	}

	// By PolicyAssignVerifyText = By.xpath("//td[normalize-space()='OTS Automation
	// Testing']");

	public String getPolicyAssignVerifyText(String name) {
		return driver.findElement(By.xpath("//td[normalize-space()='" + name + "']")).getText();
	}

	By policyDeleteButton = By.xpath("//button[@id='deleteBtn']");

	public WebElement getpolicyDeleteButton() {
		return driver.findElement(policyDeleteButton);
	}

	By PolicyDeleteAlertMessege = By.xpath("//div[@id='errorDialog']//div[2]");

	public String getPolicyDeleteAlertMessege() {
		return driver.findElement(PolicyDeleteAlertMessege).getText();
	}

	// manage users

	By Users = By.xpath("//input[@name='Users']");

	public WebElement getUsers() {
		return driver.findElement(Users);
	}

	By UsersHeaderText = By.xpath("//div[@class='screentitle']");

	public String getUsersHeaderText() {
		return driver.findElement(UsersHeaderText).getText();
	}

	By NewUserGroup = By.xpath("//button[@id='newUGroup']");

	public WebElement getNewUserGroup() {
		return driver.findElement(NewUserGroup);
	}

	By popUpNewUserGroupText = By.xpath("//label[@id='groupDialogLbl']");

	public String getpopUpNewUserGroupText() {
		return driver.findElement(popUpNewUserGroupText).getText();
	}

	By UsersGroupName = By.xpath("//input[@id='name']");

	public WebElement getUsersGroupName() {
		return driver.findElement(UsersGroupName);
	}

	By UsersGroupDescription = By.xpath("//input[@id='desc']");

	public WebElement getUsersGroupDescription() {
		return driver.findElement(UsersGroupDescription);
	}

	By AddUserButton = By.xpath("//button[@id='adduser']");

	public WebElement getAddUserButton() {
		return driver.findElement(AddUserButton);
	}

	By ChooseUserFromExistingUserListDropDown = By.xpath("//select[@id='userSelector']");

	public WebElement getChooseUserFromExistingUserListDropDown() {
		return driver.findElement(ChooseUserFromExistingUserListDropDown);
	}

	By ExistingUserNameTextVerify = By.xpath("(//table[@class='fixed_header'])//tbody/tr/tr/td");

	public WebElement getExistingUserNameTextVerify() {
		return driver.findElement(ExistingUserNameTextVerify);
	}

	By DeleteUser = By.xpath("//button[@id='deleteDlg']");

	public WebElement getDeleteUser() {
		return driver.findElement(DeleteUser);
	}

	By AddUserDialougeBox = By.xpath("//div[@id='addDialog']");

	public WebElement getAddUserDialougeBox() {
		return driver.findElement(AddUserDialougeBox);
	}

	By UserName = By.xpath("//input[@id='userName']");

	public WebElement getUserName() {
		return driver.findElement(UserName);
	}

	By UserEmailAddress = By.xpath("//input[@id='userEmail']");

	public WebElement getUserEmailAddress() {
		return driver.findElement(UserEmailAddress);
	}

	By UserConfirmEmail = By.xpath("(//input[@id='userEmail2'])[1]");

	public WebElement getUserConfirmEmail() {
		return driver.findElement(UserConfirmEmail);
	}

	By AddUserSaveButton = By.xpath("//button[@id='addNewUserBtn']");

	public WebElement getAddUserSaveButton() {
		return driver.findElement(AddUserSaveButton);
	}

	By GroupCreateSuccessMessege = By.xpath("//label[@id='alertMsg']");

	public String getGroupCreateSuccessMessege() {
		return driver.findElement(GroupCreateSuccessMessege).getText();
	}

	By GroupCreateOkButton = By.xpath("//button[@id='okBtn']");

	public WebElement getGroupCreateOkButton() {
		return driver.findElement(GroupCreateOkButton);
	}

	By UsersGroupPermissions = By.xpath("(//label[normalize-space()='Group Permissions'])[1]");

	public WebElement getUsersGroupPermissions() {
		return driver.findElement(UsersGroupPermissions);
	}

	By UsersGroupSelectDropDown = By.xpath("(//select[@id='ugSelector'])[1]");

	public WebElement getUsersGroupSelectDropDown() {
		return driver.findElement(UsersGroupSelectDropDown);
	}

	By UserGroupsVerifyText = By.xpath("(//form[@id='userPermissionsPage'])//table/tbody/tr/td[1]");

	public List<WebElement> getUserGroupsVerifyText() {
		return driver.findElements(UserGroupsVerifyText);
	}

	// Licences

	By Licences = By.xpath("//input[@name='License']");

	public WebElement getLicences() {
		return driver.findElement(Licences);
	}

	By UpdateLicenceButton = By.xpath("//button[@id='licenseupdate']");

	public WebElement getUpdateLicenceButton() {
		return driver.findElement(UpdateLicenceButton);
	}

	By LicenceUpdatedMessge = By.xpath("//label[@id='errorLabel']");

	public String getLicenceUpdatedMessge() {
		return driver.findElement(LicenceUpdatedMessge).getText();
	}

	By LicenceMessegePopUpOKButton = By.xpath("//button[@onclick='HideErrorDialog()']");

	public WebElement getLicenceMessegePopUpOKButton() {
		return driver.findElement(LicenceMessegePopUpOKButton);
	}

	By LicenceTabletextVerify = By.xpath("(//table[@class='orgProperties'])//thead/tr/th");

	public ArrayList<String> getLicenceTabletextVerify() {

		ArrayList<String> value = new ArrayList<String>();

		for (WebElement ele : driver.findElements(LicenceTabletextVerify)) {
			value.add(ele.getText());
		}
		return value;
	}
	
	public ArrayList<String> output(Properties prop) {
		ArrayList<String> expectedvalue = new ArrayList<String>();
		
		expectedvalue.add(prop.getProperty("LicenseeName"));
		expectedvalue.add(prop.getProperty("LicenceType"));
		expectedvalue.add(prop.getProperty("TotalCount"));
		expectedvalue.add(prop.getProperty("UsedInTotal"));
		expectedvalue.add(prop.getProperty("RemainingInTotal"));
		expectedvalue.add(prop.getProperty("IssuedDate"));
		expectedvalue.add(prop.getProperty("ExpirationDate"));
		expectedvalue.add(prop.getProperty("LicenceKey"));
		return expectedvalue;
	}
	
	
	
	
	//Reference
	
	By Reference = By.xpath("//input[@name='Reference']");
	
	public WebElement getReference() {
		return driver.findElement(Reference);
	}
	
	By referenceScreenTitle = By.xpath("//div[@class='screentitle']");
	
	
	public String getreferenceScreenTitle() {
		return driver.findElement(referenceScreenTitle).getText();
	}
	
	By InstallerDownloadsVerifyText =  By.xpath("//label[normalize-space()='Installer Downloads:']");
	
	public String getInstallerDownloadsVerifyText() {
		return driver.findElement(InstallerDownloadsVerifyText).getText();
	}
	
	By PluginDownloadsVerifyText = By.xpath("//label[normalize-space()='Plug-in Downloads:']");
	
	
	public String getPluginDownloadsVerifyText() {
		return driver.findElement(PluginDownloadsVerifyText).getText();
	}
	
	
	By DocumentationVerifyText = By.xpath("//label[normalize-space()='Documentation:']");
	
	public String getDocumentationVerifyText() {
		return driver.findElement(DocumentationVerifyText).getText();
	}
	
	
	
	
	
	
	
	
	
	

}
