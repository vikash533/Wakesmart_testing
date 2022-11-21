package com.wakesmart.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.About;
import com.wakesmart.pageObjects.HomePage;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.Reporting;
import com.wakesmart.pageObjects.User;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class HomePageTest extends BaseClass {

	public WebDriver driver;
	public Action action;
	private HomePage homepage;
	private IndexPage indexpage;
	private User user;
	private About about;
	private Reporting reporting;

	@BeforeClass
	public void browserLaunch() throws IOException {
		driver = launchBrowser();
		driver.get(prop.getProperty("url"));
	}

//	@AfterClass
//	public void tearDown() throws InterruptedException {
//		driver.quit();
//	}

	@Test
	public void validUserLogin() {
		indexpage = new IndexPage(driver);
		homepage = new HomePage(driver);
		action = new Action();

		action.type(indexpage.getUserName(), prop.getProperty("ValidUserName"));
		action.type(indexpage.getPassWord(), prop.getProperty("ValidPassword"));
		action.click(driver, indexpage.getLoginForm());
		action.click(driver, indexpage.getLogin());
		action.fluentWait(driver, homepage.getScreenTitle());
		String actualmessege = homepage.getScreenTitle().getText();
		Assert.assertEquals(actualmessege, prop.getProperty("WelcomeMessgeOnHomePage"));
	}

	@Test(dependsOnMethods = { "validUserLogin" })
	public void user() {
		homepage = new HomePage(driver);
		action = new Action();
		user = new User(driver);

		String userName = homepage.getuserIconUserID().getText();
		action.JSClick(driver, homepage.getuserIcon());

		String actualmessege = user.getUserTitleHomePageMessege().getText();
		String actualMessegeContent = user.getAboutContent().getText();

		Assert.assertEquals(userName, prop.getProperty("ValidUserName"));

		Assert.assertTrue(actualMessegeContent.contains(prop.getProperty("UserContentMessege")));
		Assert.assertEquals(actualmessege, prop.getProperty("UserTitleMessege"));
	}

	@Test(dependsOnMethods = { "user" })
	public void about() {
		action = new Action();
		homepage = new HomePage(driver);
		about = new About(driver);

		action.click(driver, homepage.getAboutIcon());
		String actualmessegeheader = about.getAboutHeader().getText();
		String actualmessegecontent = about.getAboutContent().getText();
		Assert.assertTrue(actualmessegeheader.contains(prop.getProperty("AboutTitleMessege")));
		Assert.assertTrue(actualmessegecontent.contains(prop.getProperty("AboutContentMessege")));
	}

	@Test(dependsOnMethods = { "validUserLogin" })
	public void reporting() throws InterruptedException, ParseException {
		homepage = new HomePage(driver);
		reporting = new Reporting(driver);

		action.click(driver, homepage.getReportsIcon());
		String reportingHeader = reporting.getHeaderTitle().getText();
		String actualOperationalReports = reporting.getoperationalReports().getText();
		String actualActivityReports = reporting.getActivityReports().getText();
		String actualEnergyReports = reporting.getEnergyReports().getText();

		// Battery Health
		String actaualBatteryHealthText = reporting.getBatteryHealthText().getText();
		action.click(driver, reporting.getBatteryHealthIcon());

		String actualStartdateText = reporting.getStartDateText().getText();

		action.type(reporting.getStartDate(), prop.getProperty("BatteryHealthStartDate"));
		action.type(reporting.getEndDate(), prop.getProperty("BatteryHealthEndDate"));
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.click(driver, reporting.getOKButton());

		String actualExporttext = reporting.getExport().getText();
		String actualstartdateverify = action.dateFormat(prop.getProperty("BatteryHealthStartDate"));
		String expectedstartdate = reporting.getStartDateVerifyAtExport().getText();

		String expectedGroupSelectionTest = reporting.getFinalGroupSelectionverifyText().getText();
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());

		driver.navigate().back();

		// verify for one week
		action.click(driver, reporting.getBatteryHealthIcon());
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRange"), reporting.getDateRange());
		action.click(driver, reporting.getOKButton());

		String startDateAtSevenDays = reporting.getStartDateVerifyAtExport().getText();
		String endDateAtSevenDays = reporting.getEndDateVerifyAtExport().getText();
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());

		// verify for two weeks
		driver.navigate().back();
		action.click(driver, reporting.getBatteryHealthIcon());
		action.selectByVisibleText(prop.getProperty("BatteryHealthGroupsSelected"), reporting.getGroupsSelected());
		action.selectByVisibleText(prop.getProperty("BatteryHealthDateRangeTwoWeeks"), reporting.getDateRange());
		action.click(driver, reporting.getOKButton());
		String startDateAtTwoweeks = reporting.getStartDateVerifyAtExport().getText();
		String endDateAtTwoWeeks = reporting.getEndDateVerifyAtExport().getText();
		action.selectByVisibleText(prop.getProperty("DownloadFormatTwo"), reporting.getExportDropDown());
		action.selectByVisibleText(prop.getProperty("DownloadFormat"), reporting.getExportDropDown());
		
		driver.navigate().back();
		

		Assert.assertEquals(reportingHeader, prop.getProperty("ReportingPageHeaderMessege"));
		Assert.assertEquals(actualOperationalReports, prop.getProperty("ReportingOperationalMessege"));
		Assert.assertEquals(actualActivityReports, prop.getProperty("ReportingActivityMessege"));
		Assert.assertEquals(actualEnergyReports, prop.getProperty("ReportingEnergyMessege"));
		Assert.assertEquals(actaualBatteryHealthText, prop.getProperty("BatteryHealthText"));
		Assert.assertEquals(actualstartdateverify, expectedstartdate);
		Assert.assertEquals(actualStartdateText, prop.getProperty("StartDateText"));
		Assert.assertEquals(actualExporttext, prop.getProperty("ExportText"));
		Assert.assertEquals(expectedGroupSelectionTest, prop.getProperty("FinalGroupSelectionverifyText"));
		Assert.assertEquals(startDateAtSevenDays, action.currentDateMinusSeven(8));
		Assert.assertEquals(endDateAtSevenDays, action.currentDateMinusone());
		Assert.assertEquals(startDateAtTwoweeks, action.currentDateMinusSeven(15));
		Assert.assertEquals(endDateAtTwoWeeks, action.currentDateMinusone());
	}
}
