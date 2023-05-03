package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class WSHomePage extends BaseClass{
	
	public WSHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By AccountSettingsIcon = By.xpath("(//div[@class='MuiButtonBase-root MuiChip-root MuiChip-outlined MuiChip-sizeMedium MuiChip-colorPrimary MuiChip-clickable MuiChip-clickableColorPrimary MuiChip-outlinedPrimary css-1d7ieb5'])//div");
	By logout = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body2 css-aghghv'])[2]");
	By MenuButton = By.xpath("//button[@class='MuiButtonBase-root css-1cpn4ow']");
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
