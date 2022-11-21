package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class IndexPage extends BaseClass {

	By UserName = By.xpath("//input[@id='username']");
	By PassWord = By.xpath("//input[@id='userPwd']");
	By Login = By.xpath("//button[@id='okButton']");
	By LoginForm = By.xpath("//form[@id='loginForm']");
	By ErrorMsg = By.xpath("//h2[@id='errorMsg']");
	By passwordVisibiltyOnDom = By.xpath("//input[@id='userPwd']");
	By LoginFormColor = By.xpath("//div[@class='logon-center']//div");
	By LoginDialougeTitle = By.xpath("//h2[@id='loginDlgTitle']");

	// Constructor
	public IndexPage(WebDriver driver) {
		this.driver = driver;
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
	
	public WebElement getLoginForm() {
		return driver.findElement(LoginForm);
	}
	
	public WebElement getErrorMsg() {
		return driver.findElement(ErrorMsg);
	}
	public WebElement getpasswordVisibiltyOnDom() {
		return driver.findElement(passwordVisibiltyOnDom);
	}
	
	public WebElement getLoginFormColor() {
		return driver.findElement(LoginFormColor);
	}
	
	

	
	
	
	

}