package com.wakesmart.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;

public class WSAutomationPage extends BaseClass{
	
	public WSAutomationPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By AutomationTab = By.xpath("//p[normalize-space()='Automation']");
	By AutomationTextInnerTab = By.xpath("//span[normalize-space()='Automation']");
	By AutomationOwnerInfo = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1ilqee0']");
	By GroupRulesTableHeader = By.xpath("(//tr[@class='MuiTableRow-root MuiTableRow-head css-1b8dwk7'])/th");
	By AutomationTableHeader = By.xpath("(//div[@class='MuiTabs-flexContainer css-k008qs'])//button");
	By AddRuleButton = By.xpath("//button[normalize-space()='Add Rule']");
	By AddNewRuleText = By.xpath("(//h2[normalize-space()='Add New Rule'])[1]");
	By GroupRuleName = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1nj3ori'])[1]/input");
	By GroupRuleDescription = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1smm1i5'])[2]");
	By GroupSelectDropdown = By.xpath("(//div[@class='MuiFormControl-root css-1r2ur5m']//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-r72j9k'])[1]");
	By SelectGroupDowndown = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li");
	By AttributeValue = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li");
	By OperatorDropdown = By.xpath("//div[@id='mui-component-select-operator']");
	By OperatorDropdownValue = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9'])//li");
	By OpeartorValue = By.xpath("//input[@name='value']");
	By AddClauseButton = By.xpath("//button[normalize-space()='Add Clause']");
	By AttributeSecond = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8'])[6]/div");
	By OperatorDropdownSecond = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8'])[7]/div");
	By GroupValueSecond = By.xpath("(//input[@name='value'])[2]");
	By AndORDropdown = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-1 css-1doag2i'])[3]/div");
	By AndOrList = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9'])/li");
	By SubmitBtn = By.xpath("//button[normalize-space()='Submit']");
	
			//(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1y0jp63'])[2]
	By AlertConfirmationMessage = By.xpath("(//div[@class='Toastify__toast-body'])/div[2]");
	By OrderDropdown = By.xpath("(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-4xkoi8'])[2]//input");
	By EnabledCheckBox = By.xpath("(//input[@type='checkbox'])[1]");
	By DeleteClauseButton = By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-1 css-tuxzvu'])[2]/div[13]/button");
	
	
	//Policy rules
	By PolicyRules = By.xpath("(//div[@class='MuiTabs-flexContainer css-k008qs'])//button[2]");
	By AlertRules = By.xpath("(//div[@class='MuiTabs-flexContainer css-k008qs'])//button[3]");
	By AlertRulesContent = By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[3]/p");
	
	public String getAlertRulesContent() {
		return driver.findElement(AlertRulesContent).getText();
	}
	
	public WebElement getAlertRules() {
		return driver.findElement(AlertRules);
	}
	
	public WebElement getPolicyRules() {
		return driver.findElement(PolicyRules);
	}
	
	public void getCraetedRuleVerifyAfterEnabled(String OrderNum, SoftAssert asserts, Properties prop) {
		
		String RuleName = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[1]")).getText();
		String RuleDescription = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[2]")).getText();
		String RuleEnabled = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[3]")).getText();
		String RuleOrder = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[4]")).getText();
		String RuleGroup = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[5]")).getText();
		String RuleSummary = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[6]")).getText();
		
		asserts.assertEquals(RuleName, prop.getProperty("GroupRuleName"),"Mismatch in the Group Rule name");
		asserts.assertEquals(RuleDescription, prop.getProperty("GroupRuleDescription"),"Mismatch in the Group Rule name");
		asserts.assertEquals(RuleEnabled, prop.getProperty("GroupRuleEnabledAfterYes"),"Mismatch in the Group Rule enabled");
		asserts.assertEquals(RuleOrder,OrderNum,"Mismatch in the Group Rule order");
		asserts.assertEquals(RuleGroup, prop.getProperty("GroupSelectedForGroupPolicy") ,"Mismatch in the Group Rule group");
		asserts.assertEquals(RuleSummary, prop.getProperty("GroupRuleSummary"),"Mismatch in the Group Rule summary");
		
		//return asserts;
	}
	
	
	
