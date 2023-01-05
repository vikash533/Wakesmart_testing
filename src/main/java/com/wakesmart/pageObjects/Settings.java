package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class Settings extends BaseClass {
	
	public Settings(WebDriver driver) {
		this.driver=driver; 
	}
	
	//Advance
	
	
	By Settings = By.xpath("//input[@id='settings']");
	By SettingsAdvanced = By.xpath("//input[@name='Advanced']");
	By ScreenHeader = By.xpath("//div[@class='screentitle']");
	By InttelligentUpdateTextVerify = By.xpath("//h4[normalize-space()='Intelligent Update (iUpdate):']");
	By DemandReductionTextVerify = By.xpath("//h4[normalize-space()='Demand Reduction:']");
	By RaptorApplianceConnectionsTextVerify = By.xpath("//h4[normalize-space()='Raptor Appliance Connections:']");
	By EnableIbutton  = By.xpath("//img[@id='aiwakeimg']");
	By EnablePriorityUpdateButton =  By.xpath("//img[@id='prioritywakeimg']");
	By EnableDemandreductionButton = By.xpath("//img[@id='demandreductionimg']"); 
	By DisplayDimmingAmount = By.xpath("//h4[normalize-space()='20%']");
	By MinimumInactivityTimeOut = By.xpath("//h4[normalize-space()='10 minutes']");
	By RaptorApplianceConnectionsButton = By.xpath("//img[@id='appconnectimg']");
	
	By EnableIUpdate = By.xpath("//img[@id='aiwakeimg']");
	By EnablePriorityUpdate = By.xpath("//img[@id='prioritywakeimg']");
	By EnableDemandReduction = By.xpath("//img[@id='demandreductionimg']");

	
	public String getEnableIUpdate() {
		return driver.findElement(EnableIUpdate).getDomAttribute("value");
	}
	
	public String getEnablePriorityUpdate() {
		return driver.findElement(EnablePriorityUpdate).getDomAttribute("value");
	}
	
	public String getEnableDemandReduction() {
		return driver.findElement(EnableDemandReduction).getDomAttribute("value");
	}

	//Security
	
	By Security = By.xpath("//input[@name='Security']");
	By passwordComplexitySettings = By.xpath("//h4[normalize-space()='Password Complexity Settings :']");
	By ActiveTwoFactorAuthentication = By.xpath("//h5[normalize-space()='Active Two-Factor Authentication:']");
	By MinimumLength = By.xpath("//h5[normalize-space()='Minimum Length (chars):']");
	By RequireCapitalLetter = By.xpath("//h5[normalize-space()='Require Capital Letter:']");
	By RequireLowerCase = By.xpath("//h5[normalize-space()='Require Lowercase:']");
	By RequireNumber = By.xpath("//h5[normalize-space()='Require Number:']");
	By RequireSpecialCharacter = By.xpath("//h5[normalize-space()='Require Special Character:']");
	By MissedAttemptsLimits = By.xpath("//h5[normalize-space()='Missed Attempts Limit (Trys):']");
	By ReuseCycle = By.xpath("//h5[normalize-space()='Reuse Cycle (Times):']");
	By ExpirirationLimit = By.xpath("(//h5[normalize-space()='Expiration Limit (Days):'])[1]");
	


	
	
	By ActiveTwoFactorAuthenticationButton = By.xpath("//img[@id='activeTwoFactorImg']");
	By MinimumLengthField = By.xpath("//input[@id='pwdLength']");
	By RequireCapitalLetterFiled = By.xpath("//img[@id='pwdCapReqImg']");
	By RequireLowerCaseField = By.xpath("//img[@id='pwdLwrReqImg']");
	By RequireNumberField = By.xpath("//img[@id='pwdNumReqImg']");
	By RequireSpecialCharacterField= By.xpath("//img[@id='pwdSpclReqImg']");
	By MissedAttemptsLimitField = By.xpath("//input[@id='pwdLockout']");
	By ExpirirationLimitField = By.xpath("//input[@id='pwdExpire']");
	By ReuseCycleField = By.xpath("//input[@id='pwdHistory']");
	
	public String getActiveTwoFactorAuthenticationButton() {
		return driver.findElement(ActiveTwoFactorAuthenticationButton).getDomAttribute("value");
	}
	
	public String getMinimumLengthField() {
		return driver.findElement(MinimumLengthField).getDomAttribute("value");
	}
	public String getRequireCapitalLetterFiled() {
		return driver.findElement(RequireCapitalLetterFiled).getDomAttribute("value");
	}
	public String getRequireLowerCaseField() {
		return driver.findElement(RequireLowerCaseField).getDomAttribute("value");
	}
	public String getRequireNumberField() {
		return driver.findElement(RequireNumberField).getDomAttribute("value");
	}
	
	public String getRequireSpecialCharacterField() {
		return driver.findElement(RequireSpecialCharacterField).getDomAttribute("value");
	}
	public String getMissedAttemptsLimitField() {
		return driver.findElement(MissedAttemptsLimitField).getDomAttribute("value");
	}
	public String getExpirirationLimitField() {
		return driver.findElement(ExpirirationLimitField).getDomAttribute("value");
	}
	
	public String getReuseCycleField() {
		return driver.findElement(ReuseCycleField).getDomAttribute("value");
	}

	//Device upgrade settings
	
	By DeviceUpgradeSettings = By.xpath("//h4[normalize-space()='Device Upgrade Settings:']");
	By AutoUpgrade = By.xpath("//h5[normalize-space()='Auto-Upgrade:']");
	By ClientVersions = By.xpath("//h5[normalize-space()='Client Versions:']");
	By WindowsClientVersionText = By.xpath("//label[normalize-space()='Windows']");
	By MacOSClientVersionText = By.xpath("//label[normalize-space()='MacOS']");
	By ChromeBookClientVersionText = By.xpath("//label[normalize-space()='Chromebook']");
	
	//General
	
	By GeneralSettings = By.xpath("//h4[normalize-space()='General Settings:']");
	By DevicesShown = By.xpath("//input[@id='devicesShown']");
	By DataRetention =By.xpath("//input[@id='keepdays']");
	By CheckInInterval = By.xpath("//input[@id='checkin']");
	By UnLicenceAfter = By.xpath("//input[@id='unlicensespan']");
	By ShowUnlicencedFor = By.xpath("//input[@id='showunlicensed']");
	By AlwaysShowUnlicenced = By.xpath("//img[@name='showstaleimg']");
	By EnergyCost = By.xpath("//input[@id='energycost']");
	By CO2 = By.xpath("//input[@id='co2cost']");
	By GreenPower = By.xpath("//input[@id='greenpercent']");
	By SettingsSaveButton = By.xpath("//button[@id='saveBtn']");
	
	public WebElement getSettingsSaveButton() {
		return driver.findElement(SettingsSaveButton);
	}
	
	public String getEnergyCost() {
		return driver.findElement(EnergyCost).getDomProperty("value");
	}
	public String getCO2() {
		return driver.findElement(CO2).getDomProperty("value");
	}
	public String getGreenPower() {
		return driver.findElement(GreenPower).getDomProperty("value");
	}
	
	public String getAlwaysShowUnlicenced() {
		return driver.findElement(AlwaysShowUnlicenced).getDomAttribute("data-val");
	}
	
	public WebElement getAlwaysShowUnlicencedClick() {
		return driver.findElement(AlwaysShowUnlicenced);
	}
	
	public String getShowUnlicencedFor() {
		return driver.findElement(ShowUnlicencedFor).getDomProperty("value");
	}
	
	public String getUnLicenceAfter() {
		return driver.findElement(UnLicenceAfter).getDomProperty("value");
	}
	
	public String getCheckInInterval() {
		return driver.findElement(CheckInInterval).getDomProperty("value");
	}
	
	public String getDataRetention() {
		return driver.findElement(DataRetention).getDomProperty("value");
	}
	
	public String getDevicesShown() {
		return driver.findElement(DevicesShown).getDomProperty("value");
	}
	
	public String getGeneralSettings() {
		return driver.findElement(GeneralSettings).getText();
	}
	
	By SettingsGeneral = By.xpath("//input[@name='General']");
	
	public WebElement getSettingsGeneral() {
		return driver.findElement(SettingsGeneral);
	}
	
	public String getDeviceUpgradeSettings() {
		return driver.findElement(DeviceUpgradeSettings).getText();
	}
	
	public String getAutoUpgrade() {
		return driver.findElement(AutoUpgrade).getText();
	}
	
	public String getClientVersions() {
		return driver.findElement(ClientVersions).getText();
	}
	
	public String getWindowsClientVersionText() {
		return driver.findElement(WindowsClientVersionText).getText();
	}
	
	public String getMacOSClientVersionText() {
		return driver.findElement(MacOSClientVersionText).getText();
	}
	public String getChromeBookClientVersionText() {
		return driver.findElement(ChromeBookClientVersionText).getText();
	}
	
	public String getWindowsVersion(String version) {
		return driver.findElement(By.xpath("//label[normalize-space()='"+version+"']")).getText();
	}
	
	public String getMacOSVersion(String version) {
		return driver.findElement(By.xpath("//label[normalize-space()='"+version+"']")).getText();
	}
	
	public String getChromebookVersion(String version) {
		return driver.findElement(By.xpath("//label[normalize-space()='"+version+"']")).getText();
	}

	public String getExpirirationLimit() {
		return driver.findElement(ExpirirationLimit).getText();
	}
	
	public WebElement getSecurity() {
		return driver.findElement(Security);
	}
	
	public String getpasswordComplexitySettings() {
		return driver.findElement(passwordComplexitySettings).getText();
	}
	
	public String getActiveTwoFactorAuthentication() {
		return driver.findElement(ActiveTwoFactorAuthentication).getText();
	}
	
	public String getMinimumLength() {
		return driver.findElement(MinimumLength).getText();
	}
	
	public String getRequireCapitalLetter() {
		return driver.findElement(RequireCapitalLetter).getText();
	}
	
	public String getRequireLowerCase() {
		return driver.findElement(RequireLowerCase).getText();
	}
	
	public String getRequireNumber() {
		return driver.findElement(RequireNumber).getText();
	}
	
	public String getRequireSpecialCharacter() {
		return driver.findElement(RequireSpecialCharacter).getText();
	}
	
	public String getMissedAttemptsLimits() {
		return driver.findElement(MissedAttemptsLimits).getText();
	}
	
	public String getReuseCycle() {
		return driver.findElement(ReuseCycle).getText();
	}
	

	//Client Version  
	
	By DeviceUpgradeSettingsd = By.xpath("//h5[normalize-space()='Reuse Cycle (Times):']");
	By ClientVersionWindows = By.xpath("//label[normalize-space()='1.2.1.21']");
	By ClientVersionMacOS = By.xpath("//label[normalize-space()='1.1.0.7']");
	By ClientVersionChromebook = By.xpath("//label[normalize-space()='1.0.0.30']");
	
	public WebElement getDeviceUpgradeSettingsd() {
		return driver.findElement(DeviceUpgradeSettingsd);
	}
	
	public WebElement getClientVersionWindows() {
		return driver.findElement(ClientVersionWindows);
	}
	
	public WebElement getClientVersionMacOS() {
		return driver.findElement(ClientVersionMacOS);
	}
	
	public WebElement getClientVersionChromebook() {
		return driver.findElement(ClientVersionChromebook);
	}
	
	

	
	public boolean getRaptorApplianceConnectionsButton() {
		return driver.findElement(RaptorApplianceConnectionsButton).isEnabled();
	}
	
	public String getMinimumInactivityTimeOut() {
		return driver.findElement(MinimumInactivityTimeOut).getText();
	}
	
	
	public String getDisplayDimmingAmount() {
		return driver.findElement(DisplayDimmingAmount).getText();
	}
	
	public boolean getEnableDemandreductionButton() {
		return driver.findElement(EnableDemandreductionButton).isEnabled();
	}
	

	public boolean getEnablePriorityUpdateButton() {
		return driver.findElement(EnablePriorityUpdateButton).isEnabled();
	}
	
	public boolean getEnableIbutton() {
		return driver.findElement(EnableIbutton).isEnabled();
	}

	public String getInttelligentUpdateTextVerify() {
		return driver.findElement(InttelligentUpdateTextVerify).getText();
	}
	
	public String getDemandReductionTextVerify() {
		return driver.findElement(DemandReductionTextVerify).getText();
	}
	
	public String getRaptorApplianceConnectionsTextVerify() {
		return driver.findElement(RaptorApplianceConnectionsTextVerify).getText();
	}

	public WebElement getSettings() {
		return driver.findElement(Settings);
	}

	public WebElement getSettingsAdvanced() {
		return driver.findElement(SettingsAdvanced);
	}
	
	public String getScreenHeader() {
		return driver.findElement(ScreenHeader).getText();
	}
	
	
}
