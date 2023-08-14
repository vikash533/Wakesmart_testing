package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class WSHomePage extends BaseClass{
	
	public WSHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By AccountSettingsIcon = By.xpath("(//div[@class='MuiAvatar-root MuiAvatar-circular MuiChip-icon MuiChip-iconMedium MuiChip-iconColorPrimary css-18l8ecj-MuiAvatar-root'])");
	By logout = By.xpath("(//div[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters css-bqgr6y-MuiButtonBase-root-MuiListItemButton-root'])[2]");
	By MenuButton = By.xpath("//div[@class='MuiAvatar-root MuiAvatar-rounded MuiAvatar-colorDefault css-1rwwuin-MuiAvatar-root']");
	By GeneralMenu = By.xpath("(//span[@class='MuiTypography-root MuiTypography-caption MuiTypography-gutterBottom css-1e5ro1l-MuiTypography-root'])[1]");
	
	
	
	
	public WebElement getAccountSettingsIcon() {
		return driver.findElement(AccountSettingsIcon);
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
