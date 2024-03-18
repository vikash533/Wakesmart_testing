package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSOrganization {

public WebDriver driver;
	
	public WSOrganization(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	 @FindBy(xpath = "//div[@class='MuiList-root css-uppwh0-MuiList-root']//a[8]")
	 public WebElement getOrganizations;
	 
	 @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-1y85m9j-MuiTypography-root']")
	 public WebElement getOrganizationsPageText;
	 
	 @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1g3ji31-MuiTypography-root']")
	 public WebElement getOrganizationsTableHeaderText;
	 
	 @FindBy(xpath = "//tr[@class='MuiTableRow-root MuiTableRow-head css-1b8dwk7']//th")
	 public List<WebElement> getTableHeaderTextVerify;
	 
	 
	 
	 
	 
	 public List<String> tableTextVerify() {
		 List<String> name = new ArrayList<>();
		 for(WebElement ele : getTableHeaderTextVerify) {
			 name.add(ele.getText());
		 }
		 return name;
	 }
	 
	 public List<String> tableTextVerifyFromLocal(Properties prop) {
		 List<String> name = new ArrayList<>();
		 name.add(prop.getProperty("ManagementOrganizationsOrganizationNameText"));
		 name.add(prop.getProperty("ManagementOrganizationsOrganizationDescriptionText"));
		 name.add(prop.getProperty("ManagementOrganizationsOrganizationAddressText"));
		 name.add(prop.getProperty("ManagementOrganizationsAccountLockedText"));
		 name.add(prop.getProperty("ManagementOrganizationsAutoUpgradeText"));
		 name.add(prop.getProperty("ManagementOrganizationsBaselineSetText"));
		 name.add(prop.getProperty("ManagementOrganizationsOptionsText"));
		 return name;
	 }
	 
	
	
	
	
	
	
}
