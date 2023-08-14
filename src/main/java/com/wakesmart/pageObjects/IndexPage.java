package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;

/*
Completely used and Updated for new UI 
 										*/

public class IndexPage extends BaseClass {
	
	Action action = new Action();

	// Constructor
	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	By UserName = By.xpath("//input[@id=':r0:']");
	By PassWord = By.xpath("//input[@type='password']");
	By Login = By.xpath("//button[@type='submit']");
	By ErrorMsg = By.xpath("//div[@class='Toastify__toast-body']/div[2]");
	By PasswordWarningMessege = By.xpath("//p[@id=':r1:-helper-text']");
	By passwordVisibiltyOnDom = By.xpath("//input[@id='userPwd']");
	By LoginFormColor = By.xpath("//div[@class='MuiBox-root css-1arlb8v']");
	By LoginDialougeTitle = By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2 MuiTypography-gutterBottom css-ei33y-MuiTypography-root']");
	By ForgotPassword = By.xpath("//label[@id='forgotline']");
	By EmailIDForReset = By.xpath("//input[@id='olduserPwd']");
	By PopupCloseIcon = By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']");

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
	
	
	
	public void validUserLogin(String username,String password , String welcomeMessage) {
		SoftAssert softAssert = new SoftAssert();
		getUserName().sendKeys(username);
		getPassWord().sendKeys(password);
		getLogin().click();
		action.fluentWait(driver, getErrorMsg());
		
		softAssert.assertEquals(getErrorMsg().getText(),  welcomeMessage);
		softAssert.assertAll();
		action.click(driver, getPopupCloseIcon());
	}
	
	
	
	


}