package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSSettingsGeneral;
//progress

public class WSSettingsGeneralTest extends BaseClass{
	
	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSSettingsGeneral general;
	
	@BeforeClass
	public void browserLaunch()  {
		try {
			driver = launchBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}

	@AfterClass(enabled=false)
	public void tearDown() {
	        driver.quit();
	}
	
	@Test(priority=1)
	public void settingsGeneral() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		general = new WSSettingsGeneral(driver);
		
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"));
		action.JSClick(driver, general.getGeneral);
		
		
		softAssert.assertEquals(general.getGeneralSettingsText.getText(), prop.getProperty("SettingsGeneralPageText"));
		softAssert.assertEquals(general.getSystemOptionsText.getText(), prop.getProperty("SettingsGeneralSystemOptionsText"));
		softAssert.assertEquals(general.getGeneralSettingsBoxText.getText(), prop.getProperty("SettingsGeneralPageText"));
		softAssert.assertEquals(general.getEnergyValuesText.getText(), prop.getProperty("SettingsGeneralEnergyValuesText"));
		softAssert.assertEquals(general.getGreenhouseGasComparisonsText.getText(), prop.getProperty("SettingsGeneralGreenhouseGasComparisonsText"));
		softAssert.assertEquals(general.getDashboardPanelSelectionText.getText(), prop.getProperty("SettingsGeneralDashboardPanelSelectionsText"));
		
		softAssert.assertEquals(general.getDevicesToShow(), prop.getProperty("SettingsGeneralDeviceToShowRows"));
		softAssert.assertEquals(general.getdataRetention(), prop.getProperty("SettingsGeneralDataRetention"));
		softAssert.assertEquals(general.getcheckInterval(), prop.getProperty("SettingsGeneralCheckInInterval"));
		softAssert.assertEquals(general.getunlicensedAfter(), prop.getProperty("SettingsGeneralUnlicenseAfterDays"));
		softAssert.assertEquals(general.getshowUnlicensedFor(), prop.getProperty("SettingsGeneralShowUnlicensedForDays"));
		
		
		
		
		
		
		
		
		softAssert.assertAll();
}
}
