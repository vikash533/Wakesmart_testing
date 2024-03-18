package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WSLicence {

public WebDriver driver;
	
	public WSLicence(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "//div[@class='MuiList-root css-1xidfkz']//a[4]")
	 public WebElement getLicence;
	 
	 @FindBy(xpath = "//div[@class='MuiCardHeader-content css-11qjisw']/span")
	 public WebElement getLicenceManagement;
	 
	 @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-hrpkyi']")
	 public WebElement getTableHeaderText;
	 
	 @FindBy(xpath = "//thead[@class='MuiTableHead-root css-1wbz3t9']/tr/th")
	 public List<WebElement> getTableHeaderTextVerify;
	 
	 //Total	 
	 By RowsTotal = By.xpath("//tbody[@class='MuiTableBody-root css-1xnox0e']//tr/td[3]");
	 By RowsUsed = By.xpath("//tbody[@class='MuiTableBody-root css-1xnox0e']//tr/td[4]");
	 By RowsRemaining= By.xpath("//tbody[@class='MuiTableBody-root css-1xnox0e']//tr/td[5]");
	 
	 
	 public List<Integer> getRowsTotal() {
		List<WebElement> list = driver.findElements(RowsTotal);
		List<Integer> rows =  new ArrayList<>();
		for(WebElement ele : list) {
			rows.add(Integer.parseInt(ele.getText()));
		}
		return rows;
	 }
	 
	 public List<Integer> getRowsUsed() {
		 List<WebElement> list = driver.findElements(RowsUsed);
		 List<Integer> used =  new ArrayList<>();
		 for(WebElement ele : list) {
			 used.add(Integer.parseInt(ele.getText()));
		 }
		 return used;
	 }
	 
	 public List<Integer> getRowsRemaining() {
		 List<WebElement> list = driver.findElements(RowsRemaining);
		 List<Integer> remaining =  new ArrayList<>();
		 for(WebElement ele : list) {
			 remaining.add(Integer.parseInt(ele.getText()));
		 }
		 return remaining;
	 }
	 
	 public void verifyCount() {
		 for(int i = 0 ; i< getRowsTotal().size(); i++) {
			 Assert.assertEquals(getRowsTotal().get(i), (getRowsUsed().get(i)+getRowsRemaining().get(i)));
		 }
	 }
	 
	 public List<String> tableTextVerify() {
		 List<String> name = new ArrayList<>();
		 for(WebElement ele : getTableHeaderTextVerify) {
			 name.add(ele.getText());
		 }
		 return name;
	 }
	 
	 public List<String> tableTextVerifyFromLocal(Properties prop) {
		 List<String> name = new ArrayList<>();
		 name.add(prop.getProperty("ManagementLicencePageNameText"));
		 name.add(prop.getProperty("ManagementLicencePageTypeText"));
		 name.add(prop.getProperty("ManagementLicencePageTotalText"));
		 name.add(prop.getProperty("ManagementLicencePageUsedText"));
		 name.add(prop.getProperty("ManagementLicencePageRemainingText"));
		 name.add(prop.getProperty("ManagementLicencePageIssuedText"));
		 name.add(prop.getProperty("ManagementLicencePageExpirationText"));
		 return name;
	 }
	
}
