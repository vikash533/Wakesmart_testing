package com.wakesmart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wakesmart.base.BaseClass;

public class User extends BaseClass {

	public User(WebDriver driver) {
		this.driver = driver;
	}

	By userTitleHomePageMessege = By.xpath("//div[contains(text(),'About WakeSMART...')]");
	By AboutContent = By.xpath("//div[contains(text(),'In 2002, the founders of Raptor Technical were hea')]");
	
	
	
	public WebElement getUserTitleHomePageMessege() {
		return driver.findElement(userTitleHomePageMessege);
	}
	
	public WebElement getAboutContent() {
		return driver.findElement(AboutContent);
	}
	

}