	public WebElement getEnabledCheckBox() {
		return driver.findElement(EnabledCheckBox);
	}
	
	public void getEditGroupRules(String OrderNum) {
		driver.findElement(By.xpath("(//div[@class='MuiBox-root css-0'])["+OrderNum+"]/button[1]")).click();
	}
	
	
	
	public void getCraetedRuleVerify(String OrderNum, SoftAssert asserts, Properties prop) throws InterruptedException {
		Thread.sleep(3000);
		String RuleName = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[1]")).getText();
		String RuleDescription = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[2]")).getText();
		String RuleEnabled = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[3]")).getText();
		String RuleOrder = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[4]")).getText();
		String RuleGroup = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[5]")).getText();
		String RuleSummary = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[1]/table/tbody/tr["+OrderNum+"]/td[6]")).getText();
		
		asserts.assertEquals(RuleName, prop.getProperty("GroupRuleName"),"Mismatch in the Group Rule name");
		asserts.assertEquals(RuleDescription, prop.getProperty("GroupRuleDescription"),"Mismatch in the Group Rule name");
		asserts.assertEquals(RuleEnabled, prop.getProperty("GroupRuleEnabled"),"Mismatch in the Group Rule enabled");
		asserts.assertEquals(RuleOrder,OrderNum,"Mismatch in the Group Rule order");
		asserts.assertEquals(RuleGroup, prop.getProperty("GroupSelectedForGroupPolicy") ,"Mismatch in the Group Rule group");
		asserts.assertEquals(RuleSummary, prop.getProperty("GroupRuleSummary"),"Mismatch in the Group Rule summary");
		
		//return asserts;
	}
	
	
public void getCraetedPolicyRuleVerify(String OrderNum, Properties prop, SoftAssert asserts) {
		
		String RuleName = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[1]")).getText();
		String RuleDescription = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[2]")).getText();
		String RuleEnabled = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[3]")).getText();
		String RuleOrder = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[4]")).getText();
		String RuleGroup = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[5]")).getText();
		String RuleSummary = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[6]")).getText();
		
		asserts.assertEquals(RuleName, prop.getProperty("NewPolicyName"),"Mismatch in the Group Rule name");
		asserts.assertEquals(RuleDescription, prop.getProperty("NewPolicyDescription"),"Mismatch in the Group Rule name");
		asserts.assertEquals(RuleEnabled, prop.getProperty("GroupRuleEnabled"),"Mismatch in the Group Rule enabled");
		asserts.assertEquals(RuleOrder,OrderNum,"Mismatch in the Group Rule order");
		asserts.assertEquals(RuleGroup, prop.getProperty("PolicySelectedForPolicyRules") ,"Mismatch in the Group Rule group");
		asserts.assertEquals(RuleSummary, prop.getProperty("GroupRuleSummary"),"Mismatch in the Group Rule summary");
		
		//return asserts;
	}


public void getCraetedPolicyRuleVerifyAfterMod(String OrderNum, SoftAssert asserts, Properties prop) {
	
	String RuleName = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[1]")).getText();
	String RuleDescription = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[2]")).getText();
	String RuleEnabled = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[3]")).getText();
	String RuleOrder = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[4]")).getText();
	String RuleGroup = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[5]")).getText();
	String RuleSummary = driver.findElement(By.xpath("(//div[@class='MuiTabPanel-root css-19kzrtu'])[2]/table/tbody/tr["+OrderNum+"]/td[6]")).getText();
//	System.out.println("RuleName--->"+RuleName);
//	System.out.println("RuleEnabled--->"+RuleEnabled);
//	System.out.println("RuleOrder--->"+RuleOrder);
//	System.out.println("RuleGroup---->"+RuleGroup);
//	System.out.println("RuleSummary---->"+RuleSummary);
	asserts.assertEquals(RuleName, prop.getProperty("NewPolicyName"),"Mismatch in the Group Rule name");
	asserts.assertEquals(RuleDescription, prop.getProperty("NewPolicyDescription"),"Mismatch in the Group Rule name");
	asserts.assertEquals(RuleEnabled, prop.getProperty("GroupRuleEnabledAfterYes"),"Mismatch in the Group Rule enabled");
	asserts.assertEquals(RuleOrder,OrderNum,"Mismatch in the Group Rule order");
	asserts.assertEquals(RuleGroup, prop.getProperty("PolicySelectedForPolicyRules") ,"Mismatch in the Group Rule group");
	asserts.assertEquals(RuleSummary, prop.getProperty("GroupRuleSummary"),"Mismatch in the Group Rule summary");
	
	//return asserts;
}
	public WebElement getRuleName() {
		return driver.findElement(By.xpath("//th[text()='Rule Name']"));
	}
	
