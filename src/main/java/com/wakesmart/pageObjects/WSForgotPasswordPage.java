package com.wakesmart.pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;

public class WSForgotPasswordPage extends BaseClass {
	public WebDriver driver;
	public WSForgotPasswordPage forgotpasswordpage;
	Action action = new Action();
	SoftAssert softAssert;
		
	// Constructor
	public WSForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
	}

	By ForgotPassword1 = By.xpath("//a[text()='Forgot Password?']");
	By WakeSMARTAdministrationLoginText = By.xpath("//h2[normalize-space()='WakeSMART Administration Login']");
	By PleaseprovideyouremailaddressText= By.xpath("//h6[normalize-space()='Please provide your email address']");
	By ForgotPasswordUsernameTextfield = By.xpath("//input[@id=':r0:']");
	By ForgotPasswordEmailTextfield = By.xpath("//input[@name='email']");
	By sbubmitButton = By.xpath("//button[normalize-space()='Submit']");
	By ErrorMsgUsername = By.xpath("//p[.='Username is required']");
	By ErrorMsgEmail = By.xpath("//p[.='Email is required']");
	By ErrorMsgInvalidEmail = By.xpath("//p[.='Must be a valid email']");
	public String getCurrentTitle(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public WebElement getForgotPassword1() {
		return driver.findElement(ForgotPassword1);
	}
	
	public WebElement getWakeSMARTAdministrationLoginText() {
		return driver.findElement(WakeSMARTAdministrationLoginText);
	}
	public WebElement getPleaseprovideyouremailaddressText() {
		return driver.findElement(PleaseprovideyouremailaddressText);
	}
	public WebElement getsbubmitButton() {
		return driver.findElement(sbubmitButton);
	}
	public WebElement getErrorMsgUsername() {
		return driver.findElement(ErrorMsgUsername);
	}
	public WebElement getErrorMsgEmail() {
		return driver.findElement(ErrorMsgEmail);
	}
	public WebElement getForgotPasswordUsernameTextfield() {
		return driver.findElement(ForgotPasswordUsernameTextfield);
	}
	public WebElement getForgotPasswordEmailTextfield() {
		return driver.findElement(ForgotPasswordEmailTextfield);
	}
	//ErrorMsgInvalidEmail
	public WebElement getErrorMsgInvalidEmail() {
		return driver.findElement(ErrorMsgInvalidEmail);
	}
}
