package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By ScreenTitle = By.xpath("//div[@class='screentitle']");
	By userIcon = By.xpath("//input[@id='userstuff']");
	By AccountSettingsIcon = By.xpath("//span[@class='MuiChip-label MuiChip-labelMedium css-14vsv3w']");
	By logout = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body2 css-aghghv'])[2]");
	By AboutIcon = By.xpath("//input[@id='aboutit']");
	By ReportsIcon = By.xpath("//input[@id='reports']");
	By getuserIconUserID = By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1auv73w'])[1]");

	public WebElement getAccountSettingsIcon() {
		return driver.findElement(AccountSettingsIcon);
	}
	
	
	public WebElement getScreenTitle() {
		return driver.findElement(ScreenTitle);
	}

	public WebElement getuserIcon() {
		return driver.findElement(userIcon);
	}

	public WebElement getlogout() {
		return driver.findElement(logout);
	}

	public WebElement getAboutIcon() {
		return driver.findElement(AboutIcon);
	}

	public WebElement getReportsIcon() {
		return driver.findElement(ReportsIcon);
	}

	public WebElement getuserIconUserID() {

		return driver.findElement(getuserIconUserID);
	}

}
