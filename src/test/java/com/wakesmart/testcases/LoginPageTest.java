package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
		String actualtitle = indexpage.getTitle(driver);
		action.softAssertion(actualtitle,  prop.getProperty("title"));
	}

	@Test(priority = 4)
	public void invalidUserName_ValidPasswordLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);

		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		String actaualmessege = indexpage.getErrorMsg().getText();
		action.softAssertion(actaualmessege,  prop.getProperty("ErorMessege"));
	}

	@Test(priority = 5)
	public void validUserName_InvalidPasswordLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);

		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		String actaualmessege = indexpage.getErrorMsg().getText();
		action.softAssertion(actaualmessege,  prop.getProperty("ErorMessege"));
	}

	@Test(priority = 6)
	public void inValidUserName_InvalidPasswordLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);

		action.type(indexpage.getUserName(), prop.getProperty("InvalidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		String actaualmessege = indexpage.getErrorMsg().getText();
		action.softAssertion(actaualmessege,  prop.getProperty("ErorMessege"));
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

		action.type(indexpage.getPassWord(), prop.getProperty("InvalidPassword"));
		String passwordValue = indexpage.getpasswordVisibiltyOnDom()
				.getDomAttribute(prop.getProperty("passwordDOMAttribute"));
		action.softAssertion(passwordValue,  prop.getProperty("passwordValue"));
	}

	@Test(priority = 9, groups= {"Smoke"})
	public void validUserLogin() throws InterruptedException {
		indexpage = new IndexPage(driver);
		homepage = new HomePage(driver);
		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		action.fluentWait(driver, homepage.getScreenTitle());
		String actualmessege = homepage.getScreenTitle().getText();
		
		action.softAssertion(actualmessege,  prop.getProperty("WelcomeMessgeOnHomePage"));
	}
	
	@Test(priority = 10, groups= {"Smoke"})
	public void userLogout() {
		homepage = new HomePage(driver);
		indexpage = new IndexPage(driver);
		action.click(driver, homepage.getlogout());
		
		action.softAssertion(indexpage.getLoginDialougeTitle().getText(),  prop.getProperty("LoginDialougeTitle"));
	}

	@Test(priority = 2)
	public void colorOfForm() throws Exception {
		indexpage = new IndexPage(driver);

		String actualColor = action.colorVerify(indexpage.getLoginFormColor(), prop.getProperty("formColorvalueRGB"));
		
		
		action.softAssertion(actualColor,  prop.getProperty("formHEXvalue"));
	}

	@Test(priority = 3, groups= {"Smoke"})
	public void colorOfLoginButton() throws Exception {
		indexpage = new IndexPage(driver);

		String actualColor = action.colorVerify(indexpage.getLogin(), prop.getProperty("loginButtonColorvalueRGB"));

		action.softAssertion(actualColor,  prop.getProperty("loginButtonHEXvalue"));
	}
}
