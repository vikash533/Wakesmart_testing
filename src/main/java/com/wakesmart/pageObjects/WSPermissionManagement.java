package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WSPermissionManagement {
public WebDriver driver;
	
	public WSPermissionManagement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	 @FindBy(xpath = "//div[@class='MuiList-root css-uppwh0-MuiList-root']//a[7]")
	 public WebElement getPermission;
	 
	 @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-h5 MuiCardHeader-title css-1y85m9j-MuiTypography-root']")
	 public WebElement getPermissionPageText;
	 
	 @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1rr20st-MuiTypography-root']")
	 public WebElement getPermissionTableHeaderText;
	 
	 @FindBy(xpath = "//button[normalize-space()='New Permission Group']")
	 public WebElement getNewPermissionGroupButton;
	 
	 @FindBy(xpath = "//h2[@class='MuiTypography-root MuiTypography-h6 MuiDialogTitle-root css-1shib43-MuiTypography-root-MuiDialogTitle-root']")
	 public WebElement getAddNewPermissionGroupPopupText;
	 
	 @FindBy(xpath = "//tr[@class='MuiTableRow-root MuiTableRow-head css-1uwa9re-MuiTableRow-root']/th")
	 public List<WebElement> getPermissionTableColumnText;
	 
	 public List<String> tableTextVerify() {
		 List<String> name = new ArrayList<>();
		 for(WebElement ele : getPermissionTableColumnText) {
			 name.add(ele.getText());
		 }
		 return name;
	 }
	 
	 public List<String> tableTextVerifyFromLocal(Properties prop) {
		 List<String> name = new ArrayList<>();
		 name.add(prop.getProperty("ManagementPermissonGroupText"));
		 name.add(prop.getProperty("ManagementPermissonRootAdminText"));
		 name.add(prop.getProperty("ManagementPermissonServerAdminText"));
		 name.add(prop.getProperty("ManagementPermissonOrgAdminText"));
		 name.add(prop.getProperty("ManagementPermissonUserAdminText"));
		 name.add(prop.getProperty("ManagementPermissonGroupAdminText"));
		 name.add(prop.getProperty("ManagementPermissonOptionsText"));
		 return name;
	 }
	 
}
