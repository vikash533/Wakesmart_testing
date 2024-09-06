package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WSUsers {
	public WebDriver driver;
	
	public WSUsers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By addNewUserText = By.xpath("//h2[@class='MuiTypography-root MuiTypography-h6 MuiDialogTitle-root css-1rnijnh']");
	By ManagementUsers = By.xpath("//div[@class='MuiList-root css-1xidfkz']//a[6]");
	By UserManagementText = By.xpath("//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-1y85m9j-MuiTypography-root']");
	By AddButtonUser = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8']/button");
	By UserTableHeaderText = By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1b8dwk7']/th");
	By AddUserButton = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-1equabv-MuiGrid-root']/button");
	By UserName = By.xpath("(//div[@class='MuiDialogContent-root css-18vaxhi']//div//input)[1]");
	By Email = By.xpath("(//div[@class='MuiDialogContent-root css-18vaxhi']//div//input)[2]");
	By ConfirmEmail = By.xpath("(//div[@class='MuiDialogContent-root css-18vaxhi']//div//input)[3]");
	By AddNewUserSubmitButton = By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-1vskg8q']/button[2]");
	By AddNewUserCancelButton = By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root']/button[1]");
	By AlertMessage = By.xpath("//div[@role='alert']/div[2]");
	By AlertCloseButton = By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']");
	By selectTheUserGroup = By.id("mui-component-select-userGroupId");
	By selectTheUserGroupDropdownText = By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1e9knfh'])");
	By selectTheUserGropCheckBoxes = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9'])/li/span[1]");
	
	public WebElement getselectTheUserGropCheckBoxes() {
		return driver.findElements(selectTheUserGropCheckBoxes).get(0);
	}
	
	public WebElement getaddNewUserText() {
		return driver.findElement(addNewUserText);
	}
	
	
	public List<String> getselectTheUserGroupDropdownText() throws InterruptedException {
		List<WebElement> list = driver.findElements(selectTheUserGroupDropdownText);
		
		List<String> textVerify = new ArrayList<>();
		for (WebElement element : list) {
			System.out.println(element.getAttribute("data-value"));
				textVerify.add(element.getAttribute("data-value"));
		}
		return textVerify;
	}
	
	
	public List<String> getselectTheUserGroupDropdownTextVerify(Properties prop) {
		 List<String> list = Arrays.asList(prop.getProperty("ManagementUserOrganizationAdministration"),
				prop.getProperty("ManagementUserOrganizationReportingUsers"),
				prop.getProperty("ManagementUserOrganizationRemoteWake"),
				prop.getProperty("ManagementUserOrganizationTestAdminGroup"),
				prop.getProperty("ManagementUserOrganizationtestnewgroup"));
		 return list;
	}
	
	
	
	
	
	public WebElement getselectTheUserGroup() {
		return driver.findElement(selectTheUserGroup);
	}
	
	public WebElement getAddNewUserCancelButton() {
		return driver.findElement(AddNewUserCancelButton);
	}
	
	
	
	
	public WebElement getAlertCloseButton() {
		return driver.findElement(AlertCloseButton);
	}
	
	public String getAlertMessage() {
		return driver.findElement(AlertMessage).getText();
	}
	
	public WebElement getAddUserButton() {
		return driver.findElement(AddUserButton);
	}
	
	public WebElement getUserName() {
		return driver.findElement(UserName);
	}
	
	public WebElement getEmail() {
		return driver.findElement(Email);
	}
	
	public WebElement getConfirmEmail() {
		return driver.findElement(ConfirmEmail);
	}
	
	public WebElement getAddNewUserSubmitButton() {
		return driver.findElement(AddNewUserSubmitButton);
	}
	
	public List<WebElement> getUserTableHeaderText() {
		return driver.findElements(UserTableHeaderText);
	}
	
	public List<String> getUsersTableHeaderTextVerify() {

		List<String> textVerify = new ArrayList<>();

		for (WebElement element : getUserTableHeaderText()) {
			textVerify.add(element.getText());
		}
		return textVerify;
	}
	
	
	public List<String> getUsersTableHeaderDataToVerify(Properties prop) {
		List<String> textVerify = new ArrayList<>();
		
		textVerify.add(prop.getProperty("ManagementUsersTableUserName"));
		textVerify.add(prop.getProperty("ManagementUsersTableUserEmailAddress"));
		textVerify.add(prop.getProperty("ManagementUsersTableUserSsoUser"));
		textVerify.add(prop.getProperty("ManagementUsersTableUserValidated"));
		textVerify.add(prop.getProperty("ManagementUsersTableUserLocked"));
		textVerify.add(prop.getProperty("ManagementUsersTableUserOptions"));

	return textVerify;
	}
	
	
	
	
	public WebElement getManagementUsers() {
		return driver.findElement(ManagementUsers);
	}
	
	public WebElement getUserManagementText() {
		return driver.findElement(UserManagementText);
	}
	
	public WebElement getAddButtonUser() {
		return driver.findElement(AddButtonUser);
	}
	
}
