package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	//declartion
	@FindBy(xpath="//td[contains(text(),'Taanya Manish')]")
	private WebElement userName;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement contctsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	private WebElement newcontctsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	private WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	private WebElement tasksLink;

	//intializatiom
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleOfThePage()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername()
	{
		return userName.isDisplayed();
	}
	
	public ContactsPage clickOnConatctsLink()
	{
		contctsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contctsLink).build().perform();
		newcontctsLink.click();
	}
	
}
