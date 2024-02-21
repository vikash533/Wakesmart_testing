package com.wakesmart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.By;

public class WSSettingsSecurity {
	public WebDriver driver;
	
	public WSSettingsSecurity(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//ul[@class='MuiList-root MuiList-padding MuiList-subheader css-19o40po'])[2]/a[2]")
	public WebElement getSecurity;
	
	@FindBy(xpath="//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-en0w5h']")
	public WebElement getSecuritySettingText;
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p")
	public WebElement getSystemOptionsText;
	
	@FindBy(xpath="(//div[@class='MuiCardHeader-content css-11qjisw'])[2]/h5")
	public WebElement getPasswordComplexitySettingText;
	
	@FindBy(xpath="(//div[@class='MuiCardHeader-content css-11qjisw'])[3]/h5")
	public WebElement getDeviceUpgradeSettingsText;
	
	@FindBy(xpath="//input[@name='pwdLength']")
	public WebElement getMinimumLength;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[2]")
	public WebElement getMissedAttemptsLimit;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[3]")
	public WebElement getExpirationLimit;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[4]")
	public WebElement getReuseCycle;
	
	@FindBy(xpath="//label[text()='Active 2-Factor Authentication']")
	public WebElement getActiveTwoFactorAuthenticationText;
	
	@FindBy(xpath="//label[text()='Require Capital Letter']")
	public WebElement getRequireCapitalLetterText;
	
	@FindBy(xpath="//label[text()='Require Lowercase']")
	public WebElement getRequireLowerCaseText;
	
	@FindBy(xpath="//label[text()='Require Number']")
	public WebElement getRequireNumberText;
	
	@FindBy(xpath="//label[text()='Require Special Character']")
	public WebElement getRequireSpecialCharacterText;
	
	@FindBy(xpath="//label[text()='Special Characters']")
	public WebElement getSpecialCharacterText;
	
	@FindBy(xpath="//p[text()='WakeSMART Client Upgrader']")
	public WebElement getWakeSMARTClientUpgraderText;
	
	@FindBy(xpath="//p[text()='Current Release Versions:']")
	public WebElement getCurrentReleaseVersionsText;
	
	@FindBy(xpath="//p[text()='Auto-Upgrade Version:']")
	public WebElement getAutoUpgradeVersionText;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[5]")
	public WebElement getActiveTwoFactorAuthentication;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[6]")
	public WebElement getRequieCapitalLetter;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[7]")
	public WebElement getRequireLowercase;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[8]")
	public WebElement getRequireNumber;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[9]")
	public WebElement getRequireSpecialCharacter;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[10]")
	public WebElement getSpecialCharacter;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[2])//div/span")
	public WebElement getEnableAutoUpgrade;
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[2])//div/div[@class='MuiFormControl-root css-1426l2u']")
	public WebElement getAutoUpgradeVersion;
	@FindBy(xpath="//div[@class='MuiBox-root css-14mw2gw']//button[1]/span[@class='MuiTouchRipple-root css-w0pj6f']")
	public WebElement getsaveButton;
	
	By AutoUpgradeVersionDropdown= By.xpath("MuiList-root MuiList-padding MuiMenu-list css-r8u8y9");
	
	public List<WebElement> getAutoUpgradeVersionDropdown() {
		return driver.findElements(AutoUpgradeVersionDropdown);
		
	}
	
}
