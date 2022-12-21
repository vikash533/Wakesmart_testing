package com.wakesmart.pageObjects;

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
	By BlankSpacetoClick = By.xpath("//div[@id='addDiv']");
	By AddClauseButton = By.xpath("//button[@id='addStmntBtn']");
	
	By AttributeIFSecondRow = By.xpath("(//select[@id='devAttribSelector2'])[1]");
	By NotCheckBoxSecondRow = By.xpath("(//input[@id='notChk2'])[1]");
	By OperatorDropDownSecondRow = By.xpath("(//select[@id='operatorSelector2'])[1]");
	By ValueSecondRow= By.xpath("(//input[@id='value2'])[1]");
	By ClauseDelete = By.xpath("(//button[@id='delClauseBtn3'])[1]");
	By CreateRuleSaveButton = By.xpath("//button[@id='saveRuleBtn']");
	By RuleNameVerifyText =  By.xpath("(//div[@id='Rule List'])//table/tbody/tr/td[1]");
	By EditRuleButton = By.xpath("//button[@id='editRuleBtn']");
	By SecondRuleOrDropDown = By.xpath("(//select[@id='conSelector2'])[1]");
	By AttributeIFThirdRow = By.xpath("(//select[@id='devAttribSelector3'])[1]");
	By OperatorDropdownThirdRow = By.xpath("(//select[@id='operatorSelector3'])[1]");
	By ValueThrirdRow = By.xpath("(//input[@id='value3'])[1]");
	By RuleVerifyText = By.xpath("(//div[@id='Rule List'])[1]/table/tbody/tr/td[6]");
	
	public boolean  getRuleVerifyText(String str) {
		boolean flag =false;
		for(WebElement ele: driver.findElements(RuleVerifyText)) {
			
			if(ele.getText().equalsIgnoreCase(str)) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	
	public WebElement getAttributeIFThirdRow() {
		return driver.findElement(AttributeIFThirdRow);
	}
	
	public WebElement getOperatorDropdownThirdRow() {
		return driver.findElement(OperatorDropdownThirdRow);
	}
	
	public WebElement getValueThrirdRow() {
		return driver.findElement(ValueThrirdRow);
	}
	
	public WebElement getSecondRuleOrDropDown() {
		return driver.findElement(SecondRuleOrDropDown );
	}

	public WebElement getEditRuleButton() {
		return driver.findElement(EditRuleButton);
	}
	
	public void getRuleNameVerifyText(String str) {
		
		for(WebElement ele: driver.findElements(RuleNameVerifyText)) {
			if(ele.getText().equalsIgnoreCase(str)) {
				ele.click();
				break;
			}	
		}
	}
	
	public WebElement getCreateRuleSaveButton() {
		return driver.findElement(CreateRuleSaveButton);
	}
	public WebElement getClauseDelete() {
		return driver.findElement(ClauseDelete);
	}
	
	public WebElement getAttributeIFSecondRow() {
		return driver.findElement(AttributeIFSecondRow);
	}
	public WebElement getNotCheckBoxSecondRow() {
		return driver.findElement(NotCheckBoxSecondRow);
	}
	public WebElement getOperatorDropDownSecondRow() {
		return driver.findElement(OperatorDropDownSecondRow);
	}
	public WebElement getValueSecondRow() {
		return driver.findElement(ValueSecondRow);
	}
	
	public WebElement getAddClauseButton() {
		return driver.findElement(AddClauseButton);
	}

	public WebElement getBlankSpacetoClick() {
		return driver.findElement(BlankSpacetoClick);
	}
	
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
