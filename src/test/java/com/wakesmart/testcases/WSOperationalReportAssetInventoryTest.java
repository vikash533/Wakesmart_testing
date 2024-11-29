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

public class WSOperationalReportAssetInventoryTest extends BaseClass {
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
    public void reportAssetInventory(){
        indexpage = new IndexPage(driver);
        action= new Action();
        softAssert = new SoftAssert();
        report = new WSReports(driver);
        try{
            indexpage.validUserLogin(prop.getProperty("ValidUserName"), prop.getProperty("ValidPassword"),prop.getProperty("WelcomeMessgeOnHomeNewPage"),prop);
            action.explicitWait(driver,report.getoperationalReports(),10);
            action.JSClick(driver,report.getoperationalReports());
            action.fluentWait(driver, report.getAssetInventoryIcon());
            action.scrollByVisibilityOfElement(driver,report.getAssetInventoryIcon());
            action.JSClick(driver, report.getAssetInventoryIcon());
            softAssert.assertEquals(report.getAssetInventoryHeader().getText(), prop.getProperty("AssetInventoryHeader"));
            action.click(driver, report.getSubmitButtonAssetInventory());
            softAssert.assertEquals(report.getAssetInventoryHeader().getText(), prop.getProperty("AssetInventoryHeader"));
            action.click(driver, report.getAssetInventoryExportButton());
            action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadCSVText"));
            action.click(driver, report.getExport());
            action.nameVerifyFromTableAndClick(report.getExportDropDown(),prop.getProperty("ExportDownloadPdfText"));
//          Need to add new functionality on Asset Inventory like save column order and Show/Hide columns

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
