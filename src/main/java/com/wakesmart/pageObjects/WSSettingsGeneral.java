package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSSettingsGeneral {
	public WebDriver driver;

	public WSSettingsGeneral(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//ul[@class='MuiList-root MuiList-padding MuiList-subheader css-p64g7a-MuiList-root'])[2]/a[1]")
	public WebElement getGeneral;

	@FindBy(xpath = "//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content']/span")
	public WebElement getGeneralSettingsText;

	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-1rf1nql-MuiGrid-root']/p")
	public WebElement getSystemOptionsText;

	@FindBy(xpath = "(//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content'])[2]")
	public WebElement getGeneralSettingsBoxText;

	@FindBy(xpath = "(//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content'])[3]")
	public WebElement getEnergyValuesText;

	@FindBy(xpath = "(//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content'])[4]")
	public WebElement getGreenhouseGasComparisonsText;

	@FindBy(xpath = "(//div[@class='MuiCardHeader-content css-1qbkelo-MuiCardHeader-content'])[5]")
	public WebElement getDashboardPanelSelectionText;

	By devicesToShow = By.xpath("//input[@name='showRows']");
	By dataRetention = By.xpath("//input[@name='dataRetention']");
	By checkInterval = By.xpath("//input[@name='checkinInterval']");
	By unlicensedAfter = By.xpath("//input[@name='unlicensedAfter']");
	By showUnlicensedFor = By.xpath("//input[@name='showUnlicensedFor']");
	By SaveButton = By.xpath("//button[normalize-space()='Save']");

	By energyCost = By.xpath("//input[@name='energyCost']");
	By co2 = By.xpath("//input[@name='co2Cost']");
	By greenPower = By.xpath("//input[@name='greenPowerPercent']");

	public WebElement getEnergyCost() {
		return driver.findElement(energyCost);
	}

	public WebElement getCo2() {
		return driver.findElement(co2);
	}

	public WebElement getGreenPower() {
		return driver.findElement(greenPower);
	}

	public WebElement getDevicesToShow() {
		return driver.findElement(devicesToShow);
	}

	public WebElement getdataRetention() {
		return driver.findElement(dataRetention);
	}

	public WebElement getcheckInterval() {
		return driver.findElement(checkInterval);
	}

	public WebElement getunlicensedAfter() {
		return driver.findElement(unlicensedAfter);
	}

	public WebElement getshowUnlicensedFor() {
		return driver.findElement(showUnlicensedFor);
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(SaveButton);
	}

	// Green house gas comparisons
	By PreferedEquilent = By.xpath("//div[@id='mui-component-select-equivalentId']");
	By PreferdEquilentDropdownOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-6hp17o-MuiList-root-MuiMenu-list']//li");
	By PreferedAvoidance = By.xpath("//div[@id='mui-component-select-avoidanceId']");
	By PreferedAvoidanceDropdownOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-6hp17o-MuiList-root-MuiMenu-list']//li");
	By PreferredSequestration = By.xpath("//div[@id='mui-component-select-sequesteredId']");
	By PreferredSequestrationDropdownOptions = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-6hp17o-MuiList-root-MuiMenu-list']//li");

	public WebElement getPreferedEquilent() {
		return driver.findElement(PreferedEquilent);
	}

	public List<WebElement> PreferdEquilentDropdownOptionsElements() {
		List<WebElement> listOptions = driver.findElements(PreferdEquilentDropdownOptions);
		return listOptions;
	}
	
	public List<String> PreferdEquilentDropdownOptions() {

		
		List<String> list = new ArrayList<>();

		for (WebElement ele : PreferdEquilentDropdownOptionsElements()) {
			list.add(ele.getText());
		}

		return list;
	}

	public List<String> getPreferdEquilentDropdownOptionsVerify(Properties prop) {
		List<String> list = new ArrayList<>();

		list.add(prop.getProperty("SettingsGeneralSmartphonesChargedinaYear"));
		list.add(prop.getProperty("SettingsGeneralPassengerCarMilesDriveninaYear"));
		list.add(prop.getProperty("SettingsGeneralGallonsofGasolineUsedinaYear"));
		list.add(prop.getProperty("SettingsGeneralHouseholdElectricityForOneYear"));
		list.add(prop.getProperty("SettingsGeneralBarrelsofOilConsumedinOneYear"));
		list.add(prop.getProperty("SettingsGeneralPoundsofCoalBurnedinOneYear"));

		return list;
	}
	
	
	
	
	//Preferred Avoidance
	public List<WebElement> getgetPreferedAvoidanceDropdownElements() {
		List<WebElement> listOptions = driver.findElements(PreferedAvoidanceDropdownOptions);
		return listOptions;
	}
	
	

	public List<String> getPreferedAvoidanceDropdownOptions() {

		List<String> list = new ArrayList<>();

		for (WebElement ele : getgetPreferedAvoidanceDropdownElements()) {
			list.add(ele.getText());
		}

		return list;
	}

	public List<String> getPreferedAvoidanceDropdownOptionsVerify(Properties prop) {
		List<String> list = new ArrayList<>();

		list.add(prop.getProperty("SettingsGeneralTonsofWasteRecycled"));
		list.add(prop.getProperty("SettingsGeneralBagsofTrashRecycled"));
		list.add(prop.getProperty("SettingsGeneralWindTurbinesRunningforaYear"));
		list.add(prop.getProperty("SettingsGeneralOldBulbsReplacedwithLED"));

		return list;
	}

	
	
	//Preferred Sequestration
	public List<WebElement> getPreferredSequestrationDropdownElements() {
		List<WebElement> listOptions = driver.findElements(PreferredSequestrationDropdownOptions);
		return listOptions;
	}
	
	
	public List<String> getPreferredSequestrationDropdownOptions() {

		List<String> list = new ArrayList<>();

		for (WebElement ele : getPreferredSequestrationDropdownElements()) {
			list.add(ele.getText());
		}

		return list;
	}

	public List<String> getPreferredSequestrationDropdownOptionsVerify(Properties prop) {
		List<String> list = new ArrayList<>();

		list.add(prop.getProperty("SettingsGeneralTreeSeedlingsGrownfor10Years"));
		list.add(prop.getProperty("SettingsGeneralAcresofUSForest"));

		return list;
	}
	
	public WebElement getPreferedAvoidance() {
		return driver.findElement(PreferedAvoidance);
	}

	public WebElement getPreferredSequestration() {
		return driver.findElement(PreferredSequestration);
	}
	
	// Dashboard panel selection
	
	By DeviceDeatilsTables = By.xpath("//div[@id='mui-component-select-devicedetails']");
	By DeviceUsage = By.xpath("//div[@id='mui-component-select-devusage']");
	By DevicesByOSandTypes = By.xpath("//div[@id='mui-component-select-devicetypes']");
	By PowerStateActvity = By.xpath("//div[@id='mui-component-select-psactivity']");
	By BatteryChargeCapacity = By.xpath("//div[@id='mui-component-select-batterycap']");
	By DevicesVSTime = By.xpath("//div[@id='mui-component-select-devicesVtime']");
	
	
	
	public WebElement getDeviceDeatilsTables() {
		return driver.findElement(DeviceDeatilsTables);
	}
	
	public WebElement getDeviceUsage() {
		return driver.findElement(DeviceUsage);
	}
	
	public WebElement getDevicesByOSandTypes() {
		return driver.findElement(DevicesByOSandTypes);
	}
	
	public WebElement getPowerStateActvity() {
		return driver.findElement(PowerStateActvity);
	}
	
	public WebElement getBatteryChargeCapacity() {
		return driver.findElement(BatteryChargeCapacity);
	}
	
	public WebElement getDevicesVSTime() {
		return driver.findElement(DevicesVSTime);
	}
	
	
	// Always Show Unlicensed Devices
	
	By AlwaysShowUnlicensedDevicesToggleDisabled = By.xpath("//span[@class='MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorSuccess PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorSuccess css-2ylotk-MuiButtonBase-root-MuiSwitch-switchBase']");
	By AlwaysShowUnlicensedDevicesToggleEnabled = By.xpath("//span[@class='MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorSuccess Mui-checked PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorSuccess Mui-checked Mui-checked css-2ylotk-MuiButtonBase-root-MuiSwitch-switchBase']");
	
	public WebElement getAlwaysShowUnlicensedDevicesToggleDisabled() {
		return  driver.findElement(AlwaysShowUnlicensedDevicesToggleDisabled);
	}
	
	
	public WebElement getAlwaysShowUnlicensedDevicesToggleEnabled() {
		return  driver.findElement(AlwaysShowUnlicensedDevicesToggleEnabled);
	}
	
	By AlwaysShowUnlincedButton = By.xpath("//span[@class='MuiSwitch-thumb css-jsexje-MuiSwitch-thumb']");
	
	public WebElement getAlwaysShowUnlincedButton() {
		return driver.findElement(AlwaysShowUnlincedButton);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
