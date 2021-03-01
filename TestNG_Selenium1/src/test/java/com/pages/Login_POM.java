package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_POM 
{
	WebDriver driver;
	
	public Login_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.ID,using="txtUsername")
	@CacheLookup
	WebElement username;
	
	@FindBy(how=How.ID,using="txtPassword")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.ID,using="btnLogin")
	@CacheLookup
	WebElement submit_button;
	
	
	public void login_hrm(String uid, String psdw)
	{
		username.sendKeys(uid);
		password.sendKeys(psdw);
		submit_button.click();
	}
}
