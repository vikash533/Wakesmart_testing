package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSPermissionManagement {
	public WebDriver driver;

	public WSPermissionManagement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//div[@class='MuiList-root css-1xidfkz']//a[7]")
	public WebElement getPermission;

	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-en0w5h']")
	public WebElement getPermissionPageText;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ilqee0']")
	public WebElement getPermissionTableHeaderText;

	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-sm-3 MuiGrid-grid-md-3 css-9ppe9d'])/button")
	public WebElement getNewPermissionGroupButton;

	@FindBy(xpath = "//h2[@class='MuiTypography-root MuiTypography-h6 MuiDialogTitle-root css-1rnijnh']")
	public WebElement getAddNewPermissionGroupPopupText;

	@FindBy(xpath = "//tr[@class='MuiTableRow-root MuiTableRow-head css-1b8dwk7']/th")
	private List<WebElement> getPermissionTableColumnText;

	public List<String> tableTextVerify() {
		List<String> name = new ArrayList<>();
		for(WebElement ele : getPermissionTableColumnText) {
			name.add(ele.getText());
		}
		return name;
	}

	public List<String> tableTextVerifyFromLocal(Properties prop) {
		List<String> name = new ArrayList<>();
		name.add(prop.getProperty("ManagementPermissonGroupText"));
		name.add(prop.getProperty("ManagementPermissonRootAdminText"));
		name.add(prop.getProperty("ManagementPermissonServerAdminText"));
		name.add(prop.getProperty("ManagementPermissonOrgAdminText"));
		name.add(prop.getProperty("ManagementPermissonUserAdminText"));
		name.add(prop.getProperty("ManagementPermissonGroupAdminText"));
		name.add(prop.getProperty("ManagementPermissonOptionsText"));
		return name;
	}



	@FindBy(xpath = "(//div[@class='MuiDialogContent-root css-18vaxhi']//div//input)[1]")
	public WebElement getGroupName;

	@FindBy(xpath = "(//div[@class='MuiDialogContent-root css-18vaxhi']//div//input)[2]")
	public WebElement getGroupDescription;

	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label Mui-disabled css-1auv73w']")
	private List<WebElement> getAdminRolesTextDisabled;

	@FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-1auv73w']")
	private List<WebElement> getAdminRolesTextEnabled;


	public List<String> adminRolesTextVerify() {
		List<String> adminRoles = Stream.concat(
				getAdminRolesTextDisabled.stream().map(WebElement::getText),
				getAdminRolesTextEnabled.stream().map(WebElement::getText)
				).collect(Collectors.toList());
		return adminRoles;
	}

	public List<String> adminRolesTextVerifyData(Properties prop) {
		List<String> name = new ArrayList<>();
		name.add(prop.getProperty("ManagementPermissonRootAdmin"));
		name.add(prop.getProperty("ManagementPermissonServerAdmin"));
		name.add(prop.getProperty("ManagementPermissonOrgAdmin"));
		name.add(prop.getProperty("ManagementPermissonUserAdmin"));
		name.add(prop.getProperty("ManagementPermissonGroupAdmin"));
		return name;
	}


	By orgAdminCheckBox = By.xpath("(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary css-1vb6jjw'])[1]");
	By chooseUsersDropdown = By.xpath("//div[@id='demo-multiple-checkbox']");
	By editGroupPermission = By.xpath("//div[@class='MuiBox-root css-1yuhvjn']/button");

	public WebElement getorgAdminCheckBox() {
		return driver.findElement(orgAdminCheckBox);
	}

	public WebElement getchooseUsersDropdown() {
		return driver.findElement(chooseUsersDropdown);
	}

	public WebElement geteditGroupPermission() {
		return driver.findElement(editGroupPermission);
	}

	By chooseUsersFromDropdown1 = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']/li/div");

	public boolean getChoseUsers(String user) {
		boolean flag = false;
		List<WebElement> list = driver.findElements(chooseUsersFromDropdown1);
		for(WebElement ele : list  ) {
			if(ele.getText().equalsIgnoreCase(user)) {
				ele.click();
				flag = true;
				break;
			}
		}
		return flag;
	}
	By AddNewPermissionGroupPopupText=By.xpath("//div[@class='MuiDialog-root MuiModal-root css-148y1pw']//h2");
	public WebElement getAddNewPermissionGroupPopupText() {
		return driver.findElement(AddNewPermissionGroupPopupText);
	}
	By EditGroupPermissionButton=By.xpath("(//div[@class='MuiDialogContent-root css-18vaxhi']//div)[13]/button");
	public WebElement getEditGroupPermissionButton() {
		return driver.findElement(EditGroupPermissionButton);
	}
	By AddNewPermissionGroupSubmitButton=By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc'])/button[2]");
	public WebElement getAddNewPermissionGroupSubmitButton() {
		return driver.findElement(AddNewPermissionGroupSubmitButton);
	}






	By EditGroupPermissionGroupName =By.xpath("((//div[@class='MuiDialogContent-root css-18vaxhi'])[2]//tbody/tr)[23]");
	public WebElement getEditGroupPermissionGroupName() {
		return driver.findElement(EditGroupPermissionGroupName);

	}

	public void clickEditGroupPermissionGroupNameCheckbox(WebDriver driver) {
		for (int j = 0; j < 2; j++) {
			for (int i = 2; i <= 7; i++) {
				By EditGroupPermissionGroupNameCheckBoxes = By.xpath("((//div[@class='MuiDialogContent-root css-18vaxhi'])[2]//tbody/tr)[23]/td[" + i + "]");
				WebElement element = driver.findElement(EditGroupPermissionGroupNameCheckBoxes);
				element.click();
			}
		}
	}
	public void clickEditGroupPermissionGroupNameCheckboxSingleTime(WebDriver driver) {
		for (int i = 2; i <= 7; i++) {
			By EditGroupPermissionGroupNameCheckBoxes = By.xpath("((//div[@class='MuiDialogContent-root css-18vaxhi'])[2]//tbody/tr)[23]/td[" + i + "]");
			WebElement element = driver.findElement(EditGroupPermissionGroupNameCheckBoxes);
			element.click();
		}
	}
	By EditGroupPermissionCancelButton =By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc'])[2]/button[1]");
	public WebElement getEditGroupPermissionCancelButton() {
		return driver.findElement(EditGroupPermissionCancelButton);
	}
	By EditGroupPermissionSaveButton =By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc'])[2]/button[2]");
	public WebElement getEditGroupPermissionSaveButton() {
		return driver.findElement(EditGroupPermissionSaveButton);
	}

	By PremissionGroupDelete = By.xpath("(//div[@class='MuiBox-root css-0']/button[2])[8]");
	public WebElement deletePermissionGroup() {
		return driver.findElement(PremissionGroupDelete);
	}
	By PremissionGroupDeletePopup = By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc']/button[2]");
	public WebElement deletePermissionGroupPopup() {
		return driver.findElement(PremissionGroupDeletePopup);
	}

	By PremissionGroupVerify = By.xpath("//tr[@class='MuiTableRow-root css-1b8dwk7']/td/p");
	public void PermissionGroupNameVerify(WebDriver driver,String PermissionGroup) {
		List<WebElement> list = driver.findElements(PremissionGroupVerify);
		for(WebElement ele : list  ) {
			if(ele.getText().equalsIgnoreCase(PermissionGroup)) {
				deletePermissionGroup().click();
				deletePermissionGroupPopup().click();
			}
				
		}
	}
}
