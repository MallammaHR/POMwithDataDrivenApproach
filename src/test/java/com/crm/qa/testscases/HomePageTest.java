package com.crm.qa.testscases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;

//testcases should be sepaerated -idnependeent each other
//before each test cases-launch the browser  and login
//@test
//after test case -close the browser
public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testutils;
	ContactsPage contactPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		testutils=new TestUtils();
		loginPage=new LoginPage();
		contactPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void  verifyHomePageTitleTest()
	{
		String titleHomePage=homePage.verifyTitleOfThePage();
		Assert.assertEquals(titleHomePage,"CRMPRO", "Title of the Home Page did not match");		
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest()
	{
//		testutils.switchToFrame();
//		boolean flag=homePage.verifyCorrectUsername();
//		
//		OR
//		Assert.assertTrue(flag);
		testutils.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority = 3)
	public void clickOnContacts()
	{
		testutils.switchToFrame();
		contactPage = homePage.clickOnConatctsLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

	
}
