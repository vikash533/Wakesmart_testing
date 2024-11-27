package com.wakesmart.testcases;

import com.wakesmart.action.Action;
import com.wakesmart.base.BaseClass;
import com.wakesmart.pageObjects.IndexPage;
import com.wakesmart.pageObjects.WSReports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class WSBattaryHealtReport extends BaseClass {
    public WebDriver driver;
    private IndexPage indexpage;
    private Action action;
    private SoftAssert softAssert;
    private WSReports report;
    @BeforeClass
    public void browserLaunch()  {
        try {
            driver = launchBrowser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.get(prop.getProperty("url"));
    }

    @AfterClass(enabled=true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void BattaryHealthOpertionalReport(){
        indexpage = new IndexPage(driver);
        action= new Action();
        softAssert = new SoftAssert();
        report = new WSReports(driver);
        try{
        indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
        action.explicitWait(driver,report.getoperationalReports(),10);
        action.JSClick(driver,report.getoperationalReports());
        action.fluentWait(driver, report.getBatteryHealthIcon());
        action.scrollByVisibilityOfElement(driver,report.getBatteryHealthIcon());
        action.JSClick(driver, report.getBatteryHealthIcon());
        softAssert.assertEquals(report.getBatteryHealthPopUpHeader().getText(), prop.getProperty("BatteryHealthStatisticsText"));
        softAssert.assertEquals(report.getGroupSelectedText().getText(), prop.getProperty("GroupSelectedText"));
        softAssert.assertEquals(report.getStartDateText().getText(), prop.getProperty("StartDateText"));
        softAssert.assertEquals(report.getEndDateText().getText(), prop.getProperty("EndDateText"));
        action.click(driver, report.getGroupsSelectedIcon());
        action.getSelectOptionFromDropdown(report.getGroupsSelected(), prop.getProperty("GroupSelectedText"));
        action.isEnabled(driver, report.getSubmitButton());
        action.click(driver, report.getSubmitButton());
        action.click(driver, report.getExport());
        action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
        action.click(driver, report.getExport());
        action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
