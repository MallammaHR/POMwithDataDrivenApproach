package com.crm.qa.testscases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;

public class ContactsPageTest extends TestBase
{
	HomePage homePage;
	LoginPage loginPage;
	TestUtils testUtils;
	ContactsPage contactsPage;
	String sheetName="Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		contactsPage=new ContactsPage();
		testUtils=new TestUtils();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchToFrame();
		contactsPage=homePage.clickOnConatctsLink();	
		
	}
	
	@Test(priority=1)
	public void verifyContactPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactLabel(),"Contacts label is missing on the oage");
	}
	
	@Test(priority = 2)
	public void selectMultipleContactsTest()
	{
		contactsPage.selectContactByName("mallu m");
		contactsPage.selectContactByName("test test2");
		
	}
	@Test(priority = 3)
	public void selectMultipleContactTest()
	{
		contactsPage.selectContactByName("qa test2");
	}
	
	@DataProvider()
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtils.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreatNewContactLink(String Title,String firstname,String lastname,String company)
	
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(Title,firstname,lastname,company);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		if((driver)!=null)
		{
			driver.quit();
		}
		
	}
}
