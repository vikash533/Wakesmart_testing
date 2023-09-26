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
//completed as per the new UI

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

	@AfterClass(enabled=true)
	public void tearDown() {
	        driver.quit();
	}
	
	@Test(priority=1)
	public void settingsGeneralDefaultOptionsVerify() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();
		general = new WSSettingsGeneral(driver);
		
		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		action.JSClick(driver, general.getGeneral);
		
		softAssert.assertEquals(general.getGeneralSettingsText.getText(), prop.getProperty("SettingsGeneralPageText"));
		softAssert.assertEquals(general.getSystemOptionsText.getText(), prop.getProperty("SettingsGeneralSystemOptionsText"));
		softAssert.assertEquals(general.getGeneralSettingsBoxText.getText(), prop.getProperty("SettingsGeneralPageText"));
		softAssert.assertEquals(general.getEnergyValuesText.getText(), prop.getProperty("SettingsGeneralEnergyValuesText"));
		softAssert.assertEquals(general.getGreenhouseGasComparisonsText.getText(), prop.getProperty("SettingsGeneralGreenhouseGasComparisonsText"));
		softAssert.assertEquals(general.getDashboardPanelSelectionText.getText(), prop.getProperty("SettingsGeneralDashboardPanelSelectionsText"));
		
		softAssert.assertEquals(general.getDevicesToShow().getAttribute("value"), prop.getProperty("SettingsGeneralDeviceToShowRows"));
		softAssert.assertEquals(general.getdataRetention().getAttribute("value"), prop.getProperty("SettingsGeneralDataRetention"));
		softAssert.assertEquals(general.getcheckInterval().getAttribute("value"), prop.getProperty("SettingsGeneralCheckInInterval"));
		softAssert.assertEquals(general.getunlicensedAfter().getAttribute("value"), prop.getProperty("SettingsGeneralUnlicenseAfterDays"));
		softAssert.assertEquals(general.getshowUnlicensedFor().getAttribute("value"), prop.getProperty("SettingsGeneralShowUnlicensedForDays"));
		
		softAssert.assertEquals(general.getEnergyCost().getAttribute("value"), prop.getProperty("SettingsGeneralEnergyCost"));
		softAssert.assertEquals(general.getCo2().getAttribute("value"), prop.getProperty("SettingsGeneralEnergyCO2"));
		softAssert.assertEquals(general.getGreenPower().getAttribute("value"), prop.getProperty("SettingsGeneralGreenEnergy"));
		
		//Preferred Equivalent

		softAssert.assertEquals(general.getPreferedEquilent().getText(), prop.getProperty("SettingsGeneralBarrelsofOilConsumedinOneYear"));
		general.getPreferedEquilent().click();
		softAssert.assertEquals(general.PreferdEquilentDropdownOptions(), general.getPreferdEquilentDropdownOptionsVerify(prop));
		
		general.PreferdEquilentDropdownOptionsElements().get(0).click();
		softAssert.assertEquals(general.getPreferedEquilent().getText(), prop.getProperty("SettingsGeneralSmartphonesChargedinaYear"));
	
		//Preferred Avoidance
		softAssert.assertEquals(general.getPreferedAvoidance().getText(), prop.getProperty("SettingsGeneralWindTurbinesRunningforaYear"));
		general.getPreferedAvoidance().click();
		softAssert.assertEquals(general.getPreferedAvoidanceDropdownOptions(), general.getPreferedAvoidanceDropdownOptionsVerify(prop));
		
		general.getgetPreferedAvoidanceDropdownElements().get(0).click();
		softAssert.assertEquals(general.getPreferedAvoidance().getText(), prop.getProperty("SettingsGeneralTonsofWasteRecycled"));
		
		//Preferred Sequestration
		
		softAssert.assertEquals(general.getPreferredSequestration().getText(), prop.getProperty("SettingsGeneralTreeSeedlingsGrownfor10Years"));
		general.getPreferredSequestration().click();
		
		softAssert.assertEquals(general.getPreferredSequestrationDropdownOptions(), general.getPreferredSequestrationDropdownOptionsVerify(prop));
		general.getPreferredSequestrationDropdownElements().get(1).click();
		softAssert.assertEquals(general.getPreferredSequestration().getText(), prop.getProperty("SettingsGeneralAcresofUSForest"));
		
		
		softAssert.assertEquals(general.getDeviceDeatilsTables().getText(), prop.getProperty("SettingsGeneralDevicesDetailsTables"));
		softAssert.assertEquals(general.getDeviceUsage().getText(), prop.getProperty("SettingsGeneralDeviceUsage"));
		softAssert.assertEquals(general.getDevicesByOSandTypes().getText(), prop.getProperty("SettingsGeneralDevicesDevicesbyOSandType"));
		softAssert.assertEquals(general.getPowerStateActvity().getText(), prop.getProperty("SettingsGeneralDevicesPowerStateActivity"));
		softAssert.assertEquals(general.getBatteryChargeCapacity().getText(), prop.getProperty("SettingsGeneralDevicesBatteryChargeCapacity"));
		softAssert.assertEquals(general.getDevicesVSTime().getText(), prop.getProperty("SettingsGeneralDevicesDevicesvsTime"));
		
		// Always Show Unlicensed Devices
