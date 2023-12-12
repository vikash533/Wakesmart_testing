package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;

/*
Completely used and Updated for new UI 
 										*/

public class IndexPage extends BaseClass {
	
	private WSOrganization organization;
	Action action = new Action();
	SoftAssert softAssert;
	private Properties prop;
	
	
	// Constructor
		public IndexPage(WebDriver driver) {
			this.driver = driver;
			organization = new WSOrganization(this.driver);
		}

	By UserName = By.xpath("//input[@id=':r0:']");
	By PassWord = By.xpath("//input[@type='password']");
	By Login = By.xpath("//button[@type='submit']");
	By ErrorMsg = By.xpath("//div[@class='Toastify__toast-body']/div[2]");
	By PasswordWarningMessege = By.xpath("//p[@id=':r1:-helper-text']");
	By passwordVisibiltyOnDom = By.xpath("//input[@id='userPwd']");
	By LoginFormColor = By.xpath("//div[@class='MuiBox-root css-1arlb8v']");
	By LoginDialougeTitle = By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 MuiTypography-gutterBottom css-14zc97g']");
	By ForgotPassword = By.xpath("//label[@id='forgotline']");
	By EmailIDForReset = By.xpath("//input[@id='olduserPwd']");
	By PopupCloseIcon = By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']");
	By OrganizationManagementHeaderText = By.xpath("//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-en0w5h']");
	By OrganizationTableHeader = By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-lmldiz']/p");

	
	
	
	public WebElement getOrganizationManagementHeaderText() {
		return driver.findElement(OrganizationManagementHeaderText);
	}
	
	public WebElement getOrganizationTableHeader() {
		return driver.findElement(OrganizationTableHeader);
	}
	
	public WebElement getPopupCloseIcon() {
		return driver.findElement(PopupCloseIcon);
	}

	public WebElement getPasswordWarningMessege() {
		return driver.findElement(PasswordWarningMessege);
	}

	public WebElement getEmailIDForReset() {
		return driver.findElement(EmailIDForReset);
	}

	public WebElement getForgotPassword() {
		return driver.findElement(ForgotPassword);
	}

	public WebElement getLoginDialougeTitle() {
		return driver.findElement(LoginDialougeTitle);
	}

	public WebElement getUserName() {
		return driver.findElement(UserName);
	}

	public WebElement getPassWord() {
		return driver.findElement(PassWord);
	}

	public WebElement getLogin() {
		return driver.findElement(Login);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public WebElement getErrorMsg() {
		return driver.findElement(ErrorMsg);
	}

	public WebElement getpasswordVisibiltyOnDom() {
		return driver.findElement(PassWord);
	}

	public WebElement getLoginFormColor() {
		return driver.findElement(LoginFormColor);
	}
	
	public void validUserLogin(String username,String password , String welcomeMessage, Properties prop) {
		 softAssert = new SoftAssert();
		 this.prop = prop;
		getUserName().sendKeys(username);
		getPassWord().sendKeys(password);
		getLogin().click();
//		action.fluentWait(driver, getErrorMsg());
		
//		softAssert.assertEquals(getErrorMsg().getText(),  welcomeMessage);
//		action.click(driver, getPopupCloseIcon());
		
		//enable this 4 lines if new Dashboard is added 
//		softAssert.assertEquals(getOrganizationManagementHeaderText().getText(),  prop.getProperty("ManagementOrganizationsPageHeaderText"));
//		softAssert.assertEquals(getOrganizationTableHeader().getText(), prop.getProperty("OrganizationName"));
//		softAssert.assertEquals(organization.tableTextVerify(),organization.tableTextVerifyFromLocal(prop));
//		selectOrganization(prop.getProperty("AutomationtabOwnerText"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		softAssert.assertAll();
	}
	
	By OrganizationName = By.xpath("//tr[@class='MuiTableRow-root css-1b8dwk7']/td[1]");
	By popUpConfirmation = By.xpath("//div[@class='MuiBox-root css-1sdcacc']/p");
	By manageOrganizationYesButton = By.xpath("//div[@class='MuiDialogActions-root MuiDialogActions-spacing css-14b29qc']/button[2]");
	
	public WebElement OptionsToSelect(int index) {
		return driver.findElement(By.xpath("(//tr[@class='MuiTableRow-root css-1b8dwk7'])["+index+"]/td[7]/div/button[1]"));
	}
	
	 public void selectOrganization(String organizationName) {
		 int count = 1 ;
		 boolean flag = false;
		 List<WebElement> elements = driver.findElements(OrganizationName);
		 
		 for(WebElement ele : elements) {
			 if(organizationName.equalsIgnoreCase(ele.getText())) {
				 OptionsToSelect(count).click();
				 flag = true;
				 break;
			 }
			 count++;
		 }
		 
		 Assert.assertTrue(flag,"No Organization found with the given Name");
		 
		 softAssert.assertEquals(driver.findElement(popUpConfirmation).getText(), prop.getProperty("ManagementOrganizationPopUpConfirmationText"));
		 driver.findElement(manageOrganizationYesButton).click();
	 }
}