	public String getOrderDropdown() {
		return driver.findElement(OrderDropdown).getAttribute("value");
	}
	
	public WebElement getAlertConfirmationMessage() {
		WebElement ele = null;
		try {
			ele = driver.findElement(AlertConfirmationMessage);
		} catch (Exception e) {
			ele = driver.findElement(AlertConfirmationMessage);
			e.printStackTrace();
		}
		return ele;
	}
	
	public WebElement getSubmitBtn() {
		return driver.findElement(SubmitBtn);
	}
	
	
	
	public void getAndOrList(String AndOr) {
		for (WebElement element : driver.findElements(AndOrList)) {

			if (element.getText().equalsIgnoreCase(AndOr)) {
				element.click();
				break;
			}
		}
	}
	
	
	
	public WebElement getAndORDropdown() {
		return  driver.findElement(AndORDropdown);
	}
	
	
	public WebElement getGroupValueSecond() {
		return  driver.findElement(GroupValueSecond);
	}
	
	public void getOperatorDropdownSecond() {
		 driver.findElement(OperatorDropdownSecond).click();;
	}
	
	
	
	public void getAttributeSecond() {
		 driver.findElement(AttributeSecond).click();;
	}
	
	public WebElement getDeleteClauseButton() {
		return driver.findElement(DeleteClauseButton);
	}
	
	
	
	
	
	
	
	public void getAddClauseButton() {
		new WebDriverWait(driver, Duration.ofSeconds(10));
		 driver.findElement(AddClauseButton).click();;
	}
	
	public WebElement getOpeartorValue() {
		return driver.findElement(OpeartorValue);
	}
	
