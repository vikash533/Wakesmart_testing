package com.wakesmart.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class Automation extends BaseClass {
	
	
	public Automation(WebDriver driver) {
		this.driver=driver;
	}
	
	By AutomateIcon = By.xpath("//input[@id='automate']");
	By AutomationHeaderText = By.xpath("//div[@class='screentitle']");
	By GroupRulesVerifyText = By.xpath("//label[@id='tabbed1Lbl']");
	By PolicyRulesVerifyText = By.xpath("//label[@id='tabbed2Lbl']");
	By AlertRulesVerifyText = By.xpath("//label[@id='tabbed3Lbl']");
	By NewRuleButton = By.xpath("//button[@id='newRuleBtn']");
	By CreateRuleHeaderText = By.xpath("//label[@id='ruleDialogLabel']");
	By EnabledCheckBox = By.xpath("//input[@id='enableInput']");
	By OrderDropdown =  By.xpath("//select[@id='devgOrderSelector']");
	By RuleName = By.xpath("//input[@id='ruleNameInput']");
	By RuleDescription = By.xpath("//input[@id='ruleDescInput']");
	By Group = By.xpath("//select[@id='devGroupSelector1']");
	By AttributeIF = By.xpath("//select[@id='devAttribSelector1']");
	By NotCheckBox = By.xpath("//input[@id='notChk1']");
	By OperatorDropDown = By.xpath("//select[@id='operatorSelector1']");
	By Value = By.xpath("//input[@id='value1']");
	
	public WebElement getValue() {
		return driver.findElement(Value);
	}
	
	
	public WebElement getOperatorDropDown() {
		return driver.findElement(OperatorDropDown);
	}
	
	
	public WebElement getNotCheckBox() {
		return driver.findElement(NotCheckBox);
	}
	
	public WebElement getAttributeIF() {
		return driver.findElement(AttributeIF);
	}

	public WebElement getGroup() {
		return driver.findElement(Group);
	}
	
	public WebElement getRuleDescription() {
		return driver.findElement(RuleDescription);
	}

	public WebElement getRuleName() {
		return driver.findElement(RuleName);
	}
	
	public WebElement getOrderDropdown() {
		return driver.findElement(OrderDropdown);
	}
	public WebElement getEnabledCheckBox() {
		return driver.findElement(EnabledCheckBox);
	}
	
	public String getCreateRuleHeaderText() {
		return driver.findElement(CreateRuleHeaderText).getText();
	}
	
	public WebElement getNewRuleButton() {
		return driver.findElement(NewRuleButton);
	}
	
	public WebElement getAutomateIcon() {
		return driver.findElement(AutomateIcon);
	}
	
	public String getAutomationHeaderText() {
		return driver.findElement(AutomationHeaderText).getText();
	}
	
	public String getGroupRulesVerifyText() {
		return driver.findElement(GroupRulesVerifyText).getText();
	}
	
	public String getPolicyRulesVerifyText() {
		return driver.findElement(PolicyRulesVerifyText).getText();
	}
	
	public String getAlertRulesVerifyText() {
		return driver.findElement(AlertRulesVerifyText).getText();
	}

}
