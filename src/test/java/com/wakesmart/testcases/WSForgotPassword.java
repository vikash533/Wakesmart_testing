package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSForgotPasswordPage;
import com.wakesmart.pageObjects.WSHomePage;
import com.wakesmart.base.BaseClass;
public class WSForgotPassword extends BaseClass {
	
	

	public WebDriver driver;
	public Action action  = new Action();
	public IndexPage indexpage;
	public WSHomePage homepage;
	public SoftAssert softAssert;
	public WSForgotPasswordPage forgotpasswordpage;

	@BeforeClass
	public void browserLaunch()  {
		try {
			driver = launchBrowser();
			driver.get(prop.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		indexpage = new IndexPage(driver);
		forgotpasswordpage = new WSForgotPasswordPage(driver);
        
	}

	@AfterClass(enabled=true)
	public void tearDown() {
		if (driver != null) {
		driver.quit();
		}
	}
	@Test(priority=1,enabled=true)
	public void forgotFunctionality() {
		softAssert = new SoftAssert();
		System.out.println(forgotpasswordpage.getForgotPassword1().getText());
		softAssert.assertEquals(forgotpasswordpage.getForgotPassword1().getText(),  prop.getProperty("ForgotPasswordText"));
		action.JSClick(driver, forgotpasswordpage.getForgotPassword1());
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(forgotpasswordpage.getPleaseprovideyouremailaddressText().getText());
		softAssert.assertEquals(forgotpasswordpage.getPleaseprovideyouremailaddressText().getText(), prop.getProperty("ForgotPasswordHeaderMessege"));
		System.out.println(forgotpasswordpage.getCurrentTitle(driver));
		softAssert.assertEquals(forgotpasswordpage.getCurrentTitle(driver),prop.getProperty("ForgotPagetitle") );
		softAssert.assertAll();
	}
	@Test(priority=3,dependsOnMethods = {"forgotFunctionality"},enabled=false)
	public void validateErrorMsgWithoutCredential() throws InterruptedException {
		action.JSClick(driver, forgotpasswordpage.getForgotPassword1());
		action.click(driver,forgotpasswordpage.getsbubmitButton() );
		System.out.println(forgotpasswordpage.getErrorMsgUsername().getText());
		System.out.println(forgotpasswordpage.getErrorMsgEmail().getText());
		softAssert.assertEquals(forgotpasswordpage.getErrorMsgUsername().getText(), prop.getProperty("ErrorMgsRegardingUsername"));
		softAssert.assertEquals(forgotpasswordpage.getErrorMsgEmail().getText(), prop.getProperty("ErrorMgsRegardingEmail"));
	}
	@Test(priority=2,dependsOnMethods = {"forgotFunctionality"},enabled=true)
	public void ValidateUnregisterAccount() {
		action.type(forgotpasswordpage.getForgotPasswordUsernameTextfield(), prop.getProperty("InvalidForgotUsername"));
		action.type(forgotpasswordpage.getForgotPasswordEmailTextfield(), prop.getProperty("InvalidForgotEmail"));
		action.click(driver,forgotpasswordpage.getsbubmitButton() );
		action.explicitWait(driver, indexpage.getErrorMsg(), 10);
		System.out.println(indexpage.getErrorMsg().getText());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ErrorMsgForInvalidUser"));
		softAssert.assertAll();
	}
	@Test(priority=3,dependsOnMethods = {"forgotFunctionality"})
	public void validateRegisterUser() throws InterruptedException {
		action.fluentWait(driver, forgotpasswordpage.getForgotPasswordUsernameTextfield());
		action.type(forgotpasswordpage.getForgotPasswordUsernameTextfield(), prop.getProperty("ValidForgotUsername"));
		action.type(forgotpasswordpage.getForgotPasswordEmailTextfield(), prop.getProperty("ValidForgotEmail"));
		action.click(driver,forgotpasswordpage.getsbubmitButton() );
		action.fluentWait(driver, indexpage.getErrorMsg());
		System.out.println(indexpage.getErrorMsg().getText());
		action.fluentWait(driver, indexpage.getErrorMsg());
		Thread.sleep(4000);
		softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ErrorMsgForvalidUser"));
		softAssert.assertAll();
	}
	@Test(priority=4,dependsOnMethods = {"forgotFunctionality"})
	public void validateInvalidFormatEmail() {
//		action.type(forgotpasswordpage.getForgotPasswordUsernameTextfield(), prop.getProperty("ValidForgotUsername"));
		action.fluentWait(driver, forgotpasswordpage.getForgotPasswordEmailTextfield());
		action.type(forgotpasswordpage.getForgotPasswordEmailTextfield(), prop.getProperty("InValidForgotEmail"));
		action.click(driver,forgotpasswordpage.getsbubmitButton() );
		System.out.println(forgotpasswordpage.getErrorMsgInvalidEmail().getText());
		action.fluentWait(driver, forgotpasswordpage.getErrorMsgInvalidEmail());
		softAssert.assertEquals(forgotpasswordpage.getErrorMsgInvalidEmail().getText(), prop.getProperty("ErrorMsgForInvalidEmail"));
		softAssert.assertAll();
	}
	

}
