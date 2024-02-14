package com.wakesmart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSSettingsSecurity {
	public WebDriver driver;
	
	public WSSettingsSecurity(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters Mui-selected css-m92ebk']")
	public WebElement getSecurity;
	
	@FindBy(xpath="//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-en0w5h']")
	public WebElement getSecuritySetting;
	
	@FindBy(xpath="//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p")
	public WebElement getSystemOptions;
	
	@FindBy(xpath="(//div[@class='MuiCardHeader-content css-11qjisw'])[2]/h5")
	public WebElement getPasswordComplexitySetting;
	
	@FindBy(xpath="(//div[@class='MuiCardHeader-content css-11qjisw'])[3]/h5")
	public WebElement getDeviceUpgradeSettings;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[1]")
	public WebElement getMinimumLength;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[2]")
	public WebElement getMissedAttemptsLimit;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[3]")
	public WebElement getExpirationLimit;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[4]")
	public WebElement getReuseCycle;
	
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
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[1]//input)[9]")
	public WebElement getSpecialCharacter;
	
	@FindBy(xpath="((//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[2])//div/span")
	public WebElement getEnableAutoUpgrade;
}
