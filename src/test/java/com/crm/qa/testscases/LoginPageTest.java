package com.crm.qa.testscases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		// we are calling the all properties and to lunch the browser and all
		loginpage=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitle() 
	{
		String title=loginpage.ValidLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmlogoImageTest()
	{
		boolean flag=loginpage.validCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
