package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	//Declaration
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	private WebElement conatctsLabel;
	
//	@FindBy(xpath="(//input[@name='contact_id'])[2]")
//	private WebElement clickOnCheckBox;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="surname")
	private WebElement lastName;
	
	@FindBy(name="client_lookup")
	private WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	private WebElement clickOnSaveBTN;
	
	//initialization
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public boolean  verifyContactLabel()
	{
		return conatctsLabel.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String fName,String ltName,String comName)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(ltName);
		companyName.sendKeys(comName);
		clickOnSaveBTN.click();	
	}
	
	
}
