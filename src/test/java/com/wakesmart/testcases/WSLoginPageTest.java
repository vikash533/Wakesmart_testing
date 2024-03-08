package com.wakesmart.testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.WSHomePage;
import com.wakesmart.pageObjects.IndexPage;

/*
Updated as per the new UI **01**
 										*/
public class WSLoginPageTest extends BaseClass {
	
	public WebDriver driver;
	public Action action  = new Action();
	public IndexPage indexpage;
	public WSHomePage homepage;
	public SoftAssert softAssert;

	@BeforeClass
	public void browserLaunch()  {
		try {
			driver = launchBrowser();
			driver.get(prop.getProperty("url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		indexpage = new IndexPage(driver);
        homepage = new WSHomePage(driver);
        
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
		driver.quit();
		}
	}

	//Completed
	@Test(priority = 1)
	public void getTitle() {
		softAssert = new SoftAssert();
		softAssert.assertEquals(indexpage.getTitle(driver),  prop.getProperty("title"));
		softAssert.assertAll();
	}

	//Completed
	@Test(priority = 4)
	public void invalidUserName_ValidPasswordLogin()  {
		softAssert = new SoftAssert();
		
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLogin());
		//commented as per new code 62 to 64
//		action.fluentWait(driver, indexpage.getErrorMsg());
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("ErorMessege"));
//		action.click(driver, indexpage.getPopupCloseIcon());
		
		softAssert.assertAll();
	}

	//Completed
	@Test(priority = 5)
	public void validUserName_InvalidPasswordLogin()  {
		softAssert = new SoftAssert();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		
		action.click(driver, indexpage.getLogin());
		action.fluentWait(driver, indexpage.getErrorMsg());
	
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("ErorMessegeInvalidCredentials"));
		
		softAssert.assertAll();
		action.click(driver, indexpage.getPopupCloseIcon());
	}

	//Completed
	@Test(priority = 6)
	public void inValidUserName_InvalidPasswordLogin()  {
		softAssert = new SoftAssert();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		action.click(driver, indexpage.getLogin());
		// commented as per new UI 104 to 108
//		action.fluentWait(driver, indexpage.getErrorMsg());
//		String actaualmessege = indexpage.getErrorMsg().getText();
//		softAssert.assertEquals(actaualmessege,  prop.getProperty("ErorMessege"));
//		softAssert.assertAll();
//		action.click(driver, indexpage.getPopupCloseIcon());
	}

	//Completed
	@Test(priority = 7)
	public void empty_Credential_Login()  {
		softAssert = new SoftAssert();
		
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), "");
		action.click(driver, indexpage.getLogin());
		action.fluentWait(driver, indexpage.getPasswordWarningMessege());
		softAssert.assertEquals(indexpage.getPasswordWarningMessege().getText(),  prop.getProperty("PasswordWarningMessege"));
		softAssert.assertAll();
	}

	//Completed
	@Test(priority = 8,enabled=true)
	public void passwordVisibilityOnDOM()  {
		softAssert = new SoftAssert();
		
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		String passwordValue = indexpage.getpasswordVisibiltyOnDom().getDomAttribute(prop.getProperty("passwordDOMAttribute"));
		softAssert.assertNotEquals(passwordValue, prop.getProperty("InvalidPassword"),"Password is visible on the DOM=");
		softAssert.assertAll();
	}

	//Completed
	@Test(priority = 9, groups= {"Smoke"},enabled=true)
	public void validUserLogin()  {
		softAssert = new SoftAssert();
		
		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		//commented as per new UI 143 to 148
		action.JSClick(driver, indexpage.getLogin());
//		action.fluentWait(driver, indexpage.getErrorMsg());
		
//		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("WelcomeMessgeOnHomeNewPage"));
//		softAssert.assertAll();
//		action.click(driver, indexpage.getPopupCloseIcon());
	}
	
	//Completed
		@Test(priority=10)
		public void URLVerification() {
			softAssert = new SoftAssert();
			
			softAssert.assertEquals(driver.getCurrentUrl(),  prop.getProperty("url"));
			softAssert.assertAll();
		}
	
	//Completed
	@Test(dependsOnMethods= {"validUserLogin"},priority = 11, groups= {"Smoke"},enabled=true)
	public void userLogout() {
		softAssert = new SoftAssert();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.JSClick(driver, homepage.getAccountSettingsIcon());
		action.fluentWait(driver, homepage.getlogout());
		action.click(driver, homepage.getlogout());
		action.fluentWait(driver, indexpage.getLoginDialougeTitle());
		softAssert.assertEquals(indexpage.getLoginDialougeTitle().getText(),  prop.getProperty("LoginDialougeTitle"));
		softAssert.assertAll();
	}
	
	@Test( priority= 3, groups= {"Smoke"},enabled=true)
	public void colorOfLoginButton()  {
		softAssert = new SoftAssert();
		
		String actualColor = action.colorVerify(indexpage.getLogin(), prop.getProperty("loginButtonColorvalueRGB"));

		softAssert.assertEquals(actualColor,  prop.getProperty("loginButtonHEXvalue"));
		softAssert.assertAll();
		
	}
	
	@Test(dependsOnMethods= {"validUserLogin"},priority = 12, groups= {"Smoke"},enabled=true)
	public void userLoginAfterPasswordChange() throws InterruptedException {
		softAssert = new SoftAssert();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.JSClick(driver, homepage.getAccountSettingsIcon());
		action.JSClick(driver, homepage.getAccountSettings());
		action.click(driver, homepage.getChangePasswordButton());
		action.explicitWait(driver, homepage.getOldChangePassword(), 20);
		action.type(homepage.getOldChangePassword(),prop.getProperty("ValidPassword"));
		System.out.println(prop.getProperty("ChangedValidPassword"));
		action.type(homepage.getNewPassword(), prop.getProperty("ChangedValidPassword"));
		action.type(homepage.getConfirmPassword(), prop.getProperty("ChangedValidPassword"));
		action.JSClick(driver, homepage.getClickSaveButton());
		
		
	}
	@Test(dependsOnMethods= {"validUserLogin","userLoginAfterPasswordChange"},priority = 13, groups= {"Smoke"},enabled=true)
	public void loginWithChangedPassword() {
		softAssert = new SoftAssert();
		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ChangedValidPassword"));
		action.JSClick(driver, indexpage.getLogin());
	}
}
