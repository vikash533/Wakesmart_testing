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

public class WSOperationalReportsGroupSummaryTest extends BaseClass {
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
    public void reportGroupSummary(){
        indexpage = new IndexPage(driver);
        action= new Action();
        softAssert = new SoftAssert();
        report = new WSReports(driver);
        try{
            indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"), prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
            action.explicitWait(driver, report.getoperationalReports(), 10);
            action.JSClick(driver,report.getoperationalReports());
            action.scrollByVisibilityOfElement(driver,report.getGroupSummaryIcon());
            action.click(driver,report.getGroupSummaryIcon());
            softAssert.assertEquals(report.getGroupSummaryText().getText(), prop.getProperty("GroupSummaryText"));
            softAssert.assertEquals(report.getListOfGroupText().getText(), prop.getProperty("GroupSummaryContentText"));
            action.click(driver, report.getAssetInventoryExportButton());
            System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
            action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
            action.fluentWait(driver, report.getExport());
            action.click(driver, report.getExport());
            action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
            action.JSClick(driver,report.getoperationalReports());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