//		softAssert.assertEquals(general.getAlwaysShowUnlicensedDevicesToggleEnabled().isDisplayed(),true);
	
		softAssert.assertAll();
}
	
	@Test(priority=2,enabled=true)
	public void settingsGeneralDefaultOptionsModify() throws InterruptedException {
		
		
		action.type(general.getDevicesToShow(), prop.getProperty("SettingsGeneralDeviceToShowRowsUpdated"));
		action.type(general.getdataRetention(), prop.getProperty("SettingsGeneralDataRetentionUpdated"));
		action.type(general.getcheckInterval(), prop.getProperty("SettingsGeneralCheckInIntervalUpdated"));
		action.type(general.getunlicensedAfter(), prop.getProperty("SettingsGeneralUnlicenseAfterDaysUpdated"));
		action.type(general.getshowUnlicensedFor(), prop.getProperty("SettingsGeneralShowUnlicensedForDaysUpdated"));
		action.type(general.getEnergyCost(), prop.getProperty("SettingsGeneralEnergyCostUpdated"));
		action.type(general.getCo2(), prop.getProperty("SettingsGeneralEnergyCO2Updated"));
		action.type(general.getGreenPower(), prop.getProperty("SettingsGeneralGreenEnergyUpdated"));
		
		// Always Show Unlicensed Devices
		action.JSClick(driver, general.getAlwaysShowUnlincedButton());
	
		action.JSClick(driver, general.getSaveButton());
		//Multiple popups coming need to check with the requirement
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("UpdationPopupConfirmation"));
		
		Thread.sleep(7000);
		
		//verfy the updated  value
		softAssert.assertEquals(general.getDevicesToShow().getAttribute("value"), prop.getProperty("SettingsGeneralDeviceToShowRowsUpdated"));
		softAssert.assertEquals(general.getdataRetention().getAttribute("value"), prop.getProperty("SettingsGeneralDataRetentionUpdated"));
		softAssert.assertEquals(general.getcheckInterval().getAttribute("value"), prop.getProperty("SettingsGeneralCheckInIntervalUpdated"));
		softAssert.assertEquals(general.getunlicensedAfter().getAttribute("value"), prop.getProperty("SettingsGeneralUnlicenseAfterDaysUpdated"));
		softAssert.assertEquals(general.getshowUnlicensedFor().getAttribute("value"), prop.getProperty("SettingsGeneralShowUnlicensedForDaysUpdated"));
		
		softAssert.assertEquals(general.getEnergyCost().getAttribute("value"), prop.getProperty("SettingsGeneralEnergyCostUpdated"));
		softAssert.assertEquals(general.getCo2().getAttribute("value"), prop.getProperty("SettingsGeneralEnergyCO2Updated"));
		softAssert.assertEquals(general.getGreenPower().getAttribute("value"), prop.getProperty("SettingsGeneralGreenEnergyUpdated"));
		
		softAssert.assertEquals(general.getPreferedEquilent().getText(), prop.getProperty("SettingsGeneralSmartphonesChargedinaYear"));
		softAssert.assertEquals(general.getPreferedAvoidance().getText(), prop.getProperty("SettingsGeneralTonsofWasteRecycled"));
		softAssert.assertEquals(general.getPreferredSequestration().getText(), prop.getProperty("SettingsGeneralAcresofUSForest"));
		
		// Always Show Unlicensed Devices
