package com.wakesmart.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSManagement;
import com.wakesmart.pageObjects.WSUsers;

/*
Updated for the new UI by shreyas kumar
 										*/

public class WSUsersTest extends BaseClass {

	public WebDriver driver;
	private IndexPage indexpage;
	private Action action;
	private SoftAssert softAssert;
	private WSManagement management;
	private WSUsers users;

	@BeforeClass
	public void browserLaunch() {
		try {
			driver = launchBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}

	@AfterClass(enabled = true)
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 0)
	public void managementUsersTableNameVerify() throws IOException, InterruptedException {
		indexpage = new IndexPage(driver);
		action = new Action();
		softAssert = new SoftAssert();
		management = new WSManagement(driver);
		users = new WSUsers(driver);

		indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),
				prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);

		action.JSClick(driver, management.getManagementTab());
		action.JSClick(driver, users.getManagementUsers());
		
		softAssert.assertEquals(users.getUsersTableHeaderTextVerify(), users.getUsersTableHeaderDataToVerify(prop)," Mismatch management users table header text");
		softAssert.assertAll();
	}
	
	// With all details
	@Test(priority = 2, dependsOnMethods= {"managementUsersTableNameVerify"})
	public void UsersWithAllInputs() throws InterruptedException {
		Thread.sleep(2000);
		action.fluentWait(driver, users.getAddButtonUser());
		action.JSClick(driver, users.getAddButtonUser());
		action.type(users.getUserName(), prop.getProperty("ManagementUserName"));
		action.type(users.getEmail(), prop.getProperty("ManagementUserEmail"));
		action.type(users.getConfirmEmail(), prop.getProperty("ManagementUserEmail"));
		action.click(driver, users.getAddNewUserSubmitButton());
		action.fluentWait(driver, users.getAlertCloseButton());
		softAssert.assertEquals(users.getAlertMessage(),  prop.getProperty("ManagementUserWithAllInputs"));
		action.click(driver, users.getAlertCloseButton());
		action.click(driver, users.getAddNewUserCancelButton());
		softAssert.assertAll();
	}
	
	//without any details
	@Test(priority = 1, dependsOnMethods= {"managementUsersTableNameVerify"})
	public void UsersWithoutAnyInputs() throws InterruptedException {
		Thread.sleep(2000);
		action.fluentWait(driver, users.getAddButtonUser());
		action.click(driver, users.getAddButtonUser());
		action.click(driver, users.getAddNewUserSubmitButton());
		Thread.sleep(2000);
		softAssert.assertEquals(users.getAlertMessage(),  prop.getProperty("ManagementUserWithoutAnyInput"));
		action.click(driver, users.getAlertCloseButton());
		softAssert.assertAll();
	}
	
	@Test(priority = 3, dependsOnMethods= {"managementUsersTableNameVerify"})
	public void UsersWithUserNameAndNoEmail() throws InterruptedException {
		Thread.sleep(2000);
		action.fluentWait(driver, users.getAddButtonUser());
		action.click(driver, users.getAddButtonUser());
		action.type(users.getUserName(), prop.getProperty("ManagementUserName"));
		action.click(driver, users.getAddNewUserSubmitButton());
		Thread.sleep(2000);
		action.fluentWait(driver, users.getAlertCloseButton());
		softAssert.assertEquals(users.getAlertMessage(),  prop.getProperty("ManagementUserNameWithoutMailID"));
		action.click(driver, users.getAlertCloseButton());
		softAssert.assertAll();
	}
	
	
	@Test(priority = 4, dependsOnMethods= {"managementUsersTableNameVerify"})
	public void UsersWithUserNameAndInvalidEmail() throws InterruptedException {
		Thread.sleep(2000);
		action.fluentWait(driver, users.getAddButtonUser());
		action.JSClick(driver, users.getAddButtonUser());
		action.type(users.getUserName(), prop.getProperty("ManagementUserName"));
		action.type(users.getEmail(), prop.getProperty("ManagementUserInvalidEmail"));
		action.type(users.getConfirmEmail(), prop.getProperty("ManagementUserInvalidEmail"));
		action.click(driver, users.getAddNewUserSubmitButton());
		Thread.sleep(2000);
		action.fluentWait(driver, users.getAlertCloseButton());
		softAssert.assertEquals(users.getAlertMessage(),  prop.getProperty("ManagementUserNameWithInvalidMailID"));
		action.click(driver, users.getAlertCloseButton());
		softAssert.assertAll();
	}
	
	
	
	
	
	
}
