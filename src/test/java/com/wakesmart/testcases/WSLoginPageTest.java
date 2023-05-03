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
Completely used and Updated for new UI 
 										*/
public class WSLoginPageTest extends BaseClass {
	
	public WebDriver driver;
	public Action action;
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
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

	//Completed
	@Test(priority = 1)
	public void getTitle() {
		softAssert = new SoftAssert();
		indexpage = new IndexPage(driver);
		
		softAssert.assertEquals(indexpage.getTitle(driver),  prop.getProperty("title"));
		softAssert.assertAll();
	}

	//Completed
	@Test(priority = 4)
	public void invalidUserName_ValidPasswordLogin()  {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLogin());
		
		action.fluentWait(driver, indexpage.getErrorMsg());
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("ErorMessege"));
		
		softAssert.assertAll();
		action.click(driver, indexpage.getPopupCloseIcon());
		
	}

	//Completed
	@Test(priority = 5)
	public void validUserName_InvalidPasswordLogin()  {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
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
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		action.click(driver, indexpage.getLogin());
		action.fluentWait(driver, indexpage.getErrorMsg());
		String actaualmessege = indexpage.getErrorMsg().getText();
		softAssert.assertEquals(actaualmessege,  prop.getProperty("ErorMessege"));
		softAssert.assertAll();
		action.click(driver, indexpage.getPopupCloseIcon());
	}

	//Completed
	@Test(priority = 7)
	public void empty_Credential_Login()  {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
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
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		String passwordValue = indexpage.getpasswordVisibiltyOnDom().getDomAttribute(prop.getProperty("passwordDOMAttribute"));
		softAssert.assertNotEquals(passwordValue, prop.getProperty("InvalidPassword"),"Password is visible on the DOM=");
		softAssert.assertAll();
	}

	//Completed
	@Test(priority = 9, groups= {"Smoke"},enabled=true)
	public void validUserLogin()  {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
		
		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLogin());
		action.fluentWait(driver, indexpage.getErrorMsg());
		
		softAssert.assertEquals(indexpage.getErrorMsg().getText(),  prop.getProperty("WelcomeMessgeOnHomeNewPage"));
		softAssert.assertAll();
		action.click(driver, indexpage.getPopupCloseIcon());
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
		homepage = new WSHomePage(driver);
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.click(driver, homepage.getAccountSettingsIcon());
		action.fluentWait(driver, homepage.getlogout());
		action.click(driver, homepage.getlogout());
		
		softAssert.assertEquals(indexpage.getLoginDialougeTitle().getText(),  prop.getProperty("LoginDialougeTitle"));
		softAssert.assertAll();
	}

	//Completed
	@Test(priority = 2,enabled=true)
	public void colorOfForm(){
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
		String actualColor = action.colorVerify(indexpage.getLoginFormColor(), prop.getProperty("formColorvalueRGB"));
		
		softAssert.assertEquals(actualColor,  prop.getProperty("formHEXvalue"));
		softAssert.assertAll();
	}

	
	@Test(priority = 3, groups= {"Smoke"},enabled=true)
	public void colorOfLoginButton()  {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		action = new Action();
		
		String actualColor = action.colorVerify(indexpage.getLogin(), prop.getProperty("loginButtonColorvalueRGB"));

		softAssert.assertEquals(actualColor,  prop.getProperty("loginButtonHEXvalue"));
		softAssert.assertAll();
	}
}