//		softAssert.assertEquals(general.getAlwaysShowUnlicensedDevicesToggleDisabled().isDisplayed(),true);
		
	
		softAssert.assertAll();
	}
	
	
	@Test(priority=3,enabled=true)
	public void settingsGeneralModifiedOptionsUpdate() throws InterruptedException {
		
		Thread.sleep(2000);
		
		action.type(general.getDevicesToShow(), prop.getProperty("SettingsGeneralDeviceToShowRows"));
		action.type(general.getdataRetention(), prop.getProperty("SettingsGeneralDataRetention"));
		action.type(general.getcheckInterval(), prop.getProperty("SettingsGeneralCheckInInterval"));
		action.type(general.getunlicensedAfter(), prop.getProperty("SettingsGeneralUnlicenseAfterDays"));
		action.type(general.getshowUnlicensedFor(), prop.getProperty("SettingsGeneralShowUnlicensedForDays"));
		action.type(general.getEnergyCost(), prop.getProperty("SettingsGeneralEnergyCost"));
		action.type(general.getCo2(), prop.getProperty("SettingsGeneralEnergyCO2"));
		action.type(general.getGreenPower(), prop.getProperty("SettingsGeneralGreenEnergy"));
		
		//Preferred Equivalent
		general.getPreferedEquilent().click();
		general.PreferdEquilentDropdownOptionsElements().get(4).click();
		
		//Preferred Avoidance
		general.getPreferedAvoidance().click();
		general.getgetPreferedAvoidanceDropdownElements().get(2).click();
		
		//Preferred Sequestration
		general.getPreferredSequestration().click();
		general.getPreferredSequestrationDropdownElements().get(0).click();
		
		action.JSClick(driver, general.getAlwaysShowUnlincedButton());
		
		action.JSClick(driver, general.getSaveButton());
		//Multiple popups coming need to check with the requirement
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("UpdationPopupConfirmation"));
		
		Thread.sleep(7000);
		
		//verfy the updated  value
		softAssert.assertEquals(general.getDevicesToShow().getAttribute("value"), prop.getProperty("SettingsGeneralDeviceToShowRows"));
		softAssert.assertEquals(general.getdataRetention().getAttribute("value"), prop.getProperty("SettingsGeneralDataRetention"));
		softAssert.assertEquals(general.getcheckInterval().getAttribute("value"), prop.getProperty("SettingsGeneralCheckInInterval"));
		softAssert.assertEquals(general.getunlicensedAfter().getAttribute("value"), prop.getProperty("SettingsGeneralUnlicenseAfterDays"));
		softAssert.assertEquals(general.getshowUnlicensedFor().getAttribute("value"), prop.getProperty("SettingsGeneralShowUnlicensedForDays"));
		
		softAssert.assertEquals(general.getEnergyCost().getAttribute("value"), prop.getProperty("SettingsGeneralEnergyCost"));
		softAssert.assertEquals(general.getCo2().getAttribute("value"), prop.getProperty("SettingsGeneralEnergyCO2"));
		softAssert.assertEquals(general.getGreenPower().getAttribute("value"), prop.getProperty("SettingsGeneralGreenEnergy"));
		
		softAssert.assertEquals(general.getPreferedEquilent().getText(), prop.getProperty("SettingsGeneralBarrelsofOilConsumedinOneYear"));
		softAssert.assertEquals(general.getPreferedAvoidance().getText(), prop.getProperty("SettingsGeneralWindTurbinesRunningforaYear"));
		softAssert.assertEquals(general.getPreferredSequestration().getText(), prop.getProperty("SettingsGeneralTreeSeedlingsGrownfor10Years"));
		

//		softAssert.assertEquals(general.getAlwaysShowUnlicensedDevicesToggleEnabled().isDisplayed(),true);
		
		softAssert.assertAll();
	}
	
	
}
