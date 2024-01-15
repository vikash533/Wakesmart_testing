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
import com.wakesmart.pageObjects.WSAutomationPage;


/*
Updated as per the new UI **04**
 										*/
public class WSAutomationPolicyRules extends BaseClass{

	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	public SoftAssert softAssert;
	private WSAutomationPage automation;
	private String orderNum = "";
	
	@BeforeClass
	public void browserLaunch() {
		try {
			driver = launchBrowser();
			driver.get(prop.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(enabled = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	@Test(priority=1)
	public void newAutomationPolicyRules() throws IOException, InterruptedException {
		automation= new WSAutomationPage(driver);
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		
		
		action.click(driver, automation.getAutomationTab());
		softAssert.assertEquals(automation.getAutomationTextInnerTab(), prop.getProperty("AutomationTabInnerText"),"Mismatch in automation Jims LLC");
		softAssert.assertEquals(automation.getAutomationTableHeader(), automation.getgetAutomationTableHeaderDataToVerify(prop)," Mismatch automation table header text");
		
		action.JSClick(driver, automation.getPolicyRules());
		
		softAssert.assertEquals(automation.getGroupsRulesTableHeaderText(), automation.getPolicyRulesTableHeaderTextVerify(prop)," Mismatch automation policy rules table header text");
		
		Thread.sleep(1000);
		action.click(driver, automation.getAddRuleButton());
		softAssert.assertEquals(automation.getAddNewRuleText().getText(), prop.getProperty("GroupAddNewpolicyText"));
		
		orderNum = automation.getOrderDropdown();
		
		System.out.println("Order Number "+ orderNum );
		action.type(automation.getGroupRuleName(), prop.getProperty("NewPolicyName"));
		action.type(automation.getGroupRuleDescription(), prop.getProperty("NewPolicyDescription"));
		action.click(driver, automation.getGroupSelectDropdown());
		automation.getSelectGroupDowndown(prop.getProperty("PolicySelectedForPolicyRules"));
		
		automation.KeyBoardAction();
		automation.getSelectAttributeDowndown(prop.getProperty("AttributeSelectedForGroupPolicy"));
		automation.getOperatorDropdown().click();
		
		automation.getOperatorDropdownValue(prop.getProperty("OperatorSelectedForGroupPolicy"));
		
		action.type(automation.getOpeartorValue(), prop.getProperty("UserNameForGroupRules"));
		automation.getAddClauseButton();
		
		automation.getAttributeSecond();
		automation.getSelectAttributeDowndown(prop.getProperty("AttributeSelectedForGroupPolicySecond"));
		automation.getOperatorDropdownSecond();
		automation.getOperatorDropdownValue(prop.getProperty("OperatorSelectedForGroupPolicy"));
		
		action.type(automation.getGroupValueSecond(), prop.getProperty("ManufacturerValueSecond"));
		
		action.click(driver, automation.getAndORDropdown());
		automation.getAndOrList(prop.getProperty("GroupNewRuleAndOr"));
		automation.getAddClauseButton();
		automation.getDeleteClauseButton().click();
		
		action.JSClick(driver, automation.getSubmitBtn());
		
		action.fluentWait(driver, automation.getAlertConfirmationMessage());
		softAssert.assertEquals(automation.getAlertConfirmationMessage().getText(), prop.getProperty("CreatedMessageOnPopUp"));
		action.click(driver, indexpage.getPopupCloseIcon());
		automation.getCraetedPolicyRuleVerify(orderNum,  prop, softAssert);
		// pending
		automation.getEditGroupRules(orderNum);
		action.click(driver, automation.getEnabledCheckBox());
		action.JSClick(driver, automation.getSubmitBtn());
		Thread.sleep(3000);
		action.fluentWait(driver, automation.getAlertConfirmationMessage());
		softAssert.assertEquals(automation.getAlertConfirmationMessage().getText(), prop.getProperty("UpdationPopupConfirmation"));
		action.click(driver, indexpage.getPopupCloseIcon());
		
		automation.getCraetedPolicyRuleVerifyAfterMod(orderNum, softAssert, prop);
		
		softAssert.assertAll();
	}
}
