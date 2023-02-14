package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.HomePage;
import com.wakesmart.pageObjects.IndexPage;

public class LoginPageTest extends BaseClass {
	public WebDriver driver;
	Action action = new Action();
	public IndexPage indexpage = new IndexPage(driver);
	public HomePage homepage;
	Actions act;
	SoftAssert softAssert;

	@BeforeClass
	public void browserLaunch() throws IOException {
		driver = launchBrowser();
		driver.get(prop.getProperty("url"));
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

	@Test(priority = 1)
	public void getTitle() {
		softAssert = new SoftAssert();
		String actualtitle = indexpage.getTitle(driver);
		softAssert.assertEquals(actualtitle,  prop.getProperty("title"));
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void invalidUserName_ValidPasswordLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		
		
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		String actaualmessege = indexpage.getErrorMsg().getText();
		softAssert.assertEquals(actaualmessege,  prop.getProperty("ErorMessege"));
		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void validUserName_InvalidPasswordLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		
		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		String actaualmessege = indexpage.getErrorMsg().getText();
		
		softAssert.assertEquals(actaualmessege,  prop.getProperty("ErorMessege"));
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void inValidUserName_InvalidPasswordLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		String actaualmessege = indexpage.getErrorMsg().getText();
		softAssert.assertEquals(actaualmessege,  prop.getProperty("ErorMessege"));
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void empty_Credential_Login() throws InterruptedException {
		indexpage = new IndexPage(driver);

		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));

	}

	@Test(priority = 8)
	public void passwordVisibilityOnDOM() throws InterruptedException {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		String passwordValue = indexpage.getpasswordVisibiltyOnDom()
				.getDomAttribute(prop.getProperty("passwordDOMAttribute"));
		softAssert.assertEquals(passwordValue,  prop.getProperty("passwordValue"));
		softAssert.assertAll();
	}

	@Test(priority = 9, groups= {"Smoke"})
	public void validUserLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);
		homepage = new HomePage(driver);
		softAssert = new SoftAssert();
		
		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		action.fluentWait(driver, homepage.getScreenTitle());
		String actualmessege = homepage.getScreenTitle().getText();
		
		softAssert.assertEquals(actualmessege,  prop.getProperty("WelcomeMessgeOnHomePage"));
		softAssert.assertAll();
	}
	
	@Test(priority = 10, groups= {"Smoke"})
	public void userLogout() {
		homepage = new HomePage(driver);
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		
		action.click(driver, homepage.getlogout());
		
		softAssert.assertEquals(indexpage.getLoginDialougeTitle().getText(),  prop.getProperty("LoginDialougeTitle"));
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void colorOfForm() throws Exception {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		
		String actualColor = action.colorVerify(indexpage.getLoginFormColor(), prop.getProperty("formColorvalueRGB"));
		
		
		softAssert.assertEquals(actualColor,  prop.getProperty("formHEXvalue"));
		softAssert.assertAll();
	}

	@Test(priority = 3, groups= {"Smoke"})
	public void colorOfLoginButton() throws Exception {
		indexpage = new IndexPage(driver);
		softAssert = new SoftAssert();
		
		String actualColor = action.colorVerify(indexpage.getLogin(), prop.getProperty("loginButtonColorvalueRGB"));

		softAssert.assertEquals(actualColor,  prop.getProperty("loginButtonHEXvalue"));
		softAssert.assertAll();
	}
}
