package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class WSHomePage extends BaseClass{
	
	public WSHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By AccountSettingsIcon = By.xpath("(//div[@class='MuiAvatar-root MuiAvatar-circular MuiChip-icon MuiChip-iconMedium MuiChip-iconColorPrimary css-pm64by'])");
	By logout = By.xpath("(//div[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters css-cqhtya'])[2]");
	By MenuButton = By.xpath("//div[@class='MuiAvatar-root MuiAvatar-rounded MuiAvatar-colorDefault css-1sha7oh']");
	By GeneralMenu = By.xpath("(//span[@class='MuiTypography-root MuiTypography-caption MuiTypography-gutterBottom css-lb3gvf'])[1]");
	
	
	
	
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
