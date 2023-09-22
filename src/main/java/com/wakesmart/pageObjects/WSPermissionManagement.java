package com.wakesmart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
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
	 private List<WebElement> getPermissionTableColumnText;
	 
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
	 
	 
	 
	 @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1lmjksc-MuiInputBase-input-MuiOutlinedInput-input'])[1]")
	 public WebElement getGroupName;
	 
	 @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1lmjksc-MuiInputBase-input-MuiOutlinedInput-input'])[2]")
	 public WebElement getGroupDescription;
	 
	 @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label Mui-disabled css-dhr2da-MuiTypography-root']")
	 private List<WebElement> getAdminRolesTextDisabled;
	 
	 @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label css-dhr2da-MuiTypography-root']")
	 private List<WebElement> getAdminRolesTextEnabled;
	 
	 
	 public List<String> adminRolesTextVerify() {
		    List<String> adminRoles = Stream.concat(
		            getAdminRolesTextDisabled.stream().map(WebElement::getText),
		            getAdminRolesTextEnabled.stream().map(WebElement::getText)
		    ).collect(Collectors.toList());
		    return adminRoles;
		}
	 
	 public List<String> adminRolesTextVerifyData(Properties prop) {
		 List<String> name = new ArrayList<>();
		 name.add(prop.getProperty("ManagementPermissonRootAdmin"));
		 name.add(prop.getProperty("ManagementPermissonServerAdmin"));
		 name.add(prop.getProperty("ManagementPermissonOrgAdmin"));
		 name.add(prop.getProperty("ManagementPermissonUserAdmin"));
		 name.add(prop.getProperty("ManagementPermissonGroupAdmin"));
		 return name;
	 }
	 
	 
	 By orgAdminCheckBox = By.xpath("(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary css-dt6pu2-MuiButtonBase-root-MuiCheckbox-root'])[1]");
	 By chooseUsersDropdown = By.xpath("//div[@id='demo-multiple-checkbox']");
	 By editGroupPermission = By.xpath("//div[@class='MuiBox-root css-1yuhvjn']/button");
	 
	 public WebElement getorgAdminCheckBox() {
		 return driver.findElement(orgAdminCheckBox);
	 }
	 
	 public WebElement getchooseUsersDropdown() {
		 return driver.findElement(chooseUsersDropdown);
	 }
	 
	 public WebElement geteditGroupPermission() {
		 return driver.findElement(editGroupPermission);
	 }
	 
	 By chooseUsersFromDropdown = By.xpath("//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-6hp17o-MuiList-root-MuiMenu-list']/li/div/span");
	 
	 
	 public boolean geteditGroupPermission(String user) {
		 boolean flag = false;
		 List<WebElement> list = driver.findElements(chooseUsersFromDropdown);
		 for(WebElement ele : list  ) {
			 if(ele.getText().equalsIgnoreCase(user)) {
				 ele.click();
				 flag = true;
				 break;
			 }
		 }
		 return flag;
	 }
	 
	 
	 
}
