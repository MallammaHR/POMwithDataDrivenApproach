package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	//Page Factory-Object Repository
	//Declarations
	
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	private WebElement signUpBTN;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')][1]")
	private WebElement crmLogo;
	
	
	//initialization
	public LoginPage( )
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization(Actions)
	public String  ValidLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw)
	{
		userName.sendKeys(un);
		passWord.sendKeys(pw);
		//click on login btn
		loginBTN.click();
		
		return new HomePage();
	}
	
	

}
