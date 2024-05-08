package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.HomePage;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSSettingsSecurity;

public class WSSettingsSecurityTest extends BaseClass {
	public WebDriver driver;
	private IndexPage indexpage;
	private HomePage homepage;
	private Action action;
	private SoftAssert softAssert;
	private WSSettingsSecurity security;
	@BeforeClass
	public void browserLaunch()  {
		try {
			driver = launchBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}

	@AfterClass(enabled=true)
	public void tearDown() {
//	        driver.quit();
	}
	@Test(priority=1)
	public void setingSecurityoptionVerify() throws InterruptedException {
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		security = new WSSettingsSecurity(driver);
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		action.fluentWait(driver, security.getSecurity);
		action.JSClick(driver,security.getSecurity);
		
		Thread.sleep(9000);
		
		softAssert.assertEquals(security.getSecuritySettingText.getText(), prop.getProperty("SettingsSecurityPageText"));
		softAssert.assertEquals(security.getSystemOptionsText.getText(), prop.getProperty("SettingsSecuritySystemOptionText"));
		softAssert.assertEquals(security.getPasswordComplexitySettingText.getText(), prop.getProperty("SettingsSecurityPasswordComplexitySettingsText"));
		softAssert.assertEquals(security.getDeviceUpgradeSettingsText.getText(), prop.getProperty("SettingsSecurityDeviceUpgradeSettings"));
		softAssert.assertEquals(security.getMinimumLength.getAttribute("value"),prop.getProperty("SettingSecurityMinimumLength"));
		softAssert.assertEquals(security.getMissedAttemptsLimit.getAttribute("value"),prop.getProperty("SettingSecurityMissedAttemptsLimit"));
		softAssert.assertEquals(security.getExpirationLimit.getAttribute("value"),prop.getProperty("SettingSecurityExpirationLimit"));
		softAssert.assertEquals(security.getReuseCycle.getAttribute("value"),prop.getProperty("SettingSecurityReuseCycle"));
		softAssert.assertEquals(security.getActiveTwoFactorAuthenticationText.getText(),prop.getProperty("SettingSecurityActiveTwoFactorAutenticationText"));
		softAssert.assertEquals(security.getRequireCapitalLetterText.getText(),prop.getProperty("SettingSecurityRequireCapitalLetterText"));
		softAssert.assertEquals(security.getRequireLowerCaseText.getText(),prop.getProperty("SettingSecurityRequireLowerCaseText"));
		softAssert.assertEquals(security.getRequireNumberText.getText(),prop.getProperty("SettingSecurityRequireNumberText"));
		softAssert.assertEquals(security.getRequireSpecialCharacterText.getText(),prop.getProperty("SettingSecurityRequireSpecialCharacterText"));
		softAssert.assertEquals(security.getSpecialCharacterText.getText(),prop.getProperty("SettingSecuritySpecialCharacterText"));
		softAssert.assertEquals(security.getWakeSMARTClientUpgraderText.getText(),prop.getProperty("SettingSecurityWakeSMARTClientUpgraderText"));
		softAssert.assertEquals(security.getCurrentReleaseVersionsText.getText(),prop.getProperty("SettingSecurityCurrentReleaseVersionsText"));
		softAssert.assertEquals(security.getAutoUpgradeVersionText.getText(),prop.getProperty("SettingSecurityAutoUpgradeVersionText"));
		softAssert.assertAll();
		
	}
	@Test(priority=2,enabled=false)
	public void enabaleTwoFactorAuthentication() throws InterruptedException{
		homepage = new HomePage(driver);
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action.click(driver, security.getActiveTwoFactorAuthentication);
		action.click(driver, security.getsaveButton);
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg(),prop.getProperty("UpdationPopupConfirmation"));
		//action.click(driver, indexpage.getPopupCloseIcon());
		action.click(driver, homepage.getAccountSettingsIcon());
		action.fluentWait(driver, homepage.getlogout());
		action.JSClick(driver, homepage.getlogout());
		
		
	}
	@Test(priority=3,enabled=false)
	public void verifyTwoFactroAuthentication() {
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		security = new WSSettingsSecurity(driver);
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		action.JSClick(driver,security.getSecurity);
		action.type(null, null);
	}
}
