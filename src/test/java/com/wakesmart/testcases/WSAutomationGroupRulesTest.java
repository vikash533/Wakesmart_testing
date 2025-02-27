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
Updated as per the new UI **03**
 										*/
public class WSAutomationGroupRulesTest extends BaseClass {
	
	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
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
			driver.quit();
	}
	
	
	@Test(priority=1)
	public void newAutomationGroupRules() throws IOException, InterruptedException {
		automation= new WSAutomationPage(driver);
		indexpage = new IndexPage(driver);
		action= new Action();
		softAssert = new SoftAssert();

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
		Thread.sleep(4000);
		action.JSClick(driver, automation.getAutomationTab());
		softAssert.assertEquals(automation.getAutomationTextInnerTab(), prop.getProperty("AutomationTabInnerText"),"Mismatch in automation Jims Inc");
		softAssert.assertEquals(automation.getAutomationTableHeader(), automation.getgetAutomationTableHeaderDataToVerify(prop)," Mismatch automation table header text");
		action.fluentWait(driver,automation.getRuleName());
		softAssert.assertEquals(automation.getGroupsRulesTableHeaderText(), automation.getGroupRulesTableHeaderTextVerify(prop)," Mismatch automation group rules table header text");

//		String groupRuleName = prop.getProperty("GroupRuleName");
//		System.out.println(groupRuleName);
//
////		boolean dataExists = automation.checkIfDataExistsInTable(groupRuleName);
//		System.out.println(dataExists);
//		if(!dataExists) {
			Thread.sleep(1000);
			action.JSClick(driver, automation.getAddRuleButton());

			action.fluentWait(driver, automation.getAddNewRuleText());
			softAssert.assertEquals(automation.getAddNewRuleText().getText(), prop.getProperty("GroupAddNewpolicyText"), "Mismatch GroupAddNewPolicy Text");

			orderNum = automation.getOrderDropdown();
			System.out.println(orderNum);
			action.type(automation.getGroupRuleName(), prop.getProperty("GroupRuleName"));

			action.type(automation.getGroupRuleDescription(), prop.getProperty("GroupRuleDescription"));
			action.click(driver, automation.getGroupSelectDropdown());

			automation.getSelectGroupDowndown(prop.getProperty("GroupSelectedForGroupPolicy"));
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

			action.JSClick(driver, automation.getSubmitBtn());

			action.fluentWait(driver, automation.getAlertConfirmationMessage());
			softAssert.assertEquals(automation.getAlertConfirmationMessage().getText(), prop.getProperty("CreatedMessageOnPopUp"), "Mismatch of CreatedMessageOnPopUp");
			action.click(driver, indexpage.getPopupCloseIcon());

			automation.getCraetedRuleVerify(orderNum, softAssert, prop);

			automation.getEditGroupRules(orderNum);
			action.click(driver, automation.getEnabledCheckBox());
			action.JSClick(driver, automation.getSubmitBtn());
//		Thread.sleep(3000);
			action.fluentWait(driver, automation.getAlertConfirmationMessage());
			softAssert.assertEquals(automation.getAlertConfirmationMessage().getText(), prop.getProperty("UpdationPopupConfirmation"));
			action.click(driver, indexpage.getPopupCloseIcon());
//			action.explicitWaitForInvisibility(driver,automation.getAlertConfirmationMessage(),10);
		Thread.sleep(4000);
			automation.getCraetedRuleVerifyAfterEnabled(orderNum, softAssert, prop);
//		}else {
//			System.out.println("Data already exists in the table.");
//		}
		softAssert.assertAll();
	}
}
