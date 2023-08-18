package com.wakesmart.pageObjects;

import java.util.ArrayList;
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
	
	
	By ManagementUsers = By.xpath("//div[@class='MuiList-root css-uppwh0-MuiList-root']//a[6]");
	By UserManagementText = By.xpath("//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-1y85m9j-MuiTypography-root']");
	By AddButtonUser = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-1equabv-MuiGrid-root']/button");
	By UserTableHeaderText = By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1uwa9re-MuiTableRow-root']/th");
	By AddUserButton = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-1equabv-MuiGrid-root']/button");
	By UserName = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1lmjksc-MuiInputBase-input-MuiOutlinedInput-input'])[1]");
	By Email = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1lmjksc-MuiInputBase-input-MuiOutlinedInput-input'])[2]");
	By ConfirmEmail = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1lmjksc-MuiInputBase-input-MuiOutlinedInput-input'])[3]");
	By AddNewUserSubmitButton = By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root']/button[2]");
	By AddNewUserCancelButton = By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-hlj6pa-MuiDialogActions-root']/button[1]");
	By AlertMessage = By.xpath("//div[@role='alert']/div[2]");
	By AlertCloseButton = By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']");
	
	
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
