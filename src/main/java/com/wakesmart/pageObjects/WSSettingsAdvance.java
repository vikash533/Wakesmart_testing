package com.wakesmart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSSettingsAdvance {
	
public WebDriver driver;
	
	public WSSettingsAdvance(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath="(//a[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters css-m92ebk'])[4]")
	public WebElement getAdvance;
	
	@FindBy(xpath="//div[@class='MuiCardHeader-root css-1dj5oyi']//span")
	public WebElement getAdvanceSetting;
	
	@FindBy(xpath="//div/p[@class='MuiTypography-root MuiTypography-body1 css-hrpkyi']")
	public WebElement getSystemOption;
	
//	Intelligent Update(iUpdate)
	@FindBy(xpath="//h5[normalize-space()='Intelligent Update(iUpdate)']")
	public WebElement getIntelligentUpdate;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='aiData']")
	public WebElement getEnableiUpdate;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='priorityWake']")
	public WebElement getEnablePriorityWake;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='aiAudit']")
	public WebElement getUpdateDevice;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='whenIdle']")
	public WebElement getOnlyUpdateIfUserIsIdle;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='whenCharge']")
	public WebElement getUpdateWhenCharging;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='useOff']")
	public WebElement getUpdateWhenOff;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='idleLength']")
	public WebElement getIdlenessLength;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='aiLength']")
	public WebElement getiUpdateHistoryUsed;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='chargeMin']")
	public WebElement getMinimumChargeLevelPer;
	@FindBy(xpath="(//div[@class='MuiCardContent-root css-fekdlw'])[1]//input[@name='preOff']")
	public WebElement getOffBufferRequired;
	
	//Demand Reduction
	@FindBy(xpath="//h5[normalize-space()='Demand Reduction']")
	public WebElement getDemandReduction;
	@FindBy(xpath="(//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[2]/div/span")
	public WebElement getEnableDemandReduction;
	@FindBy(xpath="(//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[2]/div[2]//input")
	public WebElement getDisplayDimmingAmountPer;
	@FindBy(xpath="(//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[2]/div[3]//input")
	public WebElement getMinimumInactivityTimeoutMin;
	
		
//	Raptor Appliance Connections
	@FindBy(xpath="//h5[normalize-space()='Raptor Appliance Connections']")
	public WebElement getRaptorApplianceConnections;
	
	@FindBy(xpath="(//div[@class='MuiGrid-root MuiGrid-container css-1d3bbye'])[3]/div/span")
	public WebElement getRaptorApplianceConnectionsToggleButton;
	
	
}
