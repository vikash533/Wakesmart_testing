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
import java.util.List;

public class WSActivityReports extends BaseClass {
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
    @Test(priority =1)
    public void activityReports() throws InterruptedException {
        indexpage = new IndexPage(driver);
        action= new Action();
        softAssert = new SoftAssert();
        report = new WSReports(driver);
        try{
            indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"), prop.getProperty("WelcomeMessgeOnHomeNewPage"), prop);
            action.explicitWait(driver, report.getoperationalReports(), 10);
            action.scrollByVisibilityOfElement(driver,report.getoperationalReports());
//            action.JSClick(driver,report.getoperationalReports());
//            action.scrollByVisibilityOfElement(driver, report.getActivityReportsIcon());
            action.fluentWait(driver, report.getActivityReportsIcon());
            action.JSClick(driver, report.getActivityReportsIcon());
            action.click(driver, report.getActivityReportsDeviceUsage());
            softAssert.assertEquals(report.getActivityReportsDeviceUsageSummaryText().getText(), prop.getProperty("DeviceUsageText"));
            softAssert.assertEquals(report.getActivityReportsDeviceUsageContentText().getText(), prop.getProperty("DeviceUsageContentText"));
            action.click(driver, report.getActivityReportsDeviceDateRange());
            action.fluentWait1(driver, report.getActivityReportsDeviceDateRangeOptions());
            List<String> listOfDateRange = action.verifyDropdown(report.getActivityReportsDeviceDateRangeOptions());
            System.out.println(listOfDateRange);
            action.fluentWait1(driver, report.getActivityReportsDeviceDateRangeOptions());
            action.nameVerifyFromTableAndClick(report.getActivityReportsDeviceDateRangeOptions(),prop.getProperty("DeviceUsageDateRangeText"));
            Thread.sleep(4000);
            action.click(driver, report.getActivityReportsDeviceSelectGroup());
            List<String> listofGroupSelected = action.verifyDropdown(report.getActivityReportsDeviceSelectGroupOptions());
            System.out.println(listofGroupSelected);
            action.nameVerifyFromTableAndClick(report.getActivityReportsDeviceSelectGroupOptions(),prop.getProperty("DeviceUsageDateGroupText"));
            action.scrollByVisibilityOfElement(driver, report.getActivityReportsDeviceUsageSubmitButton());
            action.JSClick(driver, report.getActivityReportsDeviceUsageSubmitButton());
            action.fluentWait(driver, report.getAssetInventoryExportButton());
            action.click(driver, report.getAssetInventoryExportButton());
            System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
            action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
            action.fluentWait(driver, report.getAssetInventoryExportButton());
            action.click(driver, report.getExport());
            action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test(priority = 2,dependsOnMethods = "activityReports")
    public void DeviceVsTime() throws InterruptedException {
        try {
            action.JSClick(driver, report.getActivityReportsDeviceVsTime());
            softAssert.assertEquals(report.getActivityReportsDeviceVsTimeHeaderText().getText(), prop.getProperty("DevicevstimetextVerify"));
            softAssert.assertEquals(report.getActivityReportsDevicevstimeContentText().getText(), prop.getProperty("DevicevstimeContentText"));
            action.click(driver, report.getActivityReportsDeviceDateRange());
            Thread.sleep(4000);
            List<String> listOfDateRange = action.verifyDropdown(report.getActivityReportsDeviceDateRangeOptions());
            System.out.println(listOfDateRange);
            action.nameVerifyFromTableAndClick(report.getActivityReportsDeviceDateRangeOptions(), prop.getProperty("DeviceUsageDateRangeText"));
            Thread.sleep(4000);
            action.click(driver, report.getActivityReportsDeviceSelectGroup());
            List<String> listofGroupSelected = action.verifyDropdown(report.getActivityReportsDeviceSelectGroupOptions());
            System.out.println(listofGroupSelected);
            action.nameVerifyFromTableAndClick(report.getActivityReportsDeviceSelectGroupOptions(), prop.getProperty("DeviceVsTimeselectGroup"));
            Thread.sleep(4000);
            action.fluentWait(driver, report.getActivityReportsDevicevstimesubmitButton());
            action.click(driver, report.getActivityReportsDevicevstimesubmitButton());
            action.click(driver, report.getAssetInventoryExportButton());
            System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
            action.nameVerifyFromTableAndClick(report.getExportDropDown(), prop.getProperty("ExportDownloadCSVText"));
            action.click(driver, report.getExport());
            action.nameVerifyFromTableAndClick(report.getExportDropDown(), prop.getProperty("ExportDownloadPdfText"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority=3,dependsOnMethods = {"DeviceVsTime"})
	public void PowerStatesVsTime() throws InterruptedException {
        try {
            action.JSClick(driver, report.getActivityReportsPowerstateVsTime());
            action.scrollToTop(driver);
            softAssert.assertEquals(report.getActivityReportsSavingsSummary().getText(), prop.getProperty("ReportingPowerStateReportPopUpHeader"));
            action.fluentWait(driver, report.getActivityReportsPowerStateVsTimeDateRange());
            action.click(driver, report.getActivityReportsPowerStateVsTimeDateRange());
            action.fluentWait1(driver, report.getActivityReportsPowerStateVsTimeDateRangeOptions());
            action.nameVerifyFromTableAndClick(report.getActivityReportsPowerStateVsTimeDateRangeOptions(), prop.getProperty("ReportingPowerStateReportDateRange"));
            action.explicitWait(driver, report.getActivityReportsPowerStateVsTimeDateTimeInterval(), 15);
            action.JSClick(driver, report.getActivityReportsPowerStateVsTimeDateTimeInterval());
//		action.fluentWait1(driver, report.getActivityReportsPowerStateVsTimeIntervalOptions());
            Thread.sleep(4000);
            action.scrollByVisibilityOfElement(driver, report.getActivityReportsPowerStateVsTimeSubmitButton());
            action.nameVerifyFromTableAndClick(report.getActivityReportsPowerStateVsTimeIntervalOptions(), prop.getProperty("ReportingPowerStateReportTimeIntervalDay"));
            action.click(driver, report.getActivityReportsPowerStateVsTimeSubmitButton());
            action.fluentWait(driver, indexpage.getErrorMsg());
            softAssert.assertEquals(indexpage.getErrorMsg().getText(), prop.getProperty("ReportingPowerStateReportVerifyPopupMsg"));
            action.click(driver, indexpage.getErrorMsg());
            action.scrollToTop(driver);
            action.click(driver, report.getActivityReportsPowerStateVsTimeExprotButton());
            System.out.println(action.verifyDropdown(report.getAssetInventorySelectDeviceOptions()));
            action.nameVerifyFromTableAndClick(report.getExportDropDown(), prop.getProperty("ExportDownloadCSVText"));
            action.click(driver, report.getExport());
            action.nameVerifyFromTableAndClick(report.getExportDropDown(), prop.getProperty("ExportDownloadPdfText"));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
