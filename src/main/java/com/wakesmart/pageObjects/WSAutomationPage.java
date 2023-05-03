package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;

public class WSAutomationPage extends BaseClass{
	
	public WSAutomationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By AutomationTab = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiList-subheader css-19o40po'])/a[2]");
	By AutomationTextInnerTab = By.xpath("//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-en0w5h']");
	By AutomationOwnerInfo = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1ilqee0']");
	By GroupRulesTableHeader = By.xpath("(//tr[@class='MuiTableRow-root MuiTableRow-head css-1b8dwk7'])/th");
	By AutomationTableHeader = By.xpath("(//div[@class='MuiTabs-flexContainer css-k008qs'])//button");
	By AddRuleButton = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1knyjq4']");
	By AddNewRuleText = By.xpath("(//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm css-1pwda69'])//h2");
	By GroupRuleName = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1nj3ori'])[1]/input");
	By GroupRuleDescription = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1h6yp7j'])[2]");
	By GroupSelectDropdown = By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-i9cdv9'])[1]");
	By SelectGroupDowndown = By.xpath("//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1e9knfh']");
	By AttributeValue = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li");
	By OperatorDropdown = By.xpath("//div[@id='mui-component-select-operator']");
	By OperatorDropdownValue = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9'])//li");
	By OpeartorValue = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1h6yp7j'])[3]");
	By AddClauseButton = By.xpath("//button[normalize-space()='Add Clause']");
	By AttributeSecond = By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-i9cdv9'])[6]");
	By OperatorDropdownSecond = By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-i9cdv9'])[7]");
	By GroupValueSecond = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1h6yp7j'])[4]");
	By AndORDropdown = By.xpath("(//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-i9cdv9'])[5]");
	By AndOrList = By.xpath("(//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9'])/li");
	By SubmitBtn = By.xpath("(//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc'])//button[3]");
	
			//(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1y0jp63'])[2]
	By AlertConfirmationMessage = By.xpath("(//div[@class='Toastify__toast-body'])/div[2]");
	By OrderDropdown = By.xpath("(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl  css-1fzlj8j'])[2]//input");
	By EnabledCheckBox = By.xpath("(//input[@type='checkbox'])[1]");
	
	
	
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
	
	
	
	public void getCraetedRuleVerify(String OrderNum, SoftAssert asserts, Properties prop) {
		
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
	
	
public void getCraetedPolicyRuleVerify(String OrderNum, SoftAssert asserts, Properties prop) {
		
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
	
	asserts.assertEquals(RuleName, prop.getProperty("NewPolicyName"),"Mismatch in the Group Rule name");
	asserts.assertEquals(RuleDescription, prop.getProperty("NewPolicyDescription"),"Mismatch in the Group Rule name");
	asserts.assertEquals(RuleEnabled, prop.getProperty("GroupRuleEnabledAfterYes"),"Mismatch in the Group Rule enabled");
	asserts.assertEquals(RuleOrder,OrderNum,"Mismatch in the Group Rule order");
	asserts.assertEquals(RuleGroup, prop.getProperty("PolicySelectedForPolicyRules") ,"Mismatch in the Group Rule group");
	asserts.assertEquals(RuleSummary, prop.getProperty("GroupRuleSummary"),"Mismatch in the Group Rule summary");
	
	//return asserts;
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
	
	
	
	
	
	
	
	
	
	public void getAddClauseButton() {
		 driver.findElement(AddClauseButton).click();;
	}
	
	public WebElement getOpeartorValue() {
		return driver.findElement(OpeartorValue);
	}
	
	
	public void getOperatorDropdownValue(String OperatorName) {


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
