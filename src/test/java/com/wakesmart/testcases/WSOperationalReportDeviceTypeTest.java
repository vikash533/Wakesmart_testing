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

public class WSOperationalReportDeviceTypeTest extends BaseClass {
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
    public void reportDeviceType(){
        indexpage = new IndexPage(driver);
        action= new Action();
        softAssert = new SoftAssert();
        report = new WSReports(driver);
        try{
            indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
            action.explicitWait(driver,report.getoperationalReports(),10);
            action.JSClick(driver,report.getoperationalReports());
            action.scrollByVisibilityOfElement(driver, report.getDeviceTypeIcon());
            action.fluentWait(driver, report.getDeviceTypeIcon());
            action.JSClick(driver, report.getDeviceTypeIcon());
            softAssert.assertEquals(report.getDeviceSummaryHeaderText().getText(), prop.getProperty("DeviceSummaryHeaderText"));
            softAssert.assertEquals(report.getDeviceSummaryContextText().getText(), prop.getProperty("DeviceSummaryContextText"));
            action.click(driver,report.getDeviceTypeSelectGroup());
            action.fluentWait1(driver, report.getAssetInventorySelectGroupOptions());
            action.getSelectOptionFromDropdown(report.getGroupsSelected(),prop.getProperty("DeviceTypeSelectGroup"));
            action.click(driver,report.getDeviceTypeSelectPolicy());
            action.getSelectOptionFromDropdown(report.getDeviceTypeSelectPolicyOptions(),prop.getProperty("DeviceTypeSelectPolicy"));
            action.click(driver,report.getDeviceTypeSubmitButton());
            action.click(driver,report.getDeviceTypeSubmitButton());
            action.fluentWait(driver, report.getAssetInventoryExportButton());
            action.click(driver, report.getAssetInventoryExportButton());
            action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
            action.click(driver, report.getExport());
            action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
