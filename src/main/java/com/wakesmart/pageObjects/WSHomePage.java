package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class WSHomePage extends BaseClass{
	
	public WSHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By AccountSettingsIcon = By.xpath("//div[@class='MuiButtonBase-root MuiChip-root MuiChip-outlined MuiChip-sizeMedium MuiChip-colorPrimary MuiChip-clickable MuiChip-clickableColorPrimary MuiChip-outlinedPrimary css-1bi0tq7']");
	By logout = By.xpath("(//div[@class='MuiListItemText-root css-n5xu2x'])[2]");
	By MenuButton = By.xpath("//div[@class='MuiAvatar-root MuiAvatar-rounded MuiAvatar-colorDefault css-1sha7oh']");
	By GeneralMenu = By.xpath("(//span[@class='MuiTypography-root MuiTypography-caption MuiTypography-gutterBottom css-lb3gvf'])[1]");
	By AccountSettings = By.xpath("//p[.='Account Settings']");
	By ChangedPasswordButton = By.xpath("//button[.='Change Password']");
	
	By oldPasswordText =By.xpath("(//input[@type='password'])[1]");
	By NewPasswordText =By.xpath("(//input[@type='password'])[2]");
	By ConfirmPasswordText =By.xpath("(//input[@type='password'])[3]");
	By saveButton =By.xpath("(//button[normalize-space()='Save'])[2]");
	
	public WebElement getAccountSettingsIcon() {
		return driver.findElement(AccountSettingsIcon);
	}
	public WebElement getAccountSettings() {
		return driver.findElement(AccountSettings);
	}
	public WebElement getChangePasswordButton() {
		return driver.findElement(ChangedPasswordButton);
	}
	public WebElement getOldChangePassword() {
		return driver.findElement(oldPasswordText);
	}
	public WebElement getNewPassword() {
		return driver.findElement(NewPasswordText);
	}
	public WebElement getConfirmPassword() {
		return driver.findElement(ConfirmPasswordText);
	}
	public WebElement getClickSaveButton() {
		return driver.findElement(saveButton);
	}
	
	public WebElement getlogout() {
		return driver.findElement(logout);
	}

	public WebElement getMenuButton() {
		return driver.findElement(MenuButton);
	}

	public WebElement getGeneralMenu() {
		return driver.findElement(GeneralMenu);
	}
}