	public void getOperatorDropdownValue(String OperatorName) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (WebElement element : driver.findElements(OperatorDropdownValue)) {

			if (element.getText().equalsIgnoreCase(OperatorName)) {
				element.click();
				break;
			}
		}
	}
	
	
	public WebElement getOperatorDropdown() {
		return driver.findElement(OperatorDropdown);
	}
	
	
	public void getSelectAttributeDowndown(String AttributrValue) {
	
		try {
			for (WebElement element : driver.findElements(AttributeValue)) {

				if (element.getText().equalsIgnoreCase(AttributrValue)) {
					element.click();
					break;
				}
			}
		} catch (StaleElementReferenceException  e) {
			
			for (WebElement element : driver.findElements(AttributeValue)) {

				if (element.getText().equalsIgnoreCase(AttributrValue)) {
					element.click();
					break;
				}
			}
			
		}
	}
	
	public void KeyBoardAction() {
		int count =1;
		Actions act = new Actions(driver);
		
		while(count<=3) {
			act.sendKeys(Keys.TAB).build().perform();
			count++;
		}
		act.sendKeys(Keys.ENTER).build().perform();;
	}
	
	
	
	
	public void getSelectGroupDowndown(String groupName) {


		for (WebElement element : driver.findElements(SelectGroupDowndown)) {

			
			if (element.getText().equalsIgnoreCase(groupName)) {
				element.click();
				break;
			}
		}
	}
	
	public WebElement getGroupSelectDropdown() {
		return driver.findElement(GroupSelectDropdown);
	}
	
	public WebElement getGroupRuleDescription() {
		return driver.findElement(GroupRuleDescription);
	}
	
	public WebElement getGroupRuleName() {
		return driver.findElement(GroupRuleName);
	}
	
	public WebElement getAddNewRuleText() {
		return driver.findElement(AddNewRuleText);
	}
	
	public WebElement getAddRuleButton() {
		return driver.findElement(AddRuleButton);
	}
	
	
	public WebElement getAutomationTab() {
		return driver.findElement(AutomationTab);
	}
	
	public String getAutomationTextInnerTab() {
		return driver.findElement(AutomationTextInnerTab).getText();
	}
	
	public String getAutomationOwnerInfo() {
		return driver.findElement(AutomationOwnerInfo).getText();
	}
	
	//Automation -table header verify - getting data from UI
		public List<String> getAutomationTableHeader() {
			
			List<String> textVerify = new ArrayList<>();
		
			
			for(WebElement element :driver.findElements(AutomationTableHeader)) {
				textVerify.add(element.getText());
			}
			return textVerify;
		}
		
		
		
		//Automation - table  header verify - getting data from properties file
		public List<String> getgetAutomationTableHeaderDataToVerify(Properties prop) {
			List<String> textVerify = new ArrayList<>(3);
			
			textVerify.add(prop.getProperty("AutomationTableHeaderGroupRules"));
			textVerify.add(prop.getProperty("AutomationTableHeaderPolicyRules"));
			textVerify.add(prop.getProperty("AutomationTableHeaderAlertRules"));

		return textVerify;
		}
	
	
	
	//Automation - group rules header verify - getting data from UI
	public List<String> getGroupsRulesTableHeaderText() {
		
		List<String> textVerify = new ArrayList<>();
	
		for(WebElement element :driver.findElements(GroupRulesTableHeader)) {
			textVerify.add(element.getText());
		}
		return textVerify;
	}
	
	//Automation - group rules header verify - getting data from properties file
	public List<String> getGroupRulesTableHeaderTextVerify(Properties prop) {
		List<String> textVerify = new ArrayList<>(7);
		
		textVerify.add(prop.getProperty("GroupRulesTableDataRuleName"));
		textVerify.add(prop.getProperty("GroupRulesTableDataRuleDesciption"));
		textVerify.add(prop.getProperty("GroupRulesTableDataEnabled"));
		textVerify.add(prop.getProperty("GroupRulesTableDataOrder"));
		textVerify.add(prop.getProperty("GroupRulesTableDataGroup"));
		textVerify.add(prop.getProperty("GroupRulesTableDataRule"));
		textVerify.add(prop.getProperty("GroupRulesTableDataOptions"));

	return textVerify;
	}
	
	
	//Automation - group rules header verify - getting data from properties file
		public List<String> getPolicyRulesTableHeaderTextVerify(Properties prop) {
			List<String> textVerify = new ArrayList<>(7);
			
			textVerify.add(prop.getProperty("GroupRulesTableDataRuleName"));
			textVerify.add(prop.getProperty("GroupRulesTableDataRuleDesciption"));
			textVerify.add(prop.getProperty("GroupRulesTableDataEnabled"));
			textVerify.add(prop.getProperty("GroupRulesTableDataOrder"));
			textVerify.add(prop.getProperty("GroupRulesTableDataPolicy"));
			textVerify.add(prop.getProperty("GroupRulesTableDataRule"));
			textVerify.add(prop.getProperty("GroupRulesTableDataOptions"));

		return textVerify;
		}
	

	
}
